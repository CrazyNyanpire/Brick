package acetecsemi.com.brick.facade.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.PinAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PinInOutStorageLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketOptionLogAssembler;
import acetecsemi.com.brick.facade.PinFacade;
import acetecsemi.com.brick.application.PinApplication;
import acetecsemi.com.brick.application.PinInOutStorageLogApplication;
import acetecsemi.com.brick.application.SocketApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PinFacadeImpl implements PinFacade {

	@Inject
	private PinApplication application;

	@Inject
	private PinInOutStorageLogApplication pinInOutStorageLogApplication;

	@Inject
	private SocketApplication socketApplication;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public PinDTO getPin(Long id) {
		return PinAssembler.toDTO(application.getPin(id));
	}

	public Boolean creatPin(PinDTO pinDTO) {
		Pin pin = PinAssembler.toEntity(pinDTO);
		pin.setBalanceQty(pin.getTotalQty());
		pin.setUseQty(0);
		pin.setInDate(pinDTO.getInDate());
		application.creatPin(pin);
		PinInOutStorageLog pinInOutStorageLog = PinInOutStorageLogAssembler
				.toEntity(pinDTO);
		pinInOutStorageLog.setPin(pin);
		pinInOutStorageLog.setInitQty(pinDTO.getBalanceQty());
		pinInOutStorageLog.setQty(0);
		pinInOutStorageLog.setType("INIT");
		this.pinInOutStorageLogApplication
				.creatPinInOutStorageLog(pinInOutStorageLog);
		return true;
	}

	public Boolean updatePin(PinDTO pinDTO) {
		Pin pin = application.getPin(pinDTO.getId());
		application.updatePin(PinAssembler.toEntity(pin,pinDTO));
		return true;
	}

	public Boolean removePin(Long id) {
		application.removePin(application.getPin(id));
		return true;
	}

	public Boolean removePins(Long[] ids) {
		Set<Pin> pins = new HashSet<Pin>();
		for (Long id : ids) {
			pins.add(application.getPin(id));
		}
		application.removePins(pins);
		return true;
	}

	public List<PinDTO> findAllPin() {
		return PinAssembler.toDTOs(application.findAllPin());
	}

	public Page<PinDTO> pageQueryPin(PinDTO queryVo, int currentPage,
			int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _pin from Pin _pin  where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _pin.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getInDate() != null) {
			jpql.append(" and _pin.inDate between ? and ? ");
			conditionVals.add(queryVo.getInDate());
			conditionVals.add(queryVo.getInDateEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _pin.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _pin.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _pin.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getModel() != null && !"".equals(queryVo.getModel())) {
			jpql.append(" and _pin.model like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getModel()));
		}
		if (queryVo.getTheoryTestUph() != null
				&& !"".equals(queryVo.getTheoryTestUph())) {
			jpql.append(" and _pin.theoryTestUph like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTheoryTestUph()));
		}
		Page<Pin> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<PinDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, PinAssembler.toDTOs(pages.getData()));
	}

	@Override
	public String inStorage(PinDTO pinDTO) {
		return this.storage(pinDTO, "IN");
	}

	@Override
	public String outStorage(PinDTO pinDTO) {
		return this.storage(pinDTO, "OUT");
	}

	public String storage(PinDTO pinDTO, String type) {
		Pin pin = Pin.get(Pin.class, pinDTO.getId());
		if (pinDTO.getQty() != null) {
			PinInOutStorageLog pinInOutStorageLog = PinInOutStorageLogAssembler
					.toEntity(pinDTO);
			pinInOutStorageLog.setId(null);
			pinInOutStorageLog.setInitQty(pin.getBalanceQty());
			pin.setBalanceQty(pin.getBalanceQty() - pinDTO.getQty());// 剩余数量
			pin.setUseQty(pin.getUseQty() + pinDTO.getQty());// 使用数量
			application.updatePin(pin);
			pinInOutStorageLog.setBalanceQty(pin.getBalanceQty());
			pinInOutStorageLog.setPin(pin);
			if (pinDTO.getSocketId() != null) {
				pinInOutStorageLog.setSocket(socketApplication.getSocket(pinDTO
						.getSocketId()));
			}
			pinInOutStorageLog.setType(type);
			pinInOutStorageLogApplication
					.creatPinInOutStorageLog(pinInOutStorageLog);
			return null;
		}
		return "登记Pin失败！";
	}
}

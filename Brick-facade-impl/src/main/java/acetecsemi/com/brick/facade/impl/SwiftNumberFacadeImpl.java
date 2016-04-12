package acetecsemi.com.brick.facade.impl;

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
import acetecsemi.com.brick.facade.impl.assembler.SwiftNumberAssembler;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.utils.SerialNumberUtils;
import acetecsemi.com.brick.facade.SwiftNumberFacade;
import acetecsemi.com.brick.application.SwiftNumberApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class SwiftNumberFacadeImpl implements SwiftNumberFacade {

	@Inject
	private SwiftNumberApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public SwiftNumberDTO getSwiftNumber(Long id) {
		return SwiftNumberAssembler.toDTO(application
				.getSwiftNumber(id));
	}

	public Boolean creatSwiftNumber(SwiftNumberDTO swiftNumberDTO) {
		application.creatSwiftNumber(SwiftNumberAssembler
				.toEntity(swiftNumberDTO));
		return true;
	}

	public Boolean updateSwiftNumber(SwiftNumberDTO swiftNumberDTO) {
		application.updateSwiftNumber(SwiftNumberAssembler
				.toEntity(swiftNumberDTO));
		return true;
	}

	public Boolean removeSwiftNumber(Long id) {
		application.removeSwiftNumber(application.getSwiftNumber(id));
		return true;
	}

	public Boolean removeSwiftNumbers(Long[] ids) {
		Set<SwiftNumber> swiftNumbers = new HashSet<SwiftNumber>();
		for (Long id : ids) {
			swiftNumbers.add(application.getSwiftNumber(id));
		}
		application.removeSwiftNumbers(swiftNumbers);
		return true;
	}

	public List<SwiftNumberDTO> findAllSwiftNumber() {
		return SwiftNumberAssembler.toDTOs(application.findAllSwiftNumber());
	}

	public Page<SwiftNumberDTO> pageQuerySwiftNumber(SwiftNumberDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _swiftNumber from SwiftNumber _swiftNumber   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _swiftNumber.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _swiftNumber.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _swiftNumber.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _swiftNumber.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
			jpql.append(" and _swiftNumber.type like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getType()));
		}
		if (queryVo.getStartTitle() != null
				&& !"".equals(queryVo.getStartTitle())) {
			jpql.append(" and _swiftNumber.startTitle like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStartTitle()));
		}
		if (queryVo.getDate() != null && !"".equals(queryVo.getDate())) {
			jpql.append(" and _swiftNumber.date like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDate()));
		}
		if (queryVo.getSn() != null && !"".equals(queryVo.getSn())) {
			jpql.append(" and _swiftNumber.sn like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSn()));
		}
		if (queryVo.getTotalSn() != null && !"".equals(queryVo.getTotalSn())) {
			jpql.append(" and _swiftNumber.totalSn like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTotalSn()));
		}
		if (queryVo.getNowSwiftNumber() != null
				&& !"".equals(queryVo.getNowSwiftNumber())) {
			jpql.append(" and _swiftNumber.nowSwiftNumber like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowSwiftNumber()));
		}
		Page<SwiftNumber> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<SwiftNumberDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				SwiftNumberAssembler.toDTOs(pages.getData()));
	}

	@Override
	public SwiftNumberDTO getNextSwiftNumberBorrowMachine() {
		SwiftNumberDTO swiftNumberDTO = new SwiftNumberDTO();
		swiftNumberDTO.setType("BorrowMachine");
		List<SwiftNumberDTO> list = this.querySwiftNumber(swiftNumberDTO);
		String nowDate = MyDateUtils.getTodayTime("yyyyMMdd");
		if (list != null && list.size() > 0) {
			swiftNumberDTO = list.get(0);
			if (swiftNumberDTO.getDate().equals(nowDate)) {
				swiftNumberDTO.setSn(SerialNumberUtils.getNumberStrNext(3,
						Integer.valueOf(swiftNumberDTO.getSn())));
			} else {
				swiftNumberDTO.setSn(SerialNumberUtils.getNumberStr(3, 1));
			}
			swiftNumberDTO.setDate(nowDate);
			swiftNumberDTO.setNowSwiftNumber(this
					.createBorrowMachineSN(swiftNumberDTO));
			swiftNumberDTO.setTotalSn(swiftNumberDTO.getTotalSn() + 1);
			this.updateSwiftNumber(swiftNumberDTO);
		} else {
			swiftNumberDTO.setStartTitle("ZJ");
			swiftNumberDTO.setDate(nowDate);
			swiftNumberDTO.setTotalSn(1);
			swiftNumberDTO.setSn("001");
			swiftNumberDTO.setNowSwiftNumber(this
					.createBorrowMachineSN(swiftNumberDTO));
			this.creatSwiftNumber(swiftNumberDTO);
		}

		return swiftNumberDTO;
	}

	private String createBorrowMachineSN(SwiftNumberDTO swiftNumberDTO) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(swiftNumberDTO.getStartTitle());
		stringBuffer.append(swiftNumberDTO.getDate());
		stringBuffer.append(swiftNumberDTO.getSn());
		return stringBuffer.toString();
	}

	public List<SwiftNumberDTO> querySwiftNumber(SwiftNumberDTO queryVo) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _swiftNumber from SwiftNumber _swiftNumber   where 1=1 ");
		if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
			jpql.append(" and _swiftNumber.type like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getType()));
		}
		if (queryVo.getStartTitle() != null
				&& !"".equals(queryVo.getStartTitle())) {
			jpql.append(" and _swiftNumber.startTitle like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStartTitle()));
		}
		if (queryVo.getDate() != null && !"".equals(queryVo.getDate())) {
			jpql.append(" and _swiftNumber.date like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDate()));
		}
		if (queryVo.getSn() != null && !"".equals(queryVo.getSn())) {
			jpql.append(" and _swiftNumber.sn like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSn()));
		}
		if (queryVo.getTotalSn() != null && !"".equals(queryVo.getTotalSn())) {
			jpql.append(" and _swiftNumber.totalSn like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTotalSn()));
		}
		if (queryVo.getNowSwiftNumber() != null
				&& !"".equals(queryVo.getNowSwiftNumber())) {
			jpql.append(" and _swiftNumber.nowSwiftNumber like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowSwiftNumber()));
		}
		@SuppressWarnings("unchecked")
		List<SwiftNumber> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return SwiftNumberAssembler.toDTOs(list);
	}
}

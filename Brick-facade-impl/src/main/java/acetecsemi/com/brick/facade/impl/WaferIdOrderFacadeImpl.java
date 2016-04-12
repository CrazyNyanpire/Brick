package acetecsemi.com.brick.facade.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.WaferIdOrderAssembler;
import acetecsemi.com.brick.facade.WaferIdOrderFacade;
import acetecsemi.com.brick.application.WaferIdOrderApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class WaferIdOrderFacadeImpl implements WaferIdOrderFacade {

	@Inject
	private WaferIdOrderApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public InvokeResult getWaferIdOrder(Long id) {
		return InvokeResult.success(WaferIdOrderAssembler.toDTO(application
				.getWaferIdOrder(id)));
	}

	public InvokeResult creatWaferIdOrder(WaferIdOrderDTO waferIdOrderDTO) {
		application.creatWaferIdOrder(WaferIdOrderAssembler
				.toEntity(waferIdOrderDTO));
		return InvokeResult.success();
	}

	public InvokeResult updateWaferIdOrder(WaferIdOrderDTO waferIdOrderDTO) {
		application.updateWaferIdOrder(WaferIdOrderAssembler
				.toEntity(waferIdOrderDTO));
		return InvokeResult.success();
	}

	public InvokeResult removeWaferIdOrder(Long id) {
		application.removeWaferIdOrder(application.getWaferIdOrder(id));
		return InvokeResult.success();
	}

	public InvokeResult removeWaferIdOrders(Long[] ids) {
		Set<WaferIdOrder> waferIdOrders = new HashSet<WaferIdOrder>();
		for (Long id : ids) {
			waferIdOrders.add(application.getWaferIdOrder(id));
		}
		application.removeWaferIdOrders(waferIdOrders);
		return InvokeResult.success();
	}

	public List<WaferIdOrderDTO> findAllWaferIdOrder() {
		return WaferIdOrderAssembler.toDTOs(application.findAllWaferIdOrder());
	}

	public Page<WaferIdOrderDTO> pageQueryWaferIdOrder(WaferIdOrderDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _waferIdOrder from WaferIdOrder _waferIdOrder   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _waferIdOrder.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _waferIdOrder.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _waferIdOrder.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _waferIdOrder.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getWaferIndex() != null && !"".equals(queryVo.getWaferIndex())) {
			jpql.append(" and _waferIdOrder.order like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getWaferIndex()));
		}
		if (queryVo.getAcetecLot() != null
				&& !"".equals(queryVo.getAcetecLot())) {
			jpql.append(" and _waferIdOrder.acetecLot like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getAcetecLot()));
		}
		if (queryVo.getWaferId() != null && !"".equals(queryVo.getWaferId())) {
			jpql.append(" and _waferIdOrder.waferId like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getWaferId()));
		}
		Page<WaferIdOrder> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<WaferIdOrderDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				WaferIdOrderAssembler.toDTOs(pages.getData()));
	}

	public List<WaferIdOrderDTO> queryWaferIdOrder(WaferIdOrderDTO queryVo) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _waferIdOrder from WaferIdOrder _waferIdOrder   where 1=1 ");
		if (queryVo.getWaferIndex() != null && !"".equals(queryVo.getWaferIndex())) {
			jpql.append(" and _waferIdOrder.order like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getWaferIndex()));
		}
		if (queryVo.getAcetecLot() != null
				&& !"".equals(queryVo.getAcetecLot())) {
			jpql.append(" and _waferIdOrder.acetecLot = ?");
			conditionVals.add(queryVo.getAcetecLot());
		}
		if (queryVo.getWaferId() != null && !"".equals(queryVo.getWaferId())) {
			jpql.append(" and _waferIdOrder.waferId like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getWaferId()));
		}
		List<WaferIdOrder> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return WaferIdOrderAssembler.toDTOs(pages);
	}

	public Map<String, Integer> getWaferIdOrderMap(List<WaferIdOrderDTO> waferIdOrderDTOList) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (WaferIdOrderDTO wioDTO : waferIdOrderDTOList) {
			map.put(wioDTO.getWaferId(), wioDTO.getWaferIndex());
		}
		return map;
	}
}

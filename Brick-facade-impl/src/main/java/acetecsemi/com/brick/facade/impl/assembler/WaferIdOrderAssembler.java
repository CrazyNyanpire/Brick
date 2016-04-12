package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class WaferIdOrderAssembler {

	public static WaferIdOrderDTO toDTO(WaferIdOrder waferIdOrder) {
		if (waferIdOrder == null) {
			return null;
		}
		WaferIdOrderDTO result = new WaferIdOrderDTO();
		result.setId(waferIdOrder.getId());
		result.setVersion(waferIdOrder.getVersion());
		result.setCreateTimestamp(waferIdOrder.getCreateTimestamp());
		result.setLastModifyTimestamp(waferIdOrder.getLastModifyTimestamp());
		result.setCreateEmployNo(waferIdOrder.getCreateEmployNo());
		result.setLastModifyEmployNo(waferIdOrder.getLastModifyEmployNo());
		result.setLogic(waferIdOrder.getLogic());
		result.setWaferIndex(waferIdOrder.getWaferIndex());
		result.setAcetecLot(waferIdOrder.getAcetecLot());
		result.setWaferId(waferIdOrder.getWaferId());
		return result;
	}

	public static List<WaferIdOrderDTO> toDTOs(
			Collection<WaferIdOrder> waferIdOrders) {
		if (waferIdOrders == null) {
			return null;
		}
		List<WaferIdOrderDTO> results = new ArrayList<WaferIdOrderDTO>();
		for (WaferIdOrder each : waferIdOrders) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static WaferIdOrder toEntity(WaferIdOrderDTO waferIdOrderDTO) {
		if (waferIdOrderDTO == null) {
			return null;
		}
		WaferIdOrder result = new WaferIdOrder();
		result.setId(waferIdOrderDTO.getId());
		result.setVersion(waferIdOrderDTO.getVersion());
		result.setCreateTimestamp(waferIdOrderDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(waferIdOrderDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(waferIdOrderDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(waferIdOrderDTO.getLastModifyEmployNo());
		result.setLogic(waferIdOrderDTO.getLogic());
		result.setWaferIndex(waferIdOrderDTO.getWaferIndex());
		result.setAcetecLot(waferIdOrderDTO.getAcetecLot());
		result.setWaferId(waferIdOrderDTO.getWaferId());
		return result;
	}

	public static List<WaferIdOrder> toEntities(
			Collection<WaferIdOrderDTO> waferIdOrderDTOs) {
		if (waferIdOrderDTOs == null) {
			return null;
		}

		List<WaferIdOrder> results = new ArrayList<WaferIdOrder>();
		for (WaferIdOrderDTO each : waferIdOrderDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

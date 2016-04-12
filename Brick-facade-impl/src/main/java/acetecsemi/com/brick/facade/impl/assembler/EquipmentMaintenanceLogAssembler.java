package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class EquipmentMaintenanceLogAssembler {

	public static EquipmentMaintenanceLogDTO toDTO(
			EquipmentMaintenanceLog equipmentMaintenanceLog) {
		if (equipmentMaintenanceLog == null) {
			return null;
		}
		EquipmentMaintenanceLogDTO result = new EquipmentMaintenanceLogDTO();
		result.setId(equipmentMaintenanceLog.getId());
		result.setVersion(equipmentMaintenanceLog.getVersion());
		result.setCreateTimestamp(equipmentMaintenanceLog.getCreateTimestamp());
		result.setLastModifyTimestamp(equipmentMaintenanceLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentMaintenanceLog.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentMaintenanceLog
				.getLastModifyEmployNo());
		result.setPlanStartDate(equipmentMaintenanceLog.getPlanStartDate());
		result.setRealStartDate(equipmentMaintenanceLog.getRealStartDate());
		result.setRealEndDate(equipmentMaintenanceLog.getRealEndDate());
		result.setNowMaintenancePlanDate(equipmentMaintenanceLog
				.getNowMaintenancePlanDate());
		result.setNextMaintenancePlanDate(equipmentMaintenanceLog
				.getNextMaintenancePlanDate());
		result.setRemark(equipmentMaintenanceLog.getRemark());
		result.setPmType(equipmentMaintenanceLog.getPmType());
		result.setResponsible(equipmentMaintenanceLog.getEquipment().getResponsible());
		// result.setEquipment (equipmentMaintenanceLog.getEquipment());
		return result;
	}

	public static List<EquipmentMaintenanceLogDTO> toDTOs(
			Collection<EquipmentMaintenanceLog> equipmentMaintenanceLogs) {
		if (equipmentMaintenanceLogs == null) {
			return null;
		}
		List<EquipmentMaintenanceLogDTO> results = new ArrayList<EquipmentMaintenanceLogDTO>();
		for (EquipmentMaintenanceLog each : equipmentMaintenanceLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static EquipmentMaintenanceLog toEntity(
			EquipmentMaintenanceLogDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		EquipmentMaintenanceLog result = new EquipmentMaintenanceLog();
		result.setId(equipmentDTO.getId());
		result.setVersion(equipmentDTO.getVersion());
		result.setCreateTimestamp(equipmentDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(equipmentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		result.setPlanStartDate(equipmentDTO.getPlanStartDate());
		result.setRealStartDate(equipmentDTO.getRealStartDate());
		result.setRealEndDate(equipmentDTO.getRealEndDate());
		result.setNowMaintenancePlanDate(equipmentDTO
				.getNowMaintenancePlanDate());
		result.setNextMaintenancePlanDate(equipmentDTO
				.getNextMaintenancePlanDate());
		result.setRemark(equipmentDTO.getRemark());
		result.setPmType(equipmentDTO.getPmType());
		// result.setEquipment (equipmentDTO.getEquipment());
		return result;
	}

	public static List<EquipmentMaintenanceLog> toEntities(
			Collection<EquipmentMaintenanceLogDTO> equipmentDTOs) {
		if (equipmentDTOs == null) {
			return null;
		}

		List<EquipmentMaintenanceLog> results = new ArrayList<EquipmentMaintenanceLog>();
		for (EquipmentMaintenanceLogDTO each : equipmentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

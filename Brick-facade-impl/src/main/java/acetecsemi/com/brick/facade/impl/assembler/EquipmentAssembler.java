package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class EquipmentAssembler {

	public static EquipmentDTO toDTO(Equipment equipment) {
		if (equipment == null) {
			return null;
		}
		EquipmentDTO result = new EquipmentDTO();
		result.setId(equipment.getId());
		result.setVersion(equipment.getVersion());
		result.setCreateTimestamp(equipment.getCreateTimestamp());
		result.setLastModifyTimestamp(equipment.getLastModifyTimestamp());
		result.setCreateEmployNo(equipment.getCreateEmployNo());
		result.setLastModifyEmployNo(equipment.getLastModifyEmployNo());
		if (equipment.getCategory() != null) {
			result.setCategoryId(equipment.getCategory().getId());
			result.setCategory(equipment.getCategory().getCategoryName());
		}
		result.setEquipmentNo(equipment.getEquipmentNo());
		result.setEquipmentName(equipment.getEquipmentName());
		if (equipment.getEquipmentCategory() != null) {
			result.setEquipmentCategoryId(equipment.getEquipmentCategory()
					.getId());
			result.setEquipmentCategory(equipment.getEquipmentCategory()
					.getCategoryName());
		}
		result.setResponsible(equipment.getResponsible());
		result.setAgent(equipment.getAgent());
		result.setMaintenanceStartDate(equipment.getMaintenanceStartDate());
		result.setRepairCycle(equipment.getRepairCycle());
		result.setCalibrationCycle(equipment.getCalibrationCycle());
		if (equipment.getEquipmentLocation() != null) {
			result.setEquipmentLocationId(equipment.getEquipmentLocation()
					.getId());
			result.setEquipmentLocation(equipment.getEquipmentLocation()
					.getCategoryName());
		}
		result.setCheckInTime(equipment.getCheckInTime());
		result.setAcceptanceList(equipment.getAcceptanceList());
		result.setStatus(equipment.getStatus());
		result.setSubStatus(equipment.getSubStatus());
		result.setComposability(equipment.getComposability());
		// result.setPlatform (equipment.getPlatform());
		result.setRepairCycleWeek(equipment.getRepairCycleWeek());
		result.setRepairCycleSeason(equipment.getRepairCycleSeason());
		result.setRepairCycleMonth(equipment.getRepairCycleMonth());
		result.setRepairCycleYear(equipment.getRepairCycleYear());
		result.setNextMaintenanceDate(equipment.getNextMaintenanceDate());
		result.setCategoryImageUrl(equipment.getCategory().getUrl());
		result.setSn(equipment.getSn());
		result.setNowMaintenancePlanDate(equipment.getNowMaintenancePlanDate());
		result.setNextMaintenancePlanDate(equipment
				.getNextMaintenancePlanDate());
		result.setNowLot(equipment.getNowLot());
		result.setProductModel(equipment.getProductModel());
		result.setIp(equipment.getIp() == null ? "" : equipment.getIp());
		result.setIsAuto(equipment.getIsAuto());
		return result;
	}

	public static List<EquipmentDTO> toDTOs(Collection<Equipment> equipments) {
		if (equipments == null) {
			return null;
		}
		List<EquipmentDTO> results = new ArrayList<EquipmentDTO>();
		for (Equipment each : equipments) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static Equipment toEntity(EquipmentDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		Equipment result = new Equipment();
		result.setId(equipmentDTO.getId());
		result.setVersion(equipmentDTO.getVersion());
		return EquipmentAssembler.toEntity(result, equipmentDTO);
	}

	public static Equipment toEntity(Equipment result, EquipmentDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		// Equipment result = new Equipment();
		// result.setId(equipmentDTO.getId());
		// result.setVersion(equipmentDTO.getVersion());
		// result.setCreateTimestamp(equipmentDTO.getCreateTimestamp());
		// result.setLastModifyTimestamp(equipmentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		if (equipmentDTO.getCategoryId() != null) {
			Category category = new Category();
			category.setId(equipmentDTO.getCategoryId());
			result.setCategory(category);
		}
		result.setEquipmentNo(equipmentDTO.getEquipmentNo());
		result.setEquipmentName(equipmentDTO.getEquipmentName());
		if (equipmentDTO.getEquipmentCategoryId() != null) {
			Category category = new Category();
			category.setId(equipmentDTO.getEquipmentCategoryId());
			result.setEquipmentCategory(category);
		}
		result.setResponsible(equipmentDTO.getResponsible());
		result.setAgent(equipmentDTO.getAgent());
		result.setMaintenanceStartDate(equipmentDTO.getMaintenanceStartDate());
		result.setRepairCycle(equipmentDTO.getRepairCycle());
		result.setCalibrationCycle(equipmentDTO.getCalibrationCycle());
		if (equipmentDTO.getEquipmentLocationId() != null) {
			Category category = new Category();
			category.setId(equipmentDTO.getEquipmentLocationId());
			result.setEquipmentLocation(category);
		}
		result.setCheckInTime(equipmentDTO.getCheckInTime());
		result.setAcceptanceList(equipmentDTO.getAcceptanceList());
		if (equipmentDTO.getStatus() != null
				&& !"".equals(equipmentDTO.getStatus())) {
			result.setStatus(equipmentDTO.getStatus());
			result.setSubStatus(equipmentDTO.getSubStatus());
		}
		result.setComposability(equipmentDTO.getComposability());
		result.setRepairCycleWeek(equipmentDTO.getRepairCycleWeek());
		result.setRepairCycleMonth(equipmentDTO.getRepairCycleMonth());
		result.setRepairCycleSeason(equipmentDTO.getRepairCycleSeason());
		result.setRepairCycleYear(equipmentDTO.getRepairCycleYear());
		result.setSn(equipmentDTO.getSn());
		// result.setNextMaintenanceDate(equipmentDTO.getIsWeek());
		// result.setPlatform (equipmentDTO.getPlatform());
		result.setNowLot(equipmentDTO.getNowLot());
		result.setProductModel(equipmentDTO.getProductModel());
		result.setIp(equipmentDTO.getIp() == null ? "" : equipmentDTO.getIp());
		if (equipmentDTO.getIsAuto() != null
				|| "".equals(equipmentDTO.getIsAuto()))
			result.setIsAuto(equipmentDTO.getIsAuto());
		return result;
	}

	public static List<Equipment> toEntities(
			Collection<EquipmentDTO> equipmentDTOs) {
		if (equipmentDTOs == null) {
			return null;
		}

		List<Equipment> results = new ArrayList<Equipment>();
		for (EquipmentDTO each : equipmentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class OvenEquipmentOptionLogAssembler {

	public static OvenEquipmentOptionLogDTO toDTO(
			OvenEquipmentOptionLog ovenEquipmentOptionLog) {
		if (ovenEquipmentOptionLog == null) {
			return null;
		}
		OvenEquipmentOptionLogDTO result = new OvenEquipmentOptionLogDTO();
		result.setId(ovenEquipmentOptionLog.getId());
		result.setVersion(ovenEquipmentOptionLog.getVersion());
		result.setCreateTimestamp(ovenEquipmentOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(ovenEquipmentOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(ovenEquipmentOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(ovenEquipmentOptionLog
				.getLastModifyEmployNo());
		result.setCategory(ovenEquipmentOptionLog.getCategory());
		// result.setEquipment (ovenEquipmentOptionLog.getEquipment());
		result.setStatus(ovenEquipmentOptionLog.getStatus());
		result.setSubStatus(ovenEquipmentOptionLog.getSubStatus());
		result.setOptUser(ovenEquipmentOptionLog.getOptUser());
		result.setOptDate(ovenEquipmentOptionLog.getOptDate());
		result.setNowLot(ovenEquipmentOptionLog.getNowLot());
		result.setNowStation(ovenEquipmentOptionLog.getNowStation());
		result.setProductModel(ovenEquipmentOptionLog.getProductModel());
		result.setStartTime(ovenEquipmentOptionLog.getStartTime());
		result.setEndTime(ovenEquipmentOptionLog.getEndTime());
		result.setDuration(ovenEquipmentOptionLog.getDuration());
		result.setEndOptUser(ovenEquipmentOptionLog.getEndOptUser());
		result.setStandardWorkHours(ovenEquipmentOptionLog
				.getStandardWorkHours());
		result.setGrossDie(ovenEquipmentOptionLog.getGrossDie());
		result.setTheoryTime(ovenEquipmentOptionLog.getTheoryTime());
		result.setInkType(ovenEquipmentOptionLog.getInkType());
		result.setTouchTimes(ovenEquipmentOptionLog.getTouchTimes());
		result.setTeam(ovenEquipmentOptionLog.getTeam());
		result.setIsShift(ovenEquipmentOptionLog.getIsShift());
		result.setOptRemark(ovenEquipmentOptionLog.getOptRemark());
		result.setProductNo(ovenEquipmentOptionLog.getProductNo());
		return result;
	}

	public static List<OvenEquipmentOptionLogDTO> toDTOs(
			Collection<OvenEquipmentOptionLog> ovenEquipmentOptionLogs) {
		if (ovenEquipmentOptionLogs == null) {
			return null;
		}
		List<OvenEquipmentOptionLogDTO> results = new ArrayList<OvenEquipmentOptionLogDTO>();
		for (OvenEquipmentOptionLog each : ovenEquipmentOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static OvenEquipmentOptionLog toEntity(
			OvenEquipmentOptionLogDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		OvenEquipmentOptionLog result = new OvenEquipmentOptionLog();
		result.setId(equipmentDTO.getId());
		result.setVersion(equipmentDTO.getVersion());
		//result.setCreateTimestamp(equipmentDTO.getCreateTimestamp());
		//result.setLastModifyTimestamp(equipmentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		result.setCategory(equipmentDTO.getCategory());
		// result.setEquipment (equipmentDTO.getEquipment());
		result.setStatus(equipmentDTO.getStatus());
		result.setSubStatus(equipmentDTO.getSubStatus());
		result.setOptUser(equipmentDTO.getOptUser());
		result.setOptDate(equipmentDTO.getOptDate());
		result.setNowLot(equipmentDTO.getNowLot());
		result.setNowStation(equipmentDTO.getNowStation());
		result.setProductModel(equipmentDTO.getProductModel());
		result.setStartTime(equipmentDTO.getStartTime());
		result.setEndTime(equipmentDTO.getEndTime());
		result.setDuration(equipmentDTO.getDuration());
		result.setEndOptUser(equipmentDTO.getEndOptUser());
		result.setStandardWorkHours(equipmentDTO.getStandardWorkHours());
		result.setGrossDie(equipmentDTO.getGrossDie());
		result.setTheoryTime(equipmentDTO.getTheoryTime());
		result.setInkType(equipmentDTO.getInkType());
		result.setTouchTimes(equipmentDTO.getTouchTimes());
		result.setTeam(equipmentDTO.getTeam());
		result.setIsShift(equipmentDTO.getIsShift());
		result.setOptRemark(equipmentDTO.getOptRemark());
		result.setProductNo(equipmentDTO.getProductNo());
		return result;
	}

	public static OvenEquipmentOptionLog toEntity(
			EquipmentDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		OvenEquipmentOptionLog result = new OvenEquipmentOptionLog();
		result.setId(equipmentDTO.getId());
		result.setVersion(equipmentDTO.getVersion());
		result.setCreateTimestamp(equipmentDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(equipmentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		result.setCategory(equipmentDTO.getCategory());
		// result.setEquipment (equipmentDTO.getEquipment());
		result.setStatus(equipmentDTO.getStatus());
		result.setSubStatus(equipmentDTO.getSubStatus());
		result.setOptUser(equipmentDTO.getOptUser());
		result.setOptDate(equipmentDTO.getOptDate());
		result.setNowLot(equipmentDTO.getNowLot());
		result.setNowStation(equipmentDTO.getNowStation());
		result.setProductModel(equipmentDTO.getProductModel());
		result.setStartTime(equipmentDTO.getStartTime());
		result.setEndTime(equipmentDTO.getEndTime());
		result.setDuration(equipmentDTO.getDuration());
		result.setEndOptUser(equipmentDTO.getEndOptUser());
		result.setStandardWorkHours(equipmentDTO.getStandardWorkHours());
		result.setGrossDie(equipmentDTO.getGrossDie());
		result.setTheoryTime(equipmentDTO.getTheoryTime());
		result.setInkType(equipmentDTO.getInkType());
		result.setTouchTimes(equipmentDTO.getTouchTimes());
		result.setTeam(equipmentDTO.getTeam());
		result.setIsShift(equipmentDTO.getIsShift());
		result.setOptRemark(equipmentDTO.getOptRemark());
		result.setProductNo(equipmentDTO.getProductNo());
		return result;
	}

	
	public static List<OvenEquipmentOptionLog> toEntities(
			Collection<OvenEquipmentOptionLogDTO> equipmentDTOs) {
		if (equipmentDTOs == null) {
			return null;
		}

		List<OvenEquipmentOptionLog> results = new ArrayList<OvenEquipmentOptionLog>();
		for (OvenEquipmentOptionLogDTO each : equipmentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

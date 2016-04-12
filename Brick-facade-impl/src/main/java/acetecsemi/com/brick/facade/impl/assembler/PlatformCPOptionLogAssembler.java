package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PlatformCPOptionLogAssembler {

	public static PlatformCPOptionLogDTO toDTO(
			PlatformCPOptionLog platformCPOptionLog) {
		if (platformCPOptionLog == null) {
			return null;
		}
		PlatformCPOptionLogDTO result = new PlatformCPOptionLogDTO();
		result.setId(platformCPOptionLog.getId());
		result.setVersion(platformCPOptionLog.getVersion());
		result.setCreateTimestamp(platformCPOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(platformCPOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(platformCPOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(platformCPOptionLog
				.getLastModifyEmployNo());
		result.setCategory(platformCPOptionLog.getCategory());
		// result.setEquipment (platformCPOptionLog.getEquipment());
		result.setStatus(platformCPOptionLog.getStatus());
		result.setSubStatus(platformCPOptionLog.getSubStatus());
		result.setOptUser(platformCPOptionLog.getOptUser());
		result.setOptDate(platformCPOptionLog.getOptDate());
		result.setNowLot(platformCPOptionLog.getNowLot());
		result.setNowStation(platformCPOptionLog.getNowStation());
		result.setProductModel(platformCPOptionLog.getProductModel());
		result.setStartTime(platformCPOptionLog.getStartTime());
		result.setEndTime(platformCPOptionLog.getEndTime());
		result.setDuration(platformCPOptionLog.getDuration());
		result.setEndOptUser(platformCPOptionLog.getEndOptUser());
		result.setStandardWorkHours(platformCPOptionLog.getStandardWorkHours());
		result.setGrossDie(platformCPOptionLog.getGrossDie());
		result.setTheoryTime(platformCPOptionLog.getTheoryTime());
		result.setInkType(platformCPOptionLog.getInkType());
		result.setTouchTimes(platformCPOptionLog.getTouchTimes());
		result.setTeam(platformCPOptionLog.getTeam());
		result.setIsShift(platformCPOptionLog.getIsShift());
		result.setOptRemark(platformCPOptionLog.getOptRemark());
		result.setCompletedChip(platformCPOptionLog.getCompletedChip());
		result.setCompletedChipDescription(platformCPOptionLog
				.getCompletedChipDescription());
		result.setChipSelection(platformCPOptionLog.getChipSelection());
		result.setChipSelectionRemark(platformCPOptionLog
				.getChipSelectionRemark());
		result.setPcNo(platformCPOptionLog.getPcNo());
		// result.setPlatform (platformCPOptionLog.getPlatform());
		return result;
	}

	public static List<PlatformCPOptionLogDTO> toDTOs(
			Collection<PlatformCPOptionLog> platformCPOptionLogs) {
		if (platformCPOptionLogs == null) {
			return null;
		}
		List<PlatformCPOptionLogDTO> results = new ArrayList<PlatformCPOptionLogDTO>();
		for (PlatformCPOptionLog each : platformCPOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static PlatformCPOptionLog toEntity(
			PlatformCPOptionLogDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		PlatformCPOptionLog result = new PlatformCPOptionLog();
		result.setId(platformDTO.getId());
		result.setVersion(platformDTO.getVersion());
		result.setCreateTimestamp(platformDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(platformDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(platformDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		result.setCategory(platformDTO.getCategory());
		// result.setEquipment (platformDTO.getEquipment());
		result.setStatus(platformDTO.getStatus());
		result.setSubStatus(platformDTO.getSubStatus());
		result.setOptUser(platformDTO.getOptUser());
		result.setOptDate(platformDTO.getOptDate());
		result.setNowLot(platformDTO.getNowLot());
		result.setNowStation(platformDTO.getNowStation());
		result.setProductModel(platformDTO.getProductModel());
		result.setStartTime(platformDTO.getStartTime());
		result.setEndTime(platformDTO.getEndTime());
		result.setDuration(platformDTO.getDuration());
		result.setEndOptUser(platformDTO.getEndOptUser());
		result.setStandardWorkHours(platformDTO.getStandardWorkHours());
		result.setGrossDie(platformDTO.getGrossDie());
		result.setTheoryTime(platformDTO.getTheoryTime());
		result.setInkType(platformDTO.getInkType());
		result.setTouchTimes(platformDTO.getTouchTimes());
		result.setTeam(platformDTO.getTeam());
		result.setIsShift(platformDTO.getIsShift());
		result.setOptRemark(platformDTO.getOptRemark());
		result.setCompletedChip(platformDTO.getCompletedChip());
		result.setCompletedChipDescription(platformDTO
				.getCompletedChipDescription());
		result.setChipSelection(platformDTO.getChipSelection());
		result.setChipSelectionRemark(platformDTO.getChipSelectionRemark());
		result.setPcNo(platformDTO.getPcNo());
		// result.setPlatform (platformDTO.getPlatform());
		return result;
	}

	public static PlatformCPOptionLog toEntity(PlatformDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		PlatformCPOptionLog result = new PlatformCPOptionLog();
		result.setVersion(platformDTO.getVersion());
		//result.setCreateTimestamp(platformDTO.getCreateTimestamp());
		//result.setLastModifyTimestamp(platformDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(platformDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		result.setCategory(platformDTO.getCategory());
		// result.setEquipment (platformDTO.getEquipment());
		result.setStatus(platformDTO.getStatus());
		result.setSubStatus(platformDTO.getSubStatus());
		result.setOptUser(platformDTO.getOptUser());
		result.setOptDate(platformDTO.getOptDate());
		result.setNowLot(platformDTO.getNowLot());
		result.setNowStation(platformDTO.getNowStation());
		result.setProductModel(platformDTO.getProductModel());
		result.setStartTime(platformDTO.getStartTime());
		result.setEndTime(platformDTO.getEndTime());
		result.setDuration(platformDTO.getDuration());
		result.setEndOptUser(platformDTO.getEndOptUser());
		result.setStandardWorkHours(platformDTO.getStandardWorkHours());
		result.setGrossDie(platformDTO.getGrossDie());
		result.setTheoryTime(platformDTO.getTheoryTime());
		result.setInkType(platformDTO.getInkType());
		result.setTouchTimes(platformDTO.getTouchTimes());
		result.setTeam(platformDTO.getTeam());
		result.setIsShift(platformDTO.getIsShift());
		result.setOptRemark(platformDTO.getOptRemark());
		result.setCompletedChip(platformDTO.getCompletedChip());
		result.setCompletedChipDescription(platformDTO
				.getCompletedChipDescription());
		result.setChipSelection(platformDTO.getChipSelection());
		result.setChipSelectionRemark(platformDTO.getChipSelectionRemark());
		result.setPcNo(platformDTO.getPcNo());
		// result.setPlatform (platformDTO.getPlatform());
		return result;
	}

	public static List<PlatformCPOptionLog> toEntities(
			Collection<PlatformCPOptionLogDTO> platformDTOs) {
		if (platformDTOs == null) {
			return null;
		}

		List<PlatformCPOptionLog> results = new ArrayList<PlatformCPOptionLog>();
		for (PlatformCPOptionLogDTO each : platformDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

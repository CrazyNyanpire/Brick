package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PlatformFTOptionLogAssembler {

	public static PlatformFTOptionLogDTO toDTO(
			PlatformFTOptionLog platformFTOptionLog) {
		if (platformFTOptionLog == null) {
			return null;
		}
		PlatformFTOptionLogDTO result = new PlatformFTOptionLogDTO();
		result.setId(platformFTOptionLog.getId());
		result.setVersion(platformFTOptionLog.getVersion());
		result.setCreateTimestamp(platformFTOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(platformFTOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(platformFTOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(platformFTOptionLog
				.getLastModifyEmployNo());
		result.setCategory(platformFTOptionLog.getCategory());
		// result.setEquipment (platformFTOptionLog.getEquipment());
		result.setStatus(platformFTOptionLog.getStatus());
		result.setSubStatus(platformFTOptionLog.getSubStatus());
		result.setOptUser(platformFTOptionLog.getOptUser());
		result.setOptDate(platformFTOptionLog.getOptDate());
		result.setNowLot(platformFTOptionLog.getNowLot());
		result.setNowStation(platformFTOptionLog.getNowStation());
		result.setProductModel(platformFTOptionLog.getProductModel());
		result.setStartTime(platformFTOptionLog.getStartTime());
		result.setEndTime(platformFTOptionLog.getEndTime());
		result.setDuration(platformFTOptionLog.getDuration());
		result.setEndOptUser(platformFTOptionLog.getEndOptUser());
		result.setStandardWorkHours(platformFTOptionLog.getStandardWorkHours());
		result.setGrossDie(platformFTOptionLog.getGrossDie());
		result.setTheoryTime(platformFTOptionLog.getTheoryTime());
		result.setInkType(platformFTOptionLog.getInkType());
		result.setTouchTimes(platformFTOptionLog.getTouchTimes());
		result.setTeam(platformFTOptionLog.getTeam());
		result.setIsShift(platformFTOptionLog.getIsShift());
		result.setOptRemark(platformFTOptionLog.getOptRemark());
		result.setCategoryPlatform(platformFTOptionLog.getCategoryPlatform());
		// result.setPlatform (platformFTOptionLog.getPlatform());
		result.setLastTestNo(platformFTOptionLog.getLastTestNo());
		result.setNowTestNo(platformFTOptionLog.getNowTestNo());
		return result;
	}

	public static List<PlatformFTOptionLogDTO> toDTOs(
			Collection<PlatformFTOptionLog> platformFTOptionLogs) {
		if (platformFTOptionLogs == null) {
			return null;
		}
		List<PlatformFTOptionLogDTO> results = new ArrayList<PlatformFTOptionLogDTO>();
		for (PlatformFTOptionLog each : platformFTOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static PlatformFTOptionLog toEntity(
			PlatformFTOptionLogDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		PlatformFTOptionLog result = new PlatformFTOptionLog();
		result.setId(platformDTO.getId());
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
		result.setCategoryPlatform(platformDTO.getCategoryPlatform());
		// result.setPlatform (platformDTO.getPlatform());
		// result.setLastTestNo (platformDTO.getLastTestNo());
		// result.setNowTestNo (platformDTO.getNowTestNo());
		return result;
	}

	public static PlatformFTOptionLog toEntity(PlatformDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		PlatformFTOptionLog result = new PlatformFTOptionLog();
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
		result.setCategoryPlatform("PLATFORM");
		// result.setPlatform (platformDTO.getPlatform());
		// result.setLastTestNo (platformDTO.getLastTestNo());
		// result.setNowTestNo (platformDTO.getNowTestNo());
		return result;
	}

	public static List<PlatformFTOptionLog> toEntities(
			Collection<PlatformFTOptionLogDTO> platformDTOs) {
		if (platformDTOs == null) {
			return null;
		}

		List<PlatformFTOptionLog> results = new ArrayList<PlatformFTOptionLog>();
		for (PlatformFTOptionLogDTO each : platformDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

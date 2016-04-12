package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.utils.SerialNumberUtils;
import acetecsemi.com.brick.core.domain.*;

public class PlatformOptionLogAssembler {

	public static PlatformOptionLogDTO toDTO(PlatformOptionLog platformOptionLog) {
		if (platformOptionLog == null) {
			return null;
		}
		PlatformOptionLogDTO result = new PlatformOptionLogDTO();
		result.setId(platformOptionLog.getId());
		result.setVersion(platformOptionLog.getVersion());
		result.setCreateTimestamp(platformOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(platformOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(platformOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(platformOptionLog.getLastModifyEmployNo());
		result.setCategory(platformOptionLog.getCategory());
		// result.setEquipment (platformOptionLog.getEquipment());
		result.setStatus(platformOptionLog.getStatus());
		result.setSubStatus(platformOptionLog.getSubStatus());
		result.setOptUser(platformOptionLog.getOptUser());
		result.setOptDate(platformOptionLog.getOptDate());
		result.setNowLot(platformOptionLog.getNowLot());
		result.setNowStation(platformOptionLog.getNowStation());
		result.setProductModel(platformOptionLog.getProductModel());
		result.setNowProduct(platformOptionLog.getProductModel());
		result.setStartTime(platformOptionLog.getStartTime());
		result.setEndTime(platformOptionLog.getEndTime());
		result.setDuration(MyDateUtils
				.getMin(platformOptionLog.getDuration() == null ? Long
						.valueOf(0) : platformOptionLog.getDuration()));
		result.setEndOptUser(platformOptionLog.getEndOptUser());
		result.setStandardWorkHours(platformOptionLog.getStandardWorkHours());
		result.setGrossDie(platformOptionLog.getGrossDie());
		result.setTheoryTime(platformOptionLog.getTheoryTime());
		result.setInkType(platformOptionLog.getInkType());
		result.setTouchTimes(platformOptionLog.getTouchTimes());
		result.setTeam(platformOptionLog.getTeam());
		result.setIsShift(platformOptionLog.getIsShift());
		result.setOptRemark(platformOptionLog.getOptRemark());
		// result.setPlatform (platformOptionLog.getPlatform());
		result.setPlatformNo(platformOptionLog.getPlatform().getTester()
				.getEquipmentNo());
		result.setPlatformName(platformOptionLog.getPlatform().getTester()
				.getEquipmentName());
		result.setCompletedChip(platformOptionLog.getCompletedChip());
		result.setCompletedChipDescription(platformOptionLog
				.getCompletedChipDescription());
		result.setChipSelection(platformOptionLog.getChipSelection());
		result.setChipSelectionRemark(platformOptionLog
				.getChipSelectionRemark());
		result.setLastTestNo(platformOptionLog.getLastTestNo());
		result.setNowTestNo(platformOptionLog.getNowTestNo());
		result.setPartIds(platformOptionLog.getPartIds());
		result.setPcNo(platformOptionLog.getPcNo());
		result.setCpCompletedNum(getCompletedNum(platformOptionLog));
		result.setLastWaferTD(platformOptionLog.getLastWaferTD());
		result.setNowWaferTD(platformOptionLog.getNowWaferTD());
		if ((result.getTouchTimes() == null || result.getTouchTimes() <= 0)
				&& result.getCpCompletedNum() != null
				&& !"".equals(result.getCpCompletedNum())
				&& platformOptionLog.getEngTouchDown() != null
				&& !"".equals(platformOptionLog.getEngTouchDown())
				&& Double.valueOf(result.getCpCompletedNum()) > 0) {
			Double td = Double.valueOf(result.getCpCompletedNum())
					* Integer.valueOf(platformOptionLog.getEngTouchDown());
			result.setTouchTimes(td.longValue());
		}
		result.setErrorMsg(platformOptionLog.getErrorMsg());
		result.setNowSiteTestQty(platformOptionLog.getNowSiteTestQty());
		result.setKitsId(platformOptionLog.getKitsId());
		result.setLoadBoardId(platformOptionLog.getLoadBoardId());
		return result;
	}

	public static List<PlatformOptionLogDTO> toDTOs(
			Collection<PlatformOptionLog> platformOptionLogs) {
		if (platformOptionLogs == null) {
			return null;
		}
		List<PlatformOptionLogDTO> results = new ArrayList<PlatformOptionLogDTO>();
		for (PlatformOptionLog each : platformOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static PlatformOptionLog toEntity(PlatformOptionLogDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		PlatformOptionLog result = new PlatformOptionLog();
		result.setId(platformDTO.getId());
		result.setVersion(platformDTO.getVersion());
		// result.setCreateTimestamp(platformDTO.getCreateTimestamp());
		// result.setLastModifyTimestamp(platformDTO.getLastModifyTimestamp());
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
		// result.setDuration(platformDTO.getDuration());
		result.setEndOptUser(platformDTO.getEndOptUser());
		result.setStandardWorkHours(platformDTO.getStandardWorkHours());
		result.setGrossDie(platformDTO.getGrossDie());
		result.setTheoryTime(platformDTO.getTheoryTime());
		result.setInkType(platformDTO.getInkType());
		result.setTouchTimes(platformDTO.getTouchTimes());
		result.setTeam(platformDTO.getTeam());
		result.setIsShift(platformDTO.getIsShift());
		result.setOptRemark(platformDTO.getOptRemark());
		result.setErrorMsg(platformDTO.getErrorMsg());
		// result.setPlatform (platformDTO.getPlatform());
		return result;
	}

	public static List<PlatformOptionLog> toEntities(
			Collection<PlatformOptionLogDTO> platformDTOs) {
		if (platformDTOs == null) {
			return null;
		}

		List<PlatformOptionLog> results = new ArrayList<PlatformOptionLog>();
		for (PlatformOptionLogDTO each : platformDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}

	public static String getCompletedNum(PlatformOptionLog platformOptionLog) {

		double lastNum = getCompleteNum(platformOptionLog.getChipSelection(),
				platformOptionLog.getChipSelectionRemark(),
				platformOptionLog.getGrossDie());
		double nowNum = getCompleteNum(platformOptionLog.getCompletedChip(),
				platformOptionLog.getCompletedChipDescription(),
				platformOptionLog.getGrossDie());
		if (nowNum <= 0) {
			return "";
		}
		return SerialNumberUtils.getFormartNum(nowNum - lastNum, "##.####");
	}

	public static double getCompleteNum(String chip, String chipDescription,
			String grossDie) {
		if (chip == null) {
			return 0.0;
		}
		String[] chipIds = chip.split(",");
		double chips = 0;

		for (String id : chipIds) {
			if (id != null && !"".equals(id) && !"-1".equals(id)) {
				chips++;
			}
		}
		if (chipDescription == null) {
			return chips;
		}
		for (String no : chipDescription.split(",")) {
			if (no != null && !"".equals(no) && grossDie != null
					&& !"".equals(grossDie) && !"0".equals(grossDie)) {
				Double td = (Double.valueOf(no) / Double.valueOf(grossDie));
				chips += td;
			}
		}
		return chips;
	}
}

package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.utils.SerialNumberUtils;
import acetecsemi.com.brick.core.domain.*;

public class EquipmentOptionLogAssembler {

	public static EquipmentOptionLogDTO toDTO(EquipmentOptionLog equipmentOptionLog) {
		if (equipmentOptionLog == null) {
			return null;
		}
		EquipmentOptionLogDTO result = new EquipmentOptionLogDTO();
		result.setId(equipmentOptionLog.getId());
		result.setVersion(equipmentOptionLog.getVersion());
		result.setCreateTimestamp(equipmentOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(equipmentOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentOptionLog.getLastModifyEmployNo());
		result.setCategory(equipmentOptionLog.getCategory());
		//result.setEquipment(equipmentOptionLog.getEquipment());
		result.setEquipmentNo(equipmentOptionLog.getEquipment().getEquipmentNo());
		result.setEquipmentName(equipmentOptionLog.getEquipment().getEquipmentName());
		result.setStatus(equipmentOptionLog.getStatus());
		result.setSubStatus(equipmentOptionLog.getSubStatus());
		result.setOptUser(equipmentOptionLog.getOptUser());
		result.setOptDate(equipmentOptionLog.getOptDate());
		result.setNowLot(equipmentOptionLog.getNowLot());
		result.setNowStation(equipmentOptionLog.getNowStation());
		result.setProductModel(equipmentOptionLog.getProductModel());
		result.setNowProduct(equipmentOptionLog.getProductModel());
		result.setStartTime(equipmentOptionLog.getStartTime());
		result.setEndTime(equipmentOptionLog.getEndTime());
		result.setDuration(MyDateUtils
				.getMin(equipmentOptionLog.getDuration() == null ? Long
						.valueOf(0) : equipmentOptionLog.getDuration()));
		result.setEndOptUser(equipmentOptionLog.getEndOptUser());
		result.setStandardWorkHours(equipmentOptionLog.getStandardWorkHours());
		result.setGrossDie(equipmentOptionLog.getGrossDie());
		result.setTheoryTime(equipmentOptionLog.getTheoryTime());
		result.setInkType(equipmentOptionLog.getInkType());
		result.setTouchTimes(equipmentOptionLog.getTouchTimes());
		result.setTeam(equipmentOptionLog.getTeam());
		result.setIsShift(equipmentOptionLog.getIsShift());
		result.setOptRemark(equipmentOptionLog.getOptRemark());
		result.setChipSelection(equipmentOptionLog.getChipSelection());
		result.setChipSelectionRemark(equipmentOptionLog.getChipSelectionRemark());
		result.setCompletedChip(equipmentOptionLog.getCompletedChip());
		result.setCompletedChipDescription(equipmentOptionLog.getCompletedChipDescription());
		result.setCpCompletedNum(getCompletedNum(equipmentOptionLog));
		return result;
	}

	public static List<EquipmentOptionLogDTO> toDTOs(
			Collection<EquipmentOptionLog> equipmentOptionLogs) {
		if (equipmentOptionLogs == null) {
			return null;
		}
		List<EquipmentOptionLogDTO> results = new ArrayList<EquipmentOptionLogDTO>();
		for (EquipmentOptionLog each : equipmentOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static EquipmentOptionLog toEntity(EquipmentOptionLogDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		EquipmentOptionLog result = new EquipmentOptionLog();
		result.setId(equipmentDTO.getId());
		result.setVersion(equipmentDTO.getVersion());
		result.setCreateTimestamp(equipmentDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(equipmentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		result.setCategory(equipmentDTO.getCategory());
		//result.setEquipment(equipmentDTO.getEquipment());
		result.setStatus(equipmentDTO.getStatus());
		result.setSubStatus(equipmentDTO.getSubStatus());
		result.setOptUser(equipmentDTO.getOptUser());
		result.setOptDate(equipmentDTO.getOptDate());
		result.setNowLot(equipmentDTO.getNowLot());
		result.setNowStation(equipmentDTO.getNowStation());
		result.setProductModel(equipmentDTO.getProductModel());
		result.setStartTime(equipmentDTO.getStartTime());
		result.setEndTime(equipmentDTO.getEndTime());
		//result.setDuration(equipmentDTO.getDuration());
		result.setEndOptUser(equipmentDTO.getEndOptUser());
		result.setStandardWorkHours(equipmentDTO.getStandardWorkHours());
		result.setGrossDie(equipmentDTO.getGrossDie());
		result.setTheoryTime(equipmentDTO.getTheoryTime());
		result.setInkType(equipmentDTO.getInkType());
		result.setTouchTimes(equipmentDTO.getTouchTimes());
		result.setTeam(equipmentDTO.getTeam());
		result.setIsShift(equipmentDTO.getIsShift());
		result.setOptRemark(equipmentDTO.getOptRemark());
		return result;
	}

	public static List<EquipmentOptionLog> toEntities(
			Collection<EquipmentOptionLogDTO> equipmentDTOs) {
		if (equipmentDTOs == null) {
			return null;
		}

		List<EquipmentOptionLog> results = new ArrayList<EquipmentOptionLog>();
		for (EquipmentOptionLogDTO each : equipmentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
	
	public static EquipmentOptionLog toEntity(EquipmentDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		EquipmentOptionLog result = new EquipmentOptionLog();
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		result.setCategory(equipmentDTO.getCategory());
		//result.setEquipment(equipmentDTO.getEquipment());
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
		return result;
	}
	
	public static EquipmentOptionLog toEntity(PlatformDTO equipmentDTO) {
		if (equipmentDTO == null) {
			return null;
		}
		EquipmentOptionLog result = new EquipmentOptionLog();
		result.setId(equipmentDTO.getId());
		result.setVersion(equipmentDTO.getVersion());
		result.setCreateTimestamp(equipmentDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(equipmentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(equipmentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(equipmentDTO.getLastModifyEmployNo());
		result.setCategory(equipmentDTO.getCategory());
		//result.setEquipment(equipmentDTO.getEquipment());
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
		return result;
	}
	
	public static String getCompletedNum(EquipmentOptionLog equipmentOptionLog) {

		double lastNum = getCompleteNum(equipmentOptionLog.getChipSelection(),
				equipmentOptionLog.getChipSelectionRemark(),
				equipmentOptionLog.getGrossDie());
		double nowNum = getCompleteNum(equipmentOptionLog.getCompletedChip(),
				equipmentOptionLog.getCompletedChipDescription(),
				equipmentOptionLog.getGrossDie());
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
					&& !"".equals(grossDie) && !"NA".equals(grossDie)) {
				Double td = (Double.valueOf(no) / Double.valueOf(grossDie));
				chips += td;
			}
		}
		return chips;
	}
}

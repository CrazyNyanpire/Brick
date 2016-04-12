package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class KitsOptionLogAssembler {

	public static KitsOptionLogDTO toDTO(KitsOptionLog kitsOptionLog) {
		if (kitsOptionLog == null) {
			return null;
		}
		KitsOptionLogDTO result = new KitsOptionLogDTO();
		result.setId(kitsOptionLog.getId());
		result.setVersion(kitsOptionLog.getVersion());
		result.setCreateTimestamp(kitsOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(kitsOptionLog.getLastModifyTimestamp());
		result.setCreateEmployNo(kitsOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(kitsOptionLog.getLastModifyEmployNo());
		result.setLogic(kitsOptionLog.getLogic());
		// result.setKits (kitsOptionLog.getKits());
		result.setStatus(kitsOptionLog.getStatus());
		result.setNowLot(kitsOptionLog.getNowLot());
		result.setNowStation(kitsOptionLog.getNowStation());
		result.setProductModel(kitsOptionLog.getProductModel());
		result.setStartTime(kitsOptionLog.getStartTime());
		result.setEndTime(kitsOptionLog.getEndTime());
		result.setDuration(kitsOptionLog.getDuration());
		result.setEndOptUser(kitsOptionLog.getEndOptUser());
		result.setTheoryTime(kitsOptionLog.getTheoryTime());
		result.setOptRemark(kitsOptionLog.getOptRemark());
		result.setProductLot(kitsOptionLog.getProductLot());
		result.setEquipmentNo(kitsOptionLog.getEquipmentNo());
		result.setRemark(kitsOptionLog.getRemark());
		result.setAppearanceHorizontal(kitsOptionLog.getAppearanceHorizontal());
		result.setPlatform(kitsOptionLog.getPlatform());
		result.setPlatformIds(kitsOptionLog.getPlatformIds());
		result.setPlatformStatus(kitsOptionLog.getPlatformStatus());
		return result;
	}

	public static List<KitsOptionLogDTO> toDTOs(
			Collection<KitsOptionLog> kitsOptionLogs) {
		if (kitsOptionLogs == null) {
			return null;
		}
		List<KitsOptionLogDTO> results = new ArrayList<KitsOptionLogDTO>();
		for (KitsOptionLog each : kitsOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static KitsOptionLog toEntity(KitsOptionLogDTO kitsDTO) {
		if (kitsDTO == null) {
			return null;
		}
		KitsOptionLog result = new KitsOptionLog();
		result.setId(kitsDTO.getId());
		result.setVersion(kitsDTO.getVersion());
		result.setCreateTimestamp(kitsDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(kitsDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(kitsDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(kitsDTO.getLastModifyEmployNo());
		result.setLogic(kitsDTO.getLogic());
		// result.setKits (kitsDTO.getKits());
		result.setStatus(kitsDTO.getStatus());
		result.setNowLot(kitsDTO.getNowLot());
		result.setNowStation(kitsDTO.getNowStation());
		result.setProductModel(kitsDTO.getProductModel());
		result.setStartTime(kitsDTO.getStartTime());
		result.setEndTime(kitsDTO.getEndTime());
		result.setDuration(kitsDTO.getDuration());
		result.setEndOptUser(kitsDTO.getEndOptUser());
		result.setTheoryTime(kitsDTO.getTheoryTime());
		result.setOptRemark(kitsDTO.getOptRemark());
		result.setProductLot(kitsDTO.getProductLot());
		result.setEquipmentNo(kitsDTO.getEquipmentNo());
		result.setRemark(kitsDTO.getRemark());
		result.setAppearanceHorizontal(kitsDTO.getAppearanceHorizontal());
		result.setPlatform(kitsDTO.getPlatform());
		result.setPlatformIds(kitsDTO.getPlatformIds());
		result.setPlatformStatus(kitsDTO.getPlatformStatus());
		return result;
	}

	public static List<KitsOptionLog> toEntities(
			Collection<KitsOptionLogDTO> kitsDTOs) {
		if (kitsDTOs == null) {
			return null;
		}

		List<KitsOptionLog> results = new ArrayList<KitsOptionLog>();
		for (KitsOptionLogDTO each : kitsDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

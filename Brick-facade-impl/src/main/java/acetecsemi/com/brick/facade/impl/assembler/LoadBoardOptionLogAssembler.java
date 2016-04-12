package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class LoadBoardOptionLogAssembler {

	public static LoadBoardOptionLogDTO toDTO(
			LoadBoardOptionLog loadBoardOptionLog) {
		if (loadBoardOptionLog == null) {
			return null;
		}
		LoadBoardOptionLogDTO result = new LoadBoardOptionLogDTO();
		result.setId(loadBoardOptionLog.getId());
		result.setVersion(loadBoardOptionLog.getVersion());
		result.setCreateTimestamp(loadBoardOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(loadBoardOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(loadBoardOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(loadBoardOptionLog.getLastModifyEmployNo());
		result.setLogic(loadBoardOptionLog.getLogic());
		// result.setLoadBoard (loadBoardOptionLog.getLoadBoard());
		result.setStatus(loadBoardOptionLog.getStatus());
		result.setNowLot(loadBoardOptionLog.getNowLot());
		result.setNowStation(loadBoardOptionLog.getNowStation());
		result.setProductModel(loadBoardOptionLog.getProductModel());
		result.setStartTime(loadBoardOptionLog.getStartTime());
		result.setEndTime(loadBoardOptionLog.getEndTime());
		result.setDuration(loadBoardOptionLog.getDuration());
		result.setEndOptUser(loadBoardOptionLog.getEndOptUser());
		result.setTheoryTime(loadBoardOptionLog.getTheoryTime());
		result.setOptRemark(loadBoardOptionLog.getOptRemark());
		result.setProductLot(loadBoardOptionLog.getProductLot());
		result.setEquipmentNo(loadBoardOptionLog.getEquipmentNo());
		result.setRemark(loadBoardOptionLog.getRemark());
		result.setAppearanceHorizontal(loadBoardOptionLog
				.getAppearanceHorizontal());
		result.setPlatform(loadBoardOptionLog.getPlatform());
		result.setPlatformIds(loadBoardOptionLog.getPlatformIds());
		result.setPlatformStatus(loadBoardOptionLog.getPlatformStatus());
		return result;
	}

	public static List<LoadBoardOptionLogDTO> toDTOs(
			Collection<LoadBoardOptionLog> loadBoardOptionLogs) {
		if (loadBoardOptionLogs == null) {
			return null;
		}
		List<LoadBoardOptionLogDTO> results = new ArrayList<LoadBoardOptionLogDTO>();
		for (LoadBoardOptionLog each : loadBoardOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static LoadBoardOptionLog toEntity(
			LoadBoardOptionLogDTO LoadBoardOptionLogDTO) {
		if (LoadBoardOptionLogDTO == null) {
			return null;
		}
		LoadBoardOptionLog result = new LoadBoardOptionLog();
		result.setId(LoadBoardOptionLogDTO.getId());
		result.setVersion(LoadBoardOptionLogDTO.getVersion());
		result.setCreateTimestamp(LoadBoardOptionLogDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(LoadBoardOptionLogDTO
				.getLastModifyTimestamp());
		result.setCreateEmployNo(LoadBoardOptionLogDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(LoadBoardOptionLogDTO
				.getLastModifyEmployNo());
		result.setLogic(LoadBoardOptionLogDTO.getLogic());
		// result.setLoadBoard (LoadBoardOptionLogDTO.getLoadBoard());
		result.setStatus(LoadBoardOptionLogDTO.getStatus());
		result.setNowLot(LoadBoardOptionLogDTO.getNowLot());
		result.setNowStation(LoadBoardOptionLogDTO.getNowStation());
		result.setProductModel(LoadBoardOptionLogDTO.getProductModel());
		result.setStartTime(LoadBoardOptionLogDTO.getStartTime());
		result.setEndTime(LoadBoardOptionLogDTO.getEndTime());
		result.setDuration(LoadBoardOptionLogDTO.getDuration());
		result.setEndOptUser(LoadBoardOptionLogDTO.getEndOptUser());
		result.setTheoryTime(LoadBoardOptionLogDTO.getTheoryTime());
		result.setOptRemark(LoadBoardOptionLogDTO.getOptRemark());
		result.setProductLot(LoadBoardOptionLogDTO.getProductLot());
		result.setEquipmentNo(LoadBoardOptionLogDTO.getEquipmentNo());
		result.setRemark(LoadBoardOptionLogDTO.getRemark());
		result.setAppearanceHorizontal(LoadBoardOptionLogDTO
				.getAppearanceHorizontal());
		result.setPlatform(LoadBoardOptionLogDTO.getPlatform());
		result.setPlatformIds(LoadBoardOptionLogDTO.getPlatformIds());
		result.setPlatformStatus(LoadBoardOptionLogDTO.getPlatformStatus());
		return result;
	}

	public static List<LoadBoardOptionLog> toEntities(
			Collection<LoadBoardOptionLogDTO> loadBoardOptionLogDTOs) {
		if (loadBoardOptionLogDTOs == null) {
			return null;
		}

		List<LoadBoardOptionLog> results = new ArrayList<LoadBoardOptionLog>();
		for (LoadBoardOptionLogDTO each : loadBoardOptionLogDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

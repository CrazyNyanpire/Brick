package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class SocketOptionLogAssembler {

	public static SocketOptionLogDTO toDTO(SocketOptionLog socketOptionLog) {
		if (socketOptionLog == null) {
			return null;
		}
		SocketOptionLogDTO result = new SocketOptionLogDTO();
		result.setId(socketOptionLog.getId());
		result.setVersion(socketOptionLog.getVersion());
		result.setCreateTimestamp(socketOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(socketOptionLog.getLastModifyTimestamp());
		result.setCreateEmployNo(socketOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(socketOptionLog.getLastModifyEmployNo());
		// result.setSocket (socketOptionLog.getSocket());
		result.setStatus(socketOptionLog.getStatus());
		result.setNowLot(socketOptionLog.getNowLot());
		result.setNowStation(socketOptionLog.getNowStation());
		result.setProductModel(socketOptionLog.getProductModel());
		result.setStartTime(socketOptionLog.getStartTime());
		result.setEndTime(socketOptionLog.getEndTime());
		result.setDuration(socketOptionLog.getDuration());
		result.setEndOptUser(socketOptionLog.getEndOptUser());
		result.setTheoryTime(socketOptionLog.getTheoryTime());
		result.setTouchTimes(socketOptionLog.getTouchTimes());
		result.setOptRemark(socketOptionLog.getOptRemark());
		result.setProductLot(socketOptionLog.getProductLot());
		result.setEquipmentNo(socketOptionLog.getPlatform());
		result.setSocketId(socketOptionLog.getSocket().getId());
		result.setPartModel(socketOptionLog.getSocket().getPartModel());
		result.setPartNo(socketOptionLog.getSocket().getPartNo());
		result.setAppearanceHorizontal(socketOptionLog.getAppearanceHorizontal());
		result.setPlatformStatus(socketOptionLog.getPlatformStatus());
		result.setPlatformSite(socketOptionLog.getPlatformSite());
		return result;
	}

	public static List<SocketOptionLogDTO> toDTOs(
			Collection<SocketOptionLog> socketOptionLogs) {
		if (socketOptionLogs == null) {
			return null;
		}
		List<SocketOptionLogDTO> results = new ArrayList<SocketOptionLogDTO>();
		for (SocketOptionLog each : socketOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static SocketOptionLog toEntity(SocketOptionLogDTO socketDTO) {
		if (socketDTO == null) {
			return null;
		}
		SocketOptionLog result = new SocketOptionLog();
		result.setId(socketDTO.getId());
		result.setVersion(socketDTO.getVersion());
		result.setCreateTimestamp(socketDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(socketDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(socketDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(socketDTO.getLastModifyEmployNo());
		// result.setSocket (socketDTO.getSocket());
		result.setStatus(socketDTO.getStatus());
		result.setNowLot(socketDTO.getNowLot());
		result.setNowStation(socketDTO.getNowStation());
		result.setProductModel(socketDTO.getProductModel());
		result.setStartTime(socketDTO.getStartTime());
		result.setEndTime(socketDTO.getEndTime());
		result.setDuration(socketDTO.getDuration());
		result.setEndOptUser(socketDTO.getEndOptUser());
		result.setTheoryTime(socketDTO.getTheoryTime());
		result.setTouchTimes(socketDTO.getTouchTimes());
		result.setOptRemark(socketDTO.getOptRemark());
		result.setProductLot(socketDTO.getProductLot());
		result.setEquipmentNo(socketDTO.getEquipmentNo());
		result.setPlatformSite(socketDTO.getPlatformSite());
		return result;
	}

	public static SocketOptionLog toEntity(SocketDTO socketDTO) {
		if (socketDTO == null) {
			return null;
		}
		SocketOptionLog result = new SocketOptionLog();
		result.setId(socketDTO.getId());
		result.setVersion(socketDTO.getVersion());
		result.setCreateTimestamp(socketDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(socketDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(socketDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(socketDTO.getLastModifyEmployNo());
		// result.setSocket (socketDTO.getSocket());
		result.setStatus(socketDTO.getStatus());
		// result.setSubStatus (socketDTO.getSubStatus());
		result.setNowLot(socketDTO.getNowLot());
		result.setNowStation(socketDTO.getNowStation());
		result.setProductModel(socketDTO.getProductModel());
		result.setStartTime(socketDTO.getStartTime());
		result.setEndTime(socketDTO.getEndTime());
		result.setDuration(socketDTO.getDuration());
		result.setEndOptUser(socketDTO.getEndOptUser());
		result.setTheoryTime(socketDTO.getTheoryTime());
		result.setTouchTimes(socketDTO.getTouchTimes());
		result.setOptRemark(socketDTO.getOptRemark());
		result.setProductLot(socketDTO.getProductLot());
		result.setEquipmentNo(socketDTO.getEquipmentNo());
		return result;
	}

	public static List<SocketOptionLog> toEntities(
			Collection<SocketOptionLogDTO> socketDTOs) {
		if (socketDTOs == null) {
			return null;
		}

		List<SocketOptionLog> results = new ArrayList<SocketOptionLog>();
		for (SocketOptionLogDTO each : socketDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

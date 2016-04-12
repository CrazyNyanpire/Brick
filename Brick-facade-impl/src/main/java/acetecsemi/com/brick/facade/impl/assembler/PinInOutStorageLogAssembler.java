package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PinInOutStorageLogAssembler {

	public static PinInOutStorageLogDTO toDTO(
			PinInOutStorageLog pinInOutStorageLog) {
		if (pinInOutStorageLog == null) {
			return null;
		}
		PinInOutStorageLogDTO result = new PinInOutStorageLogDTO();
		result.setId(pinInOutStorageLog.getId());
		result.setVersion(pinInOutStorageLog.getVersion());
		result.setCreateTimestamp(pinInOutStorageLog.getCreateTimestamp());
		result.setLastModifyTimestamp(pinInOutStorageLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(pinInOutStorageLog.getCreateEmployNo());
		result.setLastModifyEmployNo(pinInOutStorageLog.getLastModifyEmployNo());
		// result.setSocket (pinInOutStorageLog.getSocket());
		// result.setPin (pinInOutStorageLog.getPin());
		result.setQty(pinInOutStorageLog.getQty());
		result.setInitQty(pinInOutStorageLog.getInitQty());
		result.setBalanceQty(pinInOutStorageLog.getBalanceQty());
		result.setType(pinInOutStorageLog.getType());
		result.setRemark(pinInOutStorageLog.getRemark());
		if(pinInOutStorageLog.getPin() != null){
			result.setPinId(pinInOutStorageLog.getPin().getId());
			result.setPinDTO(PinAssembler.toDTO(pinInOutStorageLog.getPin()));
		}
		if(pinInOutStorageLog.getSocket() != null){
			result.setSocketId(pinInOutStorageLog.getSocket().getId());
			result.setSocketDTO(SocketAssembler.toDTO(pinInOutStorageLog.getSocket()));
		}
		return result;
	}

	public static List<PinInOutStorageLogDTO> toDTOs(
			Collection<PinInOutStorageLog> pinInOutStorageLogs) {
		if (pinInOutStorageLogs == null) {
			return null;
		}
		List<PinInOutStorageLogDTO> results = new ArrayList<PinInOutStorageLogDTO>();
		for (PinInOutStorageLog each : pinInOutStorageLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static PinInOutStorageLog toEntity(PinInOutStorageLogDTO pinDTO) {
		if (pinDTO == null) {
			return null;
		}
		PinInOutStorageLog result = new PinInOutStorageLog();
		result.setId(pinDTO.getId());
		result.setVersion(pinDTO.getVersion());
		result.setCreateTimestamp(pinDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(pinDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(pinDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(pinDTO.getLastModifyEmployNo());
		// result.setSocket (pinDTO.getSocket());
		// result.setPin (pinDTO.getPin());
		result.setQty(pinDTO.getQty());
		result.setInitQty(pinDTO.getInitQty());
		result.setBalanceQty(pinDTO.getBalanceQty());
		result.setType(pinDTO.getType());
		result.setRemark(pinDTO.getRemark());
		return result;
	}
	
	public static PinInOutStorageLog toEntity(PinDTO pinDTO) {
		if (pinDTO == null) {
			return null;
		}
		PinInOutStorageLog result = new PinInOutStorageLog();
		result.setId(pinDTO.getId());
		result.setVersion(pinDTO.getVersion());
		result.setCreateTimestamp(pinDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(pinDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(pinDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(pinDTO.getLastModifyEmployNo());
		// result.setSocket (pinDTO.getSocket());
		// result.setPin (pinDTO.getPin());
		result.setQty(pinDTO.getQty());
		result.setInitQty(pinDTO.getInitQty());
		result.setBalanceQty(pinDTO.getBalanceQty());
		result.setType(pinDTO.getType());
		result.setRemark(pinDTO.getRemark());
		return result;
	}

	public static List<PinInOutStorageLog> toEntities(
			Collection<PinInOutStorageLogDTO> pinDTOs) {
		if (pinDTOs == null) {
			return null;
		}

		List<PinInOutStorageLog> results = new ArrayList<PinInOutStorageLog>();
		for (PinInOutStorageLogDTO each : pinDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

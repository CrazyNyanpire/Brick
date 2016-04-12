package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PinAssembler {

	public static PinDTO toDTO(Pin pin) {
		if (pin == null) {
			return null;
		}
		PinDTO result = new PinDTO();
		result.setId(pin.getId());
		result.setVersion(pin.getVersion());
		result.setCreateTimestamp(pin.getCreateTimestamp());
		result.setLastModifyTimestamp(pin.getLastModifyTimestamp());
		result.setCreateEmployNo(pin.getCreateEmployNo());
		result.setLastModifyEmployNo(pin.getLastModifyEmployNo());
		result.setModel(pin.getModel());
		result.setUseQty(pin.getUseQty());
		result.setTotalQty(pin.getTotalQty());
		result.setBalanceQty(pin.getBalanceQty());
		result.setTheoryTestUph(pin.getTheoryTestUph());
		result.setInDate(pin.getInDate());
		return result;
	}

	public static List<PinDTO> toDTOs(Collection<Pin> pins) {
		if (pins == null) {
			return null;
		}
		List<PinDTO> results = new ArrayList<PinDTO>();
		for (Pin each : pins) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static Pin toEntity(PinDTO pinDTO) {
		if (pinDTO == null) {
			return null;
		}
		Pin result = new Pin();
		result.setId(pinDTO.getId());
		result.setVersion(pinDTO.getVersion());
		//result.setCreateTimestamp(pinDTO.getCreateTimestamp());
		//result.setLastModifyTimestamp(pinDTO.getLastModifyTimestamp());
		//result.setCreateEmployNo(pinDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(pinDTO.getLastModifyEmployNo());
		result.setModel(pinDTO.getModel());
		result.setUseQty(pinDTO.getUseQty());
		result.setTotalQty(pinDTO.getTotalQty());
		result.setBalanceQty(pinDTO.getBalanceQty());
		result.setTheoryTestUph(pinDTO.getTheoryTestUph());
		//result.setInDate(pinDTO.getInDate());
		return result;
	}
	
	public static Pin toEntity(Pin result, PinDTO pinDTO) {
		if (pinDTO == null) {
			return null;
		}
		result.setId(pinDTO.getId());
		result.setVersion(pinDTO.getVersion());
		//result.setCreateTimestamp(pinDTO.getCreateTimestamp());
		//result.setLastModifyTimestamp(pinDTO.getLastModifyTimestamp());
		//result.setCreateEmployNo(pinDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(pinDTO.getLastModifyEmployNo());
		result.setModel(pinDTO.getModel());
		result.setUseQty(pinDTO.getUseQty());
		result.setTotalQty(pinDTO.getTotalQty());
		result.setBalanceQty(pinDTO.getBalanceQty());
		result.setTheoryTestUph(pinDTO.getTheoryTestUph());
		//result.setInDate(pinDTO.getInDate());
		return result;
	}

	public static List<Pin> toEntities(Collection<PinDTO> pinDTOs) {
		if (pinDTOs == null) {
			return null;
		}

		List<Pin> results = new ArrayList<Pin>();
		for (PinDTO each : pinDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

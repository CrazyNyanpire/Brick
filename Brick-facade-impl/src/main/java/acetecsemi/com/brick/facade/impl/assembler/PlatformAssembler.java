package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PlatformAssembler {

	public static PlatformDTO toDTO(Platform platform) {
		if (platform == null) {
			return null;
		}
		PlatformDTO result = new PlatformDTO();
		result.setId(platform.getId());
		result.setVersion(platform.getVersion());
		result.setCreateTimestamp(platform.getCreateTimestamp());
		result.setLastModifyTimestamp(platform.getLastModifyTimestamp());
		result.setCreateEmployNo(platform.getCreateEmployNo());
		result.setLastModifyEmployNo(platform.getLastModifyEmployNo());
		result.setPlatformNo(platform.getTester().getEquipmentNo());
		result.setPlatformName(platform.getTester().getEquipmentNo());
		result.setPlatformCategory(platform.getPlatformCategory());
		result.setLocation(platform.getTester().getEquipmentLocation()
				.getCategoryName());
		result.setCheckInTime(platform.getCheckInTime());
		result.setStatus(platform.getStatus());
		result.setSubStatus(platform.getSubSstatus());
		if (platform.getEquipmentChildren() != null
				&& platform.getEquipmentChildren().size() > 0) {
			List<String> equipmentNos = new ArrayList<String>();
			for (Equipment equipment : platform.getEquipmentChildren()) {
				equipmentNos.add(equipment.getEquipmentNo());
				result.getEquipmentChildren().add(
						EquipmentAssembler.toDTO(equipment));
				result.setPlatformName(platform.getTester().getEquipmentNo()
						+ "&" + equipment.getEquipmentNo());
			}
			result.setEquipmentNos(equipmentNos);
		}
		result.setNowLot(platform.getNowLot());
		result.setProductModel(platform.getProductModel());
		result.setIp(platform.getTester().getIp());
		result.setIsAuto(platform.getTester().getIsAuto());
		return result;
	}

	public static List<PlatformDTO> toDTOs(Collection<Platform> platforms) {
		if (platforms == null) {
			return null;
		}
		List<PlatformDTO> results = new ArrayList<PlatformDTO>();
		for (Platform each : platforms) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static Platform toEntity(PlatformDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		Platform result = new Platform();
		result.setId(platformDTO.getId());
		result.setVersion(platformDTO.getVersion());
		// result.setCreateTimestamp(platformDTO.getCreateTimestamp());
		// result.setLastModifyTimestamp(platformDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(platformDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		result.setPlatformNo(platformDTO.getPlatformNo());
		result.setPlatformName(platformDTO.getPlatformName());
		result.setPlatformCategory(platformDTO.getPlatformCategory());
		result.setCheckInTime(platformDTO.getCheckInTime());
		result.setStatus(platformDTO.getStatus());
		return result;
	}

	public static List<Platform> toEntities(Collection<PlatformDTO> platformDTOs) {
		if (platformDTOs == null) {
			return null;
		}

		List<Platform> results = new ArrayList<Platform>();
		for (PlatformDTO each : platformDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

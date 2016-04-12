package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class MaintenancePlatformAssembler {

	public static MaintenancePlatformDTO toDTO(
			MaintenancePlatform maintenancePlatform) {
		if (maintenancePlatform == null) {
			return null;
		}
		MaintenancePlatformDTO result = new MaintenancePlatformDTO();
		result.setId(maintenancePlatform.getId());
		result.setVersion(maintenancePlatform.getVersion());
		result.setCreateTimestamp(maintenancePlatform.getCreateTimestamp());
		result.setLastModifyTimestamp(maintenancePlatform
				.getLastModifyTimestamp());
		result.setCreateEmployNo(maintenancePlatform.getCreateEmployNo());
		result.setLastModifyEmployNo(maintenancePlatform
				.getLastModifyEmployNo());
		result.setCategory(maintenancePlatform.getCategory());
		result.setOptType(maintenancePlatform.getOptType());
		result.setOptUser(maintenancePlatform.getOptUser());
		result.setOptDate(maintenancePlatform.getOptDate());
		result.setRemark(maintenancePlatform.getRemark());
		result.setFileUrl(maintenancePlatform.getFileUrl());
		if (maintenancePlatform.getPlatform() != null) {
			result.setPlatformName(maintenancePlatform.getPlatform()
					.getTester().getEquipmentNo());
			result.setPlatformId(maintenancePlatform.getPlatform().getId());
		}

		return result;
	}

	public static List<MaintenancePlatformDTO> toDTOs(
			Collection<MaintenancePlatform> maintenancePlatforms) {
		if (maintenancePlatforms == null) {
			return null;
		}
		List<MaintenancePlatformDTO> results = new ArrayList<MaintenancePlatformDTO>();
		for (MaintenancePlatform each : maintenancePlatforms) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static MaintenancePlatform toEntity(
			MaintenancePlatformDTO platformDTO) {
		if (platformDTO == null) {
			return null;
		}
		MaintenancePlatform result = new MaintenancePlatform();
		result.setId(platformDTO.getId());
		result.setVersion(platformDTO.getVersion());
		// result.setCreateTimestamp (platformDTO.getCreateTimestamp());
		// result.setLastModifyTimestamp (platformDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(platformDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		result.setCategory(platformDTO.getCategory());
		result.setOptType(platformDTO.getOptType());
		result.setOptUser(platformDTO.getOptUser());
		result.setOptDate(platformDTO.getOptDate());
		result.setRemark(platformDTO.getRemark());
		result.setFileUrl(platformDTO.getFileUrl());
		// result.setPlatform (platformDTO.getPlatform());
		return result;
	}

	public static List<MaintenancePlatform> toEntities(
			Collection<MaintenancePlatformDTO> platformDTOs) {
		if (platformDTOs == null) {
			return null;
		}

		List<MaintenancePlatform> results = new ArrayList<MaintenancePlatform>();
		for (MaintenancePlatformDTO each : platformDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

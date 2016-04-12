package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;

public class ChangeStatusAssembler {

	public static ChangeStatusDTO toDTO(Object[] objects) {
		if (objects == null) {
			return null;
		}
		ChangeStatusDTO result = new ChangeStatusDTO();
		result.setId(Long.valueOf(objects[0].toString()));
		result.setStatus(objects[1].toString());
		result.setNo(objects[2].toString());
		result.setCategory(objects[3] != null ? objects[3].toString() : "");
		result.setType(objects[4] != null ? objects[4].toString() : "");
		result.setEquipmentNo(objects[5] != null ? objects[5].toString() : "");
		result.setLotNo(objects[6] != null ? objects[6].toString() : "");
		result.setProductModel(objects[7] != null ? objects[7].toString() : "");
		result.setCategoryName(objects[8] != null ? objects[8].toString() : "");
		result.setLocation(objects[9] != null ? objects[9].toString() : "");
		result.setCategoryImageUrl(objects[10] != null ? objects[10].toString() : "");
		result.setSubStatus(objects[12] != null ? objects[12].toString() : "");
		result.setVersion(objects[13] != null ? Integer.valueOf(objects[13].toString()) : 0);
		return result;
	}

	public static List<ChangeStatusDTO> toDTOs(Collection<Object[]> equipments) {
		if (equipments == null) {
			return null;
		}
		List<ChangeStatusDTO> results = new ArrayList<ChangeStatusDTO>();
		for (Object[] each : equipments) {
			results.add(toDTO(each));
		}
		return results;
	}
}

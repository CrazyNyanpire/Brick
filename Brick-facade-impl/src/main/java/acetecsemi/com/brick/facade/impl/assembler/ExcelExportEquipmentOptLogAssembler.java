package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;

public class ExcelExportEquipmentOptLogAssembler {

	public static ExcelExportEquipmentOptionLogDTO toDTO(Object[] objects) {
		if (objects == null) {
			return null;
		}
		ExcelExportEquipmentOptionLogDTO result = new ExcelExportEquipmentOptionLogDTO();
		result.setProductModel(objects[0] != null ? objects[0].toString() : "");
		result.setNowlot(objects[1] != null ? objects[1].toString() : "");
		result.setStatus(objects[2] != null ? objects[2].toString() : "");
		result.setSubStatus(objects[3] != null ? objects[3].toString() : "");
		result.setStartTime(objects[4] != null ? objects[4].toString() : "");
		result.setEndTime(objects[5] != null ? objects[5].toString() : "");
		result.setDuration(objects[6] != null ? Long.valueOf(objects[6].toString()) : 0);
		result.setDuration(Math.round(result.getDuration()/60000.0));
		result.setEquipmentNo(objects[7] != null ? objects[7].toString() : "");
		result.setCategoryName(objects[8] != null ? objects[8].toString() : "");
		result.setOptRemark(objects[9] != null ? objects[9].toString() : "");
		return result;
	}

	public static List<ExcelExportEquipmentOptionLogDTO> toDTOs(Collection<Object[]> equipments) {
		if (equipments == null) {
			return null;
		}
		List<ExcelExportEquipmentOptionLogDTO> results = new ArrayList<ExcelExportEquipmentOptionLogDTO>();
		for (Object[] each : equipments) {
			results.add(toDTO(each));
		}
		return results;
	}
}

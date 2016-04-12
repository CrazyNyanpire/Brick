package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class MaintenanceEquipmentAssembler {
	
	public static MaintenanceEquipmentDTO  toDTO(MaintenanceEquipment  maintenanceEquipment){
		if (maintenanceEquipment == null) {
			return null;
		}
		MaintenanceEquipmentDTO result  = new MaintenanceEquipmentDTO();
	    	result.setId (maintenanceEquipment.getId());
     	    	result.setVersion (maintenanceEquipment.getVersion());
     	    	result.setCreateTimestamp (maintenanceEquipment.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (maintenanceEquipment.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (maintenanceEquipment.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (maintenanceEquipment.getLastModifyEmployNo());
     	    	result.setCategory (maintenanceEquipment.getCategory());
     	    	result.setOptType (maintenanceEquipment.getOptType());
     	    	result.setOptUser (maintenanceEquipment.getOptUser());
     	    	result.setOptDate (maintenanceEquipment.getOptDate());
     	    	result.setRemark (maintenanceEquipment.getRemark());
     	    	result.setFileUrl (maintenanceEquipment.getFileUrl());
     	    	//result.setEquipment (maintenanceEquipment.getEquipment());
     	    return result;
	 }
	
	public static List<MaintenanceEquipmentDTO>  toDTOs(Collection<MaintenanceEquipment>  maintenanceEquipments){
		if (maintenanceEquipments == null) {
			return null;
		}
		List<MaintenanceEquipmentDTO> results = new ArrayList<MaintenanceEquipmentDTO>();
		for (MaintenanceEquipment each : maintenanceEquipments) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static MaintenanceEquipment  toEntity(MaintenanceEquipmentDTO  equipmentDTO){
	 	if (equipmentDTO == null) {
			return null;
		}
	 	MaintenanceEquipment result  = new MaintenanceEquipment();
        result.setId (equipmentDTO.getId());
         result.setVersion (equipmentDTO.getVersion());
         //result.setCreateTimestamp (equipmentDTO.getCreateTimestamp());
         //result.setLastModifyTimestamp (equipmentDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (equipmentDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (equipmentDTO.getLastModifyEmployNo());
         result.setCategory (equipmentDTO.getCategory());
         result.setOptType (equipmentDTO.getOptType());
         result.setOptUser (equipmentDTO.getOptUser());
         result.setOptDate (equipmentDTO.getOptDate());
         result.setRemark (equipmentDTO.getRemark());
         result.setFileUrl (equipmentDTO.getFileUrl());
         //result.setEquipment (equipmentDTO.getEquipment());
 	  	return result;
	 }
	
	public static List<MaintenanceEquipment> toEntities(Collection<MaintenanceEquipmentDTO> equipmentDTOs) {
		if (equipmentDTOs == null) {
			return null;
		}
		
		List<MaintenanceEquipment> results = new ArrayList<MaintenanceEquipment>();
		for (MaintenanceEquipmentDTO each : equipmentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

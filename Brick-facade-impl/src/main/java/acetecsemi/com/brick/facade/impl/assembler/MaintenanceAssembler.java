package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class MaintenanceAssembler {
	
	public static MaintenanceDTO  toDTO(Maintenance  maintenance){
		if (maintenance == null) {
			return null;
		}
    	MaintenanceDTO result  = new MaintenanceDTO();
	    	result.setId (maintenance.getId());
     	    	result.setVersion (maintenance.getVersion());
     	    	result.setCreateTimestamp (maintenance.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (maintenance.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (maintenance.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (maintenance.getLastModifyEmployNo());
     	    	result.setCategory (maintenance.getCategory());
     	    	result.setOptType (maintenance.getOptType());
     	    	result.setOptUser (maintenance.getOptUser());
     	    	result.setOptDate (maintenance.getOptDate());
     	    	result.setRemark (maintenance.getRemark());
     	    	result.setFileUrl (maintenance.getFileUrl());
     	    return result;
	 }
	
	public static List<MaintenanceDTO>  toDTOs(Collection<Maintenance>  maintenances){
		if (maintenances == null) {
			return null;
		}
		List<MaintenanceDTO> results = new ArrayList<MaintenanceDTO>();
		for (Maintenance each : maintenances) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static Maintenance  toEntity(MaintenanceDTO  maintenanceDTO){
	 	if (maintenanceDTO == null) {
			return null;
		}
	 	Maintenance result  = new Maintenance();
        result.setId (maintenanceDTO.getId());
         result.setVersion (maintenanceDTO.getVersion());
         //result.setCreateTimestamp (maintenanceDTO.getCreateTimestamp());
         //result.setLastModifyTimestamp (maintenanceDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (maintenanceDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (maintenanceDTO.getLastModifyEmployNo());
         result.setCategory (maintenanceDTO.getCategory());
         result.setOptType (maintenanceDTO.getOptType());
         result.setOptUser (maintenanceDTO.getOptUser());
         result.setOptDate (maintenanceDTO.getOptDate());
         result.setRemark (maintenanceDTO.getRemark());
         result.setFileUrl (maintenanceDTO.getFileUrl());
 	  	return result;
	 }
	
	public static List<Maintenance> toEntities(Collection<MaintenanceDTO> maintenanceDTOs) {
		if (maintenanceDTOs == null) {
			return null;
		}
		
		List<Maintenance> results = new ArrayList<Maintenance>();
		for (MaintenanceDTO each : maintenanceDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

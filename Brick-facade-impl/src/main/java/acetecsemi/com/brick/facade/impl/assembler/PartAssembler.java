package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PartAssembler {
	
	public static PartDTO  toDTO(Part  part){
		if (part == null) {
			return null;
		}
    	PartDTO result  = new PartDTO();
	    	result.setId (part.getId());
     	    	result.setVersion (part.getVersion());
     	    	result.setCreateTimestamp (part.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (part.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (part.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (part.getLastModifyEmployNo());
     	    	result.setCategory (part.getCategory());
     	    	result.setPartNo (part.getPartNo());
     	    	result.setPartName (part.getPartName());
     	    	result.setEquipmentList (part.getEquipmentList());
     	    	result.setPartType (part.getPartType());
     	    	result.setPartModel (part.getPartModel());
     	    	result.setInDate (part.getInDate());
     	    	result.setPartLocaltion (part.getPartLocaltion());
     	    	result.setOwnership (part.getOwnership());
     	    	result.setRemark (part.getRemark());
     	    return result;
	 }
	
	public static List<PartDTO>  toDTOs(Collection<Part>  parts){
		if (parts == null) {
			return null;
		}
		List<PartDTO> results = new ArrayList<PartDTO>();
		for (Part each : parts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static Part  toEntity(PartDTO  partDTO){
	 	if (partDTO == null) {
			return null;
		}
	 	Part result  = new Part();
        result.setId (partDTO.getId());
         result.setVersion (partDTO.getVersion());
         //result.setCreateTimestamp (partDTO.getCreateTimestamp());
         //result.setLastModifyTimestamp (partDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (partDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (partDTO.getLastModifyEmployNo());
         result.setCategory (partDTO.getCategory());
         result.setPartNo (partDTO.getPartNo());
         result.setPartName (partDTO.getPartName());
         result.setEquipmentList (partDTO.getEquipmentList());
         result.setPartType (partDTO.getPartType());
         result.setPartModel (partDTO.getPartModel());
         result.setInDate (partDTO.getInDate());
         result.setPartLocaltion (partDTO.getPartLocaltion());
         result.setOwnership (partDTO.getOwnership());
         result.setRemark (partDTO.getRemark());
 	  	return result;
	 }
	
	public static List<Part> toEntities(Collection<PartDTO> partDTOs) {
		if (partDTOs == null) {
			return null;
		}
		
		List<Part> results = new ArrayList<Part>();
		for (PartDTO each : partDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

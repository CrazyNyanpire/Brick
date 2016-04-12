package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class NormalPartAssembler {
	
	public static NormalPartDTO  toDTO(NormalPart  normalPart){
		if (normalPart == null) {
			return null;
		}
    	NormalPartDTO result  = new NormalPartDTO();
	    	result.setId (normalPart.getId());
     	    	result.setVersion (normalPart.getVersion());
     	    	result.setCreateTimestamp (normalPart.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (normalPart.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (normalPart.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (normalPart.getLastModifyEmployNo());
     	    	result.setLogic (normalPart.getLogic());
     	    	result.setInDate (normalPart.getInDate());
     	    	result.setPartName (normalPart.getPartName());
     	    	result.setSerialNumber (normalPart.getSerialNumber());
     	    	result.setEquipment (normalPart.getEquipment());
     	    	result.setStatus (normalPart.getStatus());
     	    	result.setWarrantyPeriod (normalPart.getWarrantyPeriod());
     	    	result.setManufacturer (normalPart.getManufacturer());
     	    	result.setType (normalPart.getType());
     	    	result.setRemark (normalPart.getRemark());
     	    	result.setLocation (normalPart.getLocation());
     	    	result.setSlotSite (normalPart.getSlotSite());
     	    	result.setPropertyNumber (normalPart.getPropertyNumber());
     	    	result.setQuantity (normalPart.getQuantity());
     	    	result.setPartType (normalPart.getPartType());
     	    	result.setPartRevision (normalPart.getPartRevision());
     	    	result.setPartConfig (normalPart.getPartConfig());
     	    return result;
	 }
	
	public static List<NormalPartDTO>  toDTOs(Collection<NormalPart>  normalParts){
		if (normalParts == null) {
			return null;
		}
		List<NormalPartDTO> results = new ArrayList<NormalPartDTO>();
		for (NormalPart each : normalParts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static NormalPart  toEntity(NormalPartDTO  normalPartDTO){
	 	if (normalPartDTO == null) {
			return null;
		}
	 	NormalPart result  = new NormalPart();
        result.setId (normalPartDTO.getId());
         result.setVersion (normalPartDTO.getVersion());
         result.setCreateTimestamp (normalPartDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (normalPartDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (normalPartDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (normalPartDTO.getLastModifyEmployNo());
         result.setLogic (normalPartDTO.getLogic());
         result.setInDate (normalPartDTO.getInDate());
         result.setPartName (normalPartDTO.getPartName());
         result.setSerialNumber (normalPartDTO.getSerialNumber());
         result.setEquipment (normalPartDTO.getEquipment());
         result.setStatus (normalPartDTO.getStatus());
         result.setWarrantyPeriod (normalPartDTO.getWarrantyPeriod());
         result.setManufacturer (normalPartDTO.getManufacturer());
         result.setType (normalPartDTO.getType());
         result.setRemark (normalPartDTO.getRemark());
         result.setLocation (normalPartDTO.getLocation());
         result.setSlotSite (normalPartDTO.getSlotSite());
         result.setPropertyNumber (normalPartDTO.getPropertyNumber());
         result.setQuantity (normalPartDTO.getQuantity());
         result.setPartType (normalPartDTO.getPartType());
         result.setPartRevision (normalPartDTO.getPartRevision());
         result.setPartConfig (normalPartDTO.getPartConfig());
 	  	return result;
	 }
	
	public static List<NormalPart> toEntities(Collection<NormalPartDTO> normalPartDTOs) {
		if (normalPartDTOs == null) {
			return null;
		}
		
		List<NormalPart> results = new ArrayList<NormalPart>();
		for (NormalPartDTO each : normalPartDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

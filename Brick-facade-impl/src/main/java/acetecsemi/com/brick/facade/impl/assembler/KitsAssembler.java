package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class KitsAssembler {
	
	public static KitsDTO  toDTO(Kits  kits){
		if (kits == null) {
			return null;
		}
		KitsDTO result  = new KitsDTO();
	    	result.setId (kits.getId());
     	    	result.setVersion (kits.getVersion());
     	    	result.setCreateTimestamp (kits.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (kits.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (kits.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (kits.getLastModifyEmployNo());
     	    	result.setLogic (kits.getLogic());
     	    	result.setCategory (kits.getCategory());
     	    	result.setPartNo (kits.getPartNo());
     	    	result.setPartName (kits.getPartName());
     	    	result.setEquipmentList (kits.getEquipmentList());
     	    	result.setPartType (kits.getPartType());
     	    	result.setPartModel (kits.getPartModel());
     	    	result.setProductModel (kits.getProductModel());
     	    	result.setNowProductModel (kits.getNowProductModel());
     	    	result.setInDate (kits.getInDate());
     	    	result.setPartLocaltion (kits.getPartLocaltion());
     	    	result.setManufacturerNo (kits.getManufacturerNo());
     	    	result.setManufacturerName (kits.getManufacturerName());
     	    	result.setCustomerName (kits.getCustomerName());
     	    	result.setCustomerNameEn (kits.getCustomerNameEn());
     	    	result.setOwnership (kits.getOwnership());
     	    	//result.setStatus (kits.getStatus());
     			if (kits.getStatus() != null) {
     				result.setStatus(kits.getStatus().getCategoryName());
     				result.setStatusId(kits.getStatus().getId());
     			}
     	    	result.setRemark (kits.getRemark());
     	    	//result.setEquipment (kits.getEquipment());
     	    	//result.setNowPlatform (kits.getNowPlatform());
     	    	result.setPn (kits.getPn());
     	    	result.setSupplier (kits.getSupplier());
     	    	result.setApplicableModels (kits.getApplicableModels());
     	    	result.setLastFileUrl (kits.getLastFileUrl());
     	    	result.setTouchTimeTotal (kits.getTouchTimeTotal());
     	    	result.setAppearanceLevel (kits.getAppearanceLevel());
     	    	result.setEquipmentListId (kits.getEquipmentListId());
     	    return result;
	 }
	
	public static List<KitsDTO>  toDTOs(Collection<Kits>  kitss){
		if (kitss == null) {
			return null;
		}
		List<KitsDTO> results = new ArrayList<KitsDTO>();
		for (Kits each : kitss) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static Kits  toEntity(KitsDTO  kitsDTO){
	 	if (kitsDTO == null) {
			return null;
		}
	 	Kits result  = new Kits();
        result.setId (kitsDTO.getId());
         result.setVersion (kitsDTO.getVersion());
         result.setCreateTimestamp (kitsDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (kitsDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (kitsDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (kitsDTO.getLastModifyEmployNo());
         result.setLogic (kitsDTO.getLogic());
         result.setCategory (kitsDTO.getCategory());
         result.setPartNo (kitsDTO.getPartNo());
         result.setPartName (kitsDTO.getPartName());
         result.setEquipmentList (kitsDTO.getEquipmentList());
         result.setPartType (kitsDTO.getPartType());
         result.setPartModel (kitsDTO.getPartModel());
         result.setProductModel (kitsDTO.getProductModel());
         result.setNowProductModel (kitsDTO.getNowProductModel());
         result.setInDate (kitsDTO.getInDate());
         result.setPartLocaltion (kitsDTO.getPartLocaltion());
         result.setManufacturerNo (kitsDTO.getManufacturerNo());
         result.setManufacturerName (kitsDTO.getManufacturerName());
         result.setCustomerName (kitsDTO.getCustomerName());
         result.setCustomerNameEn (kitsDTO.getCustomerNameEn());
         result.setOwnership (kitsDTO.getOwnership());
        //result.setStatus (kitsDTO.getStatus());
         result.setRemark (kitsDTO.getRemark());
         //result.setEquipment (kitsDTO.getEquipment());
         //result.setNowPlatform (kitsDTO.getNowPlatform());
         result.setPn (kitsDTO.getPn());
         result.setSupplier (kitsDTO.getSupplier());
         result.setApplicableModels (kitsDTO.getApplicableModels());
         result.setLastFileUrl (kitsDTO.getLastFileUrl());
         result.setTouchTimeTotal (kitsDTO.getTouchTimeTotal());
         result.setAppearanceLevel (kitsDTO.getAppearanceLevel());
         result.setEquipmentListId (kitsDTO.getEquipmentListId());
 	  	return result;
	 }
	
	public static List<Kits> toEntities(Collection<KitsDTO> kitsDTOs) {
		if (kitsDTOs == null) {
			return null;
		}
		
		List<Kits> results = new ArrayList<Kits>();
		for (KitsDTO each : kitsDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

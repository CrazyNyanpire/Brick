package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class LoadBoardAssembler {
	
	public static LoadBoardDTO  toDTO(LoadBoard  loadBoard){
		if (loadBoard == null) {
			return null;
		}
    	LoadBoardDTO result  = new LoadBoardDTO();
	    	result.setId (loadBoard.getId());
     	    	result.setVersion (loadBoard.getVersion());
     	    	result.setCreateTimestamp (loadBoard.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (loadBoard.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (loadBoard.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (loadBoard.getLastModifyEmployNo());
     	    	result.setLogic (loadBoard.getLogic());
     	    	result.setCategory (loadBoard.getCategory());
     	    	result.setPartNo (loadBoard.getPartNo());
     	    	result.setPartName (loadBoard.getPartName());
     	    	result.setEquipmentList (loadBoard.getEquipmentList());
     	    	result.setPartType (loadBoard.getPartType());
     	    	result.setPartModel (loadBoard.getPartModel());
     	    	result.setProductModel (loadBoard.getProductModel());
     	    	result.setNowProductModel (loadBoard.getNowProductModel());
     	    	result.setInDate (loadBoard.getInDate());
     	    	result.setPartLocaltion (loadBoard.getPartLocaltion());
     	    	result.setManufacturerNo (loadBoard.getManufacturerNo());
     	    	result.setManufacturerName (loadBoard.getManufacturerName());
     	    	result.setCustomerName (loadBoard.getCustomerName());
     	    	result.setCustomerNameEn (loadBoard.getCustomerNameEn());
     	    	result.setOwnership (loadBoard.getOwnership());
     	    	//result.setStatus (loadBoard.getStatus());
     	    	if (loadBoard.getStatus() != null) {
     				result.setStatus(loadBoard.getStatus().getCategoryName());
     				result.setStatusId(loadBoard.getStatus().getId());
     			}
     	    	result.setRemark (loadBoard.getRemark());
     	    	//result.setEquipment (loadBoard.getEquipment());
     	    	//result.setNowPlatform (loadBoard.getNowPlatform());
     	    	result.setPn (loadBoard.getPn());
     	    	result.setSupplier (loadBoard.getSupplier());
     	    	result.setApplicableModels (loadBoard.getApplicableModels());
     	    	result.setLastFileUrl (loadBoard.getLastFileUrl());
     	    	result.setTouchTimeTotal (loadBoard.getTouchTimeTotal());
     	    	result.setAppearanceLevel (loadBoard.getAppearanceLevel());
     	    	result.setEquipmentListId (loadBoard.getEquipmentListId());
     	    return result;
	 }
	
	public static List<LoadBoardDTO>  toDTOs(Collection<LoadBoard>  loadBoards){
		if (loadBoards == null) {
			return null;
		}
		List<LoadBoardDTO> results = new ArrayList<LoadBoardDTO>();
		for (LoadBoard each : loadBoards) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static LoadBoard  toEntity(LoadBoardDTO  LoadBoardDTO){
	 	if (LoadBoardDTO == null) {
			return null;
		}
	 	LoadBoard result  = new LoadBoard();
        result.setId (LoadBoardDTO.getId());
         result.setVersion (LoadBoardDTO.getVersion());
         result.setCreateTimestamp (LoadBoardDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (LoadBoardDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (LoadBoardDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (LoadBoardDTO.getLastModifyEmployNo());
         result.setLogic (LoadBoardDTO.getLogic());
         result.setCategory (LoadBoardDTO.getCategory());
         result.setPartNo (LoadBoardDTO.getPartNo());
         result.setPartName (LoadBoardDTO.getPartName());
         result.setEquipmentList (LoadBoardDTO.getEquipmentList());
         result.setPartType (LoadBoardDTO.getPartType());
         result.setPartModel (LoadBoardDTO.getPartModel());
         result.setProductModel (LoadBoardDTO.getProductModel());
         result.setNowProductModel (LoadBoardDTO.getNowProductModel());
         result.setInDate (LoadBoardDTO.getInDate());
         result.setPartLocaltion (LoadBoardDTO.getPartLocaltion());
         result.setManufacturerNo (LoadBoardDTO.getManufacturerNo());
         result.setManufacturerName (LoadBoardDTO.getManufacturerName());
         result.setCustomerName (LoadBoardDTO.getCustomerName());
         result.setCustomerNameEn (LoadBoardDTO.getCustomerNameEn());
         result.setOwnership (LoadBoardDTO.getOwnership());
         //result.setStatus (LoadBoardDTO.getStatus());
         result.setRemark (LoadBoardDTO.getRemark());
         //result.setEquipment (LoadBoardDTO.getEquipment());
         //result.setNowPlatform (LoadBoardDTO.getNowPlatform());
         result.setPn (LoadBoardDTO.getPn());
         result.setSupplier (LoadBoardDTO.getSupplier());
         result.setApplicableModels (LoadBoardDTO.getApplicableModels());
         result.setLastFileUrl (LoadBoardDTO.getLastFileUrl());
         result.setTouchTimeTotal (LoadBoardDTO.getTouchTimeTotal());
         result.setAppearanceLevel (LoadBoardDTO.getAppearanceLevel());
         result.setEquipmentListId (LoadBoardDTO.getEquipmentListId());
 	  	return result;
	 }
	
	public static List<LoadBoard> toEntities(Collection<LoadBoardDTO> loadBoardDTOs) {
		if (loadBoardDTOs == null) {
			return null;
		}
		
		List<LoadBoard> results = new ArrayList<LoadBoard>();
		for (LoadBoardDTO each : loadBoardDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

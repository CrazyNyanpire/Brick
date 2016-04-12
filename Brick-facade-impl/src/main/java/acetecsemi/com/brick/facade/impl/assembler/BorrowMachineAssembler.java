package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class BorrowMachineAssembler {
	
	public static BorrowMachineDTO  toDTO(BorrowMachine  borrowMachine){
		if (borrowMachine == null) {
			return null;
		}
    	BorrowMachineDTO result  = new BorrowMachineDTO();
	    	result.setId (borrowMachine.getId());
     	    	result.setVersion (borrowMachine.getVersion());
     	    	result.setCreateTimestamp (borrowMachine.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (borrowMachine.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (borrowMachine.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (borrowMachine.getLastModifyEmployNo());
     	    	result.setState (borrowMachine.getState());
     	    	result.setProposer (borrowMachine.getProposer());
     	    	result.setDepartment (borrowMachine.getDepartment());
     	    	result.setType (borrowMachine.getType());
     	    	result.setAppTime (borrowMachine.getAppTime());
     	    	result.setEquipName (borrowMachine.getEquipName());
     	    	result.setEstimatedStartTime (borrowMachine.getEstimatedStartTime());
     	    	result.setEstimatedEndTime (borrowMachine.getEstimatedEndTime());
     	    	result.setEstimatedTime (borrowMachine.getEstimatedTime());
     	    	result.setBorrowNumber (borrowMachine.getBorrowNumber());
     	    	result.setActualBeginTime (borrowMachine.getActualBeginTime());
     	    	result.setActualEndTime (borrowMachine.getActualEndTime());
     	    	result.setActualTime (borrowMachine.getActualTime());
     	    	result.setApprover (borrowMachine.getApprover());
     	    	result.setCompany (borrowMachine.getCompany());
     	    	result.setRemark (borrowMachine.getRemark());
     	    	if(borrowMachine.getIsPlatform()){
     	    		result.setPlatformName(borrowMachine.getPlatform().getTester().getEquipmentNo());
         	    	result.setPlatformId(borrowMachine.getPlatform().getId());
         	    	result.setPlatformEquipId(borrowMachine.getPlatformEquipId());
     	    	}else{
     	    		result.setPlatformName(borrowMachine.getEquipment().getEquipmentNo());
         	    	result.setPlatformId(borrowMachine.getEquipment().getId());
     	    	}
     	    return result;
	 }
	
	public static List<BorrowMachineDTO>  toDTOs(Collection<BorrowMachine>  borrowMachines){
		if (borrowMachines == null) {
			return null;
		}
		List<BorrowMachineDTO> results = new ArrayList<BorrowMachineDTO>();
		for (BorrowMachine each : borrowMachines) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static BorrowMachine  toEntity(BorrowMachineDTO  borrowMachineDTO){
	 	if (borrowMachineDTO == null) {
			return null;
		}
	 	BorrowMachine result  = new BorrowMachine();
        result.setId (borrowMachineDTO.getId());
         result.setVersion (borrowMachineDTO.getVersion());
         //result.setCreateTimestamp (borrowMachineDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (borrowMachineDTO.getLastModifyTimestamp());
         //result.setCreateEmployNo (borrowMachineDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (borrowMachineDTO.getLastModifyEmployNo());
         result.setState (borrowMachineDTO.getState());
         result.setProposer (borrowMachineDTO.getProposer());
         result.setDepartment (borrowMachineDTO.getDepartment());
         result.setType (borrowMachineDTO.getType());
         result.setAppTime (borrowMachineDTO.getAppTime());
         result.setEquipName (borrowMachineDTO.getEquipName());
         result.setEstimatedStartTime (borrowMachineDTO.getEstimatedStartTime());
         result.setEstimatedEndTime (borrowMachineDTO.getEstimatedEndTime());
         result.setEstimatedTime (borrowMachineDTO.getEstimatedTime());
         result.setBorrowNumber (borrowMachineDTO.getBorrowNumber());
         result.setActualBeginTime (borrowMachineDTO.getActualBeginTime());
         result.setActualEndTime (borrowMachineDTO.getActualEndTime());
         result.setActualTime (borrowMachineDTO.getActualTime());
         result.setApprover (borrowMachineDTO.getApprover());
         result.setCompany (borrowMachineDTO.getCompany());
         result.setRemark (borrowMachineDTO.getRemark());
         result.setIsPlatform(borrowMachineDTO.getIsPlatform());
         result.setPlatformEquipId(borrowMachineDTO.getPlatformEquipId());
 	  	return result;
	 }
	
	public static List<BorrowMachine> toEntities(Collection<BorrowMachineDTO> borrowMachineDTOs) {
		if (borrowMachineDTOs == null) {
			return null;
		}
		
		List<BorrowMachine> results = new ArrayList<BorrowMachine>();
		for (BorrowMachineDTO each : borrowMachineDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

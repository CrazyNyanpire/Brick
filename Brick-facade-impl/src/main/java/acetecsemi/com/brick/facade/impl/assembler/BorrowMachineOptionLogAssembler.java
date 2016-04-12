package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class BorrowMachineOptionLogAssembler {
	
	public static BorrowMachineOptionLogDTO  toDTO(BorrowMachineOptionLog  borrowMachineOptionLog){
		if (borrowMachineOptionLog == null) {
			return null;
		}
		BorrowMachineOptionLogDTO result  = new BorrowMachineOptionLogDTO();
	    	result.setId (borrowMachineOptionLog.getId());
     	    	result.setVersion (borrowMachineOptionLog.getVersion());
     	    	result.setCreateTimestamp (borrowMachineOptionLog.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (borrowMachineOptionLog.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (borrowMachineOptionLog.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (borrowMachineOptionLog.getLastModifyEmployNo());
     	    	result.setStatus (borrowMachineOptionLog.getStatus());
     	    	result.setOptUser (borrowMachineOptionLog.getOptUser());
     	    	result.setOptDate (borrowMachineOptionLog.getOptDate());
     	    	result.setRemark (borrowMachineOptionLog.getRemark());
     	    	//result.setBorrowMachine (borrowMachineOptionLog.getBorrowMachine());
     	    return result;
	 }
	
	public static List<BorrowMachineOptionLogDTO>  toDTOs(Collection<BorrowMachineOptionLog>  borrowMachineOptionLogs){
		if (borrowMachineOptionLogs == null) {
			return null;
		}
		List<BorrowMachineOptionLogDTO> results = new ArrayList<BorrowMachineOptionLogDTO>();
		for (BorrowMachineOptionLog each : borrowMachineOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static BorrowMachineOptionLog  toEntity(BorrowMachineOptionLogDTO  borrowMachineDTO){
	 	if (borrowMachineDTO == null) {
			return null;
		}
	 	BorrowMachineOptionLog result  = new BorrowMachineOptionLog();
        result.setId (borrowMachineDTO.getId());
         result.setVersion (borrowMachineDTO.getVersion());
         result.setCreateTimestamp (borrowMachineDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (borrowMachineDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (borrowMachineDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (borrowMachineDTO.getLastModifyEmployNo());
         result.setStatus (borrowMachineDTO.getStatus());
         result.setOptUser (borrowMachineDTO.getOptUser());
         result.setOptDate (borrowMachineDTO.getOptDate());
         result.setRemark (borrowMachineDTO.getRemark());
         //result.setBorrowMachine (borrowMachineDTO.getBorrowMachine());
 	  	return result;
	 }
	
	public static List<BorrowMachineOptionLog> toEntities(Collection<BorrowMachineOptionLogDTO> borrowMachineDTOs) {
		if (borrowMachineDTOs == null) {
			return null;
		}
		
		List<BorrowMachineOptionLog> results = new ArrayList<BorrowMachineOptionLog>();
		for (BorrowMachineOptionLogDTO each : borrowMachineDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

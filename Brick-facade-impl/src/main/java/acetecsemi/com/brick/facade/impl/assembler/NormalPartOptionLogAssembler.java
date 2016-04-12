package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class NormalPartOptionLogAssembler {
	
	public static NormalPartOptionLogDTO  toDTO(NormalPartOptionLog  normalPartOptionLog){
		if (normalPartOptionLog == null) {
			return null;
		}
    	NormalPartOptionLogDTO result  = new NormalPartOptionLogDTO();
	    	result.setId (normalPartOptionLog.getId());
     	    	result.setVersion (normalPartOptionLog.getVersion());
     	    	result.setCreateTimestamp (normalPartOptionLog.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (normalPartOptionLog.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (normalPartOptionLog.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (normalPartOptionLog.getLastModifyEmployNo());
     	    	result.setLogic (normalPartOptionLog.getLogic());
     	    	result.setStatus (normalPartOptionLog.getStatus());
     	    	result.setRemark (normalPartOptionLog.getRemark());
     	    	result.setPath(normalPartOptionLog.getPath());
     	    	result.setPartName(NormalPartAssembler.toDTO(normalPartOptionLog.getNormalPart()).getPartName());
     	    	result.setNormalPartDTO(NormalPartAssembler.toDTO(normalPartOptionLog.getNormalPart()));
     	    return result;
	 }
	
	public static List<NormalPartOptionLogDTO>  toDTOs(Collection<NormalPartOptionLog>  normalPartOptionLogs){
		if (normalPartOptionLogs == null) {
			return null;
		}
		List<NormalPartOptionLogDTO> results = new ArrayList<NormalPartOptionLogDTO>();
		for (NormalPartOptionLog each : normalPartOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static NormalPartOptionLog  toEntity(NormalPartOptionLogDTO  normalPartOptionLogDTO){
	 	if (normalPartOptionLogDTO == null) {
			return null;
		}
	 	NormalPartOptionLog result  = new NormalPartOptionLog();
        //result.setId (normalPartOptionLogDTO.getId());
         result.setVersion (normalPartOptionLogDTO.getVersion());
         result.setCreateTimestamp (normalPartOptionLogDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (normalPartOptionLogDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (normalPartOptionLogDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (normalPartOptionLogDTO.getLastModifyEmployNo());
         result.setLogic (normalPartOptionLogDTO.getLogic());
         result.setStatus (normalPartOptionLogDTO.getStatus());
         result.setRemark (normalPartOptionLogDTO.getRemark());
         result.setPath(normalPartOptionLogDTO.getPath());
         result.setNormalPart(NormalPartAssembler.toEntity(normalPartOptionLogDTO.getNormalPartDTO()));
 	  	return result;
	 }
	
	public static List<NormalPartOptionLog> toEntities(Collection<NormalPartOptionLogDTO> normalPartOptionLogs) {
		if (normalPartOptionLogs == null) {
			return null;
		}
		
		List<NormalPartOptionLog> results = new ArrayList<NormalPartOptionLog>();
		for (NormalPartOptionLogDTO each : normalPartOptionLogs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

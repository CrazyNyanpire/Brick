package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class SocketReceivingReportAssembler {
	
	public static SocketReceivingReportDTO  toDTO(SocketReceivingReport  socketReceivingReport){
		if (socketReceivingReport == null) {
			return null;
		}
    	SocketReceivingReportDTO result  = new SocketReceivingReportDTO();
	    	result.setId (socketReceivingReport.getId());
     	    	result.setVersion (socketReceivingReport.getVersion());
     	    	result.setCreateTimestamp (socketReceivingReport.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (socketReceivingReport.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (socketReceivingReport.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (socketReceivingReport.getLastModifyEmployNo());
     	    	//result.setSocket (socketReceivingReport.getSocket());
     	    	result.setFileUrl (socketReceivingReport.getFileUrl());
     	    return result;
	 }
	
	public static List<SocketReceivingReportDTO>  toDTOs(Collection<SocketReceivingReport>  socketReceivingReports){
		if (socketReceivingReports == null) {
			return null;
		}
		List<SocketReceivingReportDTO> results = new ArrayList<SocketReceivingReportDTO>();
		for (SocketReceivingReport each : socketReceivingReports) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static SocketReceivingReport  toEntity(SocketReceivingReportDTO  socketDTO){
	 	if (socketDTO == null) {
			return null;
		}
	 	SocketReceivingReport result  = new SocketReceivingReport();
        result.setId (socketDTO.getId());
         result.setVersion (socketDTO.getVersion());
         result.setCreateTimestamp (socketDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (socketDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (socketDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (socketDTO.getLastModifyEmployNo());
         //result.setSocket (socketDTO.getSocket());
         result.setFileUrl (socketDTO.getFileUrl());
 	  	return result;
	 }
	
	public static List<SocketReceivingReport> toEntities(Collection<SocketReceivingReportDTO> socketDTOs) {
		if (socketDTOs == null) {
			return null;
		}
		
		List<SocketReceivingReport> results = new ArrayList<SocketReceivingReport>();
		for (SocketReceivingReportDTO each : socketDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class MailNoticeLogAssembler {
	
	public static MailNoticeLogDTO  toDTO(MailNoticeLog  mailNoticeLog){
		if (mailNoticeLog == null) {
			return null;
		}
    	MailNoticeLogDTO result  = new MailNoticeLogDTO();
	    	result.setId (mailNoticeLog.getId());
     	    	result.setVersion (mailNoticeLog.getVersion());
     	    	result.setCreateTimestamp (mailNoticeLog.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (mailNoticeLog.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (mailNoticeLog.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (mailNoticeLog.getLastModifyEmployNo());
     	    	result.setSubject (mailNoticeLog.getSubject());
     	    	result.setContent (mailNoticeLog.getContent());
     	    	result.setFromUser (mailNoticeLog.getFromUser());
     	    	result.setToUser (mailNoticeLog.getToUser());
     	    	result.setCc (mailNoticeLog.getCc());
     	    	result.setBcc (mailNoticeLog.getBcc());
     	    return result;
	 }
	
	public static List<MailNoticeLogDTO>  toDTOs(Collection<MailNoticeLog>  mailNoticeLogs){
		if (mailNoticeLogs == null) {
			return null;
		}
		List<MailNoticeLogDTO> results = new ArrayList<MailNoticeLogDTO>();
		for (MailNoticeLog each : mailNoticeLogs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static MailNoticeLog  toEntity(MailNoticeLogDTO  mailNoticeLogDTO){
	 	if (mailNoticeLogDTO == null) {
			return null;
		}
	 	MailNoticeLog result  = new MailNoticeLog();
        result.setId (mailNoticeLogDTO.getId());
         result.setVersion (mailNoticeLogDTO.getVersion());
         result.setCreateTimestamp (mailNoticeLogDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (mailNoticeLogDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (mailNoticeLogDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (mailNoticeLogDTO.getLastModifyEmployNo());
         result.setSubject (mailNoticeLogDTO.getSubject());
         result.setContent (mailNoticeLogDTO.getContent());
         result.setFromUser (mailNoticeLogDTO.getFromUser());
         result.setToUser (mailNoticeLogDTO.getToUser());
         result.setCc (mailNoticeLogDTO.getCc());
         result.setBcc (mailNoticeLogDTO.getBcc());
 	  	return result;
	 }
	
	public static List<MailNoticeLog> toEntities(Collection<MailNoticeLogDTO> mailNoticeLogDTOs) {
		if (mailNoticeLogDTOs == null) {
			return null;
		}
		
		List<MailNoticeLog> results = new ArrayList<MailNoticeLog>();
		for (MailNoticeLogDTO each : mailNoticeLogDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

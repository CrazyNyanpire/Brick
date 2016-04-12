package acetecsemi.com.brick.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;
import javax.inject.Inject;
import javax.inject.Named;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.MailNoticeLogAssembler;
import acetecsemi.com.brick.facade.MailNoticeLogFacade;
import acetecsemi.com.brick.application.MailNoticeLogApplication;

import acetecsemi.com.brick.core.domain.*;

@Named
public class MailNoticeLogFacadeImpl implements MailNoticeLogFacade {

	@Inject
	private MailNoticeLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getMailNoticeLog(Long id) {
		return InvokeResult.success(MailNoticeLogAssembler.toDTO(application.getMailNoticeLog(id)));
	}
	
	public InvokeResult creatMailNoticeLog(MailNoticeLogDTO mailNoticeLogDTO) {
		application.creatMailNoticeLog(MailNoticeLogAssembler.toEntity(mailNoticeLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateMailNoticeLog(MailNoticeLogDTO mailNoticeLogDTO) {
		application.updateMailNoticeLog(MailNoticeLogAssembler.toEntity(mailNoticeLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeMailNoticeLog(Long id) {
		application.removeMailNoticeLog(application.getMailNoticeLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeMailNoticeLogs(Long[] ids) {
		Set<MailNoticeLog> mailNoticeLogs= new HashSet<MailNoticeLog>();
		for (Long id : ids) {
			mailNoticeLogs.add(application.getMailNoticeLog(id));
		}
		application.removeMailNoticeLogs(mailNoticeLogs);
		return InvokeResult.success();
	}
	
	public List<MailNoticeLogDTO> findAllMailNoticeLog() {
		return MailNoticeLogAssembler.toDTOs(application.findAllMailNoticeLog());
	}
	
	public Page<MailNoticeLogDTO> pageQueryMailNoticeLog(MailNoticeLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _mailNoticeLog from MailNoticeLog _mailNoticeLog   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _mailNoticeLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _mailNoticeLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _mailNoticeLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _mailNoticeLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getSubject() != null && !"".equals(queryVo.getSubject())) {
	   		jpql.append(" and _mailNoticeLog.subject like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSubject()));
	   	}		
	   	if (queryVo.getContent() != null && !"".equals(queryVo.getContent())) {
	   		jpql.append(" and _mailNoticeLog.content like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getContent()));
	   	}		
	   	if (queryVo.getFromUser() != null && !"".equals(queryVo.getFromUser())) {
	   		jpql.append(" and _mailNoticeLog.from like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFromUser()));
	   	}		
	   	if (queryVo.getToUser() != null && !"".equals(queryVo.getToUser())) {
	   		jpql.append(" and _mailNoticeLog.to like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getToUser()));
	   	}		
	   	if (queryVo.getCc() != null && !"".equals(queryVo.getCc())) {
	   		jpql.append(" and _mailNoticeLog.cc like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCc()));
	   	}		
	   	if (queryVo.getBcc() != null && !"".equals(queryVo.getBcc())) {
	   		jpql.append(" and _mailNoticeLog.bcc like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getBcc()));
	   	}		
        Page<MailNoticeLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<MailNoticeLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, MailNoticeLogAssembler.toDTOs(pages.getData()));
	}
	
	
}

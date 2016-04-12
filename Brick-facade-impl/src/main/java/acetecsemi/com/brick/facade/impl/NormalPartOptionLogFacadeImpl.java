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
import acetecsemi.com.brick.facade.impl.assembler.NormalPartOptionLogAssembler;
import acetecsemi.com.brick.facade.NormalPartOptionLogFacade;
import acetecsemi.com.brick.application.NormalPartOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class NormalPartOptionLogFacadeImpl implements NormalPartOptionLogFacade {

	@Inject
	private NormalPartOptionLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getNormalPartOptionLog(Long id) {
		return InvokeResult.success(NormalPartOptionLogAssembler.toDTO(application.getNormalPartOptionLog(id)));
	}
	
	public InvokeResult creatNormalPartOptionLog(NormalPartOptionLogDTO normalPartOptionLogDTO) {
		application.creatNormalPartOptionLog(NormalPartOptionLogAssembler.toEntity(normalPartOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateNormalPartOptionLog(NormalPartOptionLogDTO normalPartOptionLogDTO) {
		application.updateNormalPartOptionLog(NormalPartOptionLogAssembler.toEntity(normalPartOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeNormalPartOptionLog(Long id) {
		application.removeNormalPartOptionLog(application.getNormalPartOptionLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeNormalPartOptionLogs(Long[] ids) {
		Set<NormalPartOptionLog> normalPartOptionLogs= new HashSet<NormalPartOptionLog>();
		for (Long id : ids) {
			normalPartOptionLogs.add(application.getNormalPartOptionLog(id));
		}
		application.removeNormalPartOptionLogs(normalPartOptionLogs);
		return InvokeResult.success();
	}
	
	public List<NormalPartOptionLogDTO> findAllNormalPartOptionLog() {
		return NormalPartOptionLogAssembler.toDTOs(application.findAllNormalPartOptionLog());
	}
	
	public Page<NormalPartOptionLogDTO> pageQueryNormalPartOptionLog(NormalPartOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _normalPartOptionLog from NormalPartOptionLog _normalPartOptionLog   where 1=1 ");
	   	if (queryVo.getPartId() != null) {
	   		jpql.append(" and _normalPartOptionLog.normalPart.id like ? ");
	   		conditionVals.add(queryVo.getPartId());
	   	}
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _normalPartOptionLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _normalPartOptionLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _normalPartOptionLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _normalPartOptionLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _normalPartOptionLog.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _normalPartOptionLog.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _normalPartOptionLog.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _normalPartOptionLog.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
        Page<NormalPartOptionLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<NormalPartOptionLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, NormalPartOptionLogAssembler.toDTOs(pages.getData()));
	}

	@Override
	public NormalPartDTO findNormalPartByNormalPartOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

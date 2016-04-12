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
import acetecsemi.com.brick.facade.impl.assembler.OvenEquipmentOptionLogAssembler;
import acetecsemi.com.brick.facade.OvenEquipmentOptionLogFacade;
import acetecsemi.com.brick.application.OvenEquipmentOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class OvenEquipmentOptionLogFacadeImpl implements OvenEquipmentOptionLogFacade {

	@Inject
	private OvenEquipmentOptionLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getOvenEquipmentOptionLog(Long id) {
		return InvokeResult.success(OvenEquipmentOptionLogAssembler.toDTO(application.getOvenEquipmentOptionLog(id)));
	}
	
	public InvokeResult creatOvenEquipmentOptionLog(OvenEquipmentOptionLogDTO ovenEquipmentOptionLogDTO) {
		application.creatOvenEquipmentOptionLog(OvenEquipmentOptionLogAssembler.toEntity(ovenEquipmentOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateOvenEquipmentOptionLog(OvenEquipmentOptionLogDTO ovenEquipmentOptionLogDTO) {
		application.updateOvenEquipmentOptionLog(OvenEquipmentOptionLogAssembler.toEntity(ovenEquipmentOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeOvenEquipmentOptionLog(Long id) {
		application.removeOvenEquipmentOptionLog(application.getOvenEquipmentOptionLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeOvenEquipmentOptionLogs(Long[] ids) {
		Set<OvenEquipmentOptionLog> ovenEquipmentOptionLogs= new HashSet<OvenEquipmentOptionLog>();
		for (Long id : ids) {
			ovenEquipmentOptionLogs.add(application.getOvenEquipmentOptionLog(id));
		}
		application.removeOvenEquipmentOptionLogs(ovenEquipmentOptionLogs);
		return InvokeResult.success();
	}
	
	public List<OvenEquipmentOptionLogDTO> findAllOvenEquipmentOptionLog() {
		return OvenEquipmentOptionLogAssembler.toDTOs(application.findAllOvenEquipmentOptionLog());
	}
	
	public Page<OvenEquipmentOptionLogDTO> pageQueryOvenEquipmentOptionLog(OvenEquipmentOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _ovenEquipmentOptionLog from OvenEquipmentOptionLog _ovenEquipmentOptionLog   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _ovenEquipmentOptionLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _ovenEquipmentOptionLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getSubStatus() != null && !"".equals(queryVo.getSubStatus())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.subStatus like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSubStatus()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _ovenEquipmentOptionLog.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.nowLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
	   	}		
	   	if (queryVo.getNowStation() != null && !"".equals(queryVo.getNowStation())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.nowStation like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowStation()));
	   	}		
	   	if (queryVo.getProductModel() != null && !"".equals(queryVo.getProductModel())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.productModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductModel()));
	   	}		
	   	if (queryVo.getStartTime() != null && !"".equals(queryVo.getStartTime())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.startTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartTime()));
	   	}		
	   	if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.endTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndTime()));
	   	}		
	   	if (queryVo.getDuration() != null && !"".equals(queryVo.getDuration())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.duration like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDuration()));
	   	}		
	   	if (queryVo.getEndOptUser() != null && !"".equals(queryVo.getEndOptUser())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.endOptUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndOptUser()));
	   	}		
	   	if (queryVo.getStandardWorkHours() != null && !"".equals(queryVo.getStandardWorkHours())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.standardWorkHours like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStandardWorkHours()));
	   	}		
	   	if (queryVo.getGrossDie() != null && !"".equals(queryVo.getGrossDie())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.grossDie like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGrossDie()));
	   	}		
	   	if (queryVo.getTheoryTime() != null && !"".equals(queryVo.getTheoryTime())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.theoryTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTheoryTime()));
	   	}		
	   	if (queryVo.getInkType() != null && !"".equals(queryVo.getInkType())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.inkType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getInkType()));
	   	}		
	   	if (queryVo.getTouchTimes() != null && !"".equals(queryVo.getTouchTimes())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.touchTimes like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTouchTimes()));
	   	}		
	   	if (queryVo.getTeam() != null && !"".equals(queryVo.getTeam())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.team like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTeam()));
	   	}		
	   	if (queryVo.getIsShift() != null && !"".equals(queryVo.getIsShift())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.isShift like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsShift()));
	   	}		
	   	if (queryVo.getOptRemark() != null && !"".equals(queryVo.getOptRemark())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.optRemark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptRemark()));
	   	}		
	   	if (queryVo.getProductNo() != null && !"".equals(queryVo.getProductNo())) {
	   		jpql.append(" and _ovenEquipmentOptionLog.productNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductNo()));
	   	}		
        Page<OvenEquipmentOptionLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<OvenEquipmentOptionLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, OvenEquipmentOptionLogAssembler.toDTOs(pages.getData()));
	}

	@Override
	public EquipmentDTO findEquipmentByOvenEquipmentOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

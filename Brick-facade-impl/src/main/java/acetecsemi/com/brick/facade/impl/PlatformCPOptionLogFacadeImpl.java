package acetecsemi.com.brick.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.PlatformCPOptionLogAssembler;
import acetecsemi.com.brick.facade.PlatformCPOptionLogFacade;
import acetecsemi.com.brick.application.PlatformCPOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PlatformCPOptionLogFacadeImpl implements PlatformCPOptionLogFacade {

	@Inject
	private PlatformCPOptionLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getPlatformCPOptionLog(Long id) {
		return InvokeResult.success(PlatformCPOptionLogAssembler.toDTO(application.getPlatformCPOptionLog(id)));
	}
	
	public InvokeResult creatPlatformCPOptionLog(PlatformCPOptionLogDTO platformCPOptionLogDTO) {
		application.creatPlatformCPOptionLog(PlatformCPOptionLogAssembler.toEntity(platformCPOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updatePlatformCPOptionLog(PlatformCPOptionLogDTO platformCPOptionLogDTO) {
		application.updatePlatformCPOptionLog(PlatformCPOptionLogAssembler.toEntity(platformCPOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removePlatformCPOptionLog(Long id) {
		application.removePlatformCPOptionLog(application.getPlatformCPOptionLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removePlatformCPOptionLogs(Long[] ids) {
		Set<PlatformCPOptionLog> platformCPOptionLogs= new HashSet<PlatformCPOptionLog>();
		for (Long id : ids) {
			platformCPOptionLogs.add(application.getPlatformCPOptionLog(id));
		}
		application.removePlatformCPOptionLogs(platformCPOptionLogs);
		return InvokeResult.success();
	}
	
	public List<PlatformCPOptionLogDTO> findAllPlatformCPOptionLog() {
		return PlatformCPOptionLogAssembler.toDTOs(application.findAllPlatformCPOptionLog());
	}
	
	public Page<PlatformCPOptionLogDTO> pageQueryPlatformCPOptionLog(PlatformCPOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _platformCPOptionLog from PlatformCPOptionLog _platformCPOptionLog   left join _platformCPOptionLog.equipment  where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _platformCPOptionLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _platformCPOptionLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _platformCPOptionLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _platformCPOptionLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _platformCPOptionLog.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _platformCPOptionLog.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getSubStatus() != null && !"".equals(queryVo.getSubStatus())) {
	   		jpql.append(" and _platformCPOptionLog.subStatus like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSubStatus()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _platformCPOptionLog.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _platformCPOptionLog.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
	   		jpql.append(" and _platformCPOptionLog.nowLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
	   	}		
	   	if (queryVo.getNowStation() != null && !"".equals(queryVo.getNowStation())) {
	   		jpql.append(" and _platformCPOptionLog.nowStation like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowStation()));
	   	}		
	   	if (queryVo.getProductModel() != null && !"".equals(queryVo.getProductModel())) {
	   		jpql.append(" and _platformCPOptionLog.productModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductModel()));
	   	}		
	   	if (queryVo.getStartTime() != null && !"".equals(queryVo.getStartTime())) {
	   		jpql.append(" and _platformCPOptionLog.startTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStartTime()));
	   	}		
	   	if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
	   		jpql.append(" and _platformCPOptionLog.endTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndTime()));
	   	}		
	   	if (queryVo.getDuration() != null && !"".equals(queryVo.getDuration())) {
	   		jpql.append(" and _platformCPOptionLog.duration like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDuration()));
	   	}		
	   	if (queryVo.getEndOptUser() != null && !"".equals(queryVo.getEndOptUser())) {
	   		jpql.append(" and _platformCPOptionLog.endOptUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndOptUser()));
	   	}		
	   	if (queryVo.getStandardWorkHours() != null && !"".equals(queryVo.getStandardWorkHours())) {
	   		jpql.append(" and _platformCPOptionLog.standardWorkHours like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStandardWorkHours()));
	   	}		
	   	if (queryVo.getGrossDie() != null && !"".equals(queryVo.getGrossDie())) {
	   		jpql.append(" and _platformCPOptionLog.grossDie like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getGrossDie()));
	   	}		
	   	if (queryVo.getTheoryTime() != null && !"".equals(queryVo.getTheoryTime())) {
	   		jpql.append(" and _platformCPOptionLog.theoryTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTheoryTime()));
	   	}		
	   	if (queryVo.getInkType() != null && !"".equals(queryVo.getInkType())) {
	   		jpql.append(" and _platformCPOptionLog.inkType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getInkType()));
	   	}		
	   	if (queryVo.getTouchTimes() != null && !"".equals(queryVo.getTouchTimes())) {
	   		jpql.append(" and _platformCPOptionLog.touchTimes like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTouchTimes()));
	   	}		
	   	if (queryVo.getTeam() != null && !"".equals(queryVo.getTeam())) {
	   		jpql.append(" and _platformCPOptionLog.team like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTeam()));
	   	}		
	   	if (queryVo.getIsShift() != null && !"".equals(queryVo.getIsShift())) {
	   		jpql.append(" and _platformCPOptionLog.isShift like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsShift()));
	   	}		
	   	if (queryVo.getOptRemark() != null && !"".equals(queryVo.getOptRemark())) {
	   		jpql.append(" and _platformCPOptionLog.optRemark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptRemark()));
	   	}		
	   	if (queryVo.getCompletedChip() != null && !"".equals(queryVo.getCompletedChip())) {
	   		jpql.append(" and _platformCPOptionLog.completedChip like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCompletedChip()));
	   	}		
	   	if (queryVo.getCompletedChipDescription() != null && !"".equals(queryVo.getCompletedChipDescription())) {
	   		jpql.append(" and _platformCPOptionLog.completedChipDescription like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCompletedChipDescription()));
	   	}		
	   	if (queryVo.getChipSelection() != null && !"".equals(queryVo.getChipSelection())) {
	   		jpql.append(" and _platformCPOptionLog.chipSelection like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChipSelection()));
	   	}		
	   	if (queryVo.getChipSelectionRemark() != null && !"".equals(queryVo.getChipSelectionRemark())) {
	   		jpql.append(" and _platformCPOptionLog.chipSelectionRemark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChipSelectionRemark()));
	   	}		
	   	if (queryVo.getPcNo() != null && !"".equals(queryVo.getPcNo())) {
	   		jpql.append(" and _platformCPOptionLog.pcNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPcNo()));
	   	}		
        Page<PlatformCPOptionLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<PlatformCPOptionLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, PlatformCPOptionLogAssembler.toDTOs(pages.getData()));
	}
	
	public EquipmentDTO findEquipmentByPlatformCPOptionLog(Long id) {
		String jpql = "select e from PlatformCPOptionLog o right join o.equipment e where o.id=?";
		Equipment result = (Equipment) getQueryChannelService().createJpqlQuery(jpql).setParameters(new Object[] { id }).singleResult();
		EquipmentDTO  dto = new EquipmentDTO();
		if (result != null) {
			try {
				BeanUtils.copyProperties(dto, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public PlatformDTO findPlatformByPlatformCPOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

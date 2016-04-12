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
import acetecsemi.com.brick.facade.impl.assembler.PartAssembler;
import acetecsemi.com.brick.facade.PartFacade;
import acetecsemi.com.brick.application.PartApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PartFacadeImpl implements PartFacade {

	@Inject
	private PartApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getPart(Long id) {
		return InvokeResult.success(PartAssembler.toDTO(application.getPart(id)));
	}
	
	public InvokeResult creatPart(PartDTO partDTO) {
		application.creatPart(PartAssembler.toEntity(partDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updatePart(PartDTO partDTO) {
		application.updatePart(PartAssembler.toEntity(partDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removePart(Long id) {
		application.removePart(application.getPart(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeParts(Long[] ids) {
		Set<Part> parts= new HashSet<Part>();
		for (Long id : ids) {
			parts.add(application.getPart(id));
		}
		application.removeParts(parts);
		return InvokeResult.success();
	}
	
	public List<PartDTO> findAllPart() {
		return PartAssembler.toDTOs(application.findAllPart());
	}
	
	public Page<PartDTO> pageQueryPart(PartDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _part from Part _part   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _part.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _part.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _part.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _part.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _part.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
	   		jpql.append(" and _part.partNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
	   	}		
	   	if (queryVo.getPartName() != null && !"".equals(queryVo.getPartName())) {
	   		jpql.append(" and _part.partName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartName()));
	   	}		
	   	if (queryVo.getEquipmentList() != null && !"".equals(queryVo.getEquipmentList())) {
	   		jpql.append(" and _part.equipmentList like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentList()));
	   	}		
	   	if (queryVo.getPartType() != null && !"".equals(queryVo.getPartType())) {
	   		jpql.append(" and _part.partType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartType()));
	   	}		
	   	if (queryVo.getPartModel() != null && !"".equals(queryVo.getPartModel())) {
	   		jpql.append(" and _part.partModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartModel()));
	   	}		
	   	if (queryVo.getInDate() != null) {
	   		jpql.append(" and _part.inDate between ? and ? ");
	   		conditionVals.add(queryVo.getInDate());
	   		conditionVals.add(queryVo.getInDateEnd());
	   	}	
	   	if (queryVo.getPartLocaltion() != null && !"".equals(queryVo.getPartLocaltion())) {
	   		jpql.append(" and _part.partLocaltion like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartLocaltion()));
	   	}		
	   	if (queryVo.getOwnership() != null && !"".equals(queryVo.getOwnership())) {
	   		jpql.append(" and _part.ownership like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOwnership()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _part.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
        Page<Part> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<PartDTO>(pages.getStart(), pages.getResultCount(),pageSize, PartAssembler.toDTOs(pages.getData()));
	}
	
	
}

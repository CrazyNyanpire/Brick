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
import acetecsemi.com.brick.facade.impl.assembler.NormalPartAssembler;
import acetecsemi.com.brick.facade.NormalPartFacade;
import acetecsemi.com.brick.application.NormalPartApplication;

import acetecsemi.com.brick.core.domain.*;

@Named
public class NormalPartFacadeImpl implements NormalPartFacade {

	@Inject
	private NormalPartApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getNormalPart(Long id) {
		return InvokeResult.success(NormalPartAssembler.toDTO(application.getNormalPart(id)));
	}
	
	public NormalPartDTO getNormalParts(Long id) {
		return NormalPartAssembler.toDTO(application.getNormalPart(id));
	}
	
	public InvokeResult creatNormalPart(NormalPartDTO normalPartDTO) {
		application.creatNormalPart(NormalPartAssembler.toEntity(normalPartDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateNormalPart(NormalPartDTO normalPartDTO) {
		application.updateNormalPart(NormalPartAssembler.toEntity(normalPartDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeNormalPart(Long id) {
		application.removeNormalPart(application.getNormalPart(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeNormalParts(Long[] ids) {
		Set<NormalPart> normalParts= new HashSet<NormalPart>();
		for (Long id : ids) {
			normalParts.add(application.getNormalPart(id));
		}
		application.removeNormalParts(normalParts);
		return InvokeResult.success();
	}
	
	public List<NormalPartDTO> findAllNormalPart() {
		return NormalPartAssembler.toDTOs(application.findAllNormalPart());
	}
	
	public Page<NormalPartDTO> pageQueryNormalPart(NormalPartDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _normalPart from NormalPart _normalPart   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _normalPart.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _normalPart.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _normalPart.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _normalPart.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getInDate() != null) {
	   		jpql.append(" and _normalPart.inDate between ? and ? ");
	   		conditionVals.add(queryVo.getInDate());
	   		conditionVals.add(queryVo.getInDateEnd());
	   	}	
	   	if (queryVo.getPartName() != null && !"".equals(queryVo.getPartName())) {
	   		jpql.append(" and _normalPart.partName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartName()));
	   	}		
	   	if (queryVo.getSerialNumber() != null && !"".equals(queryVo.getSerialNumber())) {
	   		jpql.append(" and _normalPart.serialNumber like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSerialNumber()));
	   	}		
	   	if (queryVo.getEquipment() != null && !"".equals(queryVo.getEquipment())) {
	   		jpql.append(" and _normalPart.equipment like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipment()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _normalPart.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getWarrantyPeriod() != null && !"".equals(queryVo.getWarrantyPeriod())) {
	   		jpql.append(" and _normalPart.warrantyPeriod like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getWarrantyPeriod()));
	   	}		
	   	if (queryVo.getManufacturer() != null && !"".equals(queryVo.getManufacturer())) {
	   		jpql.append(" and _normalPart.manufacturer like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getManufacturer()));
	   	}		
	   	if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
	   		jpql.append(" and _normalPart.type like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getType()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _normalPart.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getLocation() != null && !"".equals(queryVo.getLocation())) {
	   		jpql.append(" and _normalPart.location like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLocation()));
	   	}		
	   	if (queryVo.getSlotSite() != null && !"".equals(queryVo.getSlotSite())) {
	   		jpql.append(" and _normalPart.slotSite like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSlotSite()));
	   	}		
	   	if (queryVo.getPropertyNumber() != null && !"".equals(queryVo.getPropertyNumber())) {
	   		jpql.append(" and _normalPart.propertyNumber like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPropertyNumber()));
	   	}		
	   	if (queryVo.getQuantity() != null && !"".equals(queryVo.getQuantity())) {
	   		jpql.append(" and _normalPart.quantity like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getQuantity()));
	   	}		
	   	if (queryVo.getPartType() != null && !"".equals(queryVo.getPartType())) {
	   		jpql.append(" and _normalPart.partType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartType()));
	   	}		
	   	if (queryVo.getPartRevision() != null && !"".equals(queryVo.getPartRevision())) {
	   		jpql.append(" and _normalPart.partRevision like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartRevision()));
	   	}		
	   	if (queryVo.getPartConfig() != null && !"".equals(queryVo.getPartConfig())) {
	   		jpql.append(" and _normalPart.partConfig like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartConfig()));
	   	}		
        Page<NormalPart> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<NormalPartDTO>(pages.getStart(), pages.getResultCount(),pageSize, NormalPartAssembler.toDTOs(pages.getData()));
	}
	
	
}

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
import acetecsemi.com.brick.facade.impl.assembler.MaintenanceEquipmentAssembler;
import acetecsemi.com.brick.facade.MaintenanceEquipmentFacade;
import acetecsemi.com.brick.application.MaintenanceEquipmentApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class MaintenanceEquipmentFacadeImpl implements MaintenanceEquipmentFacade {

	@Inject
	private MaintenanceEquipmentApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public MaintenanceEquipmentDTO getMaintenanceEquipment(Long id) {
		return MaintenanceEquipmentAssembler.toDTO(application.getMaintenanceEquipment(id));
	}
	
	public InvokeResult creatMaintenanceEquipment(MaintenanceEquipmentDTO maintenanceEquipmentDTO) {
		application.creatMaintenanceEquipment(MaintenanceEquipmentAssembler.toEntity(maintenanceEquipmentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateMaintenanceEquipment(MaintenanceEquipmentDTO maintenanceEquipmentDTO) {
		application.updateMaintenanceEquipment(MaintenanceEquipmentAssembler.toEntity(maintenanceEquipmentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeMaintenanceEquipment(Long id) {
		application.removeMaintenanceEquipment(application.getMaintenanceEquipment(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeMaintenanceEquipments(Long[] ids) {
		Set<MaintenanceEquipment> maintenanceEquipments= new HashSet<MaintenanceEquipment>();
		for (Long id : ids) {
			maintenanceEquipments.add(application.getMaintenanceEquipment(id));
		}
		application.removeMaintenanceEquipments(maintenanceEquipments);
		return InvokeResult.success();
	}
	
	public List<MaintenanceEquipmentDTO> findAllMaintenanceEquipment() {
		return MaintenanceEquipmentAssembler.toDTOs(application.findAllMaintenanceEquipment());
	}
	
	public Page<MaintenanceEquipmentDTO> pageQueryMaintenanceEquipment(MaintenanceEquipmentDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _maintenanceEquipment from MaintenanceEquipment _maintenanceEquipment   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _maintenanceEquipment.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _maintenanceEquipment.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _maintenanceEquipment.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _maintenanceEquipment.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _maintenanceEquipment.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getOptType() != null && !"".equals(queryVo.getOptType())) {
	   		jpql.append(" and _maintenanceEquipment.optType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptType()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _maintenanceEquipment.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _maintenanceEquipment.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _maintenanceEquipment.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getFileUrl() != null && !"".equals(queryVo.getFileUrl())) {
	   		jpql.append(" and _maintenanceEquipment.fileUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFileUrl()));
	   	}		
        Page<MaintenanceEquipment> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<MaintenanceEquipmentDTO>(pages.getStart(), pages.getResultCount(),pageSize, MaintenanceEquipmentAssembler.toDTOs(pages.getData()));
	}

	@Override
	public EquipmentDTO findEquipmentByMaintenanceEquipment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

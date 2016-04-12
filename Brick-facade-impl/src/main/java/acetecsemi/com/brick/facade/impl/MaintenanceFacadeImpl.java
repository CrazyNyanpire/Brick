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
import acetecsemi.com.brick.facade.impl.assembler.EquipmentAssembler;
import acetecsemi.com.brick.facade.impl.assembler.MaintenanceAssembler;
import acetecsemi.com.brick.facade.MaintenanceFacade;
import acetecsemi.com.brick.application.MaintenanceApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class MaintenanceFacadeImpl implements MaintenanceFacade {

	@Inject
	private MaintenanceApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getMaintenance(Long id) {
		return InvokeResult.success(MaintenanceAssembler.toDTO(application.getMaintenance(id)));
	}
	
	public InvokeResult creatMaintenance(MaintenanceDTO maintenanceDTO) {
		application.creatMaintenance(MaintenanceAssembler.toEntity(maintenanceDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateMaintenance(MaintenanceDTO maintenanceDTO) {
		application.updateMaintenance(MaintenanceAssembler.toEntity(maintenanceDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeMaintenance(Long id) {
		application.removeMaintenance(application.getMaintenance(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeMaintenances(Long[] ids) {
		Set<Maintenance> maintenances= new HashSet<Maintenance>();
		for (Long id : ids) {
			maintenances.add(application.getMaintenance(id));
		}
		application.removeMaintenances(maintenances);
		return InvokeResult.success();
	}
	
	public List<MaintenanceDTO> findAllMaintenance() {
		return MaintenanceAssembler.toDTOs(application.findAllMaintenance());
	}
	
	public Page<MaintenanceDTO> pageQueryMaintenance(MaintenanceDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _maintenance from Maintenance _maintenance   left join _maintenance.equipment  where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _maintenance.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _maintenance.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _maintenance.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _maintenance.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _maintenance.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getOptType() != null && !"".equals(queryVo.getOptType())) {
	   		jpql.append(" and _maintenance.optType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptType()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _maintenance.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _maintenance.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _maintenance.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getFileUrl() != null && !"".equals(queryVo.getFileUrl())) {
	   		jpql.append(" and _maintenance.fileUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFileUrl()));
	   	}		
        Page<Maintenance> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<MaintenanceDTO>(pages.getStart(), pages.getResultCount(),pageSize, MaintenanceAssembler.toDTOs(pages.getData()));
	}
	
	public EquipmentDTO findEquipmentByMaintenance(Long id) {
		String jpql = "select e from Maintenance o right join o.equipment e where o.id=?";
		Equipment result = (Equipment) getQueryChannelService().createJpqlQuery(jpql).setParameters(new Object[] { id }).singleResult();
		EquipmentDTO  dto = new EquipmentDTO();
		if (result != null) {
			try {
				dto = EquipmentAssembler.toDTO(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}

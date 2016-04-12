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

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentAssembler;
import acetecsemi.com.brick.facade.impl.assembler.MaintenancePlatformAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.MaintenancePlatformFacade;
import acetecsemi.com.brick.application.MaintenancePlatformApplication;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class MaintenancePlatformFacadeImpl implements MaintenancePlatformFacade {

	@Inject
	private MaintenancePlatformApplication  application;
	
	@Inject
	private PlatformApplication  platformApplication;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public MaintenancePlatformDTO getMaintenancePlatform(Long id) {
		return MaintenancePlatformAssembler.toDTO(application.getMaintenancePlatform(id));
	}
	
	public Boolean creatMaintenancePlatform(MaintenancePlatformDTO maintenancePlatformDTO) {
		MaintenancePlatform maintenancePlatform = MaintenancePlatformAssembler.toEntity(maintenancePlatformDTO);
		if(maintenancePlatformDTO.getPlatformId() != null){
			Platform  platform = platformApplication.getPlatform(maintenancePlatformDTO.getPlatformId());
			maintenancePlatform.setPlatform(platform);
		}
		application.creatMaintenancePlatform(maintenancePlatform);
		return true;
	}
	
	public Boolean updateMaintenancePlatform(MaintenancePlatformDTO maintenancePlatformDTO) {
		//application.updateMaintenancePlatform(MaintenancePlatformAssembler.toEntity(maintenancePlatformDTO));
		MaintenancePlatform maintenancePlatform = application.getMaintenancePlatform(maintenancePlatformDTO.getId());
		BeanUtils.copyProperties(maintenancePlatformDTO, maintenancePlatform);
		if(maintenancePlatformDTO.getPlatformId() != null){
			Platform  platform = platformApplication.getPlatform(maintenancePlatformDTO.getPlatformId());
			maintenancePlatform.setPlatform(platform);
		}
		application.updateMaintenancePlatform(maintenancePlatform);
		return true;
	}
	
	public Boolean removeMaintenancePlatform(Long id) {
		application.removeMaintenancePlatform(application.getMaintenancePlatform(id));
		return true;
	}
	
	public Boolean removeMaintenancePlatforms(Long[] ids) {
		Set<MaintenancePlatform> maintenancePlatforms= new HashSet<MaintenancePlatform>();
		for (Long id : ids) {
			maintenancePlatforms.add(application.getMaintenancePlatform(id));
		}
		application.removeMaintenancePlatforms(maintenancePlatforms);
		return true;
	}
	
	public List<MaintenancePlatformDTO> findAllMaintenancePlatform() {
		return MaintenancePlatformAssembler.toDTOs(application.findAllMaintenancePlatform());
	}
	
	public Page<MaintenancePlatformDTO> pageQueryMaintenancePlatform(MaintenancePlatformDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _maintenancePlatform from MaintenancePlatform _maintenancePlatform   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _maintenancePlatform.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _maintenancePlatform.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _maintenancePlatform.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _maintenancePlatform.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _maintenancePlatform.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getOptType() != null && !"".equals(queryVo.getOptType())) {
	   		jpql.append(" and _maintenancePlatform.optType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptType()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _maintenancePlatform.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _maintenancePlatform.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _maintenancePlatform.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getFileUrl() != null && !"".equals(queryVo.getFileUrl())) {
	   		jpql.append(" and _maintenancePlatform.fileUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFileUrl()));
	   	}		
	 	if (queryVo.getPlatformName() != null && !"".equals(queryVo.getPlatformName())) {
	   		jpql.append(" and _maintenancePlatform.platform.tester.equipmentNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatformName()));
	   	}		
        Page<MaintenancePlatform> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<MaintenancePlatformDTO>(pages.getStart(), pages.getResultCount(),pageSize, MaintenancePlatformAssembler.toDTOs(pages.getData()));
	}
	
	public EquipmentDTO findEquipmentByMaintenancePlatform(Long id) {
		String jpql = "select e from MaintenancePlatform o right join o.equipment e where o.id=?";
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

	@Override
	public PlatformDTO findPlatformByMaintenancePlatform(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

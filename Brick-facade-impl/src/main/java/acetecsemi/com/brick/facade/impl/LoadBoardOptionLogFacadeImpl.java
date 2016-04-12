package acetecsemi.com.brick.facade.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.LoadBoardOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.utils.MyStringUtils;
import acetecsemi.com.brick.facade.LoadBoardOptionLogFacade;
import acetecsemi.com.brick.application.LoadBoardOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class LoadBoardOptionLogFacadeImpl implements LoadBoardOptionLogFacade {

	@Inject
	private LoadBoardOptionLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getLoadBoardOptionLog(Long id) {
		return InvokeResult.success(LoadBoardOptionLogAssembler.toDTO(application.getLoadBoardOptionLog(id)));
	}
	
	public InvokeResult creatLoadBoardOptionLog(LoadBoardOptionLogDTO loadBoardOptionLogDTO) {
		application.creatLoadBoardOptionLog(LoadBoardOptionLogAssembler.toEntity(loadBoardOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateLoadBoardOptionLog(LoadBoardOptionLogDTO loadBoardOptionLogDTO) {
		application.updateLoadBoardOptionLog(LoadBoardOptionLogAssembler.toEntity(loadBoardOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeLoadBoardOptionLog(Long id) {
		application.removeLoadBoardOptionLog(application.getLoadBoardOptionLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeLoadBoardOptionLogs(Long[] ids) {
		Set<LoadBoardOptionLog> loadBoardOptionLogs= new HashSet<LoadBoardOptionLog>();
		for (Long id : ids) {
			loadBoardOptionLogs.add(application.getLoadBoardOptionLog(id));
		}
		application.removeLoadBoardOptionLogs(loadBoardOptionLogs);
		return InvokeResult.success();
	}
	
	public List<LoadBoardOptionLogDTO> findAllLoadBoardOptionLog() {
		return LoadBoardOptionLogAssembler.toDTOs(application.findAllLoadBoardOptionLog());
	}
	
	public Page<LoadBoardOptionLogDTO> pageQueryLoadBoardOptionLog(LoadBoardOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _loadBoardOptionLog from LoadBoardOptionLog _loadBoardOptionLog    where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _loadBoardOptionLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _loadBoardOptionLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _loadBoardOptionLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _loadBoardOptionLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _loadBoardOptionLog.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
	   		jpql.append(" and _loadBoardOptionLog.nowLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
	   	}		
	   	if (queryVo.getNowStation() != null && !"".equals(queryVo.getNowStation())) {
	   		jpql.append(" and _loadBoardOptionLog.nowStation like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowStation()));
	   	}		
	   	if (queryVo.getProductModel() != null && !"".equals(queryVo.getProductModel())) {
	   		jpql.append(" and _loadBoardOptionLog.productModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductModel()));
	   	}		
	   	if (queryVo.getStartTime() != null) {
	   		jpql.append(" and _loadBoardOptionLog.startTime between ? and ? ");
	   		conditionVals.add(queryVo.getStartTime());
	   		conditionVals.add(queryVo.getStartTimeEnd());
	   	}	
	   	if (queryVo.getEndTime() != null) {
	   		jpql.append(" and _loadBoardOptionLog.endTime between ? and ? ");
	   		conditionVals.add(queryVo.getEndTime());
	   		conditionVals.add(queryVo.getEndTimeEnd());
	   	}	
	   	if (queryVo.getEndOptUser() != null && !"".equals(queryVo.getEndOptUser())) {
	   		jpql.append(" and _loadBoardOptionLog.endOptUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndOptUser()));
	   	}		
	   	if (queryVo.getTheoryTime() != null && !"".equals(queryVo.getTheoryTime())) {
	   		jpql.append(" and _loadBoardOptionLog.theoryTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTheoryTime()));
	   	}		
	   	if (queryVo.getOptRemark() != null && !"".equals(queryVo.getOptRemark())) {
	   		jpql.append(" and _loadBoardOptionLog.optRemark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptRemark()));
	   	}		
	   	if (queryVo.getProductLot() != null && !"".equals(queryVo.getProductLot())) {
	   		jpql.append(" and _loadBoardOptionLog.productLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductLot()));
	   	}		
	   	if (queryVo.getEquipmentNo() != null && !"".equals(queryVo.getEquipmentNo())) {
	   		jpql.append(" and _loadBoardOptionLog.equipmentNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentNo()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _loadBoardOptionLog.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getAppearanceHorizontal() != null && !"".equals(queryVo.getAppearanceHorizontal())) {
	   		jpql.append(" and _loadBoardOptionLog.appearanceHorizontal like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAppearanceHorizontal()));
	   	}		
	   	if (queryVo.getPlatform() != null && !"".equals(queryVo.getPlatform())) {
	   		jpql.append(" and _loadBoardOptionLog.platform like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatform()));
	   	}		
	   	if (queryVo.getPlatformIds() != null && !"".equals(queryVo.getPlatformIds())) {
	   		jpql.append(" and _loadBoardOptionLog.platformIds like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatformIds()));
	   	}		
	   	if (queryVo.getPlatformStatus() != null && !"".equals(queryVo.getPlatformStatus())) {
	   		jpql.append(" and _loadBoardOptionLog.platformStatus like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatformStatus()));
	   	}		
        Page<LoadBoardOptionLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<LoadBoardOptionLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, LoadBoardOptionLogAssembler.toDTOs(pages.getData()));
	}
	
	public CategoryDTO findStatusByLoadBoardOptionLog(Long id) {
		String jpql = "select e from LoadBoardOptionLog o right join o.status e where o.id=?";
		Category result = (Category) getQueryChannelService().createJpqlQuery(jpql).setParameters(new Object[] { id }).singleResult();
		CategoryDTO  dto = new CategoryDTO();
		if (result != null) {
			try {
				BeanUtils.copyProperties(dto, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public EquipmentDTO findEquipmentByLoadBoardOptionLog(Long id) {
		String jpql = "select e from LoadBoardOptionLog o right join o.equipment e where o.id=?";
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

	public PlatformDTO findNowPlatformByLoadBoardOptionLog(Long id) {
		String jpql = "select e from LoadBoardOptionLog o right join o.nowPlatform e where o.id=?";
		Platform result = (Platform) getQueryChannelService().createJpqlQuery(jpql).setParameters(new Object[] { id }).singleResult();
		PlatformDTO  dto = new PlatformDTO();
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
	public LoadBoardDTO findLoadBoardByLoadBoardOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 保存loadBoard操作日志最后一条记录的endTime
	 * 
	 * @param id
	 * @param endTime
	 */
	@Override
	public void saveLastLoadBoardOptionLogEndTime(Long id, Date endTime, String endOptUser) {
		String jpql = "select o from LoadBoardOptionLog o where o.loadBoard.id=? order by o.id desc";
		LoadBoardOptionLog result = (LoadBoardOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		if (result != null && result.getStartTime() != null) {
			result.setEndTime(endTime);
			Long duration = result.getEndTime().getTime()
					- result.getStartTime().getTime();
			result.setDuration(duration);
			result.setLastModifyEmployNo(endOptUser);
			result.setEndOptUser(endOptUser);
			application.updateLoadBoardOptionLog(result);
		}
	}

	@Override
	public Map<String, String> getReleaseInfo(Long loadBoardId) {
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(loadBoardId);
		StringBuilder jpql = new StringBuilder(
				"select o from LoadBoardOptionLog o   where status = '程序Release' and o.loadBoard.id=?");
		@SuppressWarnings("unchecked")
		List<LoadBoardOptionLog> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		StringBuffer productModel = new StringBuffer();
		String equipmentList = "";
		String equipmentListId = "";
		for (LoadBoardOptionLog pcol : list) {
			// if (pcol.getProductModel() == null
			// || "".equals(pcol.getProductModel())) {
			// continue;
			// }
			// productModel.append(pcol.getProductModel()).append(",");
			if (pcol.getPlatform() == null || "".equals(pcol.getPlatform())) {
				continue;
			}
			equipmentList = MyStringUtils.getReleaseInfo(equipmentList,
					pcol.getPlatform());
			equipmentListId = MyStringUtils.getReleaseInfo(equipmentListId,
					pcol.getPlatformIds());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("productModel", productModel.toString());
		map.put("equipmentList", equipmentList.toString());
		map.put("equipmentListId", equipmentListId.toString());
		return map;
	}
}

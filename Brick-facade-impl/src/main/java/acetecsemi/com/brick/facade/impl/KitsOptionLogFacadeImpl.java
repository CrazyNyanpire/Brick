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
import acetecsemi.com.brick.facade.impl.assembler.KitsOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.utils.MyStringUtils;
import acetecsemi.com.brick.facade.KitsOptionLogFacade;
import acetecsemi.com.brick.application.KitsOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class KitsOptionLogFacadeImpl implements KitsOptionLogFacade {

	@Inject
	private KitsOptionLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getKitsOptionLog(Long id) {
		return InvokeResult.success(KitsOptionLogAssembler.toDTO(application.getKitsOptionLog(id)));
	}
	
	public InvokeResult creatKitsOptionLog(KitsOptionLogDTO kitsOptionLogDTO) {
		application.creatKitsOptionLog(KitsOptionLogAssembler.toEntity(kitsOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateKitsOptionLog(KitsOptionLogDTO kitsOptionLogDTO) {
		application.updateKitsOptionLog(KitsOptionLogAssembler.toEntity(kitsOptionLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeKitsOptionLog(Long id) {
		application.removeKitsOptionLog(application.getKitsOptionLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeKitsOptionLogs(Long[] ids) {
		Set<KitsOptionLog> kitsOptionLogs= new HashSet<KitsOptionLog>();
		for (Long id : ids) {
			kitsOptionLogs.add(application.getKitsOptionLog(id));
		}
		application.removeKitsOptionLogs(kitsOptionLogs);
		return InvokeResult.success();
	}
	
	public List<KitsOptionLogDTO> findAllKitsOptionLog() {
		return KitsOptionLogAssembler.toDTOs(application.findAllKitsOptionLog());
	}
	
	public Page<KitsOptionLogDTO> pageQueryKitsOptionLog(KitsOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _kitsOptionLog from KitsOptionLog _kitsOptionLog   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _kitsOptionLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _kitsOptionLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _kitsOptionLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _kitsOptionLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _kitsOptionLog.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
	   		jpql.append(" and _kitsOptionLog.nowLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
	   	}		
	   	if (queryVo.getNowStation() != null && !"".equals(queryVo.getNowStation())) {
	   		jpql.append(" and _kitsOptionLog.nowStation like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowStation()));
	   	}		
	   	if (queryVo.getProductModel() != null && !"".equals(queryVo.getProductModel())) {
	   		jpql.append(" and _kitsOptionLog.productModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductModel()));
	   	}		
	   	if (queryVo.getStartTime() != null) {
	   		jpql.append(" and _kitsOptionLog.startTime between ? and ? ");
	   		conditionVals.add(queryVo.getStartTime());
	   		conditionVals.add(queryVo.getStartTimeEnd());
	   	}	
	   	if (queryVo.getEndTime() != null) {
	   		jpql.append(" and _kitsOptionLog.endTime between ? and ? ");
	   		conditionVals.add(queryVo.getEndTime());
	   		conditionVals.add(queryVo.getEndTimeEnd());
	   	}	
	   	if (queryVo.getEndOptUser() != null && !"".equals(queryVo.getEndOptUser())) {
	   		jpql.append(" and _kitsOptionLog.endOptUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEndOptUser()));
	   	}		
	   	if (queryVo.getTheoryTime() != null && !"".equals(queryVo.getTheoryTime())) {
	   		jpql.append(" and _kitsOptionLog.theoryTime like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTheoryTime()));
	   	}		
	   	if (queryVo.getOptRemark() != null && !"".equals(queryVo.getOptRemark())) {
	   		jpql.append(" and _kitsOptionLog.optRemark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptRemark()));
	   	}		
	   	if (queryVo.getProductLot() != null && !"".equals(queryVo.getProductLot())) {
	   		jpql.append(" and _kitsOptionLog.productLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductLot()));
	   	}		
	   	if (queryVo.getEquipmentNo() != null && !"".equals(queryVo.getEquipmentNo())) {
	   		jpql.append(" and _kitsOptionLog.equipmentNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentNo()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _kitsOptionLog.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getAppearanceHorizontal() != null && !"".equals(queryVo.getAppearanceHorizontal())) {
	   		jpql.append(" and _kitsOptionLog.appearanceHorizontal like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAppearanceHorizontal()));
	   	}		
	   	if (queryVo.getPlatform() != null && !"".equals(queryVo.getPlatform())) {
	   		jpql.append(" and _kitsOptionLog.platform like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatform()));
	   	}		
	   	if (queryVo.getPlatformIds() != null && !"".equals(queryVo.getPlatformIds())) {
	   		jpql.append(" and _kitsOptionLog.platformIds like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatformIds()));
	   	}		
	   	if (queryVo.getPlatformStatus() != null && !"".equals(queryVo.getPlatformStatus())) {
	   		jpql.append(" and _kitsOptionLog.platformStatus like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPlatformStatus()));
	   	}		
        Page<KitsOptionLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<KitsOptionLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, KitsOptionLogAssembler.toDTOs(pages.getData()));
	}
	
	public CategoryDTO findStatusByKitsOptionLog(Long id) {
		String jpql = "select e from KitsOptionLog o right join o.status e where o.id=?";
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

	public EquipmentDTO findEquipmentByKitsOptionLog(Long id) {
		String jpql = "select e from KitsOptionLog o right join o.equipment e where o.id=?";
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

	public PlatformDTO findNowPlatformByKitsOptionLog(Long id) {
		String jpql = "select e from KitsOptionLog o right join o.nowPlatform e where o.id=?";
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
	public KitsDTO findKitsByKitsOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 保存kits操作日志最后一条记录的endTime
	 * 
	 * @param id
	 * @param endTime
	 */
	@Override
	public void saveLastKitsOptionLogEndTime(Long id, Date endTime, String endOptUser) {
		String jpql = "select o from KitsOptionLog o where o.kits.id=? order by o.id desc";
		KitsOptionLog result = (KitsOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		if (result != null && result.getStartTime() != null) {
			result.setEndTime(endTime);
			Long duration = result.getEndTime().getTime()
					- result.getStartTime().getTime();
			result.setDuration(duration);
			result.setLastModifyEmployNo(endOptUser);
			result.setEndOptUser(endOptUser);
			application.updateKitsOptionLog(result);
		}
	}

	@Override
	public Map<String, String> getReleaseInfo(Long kitsId) {
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(kitsId);
		StringBuilder jpql = new StringBuilder(
				"select o from KitsOptionLog o   where status = '程序Release' and o.kits.id=?");
		@SuppressWarnings("unchecked")
		List<KitsOptionLog> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		StringBuffer productModel = new StringBuffer();
		String equipmentList = "";
		String equipmentListId = "";
		for (KitsOptionLog pcol : list) {
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

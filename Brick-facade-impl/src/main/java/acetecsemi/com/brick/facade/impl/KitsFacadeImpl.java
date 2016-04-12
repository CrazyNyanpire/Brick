package acetecsemi.com.brick.facade.impl;

import java.util.Date;
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
import acetecsemi.com.brick.facade.impl.assembler.KitsAssembler;
import acetecsemi.com.brick.facade.impl.assembler.KitsAssembler;
import acetecsemi.com.brick.facade.impl.assembler.KitsOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.utils.MyStringUtils;
import acetecsemi.com.brick.facade.KitsFacade;
import acetecsemi.com.brick.facade.KitsOptionLogFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.application.KitsApplication;
import acetecsemi.com.brick.application.KitsOptionLogApplication;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class KitsFacadeImpl implements KitsFacade {

	@Inject
	private KitsApplication  application;
	
	@Inject 
	private KitsOptionLogFacade kitsOptionLogFacade;
	
	@Inject
	private KitsOptionLogApplication kitsOptionLogApplication;
	
	@Inject 
	private PlatformApplication platformApplication;
	
	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;
	
	@Inject
	private CategoryApplication categoryApplication;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getKits(Long id) {
		return InvokeResult.success(KitsAssembler.toDTO(application.getKits(id)));
	}
	
	public InvokeResult creatKits(KitsDTO kitsDTO) {
		Kits kits = KitsAssembler.toEntity(kitsDTO);
		kits.setStatus(categoryApplication.getCategory(Long.valueOf(117)));
		application.creatKits(kits);
		KitsOptionLog kitsOptionLog = new KitsOptionLog();
		BeanUtils.copyProperties(kitsDTO, kitsOptionLog);
		kitsOptionLog.setKits(kits);
		kitsOptionLog.setStatus(kits.getStatus().getCategoryName());
		this.kitsOptionLogApplication.updateKitsOptionLog(kitsOptionLog);
		KitsReceivingReport kitsReceivingReport = new KitsReceivingReport();
		kitsReceivingReport.setFileUrl(kitsDTO.getLastFileUrl());
		kitsReceivingReport.setKits(kits);
		kitsReceivingReport.save();
		return InvokeResult.success();
	}
	
	public InvokeResult updateKits(KitsDTO kitsDTO) {
		Kits kits = application.getKits(kitsDTO.getId());
		BeanUtils.copyProperties(kitsDTO, kits);
		application.updateKits(kits);
		return InvokeResult.success();
	}
	
	public InvokeResult removeKits(Long id) {
		application.removeKits(application.getKits(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeKitss(Long[] ids) {
		Set<Kits> kitss= new HashSet<Kits>();
		for (Long id : ids) {
			kitss.add(application.getKits(id));
		}
		application.removeKitss(kitss);
		return InvokeResult.success();
	}
	
	public List<KitsDTO> findAllKits() {
		return KitsAssembler.toDTOs(application.findAllKits());
	}
	
	public Page<KitsDTO> pageQueryKits(KitsDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _kits from Kits _kits   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _kits.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _kits.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _kits.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _kits.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _kits.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
	   		jpql.append(" and _kits.partNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
	   	}		
	   	if (queryVo.getPartName() != null && !"".equals(queryVo.getPartName())) {
	   		jpql.append(" and _kits.partName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartName()));
	   	}		
	   	if (queryVo.getEquipmentList() != null && !"".equals(queryVo.getEquipmentList())) {
	   		jpql.append(" and _kits.equipmentList like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentList()));
	   	}		
	   	if (queryVo.getPartType() != null && !"".equals(queryVo.getPartType())) {
	   		jpql.append(" and _kits.partType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartType()));
	   	}		
	   	if (queryVo.getPartModel() != null && !"".equals(queryVo.getPartModel())) {
	   		jpql.append(" and _kits.partModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartModel()));
	   	}		
	   	if (queryVo.getProductModel() != null && !"".equals(queryVo.getProductModel())) {
	   		jpql.append(" and _kits.productModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductModel()));
	   	}		
	   	if (queryVo.getNowProductModel() != null && !"".equals(queryVo.getNowProductModel())) {
	   		jpql.append(" and _kits.nowProductModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getNowProductModel()));
	   	}		
	   	if (queryVo.getInDate() != null) {
	   		jpql.append(" and _kits.inDate between ? and ? ");
	   		conditionVals.add(queryVo.getInDate());
	   		conditionVals.add(queryVo.getInDateEnd());
	   	}	
	   	if (queryVo.getPartLocaltion() != null && !"".equals(queryVo.getPartLocaltion())) {
	   		jpql.append(" and _kits.partLocaltion like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartLocaltion()));
	   	}		
	   	if (queryVo.getManufacturerNo() != null && !"".equals(queryVo.getManufacturerNo())) {
	   		jpql.append(" and _kits.manufacturerNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getManufacturerNo()));
	   	}		
	   	if (queryVo.getManufacturerName() != null && !"".equals(queryVo.getManufacturerName())) {
	   		jpql.append(" and _kits.manufacturerName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getManufacturerName()));
	   	}		
	   	if (queryVo.getCustomerName() != null && !"".equals(queryVo.getCustomerName())) {
	   		jpql.append(" and _kits.customerName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCustomerName()));
	   	}		
	   	if (queryVo.getCustomerNameEn() != null && !"".equals(queryVo.getCustomerNameEn())) {
	   		jpql.append(" and _kits.customerNameEn like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCustomerNameEn()));
	   	}		
	   	if (queryVo.getOwnership() != null && !"".equals(queryVo.getOwnership())) {
	   		jpql.append(" and _kits.ownership like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOwnership()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _kits.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
	   	if (queryVo.getPn() != null && !"".equals(queryVo.getPn())) {
	   		jpql.append(" and _kits.pn like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPn()));
	   	}		
	   	if (queryVo.getSupplier() != null && !"".equals(queryVo.getSupplier())) {
	   		jpql.append(" and _kits.supplier like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSupplier()));
	   	}		
	   	if (queryVo.getApplicableModels() != null && !"".equals(queryVo.getApplicableModels())) {
	   		jpql.append(" and _kits.applicableModels like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getApplicableModels()));
	   	}		
	   	if (queryVo.getLastFileUrl() != null && !"".equals(queryVo.getLastFileUrl())) {
	   		jpql.append(" and _kits.lastFileUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastFileUrl()));
	   	}		
	   	if (queryVo.getAppearanceLevel() != null && !"".equals(queryVo.getAppearanceLevel())) {
	   		jpql.append(" and _kits.appearanceLevel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAppearanceLevel()));
	   	}		
	   	if (queryVo.getEquipmentListId() != null && !"".equals(queryVo.getEquipmentListId())) {
	   		jpql.append(" and _kits.equipmentListId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentListId()));
	   	}		
        Page<Kits> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<KitsDTO>(pages.getStart(), pages.getResultCount(),pageSize, KitsAssembler.toDTOs(pages.getData()));
	}

	@Override
	public CategoryDTO findStatusByKits(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentDTO findEquipmentByKits(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlatformDTO findNowPlatformByKits(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvokeResult changeKitsStatus(KitsDTO kitsDTO) {
		Kits kits = Kits.get(Kits.class, kitsDTO.getId());
		if (kitsDTO.getStatusId() != null) {
			KitsOptionLog kitsOptionLog = new KitsOptionLog();
			BeanUtils.copyProperties(kitsDTO, kitsOptionLog);
			switch (kitsDTO.getStatusId().intValue()) {
			case 99:
			case 100:
				if (this.checkRunKits(kits)) {
					return InvokeResult.failure("领出申请产品型号、设备kits不适用！");
				}
				if (kitsDTO.getNowPlatformId() != null) {
					/*
					 * if (this.checkPlatformSite(kitsDTO.getNowPlatformId(),
					 * kitsDTO.getPlatformSite())) { return
					 * "已经领出kits 到选择的site，如果需要办理领出请归还入库！"; }
					 */
					Platform platform = Platform.get(Platform.class,
							kitsDTO.getNowPlatformId());
					if (kits.getEquipmentList() == null
							|| kits.getEquipmentListId() == null
							|| kits.getEquipmentListId()
									.indexOf(
											String.valueOf(kitsDTO
													.getNowPlatformId())) < 0
							&& kits.getEquipmentList().indexOf(
									platform.getTester().getEquipmentNo()) < 0) {
						return InvokeResult.failure("Sockect 不能用于平台"
								+ platform.getTester().getEquipmentNo());
					}
					kits.setNowPlatform(platform);
					kitsDTO
							.setPlatform(platform.getTester().getEquipmentNo());
					// kits.setPlatformSite(kitsDTO.getPlatformSite());
				}
				break;

			case 97:
			case 98:
				kits.setNowPlatform(null);
				break;
			case 116:
				Map<String, String> map = kitsOptionLogFacade
						.getReleaseInfo(kits.getId());
				kits.setProductModel(MyStringUtils.getReleaseInfo(
						map.get("productModel"), kitsDTO.getProductModel()));
				kits.setEquipmentList(MyStringUtils.getReleaseInfo(
						map.get("equipmentList"), kitsDTO.getEquipmentList()));
				kitsDTO.setPlatform(kitsDTO.getEquipmentList());
				kits.setEquipmentListId(MyStringUtils.getReleaseInfo(
						map.get("equipmentListId"),
						kitsDTO.getEquipmentListId()));
				break;
			case 119:
				kits.setNowPlatform(null);
				break;
			}
			Category status = Category.get(Category.class,
					kitsDTO.getStatusId());
			kitsDTO.setStatus(status.getCategoryName());
			kits.setStatus(status);
			kitsOptionLogFacade.saveLastKitsOptionLogEndTime(
					kits.getId(), kitsDTO.getLastModifyTimestamp(),
					kitsDTO.getLastModifyEmployNo());
			application.updateKits(kits);
			// kitsOptionLog.setPlatformSite(kitsDTO.getPlatformSite());
			kitsOptionLog.setKits(kits);
			kitsOptionLog.setStartTime(kitsDTO.getLastModifyTimestamp());
			kitsOptionLog.setStatus(status.getCategoryName());
			kitsOptionLog.setPlatform(kitsDTO.getPlatform());
			kitsOptionLog.setPlatformIds(kitsDTO.getEquipmentListId());
			// kitsOptionLog.setOptUser(platform);
			kitsOptionLog.setId(null);
			kitsOptionLogApplication.updateKitsOptionLog(kitsOptionLog);
			if (kitsDTO.getStatusId() == Long.valueOf(116)) {
				KitsDTO sDTO = new KitsDTO();
				sDTO.setId(kitsDTO.getId());
				sDTO.setStatusId(Long.valueOf(97));
				sDTO.setAppearanceLevel("Pass");
				sDTO.setLastModifyEmployNo(kitsDTO.getLastModifyEmployNo());
				sDTO.setLastModifyTimestamp(kitsDTO.getLastModifyTimestamp());
				this.changeKitsStatus(sDTO);
			}
			return InvokeResult.success();
		}
		return InvokeResult.failure("状态改变失败！");
	}

	public List<KitsDTO> getKitsByPlatformId(Long platformId) {
		KitsDTO queryVo = new KitsDTO();
		queryVo.setNowPlatformId(platformId);
		List<KitsDTO> kitsList = this.queryKits(queryVo,
				" order by platformSite ");
		return kitsList;
	}

	@Override
	public String runLog(KitsDTO kitsDTO) {
		if (kitsDTO.getId() != null) {
			Kits kits = application.getKits(kitsDTO.getId());
			// 挂状态时关联平台
			if (kitsDTO.getPlatformId() != null) {
				kits.setNowPlatform(platformApplication.getPlatform(kitsDTO
						.getPlatformId()));
			} else {
				kits.setNowPlatform(null);
			}

			KitsOptionLog kitsOptionLog = new KitsOptionLog();
			BeanUtils.copyProperties(kitsDTO, kitsOptionLog);
			if (kits.getNowPlatform() != null) {
				kitsOptionLog.setPlatform(kits.getNowPlatform().getTester()
						.getEquipmentNo());
			}
			kitsOptionLog.setId(null);
			kitsOptionLog.setKits(kits);
			kitsOptionLog.setStartTime(kitsDTO.getLastModifyTimestamp());
			kitsOptionLog.setStatus(kits.getStatus().getCategoryName());
			kitsOptionLog.setRemark("生产批次操作日志");
			// probeCardOptionLog.setOptUser(platform);
			kitsOptionLog.setLastModifyEmployNo(kitsDTO
					.getLastModifyEmployNo());
			kitsOptionLog.setPlatform(kitsDTO.getPlatform());
			kitsOptionLog
					.setAppearanceHorizontal(kits.getAppearanceLevel());
			kitsOptionLog.setPlatformStatus(kitsDTO.getPlatformStatus());
			kitsOptionLogApplication.creatKitsOptionLog(kitsOptionLog);
			return null;
		}
		return "状态改变失败！";
	}

	/**
	 * 生产领出的probe card
	 */
	@Override
	public List<KitsDTO> findProductAllKits(KitsDTO kitsDTO) {
		// kitsDTO = new KitsDTO();
		kitsDTO.setStatusIds("99,100");
		return this.queryKits(kitsDTO, null);
	}

	public List<KitsDTO> queryKits(KitsDTO queryVo, String order) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _kits from Kits _kits   where 1=1 ");
		if (queryVo.getPlatformNo() != null
				&& !"".equals(queryVo.getPlatformNo())) {
			jpql.append(" and _kits.equipmentList like ? ");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformNo()));
		}
		if (queryVo.getStatusId() != null) {
			jpql.append(" and _kits.status.id = ?");
			conditionVals.add(queryVo.getStatusId());
		}
		if (queryVo.getStatusIds() != null
				&& !"".equals(queryVo.getStatusIds())) {
			jpql.append(" and _kits.status.id in (" + queryVo.getStatusIds()
					+ ")");
		}
		if (queryVo.getNowPlatformId() != null) {
			jpql.append(" and _kits.nowPlatform.id = ? ");
			conditionVals.add(queryVo.getNowPlatformId());
		}
		if (order != null)
			jpql.append(order);
		List<Kits> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return KitsAssembler.toDTOs(list);
	}

	private boolean checkRunKits(Kits kits) {
		if (kits.getNowPlatform() != null
				&& ("RUN".equals(kits.getNowPlatform().getStatus())
						|| "REWORK".equals(kits.getNowPlatform().getStatus())
						|| "ENG_RUN"
								.equals(kits.getNowPlatform().getStatus()) || "R/T_RUN"
							.equals(kits.getNowPlatform().getStatus()))
				&& platformOptionLogFacade
						.getLastPlatformOptionLog(
								kits.getNowPlatform().getId()).getPcNo()
						.indexOf(kits.getPartNo()) > -1) {

			return true;
		}
		return false;

	}
	
}

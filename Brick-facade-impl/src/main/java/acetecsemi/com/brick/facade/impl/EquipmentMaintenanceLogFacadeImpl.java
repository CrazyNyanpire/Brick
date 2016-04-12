package acetecsemi.com.brick.facade.impl;

import java.util.Date;
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
import acetecsemi.com.brick.facade.impl.assembler.EquipmentMaintenanceLogAssembler;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.EquipmentMaintenanceLogFacade;
import acetecsemi.com.brick.application.EquipmentMaintenanceLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class EquipmentMaintenanceLogFacadeImpl implements
		EquipmentMaintenanceLogFacade {

	@Inject
	private EquipmentMaintenanceLogApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public InvokeResult getEquipmentMaintenanceLog(Long id) {
		return InvokeResult.success(EquipmentMaintenanceLogAssembler
				.toDTO(application.getEquipmentMaintenanceLog(id)));
	}

	public InvokeResult creatEquipmentMaintenanceLog(
			EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO) {
		application
				.creatEquipmentMaintenanceLog(EquipmentMaintenanceLogAssembler
						.toEntity(equipmentMaintenanceLogDTO));
		return InvokeResult.success();
	}

	public InvokeResult updateEquipmentMaintenanceLog(
			EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO) {
		application
				.updateEquipmentMaintenanceLog(EquipmentMaintenanceLogAssembler
						.toEntity(equipmentMaintenanceLogDTO));
		return InvokeResult.success();
	}

	public InvokeResult removeEquipmentMaintenanceLog(Long id) {
		application.removeEquipmentMaintenanceLog(application
				.getEquipmentMaintenanceLog(id));
		return InvokeResult.success();
	}

	public InvokeResult removeEquipmentMaintenanceLogs(Long[] ids) {
		Set<EquipmentMaintenanceLog> equipmentMaintenanceLogs = new HashSet<EquipmentMaintenanceLog>();
		for (Long id : ids) {
			equipmentMaintenanceLogs.add(application
					.getEquipmentMaintenanceLog(id));
		}
		application.removeEquipmentMaintenanceLogs(equipmentMaintenanceLogs);
		return InvokeResult.success();
	}

	public List<EquipmentMaintenanceLogDTO> findAllEquipmentMaintenanceLog() {
		return EquipmentMaintenanceLogAssembler.toDTOs(application
				.findAllEquipmentMaintenanceLog());
	}

	public Page<EquipmentMaintenanceLogDTO> pageQueryEquipmentMaintenanceLog(
			EquipmentMaintenanceLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _equipmentMaintenanceLog from EquipmentMaintenanceLog _equipmentMaintenanceLog   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _equipmentMaintenanceLog.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _equipmentMaintenanceLog.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _equipmentMaintenanceLog.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _equipmentMaintenanceLog.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getPlanStartDate() != null
				&& !"".equals(queryVo.getPlanStartDate())) {
			jpql.append(" and _equipmentMaintenanceLog.planStartDate like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlanStartDate()));
		}
		if (queryVo.getRealStartDate() != null
				&& !"".equals(queryVo.getRealStartDate())) {
			jpql.append(" and _equipmentMaintenanceLog.realStartDate like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getRealStartDate()));
		}
		if (queryVo.getRealEndDate() != null
				&& !"".equals(queryVo.getRealEndDate())) {
			jpql.append(" and _equipmentMaintenanceLog.realEndDate like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getRealEndDate()));
		}
		if (queryVo.getNowMaintenancePlanDate() != null
				&& !"".equals(queryVo.getNowMaintenancePlanDate())) {
			jpql.append(" and _equipmentMaintenanceLog.nowMaintenancePlanDate like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowMaintenancePlanDate()));
		}
		if (queryVo.getNextMaintenancePlanDate() != null
				&& !"".equals(queryVo.getNextMaintenancePlanDate())) {
			jpql.append(" and _equipmentMaintenanceLog.nextMaintenancePlanDate like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNextMaintenancePlanDate()));
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _equipmentMaintenanceLog.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		if (queryVo.getPmType() != null && !"".equals(queryVo.getPmType())) {
			jpql.append(" and _equipmentMaintenanceLog.pmType like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getPmType()));
		}
		Page<EquipmentMaintenanceLog> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<EquipmentMaintenanceLogDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				EquipmentMaintenanceLogAssembler.toDTOs(pages.getData()));
	}

	@Override
	public EquipmentDTO findEquipmentByEquipmentMaintenanceLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentMaintenanceLogDTO> findEquipmentMaintenanceLog(Long id) {
		List<Object> conditionVals = new ArrayList<Object>();
		Equipment quipement = Equipment.get(Equipment.class, id);
		StringBuilder jpql = new StringBuilder(
				"select _equipmentMaintenanceLog from EquipmentMaintenanceLog _equipmentMaintenanceLog   where 1=1 ");
		if (id != null) {
			jpql.append(" and _equipmentMaintenanceLog.equipment.id = ? ");
			conditionVals.add(id);
		}
		jpql.append("order by _equipmentMaintenanceLog.realEndDate");
		List<EquipmentMaintenanceLogDTO> list = new ArrayList<EquipmentMaintenanceLogDTO>();
		list = EquipmentMaintenanceLogAssembler.toDTOs(getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list());
		EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO = list.get(list.size() - 1);
		if ("on".equals(quipement.getRepairCycleMonth())) {
			if (list.size() > 0) {
				String mDate = equipmentMaintenanceLogDTO
						.getNextMaintenancePlanDate().split("|")[0];
				list.addAll(this.createPlanList(quipement,
						equipmentMaintenanceLogDTO, 1, "月", mDate));
			} else {
				list.addAll(this.createPlanList(quipement, 1, "月"));
			}
		}
		if ("on".equals(quipement.getRepairCycleSeason())) {
			if (list.size() > 0) {
				String mDate = equipmentMaintenanceLogDTO
						.getNextMaintenancePlanDate().split("|")[1];
				list.addAll(this.createPlanList(quipement,
						equipmentMaintenanceLogDTO, 3, "季", mDate));
			} else {
				list.addAll(this.createPlanList(quipement, 3, "季"));
			}
		}
		if ("on".equals(quipement.getRepairCycleYear())) {
			if (list.size() > 0) {
				String mDate = equipmentMaintenanceLogDTO
						.getNextMaintenancePlanDate().split("|")[2];
				list.addAll(this.createPlanList(quipement,
						equipmentMaintenanceLogDTO, 12, "年", mDate));
			} else {
				list.addAll(this.createPlanList(quipement, 12, "年"));
			}
		}
		return list;
	}

	private List<EquipmentMaintenanceLogDTO> createPlanList(
			Equipment quipement,
			EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO, int cycle,
			String cycleName, String mDate) {
		String planStartDate = equipmentMaintenanceLogDTO.getPlanStartDate();
		List<EquipmentMaintenanceLogDTO> list = new ArrayList<EquipmentMaintenanceLogDTO>();
		Date psDate = MyDateUtils.str2Date(planStartDate,
				MyDateUtils.DefFormatString);
		EquipmentMaintenanceLogDTO eMLogDTO;
		for (int i = 1; i <= 12 / cycle; i++) {
			eMLogDTO = new EquipmentMaintenanceLogDTO();
			eMLogDTO.setPlanStartDate(MyDateUtils.formaterDate(
					MyDateUtils.addMonths(psDate, cycle * i),
					MyDateUtils.DefFormatString));
			eMLogDTO.setResponsible(equipmentMaintenanceLogDTO.getResponsible());
			eMLogDTO.setCreateEmployNo(quipement.getResponsible());
			eMLogDTO.setPmType(cycleName);
			eMLogDTO.setRealEndDate("");
			eMLogDTO.setRealStartDate("");
			list.add(eMLogDTO);
		}
		return list;
	}

	private List<EquipmentMaintenanceLogDTO> createPlanList(
			Equipment equipment, int cycle, String cycleName) {
		List<EquipmentMaintenanceLogDTO> list = new ArrayList<EquipmentMaintenanceLogDTO>();
		Date psDate = equipment.getNextMaintenanceDate();
		EquipmentMaintenanceLogDTO eMLogDTO;
		for (int i = 1; i <= 12 / cycle; i++) {
			eMLogDTO = new EquipmentMaintenanceLogDTO();
			eMLogDTO.setPlanStartDate(MyDateUtils.formaterDate(
					MyDateUtils.addMonths(psDate, cycle * i),
					MyDateUtils.DefFormatString));
			eMLogDTO.setResponsible(equipment.getResponsible());
			eMLogDTO.setCreateEmployNo(equipment.getResponsible());
			eMLogDTO.setPmType(cycleName);
			eMLogDTO.setRealEndDate("");
			eMLogDTO.setRealStartDate("");
			list.add(eMLogDTO);
		}
		return list;
	}

}

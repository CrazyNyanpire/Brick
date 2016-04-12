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
import acetecsemi.com.brick.facade.impl.assembler.CategoryAssembler;
import acetecsemi.com.brick.facade.impl.assembler.ChangeStatusAssembler;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentAssembler;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.OvenEquipmentOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformCPOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformFTOptionLogAssembler;
import acetecsemi.com.brick.facade.EquipmentFacade;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;
import acetecsemi.com.brick.application.EquipmentApplication;
import acetecsemi.com.brick.application.EquipmentOptionLogApplication;
import acetecsemi.com.brick.application.OvenEquipmentOptionLogApplication;
import acetecsemi.com.brick.application.PMDocumentApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class EquipmentFacadeImpl implements EquipmentFacade {

	@Inject
	private EquipmentApplication application;

	@Inject
	private EquipmentOptionLogApplication equipmentOptionLogApplication;

	@Inject
	private OvenEquipmentOptionLogApplication ovenEquipmentOptionLogApplication;

	@Inject
	private EquipmentOptionLogFacade equipmentOptionLogFacade;

	@Inject
	private PMDocumentApplication pmDocumentApplication;

	private QueryChannelService queryChannel;

	private static String STATUS_IDLE = "IDLE";

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public EquipmentDTO getEquipment(Long id) {
		EquipmentDTO equipmentDTO = EquipmentAssembler.toDTO(application
				.getEquipment(id));
		return equipmentDTO;
	}

	public Boolean creatEquipment(EquipmentDTO equipmentDTO) {
		equipmentDTO.setStatus(STATUS_IDLE);
		equipmentDTO.setSubStatus(STATUS_IDLE);
		equipmentDTO.setOptDate(new Date());
		Equipment equipment = EquipmentAssembler.toEntity(equipmentDTO);
		application.creatEquipment(equipment);
		EquipmentOptionLog equipmentOptionLog = EquipmentOptionLogAssembler
				.toEntity(equipmentDTO);
		equipmentOptionLog.setEquipment(equipment);
		equipmentOptionLog.setStartTime(equipmentDTO.getOptDate());
		// equipmentOptionLog.setOptUser(platform);
		equipmentOptionLogApplication
				.updateEquipmentOptionLog(equipmentOptionLog);
		return true;
	}

	public Boolean updateEquipment(EquipmentDTO equipmentDTO) {
		Equipment equipment = application.getEquipment(equipmentDTO.getId());
		application.updateEquipment(EquipmentAssembler.toEntity(equipment,
				equipmentDTO));
		return true;
	}

	public Boolean removeEquipment(Long id) {
		application.removeEquipment(application.getEquipment(id));
		return true;
	}

	public InvokeResult removeLogicEquipment(Long id) {
		Equipment equipment = Equipment.get(Equipment.class, id);
		if (equipment.getPlatform() == null) {
			equipment.setLogic(-1);
			// equipment.save();
			application.updateEquipment(equipment);
			return InvokeResult.success();
		} else {
			return InvokeResult.failure("请先将设备组装的平台分离！");
		}

	}

	public Boolean removeEquipments(Long[] ids) {
		Set<Equipment> equipments = new HashSet<Equipment>();
		for (Long id : ids) {
			equipments.add(application.getEquipment(id));
		}
		application.removeEquipments(equipments);
		return true;
	}

	public InvokeResult removeLogicEquipments(Long[] ids) {
		for (Long id : ids) {
			this.removeLogicEquipment(id);
		}
		return InvokeResult.success();
	}

	public List<EquipmentDTO> findAllEquipment() {
		return EquipmentAssembler.toDTOs(application.findAllEquipment());
	}

	public Page<EquipmentDTO> pageQueryEquipment(EquipmentDTO queryVo,
			int currentPage, int pageSize) {
		return this.pageQueryEquipment(queryVo, currentPage, pageSize, false);
	}

	public Page<EquipmentDTO> pageQueryEquipment(EquipmentDTO queryVo,
			int currentPage, int pageSize, boolean changeStatus) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _equipment from Equipment _equipment   where 1=1 ");
		jpql.append(" and (_equipment.logic <> -1 or _equipment.logic is null) ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _equipment.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _equipment.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _equipment.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _equipment.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _equipment.category.categoryName = ?");
			conditionVals
					.add(MessageFormat.format("{0}", queryVo.getCategory()));
		}
		if (queryVo.getEquipmentNo() != null
				&& !"".equals(queryVo.getEquipmentNo())) {
			jpql.append(" and _equipment.equipmentNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentNo()));
		}
		if (queryVo.getEquipmentName() != null
				&& !"".equals(queryVo.getEquipmentName())) {
			jpql.append(" and _equipment.equipmentName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentName()));
		}
		if (queryVo.getEquipmentCategory() != null
				&& !"".equals(queryVo.getEquipmentCategory())) {
			jpql.append(" and _equipment.equipmentCategory.categoryName = ?");
			conditionVals.add(queryVo.getEquipmentCategory());
		}

		if (queryVo.getResponsible() != null
				&& !"".equals(queryVo.getResponsible())) {
			jpql.append(" and _equipment.responsible like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getResponsible()));
		}
		if (queryVo.getAgent() != null && !"".equals(queryVo.getAgent())) {
			jpql.append(" and _equipment.agent like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getAgent()));
		}
		if (queryVo.getMaintenanceStartDate() != null) {
			jpql.append(" and _equipment.maintenanceStartDate between ? and ? ");
			conditionVals.add(queryVo.getMaintenanceStartDate());
			conditionVals.add(queryVo.getMaintenanceStartDateEnd());
		}
		if (queryVo.getRepairCycle() != null
				&& !"".equals(queryVo.getRepairCycle())) {
			jpql.append(" and _equipment.repairCycle like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getRepairCycle()));
		}
		if (queryVo.getCalibrationCycle() != null
				&& !"".equals(queryVo.getCalibrationCycle())) {
			jpql.append(" and _equipment.calibrationCycle like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCalibrationCycle()));
		}
		if (queryVo.getEquipmentLocation() != null
				&& !"".equals(queryVo.getEquipmentLocation())) {
			jpql.append(" and _equipment.equipmentLocation like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentLocation()));
		}
		if (queryVo.getCheckInTime() != null) {
			jpql.append(" and _equipment.checkInTime between ? and ? ");
			conditionVals.add(queryVo.getCheckInTime());
			conditionVals.add(queryVo.getCheckInTimeEnd());
		}
		if (queryVo.getAcceptanceList() != null
				&& !"".equals(queryVo.getAcceptanceList())) {
			jpql.append(" and _equipment.acceptanceList like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getAcceptanceList()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _equipment.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		if (queryVo.getEquipmentLocationId() != null) {
			jpql.append(" and _equipment.equipmentLocation.id = ?");
			conditionVals.add(queryVo.getEquipmentLocationId());
		}
		if (changeStatus) {
			jpql.append(" and _equipment.equipmentCategory.sign = 'changeStatus'");
		}
		jpql.append(" order by _equipment.equipmentNo");
		@SuppressWarnings("unchecked")
		Page<Equipment> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<EquipmentDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, EquipmentAssembler.toDTOs(pages.getData()));
	}

	@Override
	public PlatformDTO findPlatformByEquipment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentDTO> findEquipmentByPlatform(Long id) {
		String jpql = "select o from Equipment o right join o.platform e where e.id=?";
		@SuppressWarnings("unchecked")
		List<Equipment> result = (List<Equipment>) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.list();
		return EquipmentAssembler.toDTOs(result);
	}

	@Override
	public List<EquipmentDTO> findEquipments(EquipmentDTO queryVo) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _equipment from Equipment _equipment  where 1=1 ");
		if (queryVo.getEquipmentCategoryId() != null) {
			jpql.append(" and _equipment.equipmentCategory.id = ?");
			conditionVals.add(queryVo.getEquipmentCategoryId());
		}
		if (queryVo.getCategoryId() != null) {
			jpql.append(" and _equipment.category.id = ?");
			conditionVals.add(queryVo.getCategoryId());
		}
		if (queryVo.getComposability() != null
				&& !"".equals(queryVo.getComposability())) {
			jpql.append(" and _equipment.composability = ?");
			conditionVals.add(queryVo.getComposability());
		}
		if (queryVo.getIsInstalled() != null && !queryVo.getIsInstalled()) {
			jpql.append(" and _equipment.platform is null");
			jpql.append(" and _equipment.equipmentCategory.id <> 7");
		}
		if (queryVo.getUnInstallTester() != null
				&& queryVo.getUnInstallTester()) {
			jpql.append(" and _equipment.id not in (select platform.tester.id from Platform platform)");
		}
		@SuppressWarnings("unchecked")
		List<Equipment> list = (List<Equipment>) getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return EquipmentAssembler.toDTOs(list);
	}

	@Override
	public String changeEquipmentStatus(EquipmentDTO equipmentDTO) {
		this.savePMDocument(equipmentDTO);
		if (equipmentDTO.getProductModel() == null) {
			equipmentDTO.setProductModel(equipmentDTO.getNowProduct());
		}
		Equipment equipment = Equipment.get(Equipment.class,
				equipmentDTO.getId());
		if (equipmentDTO.getStatusId() != null
				&& equipmentDTO.getSubStatusId() != null) {
			Category status = Category.get(Category.class,
					equipmentDTO.getStatusId());
			Category subStatus = Category.get(Category.class,
					equipmentDTO.getSubStatusId());
			equipmentDTO.setStatus(status.getCategoryName());
			equipmentDTO.setSubStatus(subStatus.getCategoryName());
			equipment.setStatus(status.getCategoryName());
			equipment.setSubStatus(subStatus.getCategoryName());
			if (equipmentDTO.getOptDate() == null) {
				equipmentDTO.setOptDate(new Date());
			}
			if (equipmentDTO.getNextMaintenanceDate() != null) {
				equipment.setNextMaintenanceDate(equipmentDTO
						.getNextMaintenanceDate());
				equipment.setNextMaintenancePlanDate(equipmentDTO
						.getNextMaintenancePlanDate());
				equipment.setNowMaintenancePlanDate(equipmentDTO
						.getNowMaintenancePlanDate());
			}
			equipment.setNowLot(equipmentDTO.getNowLot());
			equipment.setProductModel(equipmentDTO.getProductModel());
			equipment.setLastModifyEmployNo(equipmentDTO
					.getLastModifyEmployNo());
			// 保存嫁动前状态信息
			equipmentOptionLogFacade.saveLastEquipmentOptionLogEndTime(
					equipment.getId(), equipmentDTO);
			application.updateEquipment(equipment);
			// 保存嫁动后状态信息
			if (equipment.getCategory().getId() == 11) {
				OvenEquipmentOptionLog ovenEquipmentOptionLog = OvenEquipmentOptionLogAssembler
						.toEntity(equipmentDTO);
				ovenEquipmentOptionLog.setEquipment(equipment);
				ovenEquipmentOptionLogApplication
						.updateOvenEquipmentOptionLog(ovenEquipmentOptionLog);
			} else {
				EquipmentOptionLog equipmentOptionLog = EquipmentOptionLogAssembler
						.toEntity(equipmentDTO);
				equipmentOptionLog.setChipSelection(equipmentDTO.getPianxuan());
				equipmentOptionLog.setChipSelectionRemark(equipmentDTO
						.getPianxuanBeizhu());
				equipmentOptionLog.setEquipment(equipment);
				equipmentOptionLog.setStartTime(equipmentDTO.getOptDate());
				equipmentOptionLog
						.setProductModel(equipmentDTO.getNowProduct());
				equipmentOptionLog.setEndOptUser(equipmentDTO.getOptUser());
				equipmentOptionLog.setGrossDie(equipmentDTO.getGrossDie());
				equipmentOptionLogApplication
						.updateEquipmentOptionLog(equipmentOptionLog);
			}
			return null;
		}
		return "状态改变失败！";

	}

	@Override
	public Page<EquipmentDTO> changeStatusPageQueryEquipment(
			EquipmentDTO equipment, int currentPage, int pageSize) {
		return this.pageQueryEquipment(equipment, currentPage, pageSize, true);
	}

	@Override
	public List<EquipmentDTO> findTesterEquipments() {
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setEquipmentCategoryId(Long.valueOf(7));
		equipmentDTO.setUnInstallTester(true);
		return this.findEquipments(equipmentDTO);
	}

	@Override
	public List<EquipmentDTO> findComposabilityEquipments() {
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setComposability(true);
		equipmentDTO.setIsInstalled(false);// 过滤是否已经被组装
		return this.findEquipments(equipmentDTO);
	}

	@Override
	public List<CategoryDTO> findEquipmentCategroyAll() {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select distinct _equipment.category from Equipment _equipment  where 1=1 ");
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return CategoryAssembler.toDTOs(list, false);
	}

	private void savePMDocument(EquipmentDTO equipmentDTO) {
		if (equipmentDTO.getAcceptanceList() != null
				&& !"".equals(equipmentDTO.getAcceptanceList())
				&& equipmentDTO.getPmType() != null
				&& !"".equals(equipmentDTO.getPmType())) {
			PMDocument pmDocument = new PMDocument();
			pmDocument.setFileUrl(equipmentDTO.getAcceptanceList());
			String[] strArr = equipmentDTO.getAcceptanceList().split("/");
			pmDocument.setFileName(strArr[strArr.length - 1]);
			pmDocument.setUploadUser(equipmentDTO.getLastModifyEmployNo());
			pmDocument.setUploadDate(new Date());
			pmDocument.setPmType(equipmentDTO.getPmType());
			if (equipmentDTO.getEquipmentMaintenanceLogId() != null) {
				EquipmentMaintenanceLog equipmentMaintenanceLog = new EquipmentMaintenanceLog();
				equipmentMaintenanceLog.setId(equipmentDTO
						.getEquipmentMaintenanceLogId());
				pmDocument.setEquipmentMaintenanceLog(equipmentMaintenanceLog);
			}
			String jpql = "select o from EquipmentOptionLog o where o.equipment.id=? order by o.id desc";
			EquipmentOptionLog result = (EquipmentOptionLog) getQueryChannelService()
					.createJpqlQuery(jpql)
					.setParameters(new Object[] { equipmentDTO.getId() })
					.singleResult();
			pmDocument.setEquipmentOptionLog(result);
			pmDocumentApplication.creatPMDocument(pmDocument);
		}
	}

	@Override
	public InvokeResult checkEquipmentAssemble(Long id) {
		Equipment equipment = application.getEquipment(id);
		if (equipment.getPlatform() != null) {
			return InvokeResult.success("设备已组装平台！");
		}
		if (this.checkTester(id)) {
			return InvokeResult.success("设备已组装平台！");
		}
		return InvokeResult.failure("设备未组装平台！");
	}

	private boolean checkTester(Long id) {
		String jpql = "select o from Platform o where o.tester.id=? order by o.id desc";
		Platform result = (Platform) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		if (result != null && result.getEquipmentChildren() != null
				&& result.getEquipmentChildren().size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, String>> getEquipmentNoByLot(
			EquipmentDTO equipmentDTO) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder("SELECT nowlot,");
		jpql.append("max(CASE equipmentCategory_ID WHEN '7' THEN equipmentNo ELSE '' END) tester,");
		jpql.append("max(CASE equipmentCategory_ID WHEN '8' THEN equipmentNo ELSE '' END) handler ");
		jpql.append("from (");
		jpql.append("SELECT a.nowLot,b.equipmentCategory_ID,b.equipmentNo from brick_statustoptionlog a INNER JOIN brick_equipment b on a.EQUIPMENT_ID = b.ID ");
		jpql.append("where ");
		jpql.append("CATEGORY = 'EQUIPMENT'");
		if (equipmentDTO.getNowLot() != null
				&& !"".equals(equipmentDTO.getNowLot())) {
			jpql.append(" and a.NowLot = ? ");
			conditionVals.add(equipmentDTO.getNowLot());
		}
		if (equipmentDTO.getNowStation() != null
				&& !"".equals(equipmentDTO.getNowStation())) {
			jpql.append(" and a.status = ? ");
			conditionVals.add(this.stationToStatusMap.get(equipmentDTO
					.getNowStation()));
		}
		jpql.append(") a group by nowLot");
		@SuppressWarnings("unchecked")
		List<Object[]> list = getQueryChannelService()
				.createSqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (Object[] array : list) {
			result.add(this.toMap(array));
		}
		return result;
	}

	private Map<String, String> toMap(Object[] objects) {
		if (objects == null) {
			return null;
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("lotNo", objects[0] != null ? objects[0].toString() : "");
		result.put("testerNo", objects[1] != null ? objects[1].toString() : "");
		result.put("handlerNo", objects[2] != null ? objects[2].toString() : "");
		return result;
	}

	public Map<String, String> stationToStatusMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("FT", "RUN");
			put("EQC", "EQC_RUN");
		}
	};

}

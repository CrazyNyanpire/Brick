package acetecsemi.com.brick.facade.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentAssembler;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformCPOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformFTOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardOptionLogAssembler;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;
import acetecsemi.com.brick.facade.PlatformFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.facade.ProbeCardFacade;
import acetecsemi.com.brick.facade.ProbeCardOptionLogFacade;
import acetecsemi.com.brick.facade.SocketFacade;
import acetecsemi.com.brick.facade.SocketOptionLogFacade;
import acetecsemi.com.brick.infra.MaintenanceProbeCardSendNotice;
import acetecsemi.com.brick.infra.MesTimeClient;
import acetecsemi.com.brick.application.EquipmentApplication;
import acetecsemi.com.brick.application.EquipmentOptionLogApplication;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.application.PlatformCPOptionLogApplication;
import acetecsemi.com.brick.application.PlatformFTOptionLogApplication;
import acetecsemi.com.brick.application.PlatformOptionLogApplication;
import acetecsemi.com.brick.application.ProbeCardApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
@Transactional
public class PlatformFacadeImpl implements PlatformFacade {

	@Inject
	private PlatformApplication application;

	@Inject
	private PlatformOptionLogApplication platformOptionLogApplication;

	@Inject
	private PlatformCPOptionLogApplication platformCPoptionLogApplication;

	@Inject
	private PlatformFTOptionLogApplication platformFToptionLogApplication;

	@Inject
	private EquipmentApplication equipmentApplication;

	@Inject
	private EquipmentOptionLogApplication equipmentOptionLogApplication;

	@Inject
	private EquipmentOptionLogFacade equipmentOptionLogFacade;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	private QueryChannelService queryChannel;

	private static String STATUS_SPLIT = "拆分平台";

	private static String STATUS_ASSEMBLY = "组装平台";

	private static String STATUS_IDLE = "IDLE";

	private static String STATUS_IDLE_NO_MATERIAL = "无料可测";

	private static Long ZERO = Long.valueOf(0);

	private static String INITSITETESTQTY = "0,0,0,0";

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public PlatformDTO getPlatform(Long id) {
		return PlatformAssembler.toDTO(application.getPlatform(id));
	}

	public String creatPlatform(PlatformDTO platformDTO) {
		if (platformDTO.getTesterId() != null) {
			Platform platform = PlatformAssembler.toEntity(platformDTO);
			platform.setCheckInTime(new Date());
			platform.setStatus(STATUS_IDLE);
			platform.setSubSstatus(STATUS_IDLE_NO_MATERIAL);
			platform.setTester(equipmentApplication.getEquipment(platformDTO
					.getTesterId()));
			platform.setCreateEmployNo(platformDTO.getLastModifyEmployNo());
			platform.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			application.creatPlatform(platform);
			PlatformOptionLog platformOptionLog = new PlatformOptionLog();
			platformOptionLog.setOptDate(new Date());
			platformOptionLog.setPlatform(platform);
			platformOptionLog.setCreateEmployNo(platform.getCreateEmployNo());
			platformOptionLog.setOptRemark("初始化平台…");
			platformOptionLog.setCreateEmployNo(platformDTO
					.getLastModifyEmployNo());
			platformOptionLog.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			platformOptionLogApplication
					.creatPlatformOptionLog(platformOptionLog);
			return null;
		}
		return "值为空！";
	}

	public Boolean updatePlatform(PlatformDTO platformDTO) {
		application.updatePlatform(PlatformAssembler.toEntity(platformDTO));
		return true;
	}

	public Boolean assemblePlatform(PlatformDTO platformDTO) {
		Platform platform = Platform.get(Platform.class, platformDTO.getId());
		if (platformDTO.getOptDate() == null) {
			platformDTO.setOptDate(new Date());
		}

		StringBuffer remark = new StringBuffer();
		remark.append(STATUS_ASSEMBLY);
		for (String id : platformDTO.getEquipmentIds().split(",")) {
			Equipment equipment = equipmentApplication.getEquipment(Long
					.valueOf(id));
			equipment.setStatus(STATUS_IDLE);
			equipment.setSubStatus(STATUS_IDLE_NO_MATERIAL);
			equipment.setPlatform(platform);
			equipment
					.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			equipmentApplication.updateEquipment(equipment);
			equipmentOptionLogFacade.saveLastEquipmentOptionLogEndTime(
					equipment.getId(), platformDTO);
			EquipmentOptionLog equipmentOptionLog = new EquipmentOptionLog();
			equipmentOptionLog.setStatus(STATUS_IDLE);
			equipmentOptionLog.setSubStatus(STATUS_IDLE_NO_MATERIAL);
			equipmentOptionLog.setEquipment(equipment);
			equipmentOptionLog.setOptDate(platformDTO.getOptDate());
			equipmentOptionLog.getCategory();
			equipmentOptionLog.setCreateEmployNo(platformDTO
					.getLastModifyEmployNo());
			equipmentOptionLog.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			if ("handler".equals(equipment.getCategory().getCategoryParent()
					.getCategoryName())) {
				platform.setPlatformCategory("FT");
			} else if ("probe".equals(equipment.getCategory()
					.getCategoryParent().getCategoryName())) {
				platform.setPlatformCategory("CP");
			}
			// equipmentOptionLog.setOptUser(platform);
			equipmentOptionLog.setOptRemark(STATUS_ASSEMBLY);
			equipmentOptionLogApplication
					.updateEquipmentOptionLog(equipmentOptionLog);
			remark.append("-").append(equipment.getEquipmentNo());
		}
		platform.setStatus(STATUS_IDLE);
		platform.setSubSstatus(STATUS_IDLE_NO_MATERIAL);
		platform.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		application.updatePlatform(platform);
		this.saveOptionLog(platform, platformDTO, remark.toString());
		return true;
	}

	public Boolean splitPlatform(PlatformDTO platformDTO) {
		Platform platform = Platform.get(Platform.class, platformDTO.getId());
		platformDTO.setStatus(STATUS_IDLE);
		platformDTO.setSubStatus(STATUS_IDLE_NO_MATERIAL);
		if (platform.getPlatformCategory() == null) {
			return true;
		}
		if (platformDTO.getOptDate() == null) {
			platformDTO.setOptDate(new Date());
		}
		if (platformDTO.getStartTime() == null) {
			platformDTO.setOptDate(new Date());
		}
		StringBuffer remark = new StringBuffer();
		remark.append(STATUS_SPLIT);
		for (Equipment equipment : platform.getEquipmentChildren()) {
			equipment.setPlatform(null);
			equipment.setStatus(STATUS_IDLE_NO_MATERIAL);
			equipmentApplication.updateEquipment(equipment);
			equipmentOptionLogFacade.saveLastEquipmentOptionLogEndTime(
					equipment.getId(), platformDTO);
			EquipmentOptionLog equipmentOptionLog = new EquipmentOptionLog();
			equipmentOptionLog.setStatus(STATUS_IDLE);
			equipmentOptionLog.setSubStatus(STATUS_IDLE_NO_MATERIAL);
			equipmentOptionLog.setEquipment(equipment);
			equipmentOptionLog.setOptDate(platformDTO.getOptDate());
			equipmentOptionLog.setStartTime(platformDTO.getOptDate());
			// equipmentOptionLog.setOptUser(platform);
			equipmentOptionLog.setOptRemark(STATUS_SPLIT);
			equipmentOptionLog.setCreateEmployNo(platformDTO
					.getLastModifyEmployNo());
			equipmentOptionLog.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			equipmentOptionLogApplication
					.updateEquipmentOptionLog(equipmentOptionLog);
			// remark.append("-").append(equipment.getEquipmentNo());
		}
		platform.setStatus(STATUS_IDLE_NO_MATERIAL);
		application.updatePlatform(platform);
		this.saveOptionLog(platform, platformDTO, remark.toString());
		return true;
	}

	public Boolean removePlatform(Long id) {
		application.removePlatform(application.getPlatform(id));
		return true;
	}

	public Boolean removePlatforms(Long[] ids) {
		Set<Platform> platforms = new HashSet<Platform>();
		for (Long id : ids) {
			platforms.add(application.getPlatform(id));
		}
		application.removePlatforms(platforms);
		return true;
	}

	public List<PlatformDTO> findAllPlatform() {
		return PlatformAssembler.toDTOs(application.findAllPlatform());
	}

	public Page<PlatformDTO> pageQueryPlatform(PlatformDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _platform from Platform _platform  where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _platform.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _platform.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _platform.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _platform.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getPlatformNo() != null
				&& !"".equals(queryVo.getPlatformNo())) {
			jpql.append(" and _platform.tester.equipmentNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformNo()));
		}
		if (queryVo.getPlatformName() != null
				&& !"".equals(queryVo.getPlatformName())) {
			jpql.append(" and _platform.platformName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformName()));
		}
		if (queryVo.getPlatformCategory() != null
				&& !"".equals(queryVo.getPlatformCategory())) {
			jpql.append(" and _platform.platformCategory like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformCategory()));
		}
		if (queryVo.getMaintenanceStartDate() != null) {
			jpql.append(" and _platform.maintenanceStartDate between ? and ? ");
			conditionVals.add(queryVo.getMaintenanceStartDate());
			conditionVals.add(queryVo.getMaintenanceStartDateEnd());
		}
		if (queryVo.getCheckInTime() != null) {
			jpql.append(" and _platform.checkInTime between ? and ? ");
			conditionVals.add(queryVo.getCheckInTime());
			conditionVals.add(queryVo.getCheckInTimeEnd());
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _platform.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		jpql.append(" order by _platform.tester.equipmentNo ");
		Page<Platform> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<PlatformDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, PlatformAssembler.toDTOs(pages.getData()));
	}

	public PlatformDTO findPlatformByPlatform(Long id) {
		String jpql = "select e from Platform o right join o.platform e where o.id=?";
		Platform result = (Platform) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		PlatformDTO dto = new PlatformDTO();
		if (result != null) {
			try {
				BeanUtils.copyProperties(dto, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * 改变平台状态
	 * 
	 * @param platformDTO
	 *            (id/statusId/subStatusId必须要有)
	 * @return Boolean
	 */
	public String changePlatformStatus(PlatformDTO platformDTO) {
		Platform platform = Platform.get(Platform.class, platformDTO.getId());
		platformDTO.setProductModel(platformDTO.getNowProduct());
		if (!this.checkProbeCardProduct(platform, platformDTO)) {
			return "当前Probe Card不支持产品型号:" + platformDTO.getProductModel();
		}
		if (platform.getEquipmentChildren() != null
				&& platform.getEquipmentChildren().size() > 0
				&& platformDTO.getStatusId() != null
				&& platformDTO.getSubStatusId() != null) {
			if (platformDTO.getOptDate() == null) {
				platformDTO.setOptDate(new Date());
				platformDTO.setEndTime(platformDTO.getOptDate());
			}
			platformDTO.setPlatformCategory(platform.getPlatformCategory());
			platformDTO.setCategory(platform.getTester().getCategory()
					.getCategoryName());
			platformDTO.setPlatformNo(platform.getTester().getEquipmentName());
			Category status = Category.get(Category.class,
					platformDTO.getStatusId());
			platformDTO.setStatus(status.getCategoryName());
			// 保存嫁动前状态信息
			PlatformOptionLogDTO lastPlatformOptionLog = platformOptionLogFacade
					.saveLastPlatformOptionLogEndTime(platform.getId(),
							platformDTO);
			if (lastPlatformOptionLog == null) {
				return "测试数填写有误,上状态测试数小于0！";
			}
			// 保存嫁动后状态信息
			platform.setStatus(status.getCategoryName());
			Category subStatus = Category.get(Category.class,
					platformDTO.getSubStatusId());
			platformDTO.setSubStatus(subStatus.getCategoryName());
			platform.setSubSstatus(subStatus.getCategoryName());
			platform.setNowLot(platformDTO.getNowLot());
			platform.setProductModel(platformDTO.getProductModel());
			platform.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			application.updatePlatform(platform);

			platformDTO.setPlatformCategory(platform.getPlatformCategory());
			if ("CP".equals(platform.getPlatformCategory())) {
				// 保存嫁动后状态信息
				this.saveCPOptionLog(platform, platformDTO,
						lastPlatformOptionLog);
			} else if ("FT".equals(platform.getPlatformCategory())) {
				// 保存嫁动后状态信息
				this.saveFTOptionLog(platform, platformDTO,
						lastPlatformOptionLog);
			}
			// 更新设备状态
			//保存测试数量到设备日志中
			//platformDTO.setTouchTimes(lastPlatformOptionLog.getTouchTimes());
			for (Equipment equipment : platform.getEquipmentChildren()) {
				equipment.setPlatform(platform);
				equipment.setNowLot(platformDTO.getNowLot());
				equipment.setProductModel(platformDTO.getProductModel());
				equipment.setStatus(status.getCategoryName());
				equipment.setSubStatus(subStatus.getCategoryName());
				equipment.setLastModifyEmployNo(platformDTO
						.getLastModifyEmployNo());
				equipmentApplication.updateEquipment(equipment);
				this.changeEquipmentLog(platformDTO, equipment);
			}
			Equipment tester = platform.getTester();
			tester.setNowLot(platformDTO.getNowLot());
			tester.setProductModel(platformDTO.getProductModel());
			tester.setStatus(status.getCategoryName());
			tester.setSubStatus(subStatus.getCategoryName());
			equipmentApplication.updateEquipment(tester);
			this.changeEquipmentLog(platformDTO, tester);
			return null;
		}
		return "状态改变失败！";
	}

	/**
	 * 检查选择的Probe Card是否Release对应的产品型号
	 * 
	 * @param platform
	 * @param platformDTO
	 * @return 符合返回true
	 */
	private boolean checkProbeCardProduct(Platform platform,
			PlatformDTO platformDTO) {
		if("NA".equals(platformDTO.getProductModel().toUpperCase())){
			return true;
		}
		if ("CP".equals(platform.getPlatformCategory())) {
			ProbeCard probeCard = ProbeCard.get(ProbeCard.class,
					Long.valueOf(platformDTO.getPartIds()));
			if (probeCard.getProductModel().indexOf(
					platformDTO.getProductModel()) > -1) {
				return true;
			}
			return false;
		}
		return true;
	}

	private void saveOptionLog(Platform platform, PlatformDTO platformDTO,
			String remark) {
		this.saveOptionLog(platform, platformDTO, remark, null);
	}

	private void saveOptionLog(Platform platform, PlatformDTO platformDTO,
			String remark, PlatformOptionLogDTO lastPlatformOptionLog) {

	}

	private void saveCPOptionLog(Platform platform, PlatformDTO platformDTO,
			PlatformOptionLogDTO lastPlatformOptionLog) {
		PlatformCPOptionLog platformOptionLog = PlatformCPOptionLogAssembler
				.toEntity(platformDTO);
		platformOptionLog.setTouchTimes(ZERO);
		platformOptionLog.setId(null);
		platformOptionLog.setPlatform(platform);
		platformOptionLog.setCreateEmployNo(platform.getCreateEmployNo());
		platformOptionLog.setCategoryPlatform(platform.getPlatformCategory());
		platformOptionLog.setCategory(platform.getPlatformCategory());
		platformOptionLog.setOptRemark(platformDTO.getOptRemark());
		platformOptionLog.setStartTime(platformDTO.getOptDate());
		platformOptionLog.setEndTime(null);
		platformOptionLog.setOptUser(platformDTO.getOptUser());
		platformOptionLog.setStandardWorkHours(platformDTO
				.getStandardWorkHours());
		platformOptionLog.setGrossDie(platformDTO.getGrossDie());
		platformOptionLog.setEngTouchDown(platformDTO.getEngTouchDown());
		platformOptionLog.setTeam(platformDTO.getTeam());
		// 换批处理上状态测试数，需要增加状态判断s
		// 批次为"NA",嫁动前状态不等于嫁动后状态时上状态测试数为0
		if (lastPlatformOptionLog.getId() == null
				|| !lastPlatformOptionLog.getNowLot().equals(
						platformDTO.getNowLot())
				|| "NA".equals(platformDTO.getNowLot())
				|| "SET_UP".equals(platformOptionLog.getStatus())) {
			platformOptionLog.setChipSelection("");
			platformOptionLog.setChipSelectionRemark("");
			platformOptionLog.setProductModel(platformDTO.getProductModel());
			platformDTO.setTouchTimes(ZERO);
			platformOptionLog.setLastWaferTD(String.valueOf(ZERO));
		} else {
			platformOptionLog.setChipSelection(lastPlatformOptionLog
					.getCompletedChip());
			platformOptionLog.setChipSelectionRemark(lastPlatformOptionLog
					.getCompletedChipDescription());
			platformOptionLog.setProductModel(lastPlatformOptionLog
					.getProductModel());
			platformDTO.setTouchTimes(lastPlatformOptionLog.getTouchTimes());
			platformOptionLog.setLastWaferTD(lastPlatformOptionLog
					.getNowWaferTD());
		}
		if ("NA".equals(platformDTO.getNowLot())) {
			platformOptionLog.setProductModel("NA");
			platformOptionLog.setNowStation("NA");
		}
		platformOptionLog.setPartIds(platformDTO.getPartIds());
		platformOptionLog
				.setPcNo(this.getPcNo(platformDTO.getPartIds() == null ? ""
						: platformDTO.getPartIds()));
		platformCPoptionLogApplication
				.updatePlatformCPOptionLog(platformOptionLog);
	}

	private void saveFTOptionLog(Platform platform, PlatformDTO platformDTO,
			PlatformOptionLogDTO lastPlatformOptionLog) {
		PlatformFTOptionLog platformOptionLog = PlatformFTOptionLogAssembler
				.toEntity(platformDTO);
		platformOptionLog.setId(null);
		platformOptionLog.setPlatform(platform);
		platformOptionLog
				.setCreateEmployNo(platformDTO.getLastModifyEmployNo());
		platformOptionLog.setCategoryPlatform(platform.getPlatformCategory());
		platformOptionLog.setCategory(platform.getPlatformCategory());
		platformOptionLog.setOptRemark(platformDTO.getOptRemark());
		platformOptionLog.setStartTime(platformDTO.getOptDate());
		platformOptionLog.setTouchTimes(ZERO);
		platformOptionLog.setLastSiteTestQty(lastPlatformOptionLog
				.getNowSiteTestQty());
		platformOptionLog.setSiteTestQty(platformDTO.getSiteTestQty());
		platformOptionLog.setEndTime(null);
		platformOptionLog.setOptUser(platformDTO.getOptUser());
		platformOptionLog.setTheoryTime(platformDTO.getTheoryTime());
		platformOptionLog.setStandardWorkHours(platformDTO
				.getStandardWorkHours());
		platformOptionLog.setKitsId(platformDTO.getKitsId());
		platformOptionLog.setLoadBoardId(platformDTO.getLoadBoardId());
		// 换批处理上状态测试数，需要增加状态判断
		// 批次为"NA",嫁动前状态不等于嫁动后状态时上状态测试数为0
		if (lastPlatformOptionLog.getId() == null
				|| !lastPlatformOptionLog.getNowLot().equals(
						platformDTO.getNowLot()) || "NA".equals(platformDTO)) {
			platformOptionLog.setLastTestNo(ZERO);
			platformOptionLog.setLastSiteTestQty(INITSITETESTQTY);
			platformOptionLog.setProductModel(platformDTO.getProductModel());
		} else {
			platformOptionLog.setLastTestNo(lastPlatformOptionLog
					.getNowTestNo());
			platformOptionLog.setLastSiteTestQty(lastPlatformOptionLog
					.getNowSiteTestQty());
			platformOptionLog.setProductModel(lastPlatformOptionLog
					.getProductModel());
		}
		// R/T_RUN或者LAT_RUN或者REWORK时清空上状态测试数
		switch (platformDTO.getStatusId().intValue()) {
		case 42:
			platformOptionLog.setLastTestNo(ZERO);
			platformOptionLog.setLastSiteTestQty(INITSITETESTQTY);
			break;
		case 105:
		case 106:
		case 107:
		case 108:
		case 67:
		case 45:
			PlatformOptionLog platformOptionLogHis = this.checkHisStatus(
					platformDTO.getNowLot(), platformDTO.getId(),
					platformDTO.getStatus());
			if (platformOptionLogHis == null) {
				platformOptionLog.setLastTestNo(ZERO);
				platformOptionLog.setLastSiteTestQty(INITSITETESTQTY);
			} else {
				platformOptionLog.setLastTestNo(platformOptionLogHis
						.getNowTestNo());
				platformOptionLog.setLastSiteTestQty(platformOptionLogHis
						.getNowSiteTestQty());
			}
			break;
		}
		platformOptionLog.setPartIds(platformDTO.getPartIds() == null
				|| "".equals(platformDTO.getPartIds()) ? ",,," : platformDTO
				.getPartIds());
		platformOptionLog
				.setPcNo(this.getPcNo(platformDTO.getPartIds() == null ? ",,,"
						: platformDTO.getPartIds()));
		platformFToptionLogApplication
				.updatePlatformFTOptionLog(platformOptionLog);

	}

	private PlatformOptionLog checkHisStatus(String lotNo, Long platformId,
			String status) {
		String jpql = "select o from PlatformOptionLog o where o.nowLot=? and o.platform.id=? order by id desc";
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(lotNo);
		conditionVals.add(platformId);
		List<PlatformOptionLog> result = (List<PlatformOptionLog>) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(conditionVals).list();
		for (PlatformOptionLog platformOptionLog : result) {
			if (status.equals(platformOptionLog.getStatus())) {
				return platformOptionLog;
			}
		}
		return null;

	}

	private void changeEquipmentLog(PlatformDTO platformDTO, Equipment equipment) {
		EquipmentOptionLog equipmentOptionLog = EquipmentOptionLogAssembler
				.toEntity(platformDTO);
		equipmentOptionLog.setId(null);
		equipmentOptionLog.setStatus(platformDTO.getStatus());
		equipmentOptionLog.setSubStatus(platformDTO.getSubStatus());
		equipmentOptionLog.setEquipment(equipment);
		equipmentOptionLog.setOptDate(platformDTO.getOptDate());
		equipmentOptionLog.setStartTime(platformDTO.getOptDate());
		equipmentOptionLog.setEndTime(null);
		equipmentOptionLog.setTouchTimes(platformDTO.getTouchTimes());
		equipmentOptionLog.setCreateEmployNo(platformDTO
				.getLastModifyEmployNo());
		equipmentOptionLog.setLastModifyEmployNo(platformDTO
				.getLastModifyEmployNo());
		equipmentOptionLog.setOptUser(platformDTO.getOptUser());
		equipmentOptionLog.setTheoryTime(platformDTO.getTheoryTime());
		equipmentOptionLog.setStandardWorkHours(platformDTO
				.getStandardWorkHours());
		// equipmentOptionLog.setOptUser(platform);
		// 更新上状态时间
		equipmentOptionLogFacade.saveLastEquipmentOptionLogEndTime(
				equipment.getId(), platformDTO);
		equipmentOptionLog.setTouchTimes(Long.valueOf(0));
		equipmentOptionLogApplication
				.updateEquipmentOptionLog(equipmentOptionLog);
	}

	public List<PlatformDTO> findPlatformByType(String type) {
		String jpql = "select o from Platform o where o.platformCategory=?";
		List<Platform> result = (List<Platform>) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { type })
				.list();
		PlatformDTO dto = new PlatformDTO();
		if (result != null) {
			try {
				BeanUtils.copyProperties(dto, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PlatformAssembler.toDTOs(result);
	}

	@Override
	public List<EquipmentDTO> findEquipmentsByPlatform(Long id) {
		String jpql = "select o from Equipment o right join o.platform e where e.id=?";
		@SuppressWarnings("unchecked")
		List<Equipment> list = (List<Equipment>) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.list();
		List<EquipmentDTO> result = EquipmentAssembler.toDTOs(list);
		EquipmentDTO equipmentDTO = EquipmentAssembler.toDTO(application
				.getPlatform(id).getTester());
		result.add(equipmentDTO);
		return result;
	}

	private String getPcNo(String ids) {
		List<Long> socketIds = new ArrayList<Long>();
		List<String> pcNos = new ArrayList<String>();
		for (String id : ids.split(",", -1)) {
			if (!"".equals(id)) {
				socketIds.add(Long.valueOf(id));
				Part part = Part.get(Part.class, Long.valueOf(id));
				pcNos.add(part.getPartNo());
			} else {
				socketIds.add(null);
				pcNos.add("");
			}
		}
		return StringUtils.join(pcNos, ",");
	}

	@Override
	public PlatformDTO findPlatformByEquipmentNo(String equipmentNo) {
		String jpql = "select o from Platform o inner join o.tester e where e.equipmentNo=?";
		@SuppressWarnings("unchecked")
		Platform result = (Platform) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { equipmentNo }).singleResult();
		return PlatformAssembler.toDTO(result);
	}
}

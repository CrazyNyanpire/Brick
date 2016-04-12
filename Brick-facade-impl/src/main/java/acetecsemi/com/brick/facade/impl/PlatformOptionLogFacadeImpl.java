package acetecsemi.com.brick.facade.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.springframework.beans.BeanUtils;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformOptionLogAssembler;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;
import acetecsemi.com.brick.facade.KitsFacade;
import acetecsemi.com.brick.facade.KitsOptionLogFacade;
import acetecsemi.com.brick.facade.LoadBoardFacade;
import acetecsemi.com.brick.facade.LoadBoardOptionLogFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.facade.ProbeCardFacade;
import acetecsemi.com.brick.facade.ProbeCardOptionLogFacade;
import acetecsemi.com.brick.facade.SocketFacade;
import acetecsemi.com.brick.facade.SocketOptionLogFacade;
import acetecsemi.com.brick.infra.MaintenanceProbeCardSendNotice;
import acetecsemi.com.brick.infra.MesTimeClient;
import acetecsemi.com.brick.application.EquipmentOptionLogApplication;
import acetecsemi.com.brick.application.PlatformOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PlatformOptionLogFacadeImpl implements PlatformOptionLogFacade {

	@Inject
	private PlatformOptionLogApplication application;

	@Inject
	private SocketFacade socketFacade;

	@Inject
	private SocketOptionLogFacade socketOptionLogFacade;

	@Inject
	private ProbeCardFacade probeCardFacade;

	@Inject
	private ProbeCardOptionLogFacade probeCardOptionLogFacade;

	@Inject
	private MaintenanceProbeCardSendNotice maintenanceProbeCardSendNotice;

	@Inject
	private EquipmentOptionLogFacade equipmentOptionLogFacade;

	@Inject
	private EquipmentOptionLogApplication equipmentOptionLogApplication;

	@Inject
	private MesTimeClient mesTimeClient;

	@Inject
	private KitsFacade kitsFacade;

	@Inject
	private KitsOptionLogFacade kitsOptionLogFacade;
	
	@Inject
	private LoadBoardFacade loadBoardFacade;

	@Inject
	private LoadBoardOptionLogFacade loadBoardOptionLogFacade;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public PlatformOptionLogDTO getPlatformOptionLog(Long id) {
		return PlatformOptionLogAssembler.toDTO(application
				.getPlatformOptionLog(id));
	}

	public Boolean creatPlatformOptionLog(
			PlatformOptionLogDTO platformOptionLogDTO) {
		application.creatPlatformOptionLog(PlatformOptionLogAssembler
				.toEntity(platformOptionLogDTO));
		return true;
	}

	public Boolean updatePlatformOptionLog(
			PlatformOptionLogDTO platformOptionLogDTO) {
		application.updatePlatformOptionLog(PlatformOptionLogAssembler
				.toEntity(platformOptionLogDTO));
		return true;
	}

	public Boolean removePlatformOptionLog(Long id) {
		application.removePlatformOptionLog(application
				.getPlatformOptionLog(id));
		return true;
	}

	public Boolean removePlatformOptionLogs(Long[] ids) {
		Set<PlatformOptionLog> platformOptionLogs = new HashSet<PlatformOptionLog>();
		for (Long id : ids) {
			platformOptionLogs.add(application.getPlatformOptionLog(id));
		}
		application.removePlatformOptionLogs(platformOptionLogs);
		return true;
	}

	public List<PlatformOptionLogDTO> findAllPlatformOptionLog() {
		return PlatformOptionLogAssembler.toDTOs(application
				.findAllPlatformOptionLog());
	}

	public Page<PlatformOptionLogDTO> pageQueryPlatformOptionLog(
			PlatformOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _platformOptionLog from PlatformOptionLog _platformOptionLog   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _platformOptionLog.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _platformOptionLog.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _platformOptionLog.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _platformOptionLog.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _platformOptionLog.category like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategory()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _platformOptionLog.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		if (queryVo.getSubStatus() != null
				&& !"".equals(queryVo.getSubStatus())) {
			jpql.append(" and _platformOptionLog.subStatus like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getSubStatus()));
		}
		if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
			jpql.append(" and _platformOptionLog.optUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptUser()));
		}
		if (queryVo.getOptDate() != null) {
			jpql.append(" and _platformOptionLog.optDate between ? and ? ");
			conditionVals.add(queryVo.getOptDate());
			conditionVals.add(queryVo.getOptDateEnd());
		}
		if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
			jpql.append(" and _platformOptionLog.nowLot like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
		}
		if (queryVo.getNowStation() != null
				&& !"".equals(queryVo.getNowStation())) {
			jpql.append(" and _platformOptionLog.nowStation like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowStation()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _platformOptionLog.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getStartTime() != null
				&& !"".equals(queryVo.getStartTime())) {
			jpql.append(" and _platformOptionLog.startTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStartTime()));
		}
		if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
			jpql.append(" and _platformOptionLog.endTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndTime()));
		}
		if (queryVo.getDuration() != null && !"".equals(queryVo.getDuration())) {
			jpql.append(" and _platformOptionLog.duration like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDuration()));
		}
		if (queryVo.getEndOptUser() != null
				&& !"".equals(queryVo.getEndOptUser())) {
			jpql.append(" and _platformOptionLog.endOptUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndOptUser()));
		}
		if (queryVo.getStandardWorkHours() != null
				&& !"".equals(queryVo.getStandardWorkHours())) {
			jpql.append(" and _platformOptionLog.standardWorkHours like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStandardWorkHours()));
		}
		if (queryVo.getGrossDie() != null && !"".equals(queryVo.getGrossDie())) {
			jpql.append(" and _platformOptionLog.grossDie like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getGrossDie()));
		}
		if (queryVo.getTheoryTime() != null
				&& !"".equals(queryVo.getTheoryTime())) {
			jpql.append(" and _platformOptionLog.theoryTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTheoryTime()));
		}
		if (queryVo.getInkType() != null && !"".equals(queryVo.getInkType())) {
			jpql.append(" and _platformOptionLog.inkType like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getInkType()));
		}
		if (queryVo.getTouchTimes() != null
				&& !"".equals(queryVo.getTouchTimes())) {
			jpql.append(" and _platformOptionLog.touchTimes like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTouchTimes()));
		}
		if (queryVo.getTeam() != null && !"".equals(queryVo.getTeam())) {
			jpql.append(" and _platformOptionLog.team like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTeam()));
		}
		if (queryVo.getIsShift() != null && !"".equals(queryVo.getIsShift())) {
			jpql.append(" and _platformOptionLog.isShift like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getIsShift()));
		}
		if (queryVo.getOptRemark() != null
				&& !"".equals(queryVo.getOptRemark())) {
			jpql.append(" and _platformOptionLog.optRemark like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptRemark()));
		}
		if (queryVo.getPlatformId() != null) {
			jpql.append(" and _platformOptionLog.platform.id = ?");
			conditionVals.add(queryVo.getPlatformId());
		}
		jpql.append(" order by _platformOptionLog.optDate desc");
		Page<PlatformOptionLog> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<PlatformOptionLogDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				PlatformOptionLogAssembler.toDTOs(pages.getData()));
	}

	public EquipmentDTO findEquipmentByPlatformOptionLog(Long id) {
		String jpql = "select e from PlatformOptionLog o right join o.equipment e where o.id=?";
		Equipment result = (Equipment) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		EquipmentDTO dto = new EquipmentDTO();
		if (result != null) {
			try {
				dto = EquipmentAssembler.toDTO(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public PlatformDTO findPlatformByPlatformOptionLog(Long id) {
		String jpql = "select e from PlatformOptionLog o right join o.platform e where o.id=?";
		Platform result = (Platform) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		PlatformDTO dto = new PlatformDTO();
		if (result != null) {
			try {
				dto = PlatformAssembler.toDTO(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * 保存平台操作日志最后一条记录的endTime (后期要加入endOptuser)
	 * 
	 * @param platformId
	 * @param endTime
	 */
	public PlatformOptionLogDTO saveLastPlatformOptionLogEndTime(
			Long platformId, PlatformDTO platformDTO) {
		String jpql = "select o from PlatformOptionLog o where o.platform.id=? order by o.id desc";
		PlatformOptionLog result = (PlatformOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { platformId }).singleResult();
		if (result != null && result.getStartTime() != null) {
			result.setEndTime(platformDTO.getEndTime());
			Long duration = platformDTO.getEndTime().getTime()
					- result.getStartTime().getTime();
			result.setDuration(duration);
			result.setEndOptUser(platformDTO.getOptUser());
			result.setErrorMsg(platformDTO.getErrorMsg());
			String newPartIds = platformDTO.getPartIds();
			if (result.getLastTestNo() == null) {
				result.setLastTestNo(Long.valueOf(0));
			}
			platformDTO.setPartIds(result.getPartIds());
			if ("FT".equals(platformDTO.getPlatformCategory())) {
				// FT测试数处理
				result.setNowTestNo(platformDTO.getTestQty());
				if (!this.isProductStatus(result.getStatus())) {
					result.setNowSiteTestQty(result.getLastSiteTestQty());
				} else {
					result.setNowSiteTestQty(platformDTO.getSiteTestQty());
				}
				result.setTouchTimes(result.getNowTestNo()
						- result.getLastTestNo());
				if (result.getTouchTimes() < 0) {
					return null;
				}
				// 保存socket信息
				platformDTO.setPartIds(newPartIds);
				platformDTO
						.setSiteTestQty(this.getSiteTestQty(
								result.getLastSiteTestQty(),
								result.getNowSiteTestQty()));
				result.setSiteTestQty(platformDTO.getSiteTestQty());
				List<Long> list = this.getRepairIds(result.getPartIds(),
						newPartIds);
				this.saveSockets(platformDTO, result);
				this.socketRepair(list, platformDTO);
				this.saveKits(platformDTO, result);
				this.saveLoadBoard(platformDTO, result);

			} else if ("CP".equals(platformDTO.getPlatformCategory())) {
				// 获取产品工程每片TouchDown
				JSONObject jsonObject = this
						.getEngTouchDownByProductModel(result.getNowLot());
				platformDTO.setEngTouchDown(jsonObject.getString("touchdown"));
				// CP测试数处理
				platformDTO.setGrossDie(jsonObject.getString("grossDie"));
				platformDTO
						.setGrossDie("NA".equals(platformDTO.getGrossDie()) ? "0"
								: platformDTO.getGrossDie());
				Long touchTimes = Long.valueOf(0);
				if (platformDTO.getWaferTD() != null
						&& !"".equals(platformDTO.getWaferTD())) {
					Long lastTd = "".equals(result.getLastWaferTD())
							|| result.getLastWaferTD() == null ? Long
							.valueOf(0) : Long.valueOf(result.getLastWaferTD());
					Long nowTd = "".equals(platformDTO.getWaferTD()) ? Long
							.valueOf(0) : Long
							.valueOf(platformDTO.getWaferTD());
					touchTimes = nowTd - lastTd;
					result.setNowWaferTD(platformDTO.getWaferTD());
				} else {
					Long nowTd = this.getTouchTimes(platformDTO.getPianxuan(),
							platformDTO.getPianxuanBeizhu(),
							platformDTO.getEngTouchDown(),
							platformDTO.getGrossDie());
					touchTimes = nowTd
							- this.getTouchTimes(result.getChipSelection(),
									result.getChipSelectionRemark(),
									platformDTO.getEngTouchDown(),
									platformDTO.getGrossDie());
					result.setNowWaferTD(String.valueOf(nowTd));
				}
				if (touchTimes < 0) {
					return null;
				}
				result.setEngTouchDown(platformDTO.getEngTouchDown());
				result.setGrossDie(platformDTO.getGrossDie());
				result.setCompletedChip(platformDTO.getPianxuan());
				result.setCompletedChipDescription(platformDTO
						.getPianxuanBeizhu());
				result.setTouchTimes(touchTimes);
				platformDTO.setPartIds(newPartIds);
				this.saveProbeCard(platformDTO, result);
			}
			result.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			application.updatePlatformOptionLog(result);
			return this.getLastPlatformOptionLogByNowLot(platformId,
					platformDTO);
			// return PlatformOptionLogAssembler.toDTO(result);
		}
		return new PlatformOptionLogDTO();
	}

	private void socketRepair(List<Long> list, PlatformDTO platformDTO) {
		// 当设备状态为Socket维修时socket状态变为待维修
		if (platformDTO.getSubStatusId() != Long.valueOf(118)) {
			return;
		}
		for (Long id : list) {
			SocketDTO socketDTO = new SocketDTO();
			socketDTO.setId(id);
			socketDTO
					.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			socketDTO.setStatusId(Long.valueOf(119));
			socketDTO.setRemark("Socket待维修！");
			socketFacade.changeSocketStatus(socketDTO);
		}
	}

	private List<Long> getRepairIds(String lastIds, String nowIds) {
		if (lastIds == null) {
			return new ArrayList<Long>();
		}
		String[] lastIdsArray = lastIds.split(",", -1);
		List<Long> list = new ArrayList<Long>();
		for (String str : lastIdsArray) {
			if (str.length() > 0 && nowIds.indexOf(str) < 0) {
				list.add(Long.valueOf(str));
			}
		}
		return list;
	}

	private String getSiteTestQty(String lastSiteTestQty, String nowSiteTestQty) {
		if (lastSiteTestQty == null || "".equals(lastSiteTestQty)) {
			lastSiteTestQty = "0,0,0,0";
		}
		if (nowSiteTestQty == null || "".equals(nowSiteTestQty)) {
			nowSiteTestQty = "0,0,0,0";
		}
		String[] lastSiteTestQtyArray = lastSiteTestQty.split(",", -1);
		String[] nowSiteTestQtyArray = nowSiteTestQty.split(",", -1);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < lastSiteTestQtyArray.length; i++) {
			String lastQtyStr = "".equals(lastSiteTestQtyArray[i]) ? "0"
					: lastSiteTestQtyArray[i];
			int lastQty = Integer.valueOf(lastQtyStr);
			String nowQtyStr = "0";
			// if(i < nowSiteTestQtyArray.length){
			nowQtyStr = "".equals(nowSiteTestQtyArray[i]) ? "0"
					: nowSiteTestQtyArray[i];
			// }
			int nowQty = Integer.valueOf(nowQtyStr);
			list.add(String.valueOf(nowQty - lastQty));
		}
		return StringUtils.join(list, ",");
	}

	public PlatformOptionLogDTO getLastPlatformOptionLogByNowLot(
			Long platformId, PlatformDTO platformDTO) {
		String jpql = "select o from PlatformOptionLog o where o.platform.id=? and o.nowLot = ? order by o.id desc";
		PlatformOptionLog result = (PlatformOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(
						new Object[] { platformId, platformDTO.getNowLot() })
				.singleResult();
		if (result != null && result.getStartTime() != null) {
			return PlatformOptionLogAssembler.toDTO(result);
		}
		return new PlatformOptionLogDTO();
	}

	private Long getTouchTimes(String chipSelection,
			String chipSelcetionRemark, String engTouchDown, String grossDie) {
		grossDie = grossDie == null || "".equals(grossDie) ? "0" : grossDie;
		engTouchDown = engTouchDown == null || "".equals(engTouchDown) ? "0"
				: engTouchDown;
		Long touchTimes = Long.valueOf(0);
		if (chipSelection == null || chipSelcetionRemark == null) {
			return touchTimes;
		}
		String[] chipIds = chipSelection.split(",");
		int chips = 0;
		for (String id : chipIds) {
			if (id != null && !"".equals(id) && !"-1".equals(id)) {
				chips++;
			}
		}
		touchTimes = chips * Long.valueOf(engTouchDown);
		for (String no : chipSelcetionRemark.split(",")) {
			if (no != null && !"".equals(no) && "0".equals(no)) {
				Double td = (Double.valueOf(no) / Double.valueOf(grossDie))
						* Double.valueOf(engTouchDown);
				if (td.longValue() > Long.valueOf(engTouchDown)) {
					touchTimes += Long.valueOf(engTouchDown);
				} else {
					touchTimes += td.longValue();
				}
			}
		}
		return touchTimes;
	}

	/**
	 * 查询平台操作日志最后一条记录
	 * 
	 * @param platformId
	 *            ,platformNo
	 */
	public PlatformOptionLogDTO getLastPlatformOptionLog(Long platformId,
			String platformNo) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select o from PlatformOptionLog o where 1=1 ");
		if (platformNo != null && !"".equals(platformNo)) {
			jpql.append(" and o.tester.equipmentNo = ?");
			conditionVals.add(platformNo);
		}
		if (platformId != null) {
			jpql.append(" and o.platform.id=? ");
			conditionVals.add(platformId);
		}
		jpql.append("order by o.id desc");
		PlatformOptionLog result = (PlatformOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql.toString())
				.setParameters(new Object[] { platformId }).singleResult();
		return PlatformOptionLogAssembler.toDTO(result);
	}

	public PlatformOptionLogDTO getLastPlatformOptionLog(Long platformId) {
		return this.getLastPlatformOptionLog(platformId, null);
	}

	public PlatformOptionLogDTO getLastPlatformOptionLog(String platformNo) {
		return this.getLastPlatformOptionLog(null, platformNo);
	}

	private void saveProbeCard(PlatformDTO platformDTO,
			PlatformOptionLog lastPlatformOptionLog) {
		if (lastPlatformOptionLog != null && platformDTO.getPartIds() != null
				&& !"".equals(platformDTO.getPartIds())) {
			ProbeCardDTO probeCardDTO = probeCardFacade.getProbeCard(Long
					.valueOf(platformDTO.getPartIds()));
			probeCardDTO.setTouchTime(probeCardDTO.getTouchTime()
					+ lastPlatformOptionLog.getTouchTimes());
			probeCardDTO.setTouchTimeTotal(probeCardDTO.getTouchTimeTotal()
					+ lastPlatformOptionLog.getTouchTimes());
			// probeCardDTO.setTouchTimeTotal(touchTimeTotal);
			probeCardDTO.setPlatform(platformDTO.getPlatformCategory());
			probeCardDTO.setPlatforms(platformDTO.getPlatformNo());
			probeCardDTO.setNowProductModel(platformDTO.getProductModel());
			probeCardDTO.setProductLot(platformDTO.getNowLot());
			probeCardDTO.setOptDate(platformDTO.getOptDate());
			probeCardOptionLogFacade.saveLastProbeCardOptionLogEndTime(
					probeCardDTO.getId(), probeCardDTO.getOptDate(),
					probeCardDTO.getTouchTime(),
					probeCardDTO.getTouchTimeTotal());
			probeCardDTO.setEquipmentCategory(platformDTO.getCategory());
			String resMsg = this.sendNotice(probeCardDTO);
			if ("ERROR".equals(resMsg)
					|| ("WARNING".equals(resMsg)
							&& maintenanceProbeCardSendNotice.getSliceNum() != null && maintenanceProbeCardSendNotice
							.getSliceNum() <= 0)) {
				probeCardDTO.setStatusId(Long.valueOf(93));
				probeCardDTO.setRemark("设备挂状态，超出保养上限，自动转待保养！");
				probeCardFacade.changeProbeCardStatus(probeCardDTO,
						probeCardDTO.getTouchTime(),
						probeCardDTO.getTouchTimeTotal());
			} else {
				probeCardDTO.setStatus(null);
				// 挂P/C维修时 将probe card 状态变为带维修
				if (platformDTO.getSubStatusId().equals(Long.valueOf(53))) {
					probeCardDTO.setStatusId(Long.valueOf(92));
					probeCardDTO.setPlatformId(null);
				} else {
					probeCardDTO.setStatus(null);
					probeCardDTO.setPlatformId(platformDTO.getId());
				}
				probeCardDTO.setPlatformId(platformDTO.getId());
				probeCardDTO.setLastModifyEmployNo(platformDTO
						.getLastModifyEmployNo());
				probeCardFacade.updateProbeCard(probeCardDTO);
				// probeCardDTO.setCustomerName(platformDTO.get);
				probeCardDTO.setPlatformStatus(platformDTO.getStatus());
				probeCardFacade.runLog(probeCardDTO);
				// this.changeMintenanceStatus(probeCardDTO);
			}
		}
	}

	private void saveSockets(PlatformDTO platformDTO,
			PlatformOptionLog lastPlatformOptionLog) {
		Long touchTimes;
		touchTimes = lastPlatformOptionLog.getTouchTimes() == null ? Long
				.valueOf(0) : lastPlatformOptionLog.getTouchTimes();
		// 处理Socket操作记录
		if (lastPlatformOptionLog.getPartIds() != null
				&& !"".equals(platformDTO.getPartIds())) {
			String[] ids = platformDTO.getPartIds().split(",", -1);
			List<Long> testQty = new ArrayList<Long>();
			String[] siteTestQty = platformDTO.getSiteTestQty().split(",", -1);
			List<Long> socketIdsize = new ArrayList<Long>();
			boolean hasSocketTouchedown = false;

			for (String qty : siteTestQty) {
				if (qty != null && !"".equals(qty)
						&& platformDTO.getTestQty() != null
						&& Long.valueOf(qty) > 0) {
					hasSocketTouchedown = true;
					break;
				}
			}
			if (",,,".equals(platformDTO.getSiteTestQty())
					|| lastPlatformOptionLog.getLastSiteTestQty() == null) {
				hasSocketTouchedown = false;
			}
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				if (!"".equals(id)) {
					socketIdsize.add(Long.valueOf(id));
				}
			}
			int size = socketIdsize.size();
			List<Long> socketIds = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				if (!"".equals(id)) {
					socketIds.add(Long.valueOf(id));
					if (hasSocketTouchedown) {
						testQty.add(siteTestQty[i] == null
								&& "".equals(siteTestQty[i]) ? Long.valueOf(0)
								: Long.valueOf(siteTestQty[i].trim()));
					} else {
						testQty.add(touchTimes / size);
					}
				} else {
					socketIds.add(null);
					testQty.add(null);
				}
			}

			for (int i = 0; i < socketIds.size(); i++) {
				Long id = socketIds.get(i);
				if (id == null) {
					continue;
				}
				SocketDTO socketDTO = new SocketDTO();
				socketDTO.setId(id);
				socketDTO.setTouchTimes(testQty.get(i));
				// probeCardDTO.setTouchTimeTotal(touchTimeTotal);
				socketDTO.setPlatform(lastPlatformOptionLog.getPlatform()
						.getTester().getEquipmentNo());
				socketDTO.setNowProductModel(lastPlatformOptionLog
						.getProductModel());
				socketDTO.setProductLot(lastPlatformOptionLog.getNowLot());
				socketDTO.setProductModel(platformDTO.getProductModel());
				socketDTO.setOptDate(platformDTO.getOptDate());
				socketDTO.setLastModifyEmployNo(platformDTO
						.getLastModifyEmployNo());
				socketOptionLogFacade.saveLastSocketOptionLogEndTime(
						socketDTO.getId(), socketDTO.getOptDate(),
						socketDTO.getTouchTimes(),
						platformDTO.getLastModifyEmployNo());
				// probeCardDTO.setCustomerName(platformDTO.get);
				// socketDTO.setTouchTimes(touchTimes);
				socketDTO.setPlatformId(platformDTO.getId());
				socketDTO.setNowStation(platformDTO.getNowStation());
				socketDTO.setPlatformStatus(platformDTO.getStatus());
				socketDTO.setNowLot(platformDTO.getNowLot());
				socketDTO.setProductLot(platformDTO.getNowLot());
				socketDTO.setProductModel(platformDTO.getProductModel());
				socketDTO.setPlatformSite(i + 1);
				socketFacade.runLog(socketDTO);
			}
		}
	}

	private void saveKits(PlatformDTO platformDTO,
			PlatformOptionLog lastPlatformOptionLog) {
		// 处理Kits操作记录
		if (lastPlatformOptionLog.getKitsId() != null
				&& !"".equals(lastPlatformOptionLog.getKitsId())) {
			Long id = lastPlatformOptionLog.getKitsId();
			KitsDTO kitsDTO = new KitsDTO();
			kitsDTO.setId(id);
			kitsDTO.setPlatform(lastPlatformOptionLog.getPlatform().getTester()
					.getEquipmentNo());
			kitsDTO.setNowProductModel(lastPlatformOptionLog.getProductModel());
			kitsDTO.setProductModel(platformDTO.getProductModel());
			kitsDTO.setLastModifyTimestamp(platformDTO.getOptDate());
			kitsDTO.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			kitsOptionLogFacade.saveLastKitsOptionLogEndTime(kitsDTO.getId(),
					kitsDTO.getLastModifyTimestamp(),
					platformDTO.getLastModifyEmployNo());
			// probeCardDTO.setCustomerName(platformDTO.get);
			// socketDTO.setTouchTimes(touchTimes);
			kitsDTO.setPlatformId(platformDTO.getId());
			kitsDTO.setNowStation(platformDTO.getNowStation());
			kitsDTO.setPlatformStatus(platformDTO.getStatus());
			kitsDTO.setNowLot(platformDTO.getNowLot());
			kitsDTO.setProductModel(platformDTO.getProductModel());
			kitsFacade.runLog(kitsDTO);
		}
	}
	
	private void saveLoadBoard(PlatformDTO platformDTO,
			PlatformOptionLog lastPlatformOptionLog) {
		// 处理LoadBoard操作记录
		if (lastPlatformOptionLog.getLoadBoardId() != null
				&& !"".equals(lastPlatformOptionLog.getLoadBoardId())) {
			Long id = lastPlatformOptionLog.getLoadBoardId();
			LoadBoardDTO loadBoardDTO = new LoadBoardDTO();
			loadBoardDTO.setId(id);
			loadBoardDTO.setPlatform(lastPlatformOptionLog.getPlatform().getTester()
					.getEquipmentNo());
			loadBoardDTO.setNowProductModel(lastPlatformOptionLog.getProductModel());
			loadBoardDTO.setProductModel(platformDTO.getProductModel());
			loadBoardDTO.setLastModifyTimestamp(platformDTO.getOptDate());
			loadBoardDTO.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
			loadBoardOptionLogFacade.saveLastLoadBoardOptionLogEndTime(loadBoardDTO.getId(),
					loadBoardDTO.getLastModifyTimestamp(),
					platformDTO.getLastModifyEmployNo());
			// probeCardDTO.setCustomerName(platformDTO.get);
			// socketDTO.setTouchTimes(touchTimes);
			loadBoardDTO.setPlatformId(platformDTO.getId());
			loadBoardDTO.setNowStation(platformDTO.getNowStation());
			loadBoardDTO.setPlatformStatus(platformDTO.getStatus());
			loadBoardDTO.setNowLot(platformDTO.getNowLot());
			loadBoardDTO.setProductModel(platformDTO.getProductModel());
			loadBoardFacade.runLog(loadBoardDTO);
		}
	}

	/**
	 * 判断是否需要发送保养通知
	 * 
	 * @param bean
	 */
	private String sendNotice(ProbeCardDTO probeCardDTO) {
		if (Long.valueOf(probeCardDTO.getMaintenanceLowerLimit()) < probeCardDTO
				.getTouchTime()) {
			return maintenanceProbeCardSendNotice.checkSendMail(probeCardDTO);
		}
		return "";
	}

	/**
	 * 判断是否需要发送保养通知
	 * 
	 * @param bean
	 */
	private void changeMintenanceStatus(ProbeCardDTO probeCardDTO) {
		if (Long.valueOf(probeCardDTO.getMaintenanceUpperLimit()) < probeCardDTO
				.getTouchTime()) {
			probeCardDTO.setStatusId(Long.valueOf(93));
			probeCardDTO.setRemark("设备挂状态，超出保养上限，自动转待保养！");
			probeCardFacade.changeProbeCardStatus(probeCardDTO);
		}
	}

	private JSONObject getEngTouchDownByProductModel(String acetecLot) {
		String info = mesTimeClient.getLotInfo(acetecLot, "CP");
		// "{\"productModel\":\"120730_12\",\"grossDie\":\"\",\"nowStation\":\"Shipping\",\"team\":\"白/D\",\"touchdown\":\"0\",\"standardWorkHours\":\"0\"}";
		String jsonString = info;
		return JSONObject.fromObject(jsonString);

	}

	public List<PlatformDTO> findPlatformByStatus(String status) {
		String jpql = "select o from Platform o where o.status in ( " + status
				+ ")";
		List<Platform> result = (List<Platform>) getQueryChannelService()
				.createJpqlQuery(jpql).list();
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

	public void changeStatusAll(PlatformDTO platformDTO) {
		List<PlatformDTO> list = this
				.findPlatformByStatus("'IDLE','停机','CHECK','DOWN'");
		for (PlatformDTO platformDto : list) {
			platformDto.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			platformDto.setOptUser(platformDTO.getLastModifyEmployNo());
			platformDto.setEndTime(platformDTO.getEndTime());
			platformDto.setOptDate(platformDTO.getEndTime());
			platformDto.setOptRemark("-交接班转系统");
			this.changeIdlePlatform(platformDto);
		}
	}

	public InvokeResult changeIdlePlatform(PlatformDTO platformDTO) {
		String jpql = "select o from PlatformOptionLog o where o.platform.id=? order by o.id desc";
		PlatformOptionLog result = (PlatformOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { platformDTO.getId() })
				.singleResult();

		PlatformOptionLog newPlatformOptionLog = new PlatformOptionLog();
		BeanUtils.copyProperties(result, newPlatformOptionLog);
		result.setCompletedChip(result.getChipSelection());
		result.setCompletedChipDescription(result.getChipSelectionRemark());
		result.setEndTime(platformDTO.getEndTime());
		Date startTime = null;
		if (result.getStartTime() == null) {
			startTime = result.getCreateTimestamp();
		} else {
			startTime = result.getStartTime();
		}
		Long duration = platformDTO.getEndTime().getTime()
				- startTime.getTime();
		result.setDuration(duration);
		result.setLastModifyTimestamp(platformDTO.getEndTime());
		result.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		result.setEndOptUser(platformDTO.getLastModifyEmployNo());
		newPlatformOptionLog.setCreateTimestamp(platformDTO.getEndTime());
		newPlatformOptionLog.setCreateEmployNo(platformDTO
				.getLastModifyEmployNo());
		newPlatformOptionLog.setStartTime(platformDTO.getEndTime());
		newPlatformOptionLog.setEndTime(null);
		newPlatformOptionLog.setId(null);
		newPlatformOptionLog.setIsShift("是");
		newPlatformOptionLog
				.setOptRemark(result.getOptRemark() == null ? platformDTO
						.getOptRemark() : result.getOptRemark());
		if (newPlatformOptionLog.getOptRemark().indexOf(
				platformDTO.getOptRemark()) < 0) {
			newPlatformOptionLog.setOptRemark(newPlatformOptionLog
					.getOptRemark() + platformDTO.getOptRemark());
		}
		platformDTO.setOptRemark(newPlatformOptionLog.getOptRemark());
		newPlatformOptionLog.setOptDate(platformDTO.getEndTime());
		newPlatformOptionLog.setOptUser(platformDTO.getOptUser());
		application.updatePlatformOptionLog(result);
		newPlatformOptionLog.setStatus(result.getPlatform().getStatus());
		application.creatPlatformOptionLog(newPlatformOptionLog);
		Platform platform = result.getPlatform();
		for (Equipment equipment : platform.getEquipmentChildren()) {
			this.changeEquipmentLogIdle(platformDTO, equipment);
		}
		this.changeEquipmentLogIdle(platformDTO, platform.getTester());
		return InvokeResult.success();
	}

	private void changeEquipmentLogIdle(PlatformDTO platformDTO,
			Equipment equipment) {
		EquipmentOptionLog equipmentOptionLog = new EquipmentOptionLog();
		EquipmentOptionLogDTO equipmentOptionLogDTO = equipmentOptionLogFacade
				.getLastEquipmentOptionLog(equipment.getId());
		equipmentOptionLog.setId(null);
		equipmentOptionLog.setStatus(equipmentOptionLogDTO.getStatus());
		equipmentOptionLog.setSubStatus(equipmentOptionLogDTO.getSubStatus());
		equipmentOptionLog.setEquipment(equipment);
		equipmentOptionLog.setOptDate(equipmentOptionLogDTO.getOptDate());
		equipmentOptionLog.setStartTime(platformDTO.getOptDate());
		equipmentOptionLog.setEndTime(null);
		equipmentOptionLog.setTouchTimes(equipmentOptionLogDTO.getTouchTimes());
		equipmentOptionLog.setCreateEmployNo(platformDTO
				.getLastModifyEmployNo());
		equipmentOptionLog.setLastModifyEmployNo(platformDTO
				.getLastModifyEmployNo());
		equipmentOptionLog.setOptUser(platformDTO.getOptUser());
		equipmentOptionLog.setTheoryTime(equipmentOptionLogDTO.getTheoryTime());
		equipmentOptionLog.setStandardWorkHours(equipmentOptionLogDTO
				.getStandardWorkHours());
		equipmentOptionLog.setOptRemark(platformDTO.getOptRemark());
		// equipmentOptionLog.setOptUser(platform);
		// 更新上状态时间
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setOptDate(platformDTO.getOptDate());
		equipmentDTO.setEndTime(platformDTO.getOptDate());
		equipmentDTO.setPianxuan(equipmentOptionLog.getChipSelection());
		equipmentDTO.setPianxuanBeizhu(equipmentOptionLog
				.getChipSelectionRemark());
		equipmentDTO.setOptUser(platformDTO.getLastModifyEmployNo());
		equipmentOptionLog.setTouchTimes(Long.valueOf(0));
		equipmentOptionLog.setIsShift("是");
		equipmentOptionLogFacade.saveLastEquipmentOptionLogEndTime(
				equipment.getId(), equipmentDTO);
		equipmentOptionLogApplication
				.updateEquipmentOptionLog(equipmentOptionLog);
	}

	private boolean isProductStatus(String status) {
		if ("RUN".equals(status)) {
			return true;
		}
		if ("LAT_RUN".equals(status)) {
			return true;
		}
		if ("R/T_RUN".equals(status)) {
			return true;
		}
		if ("REWORK".equals(status)) {
			return true;
		}
		if ("ENG_RUN".equals(status)) {
			return true;
		}
		return false;
	}
}

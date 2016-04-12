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
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardAssembler;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.facade.ProbeCardFacade;
import acetecsemi.com.brick.facade.ProbeCardOptionLogFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.application.ProbeCardApplication;
import acetecsemi.com.brick.application.ProbeCardOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
@Transactional
public class ProbeCardFacadeImpl implements ProbeCardFacade {

	@Inject
	private ProbeCardApplication application;

	@Inject
	private ProbeCardOptionLogApplication probeCardOptionLogApplication;

	@Inject
	private ProbeCardOptionLogFacade probeCardOptionLogFacade;

	@Inject
	private CategoryApplication categoryApplication;

	@Inject
	private PlatformApplication platformApplication;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	private QueryChannelService queryChannel;

	private static Long ZERO = Long.valueOf(0);

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public ProbeCardDTO getProbeCard(Long id) {
		return ProbeCardAssembler.toDTO(application.getProbeCard(id));
	}

	public Boolean creatProbeCard(ProbeCardDTO probeCardDTO) {
		ProbeCard probeCard = ProbeCardAssembler.toEntity(probeCardDTO);
		probeCard.setTouchTimeTotal(Long.valueOf(0));
		probeCard.setStatus(categoryApplication.getCategory(Long.valueOf(79)));
		// probeCard.setInTipMaximumDiameter(probeCard.getTipMaximumDiameter());
		// probeCard.setInTipMinimumDiameter(probeCard.getTipMinimumDiameter());
		probeCard.setTipLongest(probeCard.getInLongestNeedle());
		probeCard.setTipShortest(probeCard.getInShortestNeedle());
		probeCard.setTouchTime(ZERO);
		probeCard.setTouchTimeTotal(ZERO);
		application.creatProbeCard(probeCard);
		ProbeCardOptionLog probeCardOptionLog = ProbeCardOptionLogAssembler
				.toEntity(probeCardDTO);
		probeCardOptionLog.setProbeCard(probeCard);
		probeCardOptionLog.setStartTime(probeCardDTO.getOptDate());
		probeCardOptionLog.setStatus(probeCard.getStatus().getCategoryName());
		probeCardOptionLog.setOptDate(probeCardDTO.getOptDate());
		probeCardOptionLogApplication
				.updateProbeCardOptionLog(probeCardOptionLog);
		return true;
	}

	public Boolean updateProbeCard(ProbeCardDTO probeCardDTO) {
		ProbeCard probeCard = application.getProbeCard(probeCardDTO.getId());
		if (probeCardDTO.getPlatformId() != null) {
			probeCard.setNowPlatform(platformApplication
					.getPlatform(probeCardDTO.getPlatformId()));
		} else {
			probeCard.setNowPlatform(null);
		}
		if (probeCardDTO.getStatusId() != null) {
			probeCard.setStatus(categoryApplication.getCategory(probeCardDTO
					.getStatusId()));
		}
		BeanUtils.copyProperties(probeCardDTO, probeCard);
		application.updateProbeCard(probeCard);
		return true;
	}

	public Boolean removeProbeCard(Long id) {
		application.removeProbeCard(application.getProbeCard(id));
		return true;
	}

	public Boolean removeProbeCards(Long[] ids) {
		Set<ProbeCard> probeCards = new HashSet<ProbeCard>();
		for (Long id : ids) {
			probeCards.add(application.getProbeCard(id));
		}
		application.removeProbeCards(probeCards);
		return true;
	}

	public List<ProbeCardDTO> findAllProbeCard() {
		return ProbeCardAssembler.toDTOs(application.findAllProbeCard());
	}

	public Page<ProbeCardDTO> pageQueryProbeCard(ProbeCardDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _probeCard from ProbeCard _probeCard   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _probeCard.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _probeCard.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _probeCard.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _probeCard.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _probeCard.category like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategory()));
		}
		if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
			jpql.append(" and _probeCard.partNo like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
		}
		if (queryVo.getPartName() != null && !"".equals(queryVo.getPartName())) {
			jpql.append(" and _probeCard.partName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartName()));
		}
		if (queryVo.getEquipmentList() != null
				&& !"".equals(queryVo.getEquipmentList())) {
			jpql.append(" and _probeCard.probeCardList like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentList()));
		}
		if (queryVo.getPartType() != null && !"".equals(queryVo.getPartType())) {
			jpql.append(" and _probeCard.partType like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartType()));
		}
		if (queryVo.getPartModel() != null
				&& !"".equals(queryVo.getPartModel())) {
			jpql.append(" and _probeCard.partModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartModel()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _probeCard.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getNowProductModel() != null
				&& !"".equals(queryVo.getNowProductModel())) {
			jpql.append(" and _probeCard.nowProductModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowProductModel()));
		}
		if (queryVo.getInDate() != null) {
			jpql.append(" and _probeCard.inDate between ? and ? ");
			conditionVals.add(queryVo.getInDate());
			conditionVals.add(queryVo.getInDateEnd());
		}
		if (queryVo.getPartLocaltion() != null
				&& !"".equals(queryVo.getPartLocaltion())) {
			jpql.append(" and _probeCard.partLocaltion like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartLocaltion()));
		}
		if (queryVo.getCustomerName() != null
				&& !"".equals(queryVo.getCustomerName())) {
			jpql.append(" and _probeCard.customerName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerName()));
		}
		if (queryVo.getCustomerNameEn() != null
				&& !"".equals(queryVo.getCustomerNameEn())) {
			jpql.append(" and _probeCard.customerNameEn like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerNameEn()));
		}
		if (queryVo.getOwnership() != null
				&& !"".equals(queryVo.getOwnership())) {
			jpql.append(" and _probeCard.ownership like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOwnership()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _probeCard.status.id = ?");
			conditionVals.add(Long.valueOf(queryVo.getStatus()));
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _probeCard.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		if (queryVo.getInLongestNeedle() != null
				&& !"".equals(queryVo.getInLongestNeedle())) {
			jpql.append(" and _probeCard.inLongestNeedle like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getInLongestNeedle()));
		}
		if (queryVo.getInShortestNeedle() != null
				&& !"".equals(queryVo.getInShortestNeedle())) {
			jpql.append(" and _probeCard.inShortestNeedle like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getInShortestNeedle()));
		}
		if (queryVo.getScrappingStandard() != null
				&& !"".equals(queryVo.getScrappingStandard())) {
			jpql.append(" and _probeCard.scrappingStandard like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getScrappingStandard()));
		}
		if (queryVo.getProbeMaterials() != null
				&& !"".equals(queryVo.getProbeMaterials())) {
			jpql.append(" and _probeCard.probeMaterials like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProbeMaterials()));
		}
		if (queryVo.getMaintenanceUpperLimit() != null
				&& !"".equals(queryVo.getMaintenanceUpperLimit())) {
			jpql.append(" and _probeCard.maintenanceUpperLimit like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getMaintenanceUpperLimit()));
		}
		if (queryVo.getMaintenanceLowerLimit() != null
				&& !"".equals(queryVo.getMaintenanceLowerLimit())) {
			jpql.append(" and _probeCard.maintenanceLowerLimit like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getMaintenanceLowerLimit()));
		}
		if (queryVo.getOpenRemake() != null
				&& !"".equals(queryVo.getOpenRemake())) {
			jpql.append(" and _probeCard.openRemake like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOpenRemake()));
		}
		if (queryVo.getMaintenanceBase() != null
				&& !"".equals(queryVo.getMaintenanceBase())) {
			jpql.append(" and _probeCard.maintenanceBase like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getMaintenanceBase()));
		}
		if (queryVo.getTipHeight() != null
				&& !"".equals(queryVo.getTipHeight())) {
			jpql.append(" and _probeCard.tipHeight like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipHeight()));
		}
		if (queryVo.getTipLongest() != null
				&& !"".equals(queryVo.getTipLongest())) {
			jpql.append(" and _probeCard.tipLongest like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipLongest()));
		}
		if (queryVo.getTipShortest() != null
				&& !"".equals(queryVo.getTipShortest())) {
			jpql.append(" and _probeCard.tipShortest like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipShortest()));
		}
		if (queryVo.getXyNeedlePosition() != null
				&& !"".equals(queryVo.getXyNeedlePosition())) {
			jpql.append(" and _probeCard.xyNeedlePosition like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getXyNeedlePosition()));
		}
		if (queryVo.getZNeedlePositionFlatness() != null
				&& !"".equals(queryVo.getZNeedlePositionFlatness())) {
			jpql.append(" and _probeCard.zNeedlePositionFlatness like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getZNeedlePositionFlatness()));
		}
		if (queryVo.getTipMaximumDiameter() != null
				&& !"".equals(queryVo.getTipMaximumDiameter())) {
			jpql.append(" and _probeCard.tipMaximumDiameter like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipMaximumDiameter()));
		}
		if (queryVo.getTipMinimumDiameter() != null
				&& !"".equals(queryVo.getTipMinimumDiameter())) {
			jpql.append(" and _probeCard.tipMinimumDiameter like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipMinimumDiameter()));
		}
		if (queryVo.getExpoxyToTipAngleDistance() != null
				&& !"".equals(queryVo.getExpoxyToTipAngleDistance())) {
			jpql.append(" and _probeCard.ExpoxyToTipAngleDistance like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getExpoxyToTipAngleDistance()));
		}
		if (queryVo.getTestTemperature() != null
				&& !"".equals(queryVo.getTestTemperature())) {
			jpql.append(" and _probeCard.testTemperature like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTestTemperature()));
		}
		if (queryVo.getAppearanceOfProbeCard() != null
				&& !"".equals(queryVo.getAppearanceOfProbeCard())) {
			jpql.append(" and _probeCard.appearanceOfProbeCard like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getAppearanceOfProbeCard()));
		}
		if (queryVo.getReinforcingPlate() != null
				&& !"".equals(queryVo.getReinforcingPlate())) {
			jpql.append(" and _probeCard.reinforcingPlate like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getReinforcingPlate()));
		}
		if (queryVo.getRemakeNumber() != null
				&& !"".equals(queryVo.getRemakeNumber())) {
			jpql.append(" and _probeCard.remakeNumber like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getRemakeNumber()));
		}
		jpql.append("order by _probeCard.customerName,_probeCard.status.id,_probeCard.partNo");
		Page<ProbeCard> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<ProbeCardDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, ProbeCardAssembler.toDTOs(pages.getData()));
	}

	@Override
	public ManufacturerDTO findManufacturerByProbeCard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentDTO findEquipmentByProbeCard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeProbeCardStatus(ProbeCardDTO probeCardDTO) {
		return this.changeProbeCardStatus(probeCardDTO, null, null);
	}

	public String changeProbeCardStatus(ProbeCardDTO probeCardDTO,
			Long touchTime, Long touchTimeTotal) {
		ProbeCard probeCard = ProbeCard.get(ProbeCard.class,
				probeCardDTO.getId());
		Date nowDate = new Date();

		if ((probeCardDTO.getStatusId() == Long.valueOf(84) || probeCardDTO
				.getStatusId() == Long.valueOf(86))
				&& !this.verificationStatus(probeCardDTO, probeCard)) {
			return "领出申请产品型号、设备probecard不适用！";
		}
		if (!this.checkTip(probeCardDTO, probeCard)) {
			return "针尖最长长度或 针尖最短长度填写错误，请修改！";
		}
		if (probeCard.getStatus().getId() == Long.valueOf(85)
				&& this.checkRunProbeCard(probeCard)) {
			return "当前平台正在测试中不能变动Probe Card状态！";
		}
		if (probeCardDTO.getStatusId() != null) {
			// ProbeCardAssembler.toEntity(probeCard, probeCardDTO);
			probeCardDTO.setNowProductModel(probeCardDTO.getProductModel());
			// probeCardDTO.setProductModel(null);
			probeCardDTO.setTouchTime(touchTime);
			probeCardDTO.setTouchTimeTotal(touchTimeTotal);
			switch (probeCardDTO.getStatusId().intValue()) {
			case 81:// 在库正常时当前产品型号为空
			case 93:// 待保养时当前产品型号为空
				BeanUtils.copyProperties(probeCardDTO, probeCard);
				probeCard.setNowProductModel("");
				probeCard.setNowPlatform(null);
				break;
			case 95:// 结束保养
				BeanUtils.copyProperties(probeCardDTO, probeCard);
				probeCard.setTouchTime(ZERO);
				break;
			case 84:// 生产领出申请
				/*
				 * if (this.checkPlatform(probeCardDTO.getNowPlatformId())) {
				 * return "已经领出Probe Card 到选择的平台，如果此平台需要办理领出请归还入库！"; }
				 */
			case 86:// 工程领出申请
				if (!this.verificationStatus(probeCardDTO, probeCard)) {
					return "领出申请产品型号、设备probecard不适用！";
				}
				probeCard.setNowPlatform(Platform.get(Platform.class,
						probeCardDTO.getNowPlatformId()));
				probeCardDTO.setProductModel(null);
				BeanUtils.copyProperties(probeCardDTO, probeCard);
				probeCardDTO.setEquipmentCategory(probeCard.getNowPlatform()
						.getTester().getEquipmentCategory().getCategoryName());
				break;
			default:
				BeanUtils.copyProperties(probeCardDTO, probeCard);
			}
			Category status = Category.get(Category.class,
					probeCardDTO.getStatusId());
			probeCardDTO.setStatus(status.getCategoryName());
			probeCard.setStatus(status);
			if (probeCardDTO.getOptDate() == null) {
				probeCardDTO.setOptDate(nowDate);
			}
			// 程序release
			if (probeCardDTO.getStatusId() == Long.valueOf(80)
					&& probeCardDTO.getProductModel() != null
					&& !"".equals(probeCardDTO.getProductModel())) {
				Map<String, String> map = probeCardOptionLogFacade
						.getReleaseInfo(probeCard.getId());
				probeCard
						.setProductModel(this.getReleaseInfo(
								map.get("productModel"),
								probeCardDTO.getProductModel()));
				probeCard.setEquipmentList(this.getReleaseInfo(
						map.get("equipmentList"), probeCardDTO.getPlatforms()));
				if (probeCardDTO.getPlatform() != null
						&& !"".equals(probeCardDTO.getPlatform())) {
					Category category = categoryApplication.getCategory(Long
							.valueOf(probeCardDTO.getPlatform()));
					probeCard.setEquipmentCategory(this.getReleaseInfo(
							map.get("equipmentCategory"),
							category.getCategoryName()));
				} else
					probeCard
							.setEquipmentCategory(map.get("equipmentCategory"));
			}

			probeCardOptionLogFacade.saveLastProbeCardOptionLogEndTime(
					probeCard.getId(), nowDate, touchTime == null ? ZERO
							: touchTime, touchTimeTotal == null ? ZERO
							: touchTimeTotal);
			application.updateProbeCard(probeCard);
			ProbeCardOptionLog probeCardOptionLog = ProbeCardOptionLogAssembler
					.toEntity(probeCardDTO);
			probeCardOptionLog.setTipMaximumDiameter(probeCard
					.getTipMaximumDiameter());
			probeCardOptionLog.setTipMinimumDiameter(probeCard
					.getTipMinimumDiameter());
			probeCardOptionLog.setTipLongest(probeCard.getTipLongest());
			probeCardOptionLog.setTipShortest(probeCard.getTipShortest());
			probeCardOptionLog.setProbeCard(probeCard);
			probeCardOptionLog.setStartTime(probeCardDTO.getOptDate());
			probeCardOptionLog.setOptDate(probeCardDTO.getOptDate());
			probeCardOptionLog.setStatus(status.getCategoryName());
			probeCardOptionLog.setTouchTime(probeCard.getTouchTime());
			probeCardOptionLog.setTouchTimeTotal(probeCard.getTouchTimeTotal());
			probeCardOptionLog.setProductNowModel(probeCard
					.getNowProductModel());
			probeCardOptionLog.setEquipmentCategory(probeCardDTO
					.getEquipmentCategory());
			probeCardOptionLog.setPlatform(probeCardDTO.getEquipmentCategory());
			probeCardOptionLog.setPlatforms(probeCardDTO.getPlatforms());
			// probeCardOptionLog.setOptUser(platform);
			probeCardOptionLogApplication
					.creatProbeCardOptionLog(probeCardOptionLog);
			if (probeCardDTO.getStatusId() == Long.valueOf(80)) {
				ProbeCardDTO pcDTO = new ProbeCardDTO();
				pcDTO.setId(probeCardDTO.getId());
				pcDTO.setStatusId(Long.valueOf(81));
				pcDTO.setNeedlePositionLevel("Pass");
				pcDTO.setAppearanceLevel("Pass");
				pcDTO.setTipMaximumDiameter(probeCard.getTipMaximumDiameter());
				pcDTO.setTipMinimumDiameter(probeCard.getTipMinimumDiameter());
				pcDTO.setTipLongest(probeCard.getTipLongest());
				pcDTO.setTipShortest(probeCard.getTipShortest());
				pcDTO.setTipShortest(probeCard.getTipShortest());
				pcDTO.setOptDate(probeCardDTO.getOptDate());
				pcDTO.setOptUser(probeCardDTO.getOptUser());
				pcDTO.setLastModifyEmployNo(probeCardDTO
						.getLastModifyEmployNo());
				this.changeProbeCardStatus(pcDTO);
			}
			return null;
		}
		return "状态改变失败！";
	}

	private String getReleaseInfo(String oldStr, String objs) {
		String[] objStr = objs.split(",");
		for (String str : objStr) {
			if (oldStr.indexOf(str) < 0) {
				oldStr += str + ",";
			}
		}
		return oldStr;
	}

	@Override
	public Boolean runLog(ProbeCardDTO probeCardDTO) {
		if (probeCardDTO.getId() != null) {
			ProbeCard probeCard = application
					.getProbeCard(probeCardDTO.getId());
			// probeCard.setTouchTimeTotal(probeCardDTO.getTouchTimeTotal());
			ProbeCardOptionLog probeCardOptionLog = ProbeCardOptionLogAssembler
					.toEntity(probeCardDTO);
			if (probeCard.getNowPlatform() != null) {
				probeCardOptionLog.setPlatforms(probeCard.getNowPlatform()
						.getTester().getEquipmentNo());
				probeCardOptionLog.setPlatformNo(probeCard.getNowPlatform()
						.getTester().getEquipmentNo());
			}
			probeCardOptionLog.setPlatform(probeCardDTO.getEquipmentCategory());
			probeCardOptionLog.setProbeCard(probeCard);
			probeCardOptionLog.setStartTime(probeCardDTO.getOptDate());
			probeCardOptionLog.setStatus(probeCard.getStatus()
					.getCategoryName());
			probeCardOptionLog.setRemark("生产批次操作日志");
			probeCardOptionLog.setOptUser(probeCardDTO.getLastModifyEmployNo());
			probeCardOptionLog.setLastModifyEmployNo(probeCardDTO
					.getLastModifyEmployNo());
			probeCardOptionLog.setProductNowModel(probeCardDTO
					.getNowProductModel());
			probeCardOptionLog.setPlatformStatus(probeCardDTO
					.getPlatformStatus());
			probeCardOptionLogApplication
					.creatProbeCardOptionLog(probeCardOptionLog);

		}
		return null;
	}

	public List<ProbeCardDTO> queryProbeCard(ProbeCardDTO queryVo) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _probeCard from ProbeCard _probeCard   where 1=1 ");
		if (queryVo.getPlatformNo() != null
				&& !"".equals(queryVo.getPlatformNo())) {
			jpql.append(" and _probeCard.equipmentList like ? ");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformNo()));
		}
		if (queryVo.getStatusId() != null) {
			jpql.append(" and _probeCard.status.id = ?");
			conditionVals.add(queryVo.getStatusId());
		}

		if (queryVo.getStatusIds() != null
				&& !"".equals(queryVo.getStatusIds())) {
			jpql.append(" and _probeCard.status.id in ("
					+ queryVo.getStatusIds() + ")");
		}
		if (queryVo.getNowPlatformId() != null) {
			jpql.append(" and _probeCard.nowPlatform.id = ? ");
			conditionVals.add(queryVo.getNowPlatformId());
		}
		List<ProbeCard> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return ProbeCardAssembler.toDTOs(list);
	}

	@Override
	public List<ProbeCardDTO> findProductAllProbeCard(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setStatusIds("85,87");
		return this.queryProbeCard(probeCardDTO);
	}

	private Boolean verificationStatus(ProbeCardDTO probeCardDTO,
			ProbeCard probeCard) {
		if (probeCard.getProductModel() != null
				&& probeCard.getEquipmentList() != null
				&& probeCard.getProductModel().indexOf(
						probeCardDTO.getProductModel()) > -1
				&& probeCard.getEquipmentList().indexOf(
						probeCardDTO.getPlatforms()) > -1) {
			return true;
		}
		return false;
	}

	public List<ProbeCardDTO> getProbeCardByPlatformId(Long platformId) {
		ProbeCardDTO queryVo = new ProbeCardDTO();
		// 王胭脂要求查询生产领出或工程领出的probecard不要和平台绑定
		// 需要和release的平台绑定，当前平台release过的生产领出或工程领出的probecard
		// queryVo.setNowPlatformId(platformId);
		queryVo.setStatusIds("85,87");
		Platform platform = platformApplication.getPlatform(platformId);
		queryVo.setPlatformNo(platform.getTester().getEquipmentNo());
		List<ProbeCardDTO> probeCardDTOList = this.queryProbeCard(queryVo);
		return probeCardDTOList;
	}

	private boolean checkPlatform(Long platformId) {
		if (platformId == null) {
			return true;
		}
		ProbeCardDTO queryVo = new ProbeCardDTO();
		queryVo.setNowPlatformId(platformId);
		List<ProbeCardDTO> probeCardList = this.queryProbeCard(queryVo);
		if (probeCardList != null && probeCardList.size() > 0) {
			return true;
		}
		return false;
	}

	public ProbeCardDTO updateTouchdownNum(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setOptDate(new Date());
		ProbeCard probeCard = application.getProbeCard(probeCardDTO.getId());
		probeCard.setTouchTime(probeCardDTO.getTouchTime());
		probeCard.setTouchTimeTotal(probeCardDTO.getTouchTimeTotal());
		application.updateProbeCard(probeCard);
		/*
		 * probeCardOptionLogFacade.saveLastProbeCardOptionLogEndTime(
		 * probeCard.getId(), probeCardDTO.getOptDate(),
		 * probeCardDTO.getTouchTime(), probeCardDTO.getTouchTimeTotal());
		 * ProbeCardOptionLog probeCardOptionLog = new ProbeCardOptionLog();
		 * probeCardOptionLog.setProbeCard(probeCard);
		 * probeCardOptionLog.setStartTime(probeCardDTO.getOptDate());
		 * probeCardOptionLog.setCreateEmployNo(probeCardDTO
		 * .getLastModifyEmployNo()); probeCardOptionLogApplication
		 * .creatProbeCardOptionLog(probeCardOptionLog);
		 */
		return probeCardDTO;
	}
	
	public ProbeCardDTO updateRelease(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setOptDate(new Date());
		ProbeCard probeCard = application.getProbeCard(probeCardDTO.getId());
		probeCard.setProductModel(probeCardDTO.getProductModel());
		probeCard.setEquipmentList(probeCardDTO.getEquipmentList());
		application.updateProbeCard(probeCard);
		/*
		 * probeCardOptionLogFacade.saveLastProbeCardOptionLogEndTime(
		 * probeCard.getId(), probeCardDTO.getOptDate(),
		 * probeCardDTO.getTouchTime(), probeCardDTO.getTouchTimeTotal());
		 * ProbeCardOptionLog probeCardOptionLog = new ProbeCardOptionLog();
		 * probeCardOptionLog.setProbeCard(probeCard);
		 * probeCardOptionLog.setStartTime(probeCardDTO.getOptDate());
		 * probeCardOptionLog.setCreateEmployNo(probeCardDTO
		 * .getLastModifyEmployNo()); probeCardOptionLogApplication
		 * .creatProbeCardOptionLog(probeCardOptionLog);
		 */
		return probeCardDTO;
	}

	private boolean checkTip(ProbeCardDTO probeCardDTO, ProbeCard probeCard) {
		switch (probeCardDTO.getStatusId().intValue()) {
		case 82:
		case 95:
		case 81:
			if (probeCardDTO.getTipLongest() != null
					&& !"".equals(probeCardDTO.getTipLongest())
					&& probeCardDTO.getTipShortest() != null
					&& !"".equals(probeCardDTO.getTipShortest())) {
				Double tipLongest = Double
						.valueOf(probeCardDTO.getTipLongest());
				Double tipShortest = Double.valueOf(probeCardDTO
						.getTipShortest());
				Double lastTipLongest = Double.valueOf(probeCard
						.getTipLongest());
				Double lastTipShortest = Double.valueOf(probeCard
						.getTipShortest());
				boolean sign = false;
				if (tipLongest <= lastTipLongest && tipLongest > tipShortest) {
					sign = true;
				}
				if (sign && tipShortest <= lastTipShortest
						&& tipLongest > tipShortest) {
					sign = true;
				} else {
					sign = false;
				}
				return sign;
			}
			return false;
		}
		return true;
	}

	/**
	 * 判断probe Card使用机台RUN状态，是否可以变动状态
	 * 
	 * @param probeCard
	 * @return
	 */
	private boolean checkRunProbeCard(ProbeCard probeCard) {
		boolean sign = false;
		if (probeCard.getNowPlatform() != null
				&& ("RUN".equals(probeCard.getNowPlatform().getStatus())
						|| "REWORK".equals(probeCard.getNowPlatform()
								.getStatus())
						|| "ENG_RUN".equals(probeCard.getNowPlatform()
								.getStatus()) || "R/T_RUN".equals(probeCard
						.getNowPlatform().getStatus()))
				&& platformOptionLogFacade
						.getLastPlatformOptionLog(
								probeCard.getNowPlatform().getId()).getPcNo()
						.indexOf(probeCard.getPartNo()) > -1) {
			sign = true;
		}
		if (this.checkTouchdown(probeCard)) {
			sign = false;
		}
		return sign;
	}

	/**
	 * 判断生产领出的ProbeCard是否超过保养下限如果超过返回true
	 * 
	 * @param probeCard
	 * @return
	 */
	private boolean checkTouchdown(ProbeCard probeCard) {
		if (probeCard.getTouchTime() >= Long.valueOf(probeCard
				.getMaintenanceLowerLimit())) {
			return true;
		}
		return false;
	}
}

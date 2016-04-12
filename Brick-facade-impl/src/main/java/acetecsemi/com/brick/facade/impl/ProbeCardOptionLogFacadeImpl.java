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

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardAssembler;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardOptionLogAssembler;
import acetecsemi.com.brick.facade.ProbeCardOptionLogFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.application.ProbeCardOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class ProbeCardOptionLogFacadeImpl implements ProbeCardOptionLogFacade {

	@Inject
	private ProbeCardOptionLogApplication application;

	@Inject
	private CategoryApplication categoryApplication;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public ProbeCardOptionLogDTO getProbeCardOptionLog(Long id) {
		return ProbeCardOptionLogAssembler.toDTO(application
				.getProbeCardOptionLog(id));
	}

	public Boolean creatProbeCardOptionLog(
			ProbeCardOptionLogDTO probeCardOptionLogDTO) {
		application.creatProbeCardOptionLog(ProbeCardOptionLogAssembler
				.toEntity(probeCardOptionLogDTO));
		return true;
	}

	public Boolean updateProbeCardOptionLog(
			ProbeCardOptionLogDTO probeCardOptionLogDTO) {
		application.updateProbeCardOptionLog(ProbeCardOptionLogAssembler
				.toEntity(probeCardOptionLogDTO));
		return true;
	}

	public Boolean removeProbeCardOptionLog(Long id) {
		application.removeProbeCardOptionLog(application
				.getProbeCardOptionLog(id));
		return true;
	}

	public Boolean removeProbeCardOptionLogs(Long[] ids) {
		Set<ProbeCardOptionLog> probeCardOptionLogs = new HashSet<ProbeCardOptionLog>();
		for (Long id : ids) {
			probeCardOptionLogs.add(application.getProbeCardOptionLog(id));
		}
		application.removeProbeCardOptionLogs(probeCardOptionLogs);
		return true;
	}

	public List<ProbeCardOptionLogDTO> findAllProbeCardOptionLog() {
		return ProbeCardOptionLogAssembler.toDTOs(application
				.findAllProbeCardOptionLog());
	}

	public Page<ProbeCardOptionLogDTO> pageQueryProbeCardOptionLog(
			ProbeCardOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _probeCardOptionLog from ProbeCardOptionLog _probeCardOptionLog   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _probeCardOptionLog.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _probeCardOptionLog.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _probeCardOptionLog.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _probeCardOptionLog.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _probeCardOptionLog.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
			jpql.append(" and _probeCardOptionLog.optUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptUser()));
		}
		if (queryVo.getOptDate() != null) {
			jpql.append(" and _probeCardOptionLog.optDate between ? and ? ");
			conditionVals.add(queryVo.getOptDate());
			conditionVals.add(queryVo.getOptDateEnd());
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _probeCardOptionLog.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		if (queryVo.getEndDate() != null) {
			jpql.append(" and _probeCardOptionLog.endDate between ? and ? ");
			conditionVals.add(queryVo.getEndDate());
			conditionVals.add(queryVo.getEndDateEnd());
		}
		if (queryVo.getStatusTime() != null
				&& !"".equals(queryVo.getStatusTime())) {
			jpql.append(" and _probeCardOptionLog.statusTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStatusTime()));
		}
		if (queryVo.getMaintenancePerson() != null
				&& !"".equals(queryVo.getMaintenancePerson())) {
			jpql.append(" and _probeCardOptionLog.maintenancePerson like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getMaintenancePerson()));
		}
		if (queryVo.getMaintenanceItems() != null
				&& !"".equals(queryVo.getMaintenanceItems())) {
			jpql.append(" and _probeCardOptionLog.maintenanceItems like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getMaintenanceItems()));
		}
		if (queryVo.getDutNumber() != null
				&& !"".equals(queryVo.getDutNumber())) {
			jpql.append(" and _probeCardOptionLog.dutNumber like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDutNumber()));
		}
		if (queryVo.getBinNo() != null && !"".equals(queryVo.getBinNo())) {
			jpql.append(" and _probeCardOptionLog.binNo like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getBinNo()));
		}
		if (queryVo.getPlatforms() != null
				&& !"".equals(queryVo.getPlatforms())) {
			jpql.append(" and _probeCardOptionLog.platforms like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatforms()));
		}
		if (queryVo.getPlatform() != null && !"".equals(queryVo.getPlatform())) {
			jpql.append(" and _probeCardOptionLog.platform like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatform()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _probeCardOptionLog.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getProductLot() != null
				&& !"".equals(queryVo.getProductLot())) {
			jpql.append(" and _probeCardOptionLog.productLot like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductLot()));
		}
		if (queryVo.getProductNowModel() != null
				&& !"".equals(queryVo.getProductNowModel())) {
			jpql.append(" and _probeCardOptionLog.productNowModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductNowModel()));
		}
		if (queryVo.getProbeCardApplyPerson() != null
				&& !"".equals(queryVo.getProbeCardApplyPerson())) {
			jpql.append(" and _probeCardOptionLog.probeCardApplyPerson like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProbeCardApplyPerson()));
		}
		if (queryVo.getCustomerName() != null
				&& !"".equals(queryVo.getCustomerName())) {
			jpql.append(" and _probeCardOptionLog.customerName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerName()));
		}
		if (queryVo.getTouchTime() != null
				&& !"".equals(queryVo.getTouchTime())) {
			jpql.append(" and _probeCardOptionLog.touchTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTouchTime()));
		}
		if (queryVo.getReturnPerson() != null
				&& !"".equals(queryVo.getReturnPerson())) {
			jpql.append(" and _probeCardOptionLog.returnPerson like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getReturnPerson()));
		}
		if (queryVo.getReturnLevel() != null
				&& !"".equals(queryVo.getReturnLevel())) {
			jpql.append(" and _probeCardOptionLog.returnLevel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getReturnLevel()));
		}
		if (queryVo.getNeedlePositionLevel() != null
				&& !"".equals(queryVo.getNeedlePositionLevel())) {
			jpql.append(" and _probeCardOptionLog.needlePositionLevel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNeedlePositionLevel()));
		}
		if (queryVo.getAppearanceLevel() != null
				&& !"".equals(queryVo.getAppearanceLevel())) {
			jpql.append(" and _probeCardOptionLog.appearanceLevel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getAppearanceLevel()));
		}
		if (queryVo.getXyNeedlePosition() != null
				&& !"".equals(queryVo.getXyNeedlePosition())) {
			jpql.append(" and _probeCardOptionLog.xyNeedlePosition like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getXyNeedlePosition()));
		}
		if (queryVo.getTipMaximumDiameter() != null
				&& !"".equals(queryVo.getTipMaximumDiameter())) {
			jpql.append(" and _probeCardOptionLog.tipMaximumDiameter like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipMaximumDiameter()));
		}
		if (queryVo.getTipMinimumDiameter() != null
				&& !"".equals(queryVo.getTipMinimumDiameter())) {
			jpql.append(" and _probeCardOptionLog.tipMinimumDiameter like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipMinimumDiameter()));
		}
		if (queryVo.getTipShortest() != null
				&& !"".equals(queryVo.getTipShortest())) {
			jpql.append(" and _probeCardOptionLog.tipShortest like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTipShortest()));
		}
		if (queryVo.getProbeCardId() != null) {
			jpql.append(" and _probeCardOptionLog.probeCard.id = ?");
			conditionVals.add(queryVo.getProbeCardId());
		}
		jpql.append("order by _probeCardOptionLog.id desc");
		Page<ProbeCardOptionLog> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<ProbeCardOptionLogDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				ProbeCardOptionLogAssembler.toDTOs(pages.getData()));
	}

	@Override
	public ProbeCardDTO findProbeCardByProbeCardOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 保存probe card操作日志最后一条记录的endTime (后期要加入endOptuser)
	 * 
	 * @param probeCardId
	 * @param endTime
	 */
	public void saveLastProbeCardOptionLogEndTime(Long probeCardId,
			Date endTime, Long touchTime, Long touchTimeTotal) {
		String jpql = "select o from ProbeCardOptionLog o where o.probeCard.id=? order by o.id desc";
		ProbeCardOptionLog result = (ProbeCardOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { probeCardId }).singleResult();
		if (result != null && result.getStartTime() != null) {
			result.setEndTime(endTime);
			result.setTouchTime(touchTime);
			result.setTouchTimeTotal(touchTimeTotal == null ? result
					.getTouchTimeTotal() + touchTime : touchTimeTotal);
			application.updateProbeCardOptionLog(result);
		}
	}

	/**
	 * 查询probe card操作日志最后一条记录
	 * 
	 * @param probeCardId
	 */
	public ProbeCardOptionLogDTO findLastProbeCardOptionLog(Long probeCardId) {
		String jpql = "select o from ProbeCardOptionLog o where o.probeCard.id=? order by o.id desc";
		ProbeCardOptionLog result = (ProbeCardOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { probeCardId }).singleResult();
		return ProbeCardOptionLogAssembler.toDTO(result);
	}

	public Map<String, String> getReleaseInfo(Long probeCardId) {
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(probeCardId);
		StringBuilder jpql = new StringBuilder(
				"select o from ProbeCardOptionLog o   where status = '程序Release' and o.probeCard.id=?");
		@SuppressWarnings("unchecked")
		List<ProbeCardOptionLog> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		StringBuffer productModel = new StringBuffer();
		String equipmentList = "";
		StringBuffer equipmentCategory = new StringBuffer();
		for (ProbeCardOptionLog pcol : list) {
			if (pcol.getProductModel() == null
					|| "".equals(pcol.getProductModel())) {
				continue;
			}
			productModel.append(pcol.getProductModel()).append(",");
			if (pcol.getPlatform() != null && !"".equals(pcol.getPlatform())) {
				Category category = categoryApplication.getCategory(Long
						.valueOf(pcol.getPlatform()));
				equipmentCategory.append(category.getCategoryName())
						.append(",");
			}
			equipmentList = this.getReleaseInfo(equipmentList,
					pcol.getPlatforms());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("productModel", productModel.toString());
		map.put("equipmentList", equipmentList.toString());
		map.put("equipmentCategory", equipmentCategory.toString());
		return map;
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

	private void checkTouchDown() {

	}

	@Override
	public ProbeCardOptionLogDTO updateLog(ProbeCardOptionLogDTO probeCardOptionLogDTO) {
		probeCardOptionLogDTO.setOptDate(new Date());
		ProbeCardOptionLog probeCardOptionLog = application.getProbeCardOptionLog(probeCardOptionLogDTO.getId());
		probeCardOptionLog.setProductModel(probeCardOptionLogDTO.getProductModel());
		probeCardOptionLog.setPlatforms(probeCardOptionLogDTO.getPlatforms());
		application.updateProbeCardOptionLog(probeCardOptionLog);

		return probeCardOptionLogDTO;
	}
}

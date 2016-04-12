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

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentOptionLogAssembler;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;
import acetecsemi.com.brick.application.EquipmentOptionLogApplication;
import acetecsemi.com.brick.application.PMDocumentApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class EquipmentOptionLogFacadeImpl implements EquipmentOptionLogFacade {

	@Inject
	private EquipmentOptionLogApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public EquipmentOptionLogDTO getEquipmentOptionLog(Long id) {
		return EquipmentOptionLogAssembler.toDTO(application
				.getEquipmentOptionLog(id));
	}

	public Boolean creatEquipmentOptionLog(
			EquipmentOptionLogDTO equipmentOptionLogDTO) {
		application.creatEquipmentOptionLog(EquipmentOptionLogAssembler
				.toEntity(equipmentOptionLogDTO));
		return true;
	}

	public Boolean updateEquipmentOptionLog(
			EquipmentOptionLogDTO equipmentOptionLogDTO) {
		application.updateEquipmentOptionLog(EquipmentOptionLogAssembler
				.toEntity(equipmentOptionLogDTO));
		return true;
	}

	public Boolean removeEquipmentOptionLog(Long id) {
		application.removeEquipmentOptionLog(application
				.getEquipmentOptionLog(id));
		return true;
	}

	public Boolean removeEquipmentOptionLogs(Long[] ids) {
		Set<EquipmentOptionLog> equipmentOptionLogs = new HashSet<EquipmentOptionLog>();
		for (Long id : ids) {
			equipmentOptionLogs.add(application.getEquipmentOptionLog(id));
		}
		application.removeEquipmentOptionLogs(equipmentOptionLogs);
		return true;
	}

	public List<EquipmentOptionLogDTO> findAllEquipmentOptionLog() {
		return EquipmentOptionLogAssembler.toDTOs(application
				.findAllEquipmentOptionLog());
	}

	public Page<EquipmentOptionLogDTO> pageQueryEquipmentOptionLog(
			EquipmentOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _equipmentOptionLog from EquipmentOptionLog _equipmentOptionLog   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _equipmentOptionLog.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _equipmentOptionLog.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _equipmentOptionLog.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _equipmentOptionLog.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _equipmentOptionLog.category like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategory()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _equipmentOptionLog.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		if (queryVo.getSubStatus() != null
				&& !"".equals(queryVo.getSubStatus())) {
			jpql.append(" and _equipmentOptionLog.subStatus like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getSubStatus()));
		}
		if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
			jpql.append(" and _equipmentOptionLog.optUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptUser()));
		}
		if (queryVo.getOptDate() != null) {
			jpql.append(" and _equipmentOptionLog.optDate between ? and ? ");
			conditionVals.add(queryVo.getOptDate());
			conditionVals.add(queryVo.getOptDateEnd());
		}
		if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
			jpql.append(" and _equipmentOptionLog.nowLot like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
		}
		if (queryVo.getNowStation() != null
				&& !"".equals(queryVo.getNowStation())) {
			jpql.append(" and _equipmentOptionLog.nowStation like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowStation()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _equipmentOptionLog.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getStartTime() != null
				&& !"".equals(queryVo.getStartTime())) {
			jpql.append(" and _equipmentOptionLog.startTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStartTime()));
		}
		if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
			jpql.append(" and _equipmentOptionLog.endTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndTime()));
		}
		if (queryVo.getDuration() != null && !"".equals(queryVo.getDuration())) {
			jpql.append(" and _equipmentOptionLog.duration like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDuration()));
		}
		if (queryVo.getEndOptUser() != null
				&& !"".equals(queryVo.getEndOptUser())) {
			jpql.append(" and _equipmentOptionLog.endOptUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndOptUser()));
		}
		if (queryVo.getStandardWorkHours() != null
				&& !"".equals(queryVo.getStandardWorkHours())) {
			jpql.append(" and _equipmentOptionLog.standardWorkHours like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStandardWorkHours()));
		}
		if (queryVo.getGrossDie() != null && !"".equals(queryVo.getGrossDie())) {
			jpql.append(" and _equipmentOptionLog.grossDie like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getGrossDie()));
		}
		if (queryVo.getTheoryTime() != null
				&& !"".equals(queryVo.getTheoryTime())) {
			jpql.append(" and _equipmentOptionLog.theoryTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTheoryTime()));
		}
		if (queryVo.getInkType() != null && !"".equals(queryVo.getInkType())) {
			jpql.append(" and _equipmentOptionLog.inkType like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getInkType()));
		}
		if (queryVo.getTouchTimes() != null
				&& !"".equals(queryVo.getTouchTimes())) {
			jpql.append(" and _equipmentOptionLog.touchTimes like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTouchTimes()));
		}
		if (queryVo.getTeam() != null && !"".equals(queryVo.getTeam())) {
			jpql.append(" and _equipmentOptionLog.team like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTeam()));
		}
		if (queryVo.getIsShift() != null && !"".equals(queryVo.getIsShift())) {
			jpql.append(" and _equipmentOptionLog.isShift like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getIsShift()));
		}
		if (queryVo.getOptRemark() != null
				&& !"".equals(queryVo.getOptRemark())) {
			jpql.append(" and _equipmentOptionLog.optRemark like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptRemark()));
		}
		if (queryVo.getEquipmentId() != null) {
			jpql.append(" and _equipmentOptionLog.equipment.id = ?");
			conditionVals.add(queryVo.getEquipmentId());
		}
		if (queryVo.getEquipmentNo() != null
				&& !"".equals(queryVo.getEquipmentNo())) {
			jpql.append(" and _equipmentOptionLog.equipment.equipmentNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentNo()));
		}
		if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
			jpql.append(" and _equipmentOptionLog.nowLot like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowLot()));
		}
		jpql.append(" order by _equipmentOptionLog.id desc");
		Page<EquipmentOptionLog> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<EquipmentOptionLogDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				EquipmentOptionLogAssembler.toDTOs(pages.getData()));
	}

	@Override
	public EquipmentDTO findEquipmentByEquipmentOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId, Date endTime) {
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setOptDate(endTime);
		this.saveLastEquipmentOptionLogEndTime(equipmentId, equipmentDTO);

	}

	@Override
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId,
			PlatformDTO platformDTO) {
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setOptDate(platformDTO.getOptDate());
		equipmentDTO.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		equipmentDTO.setOptUser(platformDTO.getOptUser());
		this.saveLastEquipmentOptionLogEndTime(equipmentId, equipmentDTO);
	}

	@Override
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId,
			Date endTime, String acceptanceList) {
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setOptDate(endTime);
		equipmentDTO.setAcceptanceList(acceptanceList);
		this.saveLastEquipmentOptionLogEndTime(equipmentId, equipmentDTO);

	}

	/**
	 * 保存设备操作日志最后一条记录的endTime (后期要加入endOptuser)
	 * 
	 * @param equipmentId
	 * @param endTime
	 */
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId,
			EquipmentDTO equipmentDTO) {
		String jpql = "select o from EquipmentOptionLog o where o.equipment.id=? order by o.id desc";
		EquipmentOptionLog result = (EquipmentOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { equipmentId }).singleResult();
		equipmentDTO.setEndTime(equipmentDTO.getOptDate());
		if (result != null && result.getStartTime() != null) {
			result.setEndTime(equipmentDTO.getEndTime());
			Long duration = equipmentDTO.getEndTime().getTime()
					- result.getStartTime().getTime();
			result.setDuration(duration);
			result.setCompletedChip(equipmentDTO.getPianxuan());
			result.setCompletedChipDescription(equipmentDTO.getPianxuanBeizhu());
			result.setEndOptUser(equipmentDTO.getOptUser());
			application.updateEquipmentOptionLog(result);
			// 修改Probe card操作记录
			// return PlatformOptionLogAssembler.toDTO(result);
		}
	}

	/**
	 * 设备操作日志最后一条记录
	 * 
	 * @param equipmentId
	 */
	public EquipmentOptionLogDTO getLastEquipmentOptionLog(Long equipmentId) {
		String jpql = "select o from EquipmentOptionLog o where o.equipment.id=? order by o.id desc";
		EquipmentOptionLog result = (EquipmentOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql)
				.setParameters(new Object[] { equipmentId }).singleResult();
		return EquipmentOptionLogAssembler.toDTO(result);
	}
}

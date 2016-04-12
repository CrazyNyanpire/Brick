package acetecsemi.com.brick.facade.impl;

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
import acetecsemi.com.brick.facade.impl.assembler.EquipmentAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PlatformFTOptionLogAssembler;
import acetecsemi.com.brick.facade.PlatformFTOptionLogFacade;
import acetecsemi.com.brick.application.PlatformFTOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PlatformFTOptionLogFacadeImpl implements PlatformFTOptionLogFacade {

	@Inject
	private PlatformFTOptionLogApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public InvokeResult getPlatformFTOptionLog(Long id) {
		return InvokeResult.success(PlatformFTOptionLogAssembler
				.toDTO(application.getPlatformFTOptionLog(id)));
	}

	public InvokeResult creatPlatformFTOptionLog(
			PlatformFTOptionLogDTO platformFTOptionLogDTO) {
		application.creatPlatformFTOptionLog(PlatformFTOptionLogAssembler
				.toEntity(platformFTOptionLogDTO));
		return InvokeResult.success();
	}

	public InvokeResult updatePlatformFTOptionLog(
			PlatformFTOptionLogDTO platformFTOptionLogDTO) {
		application.updatePlatformFTOptionLog(PlatformFTOptionLogAssembler
				.toEntity(platformFTOptionLogDTO));
		return InvokeResult.success();
	}

	public InvokeResult removePlatformFTOptionLog(Long id) {
		application.removePlatformFTOptionLog(application
				.getPlatformFTOptionLog(id));
		return InvokeResult.success();
	}

	public InvokeResult removePlatformFTOptionLogs(Long[] ids) {
		Set<PlatformFTOptionLog> platformFTOptionLogs = new HashSet<PlatformFTOptionLog>();
		for (Long id : ids) {
			platformFTOptionLogs.add(application.getPlatformFTOptionLog(id));
		}
		application.removePlatformFTOptionLogs(platformFTOptionLogs);
		return InvokeResult.success();
	}

	public List<PlatformFTOptionLogDTO> findAllPlatformFTOptionLog() {
		return PlatformFTOptionLogAssembler.toDTOs(application
				.findAllPlatformFTOptionLog());
	}

	public Page<PlatformFTOptionLogDTO> pageQueryPlatformFTOptionLog(
			PlatformFTOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _platformFTOptionLog from PlatformFTOptionLog _platformFTOptionLog   left join _platformFTOptionLog.equipment  left join _platformFTOptionLog.Platform  where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _platformFTOptionLog.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _platformFTOptionLog.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _platformFTOptionLog.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _platformFTOptionLog.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _platformFTOptionLog.category like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategory()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _platformFTOptionLog.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		if (queryVo.getSubStatus() != null
				&& !"".equals(queryVo.getSubStatus())) {
			jpql.append(" and _platformFTOptionLog.subStatus like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getSubStatus()));
		}
		if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
			jpql.append(" and _platformFTOptionLog.optUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptUser()));
		}
		if (queryVo.getOptDate() != null) {
			jpql.append(" and _platformFTOptionLog.optDate between ? and ? ");
			conditionVals.add(queryVo.getOptDate());
			conditionVals.add(queryVo.getOptDateEnd());
		}
		if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
			jpql.append(" and _platformFTOptionLog.nowLot like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
		}
		if (queryVo.getNowStation() != null
				&& !"".equals(queryVo.getNowStation())) {
			jpql.append(" and _platformFTOptionLog.nowStation like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowStation()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _platformFTOptionLog.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getStartTime() != null
				&& !"".equals(queryVo.getStartTime())) {
			jpql.append(" and _platformFTOptionLog.startTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStartTime()));
		}
		if (queryVo.getEndTime() != null && !"".equals(queryVo.getEndTime())) {
			jpql.append(" and _platformFTOptionLog.endTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndTime()));
		}
		if (queryVo.getDuration() != null && !"".equals(queryVo.getDuration())) {
			jpql.append(" and _platformFTOptionLog.duration like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDuration()));
		}
		if (queryVo.getEndOptUser() != null
				&& !"".equals(queryVo.getEndOptUser())) {
			jpql.append(" and _platformFTOptionLog.endOptUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndOptUser()));
		}
		if (queryVo.getStandardWorkHours() != null
				&& !"".equals(queryVo.getStandardWorkHours())) {
			jpql.append(" and _platformFTOptionLog.standardWorkHours like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getStandardWorkHours()));
		}
		if (queryVo.getGrossDie() != null && !"".equals(queryVo.getGrossDie())) {
			jpql.append(" and _platformFTOptionLog.grossDie like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getGrossDie()));
		}
		if (queryVo.getTheoryTime() != null
				&& !"".equals(queryVo.getTheoryTime())) {
			jpql.append(" and _platformFTOptionLog.theoryTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTheoryTime()));
		}
		if (queryVo.getInkType() != null && !"".equals(queryVo.getInkType())) {
			jpql.append(" and _platformFTOptionLog.inkType like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getInkType()));
		}
		if (queryVo.getTouchTimes() != null
				&& !"".equals(queryVo.getTouchTimes())) {
			jpql.append(" and _platformFTOptionLog.touchTimes like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTouchTimes()));
		}
		if (queryVo.getTeam() != null && !"".equals(queryVo.getTeam())) {
			jpql.append(" and _platformFTOptionLog.team like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTeam()));
		}
		if (queryVo.getIsShift() != null && !"".equals(queryVo.getIsShift())) {
			jpql.append(" and _platformFTOptionLog.isShift like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getIsShift()));
		}
		if (queryVo.getOptRemark() != null
				&& !"".equals(queryVo.getOptRemark())) {
			jpql.append(" and _platformFTOptionLog.optRemark like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptRemark()));
		}
		if (queryVo.getCategoryPlatform() != null
				&& !"".equals(queryVo.getCategoryPlatform())) {
			jpql.append(" and _platformFTOptionLog.categoryPlatform like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategoryPlatform()));
		}
		if (queryVo.getLastTestNo() != null
				&& !"".equals(queryVo.getLastTestNo())) {
			jpql.append(" and _platformFTOptionLog.lastTestNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastTestNo()));
		}
		if (queryVo.getNowTestNo() != null
				&& !"".equals(queryVo.getNowTestNo())) {
			jpql.append(" and _platformFTOptionLog.nowTestNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowTestNo()));
		}
		Page<PlatformFTOptionLog> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<PlatformFTOptionLogDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				PlatformFTOptionLogAssembler.toDTOs(pages.getData()));
	}

	public EquipmentDTO findEquipmentByPlatformFTOptionLog(Long id) {
		String jpql = "select e from PlatformFTOptionLog o right join o.equipment e where o.id=?";
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

	public PlatformDTO findPlatformByPlatformFTOptionLog(Long id) {
		String jpql = "select e from PlatformFTOptionLog o right join o.Platform e where o.id=?";
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

}

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
import acetecsemi.com.brick.facade.impl.assembler.BorrowMachineAssembler;
import acetecsemi.com.brick.facade.impl.assembler.EquipmentOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.BorrowMachineFacade;
import acetecsemi.com.brick.facade.BorrowMachineOptionLogFacade;
import acetecsemi.com.brick.facade.CategoryFacade;
import acetecsemi.com.brick.facade.EquipmentFacade;
import acetecsemi.com.brick.facade.PlatformFacade;
import acetecsemi.com.brick.facade.SwiftNumberFacade;
import acetecsemi.com.brick.application.BorrowMachineApplication;
import acetecsemi.com.brick.application.EquipmentMaintenanceLogApplication;
import acetecsemi.com.brick.application.PMDocumentApplication;
import acetecsemi.com.brick.application.SwiftNumberApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class BorrowMachineFacadeImpl implements BorrowMachineFacade {

	@Inject
	private BorrowMachineApplication application;

	@Inject
	private PlatformFacade platformFacade;

	@Inject
	private EquipmentFacade equipmentFacade;

	@Inject
	private CategoryFacade categoryFacade;

	@Inject
	private BorrowMachineOptionLogFacade borrowMachineOptionLogFacade;

	@Inject
	private SwiftNumberFacade swiftNumberFacade;

	@Inject
	private EquipmentMaintenanceLogApplication equipmentMaintenanceLogApplication;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public BorrowMachineDTO getBorrowMachine(Long id) {
		BorrowMachineDTO borrowMachineDTO = BorrowMachineAssembler
				.toDTO(application.getBorrowMachine(id));
		return borrowMachineDTO;
	}

	public Boolean creatBorrowMachine(BorrowMachineDTO borrowMachineDTO) {
		borrowMachineDTO.setState("审批前");
		long estimatedTime = borrowMachineDTO.getEstimatedEndTime().getTime()
				- borrowMachineDTO.getEstimatedStartTime().getTime();
		borrowMachineDTO.setEstimatedTime(Long.toString(estimatedTime));
		BorrowMachine borrowMachine = BorrowMachineAssembler
				.toEntity(borrowMachineDTO);
		borrowMachine.setCreateEmployNo(borrowMachineDTO
				.getLastModifyEmployNo());
		borrowMachineDTO
				.setIsPlatform(borrowMachineDTO.getIsPlatform() == null ? true
						: borrowMachineDTO.getIsPlatform());
		if (borrowMachineDTO.getPlatformId() != null
				&& borrowMachineDTO.getIsPlatform()) {
			Platform platform = Platform.load(Platform.class,
					borrowMachineDTO.getPlatformId());
			borrowMachine.setPlatform(platform);
		} else if (borrowMachineDTO.getPlatformId() != null
				&& !borrowMachineDTO.getIsPlatform()) {
			Equipment equipment = Equipment.load(Equipment.class,
					borrowMachineDTO.getPlatformId());
			CategoryDTO category = categoryFacade.getCategory(Long
					.valueOf(borrowMachineDTO.getType()));
			borrowMachine.setType(category.getCategoryName());
			borrowMachine.setEquipment(equipment);
		}
		application.creatBorrowMachine(borrowMachine);
		borrowMachineDTO.setId(borrowMachine.getId());
		borrowMachineOptionLogFacade
				.addBorrowMachineOptionLog(borrowMachineDTO);
		return true;
	}

	public Boolean updateBorrowMachine(BorrowMachineDTO borrowMachineDTO) {
		BorrowMachine borrowMachine = application
				.getBorrowMachine(borrowMachineDTO.getId());
		long estimatedTime = borrowMachineDTO.getEstimatedEndTime().getTime()
				- borrowMachineDTO.getEstimatedStartTime().getTime();
		borrowMachine.setEstimatedTime(Long.toString(estimatedTime));
		borrowMachine.setProposer(borrowMachineDTO.getProposer());
		borrowMachine.setDepartment(borrowMachineDTO.getDepartment());
		borrowMachine.setType(borrowMachineDTO.getType());
		borrowMachine.setEquipName(borrowMachineDTO.getEquipName());
		borrowMachine.setEstimatedStartTime(borrowMachineDTO
				.getEstimatedStartTime());
		borrowMachine.setEstimatedEndTime(borrowMachineDTO
				.getEstimatedEndTime());
		borrowMachine.setBorrowNumber(borrowMachineDTO.getBorrowNumber());
		borrowMachine.setCompany(borrowMachineDTO.getCompany());
		borrowMachine.setRemark(borrowMachineDTO.getRemark());
		if (borrowMachineDTO.getPlatformId() != null) {
			Platform platform = Platform.load(Platform.class,
					borrowMachineDTO.getPlatformId());
			borrowMachine.setPlatform(platform);
		}
		application.updateBorrowMachine(borrowMachine);
		borrowMachineOptionLogFacade
				.addBorrowMachineOptionLog(borrowMachineDTO);
		return true;
	}

	public Boolean approveBorrowMachine(BorrowMachineDTO borrowMachineDTO) {
		BorrowMachine borrowMachine = application
				.getBorrowMachine(borrowMachineDTO.getId());
		borrowMachine.setLastModifyEmployNo(borrowMachineDTO
				.getLastModifyEmployNo());
		borrowMachine.setApprover(borrowMachineDTO.getApprover());
		if (borrowMachineDTO.getState().equals("同意")) {
			if (borrowMachine.getActualEndTime() != null) {
				borrowMachine.setState("已借机");
			} else
				borrowMachine.setState("审批后");
		} else {
			borrowMachine.setState("结单");
		}

		borrowMachine.setBorrowNumber(swiftNumberFacade
				.getNextSwiftNumberBorrowMachine().getNowSwiftNumber());
		application.updateBorrowMachine(borrowMachine);
		borrowMachineOptionLogFacade
				.addBorrowMachineOptionLog(borrowMachineDTO);
		return true;
	}

	public Boolean removeBorrowMachine(Long id) {
		application.removeBorrowMachine(application.getBorrowMachine(id));
		BorrowMachineDTO borrowMachineDTO = new BorrowMachineDTO();
		borrowMachineDTO.setId(id);
		borrowMachineDTO.setState("删除申请");
		borrowMachineOptionLogFacade
				.addBorrowMachineOptionLog(borrowMachineDTO);
		return true;
	}

	public Boolean removeBorrowMachines(Long[] ids) {
		Set<BorrowMachine> borrowMachines = new HashSet<BorrowMachine>();
		for (Long id : ids) {
			borrowMachines.add(application.getBorrowMachine(id));
		}
		application.removeBorrowMachines(borrowMachines);
		return true;
	}

	public List<BorrowMachineDTO> findAllBorrowMachine() {
		return BorrowMachineAssembler
				.toDTOs(application.findAllBorrowMachine());
	}

	public Page<BorrowMachineDTO> pageQueryBorrowMachine(
			BorrowMachineDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _borrowMachine from BorrowMachine _borrowMachine   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _borrowMachine.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _borrowMachine.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _borrowMachine.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _borrowMachine.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getState() != null && !"".equals(queryVo.getState())) {
			jpql.append(" and _borrowMachine.state like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getState()));
		}
		if (queryVo.getProposer() != null && !"".equals(queryVo.getProposer())) {
			jpql.append(" and _borrowMachine.proposer like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProposer()));
		}
		if (queryVo.getDepartment() != null
				&& !"".equals(queryVo.getDepartment())) {
			jpql.append(" and _borrowMachine.department like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDepartment()));
		}
		if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
			jpql.append(" and _borrowMachine.type like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getType()));
		}
		if (queryVo.getAppTime() != null) {
			jpql.append(" and _borrowMachine.appTime between ? and ? ");
			conditionVals.add(queryVo.getAppTime());
			conditionVals.add(queryVo.getAppTimeEnd());
		}
		if (queryVo.getEquipName() != null
				&& !"".equals(queryVo.getEquipName())) {
			jpql.append(" and _borrowMachine.equipName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipName()));
		}
		if (queryVo.getEstimatedStartTime() != null) {
			jpql.append(" and _borrowMachine.estimatedStartTime between ? and ? ");
			conditionVals.add(queryVo.getEstimatedStartTime());
			conditionVals.add(queryVo.getEstimatedStartTimeEnd());
		}
		if (queryVo.getEstimatedEndTime() != null) {
			jpql.append(" and _borrowMachine.estimatedEndTime between ? and ? ");
			conditionVals.add(queryVo.getEstimatedEndTime());
			conditionVals.add(queryVo.getEstimatedEndTimeEnd());
		}
		if (queryVo.getEstimatedTime() != null
				&& !"".equals(queryVo.getEstimatedTime())) {
			jpql.append(" and _borrowMachine.estimatedTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEstimatedTime()));
		}
		if (queryVo.getBorrowNumber() != null
				&& !"".equals(queryVo.getBorrowNumber())) {
			jpql.append(" and _borrowMachine.borrowNumber like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getBorrowNumber()));
		}
		if (queryVo.getActualBeginTime() != null) {
			jpql.append(" and _borrowMachine.actualBeginTime between ? and ? ");
			conditionVals.add(queryVo.getActualBeginTime());
			conditionVals.add(queryVo.getActualBeginTimeEnd());
		}
		if (queryVo.getActualEndTime() != null) {
			jpql.append(" and _borrowMachine.actualEndTime between ? and ? ");
			conditionVals.add(queryVo.getActualEndTime());
			conditionVals.add(queryVo.getActualEndTimeEnd());
		}
		if (queryVo.getActualTime() != null
				&& !"".equals(queryVo.getActualTime())) {
			jpql.append(" and _borrowMachine.actualTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getActualTime()));
		}
		if (queryVo.getApprover() != null && !"".equals(queryVo.getApprover())) {
			jpql.append(" and _borrowMachine.approver like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getApprover()));
		}
		if (queryVo.getCompany() != null && !"".equals(queryVo.getCompany())) {
			jpql.append(" and _borrowMachine.company like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCompany()));
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _borrowMachine.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		jpql.append(" order by _borrowMachine.createTimestamp desc");
		Page<BorrowMachine> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<BorrowMachineDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				BorrowMachineAssembler.toDTOs(pages.getData()));
	}

	/**
	 * 办理借机
	 * 
	 * @param borrowMachineDTO
	 * @return InvokeResult
	 */
	public String handleBorrowMachine(BorrowMachineDTO borrowMachineDTO) {
		BorrowMachine borrowMachine = application
				.getBorrowMachine(borrowMachineDTO.getId());
		Date nowDate = new Date();
		CategoryDTO status = categoryFacade.getCategory(Long.valueOf(120));
		if (borrowMachine.getPlatform() != null
				&& !status.getCategoryName().equals(
						borrowMachine.getPlatform().getStatus())) {
			return "平台状态必须为" + status.getCategoryName();
		}

		if (borrowMachine.getEquipment() != null
				&& !status.getCategoryName().equals(
						borrowMachine.getEquipment().getStatus())) {
			return "平台状态必须为" + status.getCategoryName();
		}

		if (borrowMachine.getEstimatedEndTime().getTime() < nowDate.getTime()
				&& borrowMachine.getActualEndTime() == null) {
			return "超出计划结束借机时间！";
		}
		if (borrowMachine.getEstimatedStartTime().getTime() < nowDate.getTime()
				&& "审批后".equals(borrowMachine.getState())) {
			if (borrowMachine.getIsPlatform()) {
				PlatformDTO platformDTO = new PlatformDTO();
				BeanUtils.copyProperties(borrowMachineDTO, platformDTO);
				platformDTO.setOptUser(borrowMachine.getProposer());
				platformDTO.setId(borrowMachine.getPlatform().getId());
				platformDTO.setStatusId(borrowMachineDTO.getStatusId());
				platformDTO.setSubStatusId(borrowMachineDTO.getSubStatusId());
				platformDTO.setTestQty(borrowMachineDTO.getTestQty());
				platformDTO.setPianxuan(borrowMachineDTO.getPianxuan());
				platformDTO.setPianxuanBeizhu(borrowMachineDTO
						.getPianxuanBeizhu());
				String msg = platformFacade.changePlatformStatus(platformDTO);
				if (msg != null) {
					return msg;
				}
			} else {
				EquipmentDTO equipmentDTO = new EquipmentDTO();
				equipmentDTO.setId(borrowMachine.getEquipment().getId());
				equipmentDTO.setStatusId(borrowMachineDTO.getStatusId());
				equipmentDTO.setSubStatusId(borrowMachineDTO.getSubStatusId());
				equipmentFacade.changeEquipmentStatus(equipmentDTO);
			}
			borrowMachine.setState(borrowMachineDTO.getState());
			borrowMachine.setActualBeginTime(nowDate);
			application.updateBorrowMachine(borrowMachine);
			borrowMachineOptionLogFacade
					.addBorrowMachineOptionLog(borrowMachineDTO);
			return null;
		}
		return "未到计划开始借机时间！";
	}

	/**
	 * 办理还机
	 * 
	 * @param borrowMachineDTO
	 * @return InvokeResult
	 */
	public String handlereturnMachine(BorrowMachineDTO borrowMachineDTO) {
		BorrowMachine borrowMachine = application
				.getBorrowMachine(borrowMachineDTO.getId());
		Date nowDate = new Date();
		long actualTime = 0;
		actualTime = nowDate.getTime()
				- borrowMachine.getActualBeginTime().getTime();
		String msg;
		if ((borrowMachine.getEstimatedStartTime().getTime() < nowDate
				.getTime()
				&& borrowMachine.getEstimatedEndTime().getTime() > nowDate
						.getTime() || borrowMachine.getActualEndTime() != null)
				&& "已借机".equals(borrowMachine.getState())) {
			borrowMachine.setState(borrowMachineDTO.getState());
			borrowMachine.setActualEndTime(nowDate);
			borrowMachine.setActualTime(String.valueOf(actualTime));
			borrowMachine.setLastModifyEmployNo(borrowMachineDTO
					.getLastModifyEmployNo());

			if (borrowMachine.getIsPlatform()) {
				PlatformDTO platformDTO = new PlatformDTO();
				BeanUtils.copyProperties(borrowMachineDTO, platformDTO);
				platformDTO.setId(borrowMachine.getPlatform().getId());
				platformDTO.setStatusId(borrowMachineDTO.getStatusId());
				platformDTO.setSubStatusId(borrowMachineDTO.getSubStatusId());
				platformDTO.setAcceptanceList(borrowMachineDTO
						.getAcceptanceList());
				platformDTO.setLastModifyEmployNo(borrowMachineDTO
						.getLastModifyEmployNo());
				platformDTO.setPianxuan(borrowMachineDTO.getPianxuan());
				platformDTO.setPianxuanBeizhu(borrowMachineDTO
						.getPianxuanBeizhu());
				msg = platformFacade.changePlatformStatus(platformDTO);
				if (msg != null) {
					return msg;
				}
			} else {
				this.updateEquipmentPM(borrowMachine.getEquipment().getId(),
						borrowMachineDTO, borrowMachine);
			}
			// 平台还机更新保养日期，保存pm文件
			if (borrowMachine.getPlatformEquipId() != null
					&& !"".equals(borrowMachine.getPlatformEquipId())
					&& "PM".equals(borrowMachine.getPlatform().getSubSstatus())) {
				for (String id : borrowMachine.getPlatformEquipId().split(",")) {
					if (!"".equals(id)) {
						this.updateEquipmentPM(Long.valueOf(id),
								borrowMachineDTO, borrowMachine);
					}
				}
			}
			application.updateBorrowMachine(borrowMachine);
			borrowMachineOptionLogFacade
					.addBorrowMachineOptionLog(borrowMachineDTO);
			return null;
		}
		borrowMachine.setState("审批前");
		borrowMachine.setActualEndTime(nowDate);
		borrowMachine.setActualTime(String.valueOf(actualTime));
		application.updateBorrowMachine(borrowMachine);
		borrowMachineOptionLogFacade
				.addBorrowMachineOptionLog(borrowMachineDTO);
		return "还机时间大于预计结束时间，申请将重新审批";
	}

	/**
	 * 撤销借机
	 * 
	 * @param borrowMachineDTO
	 * @return InvokeResult
	 */
	public String cancelBorrowMachine(BorrowMachineDTO borrowMachineDTO) {
		BorrowMachine borrowMachine = application
				.getBorrowMachine(borrowMachineDTO.getId());
		if (!borrowMachineDTO.getLastModifyEmployNo().equals(
				borrowMachine.getCreateEmployNo())) {
			return "撤销借机必须是提交申请人员！";
		}
		if ("审批后".equals(borrowMachine.getState())
				|| "审批前".equals(borrowMachine.getState())
				&& borrowMachine.getActualEndTime() == null) {
			borrowMachine.setState(borrowMachineDTO.getState() + "撤销");
			application.updateBorrowMachine(borrowMachine);
			borrowMachineDTO.setId(borrowMachine.getId());
			borrowMachineDTO.setRemark("撤销借机申请");
			borrowMachineOptionLogFacade
					.addBorrowMachineOptionLog(borrowMachineDTO);
			return null;
		}
		return "撤销借机失败！";
	}

	public EquipmentDTO getNextMaintenancePlanDate(
			BorrowMachineDTO borrowMachineDTO, EquipmentDTO equipmentDTO,
			BorrowMachine borrowMachine) {
		EquipmentDTO equipment = equipmentFacade.getEquipment(equipmentDTO
				.getId());
		// PM借机日志
		EquipmentMaintenanceLog equipmentMaintenanceLog = new EquipmentMaintenanceLog();
		equipmentMaintenanceLog
				.setPlanStartDate(MyDateUtils.formaterDate(
						equipment.getNextMaintenanceDate(),
						MyDateUtils.DefFormatString));
		equipmentMaintenanceLog
				.setRealStartDate(MyDateUtils.formaterDate(
						borrowMachine.getActualBeginTime(),
						MyDateUtils.DefFormatString));
		equipmentMaintenanceLog.setRealEndDate(MyDateUtils.formaterDate(
				borrowMachine.getActualEndTime(), MyDateUtils.DefFormatString));
		equipmentMaintenanceLog.setNowMaintenancePlanDate(equipment
				.getNextMaintenancePlanDate());
		equipmentMaintenanceLog.setCreateEmployNo(borrowMachine
				.getCreateEmployNo());
		equipmentMaintenanceLog.setPmType(borrowMachineDTO.getPmType());
		equipment.setPmType(equipmentDTO.getPmType());
		equipment = this.getNextMaintenanceDate(equipment);
		equipmentDTO.setNextMaintenanceDate(equipment.getNextMaintenanceDate());
		equipmentDTO.setNextMaintenancePlanDate(equipment
				.getNextMaintenancePlanDate());
		equipmentDTO.setNowMaintenancePlanDate(equipment
				.getNowMaintenancePlanDate());
		equipmentMaintenanceLog.setNextMaintenancePlanDate(equipmentDTO
				.getNextMaintenancePlanDate());
		equipmentMaintenanceLog.setLastModifyEmployNo(borrowMachineDTO
				.getLastModifyEmployNo());
		equipmentMaintenanceLog.setEquipment(Equipment.get(Equipment.class,
				equipmentDTO.getId()));
		equipmentMaintenanceLogApplication
				.creatEquipmentMaintenanceLog(equipmentMaintenanceLog);
		equipmentDTO.setEquipmentMaintenanceLogId(equipmentMaintenanceLog
				.getId());
		return equipmentDTO;
	}

	public void saveEquipmentMaintenanceLog(EquipmentDTO equipmentDTO) {

	}

	private EquipmentDTO getNextMaintenanceDate(EquipmentDTO equipment) {
		String nextMaintenancePlanDate = equipment.getNextMaintenancePlanDate();
		String nowMaintenancePlanDate = equipment.getNowMaintenancePlanDate();
		String[] nextMaintenancePlanDates = nextMaintenancePlanDate
				.split("\\|");
		String[] nowMaintenancePlanDates = nowMaintenancePlanDate.split("\\|");
		String dateStr = MyDateUtils
				.formaterDate(equipment.getNextMaintenanceDate(),
						MyDateUtils.DefFormatString);
		StringBuffer nextMaintenancePlanDateBuffer = new StringBuffer();
		StringBuffer nowMaintenancePlanDateBuffer = new StringBuffer();
		// 月保养
		if (nextMaintenancePlanDates[0].equals(dateStr)
				&& equipment.getPmType().indexOf("月") > -1) {
			nextMaintenancePlanDateBuffer
					.append(MyDateUtils.formaterDate(
							MyDateUtils.addMonths(
									equipment.getNextMaintenanceDate(), 1),
							MyDateUtils.DefFormatString));
			nowMaintenancePlanDateBuffer.append(dateStr);
		} else {
			nextMaintenancePlanDateBuffer.append(nextMaintenancePlanDates[0]);
			nowMaintenancePlanDateBuffer.append(nowMaintenancePlanDates[0]);
		}
		nextMaintenancePlanDateBuffer.append("|");
		nowMaintenancePlanDateBuffer.append("|");
		// 季保养
		if (nextMaintenancePlanDates.length == 2
				&& dateStr.equals(nextMaintenancePlanDates[1])
				&& equipment.getPmType().indexOf("季") > -1) {
			nextMaintenancePlanDateBuffer
					.append(MyDateUtils.formaterDate(
							MyDateUtils.addMonths(
									equipment.getNextMaintenanceDate(), 3),
							MyDateUtils.DefFormatString));
			nowMaintenancePlanDateBuffer.append(dateStr);
		} else if (nextMaintenancePlanDates.length == 2) {
			nextMaintenancePlanDateBuffer.append("");
			nowMaintenancePlanDateBuffer.append(nowMaintenancePlanDates[1]);
		}
		// 年保养
		nextMaintenancePlanDateBuffer.append("|");
		nowMaintenancePlanDateBuffer.append("|");
		if (nextMaintenancePlanDates.length == 3
				&& nextMaintenancePlanDates[2].equals(dateStr)
				&& equipment.getPmType().indexOf("年") > -1) {
			nextMaintenancePlanDateBuffer.append(MyDateUtils.formaterDate(
					MyDateUtils.addMonths(equipment.getNextMaintenanceDate(),
							12), MyDateUtils.DefFormatString));
			nowMaintenancePlanDateBuffer.append(dateStr);
		} else if (nextMaintenancePlanDates.length == 3) {
			nextMaintenancePlanDateBuffer.append(nextMaintenancePlanDates[2]);
			nowMaintenancePlanDateBuffer.append(nowMaintenancePlanDates[2]);
		}
		equipment.setNextMaintenancePlanDate(nextMaintenancePlanDateBuffer
				.toString());
		equipment.setNowMaintenancePlanDate(nowMaintenancePlanDateBuffer
				.toString());
		equipment.setNextMaintenanceDate(MyDateUtils.addMonths(
				equipment.getNextMaintenanceDate(), 1));
		return equipment;
	}

	private void updateEquipmentPM(Long id, BorrowMachineDTO borrowMachineDTO,
			BorrowMachine borrowMachine) {
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setId(id);
		equipmentDTO.setStatusId(borrowMachineDTO.getStatusId());
		equipmentDTO.setSubStatusId(borrowMachineDTO.getSubStatusId());
		equipmentDTO.setPmType(borrowMachineDTO.getPmType());
		equipmentDTO = this.getNextMaintenancePlanDate(borrowMachineDTO,
				equipmentDTO, borrowMachine);
		equipmentDTO.setAcceptanceList(borrowMachineDTO.getAcceptanceList());
		equipmentDTO.setLastModifyEmployNo(borrowMachineDTO
				.getLastModifyEmployNo());
		equipmentFacade.changeEquipmentStatus(equipmentDTO);
	}

}

package acetecsemi.com.brick.infra.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import acetecsemi.com.brick.core.domain.Equipment;
import acetecsemi.com.brick.facade.OAUserFacade;
import acetecsemi.com.brick.facade.SenderMailFacade;
import acetecsemi.com.brick.facade.dto.OAUserDTO;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.infra.MaintenanceEquipmentSendNotice;

public class MaintenanceEquipmentSendNoticeImpl implements
		MaintenanceEquipmentSendNotice {
	private static Logger LOGGER = Logger
			.getLogger(MaintenanceEquipmentSendNoticeImpl.class);

	private static String EQUIPMENTNO = "#EQUIPMENTNO#";

	private static String NOTICEDATE = "#NOTICEDATE#";

	@Inject
	private SenderMailFacade senderMailFacade;

	@Inject
	private OAUserFacade oaUserFacade;

	private String content;

	private String subject;

	private String ccDeptId;

	private String[] deptMailArray;

	private int noticeDays;

	@Override
	public void sendNoticeMail() {
		MaintenanceNotice();
	}

	public void MaintenanceNotice() {
		List<Equipment> equipmentList = Equipment.findAll(Equipment.class);
		// 当前日期加3天,提醒3天后的保养
		Date date = MyDateUtils.add(MyDateUtils.getTodayDD(),
				Calendar.DAY_OF_MONTH, this.getNoticeDays());
		// String noticeDate = MyDateUtils.formaterDate(date,
		// MyDateUtils.DefFormatString);
		for (Equipment equipment : equipmentList) {
			equipment = this.initMaintenanceDate(equipment);
			// 如果当前日期加3天,有计划保养日期,发生消息

			if (equipment.getNextMaintenanceDate().getTime() <= date.getTime()) {
				String tempContent = this.createMailContent(equipment
						.getEquipmentNo(), MyDateUtils.formaterDate(
						equipment.getNextMaintenanceDate(),
						MyDateUtils.DefFormatString));
				LOGGER.info(tempContent);
				String toUser = this.getToUser(equipment.getResponsible()
						.split("\\|")[0]);
				//toUser = "harlow.zhou@acetecsemi.net";
				if ("".equals(toUser)) {
					LOGGER.info("责任人:" + equipment.getResponsible());
				} else
					senderMailFacade.sendMailHelper(this.getSubject(),
							tempContent, toUser, this.getCCUser());
			}

		}
	}

	private String getToUser(String sn) {
		if (sn == null || "".equals(sn.trim())) {
			return "";
		}
		OAUserDTO oaUserDTO = new OAUserDTO();
		oaUserDTO.setAccounts(sn);
		List<OAUserDTO> userList = oaUserFacade.findByCondition(oaUserDTO);
		if (userList != null && userList.size() > 0) {
			OAUserDTO userDTO = userList.get(0);
			return userDTO.getEmail();
		} else
			return "";
	}

	private String[] getCCUser() {
		if (this.deptMailArray == null) {
			if (this.getCcDeptId() == null || "".equals(this.getCcDeptId())) {
				return new String[] {};
			}
			OAUserDTO oaUserDTO = new OAUserDTO();
			oaUserDTO.setDeptIds(this.getCcDeptId());
			oaUserDTO.setUserPriv("48");//部门领导
			List<String> mailList = new ArrayList<String>();
			List<OAUserDTO> userList = oaUserFacade.findByCondition(oaUserDTO);
			for (OAUserDTO userDTO : userList) {
				if (userDTO.getEmail() != null
						&& !"".equals(userDTO.getEmail()))
					mailList.add(userDTO.getEmail());
			}
			this.deptMailArray = mailList.toArray(new String[mailList.size()]);
		}
		return this.deptMailArray;
	}

	private Equipment initMaintenanceDate(Equipment equipment) {
		if (equipment.getNowMaintenancePlanDate() == null
				|| "".equals(equipment.getNowMaintenancePlanDate())) {
			String dateStr = MyDateUtils.formaterDate(
					equipment.getMaintenanceStartDate(),
					MyDateUtils.DefFormatString);
			equipment.setNowMaintenancePlanDate(dateStr + "|" + dateStr + "|"
					+ dateStr);
			equipment.setNextMaintenancePlanDate(this.getNextMaintenanceDate(
					equipment.getMaintenanceStartDate(), equipment));
			equipment.setNextMaintenanceDate(this.getNextPlanDate(equipment
					.getNextMaintenancePlanDate()));
			equipment.save();
		} else if (equipment.getNextMaintenancePlanDate() == null
				|| "".equals(equipment.getNextMaintenancePlanDate())) {
			equipment.setNextMaintenancePlanDate(this.getNextMaintenanceDate(
					equipment.getNextMaintenanceDate(), equipment));
			equipment.save();
		}
		return equipment;
	}

	private String getNextMaintenanceDate(Date date, Equipment equipment) {
		StringBuffer nextMaintenancePlanDate = new StringBuffer();
		Date nowDate = new Date();
		if ("on".equals(equipment.getRepairCycleMonth())) {
			nextMaintenancePlanDate
					.append(MyDateUtils.formaterDate(
							this.nowDate(date, nowDate, 1),
							MyDateUtils.DefFormatString));
		}
		nextMaintenancePlanDate.append("|");
		if ("on".equals(equipment.getRepairCycleSeason())) {
			nextMaintenancePlanDate
					.append(MyDateUtils.formaterDate(
							this.nowDate(date, nowDate, 3),
							MyDateUtils.DefFormatString));
		}
		nextMaintenancePlanDate.append("|");
		if ("on".equals(equipment.getRepairCycleYear())) {
			nextMaintenancePlanDate.append(MyDateUtils.formaterDate(
					this.nowDate(date, nowDate, 12),
					MyDateUtils.DefFormatString));
		}
		return nextMaintenancePlanDate.toString();
	}

	private String createMailContent(String equipmentNo, String noticeDate) {
		// #EQUIPMENTNO#设备保养计划(#NOTICEDATE#)快到期，请尽快处理！
		return this.getContent().replace(EQUIPMENTNO, equipmentNo)
				.replace(NOTICEDATE, noticeDate);
	}

	private Date nowDate(Date indate, Date nowDate, int sign) {
		Date date = MyDateUtils.addMonths(indate, sign);
		if (nowDate.before(date)) {
			return date;
		} else {
			return this.nowDate(date, nowDate, sign);
		}
	}

	private Date getNextPlanDate(String nextMaintenancePlanDate) {
		String[] nextDates = nextMaintenancePlanDate.split("\\|");
		Date minDate = null;
		for (String date : nextDates) {
			Date tempDate = new Date();
			if (!"".equals(date)) {
				tempDate = MyDateUtils.str2Date(date,
						MyDateUtils.DefFormatString);
			} else {
				continue;
			}
			if (minDate == null || minDate.after(tempDate)) {
				minDate = tempDate;
			}
		}
		return minDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNoticeDays() {
		return noticeDays;
	}

	public void setNoticeDays(int noticeDays) {
		this.noticeDays = noticeDays;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCcDeptId() {
		return ccDeptId;
	}

	public void setCcDeptId(String ccDeptId) {
		this.ccDeptId = ccDeptId;
	}

	public String[] getDeptMailArray() {
		return deptMailArray;
	}

	public void setDeptMailArray(String[] deptMailArray) {
		this.deptMailArray = deptMailArray;
	}

}

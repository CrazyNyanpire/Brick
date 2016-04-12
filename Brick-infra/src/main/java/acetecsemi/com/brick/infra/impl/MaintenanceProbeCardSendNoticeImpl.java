package acetecsemi.com.brick.infra.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import acetecsemi.com.brick.facade.OAUserFacade;
import acetecsemi.com.brick.facade.ProbeCardFacade;
import acetecsemi.com.brick.facade.SenderMailFacade;
import acetecsemi.com.brick.facade.dto.OAUserDTO;
import acetecsemi.com.brick.facade.dto.ProbeCardDTO;
import acetecsemi.com.brick.infra.MaintenanceProbeCardSendNotice;
import acetecsemi.com.brick.infra.MesTimeClient;

public class MaintenanceProbeCardSendNoticeImpl implements
		MaintenanceProbeCardSendNotice {
	private static Logger LOGGER = Logger
			.getLogger(MaintenanceProbeCardSendNoticeImpl.class);

	private static String PROBERCARDNO = "#PROBERCARDNO#";

	private static String TOUCHDOWN = "#TOUCHDOWN#";

	private static String MAINTAINMAX = "#MAINTAINMAX#";

	private static String SLICE = "#SLICE#";

	private static String PRODUCT = "#PRODUCT#";

	@Inject
	private SenderMailFacade senderMailFacade;

	@Inject
	private MesTimeClient mesTimeClient;

	@Inject
	private ProbeCardFacade probeCardFacade;

	@Inject
	private OAUserFacade oaUserFacade;

	private String contentWarning;

	private String subjectWarning;

	private String contentWarningSlice;

	private String contentError;

	private String subjectError;

	private String content;

	private String toUsers;

	private String[] toUsersArray;
	
	private Long sliceNum;

	@Override
	public void sendNoticeMail() {
		List<ProbeCardDTO> pcList = probeCardFacade.findAllProbeCard();
		String content = "";
		for (ProbeCardDTO probeCardDTO : pcList) {
			if (probeCardDTO.getStatusId() == 85
					|| probeCardDTO.getStatusId() == 87) {
				this.createContent(probeCardDTO);
				content += this.getContent();
			}
		}
		LOGGER.info("Probe Card PM 定时提醒");
		senderMailFacade.sendMailHelper("Probe Card PM 定时提醒", content,
				this.getToUsersArray());
		// LOGGER.info(mesTimeClient.getTouchDown("YE5016E"));
		// senderMailUtils.sendMail("test", content,
		// "harlow.zhou@acetecsemi.com");
	}

	public String SendMailWarning(ProbeCardDTO bean) {
		bean.setTouchTime(bean.getTouchTime() == null ? Long.valueOf(0) : bean
				.getTouchTime());
		if (bean.getTouchTime() >= Long
				.valueOf(bean.getMaintenanceUpperLimit())
				|| bean.getTouchTime() <= Long.valueOf(bean
						.getMaintenanceLowerLimit())) {
			return this.getContent();
		}
		String touchDown = mesTimeClient
				.getTouchDown(bean.getNowProductModel());
		if ("".equals(touchDown)) {
			return this.getContent();
		}
		Long engtouchdown = Long.valueOf(touchDown);
		Long sliceNum = Long.valueOf(0);
		String info = "";
		// private String maintenanceUpperLimit;// 保养上限
		// private String maintenanceLowerLimit;// 保养下限
		if (engtouchdown != 0) {
			sliceNum = (Long.valueOf(bean.getMaintenanceUpperLimit()) - bean
					.getTouchTime()) / engtouchdown;
		}
		info += bean.getNowProductModel() + "：" + sliceNum + "片，";
		if (sliceNum >= 25) {
			return this.getContent();
		}
		if (info != "") {
			info = info.substring(0, info.length() - 1);
		}
		// Prober
		// card编号#PROBERCARDNO#于本批次接触次数（#TOUCHDOWN#）将达保养上限（#MAINTAINMAX#），因此参考片数可测（#PRODUCT#:#SLICE#片），请测完建立填写pm保养单并送AMS进行保养。
		// 请维护产品编号为：#PRODUCT#的touchdown数量！;
		this.setContent(this.getContentWarning()
				.replace(PROBERCARDNO, bean.getPartNo())
				.replace(TOUCHDOWN, bean.getTouchTime().toString())
				.replace(MAINTAINMAX, bean.getMaintenanceUpperLimit())
				.replace(PRODUCT, bean.getNowProductModel())
				.replace(SLICE, sliceNum.toString()));

		if (sliceNum == 0) {
			this.setContent(this.getContent()
					+ this.getContentWarningSlice().replace(PRODUCT,
							bean.getNowProductModel()));

		}
		this.sliceNum = sliceNum;
		return this.getContent();
	}

	// / <summary>
	// / touchdown次数超过pm上限时发送邮件通知
	// / </summary>
	public String SendMailError(ProbeCardDTO bean) {
		bean.setTouchTime(bean.getTouchTime() == null ? Long.valueOf(0) : bean
				.getTouchTime());
		if (bean.getTouchTime() > Long.valueOf(bean.getMaintenanceUpperLimit())) {
			// Prober
			// card编号#PROBERCARDNO#于本批次接触次数（#TOUCHDOWN#）超过保养上限（#MAINTAINMAX#），请建立填写pm保养单并送AMS进行保养。"
			this.setContent(this.getContentError()
					.replace(PROBERCARDNO, bean.getPartNo())
					.replace(TOUCHDOWN, bean.getTouchTime().toString())
					.replace(MAINTAINMAX, bean.getMaintenanceUpperLimit()));
			// mail.SendMessage(list, "PM超过保养上限提醒", text, "");
		} else
			this.setContent("");
		return this.getContent();
	}

	public String checkSendMail(ProbeCardDTO bean) {
		this.SendMailError(bean);
		// 发生警告
		if (!"".equals(this.getContent())) {
			senderMailFacade.sendMailHelper(this.getSubjectError(), content,
					this.getToUsersArray());
			return "ERROR";
		}
		this.sliceNum = Long.valueOf(100);//默认可以再测试100片
		this.SendMailWarning(bean);
		// 发送提醒
		if (!"".equals(this.getContent())) {
			senderMailFacade.sendMailHelper(this.getSubjectWarning(), content,
					this.getToUsersArray());
			return "WARNING";
		}
		return "";
	}

	private String[] getToUsersArray() {
		if (this.toUsersArray == null) {
			OAUserDTO oaUserDTO = new OAUserDTO();
			oaUserDTO.setAccounts(this.getToUsers());
			List<OAUserDTO> userList = oaUserFacade.findByCondition(oaUserDTO);
			List<String> toUsersArray = new ArrayList<String>();
			for (OAUserDTO userDTO : userList) {
				toUsersArray.add(userDTO.getEmail());
			}
			this.toUsersArray = toUsersArray.toArray(new String[toUsersArray
					.size()]);
		}
		return this.toUsersArray;
	}

	public void createContent(ProbeCardDTO bean) {
		this.SendMailError(bean);
		this.SendMailWarning(bean);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentWarning() {
		return contentWarning;
	}

	public void setContentWarning(String contentWarning) {
		this.contentWarning = contentWarning;
	}

	public String getContentWarningSlice() {
		return contentWarningSlice;
	}

	public void setContentWarningSlice(String contentWarningSlice) {
		this.contentWarningSlice = contentWarningSlice;
	}

	public String getContentError() {
		return contentError;
	}

	public void setContentError(String contentError) {
		this.contentError = contentError;
	}

	public String getSubjectWarning() {
		return subjectWarning;
	}

	public void setSubjectWarning(String subjectWarning) {
		this.subjectWarning = subjectWarning;
	}

	public String getSubjectError() {
		return subjectError;
	}

	public void setSubjectError(String subjectError) {
		this.subjectError = subjectError;
	}

	public String getToUsers() {
		return toUsers;
	}

	public void setToUsers(String toUsers) {
		this.toUsers = toUsers;
	}

	public Long getSliceNum() {
		return sliceNum;
	}

	public void setSliceNum(Long sliceNum) {
		this.sliceNum = sliceNum;
	}

}

package acetecsemi.com.brick.infra.task;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.infra.MaintenanceEquipmentSendNotice;

@Named
@Transactional
public class MaintenancePlatformTask {
	private static Logger LOGGER = Logger
			.getLogger(MaintenancePlatformTask.class);
	@Inject
	private MaintenanceEquipmentSendNotice maintenanceEquipmentSendNotice;
	
	@Scheduled(cron = "30 00 00 * * ?")
	public void MaintenanceEquipmentNotice() {
		LOGGER.info("MaintenanceEquipmentNotice");
		maintenanceEquipmentSendNotice.sendNoticeMail();
	}
	/*
	 * string text = "Prober card编号" + bean.ACCESSORIES_NUM + "于本批次接触次数（" +
	 * bean.TOUCHDOWN_NUM + "）将达保养上限（" + bean.MAINTAIN_MAX + "），因此参考片数可测（" +
	 * info + "），请测完建立填写pm保养单并送AMS进行保养。"; if (sliceNum == 0) { text +=
	 * " 请维护产品编号为：" + productType + "的touchdown数量！"; } mail.SendMessage(list,
	 * "PM提醒", text, ""); Prober
	 * card编号4D0016于本批次接触次数（230183）将达保养上限（300000），因此参考片数可测
	 * （GL5202B：91片），请测完建立填写pm保养单并送AMS进行保养。 return text;
	 */
}

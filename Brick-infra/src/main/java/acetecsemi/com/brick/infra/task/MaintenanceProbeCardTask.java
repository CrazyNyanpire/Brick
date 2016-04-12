package acetecsemi.com.brick.infra.task;


import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.infra.MaintenanceProbeCardSendNotice;

@Named
@Transactional
public class MaintenanceProbeCardTask {
	private static Logger LOGGER = Logger
			.getLogger(MaintenanceProbeCardTask.class);
	@Inject
	private MaintenanceProbeCardSendNotice maintenanceProbeCardSendNotice;
	
	@Scheduled(cron = "20 30 0 * * ?")
	public void MaintenanceProbeCardNotice() {
		LOGGER.info("MaintenanceProbeCardNotice");
		maintenanceProbeCardSendNotice.sendNoticeMail();
	}

}

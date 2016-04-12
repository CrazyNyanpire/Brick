package acetecsemi.com.brick.infra.task;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.infra.EmployeeInfoSync;

@Named
@Transactional
public class EmployeeBasicInfoTask {
	private static Logger LOGGER = Logger
			.getLogger(MaintenancePlatformTask.class);

	@Inject
	EmployeeInfoSync employeeInfoSync;

	@Scheduled(cron = "0 0 2 ? * WED")
	// 每个星期三1点同步员工信息
	// @Scheduled(cron = "0 0 2 * * ?")
	public void MaintenanceEquipmentNotice() {
		LOGGER.info("MaintenanceEquipmentNotice");
		employeeInfoSync.sync();
	}

	@Scheduled(cron = "0 5 2 ? * WED")
	// 每个星期三1点同步员工信息
	public void createUser() {
		LOGGER.info("createUser");
		employeeInfoSync.createUser();
	}

	@Scheduled(cron = "0 10 2 ? * WED")
	// 每个星期三1点同步员工信息
	public void grantUser() {
		LOGGER.info("grantUser");
		employeeInfoSync.grantUser();
	}
}

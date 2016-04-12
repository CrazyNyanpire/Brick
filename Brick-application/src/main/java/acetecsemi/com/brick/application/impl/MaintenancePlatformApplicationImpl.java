package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.MaintenancePlatformApplication;
import acetecsemi.com.brick.core.domain.MaintenancePlatform;

@Named
@Transactional
public class MaintenancePlatformApplicationImpl implements MaintenancePlatformApplication {

	public MaintenancePlatform getMaintenancePlatform(Long id) {
		return MaintenancePlatform.get(MaintenancePlatform.class, id);
	}
	
	public void creatMaintenancePlatform(MaintenancePlatform maintenancePlatform) {
		maintenancePlatform.save();
	}
	
	public void updateMaintenancePlatform(MaintenancePlatform maintenancePlatform) {
		maintenancePlatform .save();
	}
	
	public void removeMaintenancePlatform(MaintenancePlatform maintenancePlatform) {
		if(maintenancePlatform != null){
			maintenancePlatform.remove();
		}
	}
	
	public void removeMaintenancePlatforms(Set<MaintenancePlatform> maintenancePlatforms) {
		for (MaintenancePlatform maintenancePlatform : maintenancePlatforms) {
			maintenancePlatform.remove();
		}
	}
	
	public List<MaintenancePlatform> findAllMaintenancePlatform() {
		return MaintenancePlatform.findAll(MaintenancePlatform.class);
	}
	
}

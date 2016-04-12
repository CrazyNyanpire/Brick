package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.MaintenancePlatform;

public interface MaintenancePlatformApplication {

	public MaintenancePlatform getMaintenancePlatform(Long id);
	
	public void creatMaintenancePlatform(MaintenancePlatform maintenancePlatform);
	
	public void updateMaintenancePlatform(MaintenancePlatform maintenancePlatform);
	
	public void removeMaintenancePlatform(MaintenancePlatform maintenancePlatform);
	
	public void removeMaintenancePlatforms(Set<MaintenancePlatform> maintenancePlatforms);
	
	public List<MaintenancePlatform> findAllMaintenancePlatform();
	
}


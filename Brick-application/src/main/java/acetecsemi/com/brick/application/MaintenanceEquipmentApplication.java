package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.MaintenanceEquipment;

public interface MaintenanceEquipmentApplication {

	public MaintenanceEquipment getMaintenanceEquipment(Long id);
	
	public void creatMaintenanceEquipment(MaintenanceEquipment maintenanceEquipment);
	
	public void updateMaintenanceEquipment(MaintenanceEquipment maintenanceEquipment);
	
	public void removeMaintenanceEquipment(MaintenanceEquipment maintenanceEquipment);
	
	public void removeMaintenanceEquipments(Set<MaintenanceEquipment> maintenanceEquipments);
	
	public List<MaintenanceEquipment> findAllMaintenanceEquipment();
	
}


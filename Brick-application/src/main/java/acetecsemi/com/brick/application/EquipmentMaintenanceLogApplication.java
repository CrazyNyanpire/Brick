package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.EquipmentMaintenanceLog;

public interface EquipmentMaintenanceLogApplication {

	public EquipmentMaintenanceLog getEquipmentMaintenanceLog(Long id);
	
	public void creatEquipmentMaintenanceLog(EquipmentMaintenanceLog equipmentMaintenanceLog);
	
	public void updateEquipmentMaintenanceLog(EquipmentMaintenanceLog equipmentMaintenanceLog);
	
	public void removeEquipmentMaintenanceLog(EquipmentMaintenanceLog equipmentMaintenanceLog);
	
	public void removeEquipmentMaintenanceLogs(Set<EquipmentMaintenanceLog> equipmentMaintenanceLogs);
	
	public List<EquipmentMaintenanceLog> findAllEquipmentMaintenanceLog();
	
}


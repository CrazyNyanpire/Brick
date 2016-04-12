package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.EquipmentMaintenanceLogApplication;
import acetecsemi.com.brick.core.domain.EquipmentMaintenanceLog;

@Named
@Transactional
public class EquipmentMaintenanceLogApplicationImpl implements EquipmentMaintenanceLogApplication {

	public EquipmentMaintenanceLog getEquipmentMaintenanceLog(Long id) {
		return EquipmentMaintenanceLog.get(EquipmentMaintenanceLog.class, id);
	}
	
	public void creatEquipmentMaintenanceLog(EquipmentMaintenanceLog equipmentMaintenanceLog) {
		equipmentMaintenanceLog.save();
	}
	
	public void updateEquipmentMaintenanceLog(EquipmentMaintenanceLog equipmentMaintenanceLog) {
		equipmentMaintenanceLog .save();
	}
	
	public void removeEquipmentMaintenanceLog(EquipmentMaintenanceLog equipmentMaintenanceLog) {
		if(equipmentMaintenanceLog != null){
			equipmentMaintenanceLog.remove();
		}
	}
	
	public void removeEquipmentMaintenanceLogs(Set<EquipmentMaintenanceLog> equipmentMaintenanceLogs) {
		for (EquipmentMaintenanceLog equipmentMaintenanceLog : equipmentMaintenanceLogs) {
			equipmentMaintenanceLog.remove();
		}
	}
	
	public List<EquipmentMaintenanceLog> findAllEquipmentMaintenanceLog() {
		return EquipmentMaintenanceLog.findAll(EquipmentMaintenanceLog.class);
	}
	
}

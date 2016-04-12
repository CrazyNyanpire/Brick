package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.MaintenanceEquipmentApplication;
import acetecsemi.com.brick.core.domain.MaintenanceEquipment;

@Named
@Transactional
public class MaintenanceEquipmentApplicationImpl implements MaintenanceEquipmentApplication {

	public MaintenanceEquipment getMaintenanceEquipment(Long id) {
		return MaintenanceEquipment.get(MaintenanceEquipment.class, id);
	}
	
	public void creatMaintenanceEquipment(MaintenanceEquipment maintenanceEquipment) {
		maintenanceEquipment.save();
	}
	
	public void updateMaintenanceEquipment(MaintenanceEquipment maintenanceEquipment) {
		maintenanceEquipment .save();
	}
	
	public void removeMaintenanceEquipment(MaintenanceEquipment maintenanceEquipment) {
		if(maintenanceEquipment != null){
			maintenanceEquipment.remove();
		}
	}
	
	public void removeMaintenanceEquipments(Set<MaintenanceEquipment> maintenanceEquipments) {
		for (MaintenanceEquipment maintenanceEquipment : maintenanceEquipments) {
			maintenanceEquipment.remove();
		}
	}
	
	public List<MaintenanceEquipment> findAllMaintenanceEquipment() {
		return MaintenanceEquipment.findAll(MaintenanceEquipment.class);
	}
	
}

package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.MaintenanceApplication;
import acetecsemi.com.brick.core.domain.Maintenance;

@Named
@Transactional
public class MaintenanceApplicationImpl implements MaintenanceApplication {

	public Maintenance getMaintenance(Long id) {
		return Maintenance.get(Maintenance.class, id);
	}
	
	public void creatMaintenance(Maintenance maintenance) {
		maintenance.save();
	}
	
	public void updateMaintenance(Maintenance maintenance) {
		maintenance .save();
	}
	
	public void removeMaintenance(Maintenance maintenance) {
		if(maintenance != null){
			maintenance.remove();
		}
	}
	
	public void removeMaintenances(Set<Maintenance> maintenances) {
		for (Maintenance maintenance : maintenances) {
			maintenance.remove();
		}
	}
	
	public List<Maintenance> findAllMaintenance() {
		return Maintenance.findAll(Maintenance.class);
	}
	
}

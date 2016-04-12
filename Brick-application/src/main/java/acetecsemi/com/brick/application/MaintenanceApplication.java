package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Maintenance;

public interface MaintenanceApplication {

	public Maintenance getMaintenance(Long id);
	
	public void creatMaintenance(Maintenance maintenance);
	
	public void updateMaintenance(Maintenance maintenance);
	
	public void removeMaintenance(Maintenance maintenance);
	
	public void removeMaintenances(Set<Maintenance> maintenances);
	
	public List<Maintenance> findAllMaintenance();
	
}


package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface MaintenanceEquipmentFacade {

	public MaintenanceEquipmentDTO getMaintenanceEquipment(Long id);
	
	public InvokeResult creatMaintenanceEquipment(MaintenanceEquipmentDTO maintenanceEquipment);
	
	public InvokeResult updateMaintenanceEquipment(MaintenanceEquipmentDTO maintenanceEquipment);
	
	public InvokeResult removeMaintenanceEquipment(Long id);
	
	public InvokeResult removeMaintenanceEquipments(Long[] ids);
	
	public List<MaintenanceEquipmentDTO> findAllMaintenanceEquipment();
	
	public Page<MaintenanceEquipmentDTO> pageQueryMaintenanceEquipment(MaintenanceEquipmentDTO maintenanceEquipment, int currentPage, int pageSize);
	
	public EquipmentDTO findEquipmentByMaintenanceEquipment(Long id);


	
}


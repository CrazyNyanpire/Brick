package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface EquipmentMaintenanceLogFacade {

	public InvokeResult getEquipmentMaintenanceLog(Long id);
	
	public InvokeResult creatEquipmentMaintenanceLog(EquipmentMaintenanceLogDTO equipmentMaintenanceLog);
	
	public InvokeResult updateEquipmentMaintenanceLog(EquipmentMaintenanceLogDTO equipmentMaintenanceLog);
	
	public InvokeResult removeEquipmentMaintenanceLog(Long id);
	
	public InvokeResult removeEquipmentMaintenanceLogs(Long[] ids);
	
	public List<EquipmentMaintenanceLogDTO> findAllEquipmentMaintenanceLog();
	
	public Page<EquipmentMaintenanceLogDTO> pageQueryEquipmentMaintenanceLog(EquipmentMaintenanceLogDTO equipmentMaintenanceLog, int currentPage, int pageSize);
	
	public EquipmentDTO findEquipmentByEquipmentMaintenanceLog(Long id);
	
	public List<EquipmentMaintenanceLogDTO> findEquipmentMaintenanceLog(Long id);


	
}


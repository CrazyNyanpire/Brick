package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.EquipmentOptionLog;

public interface EquipmentOptionLogApplication {

	public EquipmentOptionLog getEquipmentOptionLog(Long id);
	
	public void creatEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog);
	
	public void updateEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog);
	
	public void removeEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog);
	
	public void removeEquipmentOptionLogs(Set<EquipmentOptionLog> equipmentOptionLogs);
	
	public List<EquipmentOptionLog> findAllEquipmentOptionLog();
	
}


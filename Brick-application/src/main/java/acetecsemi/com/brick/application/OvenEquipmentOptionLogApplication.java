package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.OvenEquipmentOptionLog;

public interface OvenEquipmentOptionLogApplication {

	public OvenEquipmentOptionLog getOvenEquipmentOptionLog(Long id);
	
	public void creatOvenEquipmentOptionLog(OvenEquipmentOptionLog ovenEquipmentOptionLog);
	
	public void updateOvenEquipmentOptionLog(OvenEquipmentOptionLog ovenEquipmentOptionLog);
	
	public void removeOvenEquipmentOptionLog(OvenEquipmentOptionLog ovenEquipmentOptionLog);
	
	public void removeOvenEquipmentOptionLogs(Set<OvenEquipmentOptionLog> ovenEquipmentOptionLogs);
	
	public List<OvenEquipmentOptionLog> findAllOvenEquipmentOptionLog();
	
}


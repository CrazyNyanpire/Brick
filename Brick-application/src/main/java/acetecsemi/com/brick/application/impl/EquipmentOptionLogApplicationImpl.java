package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.EquipmentOptionLogApplication;
import acetecsemi.com.brick.core.domain.EquipmentOptionLog;

@Named
@Transactional
public class EquipmentOptionLogApplicationImpl implements EquipmentOptionLogApplication {

	public EquipmentOptionLog getEquipmentOptionLog(Long id) {
		return EquipmentOptionLog.get(EquipmentOptionLog.class, id);
	}
	
	public void creatEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog) {
		equipmentOptionLog.save();
	}
	
	public void updateEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog) {
		equipmentOptionLog .save();
	}
	
	public void removeEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog) {
		if(equipmentOptionLog != null){
			equipmentOptionLog.remove();
		}
	}
	
	public void removeEquipmentOptionLogs(Set<EquipmentOptionLog> equipmentOptionLogs) {
		for (EquipmentOptionLog equipmentOptionLog : equipmentOptionLogs) {
			equipmentOptionLog.remove();
		}
	}
	
	public List<EquipmentOptionLog> findAllEquipmentOptionLog() {
		return EquipmentOptionLog.findAll(EquipmentOptionLog.class);
	}
	
}

package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.OvenEquipmentOptionLogApplication;
import acetecsemi.com.brick.core.domain.OvenEquipmentOptionLog;

@Named
@Transactional
public class OvenEquipmentOptionLogApplicationImpl implements OvenEquipmentOptionLogApplication {

	public OvenEquipmentOptionLog getOvenEquipmentOptionLog(Long id) {
		return OvenEquipmentOptionLog.get(OvenEquipmentOptionLog.class, id);
	}
	
	public void creatOvenEquipmentOptionLog(OvenEquipmentOptionLog ovenEquipmentOptionLog) {
		ovenEquipmentOptionLog.save();
	}
	
	public void updateOvenEquipmentOptionLog(OvenEquipmentOptionLog ovenEquipmentOptionLog) {
		ovenEquipmentOptionLog .save();
	}
	
	public void removeOvenEquipmentOptionLog(OvenEquipmentOptionLog ovenEquipmentOptionLog) {
		if(ovenEquipmentOptionLog != null){
			ovenEquipmentOptionLog.remove();
		}
	}
	
	public void removeOvenEquipmentOptionLogs(Set<OvenEquipmentOptionLog> ovenEquipmentOptionLogs) {
		for (OvenEquipmentOptionLog ovenEquipmentOptionLog : ovenEquipmentOptionLogs) {
			ovenEquipmentOptionLog.remove();
		}
	}
	
	public List<OvenEquipmentOptionLog> findAllOvenEquipmentOptionLog() {
		return OvenEquipmentOptionLog.findAll(OvenEquipmentOptionLog.class);
	}
	
}

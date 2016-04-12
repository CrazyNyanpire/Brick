package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PinInOutStorageLogApplication;
import acetecsemi.com.brick.core.domain.PinInOutStorageLog;

@Named
@Transactional
public class PinInOutStorageLogApplicationImpl implements PinInOutStorageLogApplication {

	public PinInOutStorageLog getPinInOutStorageLog(Long id) {
		return PinInOutStorageLog.get(PinInOutStorageLog.class, id);
	}
	
	public void creatPinInOutStorageLog(PinInOutStorageLog pinInOutStorageLog) {
		pinInOutStorageLog.save();
	}
	
	public void updatePinInOutStorageLog(PinInOutStorageLog pinInOutStorageLog) {
		pinInOutStorageLog .save();
	}
	
	public void removePinInOutStorageLog(PinInOutStorageLog pinInOutStorageLog) {
		if(pinInOutStorageLog != null){
			pinInOutStorageLog.remove();
		}
	}
	
	public void removePinInOutStorageLogs(Set<PinInOutStorageLog> pinInOutStorageLogs) {
		for (PinInOutStorageLog pinInOutStorageLog : pinInOutStorageLogs) {
			pinInOutStorageLog.remove();
		}
	}
	
	public List<PinInOutStorageLog> findAllPinInOutStorageLog() {
		return PinInOutStorageLog.findAll(PinInOutStorageLog.class);
	}
	
}

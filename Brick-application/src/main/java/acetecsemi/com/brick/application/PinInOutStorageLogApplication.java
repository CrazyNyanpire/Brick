package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.PinInOutStorageLog;

public interface PinInOutStorageLogApplication {

	public PinInOutStorageLog getPinInOutStorageLog(Long id);
	
	public void creatPinInOutStorageLog(PinInOutStorageLog pinInOutStorageLog);
	
	public void updatePinInOutStorageLog(PinInOutStorageLog pinInOutStorageLog);
	
	public void removePinInOutStorageLog(PinInOutStorageLog pinInOutStorageLog);
	
	public void removePinInOutStorageLogs(Set<PinInOutStorageLog> pinInOutStorageLogs);
	
	public List<PinInOutStorageLog> findAllPinInOutStorageLog();
	
}


package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.PlatformOptionLog;

public interface PlatformOptionLogApplication {

	public PlatformOptionLog getPlatformOptionLog(Long id);
	
	public void creatPlatformOptionLog(PlatformOptionLog platformOptionLog);
	
	public void updatePlatformOptionLog(PlatformOptionLog platformOptionLog);
	
	public void removePlatformOptionLog(PlatformOptionLog platformOptionLog);
	
	public void removePlatformOptionLogs(Set<PlatformOptionLog> platformOptionLogs);
	
	public List<PlatformOptionLog> findAllPlatformOptionLog();
	
}


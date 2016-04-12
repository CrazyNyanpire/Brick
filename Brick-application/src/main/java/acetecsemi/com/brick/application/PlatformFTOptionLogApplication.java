package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.PlatformFTOptionLog;

public interface PlatformFTOptionLogApplication {

	public PlatformFTOptionLog getPlatformFTOptionLog(Long id);
	
	public void creatPlatformFTOptionLog(PlatformFTOptionLog platformFTOptionLog);
	
	public void updatePlatformFTOptionLog(PlatformFTOptionLog platformFTOptionLog);
	
	public void removePlatformFTOptionLog(PlatformFTOptionLog platformFTOptionLog);
	
	public void removePlatformFTOptionLogs(Set<PlatformFTOptionLog> platformFTOptionLogs);
	
	public List<PlatformFTOptionLog> findAllPlatformFTOptionLog();
	
}


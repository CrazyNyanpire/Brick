package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.PlatformCPOptionLog;

public interface PlatformCPOptionLogApplication {

	public PlatformCPOptionLog getPlatformCPOptionLog(Long id);
	
	public void creatPlatformCPOptionLog(PlatformCPOptionLog platformCPOptionLog);
	
	public void updatePlatformCPOptionLog(PlatformCPOptionLog platformCPOptionLog);
	
	public void removePlatformCPOptionLog(PlatformCPOptionLog platformCPOptionLog);
	
	public void removePlatformCPOptionLogs(Set<PlatformCPOptionLog> platformCPOptionLogs);
	
	public List<PlatformCPOptionLog> findAllPlatformCPOptionLog();
	
}


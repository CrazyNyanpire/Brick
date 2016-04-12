package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PlatformCPOptionLogApplication;
import acetecsemi.com.brick.core.domain.PlatformCPOptionLog;

@Named
@Transactional
public class PlatformCPOptionLogApplicationImpl implements PlatformCPOptionLogApplication {

	public PlatformCPOptionLog getPlatformCPOptionLog(Long id) {
		return PlatformCPOptionLog.get(PlatformCPOptionLog.class, id);
	}
	
	public void creatPlatformCPOptionLog(PlatformCPOptionLog platformCPOptionLog) {
		platformCPOptionLog.save();
	}
	
	public void updatePlatformCPOptionLog(PlatformCPOptionLog platformCPOptionLog) {
		platformCPOptionLog .save();
	}
	
	public void removePlatformCPOptionLog(PlatformCPOptionLog platformCPOptionLog) {
		if(platformCPOptionLog != null){
			platformCPOptionLog.remove();
		}
	}
	
	public void removePlatformCPOptionLogs(Set<PlatformCPOptionLog> platformCPOptionLogs) {
		for (PlatformCPOptionLog platformCPOptionLog : platformCPOptionLogs) {
			platformCPOptionLog.remove();
		}
	}
	
	public List<PlatformCPOptionLog> findAllPlatformCPOptionLog() {
		return PlatformCPOptionLog.findAll(PlatformCPOptionLog.class);
	}
	
}

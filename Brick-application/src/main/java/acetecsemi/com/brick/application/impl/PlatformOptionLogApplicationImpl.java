package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PlatformOptionLogApplication;
import acetecsemi.com.brick.core.domain.PlatformOptionLog;

@Named
@Transactional
public class PlatformOptionLogApplicationImpl implements PlatformOptionLogApplication {

	public PlatformOptionLog getPlatformOptionLog(Long id) {
		return PlatformOptionLog.get(PlatformOptionLog.class, id);
	}
	
	public void creatPlatformOptionLog(PlatformOptionLog platformOptionLog) {
		platformOptionLog.save();
	}
	
	public void updatePlatformOptionLog(PlatformOptionLog platformOptionLog) {
		platformOptionLog .save();
	}
	
	public void removePlatformOptionLog(PlatformOptionLog platformOptionLog) {
		if(platformOptionLog != null){
			platformOptionLog.remove();
		}
	}
	
	public void removePlatformOptionLogs(Set<PlatformOptionLog> platformOptionLogs) {
		for (PlatformOptionLog platformOptionLog : platformOptionLogs) {
			platformOptionLog.remove();
		}
	}
	
	public List<PlatformOptionLog> findAllPlatformOptionLog() {
		return PlatformOptionLog.findAll(PlatformOptionLog.class);
	}
	
}

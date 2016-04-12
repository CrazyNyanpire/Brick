package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PlatformFTOptionLogApplication;
import acetecsemi.com.brick.core.domain.PlatformFTOptionLog;

@Named
@Transactional
public class PlatformFTOptionLogApplicationImpl implements PlatformFTOptionLogApplication {

	public PlatformFTOptionLog getPlatformFTOptionLog(Long id) {
		return PlatformFTOptionLog.get(PlatformFTOptionLog.class, id);
	}
	
	public void creatPlatformFTOptionLog(PlatformFTOptionLog platformFTOptionLog) {
		platformFTOptionLog.save();
	}
	
	public void updatePlatformFTOptionLog(PlatformFTOptionLog platformFTOptionLog) {
		platformFTOptionLog .save();
	}
	
	public void removePlatformFTOptionLog(PlatformFTOptionLog platformFTOptionLog) {
		if(platformFTOptionLog != null){
			platformFTOptionLog.remove();
		}
	}
	
	public void removePlatformFTOptionLogs(Set<PlatformFTOptionLog> platformFTOptionLogs) {
		for (PlatformFTOptionLog platformFTOptionLog : platformFTOptionLogs) {
			platformFTOptionLog.remove();
		}
	}
	
	public List<PlatformFTOptionLog> findAllPlatformFTOptionLog() {
		return PlatformFTOptionLog.findAll(PlatformFTOptionLog.class);
	}
	
}

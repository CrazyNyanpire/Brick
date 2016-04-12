package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.NormalPartOptionLogApplication;
import acetecsemi.com.brick.core.domain.NormalPartOptionLog;

@Named
@Transactional
public class NormalPartOptionLogApplicationImpl implements NormalPartOptionLogApplication {

	public NormalPartOptionLog getNormalPartOptionLog(Long id) {
		return NormalPartOptionLog.get(NormalPartOptionLog.class, id);
	}
	
	public void creatNormalPartOptionLog(NormalPartOptionLog normalPartOptionLog) {
		normalPartOptionLog.save();
	}
	
	public void updateNormalPartOptionLog(NormalPartOptionLog normalPartOptionLog) {
		normalPartOptionLog .save();
	}
	
	public void removeNormalPartOptionLog(NormalPartOptionLog normalPartOptionLog) {
		if(normalPartOptionLog != null){
			normalPartOptionLog.remove();
		}
	}
	
	public void removeNormalPartOptionLogs(Set<NormalPartOptionLog> normalPartOptionLogs) {
		for (NormalPartOptionLog normalPartOptionLog : normalPartOptionLogs) {
			normalPartOptionLog.remove();
		}
	}
	
	public List<NormalPartOptionLog> findAllNormalPartOptionLog() {
		return NormalPartOptionLog.findAll(NormalPartOptionLog.class);
	}
	
}

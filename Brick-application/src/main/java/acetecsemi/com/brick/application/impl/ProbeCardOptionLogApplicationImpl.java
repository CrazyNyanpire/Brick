package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.ProbeCardOptionLogApplication;
import acetecsemi.com.brick.core.domain.ProbeCardOptionLog;

@Named
@Transactional
public class ProbeCardOptionLogApplicationImpl implements ProbeCardOptionLogApplication {

	public ProbeCardOptionLog getProbeCardOptionLog(Long id) {
		return ProbeCardOptionLog.get(ProbeCardOptionLog.class, id);
	}
	
	public void creatProbeCardOptionLog(ProbeCardOptionLog probeCardOptionLog) {
		probeCardOptionLog.setId(null);
		probeCardOptionLog.save();
	}
	
	public void updateProbeCardOptionLog(ProbeCardOptionLog probeCardOptionLog) {
		probeCardOptionLog .save();
	}
	
	public void removeProbeCardOptionLog(ProbeCardOptionLog probeCardOptionLog) {
		if(probeCardOptionLog != null){
			probeCardOptionLog.remove();
		}
	}
	
	public void removeProbeCardOptionLogs(Set<ProbeCardOptionLog> probeCardOptionLogs) {
		for (ProbeCardOptionLog probeCardOptionLog : probeCardOptionLogs) {
			probeCardOptionLog.remove();
		}
	}
	
	public List<ProbeCardOptionLog> findAllProbeCardOptionLog() {
		return ProbeCardOptionLog.findAll(ProbeCardOptionLog.class);
	}
	
}

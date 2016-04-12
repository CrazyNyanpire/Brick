package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.ProbeCardOptionLog;

public interface ProbeCardOptionLogApplication {

	public ProbeCardOptionLog getProbeCardOptionLog(Long id);
	
	public void creatProbeCardOptionLog(ProbeCardOptionLog probeCardOptionLog);
	
	public void updateProbeCardOptionLog(ProbeCardOptionLog probeCardOptionLog);
	
	public void removeProbeCardOptionLog(ProbeCardOptionLog probeCardOptionLog);
	
	public void removeProbeCardOptionLogs(Set<ProbeCardOptionLog> probeCardOptionLogs);
	
	public List<ProbeCardOptionLog> findAllProbeCardOptionLog();
	
}


package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.NormalPartOptionLog;

public interface NormalPartOptionLogApplication {

	public NormalPartOptionLog getNormalPartOptionLog(Long id);
	
	public void creatNormalPartOptionLog(NormalPartOptionLog normalPartOptionLog);
	
	public void updateNormalPartOptionLog(NormalPartOptionLog normalPartOptionLog);
	
	public void removeNormalPartOptionLog(NormalPartOptionLog normalPartOptionLog);
	
	public void removeNormalPartOptionLogs(Set<NormalPartOptionLog> normalPartOptionLogs);
	
	public List<NormalPartOptionLog> findAllNormalPartOptionLog();
	
}


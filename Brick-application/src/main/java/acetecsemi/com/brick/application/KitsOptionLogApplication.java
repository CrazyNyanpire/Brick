package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.KitsOptionLog;

public interface KitsOptionLogApplication {

	public KitsOptionLog getKitsOptionLog(Long id);
	
	public void creatKitsOptionLog(KitsOptionLog kitsOptionLog);
	
	public void updateKitsOptionLog(KitsOptionLog kitsOptionLog);
	
	public void removeKitsOptionLog(KitsOptionLog kitsOptionLog);
	
	public void removeKitsOptionLogs(Set<KitsOptionLog> kitsOptionLogs);
	
	public List<KitsOptionLog> findAllKitsOptionLog();
	
}


package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.LoadBoardOptionLog;

public interface LoadBoardOptionLogApplication {

	public LoadBoardOptionLog getLoadBoardOptionLog(Long id);
	
	public void creatLoadBoardOptionLog(LoadBoardOptionLog loadBoardOptionLog);
	
	public void updateLoadBoardOptionLog(LoadBoardOptionLog loadBoardOptionLog);
	
	public void removeLoadBoardOptionLog(LoadBoardOptionLog loadBoardOptionLog);
	
	public void removeLoadBoardOptionLogs(Set<LoadBoardOptionLog> loadBoardOptionLogs);
	
	public List<LoadBoardOptionLog> findAllLoadBoardOptionLog();
	
}


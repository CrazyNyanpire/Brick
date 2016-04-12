package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.LoadBoardOptionLogApplication;
import acetecsemi.com.brick.core.domain.LoadBoardOptionLog;

@Named
@Transactional
public class LoadBoardOptionLogApplicationImpl implements LoadBoardOptionLogApplication {

	public LoadBoardOptionLog getLoadBoardOptionLog(Long id) {
		return LoadBoardOptionLog.get(LoadBoardOptionLog.class, id);
	}
	
	public void creatLoadBoardOptionLog(LoadBoardOptionLog loadBoardOptionLog) {
		loadBoardOptionLog.save();
	}
	
	public void updateLoadBoardOptionLog(LoadBoardOptionLog loadBoardOptionLog) {
		loadBoardOptionLog .save();
	}
	
	public void removeLoadBoardOptionLog(LoadBoardOptionLog loadBoardOptionLog) {
		if(loadBoardOptionLog != null){
			loadBoardOptionLog.remove();
		}
	}
	
	public void removeLoadBoardOptionLogs(Set<LoadBoardOptionLog> loadBoardOptionLogs) {
		for (LoadBoardOptionLog loadBoardOptionLog : loadBoardOptionLogs) {
			loadBoardOptionLog.remove();
		}
	}
	
	public List<LoadBoardOptionLog> findAllLoadBoardOptionLog() {
		return LoadBoardOptionLog.findAll(LoadBoardOptionLog.class);
	}
	
}

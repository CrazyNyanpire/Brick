package acetecsemi.com.brick.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface LoadBoardOptionLogFacade {

	public InvokeResult getLoadBoardOptionLog(Long id);
	
	public InvokeResult creatLoadBoardOptionLog(LoadBoardOptionLogDTO loadBoardOptionLog);
	
	public InvokeResult updateLoadBoardOptionLog(LoadBoardOptionLogDTO loadBoardOptionLog);
	
	public InvokeResult removeLoadBoardOptionLog(Long id);
	
	public InvokeResult removeLoadBoardOptionLogs(Long[] ids);
	
	public List<LoadBoardOptionLogDTO> findAllLoadBoardOptionLog();
	
	public Page<LoadBoardOptionLogDTO> pageQueryLoadBoardOptionLog(LoadBoardOptionLogDTO loadBoardOptionLog, int currentPage, int pageSize);
	
	public LoadBoardDTO findLoadBoardByLoadBoardOptionLog(Long id);

	public void saveLastLoadBoardOptionLogEndTime(Long id,
			Date lastModifyTimestamp, String lastModifyEmployNo);

	public Map<String, String> getReleaseInfo(Long id);


	
}


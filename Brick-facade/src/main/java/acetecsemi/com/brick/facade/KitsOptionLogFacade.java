package acetecsemi.com.brick.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface KitsOptionLogFacade {

	public InvokeResult getKitsOptionLog(Long id);
	
	public InvokeResult creatKitsOptionLog(KitsOptionLogDTO kitsOptionLog);
	
	public InvokeResult updateKitsOptionLog(KitsOptionLogDTO kitsOptionLog);
	
	public InvokeResult removeKitsOptionLog(Long id);
	
	public InvokeResult removeKitsOptionLogs(Long[] ids);
	
	public List<KitsOptionLogDTO> findAllKitsOptionLog();
	
	public Page<KitsOptionLogDTO> pageQueryKitsOptionLog(KitsOptionLogDTO kitsOptionLog, int currentPage, int pageSize);
	
	public KitsDTO findKitsByKitsOptionLog(Long id);

	public void saveLastKitsOptionLogEndTime(Long id, Date lastModifyTimestamp,
			 String lastModifyEmployNo);

	public Map<String, String> getReleaseInfo(Long id);


	
}


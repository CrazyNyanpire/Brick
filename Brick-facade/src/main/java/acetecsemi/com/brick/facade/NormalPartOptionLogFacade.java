package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface NormalPartOptionLogFacade {

	public InvokeResult getNormalPartOptionLog(Long id);
	
	public InvokeResult creatNormalPartOptionLog(NormalPartOptionLogDTO normalPartOptionLog);
	
	public InvokeResult updateNormalPartOptionLog(NormalPartOptionLogDTO normalPartOptionLog);
	
	public InvokeResult removeNormalPartOptionLog(Long id);
	
	public InvokeResult removeNormalPartOptionLogs(Long[] ids);
	
	public List<NormalPartOptionLogDTO> findAllNormalPartOptionLog();
	
	public Page<NormalPartOptionLogDTO> pageQueryNormalPartOptionLog(NormalPartOptionLogDTO normalPartOptionLog, int currentPage, int pageSize);
	
	public NormalPartDTO findNormalPartByNormalPartOptionLog(Long id);


	
}


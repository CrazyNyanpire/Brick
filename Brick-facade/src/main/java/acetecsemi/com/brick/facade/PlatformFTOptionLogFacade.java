package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface PlatformFTOptionLogFacade {

	public InvokeResult getPlatformFTOptionLog(Long id);
	
	public InvokeResult creatPlatformFTOptionLog(PlatformFTOptionLogDTO platformFTOptionLog);
	
	public InvokeResult updatePlatformFTOptionLog(PlatformFTOptionLogDTO platformFTOptionLog);
	
	public InvokeResult removePlatformFTOptionLog(Long id);
	
	public InvokeResult removePlatformFTOptionLogs(Long[] ids);
	
	public List<PlatformFTOptionLogDTO> findAllPlatformFTOptionLog();
	
	public Page<PlatformFTOptionLogDTO> pageQueryPlatformFTOptionLog(PlatformFTOptionLogDTO platformFTOptionLog, int currentPage, int pageSize);
	
	public EquipmentDTO findEquipmentByPlatformFTOptionLog(Long id);


		public PlatformDTO findPlatformByPlatformFTOptionLog(Long id);


	
}


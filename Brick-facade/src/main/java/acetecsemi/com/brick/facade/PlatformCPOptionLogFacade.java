package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface PlatformCPOptionLogFacade {

	public InvokeResult getPlatformCPOptionLog(Long id);
	
	public InvokeResult creatPlatformCPOptionLog(PlatformCPOptionLogDTO platformCPOptionLog);
	
	public InvokeResult updatePlatformCPOptionLog(PlatformCPOptionLogDTO platformCPOptionLog);
	
	public InvokeResult removePlatformCPOptionLog(Long id);
	
	public InvokeResult removePlatformCPOptionLogs(Long[] ids);
	
	public List<PlatformCPOptionLogDTO> findAllPlatformCPOptionLog();
	
	public Page<PlatformCPOptionLogDTO> pageQueryPlatformCPOptionLog(PlatformCPOptionLogDTO platformCPOptionLog, int currentPage, int pageSize);
	
	public EquipmentDTO findEquipmentByPlatformCPOptionLog(Long id);


		public PlatformDTO findPlatformByPlatformCPOptionLog(Long id);


	
}


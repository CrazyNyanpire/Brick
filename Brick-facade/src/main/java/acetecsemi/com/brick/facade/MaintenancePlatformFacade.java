package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface MaintenancePlatformFacade {

	public MaintenancePlatformDTO getMaintenancePlatform(Long id);
	
	public Boolean creatMaintenancePlatform(MaintenancePlatformDTO maintenancePlatform);
	
	public Boolean updateMaintenancePlatform(MaintenancePlatformDTO maintenancePlatform);
	
	public Boolean removeMaintenancePlatform(Long id);
	
	public Boolean removeMaintenancePlatforms(Long[] ids);
	
	public List<MaintenancePlatformDTO> findAllMaintenancePlatform();
	
	public Page<MaintenancePlatformDTO> pageQueryMaintenancePlatform(MaintenancePlatformDTO maintenancePlatform, int currentPage, int pageSize);
	
	public PlatformDTO findPlatformByMaintenancePlatform(Long id);


	
}


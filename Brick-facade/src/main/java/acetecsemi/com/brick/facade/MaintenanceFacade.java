package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface MaintenanceFacade {

	public InvokeResult getMaintenance(Long id);
	
	public InvokeResult creatMaintenance(MaintenanceDTO maintenance);
	
	public InvokeResult updateMaintenance(MaintenanceDTO maintenance);
	
	public InvokeResult removeMaintenance(Long id);
	
	public InvokeResult removeMaintenances(Long[] ids);
	
	public List<MaintenanceDTO> findAllMaintenance();
	
	public Page<MaintenanceDTO> pageQueryMaintenance(MaintenanceDTO maintenance, int currentPage, int pageSize);
	

}


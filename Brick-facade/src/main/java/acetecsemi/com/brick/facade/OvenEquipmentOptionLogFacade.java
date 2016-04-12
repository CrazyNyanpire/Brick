package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface OvenEquipmentOptionLogFacade {

	public InvokeResult getOvenEquipmentOptionLog(Long id);
	
	public InvokeResult creatOvenEquipmentOptionLog(OvenEquipmentOptionLogDTO ovenEquipmentOptionLog);
	
	public InvokeResult updateOvenEquipmentOptionLog(OvenEquipmentOptionLogDTO ovenEquipmentOptionLog);
	
	public InvokeResult removeOvenEquipmentOptionLog(Long id);
	
	public InvokeResult removeOvenEquipmentOptionLogs(Long[] ids);
	
	public List<OvenEquipmentOptionLogDTO> findAllOvenEquipmentOptionLog();
	
	public Page<OvenEquipmentOptionLogDTO> pageQueryOvenEquipmentOptionLog(OvenEquipmentOptionLogDTO ovenEquipmentOptionLog, int currentPage, int pageSize);
	
	public EquipmentDTO findEquipmentByOvenEquipmentOptionLog(Long id);


	
}


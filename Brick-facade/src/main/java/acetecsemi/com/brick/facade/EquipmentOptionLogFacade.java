package acetecsemi.com.brick.facade;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface EquipmentOptionLogFacade {

	public EquipmentOptionLogDTO getEquipmentOptionLog(Long id);
	
	public Boolean creatEquipmentOptionLog(EquipmentOptionLogDTO equipmentOptionLog);
	
	public Boolean updateEquipmentOptionLog(EquipmentOptionLogDTO equipmentOptionLog);
	
	public Boolean removeEquipmentOptionLog(Long id);
	
	public Boolean removeEquipmentOptionLogs(Long[] ids);
	
	public List<EquipmentOptionLogDTO> findAllEquipmentOptionLog();
	
	public Page<EquipmentOptionLogDTO> pageQueryEquipmentOptionLog(EquipmentOptionLogDTO equipmentOptionLog, int currentPage, int pageSize);
	
	public EquipmentDTO findEquipmentByEquipmentOptionLog(Long id);

	public void saveLastEquipmentOptionLogEndTime(Long equipmentId,EquipmentDTO equipmentDTO);
	
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId,Date endTime);
	
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId,Date endTime,String acceptanceList);

	public EquipmentOptionLogDTO getLastEquipmentOptionLog(Long equipmentId);
	
	public void saveLastEquipmentOptionLogEndTime(Long equipmentId, PlatformDTO platformDTO);

	
}


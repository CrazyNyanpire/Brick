package acetecsemi.com.brick.facade;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface EquipmentFacade {

	public EquipmentDTO getEquipment(Long id);
	
	public Boolean creatEquipment(EquipmentDTO equipment);
	
	public Boolean updateEquipment(EquipmentDTO equipment);
	
	public Boolean removeEquipment(Long id);
	
	public Boolean removeEquipments(Long[] ids);
	
	public List<EquipmentDTO> findAllEquipment();
	
	public Page<EquipmentDTO> pageQueryEquipment(EquipmentDTO equipment, int currentPage, int pageSize);
	
	public Page<EquipmentDTO> changeStatusPageQueryEquipment(EquipmentDTO equipment, int currentPage, int pageSize);
	
	public PlatformDTO findPlatformByEquipment(Long id);
	
	public List<EquipmentDTO> findEquipmentByPlatform(Long platformId);
	
	public List<EquipmentDTO> findEquipments(EquipmentDTO equipment);
	
	public String changeEquipmentStatus(EquipmentDTO equipment);
	
	public List<EquipmentDTO> findTesterEquipments();

	public List<EquipmentDTO> findComposabilityEquipments();

	public List<CategoryDTO> findEquipmentCategroyAll();
	
	public InvokeResult removeLogicEquipment(Long id);
	
	public InvokeResult removeLogicEquipments(Long[] ids) ;
	
	public InvokeResult checkEquipmentAssemble(Long id);

	public List<Map<String, String>> getEquipmentNoByLot(
			EquipmentDTO equipmentDTO);

}


package acetecsemi.com.brick.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface KitsFacade {

	public InvokeResult getKits(Long id);

	public InvokeResult creatKits(KitsDTO kits);

	public InvokeResult updateKits(KitsDTO kits);

	public InvokeResult removeKits(Long id);

	public InvokeResult removeKitss(Long[] ids);

	public List<KitsDTO> findAllKits();

	public Page<KitsDTO> pageQueryKits(KitsDTO kits, int currentPage,
			int pageSize);

	public CategoryDTO findStatusByKits(Long id);

	public EquipmentDTO findEquipmentByKits(Long id);

	public PlatformDTO findNowPlatformByKits(Long id);

	public List<KitsDTO> findProductAllKits(KitsDTO queryVo);

	public InvokeResult changeKitsStatus(KitsDTO kitsDTO);

	public List<KitsDTO> getKitsByPlatformId(Long id);
	
	public String runLog(KitsDTO kitsDTO);

}

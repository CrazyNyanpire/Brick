package acetecsemi.com.brick.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface NormalPartFacade {

	public NormalPartDTO getNormalParts(Long id);
	
	public InvokeResult getNormalPart(Long id);
	
	public InvokeResult creatNormalPart(NormalPartDTO normalPart);
	
	public InvokeResult updateNormalPart(NormalPartDTO normalPart);
	
	public InvokeResult removeNormalPart(Long id);
	
	public InvokeResult removeNormalParts(Long[] ids);
	
	public List<NormalPartDTO> findAllNormalPart();
	
	public Page<NormalPartDTO> pageQueryNormalPart(NormalPartDTO normalPart, int currentPage, int pageSize);
	

}


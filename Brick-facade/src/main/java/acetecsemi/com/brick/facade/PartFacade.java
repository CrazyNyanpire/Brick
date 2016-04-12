package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface PartFacade {

	public InvokeResult getPart(Long id);
	
	public InvokeResult creatPart(PartDTO part);
	
	public InvokeResult updatePart(PartDTO part);
	
	public InvokeResult removePart(Long id);
	
	public InvokeResult removeParts(Long[] ids);
	
	public List<PartDTO> findAllPart();
	
	public Page<PartDTO> pageQueryPart(PartDTO part, int currentPage, int pageSize);
	

}


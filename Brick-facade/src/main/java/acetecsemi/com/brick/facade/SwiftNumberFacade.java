package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface SwiftNumberFacade {

	public SwiftNumberDTO getSwiftNumber(Long id);
	
	public Boolean creatSwiftNumber(SwiftNumberDTO swiftNumber);
	
	public Boolean updateSwiftNumber(SwiftNumberDTO swiftNumber);
	
	public Boolean removeSwiftNumber(Long id);
	
	public Boolean removeSwiftNumbers(Long[] ids);
	
	public List<SwiftNumberDTO> findAllSwiftNumber();
	
	public Page<SwiftNumberDTO> pageQuerySwiftNumber(SwiftNumberDTO swiftNumber, int currentPage, int pageSize);
	
	public SwiftNumberDTO getNextSwiftNumberBorrowMachine();

}


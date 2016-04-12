package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface TestDataLogFacade {

	public InvokeResult getTestDataLog(Long id);
	
	public InvokeResult creatTestDataLog(TestDataLogDTO testDataLog);
	
	public InvokeResult updateTestDataLog(TestDataLogDTO testDataLog);
	
	public InvokeResult removeTestDataLog(Long id);
	
	public InvokeResult removeTestDataLogs(Long[] ids);
	
	public List<TestDataLogDTO> findAllTestDataLog();
	
	public Page<TestDataLogDTO> pageQueryTestDataLog(TestDataLogDTO testDataLog, int currentPage, int pageSize);
	

}


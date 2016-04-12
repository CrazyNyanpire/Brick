package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.TestDataLog;

public interface TestDataLogApplication {

	public TestDataLog getTestDataLog(Long id);
	
	public void creatTestDataLog(TestDataLog testDataLog);
	
	public void updateTestDataLog(TestDataLog testDataLog);
	
	public void removeTestDataLog(TestDataLog testDataLog);
	
	public void removeTestDataLogs(Set<TestDataLog> testDataLogs);
	
	public List<TestDataLog> findAllTestDataLog();
	
}


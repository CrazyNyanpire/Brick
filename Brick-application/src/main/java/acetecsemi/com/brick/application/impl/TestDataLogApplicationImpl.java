package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.TestDataLogApplication;
import acetecsemi.com.brick.core.domain.TestDataLog;

@Named
@Transactional
public class TestDataLogApplicationImpl implements TestDataLogApplication {

	public TestDataLog getTestDataLog(Long id) {
		return TestDataLog.get(TestDataLog.class, id);
	}
	
	public void creatTestDataLog(TestDataLog testDataLog) {
		testDataLog.save();
	}
	
	public void updateTestDataLog(TestDataLog testDataLog) {
		testDataLog .save();
	}
	
	public void removeTestDataLog(TestDataLog testDataLog) {
		if(testDataLog != null){
			testDataLog.remove();
		}
	}
	
	public void removeTestDataLogs(Set<TestDataLog> testDataLogs) {
		for (TestDataLog testDataLog : testDataLogs) {
			testDataLog.remove();
		}
	}
	
	public List<TestDataLog> findAllTestDataLog() {
		return TestDataLog.findAll(TestDataLog.class);
	}
	
}

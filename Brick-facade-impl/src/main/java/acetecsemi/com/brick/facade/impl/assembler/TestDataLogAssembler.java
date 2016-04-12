package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class TestDataLogAssembler {
	
	public static TestDataLogDTO  toDTO(TestDataLog  testDataLog){
		if (testDataLog == null) {
			return null;
		}
    	TestDataLogDTO result  = new TestDataLogDTO();
	    	result.setId (testDataLog.getId());
     	    	result.setVersion (testDataLog.getVersion());
     	    	result.setCreateTimestamp (testDataLog.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (testDataLog.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (testDataLog.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (testDataLog.getLastModifyEmployNo());
     	    	result.setLogic (testDataLog.getLogic());
     	    	result.setEquipmentNo (testDataLog.getEquipmentNo());
     	    	result.setIp (testDataLog.getIp());
     	    	result.setAcetecLot (testDataLog.getAcetecLot());
     	    	result.setCustomerNo (testDataLog.getCustomerNo());
     	    	result.setProductModel (testDataLog.getProductModel());
     	    	result.setRemark (testDataLog.getRemark());
     	    return result;
	 }
	
	public static List<TestDataLogDTO>  toDTOs(Collection<TestDataLog>  testDataLogs){
		if (testDataLogs == null) {
			return null;
		}
		List<TestDataLogDTO> results = new ArrayList<TestDataLogDTO>();
		for (TestDataLog each : testDataLogs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static TestDataLog  toEntity(TestDataLogDTO  testDataLogDTO){
	 	if (testDataLogDTO == null) {
			return null;
		}
	 	TestDataLog result  = new TestDataLog();
        result.setId (testDataLogDTO.getId());
         result.setVersion (testDataLogDTO.getVersion());
         result.setCreateTimestamp (testDataLogDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (testDataLogDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (testDataLogDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (testDataLogDTO.getLastModifyEmployNo());
         result.setLogic (testDataLogDTO.getLogic());
         result.setEquipmentNo (testDataLogDTO.getEquipmentNo());
         result.setIp (testDataLogDTO.getIp());
         result.setAcetecLot (testDataLogDTO.getAcetecLot());
         result.setCustomerNo (testDataLogDTO.getCustomerNo());
         result.setProductModel (testDataLogDTO.getProductModel());
         result.setRemark (testDataLogDTO.getRemark());
 	  	return result;
	 }
	
	public static List<TestDataLog> toEntities(Collection<TestDataLogDTO> testDataLogDTOs) {
		if (testDataLogDTOs == null) {
			return null;
		}
		
		List<TestDataLog> results = new ArrayList<TestDataLog>();
		for (TestDataLogDTO each : testDataLogDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

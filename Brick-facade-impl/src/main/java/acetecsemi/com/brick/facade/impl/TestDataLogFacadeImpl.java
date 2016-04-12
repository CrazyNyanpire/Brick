package acetecsemi.com.brick.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;
import javax.inject.Inject;
import javax.inject.Named;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.TestDataLogAssembler;
import acetecsemi.com.brick.facade.TestDataLogFacade;
import acetecsemi.com.brick.application.TestDataLogApplication;

import acetecsemi.com.brick.core.domain.*;

@Named
public class TestDataLogFacadeImpl implements TestDataLogFacade {

	@Inject
	private TestDataLogApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getTestDataLog(Long id) {
		return InvokeResult.success(TestDataLogAssembler.toDTO(application.getTestDataLog(id)));
	}
	
	public InvokeResult creatTestDataLog(TestDataLogDTO testDataLogDTO) {
		application.creatTestDataLog(TestDataLogAssembler.toEntity(testDataLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateTestDataLog(TestDataLogDTO testDataLogDTO) {
		application.updateTestDataLog(TestDataLogAssembler.toEntity(testDataLogDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeTestDataLog(Long id) {
		application.removeTestDataLog(application.getTestDataLog(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeTestDataLogs(Long[] ids) {
		Set<TestDataLog> testDataLogs= new HashSet<TestDataLog>();
		for (Long id : ids) {
			testDataLogs.add(application.getTestDataLog(id));
		}
		application.removeTestDataLogs(testDataLogs);
		return InvokeResult.success();
	}
	
	public List<TestDataLogDTO> findAllTestDataLog() {
		return TestDataLogAssembler.toDTOs(application.findAllTestDataLog());
	}
	
	public Page<TestDataLogDTO> pageQueryTestDataLog(TestDataLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _testDataLog from TestDataLog _testDataLog   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _testDataLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _testDataLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _testDataLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _testDataLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getEquipmentNo() != null && !"".equals(queryVo.getEquipmentNo())) {
	   		jpql.append(" and _testDataLog.equipmentNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentNo()));
	   	}		
	   	if (queryVo.getIp() != null && !"".equals(queryVo.getIp())) {
	   		jpql.append(" and _testDataLog.ip like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIp()));
	   	}		
	   	if (queryVo.getAcetecLot() != null && !"".equals(queryVo.getAcetecLot())) {
	   		jpql.append(" and _testDataLog.acetecLot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAcetecLot()));
	   	}		
	   	if (queryVo.getCustomerNo() != null && !"".equals(queryVo.getCustomerNo())) {
	   		jpql.append(" and _testDataLog.customerNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCustomerNo()));
	   	}		
	   	if (queryVo.getProductModel() != null && !"".equals(queryVo.getProductModel())) {
	   		jpql.append(" and _testDataLog.productModel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProductModel()));
	   	}		
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _testDataLog.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
        Page<TestDataLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<TestDataLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, TestDataLogAssembler.toDTOs(pages.getData()));
	}
	
	
}

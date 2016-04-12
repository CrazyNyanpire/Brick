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
import acetecsemi.com.brick.facade.impl.assembler.BorrowMachineOptionLogAssembler;
import acetecsemi.com.brick.facade.BorrowMachineOptionLogFacade;
import acetecsemi.com.brick.application.BorrowMachineApplication;
import acetecsemi.com.brick.application.BorrowMachineOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class BorrowMachineOptionLogFacadeImpl implements BorrowMachineOptionLogFacade {

	@Inject
	private BorrowMachineOptionLogApplication  application;
	
	@Inject
	private BorrowMachineApplication  borrowMachineApplication;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public BorrowMachineOptionLogDTO getBorrowMachineOptionLog(Long id) {
		BorrowMachineOptionLogDTO borrowMachineOptionLogDTO = BorrowMachineOptionLogAssembler.toDTO(application.getBorrowMachineOptionLog(id));
		return borrowMachineOptionLogDTO;
	}
	
	public Boolean creatBorrowMachineOptionLog(BorrowMachineOptionLogDTO borrowMachineOptionLogDTO) {
		application.creatBorrowMachineOptionLog(BorrowMachineOptionLogAssembler.toEntity(borrowMachineOptionLogDTO));
		return true;
	}
	
	public Boolean updateBorrowMachineOptionLog(BorrowMachineOptionLogDTO borrowMachineOptionLogDTO) {
		application.updateBorrowMachineOptionLog(BorrowMachineOptionLogAssembler.toEntity(borrowMachineOptionLogDTO));
		return true;
	}
	
	public Boolean removeBorrowMachineOptionLog(Long id) {
		application.removeBorrowMachineOptionLog(application.getBorrowMachineOptionLog(id));
		return true;
	}
	
	public Boolean removeBorrowMachineOptionLogs(Long[] ids) {
		Set<BorrowMachineOptionLog> borrowMachineOptionLogs= new HashSet<BorrowMachineOptionLog>();
		for (Long id : ids) {
			borrowMachineOptionLogs.add(application.getBorrowMachineOptionLog(id));
		}
		application.removeBorrowMachineOptionLogs(borrowMachineOptionLogs);
		return true;
	}
	
	public List<BorrowMachineOptionLogDTO> findAllBorrowMachineOptionLog() {
		return BorrowMachineOptionLogAssembler.toDTOs(application.findAllBorrowMachineOptionLog());
	}
	
	public Page<BorrowMachineOptionLogDTO> pageQueryBorrowMachineOptionLog(BorrowMachineOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _borrowMachineOptionLog from BorrowMachineOptionLog _borrowMachineOptionLog   where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _borrowMachineOptionLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _borrowMachineOptionLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _borrowMachineOptionLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _borrowMachineOptionLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
	   		jpql.append(" and _borrowMachineOptionLog.category like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCategory()));
	   	}		
	   	if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
	   		jpql.append(" and _borrowMachineOptionLog.status like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
	   	}		
	   	if (queryVo.getOptUser() != null && !"".equals(queryVo.getOptUser())) {
	   		jpql.append(" and _borrowMachineOptionLog.optUser like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptUser()));
	   	}		
	   	if (queryVo.getOptDate() != null) {
	   		jpql.append(" and _borrowMachineOptionLog.optDate between ? and ? ");
	   		conditionVals.add(queryVo.getOptDate());
	   		conditionVals.add(queryVo.getOptDateEnd());
	   	}	
	   	if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
	   		jpql.append(" and _borrowMachineOptionLog.remark like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
	   	}		
        Page<BorrowMachineOptionLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<BorrowMachineOptionLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, BorrowMachineOptionLogAssembler.toDTOs(pages.getData()));
	}

	@Override
	public BorrowMachineDTO findBorrowMachineByBorrowMachineOptionLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 借机申请操作日志
	 * @param borrowMachineDTO
	 * @return
	 */
	public Boolean addBorrowMachineOptionLog(BorrowMachineDTO borrowMachineDTO) {
		BorrowMachineOptionLog borrowMachineOptionLog = new BorrowMachineOptionLog();
		borrowMachineOptionLog.setBorrowMachine(borrowMachineApplication.getBorrowMachine(borrowMachineDTO.getId()));
		borrowMachineOptionLog.setRemark(borrowMachineDTO.getRemark());
		borrowMachineOptionLog.setStatus(borrowMachineDTO.getState());
		application.creatBorrowMachineOptionLog(borrowMachineOptionLog);
		return true;
	}
}

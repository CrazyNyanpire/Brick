package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface BorrowMachineOptionLogFacade {

	public BorrowMachineOptionLogDTO getBorrowMachineOptionLog(Long id);
	
	public Boolean creatBorrowMachineOptionLog(BorrowMachineOptionLogDTO borrowMachineOptionLog);
	
	public Boolean updateBorrowMachineOptionLog(BorrowMachineOptionLogDTO borrowMachineOptionLog);
	
	public Boolean removeBorrowMachineOptionLog(Long id);
	
	public Boolean removeBorrowMachineOptionLogs(Long[] ids);
	
	public List<BorrowMachineOptionLogDTO> findAllBorrowMachineOptionLog();
	
	public Page<BorrowMachineOptionLogDTO> pageQueryBorrowMachineOptionLog(BorrowMachineOptionLogDTO borrowMachineOptionLog, int currentPage, int pageSize);
	
	public BorrowMachineDTO findBorrowMachineByBorrowMachineOptionLog(Long id);

	public Boolean addBorrowMachineOptionLog(BorrowMachineDTO borrowMachineDTO);
	
	
}


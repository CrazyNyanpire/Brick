package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface BorrowMachineFacade {

	public BorrowMachineDTO getBorrowMachine(Long id);
	
	public Boolean creatBorrowMachine(BorrowMachineDTO borrowMachine);
	
	public Boolean updateBorrowMachine(BorrowMachineDTO borrowMachine);
	
	public Boolean approveBorrowMachine(BorrowMachineDTO borrowMachineDTO);
	
	public Boolean removeBorrowMachine(Long id);
	
	public Boolean removeBorrowMachines(Long[] ids);
	
	public List<BorrowMachineDTO> findAllBorrowMachine();
	
	public Page<BorrowMachineDTO> pageQueryBorrowMachine(BorrowMachineDTO borrowMachine, int currentPage, int pageSize);

	public String handleBorrowMachine(BorrowMachineDTO borrowMachineDTO);

	public String handlereturnMachine(BorrowMachineDTO borrowMachineDTO);
	
	public String cancelBorrowMachine(BorrowMachineDTO borrowMachineDTO);

}


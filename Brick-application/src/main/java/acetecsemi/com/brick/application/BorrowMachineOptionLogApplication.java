package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.BorrowMachineOptionLog;

public interface BorrowMachineOptionLogApplication {

	public BorrowMachineOptionLog getBorrowMachineOptionLog(Long id);
	
	public void creatBorrowMachineOptionLog(BorrowMachineOptionLog borrowMachineOptionLog);
	
	public void updateBorrowMachineOptionLog(BorrowMachineOptionLog borrowMachineOptionLog);
	
	public void removeBorrowMachineOptionLog(BorrowMachineOptionLog borrowMachineOptionLog);
	
	public void removeBorrowMachineOptionLogs(Set<BorrowMachineOptionLog> borrowMachineOptionLogs);
	
	public List<BorrowMachineOptionLog> findAllBorrowMachineOptionLog();
	
}


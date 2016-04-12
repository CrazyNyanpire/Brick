package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.BorrowMachine;

public interface BorrowMachineApplication {

	public BorrowMachine getBorrowMachine(Long id);
	
	public void creatBorrowMachine(BorrowMachine borrowMachine);
	
	public void updateBorrowMachine(BorrowMachine borrowMachine);
	
	public void removeBorrowMachine(BorrowMachine borrowMachine);
	
	public void removeBorrowMachines(Set<BorrowMachine> borrowMachines);
	
	public List<BorrowMachine> findAllBorrowMachine();
	
}


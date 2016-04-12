package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.BorrowMachineApplication;
import acetecsemi.com.brick.core.domain.BorrowMachine;

@Named
@Transactional
public class BorrowMachineApplicationImpl implements BorrowMachineApplication {

	public BorrowMachine getBorrowMachine(Long id) {
		return BorrowMachine.get(BorrowMachine.class, id);
	}
	
	public void creatBorrowMachine(BorrowMachine borrowMachine) {
		borrowMachine.save();
	}
	
	public void updateBorrowMachine(BorrowMachine borrowMachine) {
		borrowMachine .save();
	}
	
	public void removeBorrowMachine(BorrowMachine borrowMachine) {
		if(borrowMachine != null){
			borrowMachine.remove();
		}
	}
	
	public void removeBorrowMachines(Set<BorrowMachine> borrowMachines) {
		for (BorrowMachine borrowMachine : borrowMachines) {
			borrowMachine.remove();
		}
	}
	
	public List<BorrowMachine> findAllBorrowMachine() {
		return BorrowMachine.findAll(BorrowMachine.class);
	}
	
}

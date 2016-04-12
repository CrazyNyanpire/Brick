package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.BorrowMachineOptionLogApplication;
import acetecsemi.com.brick.core.domain.BorrowMachineOptionLog;

@Named
@Transactional
public class BorrowMachineOptionLogApplicationImpl implements BorrowMachineOptionLogApplication {

	public BorrowMachineOptionLog getBorrowMachineOptionLog(Long id) {
		return BorrowMachineOptionLog.get(BorrowMachineOptionLog.class, id);
	}
	
	public void creatBorrowMachineOptionLog(BorrowMachineOptionLog borrowMachineOptionLog) {
		borrowMachineOptionLog.save();
	}
	
	public void updateBorrowMachineOptionLog(BorrowMachineOptionLog borrowMachineOptionLog) {
		borrowMachineOptionLog .save();
	}
	
	public void removeBorrowMachineOptionLog(BorrowMachineOptionLog borrowMachineOptionLog) {
		if(borrowMachineOptionLog != null){
			borrowMachineOptionLog.remove();
		}
	}
	
	public void removeBorrowMachineOptionLogs(Set<BorrowMachineOptionLog> borrowMachineOptionLogs) {
		for (BorrowMachineOptionLog borrowMachineOptionLog : borrowMachineOptionLogs) {
			borrowMachineOptionLog.remove();
		}
	}
	
	public List<BorrowMachineOptionLog> findAllBorrowMachineOptionLog() {
		return BorrowMachineOptionLog.findAll(BorrowMachineOptionLog.class);
	}
	
}

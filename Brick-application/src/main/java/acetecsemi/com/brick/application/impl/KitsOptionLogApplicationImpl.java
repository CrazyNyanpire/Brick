package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.KitsOptionLogApplication;
import acetecsemi.com.brick.core.domain.KitsOptionLog;

@Named
@Transactional
public class KitsOptionLogApplicationImpl implements KitsOptionLogApplication {

	public KitsOptionLog getKitsOptionLog(Long id) {
		return KitsOptionLog.get(KitsOptionLog.class, id);
	}
	
	public void creatKitsOptionLog(KitsOptionLog kitsOptionLog) {
		kitsOptionLog.save();
	}
	
	public void updateKitsOptionLog(KitsOptionLog kitsOptionLog) {
		kitsOptionLog .save();
	}
	
	public void removeKitsOptionLog(KitsOptionLog kitsOptionLog) {
		if(kitsOptionLog != null){
			kitsOptionLog.remove();
		}
	}
	
	public void removeKitsOptionLogs(Set<KitsOptionLog> kitsOptionLogs) {
		for (KitsOptionLog kitsOptionLog : kitsOptionLogs) {
			kitsOptionLog.remove();
		}
	}
	
	public List<KitsOptionLog> findAllKitsOptionLog() {
		return KitsOptionLog.findAll(KitsOptionLog.class);
	}
	
}

package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.SocketOptionLogApplication;
import acetecsemi.com.brick.core.domain.SocketOptionLog;

@Named
@Transactional
public class SocketOptionLogApplicationImpl implements SocketOptionLogApplication {

	public SocketOptionLog getSocketOptionLog(Long id) {
		return SocketOptionLog.get(SocketOptionLog.class, id);
	}
	
	public void creatSocketOptionLog(SocketOptionLog socketOptionLog) {
		socketOptionLog.save();
	}
	
	public void updateSocketOptionLog(SocketOptionLog socketOptionLog) {
		socketOptionLog .save();
	}
	
	public void removeSocketOptionLog(SocketOptionLog socketOptionLog) {
		if(socketOptionLog != null){
			socketOptionLog.remove();
		}
	}
	
	public void removeSocketOptionLogs(Set<SocketOptionLog> socketOptionLogs) {
		for (SocketOptionLog socketOptionLog : socketOptionLogs) {
			socketOptionLog.remove();
		}
	}
	
	public List<SocketOptionLog> findAllSocketOptionLog() {
		return SocketOptionLog.findAll(SocketOptionLog.class);
	}
	
}

package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.SocketOptionLog;

public interface SocketOptionLogApplication {

	public SocketOptionLog getSocketOptionLog(Long id);
	
	public void creatSocketOptionLog(SocketOptionLog socketOptionLog);
	
	public void updateSocketOptionLog(SocketOptionLog socketOptionLog);
	
	public void removeSocketOptionLog(SocketOptionLog socketOptionLog);
	
	public void removeSocketOptionLogs(Set<SocketOptionLog> socketOptionLogs);
	
	public List<SocketOptionLog> findAllSocketOptionLog();
	
}


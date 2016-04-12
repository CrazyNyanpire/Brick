package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Socket;

public interface SocketApplication {

	public Socket getSocket(Long id);
	
	public void creatSocket(Socket socket);
	
	public void updateSocket(Socket socket);
	
	public void removeSocket(Socket socket);
	
	public void removeSockets(Set<Socket> sockets);
	
	public List<Socket> findAllSocket();
	
}


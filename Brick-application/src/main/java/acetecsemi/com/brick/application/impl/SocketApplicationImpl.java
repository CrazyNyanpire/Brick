package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.SocketApplication;
import acetecsemi.com.brick.core.domain.Socket;

@Named
@Transactional
public class SocketApplicationImpl implements SocketApplication {

	public Socket getSocket(Long id) {
		return Socket.get(Socket.class, id);
	}
	
	public void creatSocket(Socket socket) {
		socket.save();
	}
	
	public void updateSocket(Socket socket) {
		socket .save();
	}
	
	public void removeSocket(Socket socket) {
		if(socket != null){
			socket.remove();
		}
	}
	
	public void removeSockets(Set<Socket> sockets) {
		for (Socket socket : sockets) {
			socket.remove();
		}
	}
	
	public List<Socket> findAllSocket() {
		return Socket.findAll(Socket.class);
	}
	
}

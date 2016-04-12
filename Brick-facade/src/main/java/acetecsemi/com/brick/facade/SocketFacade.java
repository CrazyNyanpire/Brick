package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface SocketFacade {

	public SocketDTO getSocket(Long id);

	public Boolean creatSocket(SocketDTO socket);

	public Boolean updateSocket(SocketDTO socket);

	public Boolean removeSocket(Long id);

	public Boolean removeSockets(Long[] ids);

	public List<SocketDTO> findAllSocket();

	public Page<SocketDTO> pageQuerySocket(SocketDTO socket, int currentPage,
			int pageSize);

	public EquipmentDTO findEquipmentBySocket(Long id);

	public InvokeResult changeSocketStatus(SocketDTO socketDTO);

	public String runLog(SocketDTO socketDTO);

	public List<SocketDTO> findProductAllSocket(SocketDTO socketDTO);
	
	public List<SocketDTO> getSocketByPlatformId(Long platformId);

}

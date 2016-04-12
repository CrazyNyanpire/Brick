package acetecsemi.com.brick.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface SocketOptionLogFacade {

	public SocketOptionLogDTO getSocketOptionLog(Long id);
	
	public Boolean creatSocketOptionLog(SocketOptionLogDTO socketOptionLog);
	
	public Boolean updateSocketOptionLog(SocketOptionLogDTO socketOptionLog);
	
	public Boolean removeSocketOptionLog(Long id);
	
	public Boolean removeSocketOptionLogs(Long[] ids);
	
	public List<SocketOptionLogDTO> findAllSocketOptionLog();
	
	public Page<SocketOptionLogDTO> pageQuerySocketOptionLog(SocketOptionLogDTO socketOptionLog, int currentPage, int pageSize);
	
	public SocketDTO findSocketBySocketOptionLog(Long id);

	public void saveLastSocketOptionLogEndTime(Long id, Date optDate,Long touchTimes, String endOptUser);
	
	public Map<String ,String> getReleaseInfo(Long socketId);

	
}


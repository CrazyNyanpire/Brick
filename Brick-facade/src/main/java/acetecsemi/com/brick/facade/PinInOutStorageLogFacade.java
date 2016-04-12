package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface PinInOutStorageLogFacade {

	public PinInOutStorageLogDTO getPinInOutStorageLog(Long id);

	public Boolean creatPinInOutStorageLog(
			PinInOutStorageLogDTO pinInOutStorageLog);

	public Boolean updatePinInOutStorageLog(
			PinInOutStorageLogDTO pinInOutStorageLog);

	public Boolean removePinInOutStorageLog(Long id);

	public Boolean removePinInOutStorageLogs(Long[] ids);

	public List<PinInOutStorageLogDTO> findAllPinInOutStorageLog();

	public Page<PinInOutStorageLogDTO> pageQueryPinInOutStorageLog(
			PinInOutStorageLogDTO pinInOutStorageLog, int currentPage,
			int pageSize);

	public SocketDTO findSocketByPinInOutStorageLog(Long id);

	public PinDTO findPinByPinInOutStorageLog(Long id);

}

package acetecsemi.com.brick.facade;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

@WebService()
public interface PlatformOptionLogFacade {

	public PlatformOptionLogDTO getPlatformOptionLog(Long id);

	public Boolean creatPlatformOptionLog(PlatformOptionLogDTO platformOptionLog);

	public Boolean updatePlatformOptionLog(
			PlatformOptionLogDTO platformOptionLog);

	public Boolean removePlatformOptionLog(Long id);

	public Boolean removePlatformOptionLogs(Long[] ids);

	public List<PlatformOptionLogDTO> findAllPlatformOptionLog();

	public Page<PlatformOptionLogDTO> pageQueryPlatformOptionLog(
			PlatformOptionLogDTO platformOptionLog, int currentPage,
			int pageSize);

	public EquipmentDTO findEquipmentByPlatformOptionLog(Long id);

	public PlatformDTO findPlatformByPlatformOptionLog(Long id);

	public PlatformOptionLogDTO saveLastPlatformOptionLogEndTime(
			Long platformId, PlatformDTO platformDTO);

	public PlatformOptionLogDTO getLastPlatformOptionLog(Long platformId);

	public PlatformOptionLogDTO getLastPlatformOptionLog(String platformId);

	public PlatformOptionLogDTO getLastPlatformOptionLogByNowLot(
			Long platformId, PlatformDTO platformDTO);

	public void changeStatusAll(PlatformDTO platformDTO);
}

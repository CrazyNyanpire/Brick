package acetecsemi.com.brick.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface ProbeCardOptionLogFacade {

	public ProbeCardOptionLogDTO getProbeCardOptionLog(Long id);

	public Boolean creatProbeCardOptionLog(
			ProbeCardOptionLogDTO probeCardOptionLog);

	public Boolean updateProbeCardOptionLog(
			ProbeCardOptionLogDTO probeCardOptionLog);

	public Boolean removeProbeCardOptionLog(Long id);

	public Boolean removeProbeCardOptionLogs(Long[] ids);

	public List<ProbeCardOptionLogDTO> findAllProbeCardOptionLog();

	public Page<ProbeCardOptionLogDTO> pageQueryProbeCardOptionLog(
			ProbeCardOptionLogDTO probeCardOptionLog, int currentPage,
			int pageSize);

	public ProbeCardDTO findProbeCardByProbeCardOptionLog(Long id);

	public void saveLastProbeCardOptionLogEndTime(Long probeCardId, Date endTime,Long touchTime,Long touchTimeTotal);
	
	public Map<String ,String> getReleaseInfo(Long probeCardId);
	
	public ProbeCardOptionLogDTO findLastProbeCardOptionLog(Long probeCardId);

	public ProbeCardOptionLogDTO updateLog(ProbeCardOptionLogDTO probeCardOptionLogDTO);

}

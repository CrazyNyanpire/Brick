package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface ProbeCardFacade {

	public ProbeCardDTO getProbeCard(Long id);

	public Boolean creatProbeCard(ProbeCardDTO probeCard);

	public Boolean updateProbeCard(ProbeCardDTO probeCard);

	public Boolean removeProbeCard(Long id);

	public Boolean removeProbeCards(Long[] ids);

	public List<ProbeCardDTO> findAllProbeCard();

	public Page<ProbeCardDTO> pageQueryProbeCard(ProbeCardDTO probeCard,
			int currentPage, int pageSize);

	public ManufacturerDTO findManufacturerByProbeCard(Long id);

	public EquipmentDTO findEquipmentByProbeCard(Long id);

	public String changeProbeCardStatus(ProbeCardDTO probeCardDTO);

	public Boolean runLog(ProbeCardDTO probeCardDTO);
	
	public List<ProbeCardDTO> queryProbeCard(ProbeCardDTO queryVo);

	public List<ProbeCardDTO> findProductAllProbeCard(ProbeCardDTO probeCardDTO);
	
	public List<ProbeCardDTO> getProbeCardByPlatformId(Long platformId);
	
	public ProbeCardDTO updateTouchdownNum(ProbeCardDTO probeCardDTO);
	
	public String changeProbeCardStatus(ProbeCardDTO probeCardDTO,
			Long touchTime, Long touchTimeTotal);

	public ProbeCardDTO updateRelease(ProbeCardDTO probeCardDTO);

}

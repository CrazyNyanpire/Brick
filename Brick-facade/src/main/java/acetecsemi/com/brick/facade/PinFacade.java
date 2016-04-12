package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface PinFacade {

	public PinDTO getPin(Long id);
	
	public Boolean creatPin(PinDTO pin);
	
	public Boolean updatePin(PinDTO pin);
	
	public Boolean removePin(Long id);
	
	public Boolean removePins(Long[] ids);
	
	public List<PinDTO> findAllPin();
	
	public Page<PinDTO> pageQueryPin(PinDTO pin, int currentPage, int pageSize);
	
	public String inStorage(PinDTO pin);
	
	public String outStorage(PinDTO pin);

}


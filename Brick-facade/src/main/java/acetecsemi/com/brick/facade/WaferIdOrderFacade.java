package acetecsemi.com.brick.facade;

import java.util.List;
import java.util.Map;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface WaferIdOrderFacade {

	public InvokeResult getWaferIdOrder(Long id);
	
	public InvokeResult creatWaferIdOrder(WaferIdOrderDTO waferIdOrder);
	
	public InvokeResult updateWaferIdOrder(WaferIdOrderDTO waferIdOrder);
	
	public InvokeResult removeWaferIdOrder(Long id);
	
	public InvokeResult removeWaferIdOrders(Long[] ids);
	
	public List<WaferIdOrderDTO> findAllWaferIdOrder();
	
	public Page<WaferIdOrderDTO> pageQueryWaferIdOrder(WaferIdOrderDTO waferIdOrder, int currentPage, int pageSize);
	
	public List<WaferIdOrderDTO> queryWaferIdOrder(WaferIdOrderDTO queryVo);
	
	public Map<String, Integer> getWaferIdOrderMap(List<WaferIdOrderDTO> waferIdOrderDTOList);
}


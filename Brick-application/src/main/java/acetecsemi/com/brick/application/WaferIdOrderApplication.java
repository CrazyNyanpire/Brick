package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.WaferIdOrder;

public interface WaferIdOrderApplication {

	public WaferIdOrder getWaferIdOrder(Long id);
	
	public void creatWaferIdOrder(WaferIdOrder waferIdOrder);
	
	public void updateWaferIdOrder(WaferIdOrder waferIdOrder);
	
	public void removeWaferIdOrder(WaferIdOrder waferIdOrder);
	
	public void removeWaferIdOrders(Set<WaferIdOrder> waferIdOrders);
	
	public List<WaferIdOrder> findAllWaferIdOrder();
	
}


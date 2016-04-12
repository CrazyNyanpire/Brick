package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.WaferIdOrderApplication;
import acetecsemi.com.brick.core.domain.WaferIdOrder;

@Named
@Transactional
public class WaferIdOrderApplicationImpl implements WaferIdOrderApplication {

	public WaferIdOrder getWaferIdOrder(Long id) {
		return WaferIdOrder.get(WaferIdOrder.class, id);
	}
	
	public void creatWaferIdOrder(WaferIdOrder waferIdOrder) {
		waferIdOrder.save();
	}
	
	public void updateWaferIdOrder(WaferIdOrder waferIdOrder) {
		waferIdOrder .save();
	}
	
	public void removeWaferIdOrder(WaferIdOrder waferIdOrder) {
		if(waferIdOrder != null){
			waferIdOrder.remove();
		}
	}
	
	public void removeWaferIdOrders(Set<WaferIdOrder> waferIdOrders) {
		for (WaferIdOrder waferIdOrder : waferIdOrders) {
			waferIdOrder.remove();
		}
	}
	
	public List<WaferIdOrder> findAllWaferIdOrder() {
		return WaferIdOrder.findAll(WaferIdOrder.class);
	}
	
}

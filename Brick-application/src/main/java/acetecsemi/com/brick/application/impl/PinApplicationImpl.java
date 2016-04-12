package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PinApplication;
import acetecsemi.com.brick.core.domain.Pin;

@Named
@Transactional
public class PinApplicationImpl implements PinApplication {

	public Pin getPin(Long id) {
		return Pin.get(Pin.class, id);
	}
	
	public void creatPin(Pin pin) {
		pin.save();
	}
	
	public void updatePin(Pin pin) {
		pin .save();
	}
	
	public void removePin(Pin pin) {
		if(pin != null){
			pin.remove();
		}
	}
	
	public void removePins(Set<Pin> pins) {
		for (Pin pin : pins) {
			pin.remove();
		}
	}
	
	public List<Pin> findAllPin() {
		return Pin.findAll(Pin.class);
	}
	
}

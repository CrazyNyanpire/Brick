package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Pin;

public interface PinApplication {

	public Pin getPin(Long id);
	
	public void creatPin(Pin pin);
	
	public void updatePin(Pin pin);
	
	public void removePin(Pin pin);
	
	public void removePins(Set<Pin> pins);
	
	public List<Pin> findAllPin();
	
}


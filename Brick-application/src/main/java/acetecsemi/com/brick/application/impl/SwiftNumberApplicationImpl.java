package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.SwiftNumberApplication;
import acetecsemi.com.brick.core.domain.SwiftNumber;

@Named
@Transactional
public class SwiftNumberApplicationImpl implements SwiftNumberApplication {

	public SwiftNumber getSwiftNumber(Long id) {
		return SwiftNumber.get(SwiftNumber.class, id);
	}
	
	public void creatSwiftNumber(SwiftNumber swiftNumber) {
		swiftNumber.save();
	}
	
	public void updateSwiftNumber(SwiftNumber swiftNumber) {
		swiftNumber .save();
	}
	
	public void removeSwiftNumber(SwiftNumber swiftNumber) {
		if(swiftNumber != null){
			swiftNumber.remove();
		}
	}
	
	public void removeSwiftNumbers(Set<SwiftNumber> swiftNumbers) {
		for (SwiftNumber swiftNumber : swiftNumbers) {
			swiftNumber.remove();
		}
	}
	
	public List<SwiftNumber> findAllSwiftNumber() {
		return SwiftNumber.findAll(SwiftNumber.class);
	}
	
}

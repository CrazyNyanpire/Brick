package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.SwiftNumber;

public interface SwiftNumberApplication {

	public SwiftNumber getSwiftNumber(Long id);
	
	public void creatSwiftNumber(SwiftNumber swiftNumber);
	
	public void updateSwiftNumber(SwiftNumber swiftNumber);
	
	public void removeSwiftNumber(SwiftNumber swiftNumber);
	
	public void removeSwiftNumbers(Set<SwiftNumber> swiftNumbers);
	
	public List<SwiftNumber> findAllSwiftNumber();
	
}


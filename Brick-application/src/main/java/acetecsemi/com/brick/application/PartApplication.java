package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;

import acetecsemi.com.brick.core.domain.Part;

public interface PartApplication {

	public Part getPart(Long id);
	
	public void creatPart(Part part);
	
	public void updatePart(Part part);
	
	public void removePart(Part part);
	
	public void removeParts(Set<Part> parts);
	
	public List<Part> findAllPart();
	
}


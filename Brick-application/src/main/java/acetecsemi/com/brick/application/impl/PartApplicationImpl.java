package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.application.PartApplication;
import acetecsemi.com.brick.core.domain.Part;

@Named
@Transactional
public class PartApplicationImpl implements PartApplication {

	public Part getPart(Long id) {
		return Part.get(Part.class, id);
	}
	
	public void creatPart(Part part) {
		part.save();
	}
	
	public void updatePart(Part part) {
		part .save();
	}
	
	public void removePart(Part part) {
		if(part != null){
			part.remove();
		}
	}
	
	public void removeParts(Set<Part> parts) {
		for (Part part : parts) {
			part.remove();
		}
	}
	
	public List<Part> findAllPart() {
		return Part.findAll(Part.class);
	}
	
}

package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.NormalPartApplication;
import acetecsemi.com.brick.core.domain.NormalPart;

@Named
@Transactional
public class NormalPartApplicationImpl implements NormalPartApplication {

	public NormalPart getNormalPart(Long id) {
		return NormalPart.get(NormalPart.class, id);
	}
	
	public void creatNormalPart(NormalPart normalPart) {
		normalPart.save();
	}
	
	public void updateNormalPart(NormalPart normalPart) {
		normalPart .save();
	}
	
	public void removeNormalPart(NormalPart normalPart) {
		if(normalPart != null){
			normalPart.remove();
		}
	}
	
	public void removeNormalParts(Set<NormalPart> normalParts) {
		for (NormalPart normalPart : normalParts) {
			normalPart.remove();
		}
	}
	
	public List<NormalPart> findAllNormalPart() {
		return NormalPart.findAll(NormalPart.class);
	}
	
}

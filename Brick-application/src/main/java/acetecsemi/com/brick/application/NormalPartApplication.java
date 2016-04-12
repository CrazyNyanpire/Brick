package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.NormalPart;

public interface NormalPartApplication {

	public NormalPart getNormalPart(Long id);
	
	public void creatNormalPart(NormalPart normalPart);
	
	public void updateNormalPart(NormalPart normalPart);
	
	public void removeNormalPart(NormalPart normalPart);
	
	public void removeNormalParts(Set<NormalPart> normalParts);
	
	public List<NormalPart> findAllNormalPart();
	
}


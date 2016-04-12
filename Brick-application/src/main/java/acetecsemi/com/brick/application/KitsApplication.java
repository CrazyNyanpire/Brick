package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Kits;

public interface KitsApplication {

	public Kits getKits(Long id);
	
	public void creatKits(Kits kits);
	
	public void updateKits(Kits kits);
	
	public void removeKits(Kits kits);
	
	public void removeKitss(Set<Kits> kitss);
	
	public List<Kits> findAllKits();
	
}


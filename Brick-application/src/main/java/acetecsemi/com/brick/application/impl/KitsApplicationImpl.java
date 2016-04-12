package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.KitsApplication;
import acetecsemi.com.brick.core.domain.Kits;

@Named
@Transactional
public class KitsApplicationImpl implements KitsApplication {

	public Kits getKits(Long id) {
		return Kits.get(Kits.class, id);
	}
	
	public void creatKits(Kits kits) {
		kits.save();
	}
	
	public void updateKits(Kits kits) {
		kits .save();
	}
	
	public void removeKits(Kits kits) {
		if(kits != null){
			kits.remove();
		}
	}
	
	public void removeKitss(Set<Kits> kitss) {
		for (Kits kits : kitss) {
			kits.remove();
		}
	}
	
	public List<Kits> findAllKits() {
		return Kits.findAll(Kits.class);
	}
	
}

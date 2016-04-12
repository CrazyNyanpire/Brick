package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.ProbeCardApplication;
import acetecsemi.com.brick.core.domain.ProbeCard;

@Named
@Transactional
public class ProbeCardApplicationImpl implements ProbeCardApplication {

	public ProbeCard getProbeCard(Long id) {
		return ProbeCard.get(ProbeCard.class, id);
	}
	
	public void creatProbeCard(ProbeCard probeCard) {
		probeCard.save();
	}
	
	public void updateProbeCard(ProbeCard probeCard) {
		probeCard .save();
	}
	
	public void removeProbeCard(ProbeCard probeCard) {
		if(probeCard != null){
			probeCard.remove();
		}
	}
	
	public void removeProbeCards(Set<ProbeCard> probeCards) {
		for (ProbeCard probeCard : probeCards) {
			probeCard.remove();
		}
	}
	
	public List<ProbeCard> findAllProbeCard() {
		return ProbeCard.findAll(ProbeCard.class);
	}
	
}

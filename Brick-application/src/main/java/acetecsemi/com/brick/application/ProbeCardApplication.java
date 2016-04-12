package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.ProbeCard;

public interface ProbeCardApplication {

	public ProbeCard getProbeCard(Long id);
	
	public void creatProbeCard(ProbeCard probeCard);
	
	public void updateProbeCard(ProbeCard probeCard);
	
	public void removeProbeCard(ProbeCard probeCard);
	
	public void removeProbeCards(Set<ProbeCard> probeCards);
	
	public List<ProbeCard> findAllProbeCard();
	
}


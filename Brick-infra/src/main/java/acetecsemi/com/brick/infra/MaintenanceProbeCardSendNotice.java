package acetecsemi.com.brick.infra;

import acetecsemi.com.brick.facade.dto.ProbeCardDTO;

public interface MaintenanceProbeCardSendNotice {
	public void sendNoticeMail();
	
	public String checkSendMail(ProbeCardDTO bean);
	
	public Long getSliceNum();
}

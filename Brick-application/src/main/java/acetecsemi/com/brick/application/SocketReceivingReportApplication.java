package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.SocketReceivingReport;

public interface SocketReceivingReportApplication {

	public SocketReceivingReport getSocketReceivingReport(Long id);
	
	public void creatSocketReceivingReport(SocketReceivingReport socketReceivingReport);
	
	public void updateSocketReceivingReport(SocketReceivingReport socketReceivingReport);
	
	public void removeSocketReceivingReport(SocketReceivingReport socketReceivingReport);
	
	public void removeSocketReceivingReports(Set<SocketReceivingReport> socketReceivingReports);
	
	public List<SocketReceivingReport> findAllSocketReceivingReport();
	
}


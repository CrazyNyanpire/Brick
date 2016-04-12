package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.SocketReceivingReportApplication;
import acetecsemi.com.brick.core.domain.SocketReceivingReport;

@Named
@Transactional
public class SocketReceivingReportApplicationImpl implements SocketReceivingReportApplication {

	public SocketReceivingReport getSocketReceivingReport(Long id) {
		return SocketReceivingReport.get(SocketReceivingReport.class, id);
	}
	
	public void creatSocketReceivingReport(SocketReceivingReport socketReceivingReport) {
		socketReceivingReport.save();
	}
	
	public void updateSocketReceivingReport(SocketReceivingReport socketReceivingReport) {
		socketReceivingReport .save();
	}
	
	public void removeSocketReceivingReport(SocketReceivingReport socketReceivingReport) {
		if(socketReceivingReport != null){
			socketReceivingReport.remove();
		}
	}
	
	public void removeSocketReceivingReports(Set<SocketReceivingReport> socketReceivingReports) {
		for (SocketReceivingReport socketReceivingReport : socketReceivingReports) {
			socketReceivingReport.remove();
		}
	}
	
	public List<SocketReceivingReport> findAllSocketReceivingReport() {
		return SocketReceivingReport.findAll(SocketReceivingReport.class);
	}
	
}

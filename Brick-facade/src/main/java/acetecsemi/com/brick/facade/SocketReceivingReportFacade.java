package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface SocketReceivingReportFacade {

	public InvokeResult getSocketReceivingReport(Long id);
	
	public InvokeResult creatSocketReceivingReport(SocketReceivingReportDTO socketReceivingReport);
	
	public InvokeResult updateSocketReceivingReport(SocketReceivingReportDTO socketReceivingReport);
	
	public InvokeResult removeSocketReceivingReport(Long id);
	
	public InvokeResult removeSocketReceivingReports(Long[] ids);
	
	public List<SocketReceivingReportDTO> findAllSocketReceivingReport();
	
	public Page<SocketReceivingReportDTO> pageQuerySocketReceivingReport(SocketReceivingReportDTO socketReceivingReport, int currentPage, int pageSize);
	
	public SocketDTO findSocketBySocketReceivingReport(Long id);


	
}


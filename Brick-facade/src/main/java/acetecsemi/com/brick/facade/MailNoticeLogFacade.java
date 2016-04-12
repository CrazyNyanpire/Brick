package acetecsemi.com.brick.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import acetecsemi.com.brick.facade.dto.*;

public interface MailNoticeLogFacade {

	public InvokeResult getMailNoticeLog(Long id);
	
	public InvokeResult creatMailNoticeLog(MailNoticeLogDTO mailNoticeLog);
	
	public InvokeResult updateMailNoticeLog(MailNoticeLogDTO mailNoticeLog);
	
	public InvokeResult removeMailNoticeLog(Long id);
	
	public InvokeResult removeMailNoticeLogs(Long[] ids);
	
	public List<MailNoticeLogDTO> findAllMailNoticeLog();
	
	public Page<MailNoticeLogDTO> pageQueryMailNoticeLog(MailNoticeLogDTO mailNoticeLog, int currentPage, int pageSize);
	

}


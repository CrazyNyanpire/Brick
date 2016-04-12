package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.MailNoticeLog;

public interface MailNoticeLogApplication {

	public MailNoticeLog getMailNoticeLog(Long id);
	
	public void creatMailNoticeLog(MailNoticeLog mailNoticeLog);
	
	public void updateMailNoticeLog(MailNoticeLog mailNoticeLog);
	
	public void removeMailNoticeLog(MailNoticeLog mailNoticeLog);
	
	public void removeMailNoticeLogs(Set<MailNoticeLog> mailNoticeLogs);
	
	public List<MailNoticeLog> findAllMailNoticeLog();
	
}


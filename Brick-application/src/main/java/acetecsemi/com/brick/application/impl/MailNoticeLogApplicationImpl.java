package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.MailNoticeLogApplication;
import acetecsemi.com.brick.core.domain.MailNoticeLog;

@Named
@Transactional
public class MailNoticeLogApplicationImpl implements MailNoticeLogApplication {

	public MailNoticeLog getMailNoticeLog(Long id) {
		return MailNoticeLog.get(MailNoticeLog.class, id);
	}
	
	public void creatMailNoticeLog(MailNoticeLog mailNoticeLog) {
		mailNoticeLog.save();
	}
	
	public void updateMailNoticeLog(MailNoticeLog mailNoticeLog) {
		mailNoticeLog .save();
	}
	
	public void removeMailNoticeLog(MailNoticeLog mailNoticeLog) {
		if(mailNoticeLog != null){
			mailNoticeLog.remove();
		}
	}
	
	public void removeMailNoticeLogs(Set<MailNoticeLog> mailNoticeLogs) {
		for (MailNoticeLog mailNoticeLog : mailNoticeLogs) {
			mailNoticeLog.remove();
		}
	}
	
	public List<MailNoticeLog> findAllMailNoticeLog() {
		return MailNoticeLog.findAll(MailNoticeLog.class);
	}
	
}

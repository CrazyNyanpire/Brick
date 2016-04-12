package acetecsemi.com.brick.facade.impl;

import java.util.Arrays;
import java.util.Date;

import javax.inject.Inject;

/**
 * -----------------------------------------
 * @文件: SenderMailFacadeImpl.java
 * @作者: harlow
 * @邮箱: harlow.zhou@acetecsemi.net
 * @时间: 2015-5-19
 * @描述: 发送Email工具类
 * -----------------------------------------
 */

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import acetecsemi.com.brick.application.MailNoticeLogApplication;
import acetecsemi.com.brick.core.domain.MailNoticeLog;
import acetecsemi.com.brick.facade.SenderMailFacade;

public class SenderMailFacadeImpl implements SenderMailFacade{
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	@Inject
	private MailNoticeLogApplication mailNoticeLogApplication;
	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String to) {
		this.sendMail(subject, content, new String[] { to }, null, null);
	}

	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String to, String[] cc) {
		this.sendMail(subject, content, new String[] { to }, cc, null);
	}

	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param cc 抄送人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String[] to,
			String[] cc, String[] bcc) {
		simpleMailMessage.setSubject(subject); // 设置邮件主题
		simpleMailMessage.setTo(to); // 设定收件人
		simpleMailMessage.setCc(cc); // 设定抄送人
		simpleMailMessage.setBcc(bcc); // 设定抄送人
		simpleMailMessage.setText(content); // 设置邮件主题内容
		this.saveSimpleMailMessage(simpleMailMessage);
		mailSender.send(simpleMailMessage); // 发送邮件
	}

	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMailHelper(String subject, String content, String to) {
		this.sendMailHelper(subject, content, new String[] { to }, null, null);
	}

	public void sendMailHelper(String subject, String content, String[] to) {
		this.sendMailHelper(subject, content, to, null, null);
	}

	/**
	 * @方法名: sendMailHelper
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMailHelper(String subject, String content, String to,
			String[] cc) {
		this.sendMailHelper(subject, content, new String[] { to }, cc, null);
	}

	public void sendMailHelper(String subject, String content, String[] to,
			String[] cc) {
		this.sendMailHelper(subject, content, to, cc, null);
	}

	/**
	 * @方法名: sendMailHelper
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param cc 抄送人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMailHelper(String subject, String content, String[] to,
			String[] cc, String[] bcc) {
		JavaMailSender javaMailSender = (JavaMailSender) mailSender;
		MimeMessage mime = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mime, true, "utf-8");
			Date sentDate = new Date();
			helper.setFrom(this.simpleMailMessage.getFrom());
			helper.setSubject(subject); // 设置邮件主题
			simpleMailMessage.setSubject(subject);
			helper.setTo(to); // 设定收件人
			helper.setSentDate(sentDate);
			simpleMailMessage.setSentDate(sentDate);
			simpleMailMessage.setTo(to);
			if (cc != null){
				helper.setCc(cc); // 设定抄送人
				simpleMailMessage.setCc(cc);
			}
			if (bcc != null){
				helper.setBcc(bcc); // 设定抄送人
				simpleMailMessage.setBcc(bcc);
			}
			helper.setText(content); // 设置邮件主题内容
			simpleMailMessage.setText(content);
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		this.saveSimpleMailMessage(simpleMailMessage);
		javaMailSender.send(mime);
	}

	// Spring 依赖注入
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	// Spring 依赖注入
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	/**
	 * 保存邮件信息
	 * @param simpleMailMessage
	 */
	private void saveSimpleMailMessage(SimpleMailMessage simpleMailMessage){
		MailNoticeLog mailNoticeLog = new MailNoticeLog();
		mailNoticeLog.setSubject(simpleMailMessage.getSubject());
		mailNoticeLog.setContent(simpleMailMessage.getText());
		mailNoticeLog.setFromUser(simpleMailMessage.getFrom());
		mailNoticeLog.setToUser(this.changeArrayToString(simpleMailMessage.getTo()));
		mailNoticeLog.setCc(this.changeArrayToString(simpleMailMessage.getCc()));
		mailNoticeLog.setBcc(this.changeArrayToString(simpleMailMessage.getBcc()));
		mailNoticeLog.setCreateTimestamp(simpleMailMessage.getSentDate());
		mailNoticeLog.setLastModifyTimestamp(simpleMailMessage.getSentDate());
		this.mailNoticeLogApplication.creatMailNoticeLog(mailNoticeLog);
	}
	
	private String changeArrayToString(String [] array){
		if(array != null){
			return Arrays.toString(array);
		}
		return null;
	}
}
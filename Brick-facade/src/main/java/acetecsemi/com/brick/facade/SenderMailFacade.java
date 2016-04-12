package acetecsemi.com.brick.facade;

import javax.inject.Inject;

/**
 * -----------------------------------------
 * @文件: SenderMailUtils.java
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

public interface SenderMailFacade {

	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String to) ;
	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String to, String[] cc) ;

	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param cc 抄送人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMail(String subject, String content, String[] to,
			String[] cc, String[] bcc);

	/**
	 * @方法名: sendMail
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMailHelper(String subject, String content, String to) ;

	public void sendMailHelper(String subject, String content, String[] to);

	/**
	 * @方法名: sendMailHelper
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param to 收件人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMailHelper(String subject, String content, String to,
			String[] cc) ;

	public void sendMailHelper(String subject, String content, String[] to,
			String[] cc) ;

	/**
	 * @方法名: sendMailHelper
	 * @参数名：@param subject 邮件主题
	 * @参数名：@param content 邮件主题内容
	 * @参数名：@param to 收件人Email地址
	 * @参数名：@param cc 抄送人Email地址
	 * @描述语: 发送邮件
	 */
	public void sendMailHelper(String subject, String content, String[] to,
			String[] cc, String[] bcc);

}
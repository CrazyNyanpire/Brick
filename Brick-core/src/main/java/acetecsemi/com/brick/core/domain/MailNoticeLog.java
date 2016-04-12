package acetecsemi.com.brick.core.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 05-28-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_MailNoticeLog")
public class MailNoticeLog extends BrickAbstractEntity {
	private static final long serialVersionUID = 5204603319004653689L;
	private String subject;// 主题
	private String content;// 内容
	private String fromUser; //发件人
	private String toUser; //收件人
	private String cc; //抄送
	private String bcc; //暗抄

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

}
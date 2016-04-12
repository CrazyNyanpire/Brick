package acetecsemi.com.brick.facade.dto;

import java.util.Date;

import java.io.Serializable;

public class MailNoticeLogDTO implements Serializable {

	private Long id;

	private int version;

			
		private String content;
		
				
		private String toUser;
		
				
		private String lastModifyEmployNo;
		
				
		private Date createTimestamp;
		
		private Date createTimestampEnd;
				
		private String createEmployNo;
		
				
		private String subject;
		
				
		private String bcc;
		
				
		private Date lastModifyTimestamp;
		
		private Date lastModifyTimestampEnd;
				
		private String fromUser;
		
				
		private String cc;
		
			
	
	public void setContent(String content) { 
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
		
			
	
	public void setToUser(String toUser) { 
		this.toUser = toUser;
	}

	public String getToUser() {
		return this.toUser;
	}
		
			
	
	public void setLastModifyEmployNo(String lastModifyEmployNo) { 
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}
		
			
	
	public void setCreateTimestamp(Date createTimestamp) { 
		this.createTimestamp = createTimestamp;
	}

	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}
		
		public void setCreateTimestampEnd(Date createTimestampEnd) { 
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}
			
	
	public void setCreateEmployNo(String createEmployNo) { 
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}
		
			
	
	public void setSubject(String subject) { 
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}
		
			
	
	public void setBcc(String bcc) { 
		this.bcc = bcc;
	}

	public String getBcc() {
		return this.bcc;
	}
		
			
	
	public void setLastModifyTimestamp(Date lastModifyTimestamp) { 
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	public Date getLastModifyTimestamp() {
		return this.lastModifyTimestamp;
	}
		
		public void setLastModifyTimestampEnd(Date lastModifyTimestampEnd) { 
		this.lastModifyTimestampEnd = lastModifyTimestampEnd;
	}

	public Date getLastModifyTimestampEnd() {
		return this.lastModifyTimestampEnd;
	}
			
	
	public void setFromUser(String fromUser) { 
		this.fromUser = fromUser;
	}

	public String getFromUser() {
		return this.fromUser;
	}
		
			
	
	public void setCc(String cc) { 
		this.cc = cc;
	}

	public String getCc() {
		return this.cc;
	}
		
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailNoticeLogDTO other = (MailNoticeLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
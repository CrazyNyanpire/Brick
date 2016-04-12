package acetecsemi.com.brick.facade.dto;

import java.util.Date;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private Long id;

	private int version;

			
		private String telePhone;
		
				
		private String email;
		
				
		private String createOwner;
		
				
		private String description;
		
				
		private String name;
		
				
		private String userAccount;
		
				
		private Date createDate;
		
		private Date createDateEnd;
				
		private String password;
		
									
		private Boolean disabled;
		
				
		private String salt;
		
				
		private Date lastModifyTime;
		
		private Date lastModifyTimeEnd;
			
	
	public void setTelePhone(String telePhone) { 
		this.telePhone = telePhone;
	}

	public String getTelePhone() {
		return this.telePhone;
	}
		
			
	
	public void setEmail(String email) { 
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
		
			
	
	public void setCreateOwner(String createOwner) { 
		this.createOwner = createOwner;
	}

	public String getCreateOwner() {
		return this.createOwner;
	}
		
			
	
	public void setDescription(String description) { 
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
		
			
	
	public void setName(String name) { 
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
		
			
	
	public void setUserAccount(String userAccount) { 
		this.userAccount = userAccount;
	}

	public String getUserAccount() {
		return this.userAccount;
	}
		
			
	
	public void setCreateDate(Date createDate) { 
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}
		
		public void setCreateDateEnd(Date createDateEnd) { 
		this.createDateEnd = createDateEnd;
	}

	public Date getCreateDateEnd() {
		return this.createDateEnd;
	}
			
	
	public void setPassword(String password) { 
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
		
								
	
	public void setDisabled(Boolean disabled) { 
		this.disabled = disabled;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}
		
			
	
	public void setSalt(String salt) { 
		this.salt = salt;
	}

	public String getSalt() {
		return this.salt;
	}
		
			
	
	public void setLastModifyTime(Date lastModifyTime) { 
		this.lastModifyTime = lastModifyTime;
	}

	public Date getLastModifyTime() {
		return this.lastModifyTime;
	}
		
		public void setLastModifyTimeEnd(Date lastModifyTimeEnd) { 
		this.lastModifyTimeEnd = lastModifyTimeEnd;
	}

	public Date getLastModifyTimeEnd() {
		return this.lastModifyTimeEnd;
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
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
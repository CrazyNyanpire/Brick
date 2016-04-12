package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;

public class NormalPartOptionLogDTO implements Serializable {

	private Long id;

	private int version;

			
		private String lastModifyEmployNo;
		
				
		private Date createTimestamp;
		
		private Date createTimestampEnd;
				
		private Date optDate;
		
		private Date optDateEnd;
				
		private String optUser;
		
				
		private String createEmployNo;
		
				
		private String remark;
		
		private String path;
		
		private String status;
		
		private String partName;
		
		private Date lastModifyTimestamp;
		
		private Date lastModifyTimestampEnd;
				
		private Integer logic;
		
		private Long partId;
		
		private NormalPartDTO normalPartDTO;
		
			
	
	public Long getPartId() {
			return partId;
		}

	public void setPartId(Long partId) {
			this.partId = partId;
		}

	public NormalPartDTO getNormalPartDTO() {
			return normalPartDTO;
		}

		public void setNormalPartDTO(NormalPartDTO normalPartDTO) {
			this.normalPartDTO = normalPartDTO;
		}

	public void setLastModifyEmployNo(String lastModifyEmployNo) { 
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	@JsonSerialize(using = JsonTimestampSerializer.class)
	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}
		
			
	
	public void setCreateTimestamp(Date createTimestamp) { 
		this.createTimestamp = createTimestamp;
	}

	@JsonSerialize(using = JsonTimestampSerializer.class)
	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}
		
		public void setCreateTimestampEnd(Date createTimestampEnd) { 
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}
			
	
	public void setOptDate(Date optDate) { 
		this.optDate = optDate;
	}

	public Date getOptDate() {
		return this.optDate;
	}
		
		public void setOptDateEnd(Date optDateEnd) { 
		this.optDateEnd = optDateEnd;
	}

	public Date getOptDateEnd() {
		return this.optDateEnd;
	}
			
	
	public void setOptUser(String optUser) { 
		this.optUser = optUser;
	}

	public String getOptUser() {
		return this.optUser;
	}
		
			
	
	public void setCreateEmployNo(String createEmployNo) { 
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}
		
			
	
	public void setRemark(String remark) { 
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}
		
			
	
	public void setStatus(String status) { 
		this.status = status;
	}

	public String getStatus() {
		return this.status;
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
			
	
	public void setLogic(Integer logic) { 
		this.logic = logic;
	}

	public Integer getLogic() {
		return this.logic;
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
		NormalPartOptionLogDTO other = (NormalPartOptionLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
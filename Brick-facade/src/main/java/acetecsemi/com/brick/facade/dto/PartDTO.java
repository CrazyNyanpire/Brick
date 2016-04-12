package acetecsemi.com.brick.facade.dto;

import java.util.Date;



import java.io.Serializable;

public class PartDTO implements Serializable {

	private Long id;

	private int version;

			
		private String equipmentList;
		
				
		private String partType;
		
				
		private String partNo;
		
				
		private String remark;
		
				
		private String partName;
		
				
		private Date inDate;
		
		private Date inDateEnd;
				
		private Date lastModifyTimestamp;
		
		private Date lastModifyTimestampEnd;
				
		private String partModel;
		
				
		private String lastModifyEmployNo;
		
				
		private Date createTimestamp;
		
		private Date createTimestampEnd;
				
		private String category;
		
				
		private String createEmployNo;
		
				
		private String ownership;
		

		
				
		private String partLocaltion;
		
			
	
	public void setEquipmentList(String equipmentList) { 
		this.equipmentList = equipmentList;
	}

	public String getEquipmentList() {
		return this.equipmentList;
	}
		
			
	
	public void setPartType(String partType) { 
		this.partType = partType;
	}

	public String getPartType() {
		return this.partType;
	}
		
			
	
	public void setPartNo(String partNo) { 
		this.partNo = partNo;
	}

	public String getPartNo() {
		return this.partNo;
	}
		
			
	
	public void setRemark(String remark) { 
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}
		
			
	
	public void setPartName(String partName) { 
		this.partName = partName;
	}

	public String getPartName() {
		return this.partName;
	}
		
			
	
	public void setInDate(Date inDate) { 
		this.inDate = inDate;
	}

	public Date getInDate() {
		return this.inDate;
	}
		
		public void setInDateEnd(Date inDateEnd) { 
		this.inDateEnd = inDateEnd;
	}

	public Date getInDateEnd() {
		return this.inDateEnd;
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
			
	
	public void setPartModel(String partModel) { 
		this.partModel = partModel;
	}

	public String getPartModel() {
		return this.partModel;
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
			
	
	public void setCategory(String category) { 
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}
		
			
	
	public void setCreateEmployNo(String createEmployNo) { 
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}
		
			
	
	public void setOwnership(String ownership) { 
		this.ownership = ownership;
	}

	public String getOwnership() {
		return this.ownership;
	}
		
			
	

			
	
	public void setPartLocaltion(String partLocaltion) { 
		this.partLocaltion = partLocaltion;
	}

	public String getPartLocaltion() {
		return this.partLocaltion;
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
		PartDTO other = (PartDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
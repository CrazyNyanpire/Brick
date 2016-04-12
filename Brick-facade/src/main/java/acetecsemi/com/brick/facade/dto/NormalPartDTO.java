package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;

public class NormalPartDTO implements Serializable {

	private Long id;

	private int version;

			
		private String partConfig;
		
				
		private String partType;
		
				
		private String location;
		
				
		private String remark;
		
				
		private String status;
		
				
		private String propertyNumber;
		
		private String pn;
		
		private Date inDate;
		
		private Date inDateEnd;
				
		private String partName;
		
				
		private String partRevision;
		
				
		private String serialNumber;
		
				
		private String equipment;
		
				
		private Date lastModifyTimestamp;
		
		private Date lastModifyTimestampEnd;
				
		private String type;
		
				
		private Integer logic;
		
				
		private String warrantyPeriod;
		
				
		private String lastModifyEmployNo;
		
				
		private Date createTimestamp;
		
		private Date createTimestampEnd;
				
		private String createEmployNo;
		
				
		private String manufacturer;
		
				
		private String quantity;
		
				
		private String slotSite;
		
			
	
	public void setPartConfig(String partConfig) { 
		this.partConfig = partConfig;
	}

	public String getPartConfig() {
		return this.partConfig;
	}
		
			
	
	public void setPartType(String partType) { 
		this.partType = partType;
	}

	public String getPartType() {
		return this.partType;
	}
		
			
	
	public void setLocation(String location) { 
		this.location = location;
	}

	public String getLocation() {
		return this.location;
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
		
			
	
	public void setPropertyNumber(String propertyNumber) { 
		this.propertyNumber = propertyNumber;
	}

	public String getPropertyNumber() {
		return this.propertyNumber;
	}
		
			
	
	public void setInDate(Date inDate) { 
		this.inDate = inDate;
	}
	
	@JsonSerialize(using = JsonTimestampSerializer.class)
	public Date getInDate() {
		return this.inDate;
	}
		
		public void setInDateEnd(Date inDateEnd) { 
		this.inDateEnd = inDateEnd;
	}

	public Date getInDateEnd() {
		return this.inDateEnd;
	}
			
	
	public void setPartName(String partName) { 
		this.partName = partName;
	}

	public String getPartName() {
		return this.partName;
	}
		
			
	
	public void setPartRevision(String partRevision) { 
		this.partRevision = partRevision;
	}

	public String getPartRevision() {
		return this.partRevision;
	}
		
			
	
	public void setSerialNumber(String serialNumber) { 
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}
		
			
	
	public void setEquipment(String equipment) { 
		this.equipment = equipment;
	}

	public String getEquipment() {
		return this.equipment;
	}
		
			
	
	public void setLastModifyTimestamp(Date lastModifyTimestamp) { 
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	@JsonSerialize(using = JsonTimestampSerializer.class)
	public Date getLastModifyTimestamp() {
		return this.lastModifyTimestamp;
	}
		
		public void setLastModifyTimestampEnd(Date lastModifyTimestampEnd) { 
		this.lastModifyTimestampEnd = lastModifyTimestampEnd;
	}

	public Date getLastModifyTimestampEnd() {
		return this.lastModifyTimestampEnd;
	}
			
	
	public void setType(String type) { 
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
		
			
	
	public void setLogic(Integer logic) { 
		this.logic = logic;
	}

	public Integer getLogic() {
		return this.logic;
	}
		
			
	
	public void setWarrantyPeriod(String warrantyPeriod) { 
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getWarrantyPeriod() {
		return this.warrantyPeriod;
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
		
			
	
	public void setManufacturer(String manufacturer) { 
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}
		
			
	
	public void setQuantity(String quantity) { 
		this.quantity = quantity;
	}

	public String getQuantity() {
		return this.quantity;
	}
		
			
	
	public void setSlotSite(String slotSite) { 
		this.slotSite = slotSite;
	}

	public String getSlotSite() {
		return this.slotSite;
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
		NormalPartDTO other = (NormalPartDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}
}
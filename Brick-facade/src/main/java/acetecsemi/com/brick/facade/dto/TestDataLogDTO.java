package acetecsemi.com.brick.facade.dto;

import java.util.Date;

import java.io.Serializable;

public class TestDataLogDTO implements Serializable {

	private Long id;

	private int version;

			
		private String lastModifyEmployNo;
		
				
		private Date createTimestamp;
		
		private Date createTimestampEnd;
				
		private String createEmployNo;
		
				
		private String equipmentNo;
		
				
		private String acetecLot;
		
				
		private String remark;
		
				
		private String productModel;
		
				
		private String customerNo;
		
				
		private Date lastModifyTimestamp;
		
		private Date lastModifyTimestampEnd;
				
		private Integer logic;
		
				
		private String ip;
		
			
	
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
		
			
	
	public void setEquipmentNo(String equipmentNo) { 
		this.equipmentNo = equipmentNo;
	}

	public String getEquipmentNo() {
		return this.equipmentNo;
	}
		
			
	
	public void setAcetecLot(String acetecLot) { 
		this.acetecLot = acetecLot;
	}

	public String getAcetecLot() {
		return this.acetecLot;
	}
		
			
	
	public void setRemark(String remark) { 
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}
		
			
	
	public void setProductModel(String productModel) { 
		this.productModel = productModel;
	}

	public String getProductModel() {
		return this.productModel;
	}
		
			
	
	public void setCustomerNo(String customerNo) { 
		this.customerNo = customerNo;
	}

	public String getCustomerNo() {
		return this.customerNo;
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
		
			
	
	public void setIp(String ip) { 
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
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
		TestDataLogDTO other = (TestDataLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
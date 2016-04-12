package acetecsemi.com.brick.facade.dto;

import java.util.Date;

import java.io.Serializable;

public class EquipmentMaintenanceLogDTO implements Serializable {

	private Long id;

	private int version;

	private String lastModifyEmployNo;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String nextMaintenancePlanDate;

	private String realEndDate;

	private String pmType;

	private String createEmployNo;

	private String remark;

	private String planStartDate;

	private String nowMaintenancePlanDate;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String realStartDate;

	private String responsible;

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

	public void setNextMaintenancePlanDate(String nextMaintenancePlanDate) {
		this.nextMaintenancePlanDate = nextMaintenancePlanDate;
	}

	public String getNextMaintenancePlanDate() {
		return this.nextMaintenancePlanDate;
	}

	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}

	public String getRealEndDate() {
		return this.realEndDate;
	}

	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	public String getPmType() {
		return this.pmType;
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

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanStartDate() {
		return this.planStartDate;
	}

	public void setNowMaintenancePlanDate(String nowMaintenancePlanDate) {
		this.nowMaintenancePlanDate = nowMaintenancePlanDate;
	}

	public String getNowMaintenancePlanDate() {
		return this.nowMaintenancePlanDate;
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

	public void setRealStartDate(String realStartDate) {
		this.realStartDate = realStartDate;
	}

	public String getRealStartDate() {
		return this.realStartDate;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
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
		EquipmentMaintenanceLogDTO other = (EquipmentMaintenanceLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * @author hallow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_BorrowMachine")
 public class BorrowMachine extends BrickAbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8947604784666517937L;

	private String state;// 状态
	private String proposer;// 申请人
	private String department;// 部门
	private String type;// 类型
	private Date appTime;// 申请时间
	private String equipName;// 设备名称
	private Date estimatedStartTime;// 预计开始时间
	private Date estimatedEndTime;// 预计结束时间
	private String estimatedTime;// 预计需时
	private String borrowNumber;// 借机单号
	private Date actualBeginTime;// 实际开始时间
	private Date actualEndTime;// 实际结束时间
	private String actualTime;// 实际需时
	private String approver;// 审批人
	private String company;// 借用单位
	private String remark;// 备注
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PLATFORM_ID", referencedColumnName = "ID")
	private Platform platform;// 平台
	
	private Boolean isPlatform;// 是否是平台
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "ID")
	private Equipment equipment;// 平台
	
	private String PlatformEquipId;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getAppTime() {
		return appTime;
	}

	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public Date getEstimatedStartTime() {
		return estimatedStartTime;
	}

	public void setEstimatedStartTime(Date estimatedStartTime) {
		this.estimatedStartTime = estimatedStartTime;
	}

	public Date getEstimatedEndTime() {
		return estimatedEndTime;
	}

	public void setEstimatedEndTime(Date estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public String getBorrowNumber() {
		return borrowNumber;
	}

	public void setBorrowNumber(String borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public Date getActualBeginTime() {
		return actualBeginTime;
	}

	public void setActualBeginTime(Date actualBeginTime) {
		this.actualBeginTime = actualBeginTime;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public String getActualTime() {
		return actualTime;
	}

	public void setActualTime(String actualTime) {
		this.actualTime = actualTime;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Boolean getIsPlatform() {
		return isPlatform;
	}

	public void setIsPlatform(Boolean isPlatform) {
		this.isPlatform = isPlatform;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getPlatformEquipId() {
		return PlatformEquipId;
	}

	public void setPlatformEquipId(String platformEquipId) {
		PlatformEquipId = platformEquipId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((actualBeginTime == null) ? 0 : actualBeginTime.hashCode());
		result = prime * result
				+ ((actualEndTime == null) ? 0 : actualEndTime.hashCode());
		result = prime * result
				+ ((actualTime == null) ? 0 : actualTime.hashCode());
		result = prime * result + ((appTime == null) ? 0 : appTime.hashCode());
		result = prime * result
				+ ((approver == null) ? 0 : approver.hashCode());
		result = prime * result
				+ ((borrowNumber == null) ? 0 : borrowNumber.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((equipName == null) ? 0 : equipName.hashCode());
		result = prime
				* result
				+ ((estimatedEndTime == null) ? 0 : estimatedEndTime.hashCode());
		result = prime
				* result
				+ ((estimatedStartTime == null) ? 0 : estimatedStartTime
						.hashCode());
		result = prime * result
				+ ((estimatedTime == null) ? 0 : estimatedTime.hashCode());
		result = prime * result
				+ ((proposer == null) ? 0 : proposer.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowMachine other = (BorrowMachine) obj;
		if (actualBeginTime == null) {
			if (other.actualBeginTime != null)
				return false;
		} else if (!actualBeginTime.equals(other.actualBeginTime))
			return false;
		if (actualEndTime == null) {
			if (other.actualEndTime != null)
				return false;
		} else if (!actualEndTime.equals(other.actualEndTime))
			return false;
		if (actualTime == null) {
			if (other.actualTime != null)
				return false;
		} else if (!actualTime.equals(other.actualTime))
			return false;
		if (appTime == null) {
			if (other.appTime != null)
				return false;
		} else if (!appTime.equals(other.appTime))
			return false;
		if (approver == null) {
			if (other.approver != null)
				return false;
		} else if (!approver.equals(other.approver))
			return false;
		if (borrowNumber == null) {
			if (other.borrowNumber != null)
				return false;
		} else if (!borrowNumber.equals(other.borrowNumber))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (equipName == null) {
			if (other.equipName != null)
				return false;
		} else if (!equipName.equals(other.equipName))
			return false;
		if (estimatedEndTime == null) {
			if (other.estimatedEndTime != null)
				return false;
		} else if (!estimatedEndTime.equals(other.estimatedEndTime))
			return false;
		if (estimatedStartTime == null) {
			if (other.estimatedStartTime != null)
				return false;
		} else if (!estimatedStartTime.equals(other.estimatedStartTime))
			return false;
		if (estimatedTime == null) {
			if (other.estimatedTime != null)
				return false;
		} else if (!estimatedTime.equals(other.estimatedTime))
			return false;
		if (proposer == null) {
			if (other.proposer != null)
				return false;
		} else if (!proposer.equals(other.proposer))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BorrowMachine [state=" + state + ", proposer=" + proposer
				+ ", department=" + department + ", type=" + type
				+ ", appTime=" + appTime + ", equipName=" + equipName
				+ ", estimatedStartTime=" + estimatedStartTime
				+ ", estimatedEndTime=" + estimatedEndTime + ", estimatedTime="
				+ estimatedTime + ", borrowNumber=" + borrowNumber
				+ ", actualBeginTime=" + actualBeginTime + ", actualEndTime="
				+ actualEndTime + ", actualTime=" + actualTime + ", approver="
				+ approver + ", company=" + company + ", remark=" + remark
				+ "]";
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),this.getCreateTimestamp().toString()};
	}

}
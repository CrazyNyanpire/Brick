package acetecsemi.com.brick.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRICK_EquipmentMaintenanceLog")
public class EquipmentMaintenancePlan extends BrickAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4075835982856505008L;

	private String planStartDate;//计划保养日期

	private String realStartDate;//实际保养日期

	private String realEndDate;//实际结束保养日期

	private String remark;//备注

	private String pmType;//保养类型

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "ID")
	private Equipment equipment;// 平台

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(String realStartDate) {
		this.realStartDate = realStartDate;
	}

	public String getRealEndDate() {
		return realEndDate;
	}

	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getPmType() {
		return pmType;
	}

	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result
				+ ((planStartDate == null) ? 0 : planStartDate.hashCode());
		result = prime * result + ((pmType == null) ? 0 : pmType.hashCode());
		result = prime * result
				+ ((realEndDate == null) ? 0 : realEndDate.hashCode());
		result = prime * result
				+ ((realStartDate == null) ? 0 : realStartDate.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		EquipmentMaintenancePlan other = (EquipmentMaintenancePlan) obj;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (planStartDate == null) {
			if (other.planStartDate != null)
				return false;
		} else if (!planStartDate.equals(other.planStartDate))
			return false;
		if (pmType == null) {
			if (other.pmType != null)
				return false;
		} else if (!pmType.equals(other.pmType))
			return false;
		if (realEndDate == null) {
			if (other.realEndDate != null)
				return false;
		} else if (!realEndDate.equals(other.realEndDate))
			return false;
		if (realStartDate == null) {
			if (other.realStartDate != null)
				return false;
		} else if (!realStartDate.equals(other.realStartDate))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

}

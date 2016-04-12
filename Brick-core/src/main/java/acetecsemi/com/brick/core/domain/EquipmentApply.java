package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BRICK_EQUIPMENTAPPLY")
public class EquipmentApply extends Apply{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4024252905146586307L;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "ID")
	private Equipment equipment ; //设备编号
	
	private Date planStartTime; //预计起始时间
	
	private Date planEndTime; //预计结束时间
	
	private String planTime; //预计用时
	
	private String type; //借机类型
	
	private String borrowSource; //借机对象

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBorrowSource() {
		return borrowSource;
	}

	public void setBorrowSource(String borrowSource) {
		this.borrowSource = borrowSource;
	}
}

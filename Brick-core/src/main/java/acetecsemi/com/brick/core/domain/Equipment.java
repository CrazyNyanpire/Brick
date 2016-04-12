package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openkoala.security.core.domain.User;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="BRICK_EQUIPMENT")
//@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public class Equipment extends BrickAbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3611010257435238047L;
	/**
	 * 类别
	 */
	//@Column(name = "CATEGORY", insertable = false, updatable = false)
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_ID", referencedColumnName = "ID")
	private Category category;//设备型号
	private String equipmentNo;//设备编号
	private String equipmentName;//设备名称
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "equipmentCategory_ID", referencedColumnName = "ID")
	private Category equipmentCategory;//设备类别
	private String responsible;//责任人
	private String agent;//代理人
	private Date maintenanceStartDate;//保养起始时间
	private String repairCycle;//维护周期
	private String repairCycleWeek;
	private String repairCycleMonth;
	private String repairCycleSeason;
	private String repairCycleYear;
	private Date nextMaintenanceDate;
	private String calibrationCycle;//校准周期
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "equipmentLocation_ID", referencedColumnName = "ID")
	private Category equipmentLocation;//设备位置
	private Date checkInTime;//登记时间
	private String acceptanceList;//验收单
	private String status;//设备状态
	private String subStatus;// 子状态
	private Boolean composability;//是否可组装
	//private Set<Part> parts;// 备件
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "platform_ID", referencedColumnName = "ID")
	private Platform platform;
	
	private String productModel;
	
	private String nowLot;
	
	private String nowMaintenancePlanDate;//YYYY:MM:DD-月|YYYY:MM:DD-季|YYYY:MM:DD-年
	
	private String nextMaintenancePlanDate;//YYYY:MM:DD-月|YYYY:MM:DD-季|YYYY:MM:DD-年
	
	private String sn;
	
	private String ip;
	
	private Boolean isAuto;//是否自动抓取数据
	
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public Category getEquipmentCategory() {
		return equipmentCategory;
	}
	public void setEquipmentCategory(Category equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}
//	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
//	@JoinColumn(name = "RESPONSIBLE_ID", referencedColumnName = "ID")
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
//	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
//	@JoinColumn(name = "AGENT_ID", referencedColumnName = "ID")
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public Date getMaintenanceStartDate() {
		return maintenanceStartDate;
	}
	public void setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate = maintenanceStartDate;
	}
	public String getRepairCycle() {
		return repairCycle;
	}
	public void setRepairCycle(String repairCycle) {
		this.repairCycle = repairCycle;
	}
	public String getRepairCycleWeek() {
		return repairCycleWeek;
	}
	public void setRepairCycleWeek(String repairCycleWeek) {
		this.repairCycleWeek = repairCycleWeek;
	}
	public String getRepairCycleMonth() {
		return repairCycleMonth;
	}
	public void setRepairCycleMonth(String repairCycleMonth) {
		this.repairCycleMonth = repairCycleMonth;
	}
	public String getRepairCycleSeason() {
		return repairCycleSeason;
	}
	public void setRepairCycleSeason(String repairCycleSeason) {
		this.repairCycleSeason = repairCycleSeason;
	}
	public String getRepairCycleYear() {
		return repairCycleYear;
	}
	public void setRepairCycleYear(String repairCycleYear) {
		this.repairCycleYear = repairCycleYear;
	}
	public Date getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}
	public void setNextMaintenanceDate(Date nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
	}
	public String getCalibrationCycle() {
		return calibrationCycle;
	}
	public void setCalibrationCycle(String calibrationCycle) {
		this.calibrationCycle = calibrationCycle;
	}
	public Category getEquipmentLocation() {
		return equipmentLocation;
	}
	public void setEquipmentLocation(Category equipmentLocation) {
		this.equipmentLocation = equipmentLocation;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getAcceptanceList() {
		return acceptanceList;
	}
	public void setAcceptanceList(String acceptanceList) {
		this.acceptanceList = acceptanceList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Set<Part> getParts() {
//		return parts;
//	}
//	public void setParts(Set<Part> parts) {
//		this.parts = parts;
//	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Boolean getComposability() {
		return composability;
	}
	public void setComposability(Boolean composability) {
		this.composability = composability;
	}
	
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getNowLot() {
		return nowLot;
	}
	public void setNowLot(String nowLot) {
		this.nowLot = nowLot;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	public String getNowMaintenancePlanDate() {
		return nowMaintenancePlanDate;
	}
	public void setNowMaintenancePlanDate(String nowMaintenancePlanDate) {
		this.nowMaintenancePlanDate = nowMaintenancePlanDate;
	}
	public String getNextMaintenancePlanDate() {
		return nextMaintenancePlanDate;
	}
	public void setNextMaintenancePlanDate(String nextMaintenancePlanDate) {
		this.nextMaintenancePlanDate = nextMaintenancePlanDate;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Boolean getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(Boolean isAuto) {
		this.isAuto = isAuto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((acceptanceList == null) ? 0 : acceptanceList.hashCode());
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		result = prime
				* result
				+ ((calibrationCycle == null) ? 0 : calibrationCycle.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result
				+ ((composability == null) ? 0 : composability.hashCode());
		result = prime
				* result
				+ ((equipmentCategory == null) ? 0 : equipmentCategory
						.hashCode());
		result = prime
				* result
				+ ((equipmentLocation == null) ? 0 : equipmentLocation
						.hashCode());
		result = prime * result
				+ ((equipmentName == null) ? 0 : equipmentName.hashCode());
		result = prime * result
				+ ((equipmentNo == null) ? 0 : equipmentNo.hashCode());
		result = prime
				* result
				+ ((maintenanceStartDate == null) ? 0 : maintenanceStartDate
						.hashCode());
		result = prime * result
				+ ((platform == null) ? 0 : platform.hashCode());
		result = prime * result
				+ ((repairCycle == null) ? 0 : repairCycle.hashCode());
		result = prime * result
				+ ((responsible == null) ? 0 : responsible.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Equipment other = (Equipment) obj;
		if (acceptanceList == null) {
			if (other.acceptanceList != null)
				return false;
		} else if (!acceptanceList.equals(other.acceptanceList))
			return false;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (calibrationCycle == null) {
			if (other.calibrationCycle != null)
				return false;
		} else if (!calibrationCycle.equals(other.calibrationCycle))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (composability == null) {
			if (other.composability != null)
				return false;
		} else if (!composability.equals(other.composability))
			return false;
		if (equipmentCategory == null) {
			if (other.equipmentCategory != null)
				return false;
		} else if (!equipmentCategory.equals(other.equipmentCategory))
			return false;
		if (equipmentLocation == null) {
			if (other.equipmentLocation != null)
				return false;
		} else if (!equipmentLocation.equals(other.equipmentLocation))
			return false;
		if (equipmentName == null) {
			if (other.equipmentName != null)
				return false;
		} else if (!equipmentName.equals(other.equipmentName))
			return false;
		if (equipmentNo == null) {
			if (other.equipmentNo != null)
				return false;
		} else if (!equipmentNo.equals(other.equipmentNo))
			return false;
		if (maintenanceStartDate == null) {
			if (other.maintenanceStartDate != null)
				return false;
		} else if (!maintenanceStartDate.equals(other.maintenanceStartDate))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		if (repairCycle == null) {
			if (other.repairCycle != null)
				return false;
		} else if (!repairCycle.equals(other.repairCycle))
			return false;
		if (responsible == null) {
			if (other.responsible != null)
				return false;
		} else if (!responsible.equals(other.responsible))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),this.getLastModifyTimestamp().toString()};
	}

}
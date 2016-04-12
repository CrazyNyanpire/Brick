package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_PORBECARDOPTIONLOG")
public class ProbeCardOptionLog extends OptionLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1376428644368634706L;
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PROBECARD_ID", referencedColumnName = "ID")
	private ProbeCard probeCard;
	private Date endDate;
	private String statusTime;
	private String maintenancePerson;
	private String maintenanceItems;
	private String dutNumber;
	private String binNo;
	private String platforms;
	private String platform;
	private String platformNo; //嫁动机台
	private String productModel;
	private String productLot;
	private String productNowModel;
	private String probeCardApplyPerson;
	private String customerName;
	private Long touchTime;
	private String returnPerson;
	private String returnLevel;
	private String needlePositionLevel;
	private String appearanceLevel;
	private String xyNeedlePosition;// X，Y针位
	private String tipMaximumDiameter; // 针尖最大直径
	private String tipMinimumDiameter; // 针尖最小直径
	private String tipShortest;// 针尖最短长度
	private String tipLongest;// 针尖最长长度
	private Date startTime;
	private Date endTime;
	private Long touchTimeTotal;
	
	private String equipmentCategory;
	private String platformStatus;

	public ProbeCard getProbeCard() {
		return probeCard;
	}

	public void setProbeCard(ProbeCard probeCard) {
		this.probeCard = probeCard;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}

	public String getMaintenancePerson() {
		return maintenancePerson;
	}

	public void setMaintenancePerson(String maintenancePerson) {
		this.maintenancePerson = maintenancePerson;
	}

	public String getMaintenanceItems() {
		return maintenanceItems;
	}

	public void setMaintenanceItems(String maintenanceItems) {
		this.maintenanceItems = maintenanceItems;
	}

	public String getDutNumber() {
		return dutNumber;
	}

	public void setDutNumber(String dutNumber) {
		this.dutNumber = dutNumber;
	}

	public String getBinNo() {
		return binNo;
	}

	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductLot() {
		return productLot;
	}

	public void setProductLot(String productLot) {
		this.productLot = productLot;
	}

	public String getProductNowModel() {
		return productNowModel;
	}

	public void setProductNowModel(String productNowModel) {
		this.productNowModel = productNowModel;
	}

	public String getProbeCardApplyPerson() {
		return probeCardApplyPerson;
	}

	public void setProbeCardApplyPerson(String probeCardApplyPerson) {
		this.probeCardApplyPerson = probeCardApplyPerson;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getTouchTime() {
		return touchTime;
	}

	public void setTouchTime(Long touchTime) {
		this.touchTime = touchTime;
	}

	public String getReturnPerson() {
		return returnPerson;
	}

	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}

	public String getReturnLevel() {
		return returnLevel;
	}

	public void setReturnLevel(String returnLevel) {
		this.returnLevel = returnLevel;
	}

	public String getNeedlePositionLevel() {
		return needlePositionLevel;
	}

	public void setNeedlePositionLevel(String needlePositionLevel) {
		this.needlePositionLevel = needlePositionLevel;
	}

	public String getAppearanceLevel() {
		return appearanceLevel;
	}

	public void setAppearanceLevel(String appearanceLevel) {
		this.appearanceLevel = appearanceLevel;
	}

	public String getXyNeedlePosition() {
		return xyNeedlePosition;
	}

	public void setXyNeedlePosition(String xyNeedlePosition) {
		this.xyNeedlePosition = xyNeedlePosition;
	}

	public String getTipMaximumDiameter() {
		return tipMaximumDiameter;
	}

	public void setTipMaximumDiameter(String tipMaximumDiameter) {
		this.tipMaximumDiameter = tipMaximumDiameter;
	}

	public String getTipMinimumDiameter() {
		return tipMinimumDiameter;
	}

	public void setTipMinimumDiameter(String tipMinimumDiameter) {
		this.tipMinimumDiameter = tipMinimumDiameter;
	}

	public String getTipShortest() {
		return tipShortest;
	}

	public void setTipShortest(String tipShortest) {
		this.tipShortest = tipShortest;
	}

	public String getTipLongest() {
		return tipLongest;
	}

	public void setTipLongest(String tipLongest) {
		this.tipLongest = tipLongest;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getTouchTimeTotal() {
		return touchTimeTotal;
	}

	public void setTouchTimeTotal(Long touchTimeTotal) {
		this.touchTimeTotal = touchTimeTotal;
	}

	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public String getPlatformNo() {
		return platformNo;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((appearanceLevel == null) ? 0 : appearanceLevel.hashCode());
		result = prime * result + ((binNo == null) ? 0 : binNo.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((dutNumber == null) ? 0 : dutNumber.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime
				* result
				+ ((maintenanceItems == null) ? 0 : maintenanceItems.hashCode());
		result = prime
				* result
				+ ((maintenancePerson == null) ? 0 : maintenancePerson
						.hashCode());
		result = prime
				* result
				+ ((needlePositionLevel == null) ? 0 : needlePositionLevel
						.hashCode());
		result = prime * result
				+ ((platform == null) ? 0 : platform.hashCode());
		result = prime * result
				+ ((platforms == null) ? 0 : platforms.hashCode());
		result = prime * result
				+ ((probeCard == null) ? 0 : probeCard.hashCode());
		result = prime
				* result
				+ ((probeCardApplyPerson == null) ? 0 : probeCardApplyPerson
						.hashCode());
		result = prime * result
				+ ((productLot == null) ? 0 : productLot.hashCode());
		result = prime * result
				+ ((productModel == null) ? 0 : productModel.hashCode());
		result = prime * result
				+ ((productNowModel == null) ? 0 : productNowModel.hashCode());
		result = prime * result
				+ ((returnLevel == null) ? 0 : returnLevel.hashCode());
		result = prime * result
				+ ((returnPerson == null) ? 0 : returnPerson.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((statusTime == null) ? 0 : statusTime.hashCode());
		result = prime
				* result
				+ ((tipMaximumDiameter == null) ? 0 : tipMaximumDiameter
						.hashCode());
		result = prime
				* result
				+ ((tipMinimumDiameter == null) ? 0 : tipMinimumDiameter
						.hashCode());
		result = prime * result
				+ ((tipShortest == null) ? 0 : tipShortest.hashCode());
		result = prime * result
				+ ((touchTime == null) ? 0 : touchTime.hashCode());
		result = prime
				* result
				+ ((xyNeedlePosition == null) ? 0 : xyNeedlePosition.hashCode());
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
		ProbeCardOptionLog other = (ProbeCardOptionLog) obj;
		if (appearanceLevel == null) {
			if (other.appearanceLevel != null)
				return false;
		} else if (!appearanceLevel.equals(other.appearanceLevel))
			return false;
		if (binNo == null) {
			if (other.binNo != null)
				return false;
		} else if (!binNo.equals(other.binNo))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (dutNumber == null) {
			if (other.dutNumber != null)
				return false;
		} else if (!dutNumber.equals(other.dutNumber))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (maintenanceItems == null) {
			if (other.maintenanceItems != null)
				return false;
		} else if (!maintenanceItems.equals(other.maintenanceItems))
			return false;
		if (maintenancePerson == null) {
			if (other.maintenancePerson != null)
				return false;
		} else if (!maintenancePerson.equals(other.maintenancePerson))
			return false;
		if (needlePositionLevel == null) {
			if (other.needlePositionLevel != null)
				return false;
		} else if (!needlePositionLevel.equals(other.needlePositionLevel))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		if (platforms == null) {
			if (other.platforms != null)
				return false;
		} else if (!platforms.equals(other.platforms))
			return false;
		if (probeCard == null) {
			if (other.probeCard != null)
				return false;
		} else if (!probeCard.equals(other.probeCard))
			return false;
		if (probeCardApplyPerson == null) {
			if (other.probeCardApplyPerson != null)
				return false;
		} else if (!probeCardApplyPerson.equals(other.probeCardApplyPerson))
			return false;
		if (productLot == null) {
			if (other.productLot != null)
				return false;
		} else if (!productLot.equals(other.productLot))
			return false;
		if (productModel == null) {
			if (other.productModel != null)
				return false;
		} else if (!productModel.equals(other.productModel))
			return false;
		if (productNowModel == null) {
			if (other.productNowModel != null)
				return false;
		} else if (!productNowModel.equals(other.productNowModel))
			return false;
		if (returnLevel == null) {
			if (other.returnLevel != null)
				return false;
		} else if (!returnLevel.equals(other.returnLevel))
			return false;
		if (returnPerson == null) {
			if (other.returnPerson != null)
				return false;
		} else if (!returnPerson.equals(other.returnPerson))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (statusTime == null) {
			if (other.statusTime != null)
				return false;
		} else if (!statusTime.equals(other.statusTime))
			return false;
		if (tipMaximumDiameter == null) {
			if (other.tipMaximumDiameter != null)
				return false;
		} else if (!tipMaximumDiameter.equals(other.tipMaximumDiameter))
			return false;
		if (tipMinimumDiameter == null) {
			if (other.tipMinimumDiameter != null)
				return false;
		} else if (!tipMinimumDiameter.equals(other.tipMinimumDiameter))
			return false;
		if (tipShortest == null) {
			if (other.tipShortest != null)
				return false;
		} else if (!tipShortest.equals(other.tipShortest))
			return false;
		if (touchTime == null) {
			if (other.touchTime != null)
				return false;
		} else if (!touchTime.equals(other.touchTime))
			return false;
		if (xyNeedlePosition == null) {
			if (other.xyNeedlePosition != null)
				return false;
		} else if (!xyNeedlePosition.equals(other.xyNeedlePosition))
			return false;
		return true;
	}

}
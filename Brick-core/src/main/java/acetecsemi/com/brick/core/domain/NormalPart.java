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
@Table(name="BRICK_NORMALPART")
public class NormalPart extends BrickAbstractEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6581609139546584773L;
	
	private Date inDate;
	private String partName;
	private String serialNumber;
	private String pn;
	private String equipment;
	private String status;
	private String warrantyPeriod;
	private String manufacturer;
	private String type;
	private String remark;
	private String location;
	private String slotSite;
	private String propertyNumber;
	private String quantity;
	private String partType;
	private String partRevision;
	private String partConfig;
	

	public Date getInDate() {
		return inDate;
	}


	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}


	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getSlotSite() {
		return slotSite;
	}


	public void setSlotSite(String slotSite) {
		this.slotSite = slotSite;
	}


	public String getPropertyNumber() {
		return propertyNumber;
	}


	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getPartType() {
		return partType;
	}


	public void setPartType(String partType) {
		this.partType = partType;
	}


	public String getPartRevision() {
		return partRevision;
	}


	public void setPartRevision(String partRevision) {
		this.partRevision = partRevision;
	}


	public String getPartConfig() {
		return partConfig;
	}


	public void setPartConfig(String partConfig) {
		this.partConfig = partConfig;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getPn() {
		return pn;
	}


	public void setPn(String pn) {
		this.pn = pn;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((inDate == null) ? 0 : inDate.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result
				+ ((partConfig == null) ? 0 : partConfig.hashCode());
		result = prime * result
				+ ((partName == null) ? 0 : partName.hashCode());
		result = prime * result
				+ ((partRevision == null) ? 0 : partRevision.hashCode());
		result = prime * result
				+ ((partType == null) ? 0 : partType.hashCode());
		result = prime * result
				+ ((propertyNumber == null) ? 0 : propertyNumber.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result
				+ ((slotSite == null) ? 0 : slotSite.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((warrantyPeriod == null) ? 0 : warrantyPeriod.hashCode());
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
		NormalPart other = (NormalPart) obj;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (inDate == null) {
			if (other.inDate != null)
				return false;
		} else if (!inDate.equals(other.inDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (partConfig == null) {
			if (other.partConfig != null)
				return false;
		} else if (!partConfig.equals(other.partConfig))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (partRevision == null) {
			if (other.partRevision != null)
				return false;
		} else if (!partRevision.equals(other.partRevision))
			return false;
		if (partType == null) {
			if (other.partType != null)
				return false;
		} else if (!partType.equals(other.partType))
			return false;
		if (propertyNumber == null) {
			if (other.propertyNumber != null)
				return false;
		} else if (!propertyNumber.equals(other.propertyNumber))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (slotSite == null) {
			if (other.slotSite != null)
				return false;
		} else if (!slotSite.equals(other.slotSite))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (warrantyPeriod == null) {
			if (other.warrantyPeriod != null)
				return false;
		} else if (!warrantyPeriod.equals(other.warrantyPeriod))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "NormalPart [inDate=" + inDate + ", partName=" + partName
				+ ", serialNumber=" + serialNumber + ", equipment=" + equipment
				+ ", status=" + status + ", warrantyPeriod=" + warrantyPeriod
				+ ", manufacturer=" + manufacturer + ", type=" + type
				+ ", remark=" + remark + ", location=" + location
				+ ", slotSite=" + slotSite + ", propertyNumber="
				+ propertyNumber + ", quantity=" + quantity + ", partType="
				+ partType + ", partRevision=" + partRevision + ", partConfig="
				+ partConfig + "]";
	}


	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),this.getLastModifyTimestamp().toString()};
	}

}
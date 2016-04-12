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

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "BRICK_PART")
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public class Part extends BrickAbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5204603319004653589L;
	/**
	 * 类别
	 */
	@Column(name = "CATEGORY", insertable = false, updatable = false)
	private String category;// 配件类别
	private String partNo;// 配件编号
	private String partName;// 配件名称
	private String equipmentList;// 可使用设备
	private String partType;
	private String partModel;
	private String productModel;//产品型号
	private String nowProductModel;
	private Date inDate;// 进厂时间
	private String partLocaltion;// 存储位置

	private String manufacturerNo;
	private String manufacturerName;

	private String customerName;
	private String customerNameEn;

	private String ownership;// 财产归属
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "status_ID", referencedColumnName = "ID")
	private Category status;// 状态
	private String remark;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "equipment_ID", referencedColumnName = "ID")
	private Equipment equipment;
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "paltform_ID", referencedColumnName = "ID")
	private Platform nowPlatform;

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(String equipmentList) {
		this.equipmentList = equipmentList;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartModel() {
		return partModel;
	}

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getPartLocaltion() {
		return partLocaltion;
	}

	public void setPartLocaltion(String partLocaltion) {
		this.partLocaltion = partLocaltion;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public Category getStatus() {
		return status;
	}

	public void setStatus(Category status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getNowProductModel() {
		return nowProductModel;
	}

	public void setNowProductModel(String nowProductModel) {
		this.nowProductModel = nowProductModel;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNameEn() {
		return customerNameEn;
	}

	public void setCustomerNameEn(String customerNameEn) {
		this.customerNameEn = customerNameEn;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManufacturerNo() {
		return manufacturerNo;
	}

	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Platform getNowPlatform() {
		return nowPlatform;
	}

	public void setNowPlatform(Platform nowPlatform) {
		this.nowPlatform = nowPlatform;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((equipmentList == null) ? 0 : equipmentList.hashCode());
		result = prime * result + ((inDate == null) ? 0 : inDate.hashCode());
		result = prime * result
				+ ((ownership == null) ? 0 : ownership.hashCode());
		result = prime * result
				+ ((partLocaltion == null) ? 0 : partLocaltion.hashCode());
		result = prime * result
				+ ((partModel == null) ? 0 : partModel.hashCode());
		result = prime * result
				+ ((partName == null) ? 0 : partName.hashCode());
		result = prime * result + ((partNo == null) ? 0 : partNo.hashCode());
		result = prime * result
				+ ((partType == null) ? 0 : partType.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		Part other = (Part) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (equipmentList == null) {
			if (other.equipmentList != null)
				return false;
		} else if (!equipmentList.equals(other.equipmentList))
			return false;
		if (inDate == null) {
			if (other.inDate != null)
				return false;
		} else if (!inDate.equals(other.inDate))
			return false;
		if (ownership == null) {
			if (other.ownership != null)
				return false;
		} else if (!ownership.equals(other.ownership))
			return false;
		if (partLocaltion == null) {
			if (other.partLocaltion != null)
				return false;
		} else if (!partLocaltion.equals(other.partLocaltion))
			return false;
		if (partModel == null) {
			if (other.partModel != null)
				return false;
		} else if (!partModel.equals(other.partModel))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (partNo == null) {
			if (other.partNo != null)
				return false;
		} else if (!partNo.equals(other.partNo))
			return false;
		if (partType == null) {
			if (other.partType != null)
				return false;
		} else if (!partType.equals(other.partType))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
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
		// TODO Auto-generated method stub
		return null;
	}

}
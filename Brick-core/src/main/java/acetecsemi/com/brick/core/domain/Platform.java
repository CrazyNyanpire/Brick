package acetecsemi.com.brick.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.openkoala.security.core.domain.User;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:10
 */
@Entity
@Table(name="BRICK_PLATFORM")
public class Platform extends BrickAbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083890603510034999L;
	private String platformNo;//平台编号
	private String platformName;//平台名称-tester的名称
	private String platformCategory;//平台分类CP、FT
	private Date checkInTime;//组装时间
	private String status;//平台状态
	private String subSstatus;//平台子状态
	private String picUrl;
	@OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "tester_ID", referencedColumnName = "ID")
	private Equipment tester;
	@OneToMany(targetEntity = Equipment.class, cascade = CascadeType.REFRESH,fetch=FetchType.EAGER, mappedBy = "platform")
	@OrderBy(value = "equipmentNo DESC")
	private Set<Equipment> equipmentChildren = new HashSet<Equipment>();// 设备
	
	private String productModel;  //当前测试产品型号
	private String nowLot; //当前测试产品批次
	
	public String getPlatformNo() {
		return platformNo;
	}
	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformCategory() {
		return platformCategory;
	}
	public void setPlatformCategory(String platformCategory) {
		this.platformCategory = platformCategory;
	}
	
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSubSstatus() {
		return subSstatus;
	}
	public void setSubSstatus(String subSstatus) {
		this.subSstatus = subSstatus;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Set<Equipment> getEquipmentChildren() {
		return equipmentChildren;
	}
	public void setEquipmentChildren(Set<Equipment> equipmentChildren) {
		this.equipmentChildren = equipmentChildren;
	}
	public Equipment getTester() {
		return tester;
	}
	public void setTester(Equipment tester) {
		this.tester = tester;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((checkInTime == null) ? 0 : checkInTime.hashCode());
		result = prime * result + ((picUrl == null) ? 0 : picUrl.hashCode());
		result = prime
				* result
				+ ((platformCategory == null) ? 0 : platformCategory.hashCode());
		result = prime * result
				+ ((platformName == null) ? 0 : platformName.hashCode());
		result = prime * result
				+ ((platformNo == null) ? 0 : platformNo.hashCode());
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
		Platform other = (Platform) obj;
		if (checkInTime == null) {
			if (other.checkInTime != null)
				return false;
		} else if (!checkInTime.equals(other.checkInTime))
			return false;
		if (picUrl == null) {
			if (other.picUrl != null)
				return false;
		} else if (!picUrl.equals(other.picUrl))
			return false;
		if (platformCategory == null) {
			if (other.platformCategory != null)
				return false;
		} else if (!platformCategory.equals(other.platformCategory))
			return false;
		if (platformName == null) {
			if (other.platformName != null)
				return false;
		} else if (!platformName.equals(other.platformName))
			return false;
		if (platformNo == null) {
			if (other.platformNo != null)
				return false;
		} else if (!platformNo.equals(other.platformNo))
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
		return new String[] { String.valueOf(getId()), this.getCreateTimestamp().toString()};
	}


}
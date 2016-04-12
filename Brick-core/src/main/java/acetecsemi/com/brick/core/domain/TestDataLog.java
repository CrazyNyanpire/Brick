package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "BRICK_TestDataLog")
public class TestDataLog extends BrickAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8293811641750809732L;

	private String equipmentNo;
	private String ip;
	private String acetecLot;
	private String customerNo;
	private String productModel;
	private String status;
	
	@Column(length=5000) 
	private String remark;// 备注

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAcetecLot() {
		return acetecLot;
	}

	public void setAcetecLot(String acetecLot) {
		this.acetecLot = acetecLot;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((acetecLot == null) ? 0 : acetecLot.hashCode());
		result = prime * result
				+ ((customerNo == null) ? 0 : customerNo.hashCode());
		result = prime * result
				+ ((equipmentNo == null) ? 0 : equipmentNo.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result
				+ ((productModel == null) ? 0 : productModel.hashCode());
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
		TestDataLog other = (TestDataLog) obj;
		if (acetecLot == null) {
			if (other.acetecLot != null)
				return false;
		} else if (!acetecLot.equals(other.acetecLot))
			return false;
		if (customerNo == null) {
			if (other.customerNo != null)
				return false;
		} else if (!customerNo.equals(other.customerNo))
			return false;
		if (equipmentNo == null) {
			if (other.equipmentNo != null)
				return false;
		} else if (!equipmentNo.equals(other.equipmentNo))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (productModel == null) {
			if (other.productModel != null)
				return false;
		} else if (!productModel.equals(other.productModel))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

}
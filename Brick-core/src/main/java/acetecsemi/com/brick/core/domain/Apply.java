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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="BRICK_APPLY")
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public class Apply extends BrickAbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 693361168095023058L;

	/**
	 * 类别
	 */
	@Column(name = "CATEGORY", insertable = false, updatable = false)
	private String category;//配件类别
	
	/**
	 * 申请人
	 */
//	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
//	@JoinColumn(name = "APPLYUSER_ID", referencedColumnName = "ID")
	private String applyUser;
	
	/**
	 * 操作人
	 */
//	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
//	@JoinColumn(name = "OPTUSER_ID", referencedColumnName = "ID")
	private String optUser;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 申请日
	 */
	private Date applyDate; //申请时间

	/**
	 * 备注
	 */
	private String remark;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	public String getOptUser() {
		return optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result
				+ ((applyUser == null) ? 0 : applyUser.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((optUser == null) ? 0 : optUser.hashCode());
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
		Apply other = (Apply) obj;
		if (applyDate == null) {
			if (other.applyDate != null)
				return false;
		} else if (!applyDate.equals(other.applyDate))
			return false;
		if (applyUser == null) {
			if (other.applyUser != null)
				return false;
		} else if (!applyUser.equals(other.applyUser))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (optUser == null) {
			if (other.optUser != null)
				return false;
		} else if (!optUser.equals(other.optUser))
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
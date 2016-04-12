package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="BRICK_OPTIONLOG")
public class OptionLog extends BrickAbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1027972240096592127L;

	private String status;
	
	private String optUser;
	
	private Date optDate;
	
	private String remark;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOptUser() {
		return optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
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
		result = prime * result + ((optDate == null) ? 0 : optDate.hashCode());
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
		OptionLog other = (OptionLog) obj;
		if (optDate == null) {
			if (other.optDate != null)
				return false;
		} else if (!optDate.equals(other.optDate))
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
		return new String[] { String.valueOf(getId()),this.getCreateTimestamp().toString()};
	}

}
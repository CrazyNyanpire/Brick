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
 * @created 20-03-2015 15:27:09
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "BRICK_MAINTENANCE")
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public class Maintenance extends BrickAbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9008831588443558010L;

	@Column(name = "CATEGORY", insertable = false, updatable = false)
	private String category;

	private String optType;// 操作类型
	private String optUser;// 操作人员
	private Date optDate;// 操作时间
	private String remark;// 操作详情
	private String fileUrl;// 上传文档

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((fileUrl == null) ? 0 : fileUrl.hashCode());
		result = prime * result + ((optDate == null) ? 0 : optDate.hashCode());
		result = prime * result + ((optType == null) ? 0 : optType.hashCode());
		result = prime * result + ((optUser == null) ? 0 : optUser.hashCode());
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
		Maintenance other = (Maintenance) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (fileUrl == null) {
			if (other.fileUrl != null)
				return false;
		} else if (!fileUrl.equals(other.fileUrl))
			return false;
		if (optDate == null) {
			if (other.optDate != null)
				return false;
		} else if (!optDate.equals(other.optDate))
			return false;
		if (optType == null) {
			if (other.optType != null)
				return false;
		} else if (!optType.equals(other.optType))
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
		return true;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}
}
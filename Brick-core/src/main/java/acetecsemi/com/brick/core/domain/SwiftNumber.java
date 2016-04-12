package acetecsemi.com.brick.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 05-03-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_SwiftNumber")
public class SwiftNumber extends BrickAbstractEntity {
	/**
	 * 用于保存初始值
	 */
	private static final long serialVersionUID = 5204603319004653489L;

	private String type;// 类别
	private String startTitle;// 开始编码
	private String date;// 日期字符串
	private String sn;// 流水号
	private Integer totalSn;// 总流水号
	private String nowSwiftNumber;//当前编号

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTitle() {
		return startTitle;
	}

	public void setStartTitle(String startTitle) {
		this.startTitle = startTitle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getTotalSn() {
		return totalSn;
	}

	public void setTotalSn(Integer totalSn) {
		this.totalSn = totalSn;
	}

	public String getNowSwiftNumber() {
		return nowSwiftNumber;
	}

	public void setNowSwiftNumber(String nowSwiftNumber) {
		this.nowSwiftNumber = nowSwiftNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((nowSwiftNumber == null) ? 0 : nowSwiftNumber.hashCode());
		result = prime * result + ((sn == null) ? 0 : sn.hashCode());
		result = prime * result
				+ ((startTitle == null) ? 0 : startTitle.hashCode());
		result = prime * result + ((totalSn == null) ? 0 : totalSn.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SwiftNumber other = (SwiftNumber) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (nowSwiftNumber == null) {
			if (other.nowSwiftNumber != null)
				return false;
		} else if (!nowSwiftNumber.equals(other.nowSwiftNumber))
			return false;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
			return false;
		if (startTitle == null) {
			if (other.startTitle != null)
				return false;
		} else if (!startTitle.equals(other.startTitle))
			return false;
		if (totalSn == null) {
			if (other.totalSn != null)
				return false;
		} else if (!totalSn.equals(other.totalSn))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

}
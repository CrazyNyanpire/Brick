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
@Table(name = "BRICK_STATUSTOPTIONLOG")
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING)
public class StatusOptionLog extends BrickAbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9008831588443558010L;

	@Column(name = "CATEGORY", insertable = false, updatable = false)
	private String category;
	private String status;
	private String subStatus;// 子状态
	private String optUser;
	private Date optDate;
	private String nowLot;// 当前批次
	private String nowStation;// 当前站点
	private String productModel;// 产品型号
	private Date startTime;// 开始时间
	private Date endTime;// 结束时间
	private Long duration;// 持续时间
	private String endOptUser;// 结束人员
	private String standardWorkHours;// 标准工时 FT:测试数量/理论时间 CP:片数*理论时间
	private String grossDie;// GROSSDIE
	private String theoryTime;// 理论时间
	private String inkType;// ink类型
	private Long touchTimes;// 接触次数
	private String team;// 班次
	private String isShift; // 交接班
	private String optRemark;// 操作备注
	private String errorMsg;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
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

	public String getNowLot() {
		return nowLot;
	}

	public void setNowLot(String nowLot) {
		this.nowLot = nowLot;
	}

	public String getNowStation() {
		return nowStation;
	}

	public void setNowStation(String nowStation) {
		this.nowStation = nowStation;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getEndOptUser() {
		return endOptUser;
	}

	public void setEndOptUser(String endOptUser) {
		this.endOptUser = endOptUser;
	}

	public String getStandardWorkHours() {
		return standardWorkHours;
	}

	public void setStandardWorkHours(String standardWorkHours) {
		this.standardWorkHours = standardWorkHours;
	}

	public String getGrossDie() {
		return grossDie;
	}

	public void setGrossDie(String grossDie) {
		this.grossDie = grossDie;
	}

	public String getTheoryTime() {
		return theoryTime;
	}

	public void setTheoryTime(String theoryTime) {
		this.theoryTime = theoryTime;
	}

	public String getInkType() {
		return inkType;
	}

	public void setInkType(String inkType) {
		this.inkType = inkType;
	}

	public Long getTouchTimes() {
		return touchTimes;
	}

	public void setTouchTimes(Long touchTimes) {
		this.touchTimes = touchTimes;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getIsShift() {
		return isShift;
	}

	public void setIsShift(String isShift) {
		this.isShift = isShift;
	}

	public String getOptRemark() {
		return optRemark;
	}

	public void setOptRemark(String optRemark) {
		this.optRemark = optRemark;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result
				+ ((endOptUser == null) ? 0 : endOptUser.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((grossDie == null) ? 0 : grossDie.hashCode());
		result = prime * result + ((inkType == null) ? 0 : inkType.hashCode());
		result = prime * result + ((isShift == null) ? 0 : isShift.hashCode());
		result = prime * result + ((nowLot == null) ? 0 : nowLot.hashCode());
		result = prime * result
				+ ((nowStation == null) ? 0 : nowStation.hashCode());
		result = prime * result + ((optDate == null) ? 0 : optDate.hashCode());
		result = prime * result
				+ ((optRemark == null) ? 0 : optRemark.hashCode());
		result = prime * result + ((optUser == null) ? 0 : optUser.hashCode());
		result = prime * result
				+ ((productModel == null) ? 0 : productModel.hashCode());
		result = prime
				* result
				+ ((standardWorkHours == null) ? 0 : standardWorkHours
						.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((subStatus == null) ? 0 : subStatus.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result
				+ ((theoryTime == null) ? 0 : theoryTime.hashCode());
		result = prime * result
				+ ((touchTimes == null) ? 0 : touchTimes.hashCode());
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
		StatusOptionLog other = (StatusOptionLog) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (endOptUser == null) {
			if (other.endOptUser != null)
				return false;
		} else if (!endOptUser.equals(other.endOptUser))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (grossDie == null) {
			if (other.grossDie != null)
				return false;
		} else if (!grossDie.equals(other.grossDie))
			return false;
		if (inkType == null) {
			if (other.inkType != null)
				return false;
		} else if (!inkType.equals(other.inkType))
			return false;
		if (isShift == null) {
			if (other.isShift != null)
				return false;
		} else if (!isShift.equals(other.isShift))
			return false;
		if (nowLot == null) {
			if (other.nowLot != null)
				return false;
		} else if (!nowLot.equals(other.nowLot))
			return false;
		if (nowStation == null) {
			if (other.nowStation != null)
				return false;
		} else if (!nowStation.equals(other.nowStation))
			return false;
		if (optDate == null) {
			if (other.optDate != null)
				return false;
		} else if (!optDate.equals(other.optDate))
			return false;
		if (optRemark == null) {
			if (other.optRemark != null)
				return false;
		} else if (!optRemark.equals(other.optRemark))
			return false;
		if (optUser == null) {
			if (other.optUser != null)
				return false;
		} else if (!optUser.equals(other.optUser))
			return false;
		if (productModel == null) {
			if (other.productModel != null)
				return false;
		} else if (!productModel.equals(other.productModel))
			return false;
		if (standardWorkHours == null) {
			if (other.standardWorkHours != null)
				return false;
		} else if (!standardWorkHours.equals(other.standardWorkHours))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subStatus == null) {
			if (other.subStatus != null)
				return false;
		} else if (!subStatus.equals(other.subStatus))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (theoryTime == null) {
			if (other.theoryTime != null)
				return false;
		} else if (!theoryTime.equals(other.theoryTime))
			return false;
		if (touchTimes == null) {
			if (other.touchTimes != null)
				return false;
		} else if (!touchTimes.equals(other.touchTimes))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}
}
package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="BRICK_PLATFORMAPPLY")
public class PlatformApply extends Apply {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1129074198116323854L;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "platform_ID", referencedColumnName = "ID")
	private Platform platform; //平台编号
	
	private Date planStartTime; //预计起始时间
	
	private Date planEndTime; //预计结束时间
	
	private String planTime; //预计用时
	
	private String type; //借机类型
	
	private String borrowSource; //借机对象

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBorrowSource() {
		return borrowSource;
	}

	public void setBorrowSource(String borrowSource) {
		this.borrowSource = borrowSource;
	}

}

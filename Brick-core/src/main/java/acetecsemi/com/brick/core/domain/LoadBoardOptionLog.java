package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_LOADBOARDOPTIONLOG")
public class LoadBoardOptionLog extends BrickAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1376428644368634706L;
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOADBOARD_ID", referencedColumnName = "ID")
	private LoadBoard loadBoard;
	private String status;
	private String nowLot;// 当前批次
	private String nowStation;// 当前站点
	private String productModel;// 产品型号
	private Date startTime;// 开始时间
	private Date endTime;// 结束时间
	private Long duration;// 持续时间
	private String endOptUser;// 结束人员
	private String theoryTime;// 理论时间
	private String optRemark;// 操作备注
	private String productLot;
	private String equipmentNo;
	private String remark;
	private String appearanceHorizontal;
	private String platform; //平台
	private String platformIds;//release 平台ID
	private String platformStatus;
	

	public LoadBoard getLoadBoard() {
		return loadBoard;
	}

	public void setLoadBoard(LoadBoard loadBoard) {
		this.loadBoard = loadBoard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTheoryTime() {
		return theoryTime;
	}

	public void setTheoryTime(String theoryTime) {
		this.theoryTime = theoryTime;
	}


	public String getOptRemark() {
		return optRemark;
	}

	public void setOptRemark(String optRemark) {
		this.optRemark = optRemark;
	}

	public String getProductLot() {
		return productLot;
	}

	public void setProductLot(String productLot) {
		this.productLot = productLot;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAppearanceHorizontal() {
		return appearanceHorizontal;
	}

	public void setAppearanceHorizontal(String appearanceHorizontal) {
		this.appearanceHorizontal = appearanceHorizontal;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformIds() {
		return platformIds;
	}

	public void setPlatformIds(String platformIds) {
		this.platformIds = platformIds;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

}
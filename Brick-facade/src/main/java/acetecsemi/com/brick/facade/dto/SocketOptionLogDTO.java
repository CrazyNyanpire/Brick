package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class SocketOptionLogDTO implements Serializable {

	private Long id;

	private int version;

	private String productLot;

	private String status;

	private String endOptUser;

	private String productModel;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private Date endTime;

	private Date endTimeEnd;

	private Long touchTimes;

	private String nowStation;

	private String lastModifyEmployNo;

	private Date startTime;

	private Date startTimeEnd;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private Long duration;

	private String createEmployNo;

	private String equipmentNo;

	private String subStatus;

	private String optRemark;

	private String nowLot;

	private String theoryTime;

	private String appearanceHorizontal;

	private Long socketId;

	private String partModel;

	private String partNo;

	private Long lastTouchTime;// 上状态touchTimes

	private Long nowTouchTime;// 本状态touchTimes

	private String isChangePin;

	private String platformStatus;
	
	private Integer platformSite;

	public void setProductLot(String productLot) {
		this.productLot = productLot;
	}

	public String getProductLot() {
		return this.productLot;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setEndOptUser(String endOptUser) {
		this.endOptUser = endOptUser;
	}

	public String getEndOptUser() {
		return this.endOptUser;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductModel() {
		return this.productModel;
	}

	public void setLastModifyTimestamp(Date lastModifyTimestamp) {
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	public Date getLastModifyTimestamp() {
		return this.lastModifyTimestamp;
	}

	public void setLastModifyTimestampEnd(Date lastModifyTimestampEnd) {
		this.lastModifyTimestampEnd = lastModifyTimestampEnd;
	}

	public Date getLastModifyTimestampEnd() {
		return this.lastModifyTimestampEnd;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTimeEnd(Date endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public Date getEndTimeEnd() {
		return this.endTimeEnd;
	}

	public void setTouchTimes(Long touchTimes) {
		this.touchTimes = touchTimes;
	}

	public Long getTouchTimes() {
		return this.touchTimes;
	}

	public void setNowStation(String nowStation) {
		this.nowStation = nowStation;
	}

	public String getNowStation() {
		return this.nowStation;
	}

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTimeEnd(Date startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}

	public Date getStartTimeEnd() {
		return this.startTimeEnd;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestampEnd(Date createTimestampEnd) {
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getDuration() {
		return this.duration;
	}

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getEquipmentNo() {
		return this.equipmentNo;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getSubStatus() {
		return this.subStatus;
	}

	public void setOptRemark(String optRemark) {
		this.optRemark = optRemark;
	}

	public String getOptRemark() {
		return this.optRemark;
	}

	public void setNowLot(String nowLot) {
		this.nowLot = nowLot;
	}

	public String getNowLot() {
		return this.nowLot;
	}

	public void setTheoryTime(String theoryTime) {
		this.theoryTime = theoryTime;
	}

	public String getTheoryTime() {
		return this.theoryTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAppearanceHorizontal() {
		return appearanceHorizontal;
	}

	public void setAppearanceHorizontal(String appearanceHorizontal) {
		this.appearanceHorizontal = appearanceHorizontal;
	}

	public Long getSocketId() {
		return socketId;
	}

	public void setSocketId(Long socketId) {
		this.socketId = socketId;
	}

	public String getPartModel() {
		return partModel;
	}

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public Long getLastTouchTime() {
		return lastTouchTime;
	}

	public void setLastTouchTime(Long lastTouchTime) {
		this.lastTouchTime = lastTouchTime;
	}

	public Long getNowTouchTime() {
		return nowTouchTime;
	}

	public void setNowTouchTime(Long nowTouchTime) {
		this.nowTouchTime = nowTouchTime;
	}

	public String getIsChangePin() {
		return isChangePin;
	}

	public void setIsChangePin(String isChangePin) {
		this.isChangePin = isChangePin;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}

	public Integer getPlatformSite() {
		return platformSite;
	}

	public void setPlatformSite(Integer platformSite) {
		this.platformSite = platformSite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocketOptionLogDTO other = (SocketOptionLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
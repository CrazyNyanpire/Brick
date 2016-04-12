package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class SocketDTO implements Serializable {

	private Long id;

	private int version;

	private String remark;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date inDate;

	private Date inDateEnd;

	private String applicableModels;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date createTimestamp;

	private Date createTimestampEnd;

	private Integer pinQty;

	private String lastFileUrl;

	private String partLocaltion;

	private String customerNameEn;

	private String supplier;

	private String customerName;

	private String manufacturerNo;

	private String equipmentList;

	private String partType;

	private String partNo;

	private String status;

	private String partName;

	private String productModel;

	private Integer qty;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String partModel;

	private String pinModels;

	private String lastModifyEmployNo;

	private String category;

	private String createEmployNo;

	private String ownership;

	private String manufacturerName;

	private String pn;

	private String nowProductModel;

	private String nowLot;// 当前批次
	private String nowStation;// 当前站点
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date startTime;// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date endTime;// 结束时间
	private Long duration;// 持续时间
	private String endOptUser;// 结束人员
	private String theoryTime;// 理论时间
	private Long touchTimes;// 接触次数
	private String optRemark;// 操作备注
	private String productLot;
	private String equipmentNo;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date optDate;

	private Long statusId;
	
	private String platform;
	
	private String appearanceLevel;
	
	private Long platformId;
	
	private Long touchTime;
	
	private Long touchTimeTotal;
	
	private String isChangePin;
	
	private String inTipMaximumDiameter; // 进厂针尖最大直径
	private String inTipMinimumDiameter; // 进厂针尖最小直径
	
	private String platformNo;
	
	private Integer platformSite;//site 0\1\2\3
	
	private Long nowPlatformId;
	
	private String equipmentListId;
	
	private String platformStatus;
	
	private String statusIds;
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getInDate() {
		return this.inDate;
	}

	public void setInDateEnd(Date inDateEnd) {
		this.inDateEnd = inDateEnd;
	}

	public Date getInDateEnd() {
		return this.inDateEnd;
	}

	public void setApplicableModels(String applicableModels) {
		this.applicableModels = applicableModels;
	}

	public String getApplicableModels() {
		return this.applicableModels;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestampEnd(Date createTimestampEnd) {
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}

	public void setPinQty(Integer pinQty) {
		this.pinQty = pinQty;
	}

	public Integer getPinQty() {
		return this.pinQty;
	}

	public void setLastFileUrl(String lastFileUrl) {
		this.lastFileUrl = lastFileUrl;
	}

	public String getLastFileUrl() {
		return this.lastFileUrl;
	}

	public void setPartLocaltion(String partLocaltion) {
		this.partLocaltion = partLocaltion;
	}

	public String getPartLocaltion() {
		return this.partLocaltion;
	}

	public void setCustomerNameEn(String customerNameEn) {
		this.customerNameEn = customerNameEn;
	}

	public String getCustomerNameEn() {
		return this.customerNameEn;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
	}

	public String getManufacturerNo() {
		return this.manufacturerNo;
	}

	public void setEquipmentList(String equipmentList) {
		this.equipmentList = equipmentList;
	}

	public String getEquipmentList() {
		return this.equipmentList;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartType() {
		return this.partType;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartNo() {
		return this.partNo;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductModel() {
		return this.productModel;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getQty() {
		return this.qty;
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

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public String getPartModel() {
		return this.partModel;
	}

	public void setPinModels(String pinModels) {
		this.pinModels = pinModels;
	}

	public String getPinModels() {
		return this.pinModels;
	}

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getOwnership() {
		return this.ownership;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getPn() {
		return this.pn;
	}

	public void setNowProductModel(String nowProductModel) {
		this.nowProductModel = nowProductModel;
	}

	public String getNowProductModel() {
		return this.nowProductModel;
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

	public Long getTouchTimes() {
		return touchTimes;
	}

	public void setTouchTimes(Long touchTimes) {
		this.touchTimes = touchTimes;
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

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getAppearanceLevel() {
		return appearanceLevel;
	}

	public void setAppearanceLevel(String appearanceLevel) {
		this.appearanceLevel = appearanceLevel;
	}

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public Long getTouchTime() {
		return touchTime;
	}

	public void setTouchTime(Long touchTime) {
		this.touchTime = touchTime;
	}

	public Long getTouchTimeTotal() {
		return touchTimeTotal;
	}

	public void setTouchTimeTotal(Long touchTimeTotal) {
		this.touchTimeTotal = touchTimeTotal;
	}

	public String getIsChangePin() {
		return isChangePin;
	}

	public void setIsChangePin(String isChangePin) {
		this.isChangePin = isChangePin;
	}

	public String getInTipMaximumDiameter() {
		return inTipMaximumDiameter;
	}

	public void setInTipMaximumDiameter(String inTipMaximumDiameter) {
		this.inTipMaximumDiameter = inTipMaximumDiameter;
	}

	public String getInTipMinimumDiameter() {
		return inTipMinimumDiameter;
	}

	public void setInTipMinimumDiameter(String inTipMinimumDiameter) {
		this.inTipMinimumDiameter = inTipMinimumDiameter;
	}

	public String getPlatformNo() {
		return platformNo;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}

	public Integer getPlatformSite() {
		return platformSite;
	}

	public void setPlatformSite(Integer platformSite) {
		this.platformSite = platformSite;
	}

	public Long getNowPlatformId() {
		return nowPlatformId;
	}

	public void setNowPlatformId(Long nowPlatformId) {
		this.nowPlatformId = nowPlatformId;
	}

	public String getEquipmentListId() {
		return equipmentListId;
	}

	public void setEquipmentListId(String equipmentListId) {
		this.equipmentListId = equipmentListId;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}

	public String getStatusIds() {
		return statusIds;
	}

	public void setStatusIds(String statusIds) {
		this.statusIds = statusIds;
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
		SocketDTO other = (SocketDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
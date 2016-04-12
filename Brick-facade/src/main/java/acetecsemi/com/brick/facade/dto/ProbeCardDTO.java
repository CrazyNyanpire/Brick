package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class ProbeCardDTO implements Serializable {

	private Long id;

	private int version;

	private Long touchTimeTotal;

	private String xyNeedlePosition;

	private String remark;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date inDate;

	private Date inDateEnd;

	private String maintenanceBase;

	private String tipHeight;

	private String remakeNumber;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date createTimestamp;

	private Date createTimestampEnd;

	private String appearanceOfProbeCard;

	private String partLocaltion;

	private String customerNameEn;

	private String probeMaterials;

	private String testTemperature;

	private String reinforcingPlate;

	private String customerName;

	private String equipmentList;

	private Long touchTime;

	private String partType;

	private String maintenanceLowerLimit;

	private String partNo;

	private String status;

	private String scrappingStandard;

	private String ExpoxyToTipAngleDistance;

	private String partName;

	private String tipMinimumDiameter;

	private String productModel;

	private String maintenanceUpperLimit;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String inLongestNeedle;

	private String partModel;

	private String lastModifyEmployNo;

	private String category;

	private String ownership;

	private String createEmployNo;

	private String tipShortest;

	private String openRemake;

	private String zNeedlePositionFlatness;

	private String tipLongest;

	private String tipMaximumDiameter;

	private String nowProductModel;

	private String inShortestNeedle;

	private String manufacturerNo;

	private String manufacturerName;

	private String equipmentNo;

	private String equipmentCategory;

	private Integer pinQty;

	private String pcbSize;

	private Date endDate;
	private String statusTime;
	private String maintenancePerson;
	private String maintenanceItems;
	private String dutNumber;
	private String binNo;
	private String platforms;
	private String platform;
	private String productLot;
	private String productNowModel;
	private String probeCardApplyPerson;
	private String returnPerson;
	private String returnLevel;
	private String needlePositionLevel;
	private String appearanceLevel;

	private String optUser;
	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date OptDate;

	private Long statusId;

	private Long platformId;

	private String inTipMaximumDiameter; // 进厂针尖最大直径
	private String inTipMinimumDiameter; // 进厂针尖最小直径
	
	private String platformNo;
	
	private Long nowPlatformId;
	
	private String platformStatus;
	
	private String statusIds;

	public void setTouchTimeTotal(Long touchTimeTotal) {
		this.touchTimeTotal = touchTimeTotal;
	}

	public Long getTouchTimeTotal() {
		return this.touchTimeTotal;
	}

	public void setXyNeedlePosition(String xyNeedlePosition) {
		this.xyNeedlePosition = xyNeedlePosition;
	}

	public String getXyNeedlePosition() {
		return this.xyNeedlePosition;
	}

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

	public void setMaintenanceBase(String maintenanceBase) {
		this.maintenanceBase = maintenanceBase;
	}

	public String getMaintenanceBase() {
		return this.maintenanceBase;
	}

	public void setTipHeight(String tipHeight) {
		this.tipHeight = tipHeight;
	}

	public String getTipHeight() {
		return this.tipHeight;
	}

	public void setRemakeNumber(String remakeNumber) {
		this.remakeNumber = remakeNumber;
	}

	public String getRemakeNumber() {
		return this.remakeNumber;
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

	public void setAppearanceOfProbeCard(String appearanceOfProbeCard) {
		this.appearanceOfProbeCard = appearanceOfProbeCard;
	}

	public String getAppearanceOfProbeCard() {
		return this.appearanceOfProbeCard;
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

	public void setProbeMaterials(String probeMaterials) {
		this.probeMaterials = probeMaterials;
	}

	public String getProbeMaterials() {
		return this.probeMaterials;
	}

	public void setTestTemperature(String testTemperature) {
		this.testTemperature = testTemperature;
	}

	public String getTestTemperature() {
		return this.testTemperature;
	}

	public void setReinforcingPlate(String reinforcingPlate) {
		this.reinforcingPlate = reinforcingPlate;
	}

	public String getReinforcingPlate() {
		return this.reinforcingPlate;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setEquipmentList(String equipmentList) {
		this.equipmentList = equipmentList;
	}

	public String getEquipmentList() {
		return this.equipmentList;
	}

	public void setTouchTime(Long touchTime) {
		this.touchTime = touchTime;
	}

	public Long getTouchTime() {
		return this.touchTime;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartType() {
		return this.partType;
	}

	public void setMaintenanceLowerLimit(String maintenanceLowerLimit) {
		this.maintenanceLowerLimit = maintenanceLowerLimit;
	}

	public String getMaintenanceLowerLimit() {
		return this.maintenanceLowerLimit;
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

	public void setScrappingStandard(String scrappingStandard) {
		this.scrappingStandard = scrappingStandard;
	}

	public String getScrappingStandard() {
		return this.scrappingStandard;
	}

	public void setExpoxyToTipAngleDistance(String ExpoxyToTipAngleDistance) {
		this.ExpoxyToTipAngleDistance = ExpoxyToTipAngleDistance;
	}

	public String getExpoxyToTipAngleDistance() {
		return this.ExpoxyToTipAngleDistance;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setTipMinimumDiameter(String tipMinimumDiameter) {
		this.tipMinimumDiameter = tipMinimumDiameter;
	}

	public String getTipMinimumDiameter() {
		return this.tipMinimumDiameter;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductModel() {
		return this.productModel;
	}

	public void setMaintenanceUpperLimit(String maintenanceUpperLimit) {
		this.maintenanceUpperLimit = maintenanceUpperLimit;
	}

	public String getMaintenanceUpperLimit() {
		return this.maintenanceUpperLimit;
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

	public void setInLongestNeedle(String inLongestNeedle) {
		this.inLongestNeedle = inLongestNeedle;
	}

	public String getInLongestNeedle() {
		return this.inLongestNeedle;
	}

	public void setPartModel(String partModel) {
		this.partModel = partModel;
	}

	public String getPartModel() {
		return this.partModel;
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

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getOwnership() {
		return this.ownership;
	}

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setTipShortest(String tipShortest) {
		this.tipShortest = tipShortest;
	}

	public String getTipShortest() {
		return this.tipShortest;
	}

	public void setOpenRemake(String openRemake) {
		this.openRemake = openRemake;
	}

	public String getOpenRemake() {
		return this.openRemake;
	}

	public void setZNeedlePositionFlatness(String zNeedlePositionFlatness) {
		this.zNeedlePositionFlatness = zNeedlePositionFlatness;
	}

	public String getZNeedlePositionFlatness() {
		return this.zNeedlePositionFlatness;
	}

	public void setTipLongest(String tipLongest) {
		this.tipLongest = tipLongest;
	}

	public String getTipLongest() {
		return this.tipLongest;
	}

	public void setTipMaximumDiameter(String tipMaximumDiameter) {
		this.tipMaximumDiameter = tipMaximumDiameter;
	}

	public String getTipMaximumDiameter() {
		return this.tipMaximumDiameter;
	}

	public void setNowProductModel(String nowProductModel) {
		this.nowProductModel = nowProductModel;
	}

	public String getNowProductModel() {
		return this.nowProductModel;
	}

	public void setInShortestNeedle(String inShortestNeedle) {
		this.inShortestNeedle = inShortestNeedle;
	}

	public String getInShortestNeedle() {
		return this.inShortestNeedle;
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

	public String getzNeedlePositionFlatness() {
		return zNeedlePositionFlatness;
	}

	public void setzNeedlePositionFlatness(String zNeedlePositionFlatness) {
		this.zNeedlePositionFlatness = zNeedlePositionFlatness;
	}

	public String getManufacturerNo() {
		return manufacturerNo;
	}

	public void setManufacturerNo(String manufacturerNo) {
		this.manufacturerNo = manufacturerNo;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}

	public String getMaintenancePerson() {
		return maintenancePerson;
	}

	public void setMaintenancePerson(String maintenancePerson) {
		this.maintenancePerson = maintenancePerson;
	}

	public String getMaintenanceItems() {
		return maintenanceItems;
	}

	public void setMaintenanceItems(String maintenanceItems) {
		this.maintenanceItems = maintenanceItems;
	}

	public String getDutNumber() {
		return dutNumber;
	}

	public void setDutNumber(String dutNumber) {
		this.dutNumber = dutNumber;
	}

	public String getBinNo() {
		return binNo;
	}

	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getProductLot() {
		return productLot;
	}

	public void setProductLot(String productLot) {
		this.productLot = productLot;
	}

	public String getProductNowModel() {
		return productNowModel;
	}

	public void setProductNowModel(String productNowModel) {
		this.productNowModel = productNowModel;
	}

	public String getProbeCardApplyPerson() {
		return probeCardApplyPerson;
	}

	public void setProbeCardApplyPerson(String probeCardApplyPerson) {
		this.probeCardApplyPerson = probeCardApplyPerson;
	}

	public String getReturnPerson() {
		return returnPerson;
	}

	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}

	public String getReturnLevel() {
		return returnLevel;
	}

	public void setReturnLevel(String returnLevel) {
		this.returnLevel = returnLevel;
	}

	public String getNeedlePositionLevel() {
		return needlePositionLevel;
	}

	public void setNeedlePositionLevel(String needlePositionLevel) {
		this.needlePositionLevel = needlePositionLevel;
	}

	public String getAppearanceLevel() {
		return appearanceLevel;
	}

	public void setAppearanceLevel(String appearanceLevel) {
		this.appearanceLevel = appearanceLevel;
	}

	public String getOptUser() {
		return optUser;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public Date getOptDate() {
		return OptDate;
	}

	public void setOptDate(Date optDate) {
		OptDate = optDate;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Integer getPinQty() {
		return pinQty;
	}

	public void setPinQty(Integer pinQty) {
		this.pinQty = pinQty;
	}

	public String getPcbSize() {
		return pcbSize;
	}

	public void setPcbSize(String pcbSize) {
		this.pcbSize = pcbSize;
	}

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
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

	public Long getNowPlatformId() {
		return nowPlatformId;
	}

	public void setNowPlatformId(Long nowPlatformId) {
		this.nowPlatformId = nowPlatformId;
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
		ProbeCardDTO other = (ProbeCardDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class ProbeCardOptionLogDTO implements Serializable {

	private Long id;

	private int version;

	private String productLot;

	private String optUser;

	private String xyNeedlePosition;

	private String remark;

	private Date endDate;

	private Date endDateEnd;

	private String platforms;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String returnLevel;

	private String maintenanceItems;

	private String customerName;

	private String platform;

	private Long touchTime;

	private Date optDate;

	private Date optDateEnd;

	private String probeCardApplyPerson;

	private String status;

	private String binNo;

	private String maintenancePerson;

	private String tipMinimumDiameter;

	private String productModel;

	private String dutNumber;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String appearanceLevel;

	private String needlePositionLevel;

	private String statusTime;

	private String lastModifyEmployNo;

	private String createEmployNo;

	private String tipShortest;
	
	private String tipLongest;

	private String returnPerson;

	private String tipMaximumDiameter;

	private String productNowModel;

	private String partNo;

	private ProbeCardDTO probeCardDTO;
	
	private Long probeCardId;
	
	private String platformNo;//嫁动机台
	
	private String platformStatus;

	public void setProductLot(String productLot) {
		this.productLot = productLot;
	}

	public String getProductLot() {
		return this.productLot;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public String getOptUser() {
		return this.optUser;
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

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDateEnd(Date endDateEnd) {
		this.endDateEnd = endDateEnd;
	}

	public Date getEndDateEnd() {
		return this.endDateEnd;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getPlatforms() {
		return this.platforms;
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

	public void setReturnLevel(String returnLevel) {
		this.returnLevel = returnLevel;
	}

	public String getReturnLevel() {
		return this.returnLevel;
	}

	public void setMaintenanceItems(String maintenanceItems) {
		this.maintenanceItems = maintenanceItems;
	}

	public String getMaintenanceItems() {
		return this.maintenanceItems;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setTouchTime(Long touchTime) {
		this.touchTime = touchTime;
	}

	public Long getTouchTime() {
		return this.touchTime;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getOptDate() {
		return this.optDate;
	}

	public void setOptDateEnd(Date optDateEnd) {
		this.optDateEnd = optDateEnd;
	}

	public Date getOptDateEnd() {
		return this.optDateEnd;
	}

	public void setProbeCardApplyPerson(String probeCardApplyPerson) {
		this.probeCardApplyPerson = probeCardApplyPerson;
	}

	public String getProbeCardApplyPerson() {
		return this.probeCardApplyPerson;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}

	public String getBinNo() {
		return this.binNo;
	}

	public void setMaintenancePerson(String maintenancePerson) {
		this.maintenancePerson = maintenancePerson;
	}

	public String getMaintenancePerson() {
		return this.maintenancePerson;
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

	public void setDutNumber(String dutNumber) {
		this.dutNumber = dutNumber;
	}

	public String getDutNumber() {
		return this.dutNumber;
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

	public void setAppearanceLevel(String appearanceLevel) {
		this.appearanceLevel = appearanceLevel;
	}

	public String getAppearanceLevel() {
		return this.appearanceLevel;
	}

	public void setNeedlePositionLevel(String needlePositionLevel) {
		this.needlePositionLevel = needlePositionLevel;
	}

	public String getNeedlePositionLevel() {
		return this.needlePositionLevel;
	}

	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}

	public String getStatusTime() {
		return this.statusTime;
	}

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
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

	public String getTipLongest() {
		return tipLongest;
	}

	public void setTipLongest(String tipLongest) {
		this.tipLongest = tipLongest;
	}

	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}

	public String getReturnPerson() {
		return this.returnPerson;
	}

	public void setTipMaximumDiameter(String tipMaximumDiameter) {
		this.tipMaximumDiameter = tipMaximumDiameter;
	}

	public String getTipMaximumDiameter() {
		return this.tipMaximumDiameter;
	}

	public void setProductNowModel(String productNowModel) {
		this.productNowModel = productNowModel;
	}

	public String getProductNowModel() {
		return this.productNowModel;
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

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public ProbeCardDTO getProbeCardDTO() {
		return probeCardDTO;
	}

	public void setProbeCardDTO(ProbeCardDTO probeCardDTO) {
		this.probeCardDTO = probeCardDTO;
	}

	public Long getProbeCardId() {
		return probeCardId;
	}

	public void setProbeCardId(Long probeCardId) {
		this.probeCardId = probeCardId;
	}

	public String getPlatformNo() {
		return platformNo;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
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
		ProbeCardOptionLogDTO other = (ProbeCardOptionLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class KitsDTO implements Serializable {

	private Long id;

	private int version;

	private Long touchTimeTotal;

	private String remark;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date inDate;

	private Date inDateEnd;

	private String applicableModels;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String lastFileUrl;

	private String partLocaltion;

	private String customerNameEn;

	private String supplier;

	private String customerName;

	private String manufacturerNo;

	private String equipmentList;

	private String partType;

	private String partNo;

	private String partName;

	private String productModel;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String partModel;

	private String appearanceLevel;

	private String equipmentListId;

	private Integer logic;

	private String lastModifyEmployNo;

	private String category;

	private String createEmployNo;

	private String ownership;

	private String manufacturerName;

	private String pn;

	private String nowProductModel;
	
	private String status;
	
	private Long statusId;
	
	private Long nowPlatformId;
	
	private String platform;
	
	private String statusIds;
	
	private Long platformId;
	
	private String platformStatus;
	
	private String platformNo;
	
	private String nowLot;
	
	private String nowStation;

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public String getStatusIds() {
		return statusIds;
	}

	public void setStatusIds(String statusIds) {
		this.statusIds = statusIds;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Long getNowPlatformId() {
		return nowPlatformId;
	}

	public void setNowPlatformId(Long nowPlatformId) {
		this.nowPlatformId = nowPlatformId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public void setTouchTimeTotal(Long touchTimeTotal) {
		this.touchTimeTotal = touchTimeTotal;
	}

	public Long getTouchTimeTotal() {
		return this.touchTimeTotal;
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

	public void setAppearanceLevel(String appearanceLevel) {
		this.appearanceLevel = appearanceLevel;
	}

	public String getAppearanceLevel() {
		return this.appearanceLevel;
	}

	public void setEquipmentListId(String equipmentListId) {
		this.equipmentListId = equipmentListId;
	}

	public String getEquipmentListId() {
		return this.equipmentListId;
	}

	public void setLogic(Integer logic) {
		this.logic = logic;
	}

	public Integer getLogic() {
		return this.logic;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlatformStatus() {
		return platformStatus;
	}

	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}

	public String getPlatformNo() {
		return platformNo;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
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
		KitsDTO other = (KitsDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
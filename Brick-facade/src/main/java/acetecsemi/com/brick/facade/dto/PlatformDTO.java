package acetecsemi.com.brick.facade.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonDateSerializer;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;
import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement()
public class PlatformDTO implements Serializable {

	private Long id;

	private int version;

	private String lastModifyEmployNo;

	private String platformCategory;

	private String platformNo;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String platformName;

	private String createEmployNo;

	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maintenanceStartDate;

	private Date maintenanceStartDateEnd;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkInTime;

	private Date checkInTimeEnd;

	private String equipmentIds;

	private List<String> equipmentNos;

	private List<EquipmentDTO> equipmentChildren = new ArrayList<EquipmentDTO>();

	// change platform status prop
	private String optUser;

	private Date optDate;

	private Date optDateEnd;

	private String grossDie;

	private String productModel;

	private String endOptUser;

	private String team;

	private Date endTime;

	private String standardWorkHours;

	private Long touchTimes;

	private String nowStation;

	private Date startTime;

	private Long duration;

	private String category;

	private String inkType;

	private String subStatus;

	private String optRemark;

	private String theoryTime;

	private String nowLot;

	private String isShift;
	// change platform status prop CP
	private String completedChip;// CP-完工片数
	private String completedChipDescription;// CP-完工片数详情
	private String chipSelection;// cp-片选
	private String chipSelectionRemark;// cp-片选备注
	private String pcNo;// CP-P/C编号

	// change platform status prop FT
	private Long lastTestNo;// FT-上状态测试数
	private Long nowTestNo;// FT-当前测试数

	private Long statusId;

	private Long subStatusId;

	private PlatformDTO platformDTO;

	private Long testerId;

	private String location;

	private String partIds;

	private Long testQty;

	private String pianxuan;

	private String pianxuanBeizhu;

	private String nowProduct;

	private String engTouchDown;

	private String acceptanceList; // PM保养文档

	private String touchDown;

	private String siteTestQty;

	private String waferTD;

	private String isJ750;

	private String ip;

	private String errorMsg;

	private Boolean isAuto;

	private String statusCode;

	private String loadBoardNo;

	private Long loadBoardId;

	private String kitsNo;

	private Long kitsId;

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}

	public void setPlatformCategory(String platformCategory) {
		this.platformCategory = platformCategory;
	}

	public String getPlatformCategory() {
		return this.platformCategory;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}

	public String getPlatformNo() {
		return this.platformNo;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@JsonSerialize(using = JsonTimestampSerializer.class)
	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestampEnd(Date createTimestampEnd) {
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getPlatformName() {
		return this.platformName;
	}

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate = maintenanceStartDate;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getMaintenanceStartDate() {
		return this.maintenanceStartDate;
	}

	public void setMaintenanceStartDateEnd(Date maintenanceStartDateEnd) {
		this.maintenanceStartDateEnd = maintenanceStartDateEnd;
	}

	public Date getMaintenanceStartDateEnd() {
		return this.maintenanceStartDateEnd;
	}

	public void setLastModifyTimestamp(Date lastModifyTimestamp) {
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	@JsonSerialize(using = JsonTimestampSerializer.class)
	public Date getLastModifyTimestamp() {
		return this.lastModifyTimestamp;
	}

	public void setLastModifyTimestampEnd(Date lastModifyTimestampEnd) {
		this.lastModifyTimestampEnd = lastModifyTimestampEnd;
	}

	public Date getLastModifyTimestampEnd() {
		return this.lastModifyTimestampEnd;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTimeEnd(Date checkInTimeEnd) {
		this.checkInTimeEnd = checkInTimeEnd;
	}

	public Date getCheckInTimeEnd() {
		return this.checkInTimeEnd;
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

	public String getEquipmentIds() {
		return equipmentIds;
	}

	public void setEquipmentIds(String equipmentIds) {
		this.equipmentIds = equipmentIds;
	}

	public List<String> getEquipmentNos() {
		return equipmentNos;
	}

	public void setEquipmentNos(List<String> equipmentNos) {
		this.equipmentNos = equipmentNos;
	}

	public List<EquipmentDTO> getEquipmentChildren() {
		return equipmentChildren;
	}

	public void setEquipmentChildren(List<EquipmentDTO> equipmentChildren) {
		this.equipmentChildren = equipmentChildren;
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

	public Date getOptDateEnd() {
		return optDateEnd;
	}

	public void setOptDateEnd(Date optDateEnd) {
		this.optDateEnd = optDateEnd;
	}

	public String getGrossDie() {
		return grossDie;
	}

	public void setGrossDie(String grossDie) {
		this.grossDie = grossDie;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getEndOptUser() {
		return endOptUser;
	}

	public void setEndOptUser(String endOptUser) {
		this.endOptUser = endOptUser;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStandardWorkHours() {
		return standardWorkHours;
	}

	public void setStandardWorkHours(String standardWorkHours) {
		this.standardWorkHours = standardWorkHours;
	}

	public Long getTouchTimes() {
		return touchTimes;
	}

	public void setTouchTimes(Long touchTimes) {
		this.touchTimes = touchTimes;
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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInkType() {
		return inkType;
	}

	public void setInkType(String inkType) {
		this.inkType = inkType;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getOptRemark() {
		return optRemark;
	}

	public void setOptRemark(String optRemark) {
		this.optRemark = optRemark;
	}

	public String getTheoryTime() {
		return theoryTime;
	}

	public void setTheoryTime(String theoryTime) {
		this.theoryTime = theoryTime;
	}

	public String getNowLot() {
		return nowLot;
	}

	public void setNowLot(String nowLot) {
		this.nowLot = nowLot;
	}

	public String getIsShift() {
		return isShift;
	}

	public void setIsShift(String isShift) {
		this.isShift = isShift;
	}

	public String getCompletedChip() {
		return completedChip;
	}

	public void setCompletedChip(String completedChip) {
		this.completedChip = completedChip;
	}

	public String getCompletedChipDescription() {
		return completedChipDescription;
	}

	public void setCompletedChipDescription(String completedChipDescription) {
		this.completedChipDescription = completedChipDescription;
	}

	public String getChipSelection() {
		return chipSelection;
	}

	public void setChipSelection(String chipSelection) {
		this.chipSelection = chipSelection;
	}

	public String getChipSelectionRemark() {
		return chipSelectionRemark;
	}

	public void setChipSelectionRemark(String chipSelectionRemark) {
		this.chipSelectionRemark = chipSelectionRemark;
	}

	public String getPcNo() {
		return pcNo;
	}

	public void setPcNo(String pcNo) {
		this.pcNo = pcNo;
	}

	public Long getLastTestNo() {
		return lastTestNo;
	}

	public void setLastTestNo(Long lastTestNo) {
		this.lastTestNo = lastTestNo;
	}

	public Long getNowTestNo() {
		return nowTestNo;
	}

	public void setNowTestNo(Long nowTestNo) {
		this.nowTestNo = nowTestNo;
	}

	public PlatformDTO getPlatformDTO() {
		return platformDTO;
	}

	public void setPlatformDTO(PlatformDTO platformDTO) {
		this.platformDTO = platformDTO;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getSubStatusId() {
		return subStatusId;
	}

	public void setSubStatusId(Long subStatusId) {
		this.subStatusId = subStatusId;
	}

	public Long getTesterId() {
		return testerId;
	}

	public void setTesterId(Long testerId) {
		this.testerId = testerId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPartIds() {
		return partIds;
	}

	public void setPartIds(String partIds) {
		this.partIds = partIds;
	}

	public Long getTestQty() {
		return testQty;
	}

	public void setTestQty(Long testQty) {
		this.testQty = testQty;
	}

	public String getPianxuan() {
		return pianxuan;
	}

	public void setPianxuan(String pianxuan) {
		this.pianxuan = pianxuan;
	}

	public String getPianxuanBeizhu() {
		return pianxuanBeizhu;
	}

	public void setPianxuanBeizhu(String pianxuanBeizhu) {
		this.pianxuanBeizhu = pianxuanBeizhu;
	}

	public String getNowProduct() {
		return nowProduct;
	}

	public void setNowProduct(String nowProduct) {
		this.nowProduct = nowProduct;
	}

	public String getEngTouchDown() {
		return engTouchDown;
	}

	public void setEngTouchDown(String engTouchDown) {
		this.engTouchDown = engTouchDown;
	}

	public String getAcceptanceList() {
		return acceptanceList;
	}

	public void setAcceptanceList(String acceptanceList) {
		this.acceptanceList = acceptanceList;
	}

	public String getTouchDown() {
		return touchDown;
	}

	public void setTouchDown(String touchDown) {
		this.touchDown = touchDown;
	}

	public String getSiteTestQty() {
		return siteTestQty;
	}

	public void setSiteTestQty(String siteTestQty) {
		this.siteTestQty = siteTestQty;
	}

	public String getWaferTD() {
		return waferTD;
	}

	public void setWaferTD(String waferTD) {
		this.waferTD = waferTD;
	}

	public String getIsJ750() {
		return isJ750;
	}

	public void setIsJ750(String isJ750) {
		this.isJ750 = isJ750;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Boolean getIsAuto() {
		return isAuto;
	}

	public void setIsAuto(Boolean isAuto) {
		this.isAuto = isAuto;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getLoadBoardNo() {
		return loadBoardNo;
	}

	public void setLoadBoardNo(String loadBoardNo) {
		this.loadBoardNo = loadBoardNo;
	}

	public String getKitsNo() {
		return kitsNo;
	}

	public void setKitsNo(String kitsNo) {
		this.kitsNo = kitsNo;
	}

	public Long getLoadBoardId() {
		return loadBoardId;
	}

	public void setLoadBoardId(Long loadBoardId) {
		this.loadBoardId = loadBoardId;
	}

	public Long getKitsId() {
		return kitsId;
	}

	public void setKitsId(Long kitsId) {
		this.kitsId = kitsId;
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
		PlatformDTO other = (PlatformDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonDateSerializer;
import org.openkoala.koala.springmvc.JsonTimestampSerializer;

public class EquipmentDTO implements Serializable {

	private Long id;

	private int version;

	private String acceptanceList;

	private String responsible;

	private String status;

	private String calibrationCycle;

	private String equipmentCategory;

	private Date maintenanceStartDate;

	private Date maintenanceStartDateEnd;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String equipmentLocation;

	private String agent;

	private Date checkInTime;

	private Date checkInTimeEnd;

	private String lastModifyEmployNo;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String equipmentName;

	private String repairCycle;

	private String repairCycleWeek;

	private String repairCycleMonth;
	
	private String repairCycleSeason;

	private String repairCycleYear;

	private Date nextMaintenanceDate;

	private String category;

	private String createEmployNo;

	private String equipmentNo;

	private Boolean composability;// 是否可组装

	private Long categoryId;

	private Long equipmentLocationId;

	private Long equipmentCategoryId;

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
	private String standardWorkHours;// 标准工时
	private String grossDie;// GROSSDIE
	private String theoryTime;// 理论时间
	private String inkType;// ink类型
	private Long touchTimes;// 接触次数
	private String team;// 班次
	private String isShift; // 交接班
	private String optRemark;// 操作备注

	private String productNo;
	
	private Long statusId;
	
	private Long subStatusId;
	
	private Boolean isInstalled;

	private Boolean UnInstallTester;
	
	private String nowMaintenancePlanDate;//YYYY:MM:DD-月|YYYY:MM:DD-季|YYYY:MM:DD-年
	
	private String nextMaintenancePlanDate;//YYYY:MM:DD-月|YYYY:MM:DD-季|YYYY:MM:DD-年
	
	private String completedChip;// INK-完工片数
	private String completedChipDescription;// INK-完工片数详情
	private String chipSelection;// INK-片选
	private String chipSelectionRemark;// INK-片选备注
	
	private String pianxuan;// INK-片选备注
	private String pianxuanBeizhu;// INK-片选备注
	
	private String nowProduct;
	
	private String categoryImageUrl;
	
	private String sn;
	
	private String pmType;
	
	private Long equipmentMaintenanceLogId;
	
	private String ip;
	
	private String cpCompletedNum;
	
	private Boolean isAuto;
	
	public Boolean getUnInstallTester() {
		return UnInstallTester;
	}

	public void setUnInstallTester(Boolean unInstallTester) {
		UnInstallTester = unInstallTester;
	}

	public void setAcceptanceList(String acceptanceList) {
		this.acceptanceList = acceptanceList;
	}

	public String getAcceptanceList() {
		return this.acceptanceList;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getResponsible() {
		return this.responsible;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setCalibrationCycle(String calibrationCycle) {
		this.calibrationCycle = calibrationCycle;
	}

	public String getCalibrationCycle() {
		return this.calibrationCycle;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public String getEquipmentCategory() {
		return this.equipmentCategory;
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

	public void setEquipmentLocation(String equipmentLocation) {
		this.equipmentLocation = equipmentLocation;
	}

	public String getEquipmentLocation() {
		return this.equipmentLocation;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAgent() {
		return this.agent;
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

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
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

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setRepairCycle(String repairCycle) {
		this.repairCycle = repairCycle;
	}

	public String getRepairCycle() {
		return this.repairCycle;
	}

	public String getRepairCycleWeek() {
		return repairCycleWeek;
	}

	public void setRepairCycleWeek(String repairCycleWeek) {
		this.repairCycleWeek = repairCycleWeek;
	}

	public String getRepairCycleMonth() {
		return repairCycleMonth;
	}

	public void setRepairCycleMonth(String repairCycleMonth) {
		this.repairCycleMonth = repairCycleMonth;
	}

	public String getRepairCycleSeason() {
		return repairCycleSeason;
	}

	public void setRepairCycleSeason(String repairCycleSeason) {
		this.repairCycleSeason = repairCycleSeason;
	}

	public String getRepairCycleYear() {
		return repairCycleYear;
	}

	public void setRepairCycleYear(String repairCycleYear) {
		this.repairCycleYear = repairCycleYear;
	}

	public Date getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}

	public void setNextMaintenanceDate(Date nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
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

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public String getEquipmentNo() {
		return this.equipmentNo;
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

	public Boolean getComposability() {
		return composability;
	}

	public void setComposability(Boolean composability) {
		this.composability = composability;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getEquipmentLocationId() {
		return equipmentLocationId;
	}

	public void setEquipmentLocationId(Long equipmentLocationId) {
		this.equipmentLocationId = equipmentLocationId;
	}

	public Long getEquipmentCategoryId() {
		return equipmentCategoryId;
	}

	public void setEquipmentCategoryId(Long equipmentCategoryId) {
		this.equipmentCategoryId = equipmentCategoryId;
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

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	public Boolean getIsInstalled() {
		return isInstalled;
	}

	public void setIsInstalled(Boolean isInstalled) {
		this.isInstalled = isInstalled;
	}

	public String getNowMaintenancePlanDate() {
		return nowMaintenancePlanDate;
	}

	public void setNowMaintenancePlanDate(String nowMaintenancePlanDate) {
		this.nowMaintenancePlanDate = nowMaintenancePlanDate;
	}

	public String getNextMaintenancePlanDate() {
		return nextMaintenancePlanDate;
	}

	public void setNextMaintenancePlanDate(String nextMaintenancePlanDate) {
		this.nextMaintenancePlanDate = nextMaintenancePlanDate;
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

	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}

	public void setCategoryImageUrl(String categoryImageUrl) {
		this.categoryImageUrl = categoryImageUrl;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPmType() {
		return pmType;
	}

	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	public Long getEquipmentMaintenanceLogId() {
		return equipmentMaintenanceLogId;
	}

	public void setEquipmentMaintenanceLogId(Long equipmentMaintenanceLogId) {
		this.equipmentMaintenanceLogId = equipmentMaintenanceLogId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCpCompletedNum() {
		return cpCompletedNum;
	}

	public void setCpCompletedNum(String cpCompletedNum) {
		this.cpCompletedNum = cpCompletedNum;
	}

	public Boolean getIsAuto() {
		return isAuto;
	}

	public void setIsAuto(Boolean isAuto) {
		this.isAuto = isAuto;
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
		EquipmentDTO other = (EquipmentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
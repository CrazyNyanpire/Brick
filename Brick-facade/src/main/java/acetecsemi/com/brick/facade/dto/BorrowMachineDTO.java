package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class BorrowMachineDTO implements Serializable {

	private Long id;

	private int version;

	private String equipName;

	private String remark;

	private String department;

	private String approver;

	private String state;

	private String proposer;

	private String borrowNumber;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String type;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date actualBeginTime;

	private Date actualBeginTimeEnd;

	private String lastModifyEmployNo;

	private String estimatedTime;

	private Date createTimestamp;

	private Date createTimestampEnd;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date estimatedEndTime;

	private Date estimatedEndTimeEnd;

	private String createEmployNo;

	private String actualTime;

	private String company;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date estimatedStartTime;

	private Date estimatedStartTimeEnd;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date actualEndTime;

	private Date actualEndTimeEnd;

	@DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
	private Date appTime;

	private Date appTimeEnd;

	private Long platformId;

	private String platformName;

	private Long statusId;

	private Long subStatusId;

	private Boolean isPlatform;

	private String platformEquipId;

	private String acceptanceList;

	private Long testQty;

	private String grossDie;

	private String standardWorkHours;

	private String team;

	private String touchdown;
	private String nowStationPrv;
	private String nowLotPrv;
	private String nowProductPrv;
	private String nowStation;
	private String nowLot;
	private String nowProduct;
	private String optRemark;
	private String beforeTestQty;
	private String partIds;

	private String pianxuan;
	private String pianxuanBeizhu;

	private String pmType;

	private String siteTestQty;

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getEquipName() {
		return this.equipName;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApprover() {
		return this.approver;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getProposer() {
		return this.proposer;
	}

	public void setBorrowNumber(String borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public String getBorrowNumber() {
		return this.borrowNumber;
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

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setActualBeginTime(Date actualBeginTime) {
		this.actualBeginTime = actualBeginTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getActualBeginTime() {
		return this.actualBeginTime;
	}

	public void setActualBeginTimeEnd(Date actualBeginTimeEnd) {
		this.actualBeginTimeEnd = actualBeginTimeEnd;
	}

	public Date getActualBeginTimeEnd() {
		return this.actualBeginTimeEnd;
	}

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public String getEstimatedTime() {
		return this.estimatedTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
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

	public void setEstimatedEndTime(Date estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEstimatedEndTime() {
		return this.estimatedEndTime;
	}

	public void setEstimatedEndTimeEnd(Date estimatedEndTimeEnd) {
		this.estimatedEndTimeEnd = estimatedEndTimeEnd;
	}

	public Date getEstimatedEndTimeEnd() {
		return this.estimatedEndTimeEnd;
	}

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setActualTime(String actualTime) {
		this.actualTime = actualTime;
	}

	public String getActualTime() {
		return this.actualTime;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return this.company;
	}

	public void setEstimatedStartTime(Date estimatedStartTime) {
		this.estimatedStartTime = estimatedStartTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEstimatedStartTime() {
		return this.estimatedStartTime;
	}

	public void setEstimatedStartTimeEnd(Date estimatedStartTimeEnd) {
		this.estimatedStartTimeEnd = estimatedStartTimeEnd;
	}

	public Date getEstimatedStartTimeEnd() {
		return this.estimatedStartTimeEnd;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getActualEndTime() {
		return this.actualEndTime;
	}

	public void setActualEndTimeEnd(Date actualEndTimeEnd) {
		this.actualEndTimeEnd = actualEndTimeEnd;
	}

	public Date getActualEndTimeEnd() {
		return this.actualEndTimeEnd;
	}

	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAppTime() {
		return this.appTime;
	}

	public void setAppTimeEnd(Date appTimeEnd) {
		this.appTimeEnd = appTimeEnd;
	}

	public Date getAppTimeEnd() {
		return this.appTimeEnd;
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

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
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

	public Boolean getIsPlatform() {
		return isPlatform;
	}

	public void setIsPlatform(Boolean isPlatform) {
		this.isPlatform = isPlatform;
	}

	public String getPlatformEquipId() {
		return platformEquipId;
	}

	public void setPlatformEquipId(String platformEquipId) {
		this.platformEquipId = platformEquipId;
	}

	public String getAcceptanceList() {
		return acceptanceList;
	}

	public void setAcceptanceList(String acceptanceList) {
		this.acceptanceList = acceptanceList;
	}

	public Long getTestQty() {
		return testQty;
	}

	public void setTestQty(Long testQty) {
		this.testQty = testQty;
	}

	public String getGrossDie() {
		return grossDie;
	}

	public void setGrossDie(String grossDie) {
		this.grossDie = grossDie;
	}

	public String getStandardWorkHours() {
		return standardWorkHours;
	}

	public void setStandardWorkHours(String standardWorkHours) {
		this.standardWorkHours = standardWorkHours;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTouchdown() {
		return touchdown;
	}

	public void setTouchdown(String touchdown) {
		this.touchdown = touchdown;
	}

	public String getNowStationPrv() {
		return nowStationPrv;
	}

	public void setNowStationPrv(String nowStationPrv) {
		this.nowStationPrv = nowStationPrv;
	}

	public String getNowLotPrv() {
		return nowLotPrv;
	}

	public void setNowLotPrv(String nowLotPrv) {
		this.nowLotPrv = nowLotPrv;
	}

	public String getNowProductPrv() {
		return nowProductPrv;
	}

	public void setNowProductPrv(String nowProductPrv) {
		this.nowProductPrv = nowProductPrv;
	}

	public String getNowStation() {
		return nowStation;
	}

	public void setNowStation(String nowStation) {
		this.nowStation = nowStation;
	}

	public String getNowLot() {
		return nowLot;
	}

	public void setNowLot(String nowLot) {
		this.nowLot = nowLot;
	}

	public String getNowProduct() {
		return nowProduct;
	}

	public void setNowProduct(String nowProduct) {
		this.nowProduct = nowProduct;
	}

	public String getOptRemark() {
		return optRemark;
	}

	public void setOptRemark(String optRemark) {
		this.optRemark = optRemark;
	}

	public String getBeforeTestQty() {
		return beforeTestQty;
	}

	public void setBeforeTestQty(String beforeTestQty) {
		this.beforeTestQty = beforeTestQty;
	}

	public String getPartIds() {
		return partIds;
	}

	public void setPartIds(String partIds) {
		this.partIds = partIds;
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

	public String getPmType() {
		return pmType;
	}

	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	public String getSiteTestQty() {
		return siteTestQty;
	}

	public void setSiteTestQty(String siteTestQty) {
		this.siteTestQty = siteTestQty;
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
		BorrowMachineDTO other = (BorrowMachineDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonDateSerializer;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class PlatformOptionLogDTO implements Serializable {

	private Long id;

	private int version;

	private String optUser;

	private Date optDate;

	private Date optDateEnd;

	private String grossDie;

	private String status;

	private String productModel;

	private String endOptUser;

	private String team;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private Date endTime;

	private String standardWorkHours;

	private Long touchTimes;

	private String nowStation;

	private String lastModifyEmployNo;

	private Date startTime;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String duration;

	private String category;

	private String createEmployNo;

	private String inkType;

	private String subStatus;

	private String optRemark;

	private String theoryTime;

	private String nowLot;

	private String isShift;

	private String categoryPlatform;

	private Long platformId;

	private String platformNo;

	private String platformName;

	private String completedChip;// CP-完工片数
	private String completedChipDescription;// CP-完工片数详情
	private String chipSelection;// cp-片选
	private String chipSelectionRemark;// cp-片选备注
	private String pcNo;// CP-P/C编号

	private Long lastTestNo;// FT-上状态测试数
	private Long nowTestNo;// FT-当前测试数

	private String chipSelectionSingle;

	private String nowProduct;

	private String partIds;

	private String siteTestQty;

	private String lastSiteTestQty;// FT-上状态测试数

	private String nowSiteTestQty;// FT-当前测试数

	private String cpCompletedNum;

	private String nowWaferTD;

	private String lastWaferTD;

	private String errorMsg;
	
	private Long kitsId;
	
	private Long loadBoardId;

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	public void setOptUser(String optUser) {
		this.optUser = optUser;
	}

	public String getOptUser() {
		return this.optUser;
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

	public void setGrossDie(String grossDie) {
		this.grossDie = grossDie;
	}

	public String getGrossDie() {
		return this.grossDie;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductModel() {
		return this.productModel;
	}

	public void setEndOptUser(String endOptUser) {
		this.endOptUser = endOptUser;
	}

	public String getEndOptUser() {
		return this.endOptUser;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return this.team;
	}

	public void setLastModifyTimestamp(Date lastModifyTimestamp) {
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
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

	public void setStandardWorkHours(String standardWorkHours) {
		this.standardWorkHours = standardWorkHours;
	}

	public String getStandardWorkHours() {
		return this.standardWorkHours;
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

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDuration() {
		return this.duration;
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

	public void setInkType(String inkType) {
		this.inkType = inkType;
	}

	public String getInkType() {
		return this.inkType;
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

	public void setTheoryTime(String theoryTime) {
		this.theoryTime = theoryTime;
	}

	public String getTheoryTime() {
		return this.theoryTime;
	}

	public void setNowLot(String nowLot) {
		this.nowLot = nowLot;
	}

	public String getNowLot() {
		return this.nowLot;
	}

	public void setIsShift(String isShift) {
		this.isShift = isShift;
	}

	public String getIsShift() {
		return this.isShift;
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

	public String getCategoryPlatform() {
		return categoryPlatform;
	}

	public void setCategoryPlatform(String categoryPlatform) {
		this.categoryPlatform = categoryPlatform;
	}

	public String getPlatformNo() {
		return platformNo;
	}

	public void setPlatformNo(String platformNo) {
		this.platformNo = platformNo;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
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

	public String getChipSelectionSingle() {
		return chipSelectionSingle;
	}

	public void setChipSelectionSingle(String chipSelectionSingle) {
		this.chipSelectionSingle = chipSelectionSingle;
	}

	public String getNowProduct() {
		return nowProduct;
	}

	public void setNowProduct(String nowProduct) {
		this.nowProduct = nowProduct;
	}

	public String getPartIds() {
		return partIds;
	}

	public void setPartIds(String partIds) {
		this.partIds = partIds;
	}

	public String getSiteTestQty() {
		return siteTestQty;
	}

	public void setSiteTestQty(String siteTestQty) {
		this.siteTestQty = siteTestQty;
	}

	public String getLastSiteTestQty() {
		return lastSiteTestQty;
	}

	public void setLastSiteTestQty(String lastSiteTestQty) {
		this.lastSiteTestQty = lastSiteTestQty;
	}

	public String getNowSiteTestQty() {
		return nowSiteTestQty;
	}

	public void setNowSiteTestQty(String nowSiteTestQty) {
		this.nowSiteTestQty = nowSiteTestQty;
	}

	public String getCpCompletedNum() {
		return cpCompletedNum;
	}

	public void setCpCompletedNum(String cpCompletedNum) {
		this.cpCompletedNum = cpCompletedNum;
	}

	public String getNowWaferTD() {
		return nowWaferTD;
	}

	public void setNowWaferTD(String nowWaferTD) {
		this.nowWaferTD = nowWaferTD;
	}

	public String getLastWaferTD() {
		return lastWaferTD;
	}

	public void setLastWaferTD(String lastWaferTD) {
		this.lastWaferTD = lastWaferTD;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Long getKitsId() {
		return kitsId;
	}

	public void setKitsId(Long kitsId) {
		this.kitsId = kitsId;
	}

	public Long getLoadBoardId() {
		return loadBoardId;
	}

	public void setLoadBoardId(Long loadBoardId) {
		this.loadBoardId = loadBoardId;
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
		PlatformOptionLogDTO other = (PlatformOptionLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
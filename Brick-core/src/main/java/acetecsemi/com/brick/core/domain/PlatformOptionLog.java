package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openkoala.security.core.domain.User;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@DiscriminatorValue("PLATFORM")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORYPLATFORM", discriminatorType = DiscriminatorType.STRING)
public class PlatformOptionLog extends StatusOptionLog{
	
	@Column(name = "CATEGORYPLATFORM", insertable = false, updatable = false)
	private String categoryPlatform;
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PLATFORM_ID", referencedColumnName = "ID")
	private Platform platform;
	
	private String completedChip;// CP-完工片数
	private String completedChipDescription;// CP-完工片数详情
	private String chipSelection;// cp-片选
	private String chipSelectionRemark;// cp-片选备注
	private String pcNo;// CP-P/C编号
	
	private Long lastTestNo;// FT-上状态测试数
	private Long nowTestNo;// FT-当前测试数
	
	private String partIds;
	
	private String siteTestQty;
	
	private String lastSiteTestQty;// FT-上状态测试数
	
	private String nowSiteTestQty;// FT-当前测试数
	
	private String engTouchDown;
	
	private String lastWaferTD;
	
	private String nowWaferTD;
	
	private String loadBoardNo;
	
	private String kitsNo;
	
	private Long kitsId;
	
	private Long loadBoardId;

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

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getCategoryPlatform() {
		return categoryPlatform;
	}

	public void setCategoryPlatform(String categoryPlatform) {
		this.categoryPlatform = categoryPlatform;
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

	public String getPartIds() {
		return partIds;
	}

	public void setPartIds(String partIds) {
		this.partIds = partIds;
	}

	public String getEngTouchDown() {
		return engTouchDown;
	}

	public void setEngTouchDown(String engTouchDown) {
		this.engTouchDown = engTouchDown;
	}

	public String getLastWaferTD() {
		return lastWaferTD;
	}

	public void setLastWaferTD(String lastWaferTD) {
		this.lastWaferTD = lastWaferTD;
	}

	public String getNowWaferTD() {
		return nowWaferTD;
	}

	public void setNowWaferTD(String nowWaferTD) {
		this.nowWaferTD = nowWaferTD;
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

}
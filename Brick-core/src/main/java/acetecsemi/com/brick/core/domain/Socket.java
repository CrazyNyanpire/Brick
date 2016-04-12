package acetecsemi.com.brick.core.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 10-04-2015 15:27:10
 */
@Entity
@DiscriminatorValue("SOCKET")
public class Socket extends Part {

	/**
	 * 
	 */
	private static final long serialVersionUID = 910508009920703970L;
	
	private String pn;//PN或者SN
	
	private String pinModels;//pin型号
	
	private String supplier;//供应商
	
	private Integer qty;//数量？
	
	private Integer pinQty;//pin数量
	
	private String applicableModels;//可使用机型
	
	private String lastFileUrl; 
	
	private Long touchTimeTotal;
	
	private String appearanceLevel;
	
	private Long touchTime;
	
	private Integer platformSite;//site 0\1\2\3
	
	private String equipmentListId;
	
	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getPinModels() {
		return pinModels;
	}

	public void setPinModels(String pinModels) {
		this.pinModels = pinModels;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getPinQty() {
		return pinQty;
	}

	public void setPinQty(Integer pinQty) {
		this.pinQty = pinQty;
	}

	public String getApplicableModels() {
		return applicableModels;
	}

	public void setApplicableModels(String applicableModels) {
		this.applicableModels = applicableModels;
	}

	public String getLastFileUrl() {
		return lastFileUrl;
	}

	public void setLastFileUrl(String lastFileUrl) {
		this.lastFileUrl = lastFileUrl;
	}

	public Long getTouchTimeTotal() {
		return touchTimeTotal;
	}

	public void setTouchTimeTotal(Long touchTimeTotal) {
		this.touchTimeTotal = touchTimeTotal;
	}

	public String getAppearanceLevel() {
		return appearanceLevel;
	}

	public void setAppearanceLevel(String appearanceLevel) {
		this.appearanceLevel = appearanceLevel;
	}

	public Long getTouchTime() {
		return touchTime;
	}

	public void setTouchTime(Long touchTime) {
		this.touchTime = touchTime;
	}

	public Integer getPlatformSite() {
		return platformSite;
	}

	public void setPlatformSite(Integer platformSite) {
		this.platformSite = platformSite;
	}

	public String getEquipmentListId() {
		return equipmentListId;
	}

	public void setEquipmentListId(String equipmentListId) {
		this.equipmentListId = equipmentListId;
	}


	
//	private Set<Pin> pins;
//
//	public Set<Pin> getPins() {
//		return pins;
//	}
//
//	public void setPins(Set<Pin> pins) {
//		this.pins = pins;
//	}

}
package acetecsemi.com.brick.core.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author harlow
 * @version 1.0
 * @created 10-04-2015 15:27:10
 */
@Entity
@DiscriminatorValue("Kits")
public class Kits extends Part {

	/**
	 * 
	 */
	private static final long serialVersionUID = 910508009920703970L;
	
	private String pn;//PN或者SN
	
	private String supplier;//供应商
	
	private String applicableModels;//可使用机型
	
	private String lastFileUrl; 
	
	private Long touchTimeTotal;
	
	private String appearanceLevel;
	
	private String equipmentListId;
	
	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public String getEquipmentListId() {
		return equipmentListId;
	}

	public void setEquipmentListId(String equipmentListId) {
		this.equipmentListId = equipmentListId;
	}
}
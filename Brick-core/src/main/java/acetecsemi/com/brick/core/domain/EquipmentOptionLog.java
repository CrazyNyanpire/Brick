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
 * @created 31-03-2015 15:27:09
 */
@Entity
@DiscriminatorValue("EQUIPMENT")
public class EquipmentOptionLog extends StatusOptionLog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9008831588443558010L;
	
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "ID")
	private Equipment equipment;
	
	private String completedChip;// INK-完工片数
	private String completedChipDescription;// INK-完工片数详情
	private String chipSelection;// INK-片选
	private String chipSelectionRemark;// INK-片选备注
	
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
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
	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),this.getCreateTimestamp().toString()};
	}
}
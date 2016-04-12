package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hallow
 * @version 1.0
 * @created 27-05-2015 09:27:09
 */
@Entity
@Table(name = "BRICK_PMDocument")
public class PMDocument extends BrickAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5070144169262924174L;

	private String fileName;

	private String fileUrl;

	private Date uploadDate;

	private String uploadUser;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "equipmentOptionLog_ID", referencedColumnName = "ID")
	private EquipmentOptionLog equipmentOptionLog;

	private String pmType;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "equipmentMaintenanceLog_ID", referencedColumnName = "ID")
	private EquipmentMaintenanceLog equipmentMaintenanceLog;

	private String qreOptUser;
	
	private Date qreOptDate;

	private String eeOptUser;
	
	private Date eeOptDate;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public EquipmentOptionLog getEquipmentOptionLog() {
		return equipmentOptionLog;
	}

	public void setEquipmentOptionLog(EquipmentOptionLog equipmentOptionLog) {
		this.equipmentOptionLog = equipmentOptionLog;
	}

	public String getPmType() {
		return pmType;
	}

	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	public EquipmentMaintenanceLog getEquipmentMaintenanceLog() {
		return equipmentMaintenanceLog;
	}

	public void setEquipmentMaintenanceLog(
			EquipmentMaintenanceLog equipmentMaintenanceLog) {
		this.equipmentMaintenanceLog = equipmentMaintenanceLog;
	}

	public String getQreOptUser() {
		return qreOptUser;
	}

	public void setQreOptUser(String qreOptUser) {
		this.qreOptUser = qreOptUser;
	}

	public Date getQreOptDate() {
		return qreOptDate;
	}

	public void setQreOptDate(Date qreOptDate) {
		this.qreOptDate = qreOptDate;
	}

	public String getEeOptUser() {
		return eeOptUser;
	}

	public void setEeOptUser(String eeOptUser) {
		this.eeOptUser = eeOptUser;
	}

	public Date getEeOptDate() {
		return eeOptDate;
	}

	public void setEeOptDate(Date eeOptDate) {
		this.eeOptDate = eeOptDate;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}

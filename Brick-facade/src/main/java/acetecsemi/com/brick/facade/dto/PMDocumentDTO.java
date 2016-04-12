package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class PMDocumentDTO implements Serializable {

	private Long id;

	private int version;

	private String lastModifyEmployNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTimestamp;

	private Date createTimestampEnd;

	private String createEmployNo;

	private String fileName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String uploadUser;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date uploadDate;

	private Date uploadDateEnd;

	private String fileUrl;
	
	private String equipmentNo;
	
	private String qreOptUser;
	
	private Date qreOptDate;

	private String eeOptUser;
	
	private Date eeOptDate;
	
	private String signType;
	
	private String isPass;

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
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

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
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

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public String getUploadUser() {
		return this.uploadUser;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDateEnd(Date uploadDateEnd) {
		this.uploadDateEnd = uploadDateEnd;
	}

	public Date getUploadDateEnd() {
		return this.uploadDateEnd;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() {
		return this.fileUrl;
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

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
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

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
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
		PMDocumentDTO other = (PMDocumentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
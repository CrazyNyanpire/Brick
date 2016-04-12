package acetecsemi.com.brick.core.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.openkoala.koala.commons.domain.KoalaAbstractEntity;

/**
 * @author harlow
 * @version 1.0
 * @created 17-03-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_FileUpload")
public class FileUpload extends KoalaAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4413017609389965410L;

	private String localPath; // 上传本地路径

	private String ip; // 文件服务器地址

	private String port; // 文件服务器端口号

	private String netPath; // 下载网络路径

	private Long maxSize; // 文件大小

	private String fileTypes;// 文件类型用“,”隔开

	private String type;// 文件种类

	private String description;// 描述

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getNetPath() {
		return netPath;
	}

	public void setNetPath(String netPath) {
		this.netPath = netPath;
	}

	public Long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(Long maxSize) {
		this.maxSize = maxSize;
	}

	public String getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(String fileTypes) {
		this.fileTypes = fileTypes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((fileTypes == null) ? 0 : fileTypes.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result
				+ ((localPath == null) ? 0 : localPath.hashCode());
		result = prime * result + ((maxSize == null) ? 0 : maxSize.hashCode());
		result = prime * result + ((netPath == null) ? 0 : netPath.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		FileUpload other = (FileUpload) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fileTypes == null) {
			if (other.fileTypes != null)
				return false;
		} else if (!fileTypes.equals(other.fileTypes))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (localPath == null) {
			if (other.localPath != null)
				return false;
		} else if (!localPath.equals(other.localPath))
			return false;
		if (maxSize == null) {
			if (other.maxSize != null)
				return false;
		} else if (!maxSize.equals(other.maxSize))
			return false;
		if (netPath == null) {
			if (other.netPath != null)
				return false;
		} else if (!netPath.equals(other.netPath))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getNetPath().toString() };
	}

}

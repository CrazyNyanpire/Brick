package acetecsemi.com.brick.facade.dto;

import java.io.Serializable;

public class FileUploadDTO implements Serializable {

	private Long id;

	private int version;

			
		private String port;
		
				
		private String fileTypes;
		
				
		private String description;
		
				
		private String localPath;
		
				
		private String type;
		
				
		private Long maxSize;
		
				
		private String netPath;
		
				
		private String ip;
		
			
	
	public void setPort(String port) { 
		this.port = port;
	}

	public String getPort() {
		return this.port;
	}
		
			
	
	public void setFileTypes(String fileTypes) { 
		this.fileTypes = fileTypes;
	}

	public String getFileTypes() {
		return this.fileTypes;
	}
		
			
	
	public void setDescription(String description) { 
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
		
			
	
	public void setLocalPath(String localPath) { 
		this.localPath = localPath;
	}

	public String getLocalPath() {
		return this.localPath;
	}
		
			
	
	public void setType(String type) { 
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
		
			
	
	public void setMaxSize(Long maxSize) { 
		this.maxSize = maxSize;
	}

	public Long getMaxSize() {
		return this.maxSize;
	}
		
			
	
	public void setNetPath(String netPath) { 
		this.netPath = netPath;
	}

	public String getNetPath() {
		return this.netPath;
	}
		
			
	
	public void setIp(String ip) { 
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
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
		FileUploadDTO other = (FileUploadDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
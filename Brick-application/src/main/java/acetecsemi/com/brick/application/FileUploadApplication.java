package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.FileUpload;

public interface FileUploadApplication {

	public FileUpload getFileUpload(Long id);
	
	public void creatFileUpload(FileUpload fileUpload);
	
	public void updateFileUpload(FileUpload fileUpload);
	
	public void removeFileUpload(FileUpload fileUpload);
	
	public void removeFileUploads(Set<FileUpload> fileUploads);
	
	public List<FileUpload> findAllFileUpload();
	
}


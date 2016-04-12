package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.FileUploadApplication;
import acetecsemi.com.brick.core.domain.FileUpload;

@Named
@Transactional
public class FileUploadApplicationImpl implements FileUploadApplication {

	public FileUpload getFileUpload(Long id) {
		return FileUpload.get(FileUpload.class, id);
	}
	
	public void creatFileUpload(FileUpload fileUpload) {
		fileUpload.save();
	}
	
	public void updateFileUpload(FileUpload fileUpload) {
		fileUpload .save();
	}
	
	public void removeFileUpload(FileUpload fileUpload) {
		if(fileUpload != null){
			fileUpload.remove();
		}
	}
	
	public void removeFileUploads(Set<FileUpload> fileUploads) {
		for (FileUpload fileUpload : fileUploads) {
			fileUpload.remove();
		}
	}
	
	public List<FileUpload> findAllFileUpload() {
		return FileUpload.findAll(FileUpload.class);
	}
	
}

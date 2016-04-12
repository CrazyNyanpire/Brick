package acetecsemi.com.brick.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface FileUploadFacade {

	public FileUploadDTO getFileUpload(Long id);
	
	public InvokeResult creatFileUpload(FileUploadDTO fileUpload);
	
	public InvokeResult updateFileUpload(FileUploadDTO fileUpload);
	
	public InvokeResult removeFileUpload(Long id);
	
	public InvokeResult removeFileUploads(Long[] ids);
	
	public List<FileUploadDTO> findAllFileUpload();
	
	public Page<FileUploadDTO> pageQueryFileUpload(FileUploadDTO fileUpload, int currentPage, int pageSize);
	
	public InvokeResult fileUpload(byte[] bytes, String filename);
	
	public InvokeResult fileUpload(byte[] bytes, String filename,Long id);
}


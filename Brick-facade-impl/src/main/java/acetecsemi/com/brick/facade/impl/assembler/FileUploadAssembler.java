package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class FileUploadAssembler {
	
	public static FileUploadDTO  toDTO(FileUpload  fileUpload){
		if (fileUpload == null) {
			return null;
		}
    	FileUploadDTO result  = new FileUploadDTO();
	    	result.setId (fileUpload.getId());
     	    	result.setVersion (fileUpload.getVersion());
     	    	result.setLocalPath (fileUpload.getLocalPath());
     	    	result.setIp (fileUpload.getIp());
     	    	result.setPort (fileUpload.getPort());
     	    	result.setNetPath (fileUpload.getNetPath());
     	    	result.setMaxSize (fileUpload.getMaxSize());
     	    	result.setFileTypes (fileUpload.getFileTypes());
     	    	result.setType (fileUpload.getType());
     	    	result.setDescription (fileUpload.getDescription());
     	    return result;
	 }
	
	public static List<FileUploadDTO>  toDTOs(Collection<FileUpload>  fileUploads){
		if (fileUploads == null) {
			return null;
		}
		List<FileUploadDTO> results = new ArrayList<FileUploadDTO>();
		for (FileUpload each : fileUploads) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static FileUpload  toEntity(FileUploadDTO  fileUploadDTO){
	 	if (fileUploadDTO == null) {
			return null;
		}
	 	FileUpload result  = new FileUpload();
        result.setId (fileUploadDTO.getId());
         result.setVersion (fileUploadDTO.getVersion());
         result.setLocalPath (fileUploadDTO.getLocalPath());
         result.setIp (fileUploadDTO.getIp());
         result.setPort (fileUploadDTO.getPort());
         result.setNetPath (fileUploadDTO.getNetPath());
         result.setMaxSize (fileUploadDTO.getMaxSize());
         result.setFileTypes (fileUploadDTO.getFileTypes());
         result.setType (fileUploadDTO.getType());
         result.setDescription (fileUploadDTO.getDescription());
 	  	return result;
	 }
	
	public static List<FileUpload> toEntities(Collection<FileUploadDTO> fileUploadDTOs) {
		if (fileUploadDTOs == null) {
			return null;
		}
		
		List<FileUpload> results = new ArrayList<FileUpload>();
		for (FileUploadDTO each : fileUploadDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

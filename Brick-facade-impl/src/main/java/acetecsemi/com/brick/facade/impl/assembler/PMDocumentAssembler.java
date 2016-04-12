package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class PMDocumentAssembler {

	public static PMDocumentDTO toDTO(PMDocument pMDocument) {
		if (pMDocument == null) {
			return null;
		}
		PMDocumentDTO result = new PMDocumentDTO();
		result.setId(pMDocument.getId());
		result.setVersion(pMDocument.getVersion());
		result.setCreateTimestamp(pMDocument.getCreateTimestamp());
		result.setLastModifyTimestamp(pMDocument.getLastModifyTimestamp());
		result.setCreateEmployNo(pMDocument.getCreateEmployNo());
		result.setLastModifyEmployNo(pMDocument.getLastModifyEmployNo());
		result.setFileName(pMDocument.getFileName());
		result.setFileUrl(pMDocument.getFileUrl());
		result.setUploadDate(pMDocument.getUploadDate());
		result.setUploadUser(pMDocument.getUploadUser());
		result.setEquipmentNo(pMDocument.getEquipmentOptionLog()
				.getEquipment().getEquipmentNo());
		result.setQreOptDate(pMDocument.getQreOptDate());
		result.setQreOptUser(pMDocument.getQreOptUser());
		result.setEeOptDate(pMDocument.getEeOptDate());
		result.setEeOptUser(pMDocument.getEeOptUser());
		// result.setEquipmentOptionLog (pMDocument.getEquipmentOptionLog());
		return result;
	}

	public static List<PMDocumentDTO> toDTOs(Collection<PMDocument> pMDocuments) {
		if (pMDocuments == null) {
			return null;
		}
		List<PMDocumentDTO> results = new ArrayList<PMDocumentDTO>();
		for (PMDocument each : pMDocuments) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static PMDocument toEntity(PMDocumentDTO PMDocumentDTO) {
		if (PMDocumentDTO == null) {
			return null;
		}
		PMDocument result = new PMDocument();
		result.setId(PMDocumentDTO.getId());
		result.setVersion(PMDocumentDTO.getVersion());
		result.setCreateTimestamp(PMDocumentDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(PMDocumentDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(PMDocumentDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(PMDocumentDTO.getLastModifyEmployNo());
		result.setFileName(PMDocumentDTO.getFileName());
		result.setFileUrl(PMDocumentDTO.getFileUrl());
		result.setUploadDate(PMDocumentDTO.getUploadDate());
		result.setUploadUser(PMDocumentDTO.getUploadUser());
		// result.setEquipmentOptionLog (PMDocumentDTO.getEquipmentOptionLog());
		return result;
	}

	public static List<PMDocument> toEntities(
			Collection<PMDocumentDTO> PMDocumentDTOs) {
		if (PMDocumentDTOs == null) {
			return null;
		}

		List<PMDocument> results = new ArrayList<PMDocument>();
		for (PMDocumentDTO each : PMDocumentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

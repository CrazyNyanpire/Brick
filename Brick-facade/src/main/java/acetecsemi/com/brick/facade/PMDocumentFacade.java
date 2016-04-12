package acetecsemi.com.brick.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface PMDocumentFacade {

	public InvokeResult getPMDocument(Long id);
	
	public InvokeResult creatPMDocument(PMDocumentDTO pMDocument);
	
	public InvokeResult updatePMDocument(PMDocumentDTO pMDocument);
	
	public InvokeResult removePMDocument(Long id);
	
	public InvokeResult removePMDocuments(Long[] ids);
	
	public List<PMDocumentDTO> findAllPMDocument();
	
	public Page<PMDocumentDTO> pageQueryPMDocument(PMDocumentDTO pMDocument, int currentPage, int pageSize);
	
	public EquipmentOptionLogDTO findEquipmentOptionLogByPMDocument(Long id);
	
	public InvokeResult signPMDocument(PMDocumentDTO pMDocumentDTO);
	
}


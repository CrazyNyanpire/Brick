package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.PMDocument;

public interface PMDocumentApplication {

	public PMDocument getPMDocument(Long id);
	
	public void creatPMDocument(PMDocument pMDocument);
	
	public void updatePMDocument(PMDocument pMDocument);
	
	public void removePMDocument(PMDocument pMDocument);
	
	public void removePMDocuments(Set<PMDocument> pMDocuments);
	
	public List<PMDocument> findAllPMDocument();
	
}


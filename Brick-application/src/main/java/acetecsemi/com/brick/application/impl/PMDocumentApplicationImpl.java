package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PMDocumentApplication;
import acetecsemi.com.brick.core.domain.PMDocument;

@Named
@Transactional
public class PMDocumentApplicationImpl implements PMDocumentApplication {

	public PMDocument getPMDocument(Long id) {
		return PMDocument.get(PMDocument.class, id);
	}
	
	public void creatPMDocument(PMDocument pMDocument) {
		pMDocument.save();
	}
	
	public void updatePMDocument(PMDocument pMDocument) {
		pMDocument .save();
	}
	
	public void removePMDocument(PMDocument pMDocument) {
		if(pMDocument != null){
			pMDocument.remove();
		}
	}
	
	public void removePMDocuments(Set<PMDocument> pMDocuments) {
		for (PMDocument pMDocument : pMDocuments) {
			pMDocument.remove();
		}
	}
	
	public List<PMDocument> findAllPMDocument() {
		return PMDocument.findAll(PMDocument.class);
	}
	
}

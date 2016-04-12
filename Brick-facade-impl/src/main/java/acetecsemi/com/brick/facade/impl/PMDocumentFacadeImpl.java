package acetecsemi.com.brick.facade.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.PMDocumentAssembler;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.PMDocumentFacade;
import acetecsemi.com.brick.application.PMDocumentApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PMDocumentFacadeImpl implements PMDocumentFacade {

	@Inject
	private PMDocumentApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public InvokeResult getPMDocument(Long id) {
		return InvokeResult.success(PMDocumentAssembler.toDTO(application
				.getPMDocument(id)));
	}

	public InvokeResult creatPMDocument(PMDocumentDTO pMDocumentDTO) {
		application
				.creatPMDocument(PMDocumentAssembler.toEntity(pMDocumentDTO));
		return InvokeResult.success();
	}

	public InvokeResult updatePMDocument(PMDocumentDTO pMDocumentDTO) {
		application.updatePMDocument(PMDocumentAssembler
				.toEntity(pMDocumentDTO));
		return InvokeResult.success();
	}

	public InvokeResult removePMDocument(Long id) {
		application.removePMDocument(application.getPMDocument(id));
		return InvokeResult.success();
	}

	public InvokeResult removePMDocuments(Long[] ids) {
		Set<PMDocument> pMDocuments = new HashSet<PMDocument>();
		for (Long id : ids) {
			pMDocuments.add(application.getPMDocument(id));
		}
		application.removePMDocuments(pMDocuments);
		return InvokeResult.success();
	}

	public List<PMDocumentDTO> findAllPMDocument() {
		return PMDocumentAssembler.toDTOs(application.findAllPMDocument());
	}

	public Page<PMDocumentDTO> pageQueryPMDocument(PMDocumentDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _pMDocument from PMDocument _pMDocument   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _pMDocument.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _pMDocument.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _pMDocument.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _pMDocument.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getFileName() != null && !"".equals(queryVo.getFileName())) {
			jpql.append(" and _pMDocument.fileName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getFileName()));
		}
		if (queryVo.getFileUrl() != null && !"".equals(queryVo.getFileUrl())) {
			jpql.append(" and _pMDocument.fileUrl like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getFileUrl()));
		}
		if (queryVo.getUploadDate() != null) {
			jpql.append(" and _pMDocument.uploadDate between ? and ? ");
			conditionVals.add(queryVo.getUploadDate());
			conditionVals.add(MyDateUtils.add(queryVo.getUploadDateEnd(),
					Calendar.DAY_OF_MONTH, 1));
		}
		if (queryVo.getUploadUser() != null
				&& !"".equals(queryVo.getUploadUser())) {
			jpql.append(" and _pMDocument.uploadUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getUploadUser()));
		}
		jpql.append(" order by uploadDate desc");
		Page<PMDocument> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<PMDocumentDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				PMDocumentAssembler.toDTOs(pages.getData()));
	}

	@Override
	public EquipmentOptionLogDTO findEquipmentOptionLogByPMDocument(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvokeResult signPMDocument(PMDocumentDTO pMDocumentDTO) {
		if (pMDocumentDTO.getSignType().toUpperCase().equals("QRE")
				&& pMDocumentDTO.getIsPass().equals("1")) {
			PMDocument pMDocument = application.getPMDocument(pMDocumentDTO
					.getId());
			pMDocument.setQreOptUser(pMDocumentDTO.getLastModifyEmployNo());
			pMDocument.setQreOptDate(new Date());
			application.updatePMDocument(pMDocument);
		} else if (pMDocumentDTO.getSignType().toUpperCase().equals("EE")
				&& pMDocumentDTO.getIsPass().equals("1")) {
			PMDocument pMDocument = application.getPMDocument(pMDocumentDTO
					.getId());
			pMDocument.setEeOptUser(pMDocumentDTO.getLastModifyEmployNo());
			pMDocument.setEeOptDate(new Date());
			application.updatePMDocument(pMDocument);
		} else {
			return InvokeResult.failure("会签职位不为QRE或EE！");
		}
		return InvokeResult.success("会签成功！");
	}
}

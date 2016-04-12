package acetecsemi.com.brick.facade.impl;

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
import acetecsemi.com.brick.facade.impl.assembler.SocketReceivingReportAssembler;
import acetecsemi.com.brick.facade.SocketReceivingReportFacade;
import acetecsemi.com.brick.application.SocketReceivingReportApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class SocketReceivingReportFacadeImpl implements
		SocketReceivingReportFacade {

	@Inject
	private SocketReceivingReportApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public InvokeResult getSocketReceivingReport(Long id) {
		return InvokeResult.success(SocketReceivingReportAssembler
				.toDTO(application.getSocketReceivingReport(id)));
	}

	public InvokeResult creatSocketReceivingReport(
			SocketReceivingReportDTO socketReceivingReportDTO) {
		application.creatSocketReceivingReport(SocketReceivingReportAssembler
				.toEntity(socketReceivingReportDTO));
		return InvokeResult.success();
	}

	public InvokeResult updateSocketReceivingReport(
			SocketReceivingReportDTO socketReceivingReportDTO) {
		application.updateSocketReceivingReport(SocketReceivingReportAssembler
				.toEntity(socketReceivingReportDTO));
		return InvokeResult.success();
	}

	public InvokeResult removeSocketReceivingReport(Long id) {
		application.removeSocketReceivingReport(application
				.getSocketReceivingReport(id));
		return InvokeResult.success();
	}

	public InvokeResult removeSocketReceivingReports(Long[] ids) {
		Set<SocketReceivingReport> socketReceivingReports = new HashSet<SocketReceivingReport>();
		for (Long id : ids) {
			socketReceivingReports
					.add(application.getSocketReceivingReport(id));
		}
		application.removeSocketReceivingReports(socketReceivingReports);
		return InvokeResult.success();
	}

	public List<SocketReceivingReportDTO> findAllSocketReceivingReport() {
		return SocketReceivingReportAssembler.toDTOs(application
				.findAllSocketReceivingReport());
	}

	public Page<SocketReceivingReportDTO> pageQuerySocketReceivingReport(
			SocketReceivingReportDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _socketReceivingReport from SocketReceivingReport _socketReceivingReport   left join _socketReceivingReport.equipment  where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _socketReceivingReport.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _socketReceivingReport.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _socketReceivingReport.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _socketReceivingReport.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getFileUrl() != null && !"".equals(queryVo.getFileUrl())) {
			jpql.append(" and _socketReceivingReport.fileUrl like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getFileUrl()));
		}
		Page<SocketReceivingReport> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<SocketReceivingReportDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				SocketReceivingReportAssembler.toDTOs(pages.getData()));
	}

	@Override
	public SocketDTO findSocketBySocketReceivingReport(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

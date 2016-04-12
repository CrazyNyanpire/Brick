package acetecsemi.com.brick.facade.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardAssembler;
import acetecsemi.com.brick.facade.impl.assembler.ProbeCardOptionLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.utils.MyStringUtils;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.facade.ProbeCardOptionLogFacade;
import acetecsemi.com.brick.facade.SocketFacade;
import acetecsemi.com.brick.facade.SocketOptionLogFacade;
import acetecsemi.com.brick.facade.SocketReceivingReportFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.application.SocketApplication;
import acetecsemi.com.brick.application.SocketOptionLogApplication;
import acetecsemi.com.brick.application.SocketReceivingReportApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
@Transactional
public class SocketFacadeImpl implements SocketFacade {

	@Inject
	private SocketApplication application;

	@Inject
	private SocketOptionLogApplication socketOptionLogApplication;

	@Inject
	private SocketOptionLogFacade socketOptionLogFacade;

	@Inject
	private SocketReceivingReportApplication socketReceivingReportFacadeApplication;

	@Inject
	private PlatformApplication platformApplication;

	@Inject
	private CategoryApplication categoryApplication;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	private static Long ZERO = Long.valueOf(0);
	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public SocketDTO getSocket(Long id) {
		return SocketAssembler.toDTO(application.getSocket(id));
	}

	public Boolean creatSocket(SocketDTO socketDTO) {
		Socket socket = SocketAssembler.toEntity(socketDTO);
		socket.setStatus(categoryApplication.getCategory(Long.valueOf(117)));
		socket.setTouchTime(ZERO);
		socket.setTouchTimeTotal(ZERO);
		application.creatSocket(socket);
		SocketOptionLog socketOptionLog = SocketOptionLogAssembler
				.toEntity(socketDTO);
		socketOptionLog.setSocket(socket);
		socketOptionLog.setStatus(socket.getStatus().getCategoryName());
		this.socketOptionLogApplication.updateSocketOptionLog(socketOptionLog);
		SocketReceivingReport socketReceivingReport = new SocketReceivingReport();
		socketReceivingReport.setFileUrl(socketDTO.getLastFileUrl());
		socketReceivingReport.setSocket(socket);
		socketReceivingReportFacadeApplication
				.creatSocketReceivingReport(socketReceivingReport);
		return true;
	}

	public Boolean updateSocket(SocketDTO socketDTO) {
		Socket socket = application.getSocket(socketDTO.getId());
		BeanUtils.copyProperties(socketDTO, socket);
		application.updateSocket(socket);
		return true;
	}

	public Boolean removeSocket(Long id) {
		application.removeSocket(application.getSocket(id));
		return true;
	}

	public Boolean removeSockets(Long[] ids) {
		Set<Socket> sockets = new HashSet<Socket>();
		for (Long id : ids) {
			sockets.add(application.getSocket(id));
		}
		application.removeSockets(sockets);
		return true;
	}

	public List<SocketDTO> findAllSocket() {
		return SocketAssembler.toDTOs(application.findAllSocket());
	}

	public Page<SocketDTO> pageQuerySocket(SocketDTO queryVo, int currentPage,
			int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _socket from Socket _socket   where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _socket.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _socket.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _socket.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _socket.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _socket.category like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategory()));
		}
		if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
			jpql.append(" and _socket.partNo like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
		}
		if (queryVo.getPartName() != null && !"".equals(queryVo.getPartName())) {
			jpql.append(" and _socket.partName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartName()));
		}
		if (queryVo.getEquipmentList() != null
				&& !"".equals(queryVo.getEquipmentList())) {
			jpql.append(" and _socket.equipmentList like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentList()));
		}
		if (queryVo.getPartType() != null && !"".equals(queryVo.getPartType())) {
			jpql.append(" and _socket.partType like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartType()));
		}
		if (queryVo.getPartModel() != null
				&& !"".equals(queryVo.getPartModel())) {
			jpql.append(" and _socket.partModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartModel()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _socket.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getNowProductModel() != null
				&& !"".equals(queryVo.getNowProductModel())) {
			jpql.append(" and _socket.nowProductModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowProductModel()));
		}
		if (queryVo.getInDate() != null) {
			jpql.append(" and _socket.inDate between ? and ? ");
			conditionVals.add(queryVo.getInDate());
			conditionVals.add(queryVo.getInDateEnd());
		}
		if (queryVo.getPartLocaltion() != null
				&& !"".equals(queryVo.getPartLocaltion())) {
			jpql.append(" and _socket.partLocaltion like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartLocaltion()));
		}
		if (queryVo.getManufacturerNo() != null
				&& !"".equals(queryVo.getManufacturerNo())) {
			jpql.append(" and _socket.manufacturerNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getManufacturerNo()));
		}
		if (queryVo.getManufacturerName() != null
				&& !"".equals(queryVo.getManufacturerName())) {
			jpql.append(" and _socket.manufacturerName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getManufacturerName()));
		}
		if (queryVo.getCustomerName() != null
				&& !"".equals(queryVo.getCustomerName())) {
			jpql.append(" and _socket.customerName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerName()));
		}
		if (queryVo.getCustomerNameEn() != null
				&& !"".equals(queryVo.getCustomerNameEn())) {
			jpql.append(" and _socket.customerNameEn like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerNameEn()));
		}
		if (queryVo.getOwnership() != null
				&& !"".equals(queryVo.getOwnership())) {
			jpql.append(" and _socket.ownership like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOwnership()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _socket.status.id = ?");
			conditionVals.add(Long.valueOf(queryVo.getStatus()));
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _socket.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		if (queryVo.getPn() != null && !"".equals(queryVo.getPn())) {
			jpql.append(" and _socket.pn like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPn()));
		}
		if (queryVo.getPinModels() != null
				&& !"".equals(queryVo.getPinModels())) {
			jpql.append(" and _socket.pinModels like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPinModels()));
		}
		if (queryVo.getSupplier() != null && !"".equals(queryVo.getSupplier())) {
			jpql.append(" and _socket.supplier like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getSupplier()));
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _socket.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		if (queryVo.getApplicableModels() != null
				&& !"".equals(queryVo.getApplicableModels())) {
			jpql.append(" and _socket.applicableModels like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getApplicableModels()));
		}
		if (queryVo.getLastFileUrl() != null
				&& !"".equals(queryVo.getLastFileUrl())) {
			jpql.append(" and _socket.lastFileUrl like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastFileUrl()));
		}
		Page<Socket> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<SocketDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, SocketAssembler.toDTOs(pages.getData()));
	}

	public ProbeCardDTO findProbeCardBySocket(Long id) {
		String jpql = "select e from Socket o right join o.probeCard e where o.id=?";
		ProbeCard result = (ProbeCard) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		ProbeCardDTO dto = new ProbeCardDTO();
		if (result != null) {
			try {
				dto = ProbeCardAssembler.toDTO(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public EquipmentDTO findEquipmentBySocket(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvokeResult changeSocketStatus(SocketDTO socketDTO) {
		Socket socket = Socket.get(Socket.class, socketDTO.getId());
		if (socketDTO.getStatusId() != null) {
			SocketOptionLog socketOptionLog = SocketOptionLogAssembler
					.toEntity(socketDTO);
			switch (socketDTO.getStatusId().intValue()) {
			case 99:
			case 100:
				if (this.checkRunSocket(socket)) {
					return InvokeResult.failure("领出申请产品型号、设备socket不适用！");
				}
				if (socketDTO.getNowPlatformId() != null) {
					/*
					 * if (this.checkPlatformSite(socketDTO.getNowPlatformId(),
					 * socketDTO.getPlatformSite())) { return
					 * "已经领出socket 到选择的site，如果需要办理领出请归还入库！"; }
					 */
					Platform platform = Platform.get(Platform.class,
							socketDTO.getNowPlatformId());
					if (socket.getEquipmentList() == null
							|| socket.getEquipmentListId() == null
							|| socket.getEquipmentListId()
									.indexOf(
											String.valueOf(socketDTO
													.getNowPlatformId())) < 0
							&& socket.getEquipmentList().indexOf(
									platform.getTester().getEquipmentNo()) < 0) {
						return InvokeResult.failure("Sockect 不能用于平台"
								+ platform.getTester().getEquipmentNo());
					}
					socket.setNowPlatform(platform);
					socketDTO
							.setPlatform(platform.getTester().getEquipmentNo());
					// socket.setPlatformSite(socketDTO.getPlatformSite());
				}
				break;

			case 97:
			case 98:
				socket.setNowPlatform(null);
				socket.setPlatformSite(null);
				socketOptionLog.setAppearanceHorizontal(socketDTO
						.getAppearanceLevel());
				if ("true".equals(socketDTO.getIsChangePin())) {
					socket.setTouchTime(ZERO);
				}
				break;
			case 116:
				Map<String, String> map = socketOptionLogFacade
						.getReleaseInfo(socket.getId());
				socket.setProductModel(MyStringUtils.getReleaseInfo(
						map.get("productModel"), socketDTO.getProductModel()));
				socket.setEquipmentList(MyStringUtils.getReleaseInfo(
						map.get("equipmentList"), socketDTO.getEquipmentList()));
				socketDTO.setPlatform(socketDTO.getEquipmentList());
				socket.setEquipmentListId(MyStringUtils.getReleaseInfo(
						map.get("equipmentListId"),
						socketDTO.getEquipmentListId()));
				break;
			case 119:
				socket.setNowPlatform(null);
				socket.setPlatformSite(null);
				break;
			}
			Category status = Category.get(Category.class,
					socketDTO.getStatusId());
			socketDTO.setStatus(status.getCategoryName());
			socket.setStatus(status);
			if (socketDTO.getOptDate() == null) {
				socketDTO.setOptDate(new Date());
			}
			socketOptionLogFacade.saveLastSocketOptionLogEndTime(
					socket.getId(), socketDTO.getOptDate(), Long.valueOf(0),
					socketDTO.getLastModifyEmployNo());
			application.updateSocket(socket);
			// socketOptionLog.setPlatformSite(socketDTO.getPlatformSite());
			socketOptionLog.setSocket(socket);
			socketOptionLog.setStartTime(socketDTO.getOptDate());
			socketOptionLog.setStatus(status.getCategoryName());
			socketOptionLog.setPlatform(socketDTO.getPlatform());
			socketOptionLog.setPlatformIds(socketDTO.getEquipmentListId());
			// socketOptionLog.setOptUser(platform);
			socketOptionLog.setId(null);
			socketOptionLogApplication.updateSocketOptionLog(socketOptionLog);
			if (socketDTO.getStatusId() == Long.valueOf(116)) {
				SocketDTO sDTO = new SocketDTO();
				sDTO.setId(socketDTO.getId());
				sDTO.setStatusId(Long.valueOf(97));
				sDTO.setAppearanceLevel("Pass");
				sDTO.setOptDate(socketDTO.getOptDate());
				sDTO.setLastModifyEmployNo(socketDTO.getLastModifyEmployNo());
				this.changeSocketStatus(sDTO);
			}
			return InvokeResult.success();
		}
		return InvokeResult.failure("状态改变失败！");
	}

	private boolean checkPlatformSite(Long platformId, Integer site) {
		SocketDTO queryVo = new SocketDTO();
		queryVo.setNowPlatformId(platformId);
		queryVo.setPlatformSite(site);
		List<SocketDTO> socketList = this.querySocket(queryVo,
				" order by platformSite ");
		if (socketList != null && socketList.size() > 0) {
			return true;
		}
		return false;
	}

	public List<SocketDTO> getSocketByPlatformId(Long platformId) {
		SocketDTO queryVo = new SocketDTO();
		queryVo.setNowPlatformId(platformId);
		List<SocketDTO> socketList = this.querySocket(queryVo,
				" order by platformSite ");
		return socketList;
	}

	@Override
	public String runLog(SocketDTO socketDTO) {
		if (socketDTO.getId() != null) {
			Socket socket = application.getSocket(socketDTO.getId());
			if (socketDTO.getIsChangePin() != null
					&& socketDTO.getIsChangePin().toUpperCase().equals("TRUE")) {
				socket.setTouchTime(ZERO);
			} else {
				socket.setTouchTime(socket.getTouchTime()
						+ socketDTO.getTouchTimes());
			}
			socket.setTouchTimeTotal(socket.getTouchTimeTotal()
					+ socketDTO.getTouchTimes());
			// 挂状态时关联平台
			if (socketDTO.getPlatformId() != null) {
				socket.setNowPlatform(platformApplication.getPlatform(socketDTO
						.getPlatformId()));
				socket.setPlatformSite(socketDTO.getPlatformSite());
			} else {
				socket.setNowPlatform(null);
			}

			SocketOptionLog socketOptionLog = SocketOptionLogAssembler
					.toEntity(socketDTO);
			if (socket.getNowPlatform() != null) {
				socketOptionLog.setPlatform(socket.getNowPlatform().getTester()
						.getEquipmentNo());
				socketOptionLog.setPlatformSite(socketDTO.getPlatformSite());
			}
			socketOptionLog.setId(null);
			socketOptionLog.setSocket(socket);
			socketOptionLog.setStartTime(socketDTO.getOptDate());
			socketOptionLog.setStatus(socket.getStatus().getCategoryName());
			socketOptionLog.setRemark("生产批次操作日志");
			socketOptionLog.setTouchTimes(null);
			// probeCardOptionLog.setOptUser(platform);
			socketOptionLog.setLastModifyEmployNo(socketDTO
					.getLastModifyEmployNo());
			socketOptionLog.setPlatform(socketDTO.getPlatform());
			socketOptionLog
					.setAppearanceHorizontal(socket.getAppearanceLevel());
			socketOptionLog.setPlatformStatus(socketDTO.getPlatformStatus());
			socketOptionLogApplication.creatSocketOptionLog(socketOptionLog);
			return null;
		}
		return "状态改变失败！";
	}

	/**
	 * 生产领出的probe card
	 */
	@Override
	public List<SocketDTO> findProductAllSocket(SocketDTO socketDTO) {
		// socketDTO = new SocketDTO();
		socketDTO.setStatusIds("99,100");
		return this.querySocket(socketDTO, null);
	}

	public List<SocketDTO> querySocket(SocketDTO queryVo, String order) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _socket from Socket _socket   where 1=1 ");
		if (queryVo.getPlatformNo() != null
				&& !"".equals(queryVo.getPlatformNo())) {
			jpql.append(" and _socket.equipmentList like ? ");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformNo()));
		}
		if (queryVo.getStatusId() != null) {
			jpql.append(" and _socket.status.id = ?");
			conditionVals.add(queryVo.getStatusId());
		}
		if (queryVo.getStatusIds() != null
				&& !"".equals(queryVo.getStatusIds())) {
			jpql.append(" and _socket.status.id in (" + queryVo.getStatusIds()
					+ ")");
		}
		if (queryVo.getNowPlatformId() != null) {
			jpql.append(" and _socket.nowPlatform.id = ? ");
			conditionVals.add(queryVo.getNowPlatformId());
		}
		if (queryVo.getPlatformSite() != null) {
			jpql.append(" and _socket.platformSite = ?");
			conditionVals.add(queryVo.getPlatformSite());
		}
		if (order != null)
			jpql.append(order);
		List<Socket> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return SocketAssembler.toDTOs(list);
	}

	private boolean checkRunSocket(Socket socket) {
		if (socket.getNowPlatform() != null
				&& ("RUN".equals(socket.getNowPlatform().getStatus())
						|| "REWORK".equals(socket.getNowPlatform().getStatus())
						|| "ENG_RUN"
								.equals(socket.getNowPlatform().getStatus()) || "R/T_RUN"
							.equals(socket.getNowPlatform().getStatus()))
				&& platformOptionLogFacade
						.getLastPlatformOptionLog(
								socket.getNowPlatform().getId()).getPcNo()
						.indexOf(socket.getPartNo()) > -1) {

			return true;
		}
		return false;

	}
}

package acetecsemi.com.brick.facade.impl;

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

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.LoadBoardAssembler;
import acetecsemi.com.brick.facade.impl.assembler.LoadBoardAssembler;
import acetecsemi.com.brick.facade.utils.BeanUtils;
import acetecsemi.com.brick.facade.utils.MyStringUtils;
import acetecsemi.com.brick.facade.LoadBoardFacade;
import acetecsemi.com.brick.facade.LoadBoardOptionLogFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.application.LoadBoardOptionLogApplication;
import acetecsemi.com.brick.application.LoadBoardApplication;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class LoadBoardFacadeImpl implements LoadBoardFacade {

	@Inject
	private LoadBoardApplication application;

	@Inject
	private LoadBoardOptionLogFacade loadBoardOptionLogFacade;

	@Inject
	private LoadBoardOptionLogApplication loadBoardOptionLogApplication;

	@Inject
	private PlatformApplication platformApplication;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	@Inject
	private CategoryApplication categoryApplication;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public InvokeResult getLoadBoard(Long id) {
		return InvokeResult.success(LoadBoardAssembler.toDTO(application
				.getLoadBoard(id)));
	}

	public InvokeResult creatLoadBoard(LoadBoardDTO loadBoardDTO) {
		LoadBoard loadBoard = LoadBoardAssembler.toEntity(loadBoardDTO);
		loadBoard.setStatus(categoryApplication.getCategory(Long.valueOf(117)));
		application.creatLoadBoard(loadBoard);
		LoadBoardOptionLog loadBoardOptionLog = new LoadBoardOptionLog();
		BeanUtils.copyProperties(loadBoardDTO, loadBoardOptionLog);
		loadBoardOptionLog.setLoadBoard(loadBoard);
		loadBoardOptionLog.setStatus(loadBoard.getStatus().getCategoryName());
		this.loadBoardOptionLogApplication
				.updateLoadBoardOptionLog(loadBoardOptionLog);
		LoadBoardReceivingReport loadBoardReceivingReport = new LoadBoardReceivingReport();
		loadBoardReceivingReport.setFileUrl(loadBoardDTO.getLastFileUrl());
		loadBoardReceivingReport.setLoadBoard(loadBoard);
		loadBoardReceivingReport.save();
		return InvokeResult.success();
	}

	public InvokeResult updateLoadBoard(LoadBoardDTO loadBoardDTO) {
		LoadBoard loadBoard = application.getLoadBoard(loadBoardDTO.getId());
		BeanUtils.copyProperties(loadBoardDTO, loadBoard);
		application.updateLoadBoard(loadBoard);
		return InvokeResult.success();
	}

	public InvokeResult removeLoadBoard(Long id) {
		application.removeLoadBoard(application.getLoadBoard(id));
		return InvokeResult.success();
	}

	public InvokeResult removeLoadBoards(Long[] ids) {
		Set<LoadBoard> loadBoards = new HashSet<LoadBoard>();
		for (Long id : ids) {
			loadBoards.add(application.getLoadBoard(id));
		}
		application.removeLoadBoards(loadBoards);
		return InvokeResult.success();
	}

	public List<LoadBoardDTO> findAllLoadBoard() {
		return LoadBoardAssembler.toDTOs(application.findAllLoadBoard());
	}

	public Page<LoadBoardDTO> pageQueryLoadBoard(LoadBoardDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _loadBoard from LoadBoard _loadBoard  where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _loadBoard.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _loadBoard.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _loadBoard.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _loadBoard.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and _loadBoard.category like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategory()));
		}
		if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
			jpql.append(" and _loadBoard.partNo like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
		}
		if (queryVo.getPartName() != null && !"".equals(queryVo.getPartName())) {
			jpql.append(" and _loadBoard.partName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartName()));
		}
		if (queryVo.getEquipmentList() != null
				&& !"".equals(queryVo.getEquipmentList())) {
			jpql.append(" and _loadBoard.equipmentList like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentList()));
		}
		if (queryVo.getPartType() != null && !"".equals(queryVo.getPartType())) {
			jpql.append(" and _loadBoard.partType like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartType()));
		}
		if (queryVo.getPartModel() != null
				&& !"".equals(queryVo.getPartModel())) {
			jpql.append(" and _loadBoard.partModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartModel()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _loadBoard.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getNowProductModel() != null
				&& !"".equals(queryVo.getNowProductModel())) {
			jpql.append(" and _loadBoard.nowProductModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowProductModel()));
		}
		if (queryVo.getInDate() != null) {
			jpql.append(" and _loadBoard.inDate between ? and ? ");
			conditionVals.add(queryVo.getInDate());
			conditionVals.add(queryVo.getInDateEnd());
		}
		if (queryVo.getPartLocaltion() != null
				&& !"".equals(queryVo.getPartLocaltion())) {
			jpql.append(" and _loadBoard.partLocaltion like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartLocaltion()));
		}
		if (queryVo.getManufacturerNo() != null
				&& !"".equals(queryVo.getManufacturerNo())) {
			jpql.append(" and _loadBoard.manufacturerNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getManufacturerNo()));
		}
		if (queryVo.getManufacturerName() != null
				&& !"".equals(queryVo.getManufacturerName())) {
			jpql.append(" and _loadBoard.manufacturerName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getManufacturerName()));
		}
		if (queryVo.getCustomerName() != null
				&& !"".equals(queryVo.getCustomerName())) {
			jpql.append(" and _loadBoard.customerName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerName()));
		}
		if (queryVo.getCustomerNameEn() != null
				&& !"".equals(queryVo.getCustomerNameEn())) {
			jpql.append(" and _loadBoard.customerNameEn like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCustomerNameEn()));
		}
		if (queryVo.getOwnership() != null
				&& !"".equals(queryVo.getOwnership())) {
			jpql.append(" and _loadBoard.ownership like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOwnership()));
		}
		if (queryVo.getRemark() != null && !"".equals(queryVo.getRemark())) {
			jpql.append(" and _loadBoard.remark like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getRemark()));
		}
		if (queryVo.getPn() != null && !"".equals(queryVo.getPn())) {
			jpql.append(" and _loadBoard.pn like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPn()));
		}
		if (queryVo.getSupplier() != null && !"".equals(queryVo.getSupplier())) {
			jpql.append(" and _loadBoard.supplier like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getSupplier()));
		}
		if (queryVo.getApplicableModels() != null
				&& !"".equals(queryVo.getApplicableModels())) {
			jpql.append(" and _loadBoard.applicableModels like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getApplicableModels()));
		}
		if (queryVo.getLastFileUrl() != null
				&& !"".equals(queryVo.getLastFileUrl())) {
			jpql.append(" and _loadBoard.lastFileUrl like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastFileUrl()));
		}
		if (queryVo.getAppearanceLevel() != null
				&& !"".equals(queryVo.getAppearanceLevel())) {
			jpql.append(" and _loadBoard.appearanceLevel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getAppearanceLevel()));
		}
		if (queryVo.getEquipmentListId() != null
				&& !"".equals(queryVo.getEquipmentListId())) {
			jpql.append(" and _loadBoard.equipmentListId like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentListId()));
		}
		Page<LoadBoard> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<LoadBoardDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, LoadBoardAssembler.toDTOs(pages.getData()));
	}

	public LoadBoardDTO findLoadBoardByLoadBoard(Long id) {
		String jpql = "select e from LoadBoard o right join o.loadBoard e where o.id=?";
		LoadBoard result = (LoadBoard) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { id })
				.singleResult();
		LoadBoardDTO dto = new LoadBoardDTO();
		if (result != null) {
			try {
				BeanUtils.copyProperties(dto, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public CategoryDTO findStatusByLoadBoard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentDTO findEquipmentByLoadBoard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlatformDTO findNowPlatformByLoadBoard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvokeResult changeLoadBoardStatus(LoadBoardDTO loadBoardDTO) {
		LoadBoard loadBoard = LoadBoard.get(LoadBoard.class,
				loadBoardDTO.getId());
		if (loadBoardDTO.getStatusId() != null) {
			LoadBoardOptionLog loadBoardOptionLog = new LoadBoardOptionLog();
			BeanUtils.copyProperties(loadBoardDTO, loadBoardOptionLog);
			switch (loadBoardDTO.getStatusId().intValue()) {
			case 99:
			case 100:
				if (this.checkRunLoadBoard(loadBoard)) {
					return InvokeResult.failure("领出申请产品型号、设备loadBoard不适用！");
				}
				if (loadBoardDTO.getNowPlatformId() != null) {
					/*
					 * if
					 * (this.checkPlatformSite(loadBoardDTO.getNowPlatformId(),
					 * loadBoardDTO.getPlatformSite())) { return
					 * "已经领出loadBoard 到选择的site，如果需要办理领出请归还入库！"; }
					 */
					Platform platform = Platform.get(Platform.class,
							loadBoardDTO.getNowPlatformId());
					if (loadBoard.getEquipmentList() == null
							|| loadBoard.getEquipmentListId() == null
							|| loadBoard.getEquipmentListId().indexOf(
									String.valueOf(loadBoardDTO
											.getNowPlatformId())) < 0
							&& loadBoard.getEquipmentList().indexOf(
									platform.getTester().getEquipmentNo()) < 0) {
						return InvokeResult.failure("Sockect 不能用于平台"
								+ platform.getTester().getEquipmentNo());
					}
					loadBoard.setNowPlatform(platform);
					loadBoardDTO.setPlatform(platform.getTester()
							.getEquipmentNo());
					// loadBoard.setPlatformSite(loadBoardDTO.getPlatformSite());
				}
				break;

			case 97:
			case 98:
				loadBoard.setNowPlatform(null);
				break;
			case 116:
				Map<String, String> map = loadBoardOptionLogFacade
						.getReleaseInfo(loadBoard.getId());
				loadBoard
						.setProductModel(MyStringUtils.getReleaseInfo(
								map.get("productModel"),
								loadBoardDTO.getProductModel()));
				loadBoard.setEquipmentList(MyStringUtils.getReleaseInfo(
						map.get("equipmentList"),
						loadBoardDTO.getEquipmentList()));
				loadBoardDTO.setPlatform(loadBoardDTO.getEquipmentList());
				loadBoard.setEquipmentListId(MyStringUtils.getReleaseInfo(
						map.get("equipmentListId"),
						loadBoardDTO.getEquipmentListId()));
				break;
			case 119:
				loadBoard.setNowPlatform(null);
				break;
			}
			Category status = Category.get(Category.class,
					loadBoardDTO.getStatusId());
			loadBoardDTO.setStatus(status.getCategoryName());
			loadBoard.setStatus(status);
			loadBoardOptionLogFacade.saveLastLoadBoardOptionLogEndTime(
					loadBoard.getId(), loadBoardDTO.getLastModifyTimestamp(),
					loadBoardDTO.getLastModifyEmployNo());
			application.updateLoadBoard(loadBoard);
			// loadBoardOptionLog.setPlatformSite(loadBoardDTO.getPlatformSite());
			loadBoardOptionLog.setLoadBoard(loadBoard);
			loadBoardOptionLog.setStartTime(loadBoardDTO
					.getLastModifyTimestamp());
			loadBoardOptionLog.setStatus(status.getCategoryName());
			loadBoardOptionLog.setPlatform(loadBoardDTO.getPlatform());
			loadBoardOptionLog
					.setPlatformIds(loadBoardDTO.getEquipmentListId());
			// loadBoardOptionLog.setOptUser(platform);
			loadBoardOptionLog.setId(null);
			loadBoardOptionLogApplication
					.updateLoadBoardOptionLog(loadBoardOptionLog);
			if (loadBoardDTO.getStatusId() == Long.valueOf(116)) {
				LoadBoardDTO sDTO = new LoadBoardDTO();
				sDTO.setId(loadBoardDTO.getId());
				sDTO.setStatusId(Long.valueOf(97));
				sDTO.setAppearanceLevel("Pass");
				sDTO.setLastModifyEmployNo(loadBoardDTO.getLastModifyEmployNo());
				sDTO.setLastModifyTimestamp(loadBoardDTO
						.getLastModifyTimestamp());
				this.changeLoadBoardStatus(sDTO);
			}
			return InvokeResult.success();
		}
		return InvokeResult.failure("状态改变失败！");
	}

	public List<LoadBoardDTO> getLoadBoardByPlatformId(Long platformId) {
		LoadBoardDTO queryVo = new LoadBoardDTO();
		queryVo.setNowPlatformId(platformId);
		List<LoadBoardDTO> loadBoardList = this.queryLoadBoard(queryVo,
				" order by platformSite ");
		return loadBoardList;
	}

	@Override
	public String runLog(LoadBoardDTO loadBoardDTO) {
		if (loadBoardDTO.getId() != null) {
			LoadBoard loadBoard = application
					.getLoadBoard(loadBoardDTO.getId());
			// 挂状态时关联平台
			if (loadBoardDTO.getPlatformId() != null) {
				loadBoard.setNowPlatform(platformApplication
						.getPlatform(loadBoardDTO.getPlatformId()));
			} else {
				loadBoard.setNowPlatform(null);
			}

			LoadBoardOptionLog loadBoardOptionLog = new LoadBoardOptionLog();
			BeanUtils.copyProperties(loadBoardDTO, loadBoardOptionLog);
			if (loadBoard.getNowPlatform() != null) {
				loadBoardOptionLog.setPlatform(loadBoard.getNowPlatform()
						.getTester().getEquipmentNo());
			}
			loadBoardOptionLog.setId(null);
			loadBoardOptionLog.setLoadBoard(loadBoard);
			loadBoardOptionLog.setStartTime(loadBoardDTO
					.getLastModifyTimestamp());
			loadBoardOptionLog.setStatus(loadBoard.getStatus()
					.getCategoryName());
			loadBoardOptionLog.setRemark("生产批次操作日志");
			// probeCardOptionLog.setOptUser(platform);
			loadBoardOptionLog.setLastModifyEmployNo(loadBoardDTO
					.getLastModifyEmployNo());
			loadBoardOptionLog.setPlatform(loadBoardDTO.getPlatform());
			loadBoardOptionLog.setAppearanceHorizontal(loadBoard
					.getAppearanceLevel());
			loadBoardOptionLog.setPlatformStatus(loadBoardDTO
					.getPlatformStatus());
			loadBoardOptionLogApplication
					.creatLoadBoardOptionLog(loadBoardOptionLog);
			return null;
		}
		return "状态改变失败！";
	}

	/**
	 * 生产领出的probe card
	 */
	@Override
	public List<LoadBoardDTO> findProductAllLoadBoard(LoadBoardDTO loadBoardDTO) {
		// loadBoardDTO = new LoadBoardDTO();
		loadBoardDTO.setStatusIds("99,100");
		return this.queryLoadBoard(loadBoardDTO, null);
	}

	public List<LoadBoardDTO> queryLoadBoard(LoadBoardDTO queryVo, String order) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _loadBoard from LoadBoard _loadBoard   where 1=1 ");
		if (queryVo.getPlatformNo() != null
				&& !"".equals(queryVo.getPlatformNo())) {
			jpql.append(" and _loadBoard.equipmentList like ? ");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPlatformNo()));
		}
		if (queryVo.getStatusId() != null) {
			jpql.append(" and _loadBoard.status.id = ?");
			conditionVals.add(queryVo.getStatusId());
		}
		if (queryVo.getStatusIds() != null
				&& !"".equals(queryVo.getStatusIds())) {
			jpql.append(" and _loadBoard.status.id in ("
					+ queryVo.getStatusIds() + ")");
		}
		if (queryVo.getNowPlatformId() != null) {
			jpql.append(" and _loadBoard.nowPlatform.id = ? ");
			conditionVals.add(queryVo.getNowPlatformId());
		}
		if (order != null)
			jpql.append(order);
		List<LoadBoard> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return LoadBoardAssembler.toDTOs(list);
	}

	private boolean checkRunLoadBoard(LoadBoard loadBoard) {
		if (loadBoard.getNowPlatform() != null
				&& ("RUN".equals(loadBoard.getNowPlatform().getStatus())
						|| "REWORK".equals(loadBoard.getNowPlatform()
								.getStatus())
						|| "ENG_RUN".equals(loadBoard.getNowPlatform()
								.getStatus()) || "R/T_RUN".equals(loadBoard
						.getNowPlatform().getStatus()))
				&& platformOptionLogFacade
						.getLastPlatformOptionLog(
								loadBoard.getNowPlatform().getId()).getPcNo()
						.indexOf(loadBoard.getPartNo()) > -1) {

			return true;
		}
		return false;

	}
}

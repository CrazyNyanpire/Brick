package acetecsemi.com.brick.facade.impl;

import java.util.Date;
import java.util.HashMap;
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

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.SocketAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketOptionLogAssembler;
import acetecsemi.com.brick.facade.utils.MyStringUtils;
import acetecsemi.com.brick.facade.SocketOptionLogFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.application.SocketOptionLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class SocketOptionLogFacadeImpl implements SocketOptionLogFacade {

	@Inject
	private SocketOptionLogApplication application;

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

	public SocketOptionLogDTO getSocketOptionLog(Long id) {
		return SocketOptionLogAssembler.toDTO(application
				.getSocketOptionLog(id));
	}

	public Boolean creatSocketOptionLog(SocketOptionLogDTO socketOptionLogDTO) {
		application.creatSocketOptionLog(SocketOptionLogAssembler
				.toEntity(socketOptionLogDTO));
		return true;
	}

	public Boolean updateSocketOptionLog(SocketOptionLogDTO socketOptionLogDTO) {
		application.updateSocketOptionLog(SocketOptionLogAssembler
				.toEntity(socketOptionLogDTO));
		return true;
	}

	public Boolean removeSocketOptionLog(Long id) {
		application.removeSocketOptionLog(application.getSocketOptionLog(id));
		return true;
	}

	public Boolean removeSocketOptionLogs(Long[] ids) {
		Set<SocketOptionLog> socketOptionLogs = new HashSet<SocketOptionLog>();
		for (Long id : ids) {
			socketOptionLogs.add(application.getSocketOptionLog(id));
		}
		application.removeSocketOptionLogs(socketOptionLogs);
		return true;
	}

	public List<SocketOptionLogDTO> findAllSocketOptionLog() {
		return SocketOptionLogAssembler.toDTOs(application
				.findAllSocketOptionLog());
	}

	public Page<SocketOptionLogDTO> pageQuerySocketOptionLog(
			SocketOptionLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _socketOptionLog from SocketOptionLog _socketOptionLog   left join _socketOptionLog.socket  where 1=1 ");
		if (queryVo.getCreateTimestamp() != null) {
			jpql.append(" and _socketOptionLog.createTimestamp between ? and ? ");
			conditionVals.add(queryVo.getCreateTimestamp());
			conditionVals.add(queryVo.getCreateTimestampEnd());
		}
		if (queryVo.getLastModifyTimestamp() != null) {
			jpql.append(" and _socketOptionLog.lastModifyTimestamp between ? and ? ");
			conditionVals.add(queryVo.getLastModifyTimestamp());
			conditionVals.add(queryVo.getLastModifyTimestampEnd());
		}
		if (queryVo.getCreateEmployNo() != null
				&& !"".equals(queryVo.getCreateEmployNo())) {
			jpql.append(" and _socketOptionLog.createEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCreateEmployNo()));
		}
		if (queryVo.getLastModifyEmployNo() != null
				&& !"".equals(queryVo.getLastModifyEmployNo())) {
			jpql.append(" and _socketOptionLog.lastModifyEmployNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLastModifyEmployNo()));
		}
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and _socketOptionLog.status like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getStatus()));
		}
		if (queryVo.getSubStatus() != null
				&& !"".equals(queryVo.getSubStatus())) {
			jpql.append(" and _socketOptionLog.subStatus like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getSubStatus()));
		}
		if (queryVo.getNowLot() != null && !"".equals(queryVo.getNowLot())) {
			jpql.append(" and _socketOptionLog.nowLot like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getNowLot()));
		}
		if (queryVo.getNowStation() != null
				&& !"".equals(queryVo.getNowStation())) {
			jpql.append(" and _socketOptionLog.nowStation like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNowStation()));
		}
		if (queryVo.getProductModel() != null
				&& !"".equals(queryVo.getProductModel())) {
			jpql.append(" and _socketOptionLog.productModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductModel()));
		}
		if (queryVo.getStartTime() != null) {
			jpql.append(" and _socketOptionLog.startTime between ? and ? ");
			conditionVals.add(queryVo.getStartTime());
			conditionVals.add(queryVo.getStartTimeEnd());
		}
		if (queryVo.getEndTime() != null) {
			jpql.append(" and _socketOptionLog.endTime between ? and ? ");
			conditionVals.add(queryVo.getEndTime());
			conditionVals.add(queryVo.getEndTimeEnd());
		}
		if (queryVo.getEndOptUser() != null
				&& !"".equals(queryVo.getEndOptUser())) {
			jpql.append(" and _socketOptionLog.endOptUser like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEndOptUser()));
		}
		if (queryVo.getTheoryTime() != null
				&& !"".equals(queryVo.getTheoryTime())) {
			jpql.append(" and _socketOptionLog.theoryTime like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTheoryTime()));
		}
		if (queryVo.getTouchTimes() != null
				&& !"".equals(queryVo.getTouchTimes())) {
			jpql.append(" and _socketOptionLog.touchTimes like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getTouchTimes()));
		}
		if (queryVo.getOptRemark() != null
				&& !"".equals(queryVo.getOptRemark())) {
			jpql.append(" and _socketOptionLog.optRemark like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getOptRemark()));
		}
		if (queryVo.getProductLot() != null
				&& !"".equals(queryVo.getProductLot())) {
			jpql.append(" and _socketOptionLog.productLot like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getProductLot()));
		}
		if (queryVo.getEquipmentNo() != null
				&& !"".equals(queryVo.getEquipmentNo())) {
			jpql.append(" and _socketOptionLog.equipmentNo like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getEquipmentNo()));
		}
		if (queryVo.getSocketId() != null) {
			jpql.append(" and _socketOptionLog.socket.id = ?");
			conditionVals.add(queryVo.getSocketId());
		}

		if (queryVo.getPartModel() != null
				&& !"".equals(queryVo.getPartModel())) {
			jpql.append(" and _socketOptionLog.socket.partModel like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getPartModel()));
		}

		if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
			jpql.append(" and _socketOptionLog.socket.partNo like ?");
			conditionVals
					.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
		}
		jpql.append("order by _socketOptionLog.id desc");

		Page<SocketOptionLog> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<SocketOptionLogDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				SocketOptionLogAssembler.toDTOs(pages.getData()));
	}

	public SocketDTO findSocketBySocketOptionLog(Long id) {
		String jpql = "select e from SocketOptionLog o right join o.socket e where o.id=?";
		Socket result = (Socket) getQueryChannelService().createJpqlQuery(jpql)
				.setParameters(new Object[] { id }).singleResult();
		SocketDTO dto = new SocketDTO();
		if (result != null) {
			try {
				dto = SocketAssembler.toDTO(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	/**
	 * 保存probe card操作日志最后一条记录的endTime (后期要加入endOptuser)
	 * 
	 * @param probeCardId
	 * @param endTime
	 */
	@Override
	public void saveLastSocketOptionLogEndTime(Long socketId, Date endTime,
			Long touchTimes, String endOptUser) {
		String jpql = "select o from SocketOptionLog o where o.socket.id=? order by o.id desc";
		SocketOptionLog result = (SocketOptionLog) getQueryChannelService()
				.createJpqlQuery(jpql).setParameters(new Object[] { socketId })
				.singleResult();
		if (result != null && result.getStartTime() != null) {
			result.setEndTime(endTime);
			Long duration = result.getEndTime().getTime()
					- result.getStartTime().getTime();
			result.setDuration(duration);
			result.setTouchTimes(touchTimes);
			result.setLastModifyEmployNo(endOptUser);
			result.setEndOptUser(endOptUser);
			if (touchTimes == null) {
				result.setTouchTimesTotal(result.getSocket()
						.getTouchTimeTotal() + Long.valueOf(0));
				result.setNowTouchTime(result.getSocket().getTouchTime()
						+ Long.valueOf(0));
			} else {
				result.setTouchTimesTotal(result.getSocket()
						.getTouchTimeTotal() + result.getTouchTimes());
				result.setNowTouchTime(result.getSocket().getTouchTime()
						+ result.getTouchTimes());
			}
			application.updateSocketOptionLog(result);
		}
	}

	@Override
	public Map<String, String> getReleaseInfo(Long socketId) {
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(socketId);
		StringBuilder jpql = new StringBuilder(
				"select o from SocketOptionLog o   where status = '程序Release' and o.socket.id=?");
		@SuppressWarnings("unchecked")
		List<SocketOptionLog> list = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		StringBuffer productModel = new StringBuffer();
		String equipmentList = "";
		String equipmentListId = "";
		for (SocketOptionLog pcol : list) {
			// if (pcol.getProductModel() == null
			// || "".equals(pcol.getProductModel())) {
			// continue;
			// }
			// productModel.append(pcol.getProductModel()).append(",");
			if (pcol.getPlatform() == null || "".equals(pcol.getPlatform())) {
				continue;
			}
			equipmentList = MyStringUtils.getReleaseInfo(equipmentList,
					pcol.getPlatform());
			equipmentListId = MyStringUtils.getReleaseInfo(equipmentListId,
					pcol.getPlatformIds());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("productModel", productModel.toString());
		map.put("equipmentList", equipmentList.toString());
		map.put("equipmentListId", equipmentListId.toString());
		return map;
	}

}

package acetecsemi.com.brick.facade.impl;

import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.servlet.ServletOutputStream;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.QueryChannelService;

import acetecsemi.com.brick.facade.ExportExcelFacade;
import acetecsemi.com.brick.facade.dto.ExcelExportEquipmentOptionLogDTO;
import acetecsemi.com.brick.facade.impl.assembler.ExcelExportEquipmentOptLogAssembler;
import acetecsemi.com.brick.facade.utils.ExportExcel;

@Named
public class ExportExcelFacadeImpl implements ExportExcelFacade {

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	@Override
	public void exportExcelTest(OutputStream outputStream) {
		// TODO Auto-generated method stub
		ExportExcel<Object[]> exportExcel = new ExportExcel<Object[]>();
		exportExcel.exportExcel(
				this.queryEquipmentStatus("2015-06-04", "2015-06-05", null),
				outputStream);
	}

	@Override
	public void exportExcelEquipmentStatus(OutputStream outputStream,
			String startTime, String endTime, Long equipmentCategroyId) {
		String[] titles = { "设备名称", "IDLE", "CHECK", "DOWN", "REWORK", "RUN",
				"SET_UP", "待ENG", "ENGINEERING", "ENG_RUN", "停机", "R/T_RUN",
				"LAT_RUN", "total" };
		String title = "设备状态报表";
		ExportExcel<Object[]> exportExcel = new ExportExcel<Object[]>();
		exportExcel.exportExcel(title, titles, this.queryEquipmentStatus(
				startTime, endTime, equipmentCategroyId), outputStream);
	}

	public List<Object[]> queryEquipmentStatus(String startTime,
			String endTime, Long equipmentCategroyId) {
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(startTime);
		conditionVals.add(endTime);
		conditionVals.add(startTime);
		conditionVals.add(endTime);
		StringBuilder jpql = new StringBuilder("SELECT equipmentNo,")
				.append("SUM(CASE WHEN STATUS = 'IDLE' THEN convert(duration/60/60,DECIMAL(10, 2))ELSE 0 END) `IDLE`,")
				.append("SUM(CASE WHEN STATUS = 'CHECK' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `CHECK`,")
				.append("SUM(CASE WHEN STATUS = 'DOWN' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `DOWN`,")
				.append("SUM(CASE WHEN STATUS = 'REWORK' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `REWORK`,")
				.append("SUM(CASE WHEN STATUS = 'RUN' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `RUN`,")
				.append("SUM(CASE WHEN STATUS = 'SET_UP' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `SET_UP`,")
				.append("SUM(CASE WHEN STATUS = '待ENG' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `ENG_WAIT`,")
				.append("SUM(CASE WHEN STATUS = 'ENGINEERING' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `ENGINEERING`,")
				.append("SUM(CASE WHEN STATUS = 'ENG_RUN' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `ENG_RUN`,")
				.append("SUM(CASE WHEN STATUS = '停机' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `停机`,")
				.append("SUM(CASE WHEN STATUS = 'R/T_RUN' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `R/T_RUN`,")
				.append("SUM(CASE WHEN STATUS = 'LAT_RUN' THEN convert(duration/60/60,DECIMAL(10, 2)) ELSE 0 END) `LAT_RUN`,")
				.append("CONVERT (SUM(duration) / 60 / 60, DECIMAL(10, 2)) total ")
				.append("FROM (")

				.append("SELECT brick_equipment.Category_ID, brick_equipment.equipmentNo, brick_statustoptionlog. STATUS, ")
				.append("brick_statustoptionlog.nowLot, brick_statustoptionlog.startTime st, brick_statustoptionlog.endTime et, ")
				.append("CASE WHEN brick_statustoptionlog.startTime < DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ")
				.append("THEN DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ELSE brick_statustoptionlog.startTime END startTime, ")
				.append("CASE WHEN brick_statustoptionlog.endTime IS NULL ")
				.append("THEN DATE_FORMAT( '")
				.append(endTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ELSE brick_statustoptionlog.endTime END endTime, ")
				.append("CASE WHEN brick_statustoptionlog.endTime IS NULL OR brick_statustoptionlog.endTime = '' OR duration IS NULL ")
				.append("OR ( brick_statustoptionlog.endTime > DATE_FORMAT( '")
				.append(endTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ")
				.append("AND brick_statustoptionlog.startTime > DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' )) ")
				.append("THEN TIME_TO_SEC( timediff( DATE_FORMAT( '")
				.append(endTime)
				.append("', '%Y-%m-%d %H:%i:%s' ), brick_statustoptionlog.startTime )) ")
				.append("WHEN ( brick_statustoptionlog.startTime < DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ")
				.append("AND brick_statustoptionlog.endTime > DATE_FORMAT( '")
				.append(endTime)
				.append("', '%Y-%m-%d %H:%i:%s' )) ")
				.append("THEN TIME_TO_SEC( timediff( DATE_FORMAT( '")
				.append(endTime)
				.append("', '%Y-%m-%d %H:%i:%s' ), DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' ))) ")
				.append("WHEN brick_statustoptionlog.startTime < DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ")
				.append("AND brick_statustoptionlog.endTime < DATE_FORMAT( '")
				.append(endTime)
				.append("', '%Y-%m-%d %H:%i:%s' ) ")
				.append("THEN TIME_TO_SEC( timediff( brick_statustoptionlog.endTime, DATE_FORMAT( '")
				.append(startTime)
				.append("', '%Y-%m-%d %H:%i:%s' ))) ")

				.append("ELSE brick_statustoptionlog.duration / 1000 END duration FROM brick_statustoptionlog ")
				.append("INNER JOIN brick_equipment ON brick_statustoptionlog.equipment_id = brick_equipment.id ")
				.append("WHERE brick_statustoptionlog.startTime != '' ")
				.append("AND ( brick_statustoptionlog.startTime BETWEEN DATE_FORMAT( ?, '%Y-%m-%d %H:%i:%s' ) AND DATE_FORMAT( ?, '%Y-%m-%d %H:%i:%s' ) ")
				.append("OR brick_statustoptionlog.endTime BETWEEN DATE_FORMAT( ?, '%Y-%m-%d %H:%i:%s' ) AND DATE_FORMAT( ?, '%Y-%m-%d %H:%i:%s' )")
				.append("OR ( brick_statustoptionlog.startTime < DATE_FORMAT( '")
				.append(startTime).append("', '%Y-%m-%d %H:%i:%s' ) ")
				.append("AND brick_statustoptionlog.endTime > DATE_FORMAT( '")
				.append(endTime).append("', '%Y-%m-%d %H:%i:%s' ))) ");

		if (equipmentCategroyId != null && !"".equals(equipmentCategroyId)) {
			jpql.append("AND brick_equipment.category_ID = ? ");
			conditionVals.add(equipmentCategroyId);
		} else {
			jpql.append("AND brick_equipment.equipmentCategory_ID in (7,10,11,12) ");
		}
		jpql.append(
				"ORDER BY brick_equipment.Category_ID,brick_equipment.equipmentNo,brick_statustoptionlog. STATUS,brick_statustoptionlog.startTime ")
				.append(") a ").append("GROUP BY equipmentNo");
		@SuppressWarnings("unchecked")
		List<Object[]> pages = getQueryChannelService()
				.createSqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return pages;
	}

	@Override
	public void exportExcelEquipmentOptionLog(OutputStream outputStream,
			String startTime, String endTime, Long equipmentCategroyId,
			String equipmentNo) {
		String[] titles = { "产品编号", "当前批次", "状态", "子状态", "开始时间", "结束时间",
				"持续时间(分钟)", "设备编号", "设备类型", "备注" };
		String title = "设备操作记录报表";
		ExportExcel<ExcelExportEquipmentOptionLogDTO> exportExcel = new ExportExcel<ExcelExportEquipmentOptionLogDTO>();
		exportExcel.exportExcel(title, titles,
				ExcelExportEquipmentOptLogAssembler.toDTOs(this
						.queryEquipmentOptionLog(startTime, endTime,
								equipmentCategroyId, equipmentNo)),
				outputStream);

	}

	public List<Object[]> queryEquipmentOptionLog(String startTime,
			String endTime, Long equipmentCategroyId, String equipmentNo) {
		List<Object> conditionVals = new ArrayList<Object>();
		conditionVals.add(startTime);
		conditionVals.add(endTime);
		StringBuilder jpql = new StringBuilder("")
				.append("select DISTINCT a.productModel,a.nowlot,a.`status`,a.subStatus,a.startTime,a.endTime,a.duration,b.equipmentNo,c.categoryName,a.optRemark ")
				.append("from brick_statustoptionlog a INNER JOIN brick_equipment b on a.EQUIPMENT_ID = b.ID ")
				.append("INNER JOIN brick_category c on b.equipmentCategory_ID = c.ID ")
				.append("where a.CATEGORY = 'EQUIPMENT' ")
				.append("and a.optDate BETWEEN ? and ? ");
		if (equipmentCategroyId != null && !"".equals(equipmentCategroyId)) {
			jpql.append("AND b.category_ID = ? ");
			conditionVals.add(equipmentCategroyId);
		}

		if (equipmentNo != null && !"".equals(equipmentNo)) {
			jpql.append("AND b.equipmentNo like ? ");
			conditionVals.add(MessageFormat.format("%{0}%", equipmentNo));
		}
		jpql.append("and a.productModel is not null AND a.productModel != '' ")
				.append("ORDER BY a.productModel");
		@SuppressWarnings("unchecked")
		List<Object[]> pages = getQueryChannelService()
				.createSqlQuery(jpql.toString()).setParameters(conditionVals)
				.list();
		return pages;
	}
}

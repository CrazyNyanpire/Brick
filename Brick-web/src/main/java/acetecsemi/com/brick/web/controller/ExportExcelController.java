package acetecsemi.com.brick.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.openkoala.koala.commons.InvokeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.utils.MyDateUtils;
import acetecsemi.com.brick.facade.ChangeStatusFacade;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;
import acetecsemi.com.brick.facade.ExportExcelFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;

@Controller
@RequestMapping("/Export/Excel")
public class ExportExcelController {

	@Inject
	private ExportExcelFacade exportExcelFacade;

	@ResponseBody
	@RequestMapping("/test")
	public String exportExcel(HttpServletResponse response) {
		response.setContentType("application/binary;charset=ISO8859_1");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("导出excel例子").getBytes(), "ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName + ".xls");// 组装附件名称和格式
			String hql = "from Goods";
			String[] titles = { "商品名", "商品单价", "商品单位" };
			exportExcelFacade.exportExcelTest(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@ResponseBody
	@RequestMapping("/equipmentStatus")
	public String exportExcelEquipmentStatus(HttpServletResponse response,
			@RequestParam String startTime, @RequestParam String endTime,
			@RequestParam Long equipmentCategoryId) {
		response.setContentType("application/binary;charset=ISO8859_1");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(
					("设备状态导出-" + MyDateUtils.getTodayTime("yyyy-MM-dd_HHmmss"))
							.getBytes(),
					"ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName + ".xls");// 组装附件名称和格式
			exportExcelFacade.exportExcelEquipmentStatus(outputStream,
					startTime, endTime, equipmentCategoryId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@ResponseBody
	@RequestMapping("/equipmentOptionLog")
	public String exportExcelEquipmentStatus(HttpServletResponse response,
			@RequestParam String startTime, @RequestParam String endTime,
			@RequestParam Long equipmentCategoryId,
			@RequestParam String equipmentNo) {
		response.setContentType("application/binary;charset=ISO8859_1");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(
					("设备操作日志导出-" + MyDateUtils.getTodayTime("yyyy-MM-dd_HHmmss"))
							.getBytes(), "ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName + ".xls");// 组装附件名称和格式
			exportExcelFacade.exportExcelEquipmentOptionLog(outputStream,
					startTime, endTime, equipmentCategoryId, equipmentNo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

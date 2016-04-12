package acetecsemi.com.brick.web.controller;

import javax.inject.Inject;

import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.EquipmentMaintenanceLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/EquipmentMaintenanceLog")
public class EquipmentMaintenanceLogController {

	@Inject
	private EquipmentMaintenanceLogFacade equipmentMaintenanceLogFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(
			EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO) {
		return equipmentMaintenanceLogFacade
				.creatEquipmentMaintenanceLog(equipmentMaintenanceLogDTO);
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(
			EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO) {
		return equipmentMaintenanceLogFacade
				.updateEquipmentMaintenanceLog(equipmentMaintenanceLogDTO);
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(EquipmentMaintenanceLogDTO equipmentMaintenanceLogDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<EquipmentMaintenanceLogDTO> all = equipmentMaintenanceLogFacade
				.pageQueryEquipmentMaintenanceLog(equipmentMaintenanceLogDTO,
						page, pagesize);
		return all;
	}

	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
		Long[] idArrs = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			idArrs[i] = Long.parseLong(value[i]);
		}
		return equipmentMaintenanceLogFacade
				.removeEquipmentMaintenanceLogs(idArrs);
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return equipmentMaintenanceLogFacade.getEquipmentMaintenanceLog(id);
	}

	@ResponseBody
	@RequestMapping("/findEquipmentByEquipmentMaintenanceLog/{id}")
	public Map<String, Object> findEquipmentByEquipmentMaintenanceLog(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", equipmentMaintenanceLogFacade
				.findEquipmentByEquipmentMaintenanceLog(id));
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/findEquipmentMaintenanceLog/{id}")
	public Map<String, Object> findEquipmentMaintenanceLog(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", equipmentMaintenanceLogFacade
				.findEquipmentMaintenanceLog(id));
		return result;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}

}

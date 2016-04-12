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
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/EquipmentOptionLog")
public class EquipmentOptionLogController extends BaseController {

	@Inject
	private EquipmentOptionLogFacade equipmentOptionLogFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(EquipmentOptionLogDTO equipmentOptionLogDTO) {
		return this.createInvokeResult(equipmentOptionLogFacade
				.creatEquipmentOptionLog(equipmentOptionLogDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(EquipmentOptionLogDTO equipmentOptionLogDTO) {
		return this.createInvokeResult(equipmentOptionLogFacade
				.updateEquipmentOptionLog(equipmentOptionLogDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(EquipmentOptionLogDTO equipmentOptionLogDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<EquipmentOptionLogDTO> all = equipmentOptionLogFacade
				.pageQueryEquipmentOptionLog(equipmentOptionLogDTO, page,
						pagesize);
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
		return this.createInvokeResult(equipmentOptionLogFacade
				.removeEquipmentOptionLogs(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(equipmentOptionLogFacade
				.getEquipmentOptionLog(id));
	}

	@ResponseBody
	@RequestMapping("/findEquipmentByEquipmentOptionLog/{id}")
	public Map<String, Object> findEquipmentByEquipmentOptionLog(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data",
				equipmentOptionLogFacade.findEquipmentByEquipmentOptionLog(id));
		return result;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormatTime = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "optDate*" , new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormatTime, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}

}

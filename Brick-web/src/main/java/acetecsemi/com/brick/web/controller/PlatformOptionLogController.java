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
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/PlatformOptionLog")
public class PlatformOptionLogController extends BaseController {

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(PlatformOptionLogDTO platformOptionLogDTO) {
		return this.createInvokeResult(platformOptionLogFacade
				.creatPlatformOptionLog(platformOptionLogDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(PlatformOptionLogDTO platformOptionLogDTO) {
		return this.createInvokeResult(platformOptionLogFacade
				.updatePlatformOptionLog(platformOptionLogDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(PlatformOptionLogDTO platformOptionLogDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<PlatformOptionLogDTO> all = platformOptionLogFacade
				.pageQueryPlatformOptionLog(platformOptionLogDTO, page,
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
		return this.createInvokeResult(platformOptionLogFacade
				.removePlatformOptionLogs(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(platformOptionLogFacade
				.getPlatformOptionLog(id));
	}

	@ResponseBody
	@RequestMapping("/findEquipmentByPlatformOptionLog/{id}")
	public Map<String, Object> findEquipmentByPlatformOptionLog(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data",
				platformOptionLogFacade.findEquipmentByPlatformOptionLog(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findPlatformByPlatformOptionLog/{id}")
	public Map<String, Object> findPlatformByPlatformOptionLog(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data",
				platformOptionLogFacade.findPlatformByPlatformOptionLog(id));
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

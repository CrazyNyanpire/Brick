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
import acetecsemi.com.brick.facade.ProbeCardOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/ProbeCardOptionLog")
public class ProbeCardOptionLogController extends BaseController {

	@Inject
	private ProbeCardOptionLogFacade probeCardOptionLogFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(ProbeCardOptionLogDTO probeCardOptionLogDTO) {
		return this.createInvokeResult(probeCardOptionLogFacade
				.creatProbeCardOptionLog(probeCardOptionLogDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(ProbeCardOptionLogDTO probeCardOptionLogDTO) {
		return this.createInvokeResult(probeCardOptionLogFacade
				.updateProbeCardOptionLog(probeCardOptionLogDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(ProbeCardOptionLogDTO probeCardOptionLogDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<ProbeCardOptionLogDTO> all = probeCardOptionLogFacade
				.pageQueryProbeCardOptionLog(probeCardOptionLogDTO, page,
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
		return this.createInvokeResult(probeCardOptionLogFacade
				.removeProbeCardOptionLogs(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(probeCardOptionLogFacade
				.getProbeCardOptionLog(id));
	}

	@ResponseBody
	@RequestMapping("/findProbeCardByProbeCardOptionLog/{id}")
	public Map<String, Object> findProbeCardByProbeCardOptionLog(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data",
				probeCardOptionLogFacade.findProbeCardByProbeCardOptionLog(id));
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

	@ResponseBody
	@RequestMapping("/findLastProbeCardOptionLog/{id}")
	public InvokeResult findLastProbeCardOptionLog(@PathVariable Long id) {
		return InvokeResult.success(probeCardOptionLogFacade
				.findLastProbeCardOptionLog(id));
	}
	
	@ResponseBody
	@RequestMapping("/updatelog")
	public InvokeResult updatelog(ProbeCardOptionLogDTO probeCardOptionLogDTO) {
		return InvokeResult.success(probeCardOptionLogFacade
				.updateLog(probeCardOptionLogDTO));
	}

}

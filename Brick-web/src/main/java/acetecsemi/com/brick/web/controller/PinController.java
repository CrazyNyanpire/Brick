package acetecsemi.com.brick.web.controller;

import javax.inject.Inject;

import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.PinFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/Pin")
public class PinController extends BaseController {

	@Inject
	private PinFacade pinFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(PinDTO pinDTO) {
		return this.createInvokeResult(pinFacade.creatPin(pinDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(PinDTO pinDTO) {
		return this.createInvokeResult(pinFacade.updatePin(pinDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(PinDTO pinDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<PinDTO> all = pinFacade.pageQueryPin(pinDTO, page, pagesize);
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
		return this.createInvokeResult(pinFacade.removePins(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(pinFacade.getPin(id));
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

	/**
	 * 入库
	 * 
	 * @param pinDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/inStorage")
	public InvokeResult inStorage(PinDTO pinDTO) {
		return this.createInvokeResult(pinFacade.inStorage(pinDTO));
	}

	/**
	 * 出库
	 * 
	 * @param pinDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/outStorage")
	public InvokeResult outStorage(PinDTO pinDTO) {
		return this.createInvokeResult(pinFacade.outStorage(pinDTO));
	}

}

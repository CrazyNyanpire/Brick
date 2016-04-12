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
import acetecsemi.com.brick.facade.SwiftNumberFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/SwiftNumber")
public class SwiftNumberController extends BaseController {

	@Inject
	private SwiftNumberFacade swiftNumberFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(SwiftNumberDTO swiftNumberDTO) {
		return this.createInvokeResult(swiftNumberFacade
				.creatSwiftNumber(swiftNumberDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(SwiftNumberDTO swiftNumberDTO) {
		return this.createInvokeResult(swiftNumberFacade
				.updateSwiftNumber(swiftNumberDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(SwiftNumberDTO swiftNumberDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<SwiftNumberDTO> all = swiftNumberFacade.pageQuerySwiftNumber(
				swiftNumberDTO, page, pagesize);
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
		return this.createInvokeResult(swiftNumberFacade
				.removeSwiftNumbers(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(swiftNumberFacade.getSwiftNumber(id));
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
	@RequestMapping("/getNextBorrowMachineSNs")
	public InvokeResult getNextSwiftNumberBorrowMachine() {
		return InvokeResult.success(swiftNumberFacade
				.getNextSwiftNumberBorrowMachine());
	}
}

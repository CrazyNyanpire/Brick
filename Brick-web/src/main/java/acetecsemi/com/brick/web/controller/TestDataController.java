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
import acetecsemi.com.brick.facade.BorrowMachineFacade;
import acetecsemi.com.brick.facade.PlatformFacade;
import acetecsemi.com.brick.facade.TestDataFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/TestData")
public class TestDataController extends BaseController {

	@Inject
	private TestDataFacade testDataFacade;

	@ResponseBody
	@RequestMapping("/ft")
	public InvokeResult getFTTestData(PlatformDTO platformDTO) {
		platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return testDataFacade.getFTTestData(platformDTO);
	}
	
	@ResponseBody
	@RequestMapping("/cp")
	public InvokeResult getCPTestData(PlatformDTO platformDTO) {
		platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return testDataFacade.getCPTestData(platformDTO);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}
}

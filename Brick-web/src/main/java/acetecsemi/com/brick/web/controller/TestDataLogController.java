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
import acetecsemi.com.brick.facade.TestDataLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/TestDataLog")
public class TestDataLogController {
		
	@Inject
	private TestDataLogFacade testDataLogFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(TestDataLogDTO testDataLogDTO) {
		return testDataLogFacade.creatTestDataLog(testDataLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(TestDataLogDTO testDataLogDTO) {
		return testDataLogFacade.updateTestDataLog(testDataLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(TestDataLogDTO testDataLogDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<TestDataLogDTO> all = testDataLogFacade.pageQueryTestDataLog(testDataLogDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        Long[] idArrs = new Long[value.length];
        for (int i = 0; i < value.length; i ++) {
        	        					idArrs[i] = Long.parseLong(value[i]);
						        }
        return testDataLogFacade.removeTestDataLogs(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return testDataLogFacade.getTestDataLog(id);
	}
	
		
    @InitBinder    
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    
        dateFormat.setLenient(false);    
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
        //CustomDateEditor 可以换成自己定义的编辑器。  
        //注册一个Date 类型的绑定器 。
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }
	
}

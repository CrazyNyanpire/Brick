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
import acetecsemi.com.brick.facade.PlatformCPOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/PlatformCPOptionLog")
public class PlatformCPOptionLogController {
		
	@Inject
	private PlatformCPOptionLogFacade platformCPOptionLogFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(PlatformCPOptionLogDTO platformCPOptionLogDTO) {
		return platformCPOptionLogFacade.creatPlatformCPOptionLog(platformCPOptionLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(PlatformCPOptionLogDTO platformCPOptionLogDTO) {
		return platformCPOptionLogFacade.updatePlatformCPOptionLog(platformCPOptionLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(PlatformCPOptionLogDTO platformCPOptionLogDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<PlatformCPOptionLogDTO> all = platformCPOptionLogFacade.pageQueryPlatformCPOptionLog(platformCPOptionLogDTO, page, pagesize);
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
        return platformCPOptionLogFacade.removePlatformCPOptionLogs(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return platformCPOptionLogFacade.getPlatformCPOptionLog(id);
	}
	
		@ResponseBody
	@RequestMapping("/findEquipmentByPlatformCPOptionLog/{id}")
	public Map<String, Object> findEquipmentByPlatformCPOptionLog(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", platformCPOptionLogFacade.findEquipmentByPlatformCPOptionLog(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findPlatformByPlatformCPOptionLog/{id}")
	public Map<String, Object> findPlatformByPlatformCPOptionLog(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", platformCPOptionLogFacade.findPlatformByPlatformCPOptionLog(id));
		return result;
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

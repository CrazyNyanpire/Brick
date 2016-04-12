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
import acetecsemi.com.brick.facade.PlatformFTOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/PlatformFTOptionLog")
public class PlatformFTOptionLogController {
		
	@Inject
	private PlatformFTOptionLogFacade platformFTOptionLogFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(PlatformFTOptionLogDTO platformFTOptionLogDTO) {
		return platformFTOptionLogFacade.creatPlatformFTOptionLog(platformFTOptionLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(PlatformFTOptionLogDTO platformFTOptionLogDTO) {
		return platformFTOptionLogFacade.updatePlatformFTOptionLog(platformFTOptionLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(PlatformFTOptionLogDTO platformFTOptionLogDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<PlatformFTOptionLogDTO> all = platformFTOptionLogFacade.pageQueryPlatformFTOptionLog(platformFTOptionLogDTO, page, pagesize);
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
        return platformFTOptionLogFacade.removePlatformFTOptionLogs(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return platformFTOptionLogFacade.getPlatformFTOptionLog(id);
	}
	
		@ResponseBody
	@RequestMapping("/findEquipmentByPlatformFTOptionLog/{id}")
	public Map<String, Object> findEquipmentByPlatformFTOptionLog(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", platformFTOptionLogFacade.findEquipmentByPlatformFTOptionLog(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findPlatformByPlatformFTOptionLog/{id}")
	public Map<String, Object> findPlatformByPlatformFTOptionLog(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", platformFTOptionLogFacade.findPlatformByPlatformFTOptionLog(id));
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

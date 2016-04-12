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
import acetecsemi.com.brick.facade.MaintenancePlatformFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
/**
 * 
 * @author harlow
 * 维修信息录入
 */
@Controller
@RequestMapping("/Maintenance")
public class MaintenancePlatformController  extends BaseController{
		
	@Inject
	private MaintenancePlatformFacade maintenancePlatformFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(MaintenancePlatformDTO maintenancePlatformDTO) {
		maintenancePlatformDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		maintenancePlatformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(maintenancePlatformFacade.creatMaintenancePlatform(maintenancePlatformDTO));
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(MaintenancePlatformDTO maintenancePlatformDTO) {
		maintenancePlatformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(maintenancePlatformFacade.updateMaintenancePlatform(maintenancePlatformDTO));
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(MaintenancePlatformDTO maintenancePlatformDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<MaintenancePlatformDTO> all = maintenancePlatformFacade.pageQueryMaintenancePlatform(maintenancePlatformDTO, page, pagesize);
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
        return this.createInvokeResult(maintenancePlatformFacade.removeMaintenancePlatforms(idArrs));
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(maintenancePlatformFacade.getMaintenancePlatform(id));
	}
	
		@ResponseBody
	@RequestMapping("/findPlatformByMaintenancePlatform/{id}")
	public Map<String, Object> findPlatformByMaintenancePlatform(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", maintenancePlatformFacade.findPlatformByMaintenancePlatform(id));
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

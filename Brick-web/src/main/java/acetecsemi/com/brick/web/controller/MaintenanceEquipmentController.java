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
import acetecsemi.com.brick.facade.MaintenanceEquipmentFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/MaintenanceEquipment")
public class MaintenanceEquipmentController {
		
	@Inject
	private MaintenanceEquipmentFacade maintenanceEquipmentFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(MaintenanceEquipmentDTO maintenanceEquipmentDTO) {
		return maintenanceEquipmentFacade.creatMaintenanceEquipment(maintenanceEquipmentDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(MaintenanceEquipmentDTO maintenanceEquipmentDTO) {
		return maintenanceEquipmentFacade.updateMaintenanceEquipment(maintenanceEquipmentDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(MaintenanceEquipmentDTO maintenanceEquipmentDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<MaintenanceEquipmentDTO> all = maintenanceEquipmentFacade.pageQueryMaintenanceEquipment(maintenanceEquipmentDTO, page, pagesize);
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
        return maintenanceEquipmentFacade.removeMaintenanceEquipments(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(maintenanceEquipmentFacade.getMaintenanceEquipment(id));
	}
	
		@ResponseBody
	@RequestMapping("/findEquipmentByMaintenanceEquipment/{id}")
	public Map<String, Object> findEquipmentByMaintenanceEquipment(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", maintenanceEquipmentFacade.findEquipmentByMaintenanceEquipment(id));
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

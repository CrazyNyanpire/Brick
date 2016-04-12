package acetecsemi.com.brick.web.controller;

import javax.inject.Inject;

import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import acetecsemi.com.brick.facade.KitsFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/Kits")
public class KitsController {
		
	@Inject
	private KitsFacade kitsFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(KitsDTO kitsDTO) {
		kitsDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		kitsDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return kitsFacade.creatKits(kitsDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(KitsDTO kitsDTO) {
		kitsDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return kitsFacade.updateKits(kitsDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(KitsDTO kitsDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<KitsDTO> all = kitsFacade.pageQueryKits(kitsDTO, page, pagesize);
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
        return kitsFacade.removeKitss(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return kitsFacade.getKits(id);
	}
	
		@ResponseBody
	@RequestMapping("/findStatusByKits/{id}")
	public Map<String, Object> findStatusByKits(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", kitsFacade.findStatusByKits(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findEquipmentByKits/{id}")
	public Map<String, Object> findEquipmentByKits(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", kitsFacade.findEquipmentByKits(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findNowPlatformByKits/{id}")
	public Map<String, Object> findNowPlatformByKits(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", kitsFacade.findNowPlatformByKits(id));
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
	
    /**
	 * 生产领出kits
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productAll")
	public List<KitsDTO> productAll(KitsDTO queryVo) {
		return kitsFacade.findProductAllKits(queryVo);
	}

	/**
	 * 所有kits
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/all")
	public List<KitsDTO> all() {
		return kitsFacade.findAllKits();
	}

	/**
	 * 改变Socket状态
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatus")
	public InvokeResult changeStatusSocket(KitsDTO kitsDTO) {
		kitsDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		kitsDTO.setLastModifyTimestamp(new Date());
		return kitsFacade.changeKitsStatus(kitsDTO);
	}

	/**
	 * 获取对应平台领取的kits
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getKitsByPlatformId/{id}")
	public InvokeResult changeStatusSocket(@PathVariable Long id) {
		return InvokeResult.success(kitsFacade.getKitsByPlatformId(id));
	}

}

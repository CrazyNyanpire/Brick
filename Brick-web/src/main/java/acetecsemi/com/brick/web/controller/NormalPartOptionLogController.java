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
import acetecsemi.com.brick.facade.NormalPartFacade;
import acetecsemi.com.brick.facade.NormalPartOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/NormalPartOptionLog")
public class NormalPartOptionLogController {
		
	@Inject
	private NormalPartOptionLogFacade normalPartOptionLogFacade;
	@Inject
	private NormalPartFacade normalPartFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(NormalPartOptionLogDTO normalPartOptionLogDTO,@RequestParam long id) {
		NormalPartDTO normalPartDTO=new NormalPartDTO();
		normalPartDTO=normalPartFacade.getNormalParts(id);
		normalPartDTO.setStatus(normalPartOptionLogDTO.getStatus());
		normalPartDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		normalPartDTO.setLastModifyTimestamp(new Date());
		normalPartFacade.updateNormalPart(normalPartDTO);
		normalPartOptionLogDTO.setNormalPartDTO(normalPartDTO);
		normalPartOptionLogDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		return normalPartOptionLogFacade.creatNormalPartOptionLog(normalPartOptionLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(NormalPartOptionLogDTO normalPartOptionLogDTO) {
		return normalPartOptionLogFacade.updateNormalPartOptionLog(normalPartOptionLogDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(NormalPartOptionLogDTO normalPartOptionLogDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<NormalPartOptionLogDTO> all = normalPartOptionLogFacade.pageQueryNormalPartOptionLog(normalPartOptionLogDTO, page, pagesize);
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
        return normalPartOptionLogFacade.removeNormalPartOptionLogs(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return normalPartOptionLogFacade.getNormalPartOptionLog(id);
	}
	
		@ResponseBody
	@RequestMapping("/findNormalPartByNormalPartOptionLog/{id}")
	public Map<String, Object> findNormalPartByNormalPartOptionLog(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", normalPartOptionLogFacade.findNormalPartByNormalPartOptionLog(id));
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

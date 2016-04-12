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
import acetecsemi.com.brick.facade.PMDocumentFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/PMDocument")
public class PMDocumentController {

	@Inject
	private PMDocumentFacade pMDocumentFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(PMDocumentDTO pMDocumentDTO) {
		pMDocumentDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		pMDocumentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return pMDocumentFacade.creatPMDocument(pMDocumentDTO);
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(PMDocumentDTO pMDocumentDTO) {
		pMDocumentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return pMDocumentFacade.updatePMDocument(pMDocumentDTO);
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(PMDocumentDTO pMDocumentDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<PMDocumentDTO> all = pMDocumentFacade.pageQueryPMDocument(
				pMDocumentDTO, page, pagesize);
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
		return pMDocumentFacade.removePMDocuments(idArrs);
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return pMDocumentFacade.getPMDocument(id);
	}

	@ResponseBody
	@RequestMapping("/findEquipmentOptionLogByPMDocument/{id}")
	public Map<String, Object> findEquipmentOptionLogByPMDocument(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data",
				pMDocumentFacade.findEquipmentOptionLogByPMDocument(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/signPMDocument")
	public InvokeResult signPMDocument(PMDocumentDTO pMDocumentDTO) {
		pMDocumentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return pMDocumentFacade.signPMDocument(pMDocumentDTO);
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

}

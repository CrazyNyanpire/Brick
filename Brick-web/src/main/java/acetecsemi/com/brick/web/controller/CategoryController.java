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
import acetecsemi.com.brick.facade.CategoryFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/Category")
public class CategoryController extends BaseController {

	@Inject
	private CategoryFacade categoryFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CategoryDTO categoryDTO) {
		return this.createInvokeResult(categoryFacade.creatCategory(categoryDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CategoryDTO categoryDTO) {
		return this.createInvokeResult(categoryFacade.updateCategory(categoryDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CategoryDTO categoryDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<CategoryDTO> all = categoryFacade.pageQueryCategory(categoryDTO,
				page, pagesize);
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
		return this.createInvokeResult(categoryFacade.removeCategorys(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(categoryFacade.getCategory(id));
	}

	@ResponseBody
	@RequestMapping("/findCategoryParentByCategory/{id}")
	public Map<String, Object> findCategoryParentByCategory(
			@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", categoryFacade.findCategoryParentByCategory(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findCategoryChildrenByCategory/{id}")
	public Page findCategoryChildrenByCategory(@PathVariable Long id,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<CategoryDTO> all = categoryFacade.findCategoryChildrenByCategory(
				id, page, pagesize);
		return all;
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
	
	/**
	 * 所有可挂状态的平台及设备分类
	 * @param 
	 * @return
	 */
/*	@ResponseBody
	@RequestMapping("/changeStatusAll")
	public InvokeResult assemble() {
		return InvokeResult.success(categoryFacade.changeStatusCategorys());
	}*/
	
	/**
	 * 所有可挂状态的平台、设备分类及位置
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatusAll")
	public InvokeResult changeStatusTree() {
		return InvokeResult.success(categoryFacade.changeStatusTree());
	}
	
	/**
	 * 获取当前状态的下一个状态
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/nextStatusCategorys/{id}")
	public InvokeResult nextStatusCategorys(@PathVariable Long id) {
		return InvokeResult.success(categoryFacade.nextStatusCategorys(id));
	}
	
	@ResponseBody
	@RequestMapping("/getByType/{id}")
	public InvokeResult getByType(@PathVariable Long id, @RequestParam String type) {
		if(type != null && "".equals(type)){
			type = null;
		}
		return InvokeResult.success(categoryFacade.getCategory(id,type));
	}

	@ResponseBody
	@RequestMapping("/getEquipmentTree")
	public InvokeResult getEquipmentTree() {
		CategoryDTO categoryDTO = categoryFacade.getCategory(Long.valueOf(6));
		List<CategoryDTO> categoryDTOList = categoryDTO.getCategoryChildren();
		categoryDTOList.add(categoryFacade.getCategory(Long.valueOf(35)));
		categoryDTO.setCategoryChildren(categoryDTOList);
		return InvokeResult.success(categoryDTO);
	}
}

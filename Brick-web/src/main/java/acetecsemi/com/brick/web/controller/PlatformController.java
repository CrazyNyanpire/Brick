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
import acetecsemi.com.brick.facade.CategoryFacade;
import acetecsemi.com.brick.facade.EquipmentFacade;
import acetecsemi.com.brick.facade.PlatformFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/Platform")
public class PlatformController extends BaseController {

	@Inject
	private PlatformFacade platformFacade;

	@Inject
	private CategoryFacade categoryFacade;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	@Inject
	private EquipmentFacade equipmentFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(PlatformDTO platformDTO) {
		platformDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(platformFacade
				.creatPlatform(platformDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(PlatformDTO platformDTO) {
		platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(platformFacade
				.updatePlatform(platformDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(PlatformDTO platformDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<PlatformDTO> all = platformFacade.pageQueryPlatform(platformDTO,
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
		return this.createInvokeResult(platformFacade.removePlatforms(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(platformFacade.getPlatform(id));
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
	 * 通过平台查找组装设备
	 * 
	 * @param id
	 *            平台id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEquipmentByPlatform/{id}")
	public Map<String, Object> findPlatformByEquipment(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", equipmentFacade.findEquipmentByPlatform(id));
		return result;
	}

	/**
	 * 平台组装
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId,platformDTO.getEquipmentIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/assemble")
	public InvokeResult assemble(PlatformDTO platformDTO) {
		platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		platformFacade.splitPlatform(platformDTO);
		return this.createInvokeResult(platformFacade
				.assemblePlatform(platformDTO));
	}

	/**
	 * 平台组装
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId,platformDTO.getEquipmentIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/split")
	public InvokeResult split(PlatformDTO platformDTO) {
		platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		if (platformFacade.splitPlatform(platformDTO)) {
			return InvokeResult.success("解除绑定成功！");
		}
		return InvokeResult.failure("解除绑定失败");
	}

	/**
	 * 平台嫁动
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId,platformDTO.getStatus
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changePlatformStatus")
	public InvokeResult changePlatformStatus(PlatformDTO platformDTO) {
		if (platformDTO.getOptUser() != null
				&& !"".equals(platformDTO.getOptUser())) {
			platformDTO.setLastModifyEmployNo(platformDTO.getOptUser());
		} else {
			platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
			platformDTO.setOptUser(platformDTO.getLastModifyEmployNo());
		}
		if (platformDTO.getChipSelection() == null) {
			platformDTO.setChipSelection(platformDTO.getPianxuan());
			platformDTO.setChipSelectionRemark(platformDTO.getPianxuanBeizhu());
		}
		return this.createInvokeResult(platformFacade
				.changePlatformStatus(platformDTO));
	}

	/**
	 * 平台嫁动
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId,platformDTO.getStatus
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changePlatformStatusAll")
	public InvokeResult changePlatformStatusAll(PlatformDTO platformDTO) {
		if (platformDTO.getOptUser() == null
				|| "".equals(platformDTO.getOptUser())) {
			platformDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
			platformDTO.setOptUser(platformDTO.getLastModifyEmployNo());
		} else {
			platformDTO.setLastModifyEmployNo(platformDTO.getOptUser());
		}
		platformDTO.setEndTime(new Date());
		platformDTO.setOptDate(platformDTO.getEndTime());
		platformOptionLogFacade.changeStatusAll(platformDTO);
		return InvokeResult.success();
	}

	/**
	 * 所有平台
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/all")
	public InvokeResult assemble() {
		return InvokeResult.success(platformFacade.findAllPlatform());
	}

	/**
	 * 通过类型查找平台（CP、FT）
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findByType")
	public InvokeResult findByType(@RequestParam String type) {
		return InvokeResult.success(platformFacade.findPlatformByType(type));
	}

	/**
	 * 通过平台查找组装设备包含tester
	 * 
	 * @param id
	 *            平台id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEquipmentsByPlatform/{id}")
	public Map<String, Object> findEquipmentsByPlatform(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", platformFacade.findEquipmentsByPlatform(id));
		return result;
	}

	/**
	 * 获取平台最后一条操作记录
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLastPlatformOptionLog/{id}")
	public InvokeResult getLastPlatformOptionLog(@PathVariable Long id) {
		return InvokeResult.success(platformOptionLogFacade
				.getLastPlatformOptionLog(id));
	}

	/**
	 * 获取平台最后一条操作记录
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLastPlatformOptionLogForMES/{id}")
	public InvokeResult getLastPlatformOptionLogForMES(@PathVariable Long id) {
		PlatformOptionLogDTO platformOptionLogDTO = platformOptionLogFacade
				.getLastPlatformOptionLog(id);
		platformOptionLogDTO.setChipSelectionSingle(this
				.createChipSelectionSingle(platformOptionLogDTO));
		return InvokeResult.success(platformOptionLogDTO);
	}

	private String createChipSelectionSingle(
			PlatformOptionLogDTO platformOptionLogDTO) {
		String chipSelection = platformOptionLogDTO.getChipSelection();
		String[] chipSelectionRemark = platformOptionLogDTO
				.getChipSelectionRemark().split(",");
		StringBuffer chipSelectionSingle = new StringBuffer();
		for (int i = 1; i <= chipSelectionRemark.length; i++) {
			String csr = chipSelectionRemark[i - 1];
			if (csr.length() > 0) {
				chipSelectionSingle.append("0/").append(csr);
			} else if (chipSelection.indexOf(String.valueOf(i)) > -1) {
				chipSelectionSingle.append("1/0");
			} else {
				chipSelectionSingle.append("0/0");
			}
			if (i < chipSelectionRemark.length) {
				chipSelectionSingle.append(",");
			}
		}
		return chipSelectionSingle.toString();
	}

	/**
	 * 通过equipmentNo获取平台信息
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getPlatformNo()
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPlatformByPlatformNo")
	public InvokeResult findPlatformByEquipmentNo(PlatformDTO platformDTO) {
		PlatformDTO PlatformDTO = this.platformFacade
				.findPlatformByEquipmentNo(platformDTO.getPlatformNo());
		PlatformDTO.setStatusCode(categoryFacade.getCategoryByName(
				PlatformDTO.getStatus()).getCategoryCode());
		return InvokeResult.success(PlatformDTO);
	}
}

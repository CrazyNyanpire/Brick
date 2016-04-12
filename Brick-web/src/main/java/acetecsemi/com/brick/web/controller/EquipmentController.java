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
import acetecsemi.com.brick.facade.EquipmentFacade;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/Equipment")
public class EquipmentController extends BaseController {

	@Inject
	private EquipmentFacade equipmentFacade;

	@Inject
	private EquipmentOptionLogFacade equipmentOptionLogFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(EquipmentDTO equipmentDTO) {
		equipmentDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		equipmentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(equipmentFacade
				.creatEquipment(equipmentDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(EquipmentDTO equipmentDTO) {
		equipmentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(equipmentFacade
				.updateEquipment(equipmentDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(EquipmentDTO equipmentDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<EquipmentDTO> all = equipmentFacade.pageQueryEquipment(
				equipmentDTO, page, pagesize);
		return all;
	}

	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult removeLogic(@RequestParam String ids) {
		String[] value = ids.split(",");
		Long[] idArrs = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			idArrs[i] = Long.parseLong(value[i]);
		}
		return equipmentFacade.removeLogicEquipments(idArrs);
	}

	@ResponseBody
	@RequestMapping("/deleteAll")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
		Long[] idArrs = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			idArrs[i] = Long.parseLong(value[i]);
		}
		return this
				.createInvokeResult(equipmentFacade.removeEquipments(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(equipmentFacade.getEquipment(id));
	}

	@ResponseBody
	@RequestMapping("/findPlatformByEquipment/{id}")
	public Map<String, Object> findPlatformByEquipment(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", equipmentFacade.findPlatformByEquipment(id));
		return result;
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
	 * 通过条件查找设备列表
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEquipments/{id}")
	public Map<String, Object> findPlatformByEquipment(EquipmentDTO equipmentDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", equipmentFacade.findEquipments(equipmentDTO));
		return result;
	}

	/**
	 * 获取可组装设备列表
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findComposabilityEquipments")
	public Map<String, Object> findComposabilityEquipments() {
		Map<String, Object> result = new HashMap<String, Object>();
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		equipmentDTO.setComposability(true);
		equipmentDTO.setIsInstalled(false);// 过滤是否已经被组装
		result.put("data", equipmentFacade.findEquipments(equipmentDTO));
		return result;
	}

	/**
	 * 获取可改变设备状态列表
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findChangeStatusEquipments")
	public Map<String, Object> findChangeStatusEquipments() {
		Map<String, Object> result = new HashMap<String, Object>();
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		equipmentDTO.setComposability(true);
		result.put("data", equipmentFacade.findEquipments(equipmentDTO));
		return result;
	}

	/**
	 * 获取Tester设备列表
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findTesterEquipments")
	public Map<String, Object> findTesterEquipments() {
		Map<String, Object> result = new HashMap<String, Object>();
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		equipmentDTO.setEquipmentCategoryId(Long.valueOf(7));
		equipmentDTO.setUnInstallTester(true);
		result.put("data", equipmentFacade.findEquipments(equipmentDTO));
		return result;
	}

	/**
	 * 根据条件获取设备列表
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEquipments")
	public Map<String, Object> findTesterEquipments(EquipmentDTO equipmentDTO) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", equipmentFacade.findEquipments(equipmentDTO));
		return result;
	}

	/**
	 * 改变设备状态
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatus")
	public InvokeResult changeStatusEquipments(EquipmentDTO equipmentDTO) {
		if (equipmentDTO.getOptUser() != null
				&& !"".equals(equipmentDTO.getOptUser())) {
			equipmentDTO.setLastModifyEmployNo(equipmentDTO.getOptUser());
		} else {
			equipmentDTO
					.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
			equipmentDTO.setOptUser(equipmentDTO.getLastModifyEmployNo());
		}
		return this.createInvokeResult(equipmentFacade
				.changeEquipmentStatus(equipmentDTO));
	}

	/**
	 * 查询可改变设备状态设备
	 * 
	 * @param equipmentDTO
	 * @param page
	 * @param pagesize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatusPageJson")
	public Page changeStatusPageJson(EquipmentDTO equipmentDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<EquipmentDTO> all = equipmentFacade
				.changeStatusPageQueryEquipment(equipmentDTO, page, pagesize);
		return all;
	}

	/**
	 * 改变设备状态
	 * 
	 * @param equipmentDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEquipmentCategroyAll")
	public InvokeResult changeStatusEquipments() {
		return InvokeResult.success(equipmentFacade.findEquipmentCategroyAll());
	}

	/**
	 * 获取平台最后一条操作记录
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLastEquipmentOptionLog/{id}")
	public InvokeResult getLastPlatformOptionLog(@PathVariable Long id) {
		return InvokeResult.success(equipmentOptionLogFacade
				.getLastEquipmentOptionLog(id));
	}

	/**
	 * 判断设备是否被组装
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkEquipmentAssemble/{id}")
	public InvokeResult checkEquipmentAssemble(@PathVariable Long id) {
		return equipmentFacade.checkEquipmentAssemble(id);
	}

	@ResponseBody
	@RequestMapping("/getEquipmentNo")
	public InvokeResult getEquipmentNo(EquipmentDTO equipmentDTO) {
		List<Map<String, String>> all = equipmentFacade
				.getEquipmentNoByLot(equipmentDTO);
		return InvokeResult.success(all);
	}

}

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
import acetecsemi.com.brick.facade.ProbeCardFacade;
import acetecsemi.com.brick.infra.MaintenanceProbeCardSendNotice;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/ProbeCard")
public class ProbeCardController extends BaseController {

	@Inject
	private ProbeCardFacade probeCardFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		probeCardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(probeCardFacade
				.creatProbeCard(probeCardDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(probeCardFacade
				.updateProbeCard(probeCardDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(ProbeCardDTO probeCardDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<ProbeCardDTO> all = probeCardFacade.pageQueryProbeCard(
				probeCardDTO, page, pagesize);
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
		return this
				.createInvokeResult(probeCardFacade.removeProbeCards(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(probeCardFacade.getProbeCard(id));
	}

	@ResponseBody
	@RequestMapping("/all")
	public List<ProbeCardDTO> all(@PathVariable Long id) {
		return probeCardFacade.findAllProbeCard();
	}

	@ResponseBody
	@RequestMapping("/findManufacturerByProbeCard/{id}")
	public Map<String, Object> findManufacturerByProbeCard(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", probeCardFacade.findManufacturerByProbeCard(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findEquipmentByProbeCard/{id}")
	public Map<String, Object> findEquipmentByProbeCard(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", probeCardFacade.findEquipmentByProbeCard(id));
		return result;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		SimpleDateFormat dateFormatDef = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormatDef, true));
		binder.registerCustomEditor(Date.class, "optDate",
				new CustomDateEditor(dateFormat, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}

	/**
	 * 改变ProbeCard状态
	 * 
	 * @param probeCardDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatus")
	public InvokeResult changeStatusProbeCard(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(probeCardFacade
				.changeProbeCardStatus(probeCardDTO));
	}

	/**
	 * 平台挂状态记录probe card日志
	 * 
	 * @param probeCardDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/runLog")
	public InvokeResult runLog(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(probeCardFacade.runLog(probeCardDTO));
	}

	/**
	 * 生产领出probe card
	 * 
	 * @param probeCardDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productAll")
	public List<ProbeCardDTO> productAll(ProbeCardDTO probeCardDTO) {
		return probeCardFacade.findProductAllProbeCard(probeCardDTO);
	}

	/**
	 * 获取对应平台领取的ProbeCard
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getProbeCardByPlatformId/{id}")
	public InvokeResult getProbeCardByPlatformId(@PathVariable Long id) {
		return InvokeResult.success(probeCardFacade
				.getProbeCardByPlatformId(id));
	}

	/**
	 * 获取对应平台领取的ProbeCard
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getProbeCardListByPlatformId/{id}")
	public List<ProbeCardDTO> getProbeCardListByPlatformId(@PathVariable Long id) {
		return probeCardFacade.getProbeCardByPlatformId(id);
	}

	@ResponseBody
	@RequestMapping("/updateTouchdownNum")
	public InvokeResult updateTouchdownNum(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return InvokeResult.success(probeCardFacade
				.updateTouchdownNum(probeCardDTO));
	}
	
	@ResponseBody
	@RequestMapping("/updateRelease")
	public InvokeResult updateRelease(ProbeCardDTO probeCardDTO) {
		probeCardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return InvokeResult.success(probeCardFacade
				.updateRelease(probeCardDTO));
	}
	
	@Inject
	private MaintenanceProbeCardSendNotice maintenanceProbeCardSendNotice;
	@ResponseBody
	@RequestMapping("/notice")
	public InvokeResult notice() {
		 maintenanceProbeCardSendNotice.sendNoticeMail();
		 return InvokeResult.success();
	}
}

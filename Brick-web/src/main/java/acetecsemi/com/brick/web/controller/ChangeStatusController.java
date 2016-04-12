package acetecsemi.com.brick.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.openkoala.koala.commons.InvokeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.ChangeStatusFacade;
import acetecsemi.com.brick.facade.EquipmentOptionLogFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;

@Controller
@RequestMapping("/ChangeStatus")
public class ChangeStatusController {

	@Inject
	private ChangeStatusFacade changeStatusFacade;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	@Inject
	private EquipmentOptionLogFacade equipmentOptionLogFacade;

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(ChangeStatusDTO changeStatusDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<ChangeStatusDTO> all = changeStatusFacade.pageQueryChangeStatus(
				changeStatusDTO, page, pagesize);
		return all;
	}

	@ResponseBody
	@RequestMapping("/OptionLog/pageJson")
	public Page pageJsonOptionLog(ChangeStatusDTO changeStatusDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<ChangeStatusDTO> all = changeStatusFacade.pageQueryChangeStatus(
				changeStatusDTO, page, pagesize);
		return all;
	}

	/**
	 * 获取平台最后一条操作记录
	 * 
	 * @param platformDTO需要
	 *            platformDTO.getId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLastOptionLog")
	public InvokeResult getLastPlatformOptionLog(ChangeStatusDTO changeStatusDTO) {
		if ("PLATFORM".equals(changeStatusDTO.getCategory().toUpperCase())) {
			return InvokeResult.success(platformOptionLogFacade
					.getLastPlatformOptionLog(changeStatusDTO.getId()));
		} else {
			return InvokeResult.success(this.equipmentOptionLogFacade
					.getLastEquipmentOptionLog(changeStatusDTO.getId()));
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/changeStatusList")
	public InvokeResult changeStatusList(ChangeStatusDTO changeStatusDTO) {
		List<ChangeStatusDTO> all = changeStatusFacade.pageQueryChangeStatus(changeStatusDTO, 0, 10000).getData();
		return InvokeResult.success(all);
	}

}

package acetecsemi.com.brick.web.controller;

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
import acetecsemi.com.brick.facade.OAUserFacade;
import acetecsemi.com.brick.facade.PlatformOptionLogFacade;

@Controller
@RequestMapping("/OAUser")
public class OAUserController {

	@Inject
	private OAUserFacade oaUserFacade;

	/**
	 * 查询所有用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public InvokeResult getLastPlatformOptionLog() {
		return InvokeResult.success(this.oaUserFacade.findAll());
	}

	/**
	 * 通过条件查询用户
	 * @param oaUserDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findByCondition")
	public InvokeResult getOAUserByCondition(OAUserDTO oaUserDTO) {
		return InvokeResult.success(oaUserFacade.findByCondition(oaUserDTO));
	}
}

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
import acetecsemi.com.brick.facade.SocketFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/Socket")
public class SocketController extends BaseController {

	@Inject
	private SocketFacade socketFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(SocketDTO socketDTO) {
		socketDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		socketDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(socketFacade.creatSocket(socketDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(SocketDTO socketDTO) {
		socketDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(socketFacade.updateSocket(socketDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(SocketDTO socketDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<SocketDTO> all = socketFacade.pageQuerySocket(socketDTO, page,
				pagesize);
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
		return this.createInvokeResult(socketFacade.removeSockets(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(socketFacade.getSocket(id));
	}

	@ResponseBody
	@RequestMapping("/findEquipmentBySocket/{id}")
	public Map<String, Object> findEquipmentBySocket(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", socketFacade.findEquipmentBySocket(id));
		return result;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		SimpleDateFormat dateFormatDef = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(Date.class, "inDate", new CustomDateEditor(
				dateFormatDef, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}

	/**
	 * 生产领出socket
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productAll")
	public List<SocketDTO> productAll(SocketDTO queryVo) {
		return socketFacade.findProductAllSocket(queryVo);
	}

	/**
	 * 所有socket
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/all")
	public List<SocketDTO> all() {
		return socketFacade.findAllSocket();
	}

	/**
	 * 改变Socket状态
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatus")
	public InvokeResult changeStatusSocket(SocketDTO socketDTO) {
		socketDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return socketFacade.changeSocketStatus(socketDTO);
	}

	/**
	 * 获取对应平台领取的socket
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSocketByPlatformId/{id}")
	public InvokeResult changeStatusSocket(@PathVariable Long id) {
		return InvokeResult.success(socketFacade.getSocketByPlatformId(id));
	}

}

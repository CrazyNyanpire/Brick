package acetecsemi.com.brick.web.controller;

import javax.inject.Inject;

import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.BorrowMachineFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/BorrowMachine")
public class BorrowMachineController extends BaseController {

	@Inject
	private BorrowMachineFacade borrowMachineFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(BorrowMachineDTO borrowMachineDTO) {
		borrowMachineDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		Date nowDate = new Date();
		borrowMachineDTO.setAppTime(nowDate);
		return this.createInvokeResult(borrowMachineFacade
				.creatBorrowMachine(borrowMachineDTO));
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(BorrowMachineDTO borrowMachineDTO) {
		borrowMachineDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(borrowMachineFacade
				.updateBorrowMachine(borrowMachineDTO));
	}

	@ResponseBody
	@RequestMapping("/approve")
	public InvokeResult approve(BorrowMachineDTO borrowMachineDTO) {
		borrowMachineDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(borrowMachineFacade
				.approveBorrowMachine(borrowMachineDTO));
	}

	/**
	 * 办理借机
	 * 
	 * @param borrowMachineDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/borrowMachine")
	public InvokeResult borrowMachine(BorrowMachineDTO borrowMachineDTO) {
		borrowMachineDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(borrowMachineFacade
				.handleBorrowMachine(borrowMachineDTO));
	}

	/**
	 * 办理还机
	 * 
	 * @param borrowMachineDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/returnMachine")
	public InvokeResult returnMachine(BorrowMachineDTO borrowMachineDTO) {
		borrowMachineDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return this.createInvokeResult(borrowMachineFacade
				.handlereturnMachine(borrowMachineDTO));
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(BorrowMachineDTO borrowMachineDTO,
			@RequestParam int page, @RequestParam int pagesize) {
		Page<BorrowMachineDTO> all = borrowMachineFacade
				.pageQueryBorrowMachine(borrowMachineDTO, page, pagesize);
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
		return this.createInvokeResult(borrowMachineFacade
				.removeBorrowMachines(idArrs));
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(borrowMachineFacade.getBorrowMachine(id));
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}

	/**
	 * 撤销借机
	 * 
	 * @param borrowMachineDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cancelMachine")
	public InvokeResult cancelMachine(@RequestParam String ids,
			@RequestParam String status) {
		BorrowMachineDTO borrowMachineDTO = new BorrowMachineDTO();
		borrowMachineDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		borrowMachineDTO.setId(Long.parseLong(ids));
		borrowMachineDTO.setState(status);
		return this.createInvokeResult(borrowMachineFacade
				.cancelBorrowMachine(borrowMachineDTO));
	}
}

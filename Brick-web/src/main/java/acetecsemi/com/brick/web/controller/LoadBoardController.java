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
import acetecsemi.com.brick.facade.LoadBoardFacade;

import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;

@Controller
@RequestMapping("/LoadBoard")
public class LoadBoardController {

	@Inject
	private LoadBoardFacade loadBoardFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(LoadBoardDTO loadBoardDTO) {
		loadBoardDTO.setCreateEmployNo(CurrentUser.getUserNameAccount());
		loadBoardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return loadBoardFacade.creatLoadBoard(loadBoardDTO);
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(LoadBoardDTO loadBoardDTO) {
		loadBoardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		return loadBoardFacade.updateLoadBoard(loadBoardDTO);
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(LoadBoardDTO loadBoardDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<LoadBoardDTO> all = loadBoardFacade.pageQueryLoadBoard(
				loadBoardDTO, page, pagesize);
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
		return loadBoardFacade.removeLoadBoards(idArrs);
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return loadBoardFacade.getLoadBoard(id);
	}

	@ResponseBody
	@RequestMapping("/findStatusByLoadBoard/{id}")
	public Map<String, Object> findStatusByLoadBoard(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", loadBoardFacade.findStatusByLoadBoard(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findEquipmentByLoadBoard/{id}")
	public Map<String, Object> findEquipmentByLoadBoard(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", loadBoardFacade.findEquipmentByLoadBoard(id));
		return result;
	}

	@ResponseBody
	@RequestMapping("/findNowPlatformByLoadBoard/{id}")
	public Map<String, Object> findNowPlatformByLoadBoard(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", loadBoardFacade.findNowPlatformByLoadBoard(id));
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
	 * 生产领出loadBoard
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productAll")
	public List<LoadBoardDTO> productAll(LoadBoardDTO queryVo) {
		return loadBoardFacade.findProductAllLoadBoard(queryVo);
	}

	/**
	 * 所有loadBoard
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/all")
	public List<LoadBoardDTO> all() {
		return loadBoardFacade.findAllLoadBoard();
	}

	/**
	 * 改变Socket状态
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeStatus")
	public InvokeResult changeStatusSocket(LoadBoardDTO loadBoardDTO) {
		loadBoardDTO.setLastModifyEmployNo(CurrentUser.getUserNameAccount());
		loadBoardDTO.setLastModifyTimestamp(new Date());
		return loadBoardFacade.changeLoadBoardStatus(loadBoardDTO);
	}

	/**
	 * 获取对应平台领取的loadBoard
	 * 
	 * @param socketDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLoadBoardByPlatformId/{id}")
	public InvokeResult changeStatusSocket(@PathVariable Long id) {
		return InvokeResult.success(loadBoardFacade
				.getLoadBoardByPlatformId(id));
	}
}

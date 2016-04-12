package acetecsemi.com.brick.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface LoadBoardFacade {

	public InvokeResult getLoadBoard(Long id);

	public InvokeResult creatLoadBoard(LoadBoardDTO loadBoard);

	public InvokeResult updateLoadBoard(LoadBoardDTO loadBoard);

	public InvokeResult removeLoadBoard(Long id);

	public InvokeResult removeLoadBoards(Long[] ids);

	public List<LoadBoardDTO> findAllLoadBoard();

	public Page<LoadBoardDTO> pageQueryLoadBoard(LoadBoardDTO loadBoard,
			int currentPage, int pageSize);

	public CategoryDTO findStatusByLoadBoard(Long id);

	public EquipmentDTO findEquipmentByLoadBoard(Long id);

	public PlatformDTO findNowPlatformByLoadBoard(Long id);

	public List<LoadBoardDTO> findProductAllLoadBoard(LoadBoardDTO queryVo);

	public InvokeResult changeLoadBoardStatus(LoadBoardDTO loadBoardDTO);

	public List<LoadBoardDTO> getLoadBoardByPlatformId(Long id);

	public String runLog(LoadBoardDTO loadBoardDTO);

}

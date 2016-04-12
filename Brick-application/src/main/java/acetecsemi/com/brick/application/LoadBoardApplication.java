package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.LoadBoard;

public interface LoadBoardApplication {

	public LoadBoard getLoadBoard(Long id);
	
	public void creatLoadBoard(LoadBoard loadBoard);
	
	public void updateLoadBoard(LoadBoard loadBoard);
	
	public void removeLoadBoard(LoadBoard loadBoard);
	
	public void removeLoadBoards(Set<LoadBoard> loadBoards);
	
	public List<LoadBoard> findAllLoadBoard();
	
}


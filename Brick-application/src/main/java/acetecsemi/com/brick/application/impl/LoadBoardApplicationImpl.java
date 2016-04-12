package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.LoadBoardApplication;
import acetecsemi.com.brick.core.domain.LoadBoard;

@Named
@Transactional
public class LoadBoardApplicationImpl implements LoadBoardApplication {

	public LoadBoard getLoadBoard(Long id) {
		return LoadBoard.get(LoadBoard.class, id);
	}
	
	public void creatLoadBoard(LoadBoard loadBoard) {
		loadBoard.save();
	}
	
	public void updateLoadBoard(LoadBoard loadBoard) {
		loadBoard .save();
	}
	
	public void removeLoadBoard(LoadBoard loadBoard) {
		if(loadBoard != null){
			loadBoard.remove();
		}
	}
	
	public void removeLoadBoards(Set<LoadBoard> loadBoards) {
		for (LoadBoard loadBoard : loadBoards) {
			loadBoard.remove();
		}
	}
	
	public List<LoadBoard> findAllLoadBoard() {
		return LoadBoard.findAll(LoadBoard.class);
	}
	
}

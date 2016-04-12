package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Category;

public interface CategoryApplication {

	public Category getCategory(Long id);
	
	public void creatCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void removeCategory(Category category);
	
	public void removeCategorys(Set<Category> categorys);
	
	public List<Category> findAllCategory();
	
}


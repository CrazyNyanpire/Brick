package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.core.domain.Category;

@Named
@Transactional
public class CategoryApplicationImpl implements CategoryApplication {

	public Category getCategory(Long id) {
		return Category.get(Category.class, id);
	}
	
	public void creatCategory(Category category) {
		category.save();
	}
	
	public void updateCategory(Category category) {
		category .save();
	}
	
	public void removeCategory(Category category) {
		if(category != null){
			category.remove();
		}
	}
	
	public void removeCategorys(Set<Category> categorys) {
		for (Category category : categorys) {
			category.remove();
		}
	}
	
	public List<Category> findAllCategory() {
		return Category.findAll(Category.class);
	}
	
}

package acetecsemi.com.brick.facade;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface CategoryFacade {

	public CategoryDTO getCategory(Long id);

	public Boolean creatCategory(CategoryDTO category);

	public Boolean updateCategory(CategoryDTO category);

	public Boolean removeCategory(Long id);

	public Boolean removeCategorys(Long[] ids);

	public List<CategoryDTO> findAllCategory();

	public Page<CategoryDTO> pageQueryCategory(CategoryDTO category,
			int currentPage, int pageSize);

	public CategoryDTO findCategoryParentByCategory(Long id);

	public Page<CategoryDTO> findCategoryChildrenByCategory(Long id,
			int currentPage, int pageSize);

	public List<StatusCategoryDTO> changeStatusCategorys(Long categoryId);
	
	public List<CategoryDTO> nextStatusCategorys(Long id);
	
	public CategoryDTO getCategory(Long id,String type);
	
	public List<Object> changeStatusTree();
	
	public CategoryDTO getCategoryByName(String name);
}

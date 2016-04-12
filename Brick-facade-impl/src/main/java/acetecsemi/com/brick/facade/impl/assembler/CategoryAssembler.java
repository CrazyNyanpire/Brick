package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class CategoryAssembler {

	/**
	 * 
	 * @param category
	 * @param children
	 *            是否获取子节点，true获取，false不获取 获取子节点就不获取父节点，获取父节点就不获取子节点
	 * @return
	 */
	public static CategoryDTO toDTO(Category category, boolean children) {
		if (category == null) {
			return null;
		}
		CategoryDTO result = new CategoryDTO();
		result.setId(category.getId());
		result.setVersion(category.getVersion());
		result.setCategoryCode(category.getCategoryCode());
		result.setCategoryName(category.getCategoryName());
		result.setDescription(category.getDescription());
		result.setHasChildren(false);
		result.setUrl(category.getUrl());
		//if (category.getCategoryParent() != null)
		//	result.setCategoryParentid(category.getCategoryParent().getId());
//		if (category.getCategoryParent() != null && !children)
//			result.setCategoryParent(CategoryAssembler.toDTO(
//					category.getCategoryParent(), false));
//		if ( children && category.getCategoryChildren() != null
//				&& category.getCategoryChildren().size() > 0) {
//			result.setHasChildren(true);
//			result.setCategoryChildren(CategoryAssembler.toDTOs(
//					category.getCategoryChildren(), children));
//		}
		return result;
	}

	public static List<CategoryDTO> toDTOs(Collection<Category> categorys,
			boolean children) {
		if (categorys == null) {
			return null;
		}
		List<CategoryDTO> results = new ArrayList<CategoryDTO>();
		for (Category each : categorys) {
			results.add(toDTO(each, children));
		}
		return results;
	}

	public static Category toEntity(CategoryDTO categoryDTO) {
		if (categoryDTO == null) {
			return null;
		}
		Category result = new Category();
		result.setId(categoryDTO.getId());
		result.setVersion(categoryDTO.getVersion());
		result.setCategoryCode(categoryDTO.getCategoryCode());
		result.setCategoryName(categoryDTO.getCategoryName());
		result.setDescription(categoryDTO.getDescription());
		if(categoryDTO.getParentId() != null){
			Category parent = new Category();
			parent.setId(categoryDTO.getParentId());
			result.setCategoryParent(parent);
		}
		return result;
	}

	public static List<Category> toEntities(Collection<CategoryDTO> categoryDTOs) {
		if (categoryDTOs == null) {
			return null;
		}

		List<Category> results = new ArrayList<Category>();
		for (CategoryDTO each : categoryDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

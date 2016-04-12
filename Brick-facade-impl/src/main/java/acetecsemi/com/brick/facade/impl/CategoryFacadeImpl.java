package acetecsemi.com.brick.facade.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.CategoryAssembler;
import acetecsemi.com.brick.facade.CategoryFacade;
import acetecsemi.com.brick.application.CategoryApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class CategoryFacadeImpl implements CategoryFacade {

	@Inject
	private CategoryApplication application;

	private QueryChannelService queryChannel;

	private List<StatusCategoryDTO> changeStatusList;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public CategoryDTO getCategory(Long id) {
		Category category = application.getCategory(id);
		return this.getCategory(category, null);
	}

	public CategoryDTO getCategory(Long id, String type) {
		Category category = application.getCategory(id);
		return this.getCategory(category, type);
	}

	private CategoryDTO getCategory(Category category, String type) {
		// Category category = application.getCategory(id);
		List<CategoryDTO> categoryChildrenDTO = new ArrayList<CategoryDTO>();
		CategoryDTO categoryDTO = CategoryAssembler.toDTO(category, false);
		if (category.getCategoryChildren() != null) {
			categoryDTO.setHasChildren(true);
			List<Category> categoryChildren = this
					.findCategoryChildrenByCategory(category.getId());
			for (Category categoryTemp : categoryChildren) {
				if (type == null)
					categoryChildrenDTO.add(this
							.getCategory(categoryTemp, type));
				else if (type != null
						&& categoryTemp.getSign() != null
						&& categoryTemp.getSign().indexOf(type.toUpperCase()) > -1) {
					categoryChildrenDTO.add(this
							.getCategory(categoryTemp, type));
				}
			}
			categoryDTO.setCategoryChildren(categoryChildrenDTO);
		} else {
			categoryDTO.setHasChildren(false);
		}
		return categoryDTO;
	}

	public Category getCategorySuper(Long id) {
		Category category = Category.get(Category.class, id);
		if (category.getCategoryChildren() != null) {
			List<Category> categoryList = this
					.findCategoryChildrenByCategory(id);
			for (Category child : categoryList) {
				category.getCategoryChildren().add(
						this.getCategorySuper(child.getId()));
			}
		}
		return category;
	}

	public Boolean creatCategory(CategoryDTO categoryDTO) {
		application.creatCategory(CategoryAssembler.toEntity(categoryDTO));
		return true;
	}

	public Boolean updateCategory(CategoryDTO categoryDTO) {
		application.updateCategory(CategoryAssembler.toEntity(categoryDTO));
		return true;
	}

	public Boolean removeCategory(Long id) {
		application.removeCategory(application.getCategory(id));
		return true;
	}

	public Boolean removeCategorys(Long[] ids) {
		Set<Category> categorys = new HashSet<Category>();
		for (Long id : ids) {
			categorys.add(application.getCategory(id));
		}
		application.removeCategorys(categorys);
		return true;
	}

	public List<CategoryDTO> findAllCategory() {
		return CategoryAssembler.toDTOs(application.findAllCategory(), false);
	}

	public Page<CategoryDTO> pageQueryCategory(CategoryDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _category from Category _category   where 1=1 ");
		if (queryVo.getCategoryCode() != null
				&& !"".equals(queryVo.getCategoryCode())) {
			jpql.append(" and _category.categoryCode like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategoryCode()));
		}
		if (queryVo.getCategoryName() != null
				&& !"".equals(queryVo.getCategoryName())) {
			jpql.append(" and _category.categoryName like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getCategoryName()));
		}
		if (queryVo.getDescription() != null
				&& !"".equals(queryVo.getDescription())) {
			jpql.append(" and _category.description like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDescription()));
		}
		Page<Category> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<CategoryDTO>(pages.getStart(), pages.getResultCount(),
				pageSize, CategoryAssembler.toDTOs(pages.getData(), false));
	}

	@Override
	public CategoryDTO findCategoryParentByCategory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CategoryDTO> findCategoryChildrenByCategory(Long id,
			int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Category> findCategoryChildrenByCategory(Long id,
			String condition) {
		StringBuilder jpql = new StringBuilder(
				"select _category from Category _category where _category.categoryParent.id=?");
		// String jpql =
		// "select e from MaterialProcess o right join o.createUser e where o.id=?";
		if (condition != null)
			jpql.append(condition);
		List<Category> result = (List<Category>) getQueryChannelService()
				.createJpqlQuery(jpql.toString())
				.setParameters(new Object[] { id }).list();
		return result;
	}

	private List<Category> findCategoryChildrenByCategory(Long id) {
		return this.findCategoryChildrenByCategory(id, null);
	}

	private StatusCategoryDTO changeStatusCategoryChildren(Long id,
			Category categoryParent) {
		String condition = " and _category.sign='changeStatus'";
		// 获取平台分类
		List<Category> list = this
				.findCategoryChildrenByCategory(id, condition);
		StatusCategoryDTO result = new StatusCategoryDTO();
		List<StatusCategoryDTO> statusCategoryList = new ArrayList<StatusCategoryDTO>();
		for (Category Category : list) {
			StatusCategoryDTO map = new StatusCategoryDTO();
			map.setId(Category.getId());
			map.setName(Category.getDescription());
			map.setType(categoryParent.getCategoryCode());
			statusCategoryList.add(map);
		}
		result.setType(categoryParent.getCategoryCode());
		result.setName(categoryParent.getDescription());
		result.setChildren(statusCategoryList);
		return result;
	}

	public List<StatusCategoryDTO> changeStatusCategorys(Long categoryId) {
		if (changeStatusList != null) {
			return this.changeStatusList;
		}
		StringBuilder jpql = new StringBuilder(
				"select _category from Category _category where _category.sign='changeStatusParent'");
		jpql.append(" and _category.id = ?");
		List<Category> list = (List<Category>) getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(new Object[] { categoryId }).list();
		List<StatusCategoryDTO> resList = new ArrayList<StatusCategoryDTO>();
		for (Category category : list) {
			StatusCategoryDTO result = new StatusCategoryDTO();
			jpql = new StringBuilder(
					"select _category.categoryParent from Category _category where _category.id =?");
			Category categoryParent = (Category) getQueryChannelService()
					.createJpqlQuery(jpql.toString())
					.setParameters(new Object[] { category.getId() })
					.singleResult();
			resList.add(this.changeStatusCategoryChildren(category.getId(),
					categoryParent));
		}
		return resList;
	}

	public List<CategoryDTO> nextStatusCategorys(Long id) {
		Category category = this.application.getCategory(id);
		if (category.getSign() != null) {
			StringBuilder jpql = new StringBuilder(
					"select _category from Category _category where _category.id in (");
			jpql.append(category.getSign().replace("|", ","));
			jpql.append(")");
			List<Category> list = (List<Category>) getQueryChannelService()
					.createJpqlQuery(jpql.toString()).list();
			return CategoryAssembler.toDTOs(list, false);
		}
		return null;
	}

	public List<Object> changeStatusTree() {
		List<Object> result = new ArrayList<Object>();
		result.addAll(this.changeStatusCategorys(Long.valueOf(2)));
		CategoryDTO testerDTO= this.getCategory(Long.valueOf(7));
		testerDTO.setCategoryName("平台");
		result.add(this.changeCategoryDTOTOStatusCategoryDTO(testerDTO,testerDTO.getCategoryCode()));
		result.addAll(this.changeStatusCategorys(Long.valueOf(6)));
		CategoryDTO statusDTO= this.getCategory(Long.valueOf(76),"CP");
		result.add(this.changeCategoryDTOTOStatusCategoryDTO(statusDTO,statusDTO.getCategoryCode()));
		CategoryDTO categoryDTO= this.getCategory(Long.valueOf(35));
		result.add(this.changeCategoryDTOTOStatusCategoryDTO(categoryDTO,"location"));
		return result;
	}
	
	private StatusCategoryDTO changeCategoryDTOTOStatusCategoryDTO(CategoryDTO categoryDTO,String type){
		StatusCategoryDTO parent = new StatusCategoryDTO();
		parent.setId(categoryDTO.getId());
		parent.setName(categoryDTO.getCategoryName());
		parent.setType(type);
		List<StatusCategoryDTO> statusCategoryDTOList = new ArrayList<StatusCategoryDTO>();
		if(categoryDTO.getCategoryChildren() != null && categoryDTO.getCategoryChildren().size() > 0){
			for (CategoryDTO category : categoryDTO.getCategoryChildren()) {
				statusCategoryDTOList.add(this.changeCategoryDTOTOStatusCategoryDTO(category,type));
			}
		}
		/*for (CategoryDTO Category : categoryDTO.getCategoryChildren()) {
			StatusCategoryDTO map = new StatusCategoryDTO();
			map.setId(Category.getId());
			map.setName(Category.getDescription());
			map.setType(categoryDTO.getCategoryCode());
			statusCategoryDTOList.add(map);
		}*/
		parent.setChildren(statusCategoryDTOList);
		return parent;
	}
	
	
	@Override
	public CategoryDTO getCategoryByName(String name) {
		if (name != null) {
			StringBuilder jpql = new StringBuilder(
					"select _category from Category _category where _category.categoryName = ?");
			Category category = (Category) getQueryChannelService()
					.createJpqlQuery(jpql.toString())
					.setParameters(new Object[] { name })
					.singleResult();
			return CategoryAssembler.toDTO(category, false);
		}
		return null;
	}
}

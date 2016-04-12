package acetecsemi.com.brick.facade.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO implements Serializable {

	private Long id;

	private int version;

	private String categoryName;

	private String description;

	private String categoryCode;

	private CategoryDTO categoryParent;
	
	private Long categoryParentid;

	private List<CategoryDTO> categoryChildren = new ArrayList<CategoryDTO>();
	
	private boolean hasChildren;
	
	private Long parentId;
	
	private String url;

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public CategoryDTO getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(CategoryDTO categoryParent) {
		categoryParent = categoryParent;
	}

	public Long getCategoryParentid() {
		return categoryParentid;
	}

	public void setCategoryParentid(Long categoryParentid) {
		this.categoryParentid = categoryParentid;
	}

	public List<CategoryDTO> getCategoryChildren() {
		return categoryChildren;
	}

	public void setCategoryChildren(List<CategoryDTO> categoryChildren) {
		this.categoryChildren = categoryChildren;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDTO other = (CategoryDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
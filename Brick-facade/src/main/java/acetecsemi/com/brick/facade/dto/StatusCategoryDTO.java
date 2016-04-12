package acetecsemi.com.brick.facade.dto;

import java.util.List;

public class StatusCategoryDTO {

	private Long id;

	private String name;

	private String type;

	private List<StatusCategoryDTO> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<StatusCategoryDTO> getChildren() {
		return children;
	}

	public void setChildren(List<StatusCategoryDTO> children) {
		this.children = children;
	}

}

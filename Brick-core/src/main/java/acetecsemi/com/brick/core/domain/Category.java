package acetecsemi.com.brick.core.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 05-03-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_Category")
public class Category extends BrickAbstractEntity {
	/**
	 * 用于保存初始值
	 */
	private static final long serialVersionUID = 5204603319004653589L;

	private String categoryCode;// 类别编码
	private String categoryName;// 类别名称
	private String description;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryParent_ID", referencedColumnName = "ID")
	private Category categoryParent;// 父分类

	@OneToMany(targetEntity = Category.class, cascade = CascadeType.REFRESH,fetch=FetchType.LAZY, mappedBy = "categoryParent")
	@OrderBy(value = "categoryCode DESC")
	private Set<Category> categoryChildren = new HashSet<Category>();// 类别编码

	private String sign;//标示是否可以挂状态等
	
	private String url;
	
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}


	public Set<Category> getCategoryChildren() {
		return categoryChildren;
	}

	public void setCategoryChildren(Set<Category> categoryChildren) {
		this.categoryChildren = categoryChildren;
	}
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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
		int result = super.hashCode();
		result = prime * result
				+ ((categoryCode == null) ? 0 : categoryCode.hashCode());
		result = prime * result
				+ ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result
				+ ((categoryParent == null) ? 0 : categoryParent.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryCode == null) {
			if (other.categoryCode != null)
				return false;
		} else if (!categoryCode.equals(other.categoryCode))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryParent == null) {
			if (other.categoryParent != null)
				return false;
		} else if (!categoryParent.equals(other.categoryParent))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

}
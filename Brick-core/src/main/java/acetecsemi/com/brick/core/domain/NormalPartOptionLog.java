package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_NORMALPARTLOG")
public class NormalPartOptionLog extends OptionLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7743303190039782651L;
	
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "NORMALPART_ID", referencedColumnName = "ID")
	private NormalPart normalPart;
	private String path;

	public NormalPart getNormalPart() {
		return normalPart;
	}

	public void setNormalPart(NormalPart normalPart) {
		this.normalPart = normalPart;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NormalPartOptionLog [normalPart=" + normalPart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((normalPart == null) ? 0 : normalPart.hashCode());
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
		NormalPartOptionLog other = (NormalPartOptionLog) obj;
		if (normalPart == null) {
			if (other.normalPart != null)
				return false;
		} else if (!normalPart.equals(other.normalPart))
			return false;
		return true;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	



}
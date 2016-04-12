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
@Table(name = "BRICK_WAFERIDORDER")
public class WaferIdOrder extends BrickAbstractEntity {
	/**
	 * 用于保存初始值
	 */
	private static final long serialVersionUID = 5204603319004653589L;

	private Integer waferIndex;
	private String acetecLot;
	private String waferId;
	
	
	public Integer getWaferIndex() {
		return waferIndex;
	}


	public void setWaferIndex(Integer waferIndex) {
		this.waferIndex = waferIndex;
	}


	public String getAcetecLot() {
		return acetecLot;
	}


	public void setAcetecLot(String acetecLot) {
		this.acetecLot = acetecLot;
	}


	public String getWaferId() {
		return waferId;
	}


	public void setWaferId(String waferId) {
		this.waferId = waferId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((acetecLot == null) ? 0 : acetecLot.hashCode());
		result = prime * result + ((waferIndex == null) ? 0 : waferIndex.hashCode());
		result = prime * result + ((waferId == null) ? 0 : waferId.hashCode());
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
		WaferIdOrder other = (WaferIdOrder) obj;
		if (acetecLot == null) {
			if (other.acetecLot != null)
				return false;
		} else if (!acetecLot.equals(other.acetecLot))
			return false;
		if (waferIndex == null) {
			if (other.waferIndex != null)
				return false;
		} else if (!waferIndex.equals(other.waferIndex))
			return false;
		if (waferId == null) {
			if (other.waferId != null)
				return false;
		} else if (!waferId.equals(other.waferId))
			return false;
		return true;
	}


	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}

}
package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:09
 */
@Entity
@Table(name = "BRICK_PIN")
public class Pin extends BrickAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8625830696783839697L;

	private String model;

	private Integer useQty;

	private Integer totalQty;

	private Integer balanceQty;

	private String theoryTestUph;

	private Date inDate;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getUseQty() {
		return useQty;
	}

	public void setUseQty(Integer useQty) {
		this.useQty = useQty;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public Integer getBalanceQty() {
		return balanceQty;
	}

	public void setBalanceQty(Integer balanceQty) {
		this.balanceQty = balanceQty;
	}

	public String getTheoryTestUph() {
		return theoryTestUph;
	}

	public void setTheoryTestUph(String theoryTestUph) {
		this.theoryTestUph = theoryTestUph;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}
}
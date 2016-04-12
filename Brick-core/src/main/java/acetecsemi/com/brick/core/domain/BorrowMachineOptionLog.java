package acetecsemi.com.brick.core.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openkoala.security.core.domain.User;

/**
 * @author harlow
 * @version 1.0
 * @created 02-04-2015 15:27:09
 */
@Entity
@Table(name="BRICK_BORROWMACHINEOPTIONLOG")
public class BorrowMachineOptionLog extends OptionLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3415541785427109763L;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "BORROWMACHINE_ID", referencedColumnName = "ID")
	private BorrowMachine borrowMachine;

	public BorrowMachine getBorrowMachine() {
		return borrowMachine;
	}

	public void setBorrowMachine(BorrowMachine borrowMachine) {
		this.borrowMachine = borrowMachine;
	}

}
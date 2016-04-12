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
 * @created 20-03-2015 15:27:09
 */
@Entity
@DiscriminatorValue("PLATFORM")
public class MaintenancePlatform extends Maintenance {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5338276544529135148L;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PLATFORM_ID", referencedColumnName = "ID")
	private Platform platform;

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	@Override
	public String[] businessKeys() {
		return new String[] { String.valueOf(getId()),
				this.getCreateTimestamp().toString() };
	}
}
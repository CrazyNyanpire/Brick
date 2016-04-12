package acetecsemi.com.brick.core.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FT")
public class PlatformFTOptionLog extends PlatformOptionLog {


}

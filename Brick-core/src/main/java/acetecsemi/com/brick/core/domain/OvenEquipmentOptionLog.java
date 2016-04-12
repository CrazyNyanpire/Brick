package acetecsemi.com.brick.core.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OVEN")
public class OvenEquipmentOptionLog extends EquipmentOptionLog{
	
	private String productNo;//oven-产品数量

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
		
}

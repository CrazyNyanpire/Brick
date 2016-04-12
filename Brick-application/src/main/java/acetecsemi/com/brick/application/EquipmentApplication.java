package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Equipment;

public interface EquipmentApplication {

	public Equipment getEquipment(Long id);
	
	public void creatEquipment(Equipment equipment);
	
	public void updateEquipment(Equipment equipment);
	
	public void removeEquipment(Equipment equipment);
	
	public void removeEquipments(Set<Equipment> equipments);
	
	public List<Equipment> findAllEquipment();
	
}


package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.EquipmentApplication;
import acetecsemi.com.brick.core.domain.Equipment;

@Named
@Transactional
public class EquipmentApplicationImpl implements EquipmentApplication {

	public Equipment getEquipment(Long id) {
		return Equipment.get(Equipment.class, id);
	}
	
	public void creatEquipment(Equipment equipment) {
		equipment.save();
	}
	
	public void updateEquipment(Equipment equipment) {
		equipment .save();
	}
	
	public void removeEquipment(Equipment equipment) {
		if(equipment != null){
			equipment.remove();
		}
	}
	
	public void removeEquipments(Set<Equipment> equipments) {
		for (Equipment equipment : equipments) {
			equipment.remove();
		}
	}
	
	public List<Equipment> findAllEquipment() {
		return Equipment.findAll(Equipment.class);
	}
	
}

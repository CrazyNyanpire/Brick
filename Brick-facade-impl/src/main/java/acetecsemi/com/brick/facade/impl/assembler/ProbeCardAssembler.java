package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class ProbeCardAssembler {

	public static ProbeCardDTO toDTO(ProbeCard probeCard) {
		if (probeCard == null) {
			return null;
		}
		ProbeCardDTO result = new ProbeCardDTO();
		result.setId(probeCard.getId());
		result.setVersion(probeCard.getVersion());
		result.setCreateTimestamp(probeCard.getCreateTimestamp());
		result.setLastModifyTimestamp(probeCard.getLastModifyTimestamp());
		result.setCreateEmployNo(probeCard.getCreateEmployNo());
		result.setLastModifyEmployNo(probeCard.getLastModifyEmployNo());
		result.setCategory(probeCard.getCategory());
		result.setPartNo(probeCard.getPartNo());
		result.setPartName(probeCard.getPartName());
		result.setEquipmentList(probeCard.getEquipmentList());
		result.setPartType(probeCard.getPartType());
		result.setPartModel(probeCard.getPartModel());
		result.setProductModel(probeCard.getProductModel());
		result.setNowProductModel(probeCard.getNowProductModel());
		result.setInDate(probeCard.getInDate());
		result.setPartLocaltion(probeCard.getPartLocaltion());
		// result.setManufacturer (probeCard.getManufacturer());
		result.setManufacturerName(probeCard.getManufacturerName());
		result.setManufacturerNo(probeCard.getManufacturerNo());
		result.setCustomerName(probeCard.getCustomerName());
		result.setCustomerNameEn(probeCard.getCustomerNameEn());
		result.setOwnership(probeCard.getOwnership());
		if(probeCard.getStatus() != null){
			result.setStatus(probeCard.getStatus().getCategoryName());
			result.setStatusId(probeCard.getStatus().getId());
		}
		
		result.setRemark(probeCard.getRemark());
		// result.setEquipment (probeCard.getEquipment());
		if (probeCard.getEquipment() != null) {
			
			result.setEquipmentNo(probeCard.getEquipment().getEquipmentNo());
		}
		result.setEquipmentCategory(probeCard.getEquipmentCategory());
		result.setInLongestNeedle(probeCard.getInLongestNeedle());
		result.setInShortestNeedle(probeCard.getInShortestNeedle());
		result.setScrappingStandard(probeCard.getScrappingStandard());
		result.setProbeMaterials(probeCard.getProbeMaterials());
		result.setMaintenanceUpperLimit(probeCard.getMaintenanceUpperLimit());
		result.setMaintenanceLowerLimit(probeCard.getMaintenanceLowerLimit());
		result.setOpenRemake(probeCard.getOpenRemake());
		result.setMaintenanceBase(probeCard.getMaintenanceBase());
		result.setTipHeight(probeCard.getTipHeight());
		result.setTipLongest(probeCard.getTipLongest());
		result.setTipShortest(probeCard.getTipShortest());
		result.setXyNeedlePosition(probeCard.getXyNeedlePosition());
		result.setZNeedlePositionFlatness(probeCard
				.getZNeedlePositionFlatness());
		result.setTipMaximumDiameter(probeCard.getTipMaximumDiameter());
		result.setTipMinimumDiameter(probeCard.getTipMinimumDiameter());
		result.setExpoxyToTipAngleDistance(probeCard
				.getExpoxyToTipAngleDistance());
		result.setTestTemperature(probeCard.getTestTemperature());
		result.setAppearanceOfProbeCard(probeCard.getAppearanceOfProbeCard());
		result.setReinforcingPlate(probeCard.getReinforcingPlate());
		result.setRemakeNumber(probeCard.getRemakeNumber());
		result.setTouchTime(probeCard.getTouchTime() == null ? 0 : probeCard.getTouchTime() );
		result.setTouchTimeTotal(probeCard.getTouchTimeTotal());
		result.setPinQty(probeCard.getPinQty());
		result.setPcbSize(probeCard.getPcbSize());
		if(probeCard.getNowPlatform() != null){
			result.setPlatform(probeCard.getNowPlatform().getTester().getEquipmentNo());
		}
		result.setInTipMaximumDiameter(probeCard.getInTipMaximumDiameter());
		result.setInTipMinimumDiameter(probeCard.getInTipMinimumDiameter());
		return result;
	}

	public static List<ProbeCardDTO> toDTOs(Collection<ProbeCard> probeCards) {
		if (probeCards == null) {
			return null;
		}
		List<ProbeCardDTO> results = new ArrayList<ProbeCardDTO>();
		for (ProbeCard each : probeCards) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static ProbeCard toEntity(ProbeCardDTO probeCardDTO) {
		if (probeCardDTO == null) {
			return null;
		}
		ProbeCard result = new ProbeCard();
		result.setId(probeCardDTO.getId());
		result.setVersion(probeCardDTO.getVersion());
		//result.setCreateTimestamp(probeCardDTO.getCreateTimestamp());
		//result.setLastModifyTimestamp(probeCardDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(probeCardDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(probeCardDTO.getLastModifyEmployNo());
		result.setCategory(probeCardDTO.getCategory());
		result.setPartNo(probeCardDTO.getPartNo());
		result.setPartName(probeCardDTO.getPartName());
		result.setEquipmentList(probeCardDTO.getEquipmentList());
		result.setPartType(probeCardDTO.getPartType());
		result.setPartModel(probeCardDTO.getPartModel());
		result.setProductModel(probeCardDTO.getProductModel());
		result.setNowProductModel(probeCardDTO.getNowProductModel());
		result.setInDate(probeCardDTO.getInDate());
		result.setPartLocaltion(probeCardDTO.getPartLocaltion());
		// result.setManufacturer (probeCardDTO.getManufacturer());
		result.setManufacturerName(probeCardDTO.getManufacturerName());
		result.setManufacturerNo(probeCardDTO.getManufacturerNo());
		result.setCustomerName(probeCardDTO.getCustomerName());
		result.setCustomerNameEn(probeCardDTO.getCustomerNameEn());
		result.setOwnership(probeCardDTO.getOwnership());
		//result.setStatus(probeCardDTO.getStatus());
		result.setRemark(probeCardDTO.getRemark());
		// result.setEquipment (probeCardDTO.getEquipment());
		result.setInLongestNeedle(probeCardDTO.getInLongestNeedle());
		result.setInShortestNeedle(probeCardDTO.getInShortestNeedle());
		result.setScrappingStandard(probeCardDTO.getScrappingStandard());
		result.setProbeMaterials(probeCardDTO.getProbeMaterials());
		result.setMaintenanceUpperLimit(probeCardDTO.getMaintenanceUpperLimit());
		result.setMaintenanceLowerLimit(probeCardDTO.getMaintenanceLowerLimit());
		result.setOpenRemake(probeCardDTO.getOpenRemake());
		result.setMaintenanceBase(probeCardDTO.getMaintenanceBase());
		result.setTipHeight(probeCardDTO.getTipHeight());
		result.setTipLongest(probeCardDTO.getTipLongest());
		result.setTipShortest(probeCardDTO.getTipShortest());
		result.setXyNeedlePosition(probeCardDTO.getXyNeedlePosition());
		result.setZNeedlePositionFlatness(probeCardDTO
				.getZNeedlePositionFlatness());
		result.setTipMaximumDiameter(probeCardDTO.getTipMaximumDiameter());
		result.setTipMinimumDiameter(probeCardDTO.getTipMinimumDiameter());
		result.setExpoxyToTipAngleDistance(probeCardDTO
				.getExpoxyToTipAngleDistance());
		result.setTestTemperature(probeCardDTO.getTestTemperature());
		result.setAppearanceOfProbeCard(probeCardDTO.getAppearanceOfProbeCard());
		result.setReinforcingPlate(probeCardDTO.getReinforcingPlate());
		result.setRemakeNumber(probeCardDTO.getRemakeNumber());
		result.setTouchTime(probeCardDTO.getTouchTime());
		result.setTouchTimeTotal(probeCardDTO.getTouchTimeTotal());
		result.setPinQty(probeCardDTO.getPinQty());
		result.setPcbSize(probeCardDTO.getPcbSize());
		result.setInTipMaximumDiameter(probeCardDTO.getInTipMaximumDiameter());
		result.setInTipMinimumDiameter(probeCardDTO.getInTipMinimumDiameter());
		return result;
	}
	
	public static ProbeCard toEntity(ProbeCard result ,ProbeCardDTO probeCardDTO) {
		if (probeCardDTO == null) {
			return null;
		}
		result.setLastModifyEmployNo(probeCardDTO.getLastModifyEmployNo());
		result.setCategory(probeCardDTO.getCategory());
		result.setPartNo(probeCardDTO.getPartNo());
		result.setPartName(probeCardDTO.getPartName());
		result.setEquipmentList(probeCardDTO.getEquipmentList());
		result.setPartType(probeCardDTO.getPartType());
		result.setPartModel(probeCardDTO.getPartModel());
		result.setProductModel(probeCardDTO.getProductModel());
		result.setNowProductModel(probeCardDTO.getNowProductModel());
		result.setInDate(probeCardDTO.getInDate());
		result.setPartLocaltion(probeCardDTO.getPartLocaltion());
		// result.setManufacturer (probeCardDTO.getManufacturer());
		result.setManufacturerName(probeCardDTO.getManufacturerName());
		result.setManufacturerNo(probeCardDTO.getManufacturerNo());
		result.setCustomerName(probeCardDTO.getCustomerName());
		result.setCustomerNameEn(probeCardDTO.getCustomerNameEn());
		result.setOwnership(probeCardDTO.getOwnership());
		//result.setStatus(probeCardDTO.getStatus());
		result.setRemark(probeCardDTO.getRemark());
		// result.setEquipment (probeCardDTO.getEquipment());
		result.setInLongestNeedle(probeCardDTO.getInLongestNeedle());
		result.setInShortestNeedle(probeCardDTO.getInShortestNeedle());
		result.setScrappingStandard(probeCardDTO.getScrappingStandard());
		result.setProbeMaterials(probeCardDTO.getProbeMaterials());
		result.setMaintenanceUpperLimit(probeCardDTO.getMaintenanceUpperLimit());
		result.setMaintenanceLowerLimit(probeCardDTO.getMaintenanceLowerLimit());
		result.setOpenRemake(probeCardDTO.getOpenRemake());
		result.setMaintenanceBase(probeCardDTO.getMaintenanceBase());
		result.setTipHeight(probeCardDTO.getTipHeight());
		result.setTipLongest(probeCardDTO.getTipLongest());
		result.setTipShortest(probeCardDTO.getTipShortest());
		result.setXyNeedlePosition(probeCardDTO.getXyNeedlePosition());
		result.setZNeedlePositionFlatness(probeCardDTO
				.getZNeedlePositionFlatness());
		result.setTipMaximumDiameter(probeCardDTO.getTipMaximumDiameter());
		result.setTipMinimumDiameter(probeCardDTO.getTipMinimumDiameter());
		result.setExpoxyToTipAngleDistance(probeCardDTO
				.getExpoxyToTipAngleDistance());
		result.setTestTemperature(probeCardDTO.getTestTemperature());
		result.setAppearanceOfProbeCard(probeCardDTO.getAppearanceOfProbeCard());
		result.setReinforcingPlate(probeCardDTO.getReinforcingPlate());
		result.setRemakeNumber(probeCardDTO.getRemakeNumber());
		result.setTouchTime(probeCardDTO.getTouchTime());
		result.setTouchTimeTotal(probeCardDTO.getTouchTimeTotal());
		result.setPinQty(probeCardDTO.getPinQty());
		result.setPcbSize(probeCardDTO.getPcbSize());
		result.setInTipMaximumDiameter(probeCardDTO.getInTipMaximumDiameter());
		result.setInTipMinimumDiameter(probeCardDTO.getInTipMinimumDiameter());
		return result;
	}


	public static List<ProbeCard> toEntities(
			Collection<ProbeCardDTO> probeCardDTOs) {
		if (probeCardDTOs == null) {
			return null;
		}
		List<ProbeCard> results = new ArrayList<ProbeCard>();
		for (ProbeCardDTO each : probeCardDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

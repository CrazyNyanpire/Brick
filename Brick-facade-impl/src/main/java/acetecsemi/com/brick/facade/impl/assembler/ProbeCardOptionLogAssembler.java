package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class ProbeCardOptionLogAssembler {

	public static ProbeCardOptionLogDTO toDTO(
			ProbeCardOptionLog probeCardOptionLog) {
		if (probeCardOptionLog == null) {
			return null;
		}
		ProbeCardOptionLogDTO result = new ProbeCardOptionLogDTO();
		result.setId(probeCardOptionLog.getId());
		result.setVersion(probeCardOptionLog.getVersion());
		result.setCreateTimestamp(probeCardOptionLog.getCreateTimestamp());
		result.setLastModifyTimestamp(probeCardOptionLog
				.getLastModifyTimestamp());
		result.setCreateEmployNo(probeCardOptionLog.getCreateEmployNo());
		result.setLastModifyEmployNo(probeCardOptionLog.getLastModifyEmployNo());
		result.setStatus(probeCardOptionLog.getStatus());
		result.setOptUser(probeCardOptionLog.getOptUser());
		result.setOptDate(probeCardOptionLog.getOptDate());
		result.setRemark(probeCardOptionLog.getRemark());
		// result.setProbeCard (probeCardOptionLog.getProbeCard());
		result.setEndDate(probeCardOptionLog.getEndDate());
		result.setStatusTime(probeCardOptionLog.getStatusTime());
		result.setMaintenancePerson(probeCardOptionLog.getMaintenancePerson());
		result.setMaintenanceItems(probeCardOptionLog.getMaintenanceItems());
		result.setDutNumber(probeCardOptionLog.getDutNumber());
		result.setBinNo(probeCardOptionLog.getBinNo());
		result.setPlatforms(probeCardOptionLog.getPlatforms());
		result.setPlatform(probeCardOptionLog.getPlatform());
		result.setPlatformNo(probeCardOptionLog.getPlatformNo());
		result.setProductModel(probeCardOptionLog.getProductModel());
		result.setProductLot(probeCardOptionLog.getProductLot());
		result.setProductNowModel(probeCardOptionLog.getProductNowModel());
		result.setProbeCardApplyPerson(probeCardOptionLog
				.getProbeCardApplyPerson());
		result.setCustomerName(probeCardOptionLog.getCustomerName());
		result.setTouchTime(probeCardOptionLog.getTouchTime());
		result.setReturnPerson(probeCardOptionLog.getReturnPerson());
		result.setReturnLevel(probeCardOptionLog.getReturnLevel());
		result.setNeedlePositionLevel(probeCardOptionLog
				.getNeedlePositionLevel());
		result.setAppearanceLevel(probeCardOptionLog.getAppearanceLevel());
		result.setXyNeedlePosition(probeCardOptionLog.getXyNeedlePosition());
		result.setTipMaximumDiameter(probeCardOptionLog.getTipMaximumDiameter());
		result.setTipMinimumDiameter(probeCardOptionLog.getTipMinimumDiameter());
		result.setTipShortest(probeCardOptionLog.getTipShortest());
		result.setTipLongest(probeCardOptionLog.getTipLongest());
		if (probeCardOptionLog.getProbeCard() != null) {
			result.setProbeCardDTO(ProbeCardAssembler.toDTO(probeCardOptionLog
					.getProbeCard()));
		}
		if(probeCardOptionLog.getEndTime() != null){
			Long duration = probeCardOptionLog.getEndTime().getTime()
					- probeCardOptionLog.getStartTime().getTime();
			result.setStatusTime(String.valueOf(duration/1000/60));
		}
		result.setPlatformStatus(probeCardOptionLog.getPlatformStatus());
		return result;
	}

	public static List<ProbeCardOptionLogDTO> toDTOs(
			Collection<ProbeCardOptionLog> probeCardOptionLogs) {
		if (probeCardOptionLogs == null) {
			return null;
		}
		List<ProbeCardOptionLogDTO> results = new ArrayList<ProbeCardOptionLogDTO>();
		for (ProbeCardOptionLog each : probeCardOptionLogs) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static ProbeCardOptionLog toEntity(ProbeCardOptionLogDTO probeCardDTO) {
		if (probeCardDTO == null) {
			return null;
		}
		ProbeCardOptionLog result = new ProbeCardOptionLog();
		result.setId(probeCardDTO.getId());
		result.setVersion(probeCardDTO.getVersion());
		result.setCreateTimestamp(probeCardDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(probeCardDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(probeCardDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(probeCardDTO.getLastModifyEmployNo());
		result.setStatus(probeCardDTO.getStatus());
		result.setOptUser(probeCardDTO.getOptUser());
		result.setOptDate(probeCardDTO.getOptDate());
		result.setRemark(probeCardDTO.getRemark());
		// result.setProbeCard (probeCardDTO.getProbeCard());
		result.setEndDate(probeCardDTO.getEndDate());
		result.setStatusTime(probeCardDTO.getStatusTime());
		result.setMaintenancePerson(probeCardDTO.getMaintenancePerson());
		result.setMaintenanceItems(probeCardDTO.getMaintenanceItems());
		result.setDutNumber(probeCardDTO.getDutNumber());
		result.setBinNo(probeCardDTO.getBinNo());
		result.setPlatforms(probeCardDTO.getPlatforms());
		result.setPlatform(probeCardDTO.getPlatform());
		result.setPlatformNo(probeCardDTO.getPlatformNo());
		result.setProductModel(probeCardDTO.getProductModel());
		result.setProductLot(probeCardDTO.getProductLot());
		result.setProductNowModel(probeCardDTO.getProductNowModel());
		result.setProbeCardApplyPerson(probeCardDTO.getProbeCardApplyPerson());
		result.setCustomerName(probeCardDTO.getCustomerName());
		result.setTouchTime(probeCardDTO.getTouchTime());
		result.setReturnPerson(probeCardDTO.getReturnPerson());
		result.setReturnLevel(probeCardDTO.getReturnLevel());
		result.setNeedlePositionLevel(probeCardDTO.getNeedlePositionLevel());
		result.setAppearanceLevel(probeCardDTO.getAppearanceLevel());
		result.setXyNeedlePosition(probeCardDTO.getXyNeedlePosition());
		result.setTipMaximumDiameter(probeCardDTO.getTipMaximumDiameter());
		result.setTipMinimumDiameter(probeCardDTO.getTipMinimumDiameter());
		result.setTipShortest(probeCardDTO.getTipShortest());
		result.setTipLongest(probeCardDTO.getTipLongest());
		
		return result;
	}

	public static ProbeCardOptionLog toEntity(ProbeCardDTO probeCardDTO) {
		if (probeCardDTO == null) {
			return null;
		}
		ProbeCardOptionLog result = new ProbeCardOptionLog();
		result.setId(probeCardDTO.getId());
		result.setVersion(probeCardDTO.getVersion());
		result.setCreateTimestamp(probeCardDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(probeCardDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(probeCardDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(probeCardDTO.getLastModifyEmployNo());
		result.setStatus(probeCardDTO.getStatus());
		result.setOptUser(probeCardDTO.getOptUser());
		result.setOptDate(probeCardDTO.getOptDate());
		result.setRemark(probeCardDTO.getRemark());
		// result.setProbeCard (probeCardDTO.getProbeCard());
		result.setEndDate(probeCardDTO.getEndDate());
		result.setStatusTime(probeCardDTO.getStatusTime());
		result.setMaintenancePerson(probeCardDTO.getMaintenancePerson());
		result.setMaintenanceItems(probeCardDTO.getMaintenanceItems());
		result.setDutNumber(probeCardDTO.getDutNumber());
		result.setBinNo(probeCardDTO.getBinNo());
		result.setPlatforms(probeCardDTO.getPlatforms());
		result.setPlatform(probeCardDTO.getPlatform());
		result.setProductModel(probeCardDTO.getProductModel());
		result.setProductLot(probeCardDTO.getProductLot());
		result.setProductNowModel(probeCardDTO.getProductNowModel());
		result.setProbeCardApplyPerson(probeCardDTO.getProbeCardApplyPerson());
		result.setCustomerName(probeCardDTO.getCustomerName());
		result.setTouchTime(probeCardDTO.getTouchTime());
		result.setReturnPerson(probeCardDTO.getReturnPerson());
		result.setReturnLevel(probeCardDTO.getReturnLevel());
		result.setNeedlePositionLevel(probeCardDTO.getNeedlePositionLevel());
		result.setAppearanceLevel(probeCardDTO.getAppearanceLevel());
		result.setXyNeedlePosition(probeCardDTO.getXyNeedlePosition());
		result.setTipMaximumDiameter(probeCardDTO.getTipMaximumDiameter());
		result.setTipMinimumDiameter(probeCardDTO.getTipMinimumDiameter());
		result.setTipShortest(probeCardDTO.getTipShortest());
		result.setTipLongest(probeCardDTO.getTipLongest());
		return result;
	}

	public static List<ProbeCardOptionLog> toEntities(
			Collection<ProbeCardOptionLogDTO> probeCardDTOs) {
		if (probeCardDTOs == null) {
			return null;
		}

		List<ProbeCardOptionLog> results = new ArrayList<ProbeCardOptionLog>();
		for (ProbeCardOptionLogDTO each : probeCardDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

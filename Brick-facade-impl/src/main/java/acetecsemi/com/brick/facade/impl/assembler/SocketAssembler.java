package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class SocketAssembler {

	public static SocketDTO toDTO(Socket socket) {
		if (socket == null) {
			return null;
		}
		SocketDTO result = new SocketDTO();
		result.setId(socket.getId());
		result.setVersion(socket.getVersion());
		result.setCreateTimestamp(socket.getCreateTimestamp());
		result.setLastModifyTimestamp(socket.getLastModifyTimestamp());
		result.setCreateEmployNo(socket.getCreateEmployNo());
		result.setLastModifyEmployNo(socket.getLastModifyEmployNo());
		result.setCategory(socket.getCategory());
		result.setPartNo(socket.getPartNo());
		result.setPartName(socket.getPartName());
		result.setEquipmentList(socket.getEquipmentList());
		result.setPartType(socket.getPartType());
		result.setPartModel(socket.getPartModel());
		result.setProductModel(socket.getProductModel());
		result.setNowProductModel(socket.getNowProductModel());
		result.setInDate(socket.getInDate());
		result.setPartLocaltion(socket.getPartLocaltion());
		result.setManufacturerNo(socket.getManufacturerNo());
		result.setManufacturerName(socket.getManufacturerName());
		result.setCustomerName(socket.getCustomerName());
		result.setCustomerNameEn(socket.getCustomerNameEn());
		result.setOwnership(socket.getOwnership());
		if (socket.getStatus() != null) {
			result.setStatus(socket.getStatus().getCategoryName());
			result.setStatusId(socket.getStatus().getId());
		}
		result.setRemark(socket.getRemark());
		// result.setEquipment (socket.getEquipment());
		result.setPn(socket.getPn());
		result.setPinModels(socket.getPinModels());
		result.setSupplier(socket.getSupplier());
		result.setQty(socket.getQty());
		result.setPinQty(socket.getPinQty());
		result.setRemark(socket.getRemark());
		result.setApplicableModels(socket.getApplicableModels());
		result.setLastFileUrl(socket.getLastFileUrl());
		result.setAppearanceLevel(socket.getAppearanceLevel());
		if (socket.getNowPlatform() != null) {
			result.setPlatform(socket.getNowPlatform().getTester()
					.getEquipmentNo());
		}
		result.setTouchTime(socket.getTouchTime() == null ? Long.valueOf(0)
				: socket.getTouchTime());
		result.setTouchTimeTotal(socket.getTouchTimeTotal() == null ? Long
				.valueOf(0) : socket.getTouchTimeTotal());
		result.setPlatformSite(socket.getPlatformSite());
		result.setEquipmentListId(socket.getEquipmentListId());
		return result;
	}

	public static List<SocketDTO> toDTOs(Collection<Socket> sockets) {
		if (sockets == null) {
			return null;
		}
		List<SocketDTO> results = new ArrayList<SocketDTO>();
		for (Socket each : sockets) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static Socket toEntity(SocketDTO socketDTO) {
		if (socketDTO == null) {
			return null;
		}
		Socket result = new Socket();
		result.setId(socketDTO.getId());
		result.setVersion(socketDTO.getVersion());
		result.setCreateTimestamp(socketDTO.getCreateTimestamp());
		result.setLastModifyTimestamp(socketDTO.getLastModifyTimestamp());
		result.setCreateEmployNo(socketDTO.getCreateEmployNo());
		result.setLastModifyEmployNo(socketDTO.getLastModifyEmployNo());
		result.setCategory(socketDTO.getCategory());
		result.setPartNo(socketDTO.getPartNo());
		result.setPartName(socketDTO.getPartName());
		result.setEquipmentList(socketDTO.getEquipmentList());
		result.setPartType(socketDTO.getPartType());
		result.setPartModel(socketDTO.getPartModel());
		result.setProductModel(socketDTO.getProductModel());
		result.setNowProductModel(socketDTO.getNowProductModel());
		result.setInDate(socketDTO.getInDate());
		result.setPartLocaltion(socketDTO.getPartLocaltion());
		result.setManufacturerNo(socketDTO.getManufacturerNo());
		result.setManufacturerName(socketDTO.getManufacturerName());
		result.setCustomerName(socketDTO.getCustomerName());
		result.setCustomerNameEn(socketDTO.getCustomerNameEn());
		result.setOwnership(socketDTO.getOwnership());
		// result.setStatus (socketDTO.getStatus());
		result.setRemark(socketDTO.getRemark());
		// result.setEquipment (socketDTO.getEquipment());
		result.setPn(socketDTO.getPn());
		result.setPinModels(socketDTO.getPinModels());
		result.setSupplier(socketDTO.getSupplier());
		result.setQty(socketDTO.getQty());
		result.setPinQty(socketDTO.getPinQty());
		result.setRemark(socketDTO.getRemark());
		result.setApplicableModels(socketDTO.getApplicableModels());
		result.setLastFileUrl(socketDTO.getLastFileUrl());
		result.setAppearanceLevel(socketDTO.getAppearanceLevel());
		result.setPlatformSite(socketDTO.getPlatformSite());
		result.setEquipmentListId(socketDTO.getEquipmentListId());
		return result;
	}

	public static List<Socket> toEntities(Collection<SocketDTO> socketDTOs) {
		if (socketDTOs == null) {
			return null;
		}

		List<Socket> results = new ArrayList<Socket>();
		for (SocketDTO each : socketDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}

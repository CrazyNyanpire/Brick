package acetecsemi.com.brick.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.FileUploadAssembler;
import acetecsemi.com.brick.facade.FileUploadFacade;
import acetecsemi.com.brick.application.FileUploadApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class FileUploadFacadeImpl implements FileUploadFacade {

	@Inject
	private FileUploadApplication application;

	private QueryChannelService queryChannel;

	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	public FileUploadDTO getFileUpload(Long id) {
		return FileUploadAssembler.toDTO(application
				.getFileUpload(id));
	}

	public InvokeResult creatFileUpload(FileUploadDTO fileUploadDTO) {
		application
				.creatFileUpload(FileUploadAssembler.toEntity(fileUploadDTO));
		return InvokeResult.success();
	}

	public InvokeResult updateFileUpload(FileUploadDTO fileUploadDTO) {
		application.updateFileUpload(FileUploadAssembler
				.toEntity(fileUploadDTO));
		return InvokeResult.success();
	}

	public InvokeResult removeFileUpload(Long id) {
		application.removeFileUpload(application.getFileUpload(id));
		return InvokeResult.success();
	}

	public InvokeResult removeFileUploads(Long[] ids) {
		Set<FileUpload> fileUploads = new HashSet<FileUpload>();
		for (Long id : ids) {
			fileUploads.add(application.getFileUpload(id));
		}
		application.removeFileUploads(fileUploads);
		return InvokeResult.success();
	}

	public List<FileUploadDTO> findAllFileUpload() {
		return FileUploadAssembler.toDTOs(application.findAllFileUpload());
	}

	public Page<FileUploadDTO> pageQueryFileUpload(FileUploadDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder(
				"select _fileUpload from FileUpload _fileUpload   where 1=1 ");
		if (queryVo.getLocalPath() != null
				&& !"".equals(queryVo.getLocalPath())) {
			jpql.append(" and _fileUpload.localPath like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getLocalPath()));
		}
		if (queryVo.getIp() != null && !"".equals(queryVo.getIp())) {
			jpql.append(" and _fileUpload.ip like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIp()));
		}
		if (queryVo.getPort() != null && !"".equals(queryVo.getPort())) {
			jpql.append(" and _fileUpload.port like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPort()));
		}
		if (queryVo.getNetPath() != null && !"".equals(queryVo.getNetPath())) {
			jpql.append(" and _fileUpload.netPath like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getNetPath()));
		}
		if (queryVo.getFileTypes() != null
				&& !"".equals(queryVo.getFileTypes())) {
			jpql.append(" and _fileUpload.fileTypes like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getFileTypes()));
		}
		if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
			jpql.append(" and _fileUpload.type like ?");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getType()));
		}
		if (queryVo.getDescription() != null
				&& !"".equals(queryVo.getDescription())) {
			jpql.append(" and _fileUpload.description like ?");
			conditionVals.add(MessageFormat.format("%{0}%",
					queryVo.getDescription()));
		}
		Page<FileUpload> pages = getQueryChannelService()
				.createJpqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<FileUploadDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				FileUploadAssembler.toDTOs(pages.getData()));
	}

	public InvokeResult fileUpload(byte[] bytes, String filename) {
		return this.fileUpload(bytes, filename, Long.valueOf(1));
	}
	
	public InvokeResult fileUpload(byte[] bytes, String filename,Long id) {
		FileUploadDTO fileUploadDTO = FileUploadAssembler.toDTO(application
				.getFileUpload(id));
		String timeMill = String.valueOf(System.currentTimeMillis());
		filename = timeMill + "_" + filename;
		try {
			if (bytes.length > fileUploadDTO.getMaxSize()) {
				return InvokeResult.failure("You failed to upload " + filename
						+ " because the file was to long.");
			}
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(fileUploadDTO.getLocalPath()
							+ "/" + filename)));
			stream.write(bytes);
			stream.close();
			return InvokeResult.success(fileUploadDTO.getIp() + ":"
					+ fileUploadDTO.getPort() + "/"
					+ fileUploadDTO.getNetPath() + filename);
		} catch (Exception e) {
			return InvokeResult.failure("You failed to upload " + filename
					+ " => " + e.getMessage());
		}
	}

}

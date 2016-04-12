package acetecsemi.com.brick.web.controller;

import javax.inject.Inject;

import org.springframework.web.bind.WebDataBinder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.dayatang.utils.Page;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.FileUploadFacade;

import org.openkoala.koala.commons.InvokeResult;

@Controller
@RequestMapping("/FileUpload")
public class FileUploadController {

	@Inject
	private FileUploadFacade fileUploadFacade;

	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(FileUploadDTO fileUploadDTO) {
		return fileUploadFacade.creatFileUpload(fileUploadDTO);
	}

	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(FileUploadDTO fileUploadDTO) {
		return fileUploadFacade.updateFileUpload(fileUploadDTO);
	}

	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(FileUploadDTO fileUploadDTO, @RequestParam int page,
			@RequestParam int pagesize) {
		Page<FileUploadDTO> all = fileUploadFacade.pageQueryFileUpload(
				fileUploadDTO, page, pagesize);
		return all;
	}

	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
		Long[] idArrs = new Long[value.length];
		for (int i = 0; i < value.length; i++) {
			idArrs[i] = Long.parseLong(value[i]);
		}
		return fileUploadFacade.removeFileUploads(idArrs);
	}

	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return InvokeResult.success(fileUploadFacade.getFileUpload(id));
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		// CustomDateEditor 可以换成自己定义的编辑器。
		// 注册一个Date 类型的绑定器 。
		binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "You can upload a file by posting to this same URL.";
	}

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public InvokeResult handleFileUpload(
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				return fileUploadFacade.fileUpload(file.getBytes(),
						file.getOriginalFilename());
			} catch (IOException e) {
				return InvokeResult.failure("You failed to upload "
						+ file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			return InvokeResult.failure("You failed to upload "
					+ file.getOriginalFilename()
					+ " because the file was empty.");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/Socket/upload", method = RequestMethod.POST)
	public InvokeResult socketFileUpload(
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				return fileUploadFacade.fileUpload(file.getBytes(),
						file.getOriginalFilename(),Long.valueOf(2));
			} catch (IOException e) {
				return InvokeResult.failure("You failed to upload "
						+ file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			return InvokeResult.failure("You failed to upload "
					+ file.getOriginalFilename()
					+ " because the file was empty.");
		}
	}

}

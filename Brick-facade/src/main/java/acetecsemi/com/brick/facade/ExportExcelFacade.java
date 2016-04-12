package acetecsemi.com.brick.facade;

import java.io.OutputStream;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletOutputStream;
import javax.xml.ws.BindingType;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

public interface ExportExcelFacade {

	public void exportExcelTest(OutputStream outputStream);

	public void exportExcelEquipmentStatus(OutputStream outputStream,
			String startTime, String endTime,Long equipmentCategroyId);
	
	public void exportExcelEquipmentOptionLog(OutputStream outputStream,
			String startTime, String endTime,Long equipmentCategroyId,String equipmentNo);

}

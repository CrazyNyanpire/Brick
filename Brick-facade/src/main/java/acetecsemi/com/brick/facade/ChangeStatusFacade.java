package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;

@WebService()
@BindingType(value = "http://www.w3.org/2003/05/soap/bindings/HTTP/")
public interface ChangeStatusFacade {

	public InvokeResult changeStatus(ChangeStatusDTO changeStatusDTO);

	public Page<ChangeStatusDTO> pageQueryChangeStatus(ChangeStatusDTO queryVo,
			int currentPage, int pageSize);

}

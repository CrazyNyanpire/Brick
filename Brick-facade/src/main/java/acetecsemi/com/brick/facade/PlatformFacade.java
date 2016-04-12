package acetecsemi.com.brick.facade;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.*;
@WebService()
public interface PlatformFacade {
	@GET() 
    @Path("getPlatform/{id}") 
    @Produces({ MediaType.APPLICATION_XML }) 
	public PlatformDTO getPlatform(Long id);
	
	public String creatPlatform(PlatformDTO platform);
	
	public Boolean updatePlatform(PlatformDTO platform);
	
	public Boolean removePlatform(Long id);
	
	public Boolean removePlatforms(Long[] ids);
	
	public List<PlatformDTO> findAllPlatform();
	
	public Page<PlatformDTO> pageQueryPlatform(PlatformDTO platform, int currentPage, int pageSize);
	
	public Boolean assemblePlatform(PlatformDTO platformDTO);
	
	public Boolean splitPlatform(PlatformDTO platformDTO);
	
	public String changePlatformStatus(PlatformDTO platformDTO); 
	
	public List<PlatformDTO> findPlatformByType(String type);

	public List<EquipmentDTO> findEquipmentsByPlatform(Long id);
	
	public PlatformDTO findPlatformByEquipmentNo(String equipmentNo);

}


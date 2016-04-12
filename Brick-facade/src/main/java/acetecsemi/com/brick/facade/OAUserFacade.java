package acetecsemi.com.brick.facade;

import java.util.List;

import acetecsemi.com.brick.facade.dto.OAUserDTO;

public interface OAUserFacade {

	public List<OAUserDTO> findAll();
	
	public List<OAUserDTO> findByCondition(OAUserDTO oaUserDTO);
}

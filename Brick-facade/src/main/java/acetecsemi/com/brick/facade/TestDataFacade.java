package acetecsemi.com.brick.facade;

import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.dto.PlatformDTO;


public interface TestDataFacade {

	public InvokeResult getCPTestData(PlatformDTO platformDTO);

	public InvokeResult getFTTestData(PlatformDTO platformDTO);

}

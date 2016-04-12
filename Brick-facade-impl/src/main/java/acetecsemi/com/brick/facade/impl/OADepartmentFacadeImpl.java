package acetecsemi.com.brick.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.QueryChannelService;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;

import acetecsemi.com.brick.facade.ChangeStatusFacade;
import acetecsemi.com.brick.facade.dto.ChangeStatusDTO;
import acetecsemi.com.brick.facade.impl.assembler.ChangeStatusAssembler;

@Named
public class OADepartmentFacadeImpl {

	private QueryChannelService queryChannel;
	
	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	
}

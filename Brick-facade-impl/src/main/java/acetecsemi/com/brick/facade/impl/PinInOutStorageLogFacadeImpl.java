package acetecsemi.com.brick.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;

import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.facade.impl.assembler.PinAssembler;
import acetecsemi.com.brick.facade.impl.assembler.PinInOutStorageLogAssembler;
import acetecsemi.com.brick.facade.impl.assembler.SocketAssembler;
import acetecsemi.com.brick.facade.PinInOutStorageLogFacade;
import acetecsemi.com.brick.application.PinApplication;
import acetecsemi.com.brick.application.PinInOutStorageLogApplication;
import acetecsemi.com.brick.application.SocketApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
public class PinInOutStorageLogFacadeImpl implements PinInOutStorageLogFacade {

	@Inject
	private PinInOutStorageLogApplication  application;
	
	@Inject
	private PinApplication  pinApplication;
	
	@Inject
	private SocketApplication  socketApplication;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public PinInOutStorageLogDTO getPinInOutStorageLog(Long id) {
		return PinInOutStorageLogAssembler.toDTO(application.getPinInOutStorageLog(id));
	}
	
	public Boolean creatPinInOutStorageLog(PinInOutStorageLogDTO pinInOutStorageLogDTO) {
		PinInOutStorageLog pinInOutStorageLog = new PinInOutStorageLog();
		pinInOutStorageLog.setPin(pinApplication.getPin(pinInOutStorageLogDTO.getId()));
		pinInOutStorageLog.setSocket(socketApplication.getSocket(pinInOutStorageLogDTO.getId()));
		application.creatPinInOutStorageLog(PinInOutStorageLogAssembler.toEntity(pinInOutStorageLogDTO));
		return true;
	}
	
	public Boolean updatePinInOutStorageLog(PinInOutStorageLogDTO pinInOutStorageLogDTO) {
		application.updatePinInOutStorageLog(PinInOutStorageLogAssembler.toEntity(pinInOutStorageLogDTO));
		return true;
	}
	
	public Boolean removePinInOutStorageLog(Long id) {
		application.removePinInOutStorageLog(application.getPinInOutStorageLog(id));
		return true;
	}
	
	public Boolean removePinInOutStorageLogs(Long[] ids) {
		Set<PinInOutStorageLog> pinInOutStorageLogs= new HashSet<PinInOutStorageLog>();
		for (Long id : ids) {
			pinInOutStorageLogs.add(application.getPinInOutStorageLog(id));
		}
		application.removePinInOutStorageLogs(pinInOutStorageLogs);
		return true;
	}
	
	public List<PinInOutStorageLogDTO> findAllPinInOutStorageLog() {
		return PinInOutStorageLogAssembler.toDTOs(application.findAllPinInOutStorageLog());
	}
	
	public Page<PinInOutStorageLogDTO> pageQueryPinInOutStorageLog(PinInOutStorageLogDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _pinInOutStorageLog from PinInOutStorageLog _pinInOutStorageLog   left join _pinInOutStorageLog.socket  where 1=1 ");
	   	if (queryVo.getCreateTimestamp() != null) {
	   		jpql.append(" and _pinInOutStorageLog.createTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getCreateTimestamp());
	   		conditionVals.add(queryVo.getCreateTimestampEnd());
	   	}	
	   	if (queryVo.getLastModifyTimestamp() != null) {
	   		jpql.append(" and _pinInOutStorageLog.lastModifyTimestamp between ? and ? ");
	   		conditionVals.add(queryVo.getLastModifyTimestamp());
	   		conditionVals.add(queryVo.getLastModifyTimestampEnd());
	   	}	
	   	if (queryVo.getCreateEmployNo() != null && !"".equals(queryVo.getCreateEmployNo())) {
	   		jpql.append(" and _pinInOutStorageLog.createEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCreateEmployNo()));
	   	}		
	   	if (queryVo.getLastModifyEmployNo() != null && !"".equals(queryVo.getLastModifyEmployNo())) {
	   		jpql.append(" and _pinInOutStorageLog.lastModifyEmployNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLastModifyEmployNo()));
	   	}		
	   	if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
	   		jpql.append(" and _pinInOutStorageLog.type like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getType()));
	   	}		
	   	if (queryVo.getModel() != null && !"".equals(queryVo.getModel())) {
	   		jpql.append(" and _pinInOutStorageLog.pin.model like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getModel()));
	   	}
	   	if (queryVo.getPinId() != null) {
	   		jpql.append(" and _pinInOutStorageLog.pin.id = ?");
	   		conditionVals.add(queryVo.getPinId());
	   	}	
	   	if (queryVo.getPartNo() != null && !"".equals(queryVo.getPartNo())) {
	   		jpql.append(" and _pinInOutStorageLog.socket.partNo like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPartNo()));
	   	}
	   	
	   	jpql.append(" order by _pinInOutStorageLog.createTimestamp desc");
        Page<PinInOutStorageLog> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<PinInOutStorageLogDTO>(pages.getStart(), pages.getResultCount(),pageSize, PinInOutStorageLogAssembler.toDTOs(pages.getData()));
	}
	
	public SocketDTO findSocketByPinInOutStorageLog(Long id) {
		String jpql = "select e from PinInOutStorageLog o right join o.socket e where o.id=?";
		Socket result = (Socket) getQueryChannelService().createJpqlQuery(jpql).setParameters(new Object[] { id }).singleResult();
		SocketDTO  dto = new SocketDTO();
		if (result != null) {
			try {
				dto = SocketAssembler.toDTO(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public PinDTO findPinByPinInOutStorageLog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

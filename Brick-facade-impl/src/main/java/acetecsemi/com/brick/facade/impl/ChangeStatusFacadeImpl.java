package acetecsemi.com.brick.facade.impl;

import java.text.MessageFormat;
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
public class ChangeStatusFacadeImpl implements ChangeStatusFacade {

	private QueryChannelService queryChannel;
	
	private QueryChannelService getQueryChannelService() {
		if (queryChannel == null) {
			queryChannel = InstanceFactory.getInstance(
					QueryChannelService.class, "queryChannel");
		}
		return queryChannel;
	}

	@Override
	public InvokeResult changeStatus(ChangeStatusDTO changeStatusDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ChangeStatusDTO> pageQueryChangeStatus(ChangeStatusDTO queryVo,
			int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
		StringBuilder jpql = new StringBuilder("SELECT * FROM (");
		jpql.append("SELECT a.id,a.`status`,c.equipmentNo NO,a.platformCategory category,'platform' type,d.equipmentNo,a.nowLot,a.productModel,b.categoryName categoryName,c.equipmentLocation_ID location,b.url,b.id testerCategoryId,c.subStatus subStatus,a.version ");
		jpql.append("FROM brick_platform a ");
		jpql.append("INNER JOIN brick_equipment c ON a.tester_id = c.ID ");
		jpql.append("INNER JOIN brick_equipment d ON d.platform_ID = a.ID " );
		jpql.append("LEFT JOIN brick_category b ON c.Category_ID = b.ID  " );
		jpql.append(" UNION ");
		jpql.append("SELECT a.id,`status`,equipmentNo NO,b.categoryCode category,'equipment' type,'' equipmentNo,a.nowLot,a.productModel,b.categoryName categoryName,a.equipmentLocation_ID location,c.url,b.id testerCategoryId,subStatus subStatus,a.version ");
		jpql.append("FROM brick_equipment a ");
		jpql.append("INNER JOIN brick_category b ON a.equipmentCategory_ID = b.ID ");
		jpql.append("INNER JOIN brick_category c ON a.Category_ID = c.ID ");
		jpql.append("WHERE b.sign = 'changeStatus') a WHERE 1=1");
		if (queryVo.getStatus() != null && !"".equals(queryVo.getStatus())) {
			jpql.append(" and a.status = ? ");
			conditionVals.add(queryVo.getStatus());
		}
		if (queryVo.getSubStatus() != null && !"".equals(queryVo.getSubStatus())) {
			jpql.append(" and a.subStatus = ? ");
			conditionVals.add(queryVo.getSubStatus());
		}
		if (queryVo.getCategory() != null && !"".equals(queryVo.getCategory())) {
			jpql.append(" and a.category = ? ");
			conditionVals.add(queryVo.getCategory());
		}
		if (queryVo.getType() != null && !"".equals(queryVo.getType())) {
			jpql.append(" and a.type = ? ");
			conditionVals.add(queryVo.getType().toLowerCase());
		}
		if (queryVo.getLocation() != null && !"".equals(queryVo.getLocation())) {
			jpql.append(" and a.location = ? ");
			conditionVals.add(Long.valueOf(queryVo.getLocation()));
		}
		if (queryVo.getTesterCategoryId() != null ) {
			jpql.append(" and a.testerCategoryId = ? ");
			conditionVals.add(queryVo.getTesterCategoryId());
		}
		if (queryVo.getEquipmentNo() != null  && !"".equals(queryVo.getEquipmentNo())) {
			jpql.append(" and a.NO like ? ");
			conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEquipmentNo()));
		}
		jpql.append(" order by NO ");
		@SuppressWarnings("unchecked")
		Page<Object[]> pages = getQueryChannelService()
				.createSqlQuery(jpql.toString()).setParameters(conditionVals)
				.setPage(currentPage, pageSize).pagedList();

		return new Page<ChangeStatusDTO>(pages.getStart(),
				pages.getResultCount(), pageSize,
				ChangeStatusAssembler.toDTOs(pages.getData()));
	}
	
}

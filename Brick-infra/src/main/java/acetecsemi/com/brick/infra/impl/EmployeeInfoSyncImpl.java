package acetecsemi.com.brick.infra.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.organisation.core.domain.Employee;
import org.openkoala.organisation.facade.EmployeeFacade;
import org.openkoala.organisation.facade.dto.EmployeeDTO;
import org.openkoala.security.org.core.domain.EmployeeUser;
import org.openkoala.security.org.facade.SecurityOrgAccessFacade;
import org.openkoala.security.org.facade.SecurityOrgConfigFacade;
import org.openkoala.security.org.facade.command.CreateEmpolyeeUserCommand;
import org.openkoala.security.org.facade.dto.AuthorizationCommand;
import org.openkoala.security.org.facade.dto.EmployeeUserDTO;

import acetecsemi.com.brick.facade.OAUserFacade;
import acetecsemi.com.brick.facade.dto.OAUserDTO;
import acetecsemi.com.brick.infra.EmployeeInfoSync;
import acetecsemi.com.brick.infra.task.MaintenancePlatformTask;

public class EmployeeInfoSyncImpl implements EmployeeInfoSync {
	@Inject
	private EmployeeFacade employeeFacade;

	@Inject
	private OAUserFacade oaUserFacade;

	@Inject
	private SecurityOrgConfigFacade securityOrgConfigFacade;

	@Inject
	private SecurityOrgAccessFacade securityOrgAccessFacade;

	private static Logger LOGGER = Logger.getLogger(EmployeeInfoSyncImpl.class);

	public void sync() {
		List<OAUserDTO> list = oaUserFacade.findAll();
		List<EmployeeDTO> employeeList = employeeFacade.pagingQueryEmployees(
				new EmployeeDTO(), 0, 10000).getData();
		for (OAUserDTO oaUserDTO : list) {
			EmployeeDTO employeeDTO = this.getEmployeePersistent(employeeList,
					oaUserDTO);
			employeeDTO = this.createEmployeeDTO(employeeDTO, oaUserDTO);
			employeeFacade.createEmployee(employeeDTO);
		}

	}

	@SuppressWarnings("unchecked")
	public void createUser() {
		List<Employee> employeeList = (List<Employee>) employeeFacade.findAll()
				.getData();
		List<Employee> newEmployee = new ArrayList<Employee>();
		for (Employee employee : employeeList) {
			CreateEmpolyeeUserCommand command = new CreateEmpolyeeUserCommand();
			// name=&userAccount=&description=&employeeid=
			command.setName(employee.getName());
			command.setUserAccount(employee.getSn());
			command.setEmployeeId(employee.getId());
			command.setCreateOwner("Koala");
			InvokeResult invokeResult = securityOrgConfigFacade
					.createEmployeeUser(command);
			if (invokeResult.isHasErrors()) {
				newEmployee.add(employee);
			}
		}

	}

	public void grantUser() {
		List<EmployeeUserDTO> noRoleUsers = securityOrgAccessFacade
				.queryEmployeeUsersNoRole();
		for (EmployeeUserDTO user : noRoleUsers) {
			AuthorizationCommand command = new AuthorizationCommand();
			// actorId（用户ID）=&organizationId=2&organizationName=IT&authorityIds=（角色ID）
			command.setActorId(user.getId());
			command.setOrganizationId(Long.valueOf(2));
			command.setOrganizationName("IT");
			command.setAuthorityIds(new Long[] { Long.valueOf(9) });
			// SecurityConfigFacade
			InvokeResult invokeResult = securityOrgConfigFacade
					.grantAuthorityToActorInScope(command);
			if (invokeResult.isHasErrors())
				LOGGER.info(invokeResult.getErrorMessage());
		}

	}

	private EmployeeDTO createEmployeeDTO(EmployeeDTO employeeDto,
			OAUserDTO oaUserDTO) {
		if (employeeDto == null)
			employeeDto = new EmployeeDTO();
		employeeDto.setGender("0".equals(oaUserDTO.getSex()) ? "MALE"
				: "FEMALE");
		employeeDto.setMobilePhone(oaUserDTO.getMobile());
		employeeDto.setFamilyPhone("");
		employeeDto.setEmail(oaUserDTO.getEmail());
		employeeDto.setName(oaUserDTO.getName());
		employeeDto.setSn(oaUserDTO.getAccounts());
		employeeDto.setOrganizationName(oaUserDTO.getDeptName());
		return employeeDto;
	}

	private EmployeeDTO getEmployeePersistent(List<EmployeeDTO> employeeList,
			OAUserDTO oaUserDTO) {
		for (EmployeeDTO employeeDTO : employeeList) {
			if (employeeDTO.getSn().equalsIgnoreCase(oaUserDTO.getAccounts())) {
				return employeeDTO;
			}
		}
		return null;
	}
}

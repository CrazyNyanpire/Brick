package acetecsemi.com.brick.facade.dto;

import java.io.Serializable;

public class OADepartmentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6361034277909065599L;

	private Long id; // 平台或设备id

	private String deptName;// 状态

	private String deptNo;// 分类
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	
}
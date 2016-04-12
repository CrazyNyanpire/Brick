package acetecsemi.com.brick.core.domain;

import java.util.Date;

public class PartApply extends Apply {
	
	private Part part;
	
	private Platform platform; //平台编号
	
	private Date planStartTime; //预计起始时间
	
	private Date planEndTime; //预计结束时间
	
	private String planTime; //预计用时
	
	private String borrowSource; //借机对象
}

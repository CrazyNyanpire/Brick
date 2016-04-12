package acetecsemi.com.brick.facade.dto;

public class CPGetTestDataDTO {

	private String waferId;

	private String tested;

	private String touchDown;
	
	private Boolean isFinish;
	
	private String fileName;
	
	private String createDate;
	
	private Integer order;

	public String getWaferId() {
		return waferId;
	}

	public void setWaferId(String waferId) {
		this.waferId = waferId;
	}

	public String getTested() {
		return tested;
	}

	public void setTested(String tested) {
		this.tested = tested;
	}

	public String getTouchDown() {
		return touchDown;
	}

	public void setTouchDown(String touchDown) {
		this.touchDown = touchDown;
	}

	public Boolean getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(Boolean isFinish) {
		this.isFinish = isFinish;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}

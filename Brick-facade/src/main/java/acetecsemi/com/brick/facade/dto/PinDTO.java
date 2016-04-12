package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.openkoala.koala.springmvc.JsonDateSerializer;

public class PinDTO implements Serializable {

	private Long id;

	private int version;

	private String lastModifyEmployNo;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private String model;

	private String createEmployNo;

	private String theoryTestUph;

	private Integer useQty;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private Integer totalQty;

	private Integer qty;// In或者Out数量

	private Integer initQty;// 原数量

	private Integer balanceQty;// 剩余数量

	private String type; // In 或者 Out

	private String remark;
	
	private Long socketId;
	
	private Date inDate;
	
	private Date inDateEnd;

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestampEnd(Date createTimestampEnd) {
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return this.model;
	}

	public void setBalanceQty(Integer balanceQty) {
		this.balanceQty = balanceQty;
	}

	public Integer getBalanceQty() {
		return this.balanceQty;
	}

	public void setCreateEmployNo(String createEmployNo) {
		this.createEmployNo = createEmployNo;
	}

	public String getCreateEmployNo() {
		return this.createEmployNo;
	}

	public void setTheoryTestUph(String theoryTestUph) {
		this.theoryTestUph = theoryTestUph;
	}

	public String getTheoryTestUph() {
		return this.theoryTestUph;
	}

	public void setUseQty(Integer useQty) {
		this.useQty = useQty;
	}

	public Integer getUseQty() {
		return this.useQty;
	}

	public void setLastModifyTimestamp(Date lastModifyTimestamp) {
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	public Date getLastModifyTimestamp() {
		return this.lastModifyTimestamp;
	}

	public void setLastModifyTimestampEnd(Date lastModifyTimestampEnd) {
		this.lastModifyTimestampEnd = lastModifyTimestampEnd;
	}

	public Date getLastModifyTimestampEnd() {
		return this.lastModifyTimestampEnd;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public Integer getTotalQty() {
		return this.totalQty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getInitQty() {
		return initQty;
	}

	public void setInitQty(Integer initQty) {
		this.initQty = initQty;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSocketId() {
		return socketId;
	}

	public void setSocketId(Long socketId) {
		this.socketId = socketId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PinDTO other = (PinDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getInDateEnd() {
		return inDateEnd;
	}

	public void setInDateEnd(Date inDateEnd) {
		this.inDateEnd = inDateEnd;
	}
}
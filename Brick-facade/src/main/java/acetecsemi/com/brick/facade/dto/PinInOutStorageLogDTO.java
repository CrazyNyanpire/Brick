package acetecsemi.com.brick.facade.dto;

import java.util.Date;
import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import acetecsemi.com.brick.facade.utils.JsonDateTimeSerializer;

public class PinInOutStorageLogDTO implements Serializable {

	private Long id;

	private int version;

	private String lastModifyEmployNo;

	private Date createTimestamp;

	private Date createTimestampEnd;

	private Integer initQty;

	private Integer balanceQty;

	private String createEmployNo;

	private Integer qty;

	private Date lastModifyTimestamp;

	private Date lastModifyTimestampEnd;

	private String type;

	private String remark;
	
	private PinDTO pinDTO;
	
	private Long pinId;
	
	private SocketDTO socketDTO;
	
	private Long socketId;
	
	private String model;
	
	private String partNo;

	public void setLastModifyEmployNo(String lastModifyEmployNo) {
		this.lastModifyEmployNo = lastModifyEmployNo;
	}

	public String getLastModifyEmployNo() {
		return this.lastModifyEmployNo;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestampEnd(Date createTimestampEnd) {
		this.createTimestampEnd = createTimestampEnd;
	}

	public Date getCreateTimestampEnd() {
		return this.createTimestampEnd;
	}

	public void setInitQty(Integer initQty) {
		this.initQty = initQty;
	}

	public Integer getInitQty() {
		return this.initQty;
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

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getQty() {
		return this.qty;
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

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PinDTO getPinDTO() {
		return pinDTO;
	}

	public void setPinDTO(PinDTO pinDTO) {
		this.pinDTO = pinDTO;
	}

	public SocketDTO getSocketDTO() {
		return socketDTO;
	}

	public void setSocketDTO(SocketDTO socketDTO) {
		this.socketDTO = socketDTO;
	}

	public Long getPinId() {
		return pinId;
	}

	public void setPinId(Long pinId) {
		this.pinId = pinId;
	}

	public Long getSocketId() {
		return socketId;
	}

	public void setSocketId(Long socketId) {
		this.socketId = socketId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
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
		PinInOutStorageLogDTO other = (PinInOutStorageLogDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
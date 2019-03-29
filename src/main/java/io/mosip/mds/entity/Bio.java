package io.mosip.mds.entity;

public class Bio {
	
	private Integer type;
	private Integer count;
	private Integer format;
	private Integer requestedScore;
	private Integer deviceId;
	private Integer deviceSubId;
//	private CustomOPts customOpts;
	
	
	
	public Bio(Integer type, Integer count, Integer format, Integer requestedScore, Integer deviceId,
			Integer deviceSubId) {
		super();
		this.type = type;
		this.count = count;
		this.format = format;
		this.requestedScore = requestedScore;
		this.deviceId = deviceId;
		this.deviceSubId = deviceSubId;
//		this.customOpts = customOpts;
	}
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getFormat() {
		return format;
	}
	public void setFormat(Integer format) {
		this.format = format;
	}
	public Integer getRequestedScore() {
		return requestedScore;
	}
	public void setRequestedScore(Integer requestedScore) {
		this.requestedScore = requestedScore;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getDeviceSubId() {
		return deviceSubId;
	}
	public void setDeviceSubId(Integer deviceSubId) {
		this.deviceSubId = deviceSubId;
	}
//	co
	
	
	

}

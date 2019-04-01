package io.mosip.mds.entity;

public class Data {
	
	//How are we getting the values
	//Opt1: from device every time
	//Opt2: stored one time based on some database
//	if yes then optimise the code accordiing to it
	private Integer deviceCode;
	private Integer deviceProviderId;
	private Integer deviceServiceId;
	private Integer deviceServiceVersion;
	private Integer bioSubType;
	private String mosipProcess;
	private String env;
	private String bioValue;
	private String bioExtract;
	private String timestamp;
	private float requestedScore;
	private float qualityScore;
	
	public Data() {
		
	}
	
	public Data(Integer deviceCode, Integer deviceProviderId, Integer deviceServiceId, Integer deviceServiceVersion,
			Integer bioSubType, String mosipProcess, String env, String bioValue, String bioExtract, String timestamp,
			float requestedScore, float qualityScore) {
		super();
		this.deviceCode = deviceCode;
		this.deviceProviderId = deviceProviderId;
		this.deviceServiceId = deviceServiceId;
		this.deviceServiceVersion = deviceServiceVersion;
		this.bioSubType = bioSubType;
		this.mosipProcess = mosipProcess;
		this.env = env;
		this.bioValue = bioValue;
		this.bioExtract = bioExtract;
		this.timestamp = timestamp;
		this.requestedScore = requestedScore;
		this.qualityScore = qualityScore;
	}


	
	public Integer getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(Integer deviceCode) {
		this.deviceCode = deviceCode;
	}
	public Integer getDeviceProviderId() {
		return deviceProviderId;
	}
	public void setDeviceProviderId(Integer deviceProviderId) {
		this.deviceProviderId = deviceProviderId;
	}
	public Integer getDeviceServiceId() {
		return deviceServiceId;
	}
	public void setDeviceServiceId(Integer deviceServiceId) {
		this.deviceServiceId = deviceServiceId;
	}
	public Integer getBioSubType() {
		return bioSubType;
	}
	public void setBioSubType(Integer bioSubType) {
		this.bioSubType = bioSubType;
	}
	public String getMosipProcess() {
		return mosipProcess;
	}
	public void setMosipProcess(String mosipProcess) {
		this.mosipProcess = mosipProcess;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	public String getBioValue() {
		return bioValue;
	}
	public void setBioValue(String bioValue) {
		this.bioValue = bioValue;
	}
	public String getBioExtract() {
		return bioExtract;
	}
	public void setBioExtract(String bioExtract) {
		this.bioExtract = bioExtract;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public float getRequestedScore() {
		return requestedScore;
	}


	public void setRequestedScore(float requestedScore) {
		this.requestedScore = requestedScore;
	}


	public float getQualityScore() {
		return qualityScore;
	}


	public void setQualityScore(float qualityScore) {
		this.qualityScore = qualityScore;
	}
	
	
	
	
	

}

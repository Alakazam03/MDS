package io.mosip.mds.entity;

//import javax.persistence.Entity;

//@Entity
public class Device {
	private String type;
	private Integer deviceId;
	private String subType;
	private String deviceStatus;// Active Inactive
	private String certification; // L0 L1
	private String serviceVersion; // version of document
	private Integer deviceSubId; // starting from 1 url
	private String callbackId; // http url

	public Device() {
	}
	
	public Device(String type, Integer deviceId, String subType, String deviceStatus, String certification,
			String serviceVersion, Integer deviceSubId, String callbackId) {
		this.type = type;
		this.deviceId = deviceId;
		this.subType = subType;
		this.deviceStatus = deviceStatus;
		this.certification = certification;
		this.serviceVersion = serviceVersion;
		this.deviceSubId = deviceSubId;
		this.callbackId = callbackId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public Integer getDeviceSubId() {
		return deviceSubId;
	}

	public void setDeviceSubId(Integer deviceSubId) {
		this.deviceSubId = deviceSubId;
	}

	public String getCallbackId() {
		return callbackId;
	}

	public void setCallbackId(String callbackId) {
		this.callbackId = callbackId;
	}

	@Override
	public String toString() {
		return "Device [type=" + type + ", deviceId=" + deviceId + ", subType=" + subType + ", deviceStatus="
				+ deviceStatus + ", certification=" + certification + ", serviceVersion=" + serviceVersion
				+ ", deviceSubId=" + deviceSubId + ", callbackId=" + callbackId + "]";
	}
}
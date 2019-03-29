package io.mosip.mds.entity;


public class Info {

	private String Type;
	private Integer DeviceId;
	private String SubType;
	private String DeviceStatus;// Active Inactive
//	private String certification; // L0 L1
	private String ServiceVersion; // version of document
	private Integer DeviceSubId; // starting from 1 url
	private String CallbackId;
	private DeviceInfo deviceInfo;
	
	
	public Info() {
		
	}
	public Info(Device device, DeviceInfo info) {
		super();
		this.Type = device.getType();
//		this.deviceId = device.deviceId;
		this.SubType = device.getSubType();
		this.DeviceStatus = device.getDeviceStatus();
//		this.certification = device.certification;
		this.ServiceVersion = device.getServiceVersion();
//		this.deviceSubId = device.deviceSubId;
		this.CallbackId = device.getCallbackId();
		this.DeviceSubId = device.getDeviceSubId();
		deviceInfo = info;
		
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Integer getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(Integer deviceId) {
		DeviceId = deviceId;
	}
	public String getSubType() {
		return SubType;
	}
	public void setSubType(String subType) {
		SubType = subType;
	}
	public String getDeviceStatus() {
		return DeviceStatus;
	}
	public void setDeviceStatus(String deviceStatus) {
		DeviceStatus = deviceStatus;
	}
	public String getServiceVersion() {
		return ServiceVersion;
	}
	public void setServiceVersion(String serviceVersion) {
		ServiceVersion = serviceVersion;
	}
	public Integer getDeviceSubId() {
		return DeviceSubId;
	}
	public void setDeviceSubId(Integer deviceSubId) {
		DeviceSubId = deviceSubId;
	}
	public String getCallbackId() {
		return CallbackId;
	}
	public void setCallbackId(String callbackId) {
		CallbackId = callbackId;
	}
	public DeviceInfo getDeviceInfo() {
		return this.deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
	
	
}
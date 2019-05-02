package io.mosip.mds.entity;

import lombok.Data;

@Data
public class Info {

	private String Type;
	private String DeviceId;
	private String SubType;
	private String DeviceStatus;// Active Inactive
//	private String certification; // L0 L1
	private String ServiceVersion; // version of document
	private String DeviceSubId; // starting from 1 url
	private String CallbackId;
	private DeviceInfo deviceInfo;
	
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
	
}
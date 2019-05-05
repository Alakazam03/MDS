package io.mosip.mds.entity;

import lombok.Data;

@Data
public class Info {

	private String type;
	private String subType;
	private String status; // Active Inactive
	private DeviceInfo deviceInfo;
	private String deviceInfoSignature;
	private String serviceVersion; // version of document
	private String callbackId;
	private String deviceSubId; // starting from 1 url
	
	
	public Info(Device device, DeviceInfo info) {
		this.type = device.getType();
		this.subType = device.getSubType();
		this.status = device.getDeviceStatus();
		this.deviceInfo = info;
		this.deviceInfoSignature = "";
		this.serviceVersion = device.getServiceVersion();
		this.callbackId = device.getCallbackId();
		this.deviceSubId = device.getDeviceSubId();
	}
	
}
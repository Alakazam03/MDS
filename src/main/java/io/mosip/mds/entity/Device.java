package io.mosip.mds.entity;

import lombok.Data;

@Data
public class Device {
	private String type;
	private String deviceId;
	private String subType;
	private String deviceStatus;// Active Inactive
	private String certification; // L0 L1
	private String serviceVersion; // version of document
	private String deviceSubId; // starting from 1 url
	private String callbackId; // http url

	public Device() {
	}
	
	public Device(String type, String deviceId, String subType, String deviceStatus, String certification,
			String serviceVersion, String deviceSubId, String callbackId) {
		this.type = type;
		this.deviceId = deviceId;
		this.subType = subType;
		this.deviceStatus = deviceStatus;
		this.certification = certification;
		this.serviceVersion = serviceVersion;
		this.deviceSubId = deviceSubId;
		this.callbackId = callbackId;
	}

}
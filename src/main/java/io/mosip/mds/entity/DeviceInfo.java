package io.mosip.mds.entity;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class DeviceInfo {
	private String deviceId;
	private List<String> deviceSubId;
	private String firmware;
	private String deviceProvideName;
	private String deviceProviderId;
	private String deviceModel;
	private String deviceMake;
	private String deviceExpiry;
	private String certification;
	private String timestamp;

	public DeviceInfo(String deviceId, List<String> deviceSubId, String firmware, String deviceProvideName, String deviceProviderId, String deviceModel,
			String deviceMake, String deviceExpiry, String certification, String timestamp) {
		this.deviceId = deviceId;
		this.deviceSubId = deviceSubId;
		this.firmware = firmware;
		this.deviceProvideName = deviceProvideName;
		this.deviceProviderId = deviceProviderId;
		this.deviceModel = deviceModel;
		this.deviceMake = deviceMake;
		this.deviceExpiry = deviceExpiry;
		this.certification = certification;
		this.timestamp = timestamp;
	}
}

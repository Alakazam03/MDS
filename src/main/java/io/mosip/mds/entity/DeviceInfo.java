package io.mosip.mds.entity;


import java.util.Date;

public class DeviceInfo {
	
	private Integer deviceId;
	private Integer deviceSubId;
	private Integer firmware;
	private String deviceProvideName;
	private Integer deviceModel;
	private Integer deviceMake;
	private Date deviceExpiry;
	private String certification;
	private String timestamp;
	
	//constructor
	
	public DeviceInfo() {
		
	}
	
	// constructor 2
	public DeviceInfo(Integer deviceId, Integer deviceSubId, Integer firmware, String deviceProvideName, Integer deviceModel,
			Integer deviceMake, Date deviceExpiry, String certification, String timestamp) {
		super();
		this.deviceId = deviceId;
		this.deviceSubId = deviceSubId;
		this.firmware = firmware;
		this.deviceProvideName = deviceProvideName;
		//model 
		this.deviceModel = deviceModel;
		this.deviceMake = deviceMake;
		this.deviceExpiry = deviceExpiry;
		this.certification = certification;
		this.timestamp = timestamp;
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
	public Integer getFirmware() {
		return firmware;
	}
	public void setFirmware(Integer firmware) {
		this.firmware = firmware;
	}
	public String getDeviceProvideName() {
		return deviceProvideName;
	}
	public void setDeviceProvideName(String deviceProvideName) {
		this.deviceProvideName = deviceProvideName;
	}
	public Integer getdeviceModel() {
		return deviceModel;
	}
	public void setdeviceModel(Integer model) {
		deviceModel = model;
	}
	public Integer getDeviceMake() {
		return deviceMake;
	}
	public void setDeviceMake(Integer deviceMake) {
		this.deviceMake = deviceMake;
	}
	public Date getDeviceExpiry() {
		return deviceExpiry;
	}
	public void setDeviceExpiry(Date deviceExpiry) {
		this.deviceExpiry = deviceExpiry;
	}
	
//	public String getCertification() {
//		return certification;
//	}
//	public void setCertification(String certification) {
//		this.certification = certification;
//	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "DeviceInfo [deviceId=" + deviceId + ", deviceSubId=" + deviceSubId + ", firmware=" + firmware
				+ ", deviceProvideName=" + deviceProvideName + ", Model=" + deviceModel + ", deviceMake=" + deviceMake
				+ ", deviceExpiry=" + deviceExpiry + ", certification=" + certification + ", timestamp=" + timestamp
				+ "]";
	}
	
	
	/*  
	 	Date() : Creates date object representing current date and time.
		Date(long milliseconds) : Creates a date object for the given milliseconds since January 1, 1970, 00:00:00 GMT.
		Date(int year, int month, int date)
		Date(int year, int month, int date, int hrs, int min)
		Date(int year, int month, int date, int hrs, int min, int sec)
		Date(String s)
	*/
	
	/*
	 	* TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());
		
		System.out.println(nowAsISO);
		
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
		//nowAsISO = "2013-05-31T00:00:00Z";
		Date finalResult = df1.parse(nowAsISO);
		
		System.out.println(finalResult);

	 */
	
	
	
	

}

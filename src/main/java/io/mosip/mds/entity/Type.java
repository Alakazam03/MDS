package io.mosip.mds.entity;

public enum Type {
	BIOMETRIC_DEVICE("Biometric Device"),
	FINGERPRINT("Fingerprint"),
	FACE("Face"),
	IRIS("Iris"),
	VEIN("Vein");

	private final String text;

	Type(final String t) {
		this.text = t;
	}

	@Override
	public String toString() {
		return this.text;
	}
}

// https://gitlab.com/mosip/mosip-wiki/blob/AnadiMechanisms/3.2--MOSIP-Java-coding-standards.md
/*
 package io.mosip.registration.constants;

/**
 * Device Type enum
 * @author Dinesh Ashokan
 *
public enum DeviceTypes {
	
	FINGERPRINT("Fingerprint"),
	IRIS("IRIS"),
	WEBCAM("webcam");
	
	/**
	 * @param code
	private DeviceTypes(String deviceType) {
		this.deviceType = deviceType;
	}

	private final String deviceType;

	/**
	 * @return the code
	public String getDeviceType() {
		return deviceType;
	}
	

}

 * */
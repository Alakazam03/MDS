package io.mosip.mds.entity;

public enum Type {
	BIOMETRIC_DEVICE("Biometric Device"), FINGERPRINT("Fingerprint"), FACE("Face"), IRIS("Iris"), VEIN("Vein");

	private final String text;

	Type(final String t) {
		this.text = t;
	}

	@Override
	public String toString() {
		return this.text;
	}
}
package io.mosip.mds.entity;

import java.util.Arrays;

public enum SubType {
	BIOMETRIC_DEVICE(new String[] { "" }), FINGERPRINT(new String[] { "Slab", "Single", "Touchless" }),
	FACE(new String[] { "" }), IRIS(new String[] { "Single", "Double" }), VEIN(new String[] { "Vein" });

	private final String[] subTypes;

	SubType(final String[] subTypes) {
		this.subTypes = subTypes;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.subTypes);
	}
}
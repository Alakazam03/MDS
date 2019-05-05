package io.mosip.mds.dto;

import lombok.Data;

@Data
public class Biometrics {
	
	private String hash;
	private String signature;
	private String sessionKey;
	private DataBlock data;
	
	public Biometrics(String i, String sessionKey, String signature, DataBlock d) {
		this.sessionKey = sessionKey;
		this.hash = i;
		this.signature = signature;
		this.data = d;
	}
	
}

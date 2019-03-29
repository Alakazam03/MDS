package io.mosip.mds.entity;

public class Biometrics {
	
	private String hash;
	private String signature;
	private Data d;
	
	public Biometrics(String hash, String signature, Data d) {
		super();
		this.hash = hash;
		this.signature = signature;
		this.d = d;
	}
	
	
	public String getHash() {
		return hash;
	}


	public void setHash(String hash) {
		this.hash = hash;
	}


	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public Data getD() {
		return d;
	}


	public void setD(Data d) {
		this.d = d;
	}


	

	
	
}

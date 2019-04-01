package io.mosip.mds.entity;

public class Biometrics {
	
	private String hash;
	private String signature;
	private Data data;
	
	public Biometrics(String i, String signature, Data d) {
		super();
		this.hash = i;
		this.signature = signature;
		this.data = d;
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
		return data;
	}


	public void setD(Data d) {
		this.data = d;
	}


	
//	setter
	

	
	
}

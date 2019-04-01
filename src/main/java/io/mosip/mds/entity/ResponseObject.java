package io.mosip.mds.entity;

import java.util.ArrayList;

public class ResponseObject {
	
	private ArrayList<Biometrics> b;

	public ResponseObject(ArrayList<Biometrics> b) {
		super();
		this.b = b;
	}

	public ArrayList<Biometrics> getB() {
		return b;
	}

	public void setB(ArrayList<Biometrics> b) {
		this.b = b;
	}
	
	

}

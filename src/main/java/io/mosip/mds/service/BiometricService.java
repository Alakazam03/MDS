package io.mosip.mds.service;
import io.mosip.mds.entity.Biometrics;
import io.mosip.mds.entity.DataBlock;
import io.mosip.mds.entity.Info;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class BiometricService {
	
//	private static final String UTF_8 = null;
	private ArrayList<Biometrics> list = new ArrayList<Biometrics>();
	StringBuilder hashStr = new StringBuilder("devuce123hfoeihf");
	


	public BiometricService(DataBlock data) {
		String hashCode = null;
		try {
			hashCode = this.hashWith256(hashWith256(String.valueOf(data)));
			String sessionKey = "sessionKey";
			String signature = "signature";
			list.add(new Biometrics(hashCode, sessionKey, signature, data));
		}
		catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
		
	}


	
	
	 
	 private String hashWith256(String textToHash) throws NoSuchAlgorithmException {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
		    byte[] hashedByetArray = digest.digest(byteOfTextToHash);
		    String encoded = Base64.getEncoder().encodeToString(hashedByetArray);
		    return encoded;
	}


	public ArrayList<Biometrics> allInfo() {
		return list;
	}
	
		

}
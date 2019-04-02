package io.mosip.mds.service;
import io.mosip.mds.entity.Biometrics;
import io.mosip.mds.entity.Data;
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
	
	
//	SHA256InJava sj = new SHA256InJava();
	
//	Data d = 
//	        String hash = sj.getSHA256Hash(data);
//	18
//	        System.out.println("The SHA256 (hexadecimal encoded) hash is:"+hash);
	//here hash can be deviceId

	public BiometricService(Data data) {
		super();
		
//		BiometricService bo = new BiometricService();
		
		String hashCode = new String();//hashWith256(String.valueOf(d));
		try {
			hashCode = hashWith256(String.valueOf(data));
			
			System.out.println("hashCode " + hashCode);
		}
		catch (NoSuchAlgorithmException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
		
		
		
		list.add(new Biometrics(hashCode, "fsgfsg", data));
//		Biometrics b = new Biometrics( hashStr.hashCode(), "NCJWN3RFJW234", null);
	}


	
	
	 
	 static private String hashWith256(String textToHash) throws NoSuchAlgorithmException {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
		    byte[] hashedByetArray = digest.digest(byteOfTextToHash);
		    String encoded = Base64.getEncoder().encodeToString(hashedByetArray);
		    return encoded;
		}
	 
	 
	



	public ArrayList<Biometrics> allInfo() {
		System.out.println(list);
		return list;
	}
	
		

}
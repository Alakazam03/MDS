package io.mosip.mds.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import javafx.scene.image.Image;


import lombok.Data;

@Data
public class DataBlock {
	
	//How are we getting the values
	//Opt1: from device every time
	//Opt2: stored one time based on some database
//	if yes then optimise the code accordiing to it
	private Integer deviceCode;
	private Integer deviceProviderId;
	private Integer deviceServiceId;
	private Integer deviceServiceVersion;
	private Integer bioSubType;
	private String mosipProcess;
	private String env; //Staging| Developer| Pre-Production | Production
	private String bioValue;
	private String bioExtract;
	private String timestamp;
	private float requestedScore;
	private float qualityScore;
	
	public DataBlock() {
		
	}
	
	public DataBlock(Integer deviceCode, Integer deviceProviderId, Integer deviceServiceId, Integer deviceServiceVersion,
			Integer bioSubType, String mosipProcess, String env, String fileName, String bioExtract, String timestamp,
			float requestedScore, float qualityScore) {
		super();
		this.deviceCode = deviceCode;
		this.deviceProviderId = deviceProviderId;
		this.deviceServiceId = deviceServiceId;
		this.deviceServiceVersion = deviceServiceVersion;
		this.bioSubType = bioSubType;
		this.mosipProcess = mosipProcess;
		this.env = env;
		this.bioExtract = bioExtract;
		this.timestamp = timestamp;
		this.requestedScore = requestedScore;
		this.qualityScore = qualityScore;
		File file = new File(fileName);
		this.bioValue = this.encodeFileToBase64Binary(file);
	}
	
	private String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
}
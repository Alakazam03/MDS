package io.mosip.mds.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import io.mosip.mds.Util;
import io.mosip.mds.entity.Device;
import io.mosip.mds.entity.DeviceInfo;
import io.mosip.mds.entity.Info;

@Repository
public class DeviceRepository {
	
	@Value("${mds.device.type}")
	private String deviceType;
	
	@Value("${mds.location:127.0.0.1}")
	private String location;
	
	@Value("${server.port}")
	private String port;
	
	private ArrayList<Device> devices = new ArrayList<Device>();
	
	private ArrayList<Info> deviceInfos = new ArrayList<Info>();
	private HashMap<String, Device> deviceIds = new HashMap<String, Device>();
	
	private static String deviceList = "src/main/resources/devices";
	private static String deviceInfoFile = "src/main/resources/deviceInfo";
	private static boolean INIT = false;
	public void init() {
		if(this.INIT) return;
		java.io.BufferedReader fileReader = null;
		try {
			fileReader = new java.io.BufferedReader(new java.io.FileReader(deviceList));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String input = null;
		String[] tokens = null;
		try {
			while (true) {
				input = fileReader.readLine();
				if (input == null || input.equals("")) break;
				tokens = input.trim().split(",");
				if (tokens[0].equals(this.deviceType)) {
					devices.add(
							new Device(
									tokens[0], 
									tokens[1], 
									tokens[2], 
									tokens[3], 
									tokens[4], 
									tokens[5], 
									tokens[6], 
									"http://" +  location + ":" + port + "/" + tokens[1]
									)
							);
					deviceIds.put(tokens[1], devices.get(devices.size() - 1));
				}
			}
			fileReader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		DeviceInfo deviceInfo = null;
		try {
			fileReader = new java.io.BufferedReader(new java.io.FileReader(this.deviceInfoFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while (true) {
				input = fileReader.readLine();
				if (input == null || input.equals("")) break;
				tokens = input.trim().split(",");
				if (deviceIds.containsKey(tokens[0])) {
					String[] deviceSubIds = tokens[1].substring(1, tokens[1].length() - 1).trim().split("%");
					deviceInfo = new DeviceInfo(
									tokens[0], 
									Arrays.asList(deviceSubIds), 
									tokens[2], 
									tokens[3], 
									tokens[4], 
									tokens[5], 
									tokens[6], 
									tokens[7],
									tokens[8],
									Util.getTimeStamp()
									);
					this.deviceInfos.add(new Info(deviceIds.get(tokens[0]), deviceInfo));
				}
			}
			fileReader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		this.INIT= true;
	}

	public List<Device> getAllDevicesByType(String devType) {
		init();
		if (devType.equals("Biometric Device")) {
			return this.devices;
		}
		ArrayList<Device> filteredList = new ArrayList<Device>();
		this.devices.stream().filter(i -> i.getType().equals(devType)).forEach(filteredList::add);
		return filteredList;
	}

	public List<Info> getAllDevicesInfo() {
		init();
		return this.deviceInfos;
	}
}

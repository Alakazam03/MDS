package io.mosip.mds.service;

//vaibhav aggarwal

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.mosip.mds.entity.Device;

@Service
public class DeviceService {
	
	@Value("${mds.device.type}")
	private String deviceType;
	
	private ArrayList<Device> list = new ArrayList<Device>();
	
	private static String deviceList = "src/main/resources/devices";
	
	public DeviceService() throws Exception {
		java.io.BufferedReader fileReader = new java.io.BufferedReader(new java.io.FileReader(deviceList));
		// read file until EOF
		String input = null;
		String[] tokens = null;
		while (true) {
			input = fileReader.readLine();
			if (input == null || input.equals("")) break;
			tokens = input.trim().split(",");
			list.add(new Device(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]));
		}
		fileReader.close();
	}
	
	public List<Device> allDevices(String deviceType) {
		if (deviceType.equals("Biometric Device")) {
			return list;
		}
		ArrayList<Device> filteredList = new ArrayList<Device>();
		list.stream().filter(i -> i.getType().equals(deviceType)).forEach(filteredList::add);
		return filteredList;
	}
}

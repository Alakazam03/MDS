package io.mosip.mds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.mosip.mds.entity.Device;

@Service
public class DeviceService {
	private ArrayList<Device> list = new ArrayList<Device>();
	
	public DeviceService() {
		list.add(new Device("Fingerprint", 1, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/1"));
		list.add(new Device("Face", 2, "Face", "Active", "L1", "1.0", 1, "http://127.0.0.1/2"));
		list.add(new Device("Fingerprint", 3, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/3"));
		list.add(new Device("Fingerprint", 4, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/4"));
		list.add(new Device("Fingerprint", 5, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/5"));
		list.add(new Device("Fingerprint", 6, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/6"));
	}
	
	public List<Device> allDevices() {
		System.out.println(list);
		return list;
	}
}

package io.mosip.mds.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import io.mosip.mds.entity.Device;
import io.mosip.mds.entity.DeviceInfo;
import io.mosip.mds.entity.Info;

@Service
public class InfoService {
	
	private ArrayList<Info> list = new ArrayList<Info>();
	
	
	InfoService(){
		Device d = new Device("Fingerprint", 1, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/1");
		DeviceInfo dI = new DeviceInfo(1, 1, 2, "texas", 23, 32, new Date(2323223232L) , "L1", "format");
		list.add(new Info(d, dI));
//		list.add(new Device("Face", 2, "Face", "Active", "L1", "1.0", 1, "http://127.0.0.1/2"));
//		list.add(new Device("Fingerprint", 3, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/3"));
//		list.add(new Device("Fingerprint", 4, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/4"));
//		list.add(new Device("Fingerprint", 5, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/5"));
//		list.add(new Device("Fingerprint", 6, "Fingerprint", "Active", "L0", "1.0", 1, "http://127.0.0.1/6"));
	}
	
	public List<Info> allInfo(){
		System.out.println(list);
		return list;
	}
}

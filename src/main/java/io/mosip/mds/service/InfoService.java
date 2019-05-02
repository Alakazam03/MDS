package io.mosip.mds.service;

import java.util.ArrayList;
import java.util.Arrays;
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
		Device d = new Device("Fingerprint", "" + 1, "Fingerprint", "Active", "L0", "1.0", "" + 1, "http://127.0.0.1/1");
		DeviceInfo dI = new DeviceInfo(1, Arrays.asList(2,3), 2, "texas", 23, 32, new Date(2323223232L) , "L1", "format");
		list.add(new Info(d, dI));
	}
	
	public List<Info> allInfo(){
		System.out.println(list);
		return list;
	}
}

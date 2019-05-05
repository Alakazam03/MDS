package io.mosip.mds.service;

//vaibhav aggarwal

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.mosip.mds.dto.Biometrics;
import io.mosip.mds.dto.DataBlock;
import io.mosip.mds.dto.RequestObject;
import io.mosip.mds.entity.BiometricDevice;
import io.mosip.mds.entity.Device;
import io.mosip.mds.entity.FaceDevice;
import io.mosip.mds.entity.Info;
import io.mosip.mds.repository.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public List<Device> getAllDevicesByType(String deviceType) {
		return deviceRepository.getAllDevicesByType(deviceType);
	}

	public List<Info> allInfo() {
		return deviceRepository.getAllDevicesInfo();
	}

	public List<Biometrics> capture(RequestObject obj) {
		String fileName = "src/main/resources/fingerprints/thumbs.jpg";
		DataBlock d = new DataBlock(12, 45, 34, 56, 43, obj.getMosipProcess(), obj.getEnv(), fileName,"UNKNOWN",  obj.getCaptureTime(), 100, 98 );
		BiometricService bobj = new BiometricService(d);
		List<Biometrics> list = bobj.allInfo();
		return list;
	}
}

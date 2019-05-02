package io.mosip.mds.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.mds.dto.RequestObject;
import io.mosip.mds.entity.Biometrics;
import io.mosip.mds.entity.Data;
import io.mosip.mds.entity.Device;
import io.mosip.mds.entity.Info;
import io.mosip.mds.service.BiometricService;
import io.mosip.mds.service.DeviceService;
import io.mosip.mds.service.InfoService;


@RestController
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private InfoService infoService;
	
	@Autowired
	private BiometricService bobj;
	
	@Value("${mds.location:127.0.0.1}")
	private String location;
	
	@Value("${server.port}")
	private String port;
	
	
	@GetMapping("/device")
	public ResponseEntity<List<Device>> allDevices(@RequestBody Device deviceType) {
		List<Device> list = deviceService.allDevices(deviceType.getType());
		HttpHeaders responseHeaders = this.getResponseHeaders();
		return new ResponseEntity<List<Device>>(list, responseHeaders, HttpStatus.OK);
	}
	

	
	@GetMapping("/info")
	public ResponseEntity<List<Info>> allInfo() {
		List<Info> list = infoService.allInfo();
		HttpHeaders responseHeaders = this.getResponseHeaders();
		return new ResponseEntity<List<Info>>(list, responseHeaders, HttpStatus.OK);
	}


	@PostMapping(path = "/capture")
	public ResponseEntity<List<Biometrics>> DeviceCapture(@RequestBody RequestObject obj){
		// Locking 
		Data d = new Data(1, 45, 34, 56, 43, obj.getMosipProcess(), obj.getEnv(), "hjgh","UNKNOWN",  obj.getCaptureTime(), 100, 98 );
		BiometricService bobj = new BiometricService(d);
		List<Biometrics> list = bobj.allInfo();
		//return "information retrieved " + obj.getEnv() + " list object "+ obj.getBio().get(0).getType();
		HttpHeaders responseHeaders = this.getResponseHeaders();
		return new ResponseEntity<List<Biometrics>>(list, responseHeaders, HttpStatus.OK);
		
	}
	
	private HttpHeaders getResponseHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(URI.create("http://" +  location + ":" + port + "/device"));
		responseHeaders.setCacheControl(CacheControl.noCache());
//		responseHeaders.setContentLength(100000);
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		responseHeaders.setConnection("Closed");
		return responseHeaders;
	}
}


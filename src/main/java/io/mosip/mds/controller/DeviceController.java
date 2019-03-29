package io.mosip.mds.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.mds.entity.Device;
import io.mosip.mds.entity.Info;
import io.mosip.mds.entity.RequestObject;
import io.mosip.mds.service.DeviceService;
import io.mosip.mds.service.InfoService;


@RestController
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private InfoService infoService;
	
	private String location = "http://127.0.0.1";
	private String port = "8081";
	
	@GetMapping("/device")
	public ResponseEntity<List<Device>> allDevices() {
		List<Device> list = deviceService.allDevices();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(URI.create(location + ":" + port + "/device"));
		responseHeaders.setCacheControl(CacheControl.noCache());
//		responseHeaders.setContentLength(100000);
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		responseHeaders.setConnection("Closed");
		return new ResponseEntity<List<Device>>(list, responseHeaders, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/info")
	public ResponseEntity<List<Info>> allInfo() {
		List<Info> list = infoService.allInfo();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(URI.create(location + ":" + port + "/device"));
		responseHeaders.setCacheControl(CacheControl.noCache());
//		responseHeaders.setContentLength(100000);
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		responseHeaders.setConnection("Closed");
		return new ResponseEntity<List<Info>>(list, responseHeaders, HttpStatus.OK);
	}


	@PostMapping(path = "/capture")
	public String DeviceCapture(@RequestBody RequestObject obj){
//		HttpHeaders responseHeaders  = new HttpHeaders
		System.out.println("vaibhav aggarwal"+ obj.toString());
		return "information retrieved " + obj.getEnv() + " list object "+ obj.getBio().get(0).getType();
		
	}
}


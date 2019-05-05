package io.mosip.mds.controller;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.List;

//import org.apache.tomcat.jni.Lock;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.mosip.mds.dto.Biometrics;
import io.mosip.mds.dto.RequestObject;
import io.mosip.mds.entity.Device;
import io.mosip.mds.entity.Info;
import io.mosip.mds.service.DeviceService;

@RestController
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	@Value("${mds.location:127.0.0.1}")
	private String location;
	
	@Value("${server.port}")
	private String port;
	
	ReentrantLock lock = new ReentrantLock();
	
	
	@GetMapping("/device")
	public ResponseEntity<String> allDevices(@RequestBody Device deviceType) {
		List<Device> list = deviceService.getAllDevicesByType(deviceType.getType());
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = this.getResponseHeaders(response.length(), "device");
		return new ResponseEntity<String>(response, responseHeaders, HttpStatus.OK);
	}
	

	
	@GetMapping("/info")
	public ResponseEntity<List<Info>> allInfo() {
		List<Info> list = deviceService.allInfo();
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = this.getResponseHeaders(response.length(), "info");
		return new ResponseEntity<List<Info>>(list, responseHeaders, HttpStatus.OK);
	}


	@PostMapping(path = "/capture")
	public ResponseEntity<String> DeviceCapture(@RequestBody RequestObject obj) throws InterruptedException{
		if(!lock.isLocked()) {
				lock.lock();
				//TimeUnit.SECONDS.sleep(3);
				List<Biometrics> list = deviceService.capture(obj);
				String response = null;
				ObjectMapper mapper = new ObjectMapper();
				try {
					response = mapper.writeValueAsString(list);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				HttpHeaders responseHeaders = this.getResponseHeaders(response.length(), "capture");
				lock.unlock();
				return new ResponseEntity<String>(response, responseHeaders, HttpStatus.OK);
		}
		else{
			
			 return new ResponseEntity<String>("Busy", this.getResponseHeaders(4, "capture"), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	private HttpHeaders getResponseHeaders(long contentLength, String service) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(URI.create("http://" +  location + ":" + port + "/" + service));
		responseHeaders.setCacheControl(CacheControl.noCache());
		responseHeaders.setContentLength(contentLength);
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		responseHeaders.setConnection("Closed");
		return responseHeaders;
	}
}


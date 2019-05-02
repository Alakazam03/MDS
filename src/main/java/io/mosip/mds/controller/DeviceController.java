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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.mosip.mds.dto.RequestObject;
import io.mosip.mds.entity.Biometrics;
import io.mosip.mds.entity.DataBlock;
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
	
	@Value("${mds.location:127.0.0.1}")
	private String location;
	
	@Value("${server.port}")
	private String port;
	
	
	@GetMapping("/device")
	public ResponseEntity<String> allDevices(@RequestBody Device deviceType) {
		List<Device> list = deviceService.allDevices(deviceType.getType());
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = this.getResponseHeaders(response.length());
		return new ResponseEntity<String>(response, responseHeaders, HttpStatus.OK);
	}
	

	
	@GetMapping("/info")
	public ResponseEntity<List<Info>> allInfo() {
		List<Info> list = infoService.allInfo();
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = this.getResponseHeaders(response.length());
		return new ResponseEntity<List<Info>>(list, responseHeaders, HttpStatus.OK);
	}


	@PostMapping(path = "/capture")
	public ResponseEntity<String> DeviceCapture(@RequestBody RequestObject obj){
		// Locking 
		String fileName = "src/main/resources/fingerprints/thumbs.jpg";
		DataBlock d = new DataBlock(12, 45, 34, 56, 43, obj.getMosipProcess(), obj.getEnv(), fileName,"UNKNOWN",  obj.getCaptureTime(), 100, 98 );
		BiometricService bobj = new BiometricService(d);
		List<Biometrics> list = bobj.allInfo();
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = this.getResponseHeaders(response.length());
		return new ResponseEntity<String>(response, responseHeaders, HttpStatus.OK);
		
	}
	
	private HttpHeaders getResponseHeaders(long contentLength) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(URI.create("http://" +  location + ":" + port + "/device"));
		responseHeaders.setCacheControl(CacheControl.noCache());
		responseHeaders.setContentLength(contentLength);
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		responseHeaders.setConnection("Closed");
		return responseHeaders;
	}
}


package io.mosip.mds;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	private static String port;
	
	@Value("${server.port}")
	public void setPort(String port) {
	    DemoApplication.port = port;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		System.out.println("\nStarted MDS at: " + port);
	}

}

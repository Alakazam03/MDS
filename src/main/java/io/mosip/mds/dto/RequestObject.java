package io.mosip.mds.dto;

//import java.util.Date;
import java.util.List;

import io.mosip.mds.entity.Bio;
import lombok.Data;

@Data
public class RequestObject {
	private String env; // Staging| Developer| Pre-Production | Production
	private String mosipProcess;
	private Integer version;
	private Integer timeout;
	private String captureTime;
	private Integer transactionId;
	private List<Bio> bio;
//	private String CustomOpts;
	
	
	public RequestObject(String env, String mosipProcess, Integer version, Integer timeout, String captureTime,
			Integer transactionId, List<Bio> bio, String customOpts) {
		super();
		this.env = env;
		this.mosipProcess = mosipProcess;
		this.version = version;
		this.timeout = timeout;
		this.captureTime = captureTime;
		this.transactionId = transactionId;
		this.bio = bio;
//		eCustomOpts = customOpts;
	}


}

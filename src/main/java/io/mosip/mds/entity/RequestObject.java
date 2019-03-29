package io.mosip.mds.entity;

import java.util.Date;
import java.util.List;

public class RequestObject {
	
	@Override
	public String toString() {
		return "RequestObject [env=" + env + ", mosipProcess=" + mosipProcess + ", version=" + version + ", timeout="
				+ timeout + ", captureTime=" + captureTime + ", transactionId=" + transactionId + ", bio=" + bio + "]";
	}


	private String env;
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


	public String getEnv() {
		return env;
	}


	public void setEnv(String env) {
		this.env = env;
	}


	public String getMosipProcess() {
		return mosipProcess;
	}


	public void setMosipProcess(String mosipProcess) {
		this.mosipProcess = mosipProcess;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public Integer getTimeout() {
		return timeout;
	}


	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}


	public String getCaptureTime() {
		return captureTime;
	}


	public void setCaptureTime(String captureTime) {
		this.captureTime = captureTime;
	}


	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	public List<Bio> getBio() {
		return bio;
	}


	public void setBio(List<Bio> bio) {
		this.bio = bio;
	}


//	public String getCustomOpts() {
//		return CustomOpts;
//	}
//
//
//	public void setCustomOpts(String customOpts) {
//		CustomOpts = customOpts;
//	}
	
	
	
	
	
	
	
	

}

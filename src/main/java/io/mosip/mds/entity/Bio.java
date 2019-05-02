package io.mosip.mds.entity;
import lombok.Data;
@Data
public class Bio {
	
	private Integer type; // “FMR”,  “FIR” , “IIR”, “Face”
	private Integer count;
	private Integer format;
	private Integer requestedScore;
	private Integer deviceId;
	private Integer deviceSubId;
//	private CustomOPts customOpts;
	
	
	
	public Bio(Integer type, Integer count, Integer format, Integer requestedScore, Integer deviceId,
			Integer deviceSubId) {
		super();
		this.type = type;
		this.count = count;
		this.format = format;
		this.requestedScore = requestedScore;
		this.deviceId = deviceId;
		this.deviceSubId = deviceSubId;
//		this.customOpts = customOpts;
	}
	

}

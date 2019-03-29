import java.util.*;


public interface Device {
	
	String type;
	Integer deviceId;
	String subType;
	String deviceStatus;// Active Inactive
	String certification; // L0 L1
	String serviceVersion; // version of document
	Integer deviceSubId; // starting from 1 url
	String callbackId; // http url

}

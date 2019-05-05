package io.mosip.mds;

import java.sql.Timestamp;

public class Util {
	public static String getTimeStamp() {
		return new Timestamp(System.currentTimeMillis()).toString();
	}
}

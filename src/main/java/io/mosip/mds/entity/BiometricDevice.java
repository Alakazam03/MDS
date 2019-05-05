package io.mosip.mds.entity;

import java.util.List;

import io.mosip.mds.dto.Biometrics;
import io.mosip.mds.dto.RequestObject;

public interface BiometricDevice {
	public  List<Biometrics> capture(RequestObject reqObject);
}

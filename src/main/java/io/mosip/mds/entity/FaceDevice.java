package io.mosip.mds.entity;

import java.util.List;

import io.mosip.mds.dto.Biometrics;
import io.mosip.mds.dto.RequestObject;

public class FaceDevice extends Device implements BiometricDevice{

	@Override
	public List<Biometrics> capture(RequestObject reqObject) {
		// TODO Auto-generated method stub
		return null;
	}

}

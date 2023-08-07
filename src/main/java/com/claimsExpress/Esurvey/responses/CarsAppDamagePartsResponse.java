package com.claimsExpress.Esurvey.responses;

import java.util.ArrayList;
import java.util.List;

public class CarsAppDamagePartsResponse {
List<CarsAppDamagePartResponse> appDamagePartResponses = new ArrayList<>();

public List<CarsAppDamagePartResponse> getAppDamagePartResponses() {
	return appDamagePartResponses;
}

public void setAppDamagePartResponses(List<CarsAppDamagePartResponse> appDamagePartResponses) {
	this.appDamagePartResponses = appDamagePartResponses;
}

}

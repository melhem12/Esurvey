package com.claimsExpress.Esurvey.requests;

import java.util.ArrayList;
import java.util.List;


public class CarsAppDamagePartsRequest {
	String accidentId;
	
	public String getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	List<CarsAppDamagePartRequest> carsAppDamagePartsRequest = new ArrayList<>();

	public List<CarsAppDamagePartRequest> getCarsAppDamagePartsRequest() {
		return carsAppDamagePartsRequest;
	}

	public void setCarsAppDamagePartsRequest(List<CarsAppDamagePartRequest> carsAppDamagePartsRequest) {
		this.carsAppDamagePartsRequest = carsAppDamagePartsRequest;
	}
	

}

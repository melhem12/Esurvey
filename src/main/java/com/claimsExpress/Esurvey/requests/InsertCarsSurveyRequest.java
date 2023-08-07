package com.claimsExpress.Esurvey.requests;

public class InsertCarsSurveyRequest {
	
	private String carId ;
	private String userId ;
	
	public InsertCarsSurveyRequest() {
		super();
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}

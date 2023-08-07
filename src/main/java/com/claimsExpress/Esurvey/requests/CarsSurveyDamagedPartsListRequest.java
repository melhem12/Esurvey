package com.claimsExpress.Esurvey.requests;

import java.util.List;


public class CarsSurveyDamagedPartsListRequest {
	
	private String carId;

	private List<CarsSurveyDamagedPartsListRequest> carsSurveyDamagedPartsBean;



	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public List<CarsSurveyDamagedPartsListRequest> getCarsSurveyDamagedPartsBean() {
		return carsSurveyDamagedPartsBean;
	}

	public void setCarsSurveyDamagedPartsBean(List<CarsSurveyDamagedPartsListRequest> carsSurveyDamagedPartsBean) {
		this.carsSurveyDamagedPartsBean = carsSurveyDamagedPartsBean;
	}


	
}

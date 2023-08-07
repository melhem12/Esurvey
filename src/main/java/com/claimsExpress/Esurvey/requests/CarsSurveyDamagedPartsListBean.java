package com.claimsExpress.Esurvey.requests;

import java.util.List;


public class CarsSurveyDamagedPartsListBean {
	
	private String carId;

	private List<CarsSurveyDamagedPartsBean> carsSurveyDamagedPartsBean;



	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public List<CarsSurveyDamagedPartsBean> getCarsSurveyDamagedPartsBean() {
		return carsSurveyDamagedPartsBean;
	}

	public void setCarsSurveyDamagedPartsBean(List<CarsSurveyDamagedPartsBean> carsSurveyDamagedPartsBean) {
		this.carsSurveyDamagedPartsBean = carsSurveyDamagedPartsBean;
	}



	
}

package com.claimsExpress.Esurvey.responses;

import java.io.Serializable;

public class CarTrademarkResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String carTrademarkId;

	private String carTrademarkDescription;

	public String getCarTrademarkId() {
		return carTrademarkId;
	}

	public void setCarTrademarkId(String carTrademarkId) {
		this.carTrademarkId = carTrademarkId;
	}

	public String getCarTrademarkDescription() {
		return carTrademarkDescription;
	}

	public void setCarTrademarkDescription(String carTrademarkDescription) {
		this.carTrademarkDescription = carTrademarkDescription;
	}

}

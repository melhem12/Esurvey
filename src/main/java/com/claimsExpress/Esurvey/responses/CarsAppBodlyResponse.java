package com.claimsExpress.Esurvey.responses;

import com.claimsExpress.Esurvey.models.CarsAppAccident;

public class CarsAppBodlyResponse {
	  private String  bodlyId ;
		private CarsAppAccident carsAppAccidentId ;
 
 
	private int  bodlyInsCountLightInj ;
	
	
	private int  bodlyInsCountSeverInj ;
	
	private int  bodlyInsCountDeath ;
	
	
	
	
	private int  bodlyTPCountLightInj ;
	
	
	

	private int  bodlyTPCountSeverInj ;
	
	
	private int  bodlyTPCountDeath ;


	public String getBodlyId() {
		return bodlyId;
	}


	public void setBodlyId(String bodlyId) {
		this.bodlyId = bodlyId;
	}


	public CarsAppAccident getCarsAppAccidentId() {
		return carsAppAccidentId;
	}


	public void setCarsAppAccidentId(CarsAppAccident carsAppAccidentId) {
		this.carsAppAccidentId = carsAppAccidentId;
	}


	public int getBodlyInsCountLightInj() {
		return bodlyInsCountLightInj;
	}


	public void setBodlyInsCountLightInj(int bodlyInsCountLightInj) {
		this.bodlyInsCountLightInj = bodlyInsCountLightInj;
	}


	public int getBodlyInsCountSeverInj() {
		return bodlyInsCountSeverInj;
	}


	public void setBodlyInsCountSeverInj(int bodlyInsCountSeverInj) {
		this.bodlyInsCountSeverInj = bodlyInsCountSeverInj;
	}


	public int getBodlyInsCountDeath() {
		return bodlyInsCountDeath;
	}


	public void setBodlyInsCountDeath(int bodlyInsCountDeath) {
		this.bodlyInsCountDeath = bodlyInsCountDeath;
	}


	public int getBodlyTPCountLightInj() {
		return bodlyTPCountLightInj;
	}


	public void setBodlyTPCountLightInj(int bodlyTPCountLightInj) {
		this.bodlyTPCountLightInj = bodlyTPCountLightInj;
	}


	public int getBodlyTPCountSeverInj() {
		return bodlyTPCountSeverInj;
	}


	public void setBodlyTPCountSeverInj(int bodlyTPCountSeverInj) {
		this.bodlyTPCountSeverInj = bodlyTPCountSeverInj;
	}


	public int getBodlyTPCountDeath() {
		return bodlyTPCountDeath;
	}


	public void setBodlyTPCountDeath(int bodlyTPCountDeath) {
		this.bodlyTPCountDeath = bodlyTPCountDeath;
	}
	
}

package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "CARS_APP_ACC_CONDITIONS")
@EntityListeners(AuditingEntityListener.class)
public class CarsAppAccidentConditions {
	
	
	@Id
	@Column(name="APP_ACC_CONDITIONS_ID ")
	private String  accidentConditionsId ;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="APP_ACC_CONDITIONS_ACCIDENT_ID",nullable=false)
	private CarsAppAccident carsAppAccident ;
	
	   @Column(name="APP_ACC_CONDITIONS_TP_DAMAGE ")
		private String  accidentConditionsTPFDamage;
	  
	   @Column(name="APP_ACC_CONDITIONS_RESPONSIB")
		private String  accidentConditionsResponsib;
	  
	   
	   @Column(name="APP_ACC_CONDITIONS_DOUBTS")
			private String  accidentConditionsDoubts;
	   
	   @Column(name="APP_ACC_CONDITIONS_TP_COUNTS")
		private int  accidentConditiosTPCount;

	public String getAccidentConditionsId() {
		return accidentConditionsId;
	}

	public void setAccidentConditionsId(String accidentConditionsId) {
		this.accidentConditionsId = accidentConditionsId;
	}

	public CarsAppAccident getCarsAppAccident() {
		return carsAppAccident;
	}

	public void setCarsAppAccident(CarsAppAccident carsAppAccident) {
		this.carsAppAccident = carsAppAccident;
	}

	public String getAccidentConditionsTPFDamage() {
		return accidentConditionsTPFDamage;
	}

	public void setAccidentConditionsTPFDamage(String accidentConditionsTPFDamage) {
		this.accidentConditionsTPFDamage = accidentConditionsTPFDamage;
	}

	public String getAccidentConditionsResponsib() {
		return accidentConditionsResponsib;
	}

	public void setAccidentConditionsResponsib(String accidentConditionsResponsib) {
		this.accidentConditionsResponsib = accidentConditionsResponsib;
	}

	public String getAccidentConditionsDoubts() {
		return accidentConditionsDoubts;
	}

	public void setAccidentConditionsDoubts(String accidentConditionsDoubts) {
		this.accidentConditionsDoubts = accidentConditionsDoubts;
	}

	public int getAccidentConditiosTPCount() {
		return accidentConditiosTPCount;
	}

	public void setAccidentConditiosTPCount(int accidentConditiosTPCount) {
		this.accidentConditiosTPCount = accidentConditiosTPCount;
	}

	public CarsAppAccidentConditions() {
	}
	   
	   
	   
	   
	   
	   
}

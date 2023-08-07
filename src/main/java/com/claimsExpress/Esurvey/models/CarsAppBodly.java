package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "CARS_APP_BODILY")
@EntityListeners(AuditingEntityListener.class)
public class CarsAppBodly {
	@Id
	@Column(name="APP_BODILY_ID ")
	private String  bodlyId ;
	
	   @OneToOne(fetch=FetchType.LAZY)
			@JoinColumn(name="APP_BODILY_ACCIDENT_ID",nullable=false)
			private CarsAppAccident carsAppAccident ;
	   
	   
		@Column(name="APP_BODILY_INS_COUNT_LIGHT_INJ ")
		private int  bodlyInsCountLightInj ;
		
		
		
		public CarsAppBodly() {
		
		}

		@Column(name="APP_BODILY_INS_COUNT_SEVER_INJ ")
		private int  bodlyInsCountSeverInj ;
		
		@Column(name="APP_BODILY_INS_COUNT_DEATH ")
		private int  bodlyInsCountDeath ;
		
		
		
		
		@Column(name="APP_BODILY_TP_COUNT_LIGHT_INJ ")
		private int  bodlyTPCountLightInj ;
		
		
		
		@Column(name="APP_BODILY_TP_COUNT_SEVER_INJ ")
		private int  bodlyTPCountSeverInj ;
		
		@Column(name="APP_BODILY_TP_COUNT_DEATH ")
		private int  bodlyTPCountDeath ;

		public String getBodlyId() {
			return bodlyId;
		}

		public void setBodlyId(String bodlyId) {
			this.bodlyId = bodlyId;
		}

		public CarsAppAccident getCarsAppAccident() {
			return carsAppAccident;
		}

		public void setCarsAppAccident(CarsAppAccident carsAppAccident) {
			this.carsAppAccident = carsAppAccident;
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

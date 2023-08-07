package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "CARS_APP_DAMAGED_PARTS")
@EntityListeners(AuditingEntityListener.class)
public class CarsAppDamageParts {

	
	  
	  @Id
		@Column(name="APP_DAMAGED_PARTS_ID ")
		private String  damagedPartsId ;
	    @OneToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="APP_DAMAGED_PARTS_ACCIDENT_ID",nullable=false)
		private CarsAppAccident carsAppAccident ;
		@Column(name="APP_DAMAGED_PARTS_PART_ID ")
		private String  damagesPartsPartId ;
	    @Lob
		@Column(name="APP_DAMAGED_PARTS_PICTURE")
	    private byte[] appDamagedPartsPicture;
	    
	    
	    
	    
		public CarsAppDamageParts() {
		
		}
		public String getDamagedPartsId() {
			return damagedPartsId;
		}
		public void setDamagedPartsId(String damagedPartsId) {
			this.damagedPartsId = damagedPartsId;
		}
		public CarsAppAccident getCarsAppAccident() {
			return carsAppAccident;
		}
		public void setCarsAppAccident(CarsAppAccident carsAppAccident) {
			this.carsAppAccident = carsAppAccident;
		}
		public String getDamagesPartsPartId() {
			return damagesPartsPartId;
		}
		public void setDamagesPartsPartId(String damagesPartsPartId) {
			this.damagesPartsPartId = damagesPartsPartId;
		}
		public byte[] getAppDamagedPartsPicture() {
			return appDamagedPartsPicture;
		}
		public void setAppDamagedPartsPicture(byte[] appDamagedPartsPicture) {
			this.appDamagedPartsPicture = appDamagedPartsPicture;
		}
	
		
}

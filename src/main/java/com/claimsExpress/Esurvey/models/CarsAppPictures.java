package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "CARS_APP_PICTURES")
@EntityListeners(AuditingEntityListener.class)
public class CarsAppPictures {
	@Id
	@Column(name="APP_PICTURES_ID ")
	private String appPicturesId ;
	
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="APP_PICTURES_ACCIDENT_ID",nullable=false)
private CarsAppAccident carsAppAccident ;
	  
	    @Lob
		@Column(name="APP_PICTURES_GENERAL")
	    private byte[] appPicturesGeneral;


	    @Lob
		@Column(name="APP_PICTURES_CAR_DAMAGE")
	    private byte[] appPicturesCarDamage;	  
	    @Lob
		@Column(name="APP_PICTURES_TP_POLICY ")
	    private byte[] appPicturesTPPolicy;
	  
	    
	    @Lob
		@Column(name="APP_PICTURES_DL_VR1 ")
	    private byte[] appPicturesDLvr1;
	    
	    
	    
	    @Lob
		@Column(name="APP_PICTURES_DL_VR2 ")
	    private byte[] appPicturesDLvr2;
	    
	    @Lob
	 	@Column(name="APP_PICTURES_OPTIONAL1")
	 	private byte[] appPicturesOptional1;
	  
	  
	    @Lob
	 	@Column(name="APP_PICTURES_OPTIONAL2")
	 	private byte[] appPicturesOptional2;
	    
	    
	    @Lob
	 	@Column(name="APP_PICTURES_OPTIONAL3 ")
	 	private byte[] appPicturesOptional3;


		public String getAppPicturesId() {
			return appPicturesId;
		}


		public void setAppPicturesId(String appPicturesId) {
			this.appPicturesId = appPicturesId;
		}


		public CarsAppAccident getCarsAppAccident() {
			return carsAppAccident;
		}


		public void setCarsAppAccident(CarsAppAccident carsAppAccident) {
			this.carsAppAccident = carsAppAccident;
		}


		public byte[] getAppPicturesGeneral() {
			return appPicturesGeneral;
		}


		public void setAppPicturesGeneral(byte[] appPicturesGeneral) {
			this.appPicturesGeneral = appPicturesGeneral;
		}


		public byte[] getAppPicturesCarDamage() {
			return appPicturesCarDamage;
		}


		public void setAppPicturesCarDamage(byte[] appPicturesCarDamage) {
			this.appPicturesCarDamage = appPicturesCarDamage;
		}


		public byte[] getAppPicturesTPPolicy() {
			return appPicturesTPPolicy;
		}


		public void setAppPicturesTPPolicy(byte[] appPicturesTPPolicy) {
			this.appPicturesTPPolicy = appPicturesTPPolicy;
		}


		public byte[] getAppPicturesDLvr1() {
			return appPicturesDLvr1;
		}


		public void setAppPicturesDLvr1(byte[] appPicturesDLvr1) {
			this.appPicturesDLvr1 = appPicturesDLvr1;
		}


		public byte[] getAppPicturesDLvr2() {
			return appPicturesDLvr2;
		}


		public void setAppPicturesDLvr2(byte[] appPicturesDLvr2) {
			this.appPicturesDLvr2 = appPicturesDLvr2;
		}


		public byte[] getAppPicturesOptional1() {
			return appPicturesOptional1;
		}


		public void setAppPicturesOptional1(byte[] appPicturesOptional1) {
			this.appPicturesOptional1 = appPicturesOptional1;
		}


		public byte[] getAppPicturesOptional2() {
			return appPicturesOptional2;
		}


		public void setAppPicturesOptional2(byte[] appPicturesOptional2) {
			this.appPicturesOptional2 = appPicturesOptional2;
		}


		public byte[] getAppPicturesOptional3() {
			return appPicturesOptional3;
		}


		public void setAppPicturesOptional3(byte[] appPicturesOptional3) {
			this.appPicturesOptional3 = appPicturesOptional3;
		}


		

	


	  
	
}

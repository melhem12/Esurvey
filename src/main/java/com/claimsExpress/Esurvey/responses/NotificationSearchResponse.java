package com.claimsExpress.Esurvey.responses;

public class NotificationSearchResponse {
	
	
	
	
	private String carId;
	
	private String notification;
	
	private String notificationId;
	
	private String plate;
	
	private String insTp;
	
	private Integer VEHSEQ;
	
	private String insCompany;
	
	private String insCompanyCode;
	
	private String claimStatus;
	
	private String ownerName;

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getInsTp() {
		return insTp;
	}

	public void setInsTp(String insTp) {
		this.insTp = insTp;
	}

	public Integer getVEHSEQ() {
		return VEHSEQ;
	}

	public void setVEHSEQ(Integer vEHSEQ) {
		VEHSEQ = vEHSEQ;
	}

	public String getInsCompany() {
		return insCompany;
	}

	public void setInsCompany(String insCompany) {
		this.insCompany = insCompany;
	}

	public String getInsCompanyCode() {
		return insCompanyCode;
	}

	public void setInsCompanyCode(String insCompanyCode) {
		this.insCompanyCode = insCompanyCode;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

}

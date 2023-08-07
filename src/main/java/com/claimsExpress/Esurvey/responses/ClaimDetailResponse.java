package com.claimsExpress.Esurvey.responses;

import org.springframework.beans.factory.annotation.Value;

public interface ClaimDetailResponse{
	
	

	@Value("#{target.notificationid}")
	String getNotificationId();
	
	@Value("#{target.carid}")
	String getCarId();
	
	@Value("#{target.pasNumber}")
	String getPasNumber();
	
	@Value("#{target.VehicleOwnerName}")
	String getVehicleOwnerName();
	
	@Value("#{target.phoneNumber}")
	String getPhoneNumber();
	
	@Value("#{target.licenseNumber}")
	String getLicenseNumber();
	
	@Value("#{target.BRANDTRADEMARK}")
	String getBrandTrademark();
	
	@Value("#{target.modelYear}")
	String getModelYear();
	
	@Value("#{target.plateNumber}")
	String getPlateNumber();
	
	@Value("#{target.policyNumber}")
	String getPolicyNumber();
	
	@Value("#{target.vehicleNumber}")
	String getvehicleNumber();
	
	@Value("#{target.reportedDate}")
	String getReportedDate();
	
	@Value("#{target.lossDate}")
	String getLossDate();
	
	@Value("#{target.accidentLocation}")
	String getAccidentLocation();
	
	@Value("#{target.SURVEY_DAMAGED_LOCKED_USER}")
	String getSurveyDamagedLockedUser();
	
	
	
}

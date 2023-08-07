package com.claimsExpress.Esurvey.responses;

import org.springframework.beans.factory.annotation.Value;

public interface ClaimCarDetailResponse {

	@Value("#{target.notificationid}")
	String getNotificationId();

	@Value("#{target.carid}")
	String getCarId();

	@Value("#{target.pasNumber}")
	String getPasNumber();

	@Value("#{target.VehicleOwnerName}")
	String getVehicleOwnerName();

	@Value("#{target.CAR_OWNER_FIRST_NAME}")
	String getCarOwnerFirstName();

	@Value("#{target.CAR_OWNER_FATHER_NAME}")
	String getCarOwnerFatherName();

	@Value("#{target.CAR_OWNER_MAINDEN}")
	String getCarOwnerMaidenName();

	@Value("#{target.CAR_OWNER_FAMILY_NAME}")
	String getCarOwnerFamilyName();

	@Value("#{target.phoneNumber}")
	String getPhoneNumber();

	@Value("#{target.licenseNumber}")
	String getLicenseNumber();

	@Value("#{target.licenseDate}")
	String getLicenseDate();

	@Value("#{target.licenseExpiryDate}")
	String getLicenseExpiryDate();

	@Value("#{target.BRAND_ID}")
	String getBrandId();

	@Value("#{target.CAR_TRADEMARK_ID}")
	String getCarTrademarkId();

	@Value("#{target.ShapeId}")
	String getShapeID();

	@Value("#{target.BRANDTRADEMARK}")
	String getBrandTradeMark();

	@Value("#{target.modelYear}")
	String getModelYear();

	@Value("#{target.chassisNumber}")
	String getChasisNumber();

	@Value("#{target.plateNumber}")
	String getPlateNumber();

	@Value("#{target.policyNumber}")
	String getPolicyNumber();

	@Value("#{target.insurerCode}")
	String getInsurerCode();

	@Value("#{target.vehicleNumber}")
	String getVehicleNumber();

	@Value("#{target.claimStatus}")
	String getClaimStatus();

	@Value("#{target.reportedDate}")
	String getReportedDate();

	@Value("#{target.lossDate}")
	String getLossDate();

	@Value("#{target.accidentLocation}")
	String getAccidentLocation();

	@Value("#{target.CLAIM_NUMBER}")
	String getClaimNumber();

	@Value("#{target.SURVEY_DAMAGED_VEHICLE_SIZE}")
	String getVehicleSize();

	@Value("#{target.SURVEY_DAMAGED_BODY_TYPE}")
	String getBodyType();

	@Value("#{target.SURVEY_DAMAGED_DOORS}")
	String getDoors();
	@Value("#{target.CAR_THRDP_INS_CMPNY_ID}")
	String getInsuranceCompanyId();
	@Value("#{target.CAR_POLICY_TYPE}")
	String getPolicyType() ;

}

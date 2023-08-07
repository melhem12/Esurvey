package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "CARS_LOSS_CAR")
@EntityListeners(AuditingEntityListener.class)
public class CarLossCar implements Cloneable {

	private static Log logger = LogFactory.getLog(CarLossCar.class);

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CAR_ID")
	private String carId;

	@Column(name = "CAR_CLAIM_ID")
	private String carClaimId;

	@Column(name = "CAR_SHAPE_ID")
	private String carShapeId;

//	@Column(name = "CAR_SHAPE_ID")
//	private java.lang.String chasisNumber;



	@Column(name = "CAR_SEQUENCE")
	private Integer carSequence;

	@Column(name = "SYS_CREATED_BY")
	private String sysCreatedBy;

	@Column(name = "SYS_CREATED_DATE")
	private java.sql.Timestamp sysCreatedDate;

	@Column(name = "SYS_UPDATED_BY")
	private String sysUpdatedBy;

	@Column(name = "SYS_UPDATED_DATE")
	private java.sql.Timestamp sysUpdatedDate;

	@Column(name = "CAR_OWNER_FAMILY_NAME")
	private String carOwnerFamilyName;

	@Column(name = "CAR_OWNER_FIRST_NAME")
	private String carOwnerFirstName;

	@Column(name = "CAR_OWNER_FATHER_NAME")
	private String carOwnerFatherName;

	@Column(name = "CAR_OWNER_PHONE")
	private String carOwnerPhone;

	@Column(name = "CAR_DRIVER_GENDER")
	private String carDriverGender;

	@Column(name = "CAR_YEAR_MANFACT")
	private Long carYear;

	@Column(name = "CAR_CAR_BRAND")
	private String carBrandId;

	@Column(name = "CAR_CAR_TRADEMARK")
	private String carTradeMark;

	@Column(name = "CAR_PLATE")
	private String carPlate;

	@Column(name = "CAR_DRIVER_LICENSE_NBR")
	private String carDriverLicenseNbr;

	@Column(name = "CAR_DRIVER_LICENSE_INCP_DTE")
	private java.sql.Timestamp carDriverLicenseIncpDate;
	@Column(name = "CAR_THRDP_INS_CMPNY_ID")
	private String insuranceCompany ;
	@Column(name = "CAR_POLICY_TYPE")
	private String carPolicyType ;


	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getCarPolicyType() {
		return carPolicyType;
	}

	public void setCarPolicyType(String carPolicyType) {
		this.carPolicyType = carPolicyType;
	}

	public java.sql.Timestamp getCarDriverLicenseIncpDate() {
		return carDriverLicenseIncpDate;
	}

	public void setCarDriverLicenseIncpDate(java.sql.Timestamp carDriverLicenseIncpDate) {
		this.carDriverLicenseIncpDate = carDriverLicenseIncpDate;
	}

	public java.sql.Timestamp getCarDriverLicenseEX() {
		return carDriverLicenseEX;
	}

	public void setCarDriverLicenseEX(java.sql.Timestamp carDriverLicenseEX) {
		this.carDriverLicenseEX = carDriverLicenseEX;
	}

	@Column(name = "CAR_DRIVER_LICENSE_EXP_DTE")
	private java.sql.Timestamp carDriverLicenseEX;

	public static Log getLogger() {
		return logger;
	}

	public static void setLogger(Log logger) {
		CarLossCar.logger = logger;
	}

	public Long getCarYear() {
		return carYear;
	}

	public void setCarYear(Long carYear) {
		this.carYear = carYear;
	}

	public String getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(String carBrandId) {
		this.carBrandId = carBrandId;
	}

	public String getCarTradeMark() {
		return carTradeMark;
	}

	public void setCarTradeMark(String carTradeMark) {
		this.carTradeMark = carTradeMark;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCarDriverGender() {
		return carDriverGender;
	}

	public void setCarDriverGender(String carDriverGender) {
		this.carDriverGender = carDriverGender;
	}



	public String getCarOwnerFamilyName() {
		return carOwnerFamilyName;
	}

	public void setCarOwnerFamilyName(String carOwnerFamilyName) {
		this.carOwnerFamilyName = carOwnerFamilyName;
	}

	public String getCarOwnerFirstName() {
		return carOwnerFirstName;
	}

	public void setCarOwnerFirstName(String carOwnerFirstName) {
		this.carOwnerFirstName = carOwnerFirstName;
	}

	public String getCarOwnerFatherName() {
		return carOwnerFatherName;
	}

	public void setCarOwnerFatherName(String carOwnerFatherName) {
		this.carOwnerFatherName = carOwnerFatherName;
	}

	public String getCarOwnerPhone() {
		return carOwnerPhone;
	}

	public void setCarOwnerPhone(String carOwnerPhone) {
		this.carOwnerPhone = carOwnerPhone;
	}

	public String getCarDriverLicenseNbr() {
		return carDriverLicenseNbr;
	}

	public void setCarDriverLicenseNbr(String carDriverLicenseNbr) {
		this.carDriverLicenseNbr = carDriverLicenseNbr;
	}


	public CarLossCar() {
		super();
	}

	public CarLossCar(String carId) {
		super();

		this.setCarId(carId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarClaimId() {
		return carClaimId;
	}

	public void setCarClaimId(String carClaimId) {
		this.carClaimId = carClaimId;
	}

	public String getCarShapeId() {
		return carShapeId;
	}

	public void setCarShapeId(String carShapeId) {
		this.carShapeId = carShapeId;
	}

	public Integer getCarSequence() {
		return carSequence;
	}

	public void setCarSequence(Integer carSequence) {
		this.carSequence = carSequence;
	}

	public String getSysCreatedBy() {
		return sysCreatedBy;
	}

	public void setSysCreatedBy(String sysCreatedBy) {
		this.sysCreatedBy = sysCreatedBy;
	}

	public java.sql.Timestamp getSysCreatedDate() {
		return sysCreatedDate;
	}

	public void setSysCreatedDate(java.sql.Timestamp sysCreatedDate) {
		this.sysCreatedDate = sysCreatedDate;
	}

	public String getSysUpdatedBy() {
		return sysUpdatedBy;
	}

	public void setSysUpdatedBy(String sysUpdatedBy) {
		this.sysUpdatedBy = sysUpdatedBy;
	}

	public java.sql.Timestamp getSysUpdatedDate() {
		return sysUpdatedDate;
	}

	public void setSysUpdatedDate(java.sql.Timestamp sysUpdatedDate) {
		this.sysUpdatedDate = sysUpdatedDate;
	}

}

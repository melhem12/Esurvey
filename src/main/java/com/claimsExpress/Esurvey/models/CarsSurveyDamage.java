package com.claimsExpress.Esurvey.models;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="CARS_SURVEY_DAMAGED")
@EntityListeners(AuditingEntityListener.class)
public class CarsSurveyDamage  implements Cloneable {

	private static Log logger = LogFactory.getLog(CarsSurveyDamage.class);

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SURVEY_DAMAGED_ID")
	private String surveyDamagedId;

	@Column(name="SURVEY_DAMAGED_SURVEY_ID")
	private String surveyDamagedSurveyId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SURVEY_DAMAGED_CAR_ID",nullable=false)
	private CarLossCar surveyDamagedCarId;

	public CarLossCar getSurveyDamagedCarId() {
		return surveyDamagedCarId;
	}

	public void setSurveyDamagedCarId(CarLossCar surveyDamagedCarId) {
		this.surveyDamagedCarId = surveyDamagedCarId;
	}

	@Column(name="SURVEY_DAMAGED_VEHICLE_SIZE")
	private String surveyDamagedVehicleSize;

	@Column(name="SURVEY_DAMAGED_BODY_TYPE")
	private String surveyDamagedBodyType;

	@Column(name="SURVEY_DAMAGED_DOORS")
	private String surveyDamagedDoors;

	@Column(name="SURVEY_DAMAGED_DESCRIPTION")
	private String surveyDamagedDescription;

	@Column(name="SYS_VERSION_NUMBER")
	private Integer sysVersionNumber;

	@Column(name="SYS_CREATED_DATE")
	private java.sql.Timestamp sysCreatedDate;

	@Column(name="SYS_CREATED_BY")
	private String sysCreatedBy;

	@Column(name="SYS_UPDATED_DATE")
	private java.sql.Timestamp sysUpdatedDate;

	@Column(name="SYS_UPDATED_BY")
	private String sysUpdatedBy;

	@Column(name="SURVEY_DAMAGED_LOCKED_DATE")
	private java.sql.Timestamp surveyDamagedLockedDate;

	@Column(name="SURVEY_DAMAGED_LOCKED_USER")
	private String surveyDamagedLockedUser;


	public CarsSurveyDamage() {
		super();
	}

	public CarsSurveyDamage(String surveyId) {
		super();

		this.setSurveyDamagedId(surveyId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}



	public String getSurveyDamagedId() {
		return surveyDamagedId;
	}

	public void setSurveyDamagedId(String surveyDamagedId) {
		this.surveyDamagedId = surveyDamagedId;
	}

	public String getSurveyDamagedSurveyId() {
		return surveyDamagedSurveyId;
	}

	public void setSurveyDamagedSurveyId(String surveyDamagedSurveyId) {
		this.surveyDamagedSurveyId = surveyDamagedSurveyId;
	}



	public String getSurveyDamagedVehicleSize() {
		return surveyDamagedVehicleSize;
	}

	public void setSurveyDamagedVehicleSize(String surveyDamagedVehicleSize) {
		this.surveyDamagedVehicleSize = surveyDamagedVehicleSize;
	}

	public String getSurveyDamagedBodyType() {
		return surveyDamagedBodyType;
	}

	public void setSurveyDamagedBodyType(String surveyDamagedBodyType) {
		this.surveyDamagedBodyType = surveyDamagedBodyType;
	}

	public String getSurveyDamagedDoors() {
		return surveyDamagedDoors;
	}

	public void setSurveyDamagedDoors(String surveyDamagedDoors) {
		this.surveyDamagedDoors = surveyDamagedDoors;
	}

	public String getSurveyDamagedDescription() {
		return surveyDamagedDescription;
	}

	public void setSurveyDamagedDescription(String surveyDamagedDescription) {
		this.surveyDamagedDescription = surveyDamagedDescription;
	}

	public Integer getSysVersionNumber() {
		return sysVersionNumber;
	}

	public void setSysVersionNumber(Integer sysVersionNumber) {
		this.sysVersionNumber = sysVersionNumber;
	}

	public java.sql.Timestamp getSysCreatedDate() {
		return sysCreatedDate;
	}

	public void setSysCreatedDate(java.sql.Timestamp sysCreatedDate) {
		this.sysCreatedDate = sysCreatedDate;
	}

	public String getSysCreatedBy() {
		return sysCreatedBy;
	}

	public void setSysCreatedBy(String sysCreatedBy) {
		this.sysCreatedBy = sysCreatedBy;
	}

	public java.sql.Timestamp getSysUpdatedDate() {
		return sysUpdatedDate;
	}

	public void setSysUpdatedDate(java.sql.Timestamp sysUpdatedDate) {
		this.sysUpdatedDate = sysUpdatedDate;
	}

	public String getSysUpdatedBy() {
		return sysUpdatedBy;
	}

	public void setSysUpdatedBy(String sysUpdatedBy) {
		this.sysUpdatedBy = sysUpdatedBy;
	}

	public java.sql.Timestamp getSurveyDamagedLockedDate() {
		return surveyDamagedLockedDate;
	}

	public void setSurveyDamagedLockedDate(java.sql.Timestamp surveyDamagedLockedDate) {
		this.surveyDamagedLockedDate = surveyDamagedLockedDate;
	}

	public String getSurveyDamagedLockedUser() {
		return surveyDamagedLockedUser;
	}

	public void setSurveyDamagedLockedUser(String surveyDamagedLockedUser) {
		this.surveyDamagedLockedUser = surveyDamagedLockedUser;
	}

	
}

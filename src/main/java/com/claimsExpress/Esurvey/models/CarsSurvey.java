package com.claimsExpress.Esurvey.models;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CARS_SURVEY")
@EntityListeners(AuditingEntityListener.class)
public class CarsSurvey  implements Cloneable {

	private static Log logger = LogFactory.getLog(CarsSurvey.class);

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SURVEY_ID")
	private String surveyId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SURVEY_CAR_ID",nullable=false)
	private CarLossCar surveyCarId;

	@Column(name="SURVEY_SEQUENCE")
	private String surveySequence;

	@Column(name="SURVEY_DATE")
	private java.sql.Timestamp surveyDate;

	@Column(name="SURVEY_SHEET")
	private String surveySheet;

	@Column(name="SURVEY_MAJOR_DAMAGE")
	private String surveyMajorDamage;

	@Column(name="SURVEY_NOT_MAJOR_DAMAGE")
	private String surveyNotMajorDamage;

	@Column(name="SURVEY_PIC")
	private String surveyPic;

	public CarLossCar getSurveyCarId() {
		return surveyCarId;
	}

	public void setSurveyCarId(CarLossCar surveyCarId) {
		this.surveyCarId = surveyCarId;
	}

	@Column(name="SURVEY_SUPPLIER_ID")
	private String surveySupplierId;

	@Column(name="SYS_CREATED_BY")
	private String sysCreatedBy;

	@Column(name="SYS_CREATED_DATE")
	private java.sql.Timestamp sysCreatedDate;

	@Column(name="SURVEY_SHEET_DATE")
	private java.sql.Timestamp surveySheetDate;

	@Column(name="SYS_UPDATED_DATE")
	private java.sql.Timestamp sysUpdatedDate;

	@Column(name="SYS_UPDATED_BY")
	private String sysUpdatedBy;

	@Column(name="SURVEY_REMARKS")
	private String surveyRemarks;

	@Column(name="SURVEY_PLACE")
	private String surveyPlace;

	public CarsSurvey() {
		super();
	}

	public CarsSurvey(String surveyId) {
		super();

		this.setSurveyId(surveyId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}



	public String getSurveySequence() {
		return surveySequence;
	}

	public void setSurveySequence(String surveySequence) {
		this.surveySequence = surveySequence;
	}

	public java.sql.Timestamp getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(java.sql.Timestamp surveyDate) {
		this.surveyDate = surveyDate;
	}

	public String getSurveySheet() {
		return surveySheet;
	}

	public void setSurveySheet(String surveySheet) {
		this.surveySheet = surveySheet;
	}

	public String getSurveyMajorDamage() {
		return surveyMajorDamage;
	}

	public void setSurveyMajorDamage(String surveyMajorDamage) {
		this.surveyMajorDamage = surveyMajorDamage;
	}

	public String getSurveyNotMajorDamage() {
		return surveyNotMajorDamage;
	}

	public void setSurveyNotMajorDamage(String surveyNotMajorDamage) {
		this.surveyNotMajorDamage = surveyNotMajorDamage;
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

	public String getSurveyRemarks() {
		return surveyRemarks;
	}

	public void setSurveyRemarks(String surveyRemarks) {
		this.surveyRemarks = surveyRemarks;
	}

	public String getSurveyPlace() {
		return surveyPlace;
	}

	public void setSurveyPlace(String surveyPlace) {
		this.surveyPlace = surveyPlace;
	}

	public java.sql.Timestamp getSurveySheetDate() {
		return surveySheetDate;
	}

	public void setSurveySheetDate(java.sql.Timestamp surveySheetDate) {
		this.surveySheetDate = surveySheetDate;
	}

	public String getSurveyPic() {
		return surveyPic;
	}

	public void setSurveyPic(String surveyPic) {
		this.surveyPic = surveyPic;
	}

	public String getSurveySupplierId() {
		return surveySupplierId;
	}

	public void setSurveySupplierId(String surveySupplierId) {
		this.surveySupplierId = surveySupplierId;
	}

}

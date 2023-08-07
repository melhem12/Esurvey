package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="CARS_SURVEY_DAMAGED_PARTS")
@EntityListeners(AuditingEntityListener.class)
public class CarsSurveyDamagedParts  implements Cloneable {
	
	private static Log logger = LogFactory.getLog(CarsSurveyDamagedParts.class);

	@Column(name="SURVEY_DAMAGED_BROKABLE")
	private Integer surveyDamagedBrokable;

	@Column(name="SURVEY_DAMAGED_CHECK_COMPANY")
	private Integer surveyDamagedCheckCompany;

	@Column(name="SURVEY_DAMAGED_DESCRIPTION")
	private String surveyDamagedDescription;

	@Id
	@Column(name="SURVEY_DAMAGED_PARTS_ID")
	private String surveyDamagedPartsId;

	@Column(name="SURVEY_DAMAGED_PART_CODE")
	private Integer surveyDamagedPartCode;

	@Column(name="SURVEY_DAMAGED_REVIEW")
	private String surveyDamagedReview;

	@Column(name="SURVEY_DAMAGED_SEVERITY")
	private Integer surveyDamagedSeverity;

	@Column(name="SURVEY_DAMAGED_SURVEY_ID")
	private String surveyDamagedSurveyId;

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

	@Column(name="MET_PARENT_PART")
	private String metParentPart;





	public CarsSurveyDamagedParts() {
		super();
	}

	public CarsSurveyDamagedParts(String surveyId) {
		super();

		this.setSurveyDamagedPartsId(surveyId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}



	public String getSurveyDamagedSurveyId() {
		return surveyDamagedSurveyId;
	}

	public void setSurveyDamagedSurveyId(String surveyDamagedSurveyId) {
		this.surveyDamagedSurveyId = surveyDamagedSurveyId;
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



	public String getSurveyDamagedPartsId() {
		return surveyDamagedPartsId;
	}

	public void setSurveyDamagedPartsId(String surveyDamagedPartsId) {
		this.surveyDamagedPartsId = surveyDamagedPartsId;
	}





	public String getSurveyDamagedReview() {
		return surveyDamagedReview;
	}

	public void setSurveyDamagedReview(String surveyDamagedReview) {
		this.surveyDamagedReview = surveyDamagedReview;
	}

	public Integer getSurveyDamagedBrokable() {
		return surveyDamagedBrokable;
	}

	public void setSurveyDamagedBrokable(Integer surveyDamagedBrokable) {
		this.surveyDamagedBrokable = surveyDamagedBrokable;
	}

	public Integer getSurveyDamagedCheckCompany() {
		return surveyDamagedCheckCompany;
	}

	public void setSurveyDamagedCheckCompany(Integer surveyDamagedCheckCompany) {
		this.surveyDamagedCheckCompany = surveyDamagedCheckCompany;
	}

	public Integer getSurveyDamagedPartCode() {
		return surveyDamagedPartCode;
	}

	public void setSurveyDamagedPartCode(Integer surveyDamagedPartCode) {
		this.surveyDamagedPartCode = surveyDamagedPartCode;
	}

	public Integer getSurveyDamagedSeverity() {
		return surveyDamagedSeverity;
	}

	public void setSurveyDamagedSeverity(Integer surveyDamagedSeverity) {
		this.surveyDamagedSeverity = surveyDamagedSeverity;
	}

	public String getMetParentPart() {
		return metParentPart;
	}

	public void setMetParentPart(String metParentPart) {
		this.metParentPart = metParentPart;
	}

}

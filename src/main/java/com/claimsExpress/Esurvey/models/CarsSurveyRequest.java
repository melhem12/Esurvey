package com.claimsExpress.Esurvey.models;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="CARS_SURVEY_REQUEST")
@EntityListeners(AuditingEntityListener.class)
public class CarsSurveyRequest  implements Cloneable {

	private static Log logger = LogFactory.getLog(CarsSurveyRequest.class);

	private static final long serialVersionUID = 1L;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SURVEY_REQUEST_CAR_ID",nullable=false)
	private CarLossCar surveyRequestCarId;
	
	public CarLossCar getSurveyRequestCarId() {
		return surveyRequestCarId;
	}

	public void setSurveyRequestCarId(CarLossCar surveyRequestCarId) {
		this.surveyRequestCarId = surveyRequestCarId;
	}

	@Column(name="SURVEY_REQUEST_ADDRESS")
	private String surveyRequestAddress;

	@Column(name="SURVEY_REQUEST_CANCELED")
	private String surveyRequestCancelled;

	@Column(name="SURVEY_REQUEST_DATE")
	private java.sql.Timestamp surveyRequestDate;

	@Column(name="SURVEY_REQUEST_GARAGE_ID")
	private String surveyRequestGarageId;

	@Column(name="SURVEY_REQUEST_GARAGE_NAME")
	private String surveyRequestGarageName;

	@Column(name="SURVEY_REQUEST_NOTE")
	private String surveyRequestNote;

	@Column(name="SURVEY_REQUEST_ORDER")
	private String surveyRequestOrder;

	@Column(name="SURVEY_REQUEST_PHONE")
	private String surveyRequestPhone;

	@Column(name="SURVEY_REQUEST_SURVEYOR_ID")
	private String surveyRequestSurveyorId;

	@Column(name="SURVEY_REQUEST_TOWN_ID")
	private String surveyRequestTownId;

	@Column(name="SURVEY_REQUEST_VIP")
	private String surveyRequestVip;

	@Column(name="RE_SURVEY_REQUEST")
	private String reSurveyRequest;

	@Id
	@Column(name="SURVEY_REQUEST_ID")
	private String surveyRequestId;

	@Column(name="SURVEY_REQUEST_USER")
	private String surveyRequestUser;

	@Column(name="SURVEY_DISPATCH_DATE")
	private java.sql.Timestamp surveyDispatchDate;

	@Column(name="SURVEY_DISPATCH_USER")
	private String surveyDispatchUser;

	@Column(name="SURVEY_DISPATCH_NOTE")
	private String surveyDispatchNote;

	@Column(name="SURVEY_REQUEST_STATUS")
	private String surveyRequestStatus;

	@Column(name="SURVEY_DEPARTURE_TOWN_ID")
	private String surveyDepartureTownId;

	@Column(name="SYS_VERSION_NUMBER")
	private String sysVersionNumber;

	@Column(name="SYS_CREATED_DATE")
	private java.sql.Timestamp sysCreatedDate;

	@Column(name="SYS_CREATED_BY")
	private String sysCreatedBy;

	@Column(name="SYS_UPDATED_DATE")
	private java.sql.Timestamp sysUpdatedDate;

	@Column(name="SYS_UPDATED_BY")
	private String sysUpdatedBy;

	@Column(name="SURVEY_REQUEST_SEQUENCE")
	private String surveyRequestSequence;

	@Column(name="SURVEY_REQUEST_MATERIAL_ID")
	private String surveyRequestMaterialId;

	@Column(name="SURVEY_COST")
	private String surveyCost;

	@Column(name="SURVEY_DISPATCH_LOG_DATE")
	private java.sql.Timestamp surveyDispatchLogDate;

	@Column(name="SURVEY_WANT_TO_REPAIR")
	private String surveyWantToRepair;

	@Column(name="SURVEY_UNDER_REPAIR")
	private String surveyUnderRepair;

	@Column(name="SURVEY_REQUEST_CANCEL_REASON")
	private String surveyRequestCancelReason;

	@Column(name="SURVEY_REQUEST_CANCEL_USER")
	private String surveyRequestCancelUser;

	@Column(name="SURVEY_REQUEST_CANCEL_DATE")
	private java.sql.Timestamp surveyRequestCancelDate;

	@Column(name="SURVEY_REQUEST_CANCEL_NOTE")
	private String surveyRequestCancelNote;


	public CarsSurveyRequest() {
		super();
	}

	public CarsSurveyRequest(String surveyRequestId) {
		super();

		this.setSurveyRequestId(surveyRequestId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getSurveyRequestAddress() {
		return surveyRequestAddress;
	}

	public void setSurveyRequestAddress(String surveyRequestAddress) {
		this.surveyRequestAddress = surveyRequestAddress;
	}

	public String getSurveyRequestCancelled() {
		return surveyRequestCancelled;
	}

	public void setSurveyRequestCancelled(String surveyRequestCancelled) {
		this.surveyRequestCancelled = surveyRequestCancelled;
	}

	public java.sql.Timestamp getSurveyRequestDate() {
		return surveyRequestDate;
	}

	public void setSurveyRequestDate(java.sql.Timestamp surveyRequestDate) {
		this.surveyRequestDate = surveyRequestDate;
	}

	public String getSurveyRequestGarageId() {
		return surveyRequestGarageId;
	}

	public void setSurveyRequestGarageId(String surveyRequestGarageId) {
		this.surveyRequestGarageId = surveyRequestGarageId;
	}

	public String getSurveyRequestGarageName() {
		return surveyRequestGarageName;
	}

	public void setSurveyRequestGarageName(String surveyRequestGarageName) {
		this.surveyRequestGarageName = surveyRequestGarageName;
	}

	public String getSurveyRequestNote() {
		return surveyRequestNote;
	}

	public void setSurveyRequestNote(String surveyRequestNote) {
		this.surveyRequestNote = surveyRequestNote;
	}

	public String getSurveyRequestOrder() {
		return surveyRequestOrder;
	}

	public void setSurveyRequestOrder(String surveyRequestOrder) {
		this.surveyRequestOrder = surveyRequestOrder;
	}

	public String getSurveyRequestPhone() {
		return surveyRequestPhone;
	}

	public void setSurveyRequestPhone(String surveyRequestPhone) {
		this.surveyRequestPhone = surveyRequestPhone;
	}

	public String getSurveyRequestSurveyorId() {
		return surveyRequestSurveyorId;
	}

	public void setSurveyRequestSurveyorId(String surveyRequestSurveyorId) {
		this.surveyRequestSurveyorId = surveyRequestSurveyorId;
	}

	public String getSurveyRequestTownId() {
		return surveyRequestTownId;
	}

	public void setSurveyRequestTownId(String surveyRequestTownId) {
		this.surveyRequestTownId = surveyRequestTownId;
	}

	public String getSurveyRequestVip() {
		return surveyRequestVip;
	}

	public void setSurveyRequestVip(String surveyRequestVip) {
		this.surveyRequestVip = surveyRequestVip;
	}

	public String getReSurveyRequest() {
		return reSurveyRequest;
	}

	public void setReSurveyRequest(String reSurveyRequest) {
		this.reSurveyRequest = reSurveyRequest;
	}

	public String getSurveyRequestUser() {
		return surveyRequestUser;
	}

	public void setSurveyRequestUser(String surveyRequestUser) {
		this.surveyRequestUser = surveyRequestUser;
	}

	public java.sql.Timestamp getSurveyDispatchDate() {
		return surveyDispatchDate;
	}

	public void setSurveyDispatchDate(java.sql.Timestamp surveyDispatchDate) {
		this.surveyDispatchDate = surveyDispatchDate;
	}

	public String getSurveyDispatchUser() {
		return surveyDispatchUser;
	}

	public void setSurveyDispatchUser(String surveyDispatchUser) {
		this.surveyDispatchUser = surveyDispatchUser;
	}

	public String getSurveyDispatchNote() {
		return surveyDispatchNote;
	}

	public void setSurveyDispatchNote(String surveyDispatchNote) {
		this.surveyDispatchNote = surveyDispatchNote;
	}

	public String getSurveyRequestStatus() {
		return surveyRequestStatus;
	}

	public void setSurveyRequestStatus(String surveyRequestStatus) {
		this.surveyRequestStatus = surveyRequestStatus;
	}

	public String getSurveyDepartureTownId() {
		return surveyDepartureTownId;
	}

	public void setSurveyDepartureTownId(String surveyDepartureTownId) {
		this.surveyDepartureTownId = surveyDepartureTownId;
	}

	public String getSysVersionNumber() {
		return sysVersionNumber;
	}

	public void setSysVersionNumber(String sysVersionNumber) {
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

	public String getSurveyRequestSequence() {
		return surveyRequestSequence;
	}

	public void setSurveyRequestSequence(String surveyRequestSequence) {
		this.surveyRequestSequence = surveyRequestSequence;
	}

	public String getSurveyRequestMaterialId() {
		return surveyRequestMaterialId;
	}

	public void setSurveyRequestMaterialId(String surveyRequestMaterialId) {
		this.surveyRequestMaterialId = surveyRequestMaterialId;
	}

	public String getSurveyCost() {
		return surveyCost;
	}

	public void setSurveyCost(String surveyCost) {
		this.surveyCost = surveyCost;
	}

	public java.sql.Timestamp getSurveyDispatchLogDate() {
		return surveyDispatchLogDate;
	}

	public void setSurveyDispatchLogDate(java.sql.Timestamp surveyDispatchLogDate) {
		this.surveyDispatchLogDate = surveyDispatchLogDate;
	}

	public String getSurveyWantToRepair() {
		return surveyWantToRepair;
	}

	public void setSurveyWantToRepair(String surveyWantToRepair) {
		this.surveyWantToRepair = surveyWantToRepair;
	}

	public String getSurveyUnderRepair() {
		return surveyUnderRepair;
	}

	public void setSurveyUnderRepair(String surveyUnderRepair) {
		this.surveyUnderRepair = surveyUnderRepair;
	}

	public String getSurveyRequestCancelReason() {
		return surveyRequestCancelReason;
	}

	public void setSurveyRequestCancelReason(String surveyRequestCancelReason) {
		this.surveyRequestCancelReason = surveyRequestCancelReason;
	}

	public String getSurveyRequestCancelUser() {
		return surveyRequestCancelUser;
	}

	public void setSurveyRequestCancelUser(String surveyRequestCancelUser) {
		this.surveyRequestCancelUser = surveyRequestCancelUser;
	}

	public java.sql.Timestamp getSurveyRequestCancelDate() {
		return surveyRequestCancelDate;
	}

	public void setSurveyRequestCancelDate(java.sql.Timestamp surveyRequestCancelDate) {
		this.surveyRequestCancelDate = surveyRequestCancelDate;
	}

	public String getSurveyRequestCancelNote() {
		return surveyRequestCancelNote;
	}

	public void setSurveyRequestCancelNote(String surveyRequestCancelNote) {
		this.surveyRequestCancelNote = surveyRequestCancelNote;
	}

	public String getSurveyRequestId() {
		return surveyRequestId;
	}

	public void setSurveyRequestId(String surveyRequestId) {
		this.surveyRequestId = surveyRequestId;
	}




}

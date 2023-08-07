package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="CARS_LOSS_RESP")
@EntityListeners(AuditingEntityListener.class)
public class CarsLossResp  implements Cloneable {

	
	private static Log logger = LogFactory.getLog(CarsLossResp.class);

	private static final long serialVersionUID = 1L;

	public CarLossCar getRepStatusCarId() {
		return repStatusCarId;
	}



	public void setRepStatusCarId(CarLossCar repStatusCarId) {
		this.repStatusCarId = repStatusCarId;
	}

	@Column(name="RESP_STATUS_STATE")
	private String respStatusState;
	@Column(name="RESP_STATUS_INSURANCE")
	private Integer respStatusInsurance;
	@Column(name="RESP_STATUS_VISA")
	private Integer respStatusVisa;
	@Column(name="RESP_STATUS_CAR")
	private Integer respStatusCar;
	@Column(name="RESP_STATUS_OTHER")
	private Integer respStatusOther;
	@Column(name="RESP_STATUS_RESP")
	private Integer respStatusResp;
	@Column(name="RESP_STATUS_REMARKS")
	private String respStatusRemarks;
	@Column(name="RESP_STATUS")
	private String respStatus;
	@Column(name="RESP_STATUS_EVALUATOR")
	private Integer respStatusEvaluator;
	@Column(name="LOG_USER")
	private String logUser;
	@Column(name="LOG_DATE_TIME")
	private java.sql.Timestamp logDateTime;
	@Column(name="LOG_COMPUTER")
	private String logComputer;
	@Column(name="LOG_SOFTWARE")
	private String logSoftware;
	@Column(name="RESP_STATUS_REPORTED_DATEJ")
	private Integer respStatusReportedDateJ;
	@Column(name="RESP_STATUS_REMOVE_APPROVAL")
	private String respStatusRemoveApproval;
	@Id
	@Column(name="REP_STATUS_ID")
	private String repStatusId;






	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REP_STATUS_CAR_ID",nullable=false)
	private CarLossCar  repStatusCarId;



	@Column(name="RESP_STATUS_BODILY_ID")
	private String respStatusBodilyId;
	@Column(name="RESP_STATUS_MATERIAL_ID")
	private String respStatusMaterialId;
	@Column(name="RESP_STATUS_OTHER_ID")
	private String respStatusOtherId;
	@Column(name="RESP_STATUS_BOD_OTH_ID")
	private String respStatusBodOthId;
	@Column(name="RESP_STATUS_MAT_OTH_ID")
	private String respStatusMatOthId;
	@Column(name="RESP_STATUS_REPORTED_DATE")
	private java.sql.Timestamp respStatusReportedDate;
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



	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}



	public String getRespStatusState() {
		return respStatusState;
	}

	public void setRespStatusState(String respStatusState) {
		this.respStatusState = respStatusState;
	}

	public Integer getRespStatusInsurance() {
		return respStatusInsurance;
	}

	public void setRespStatusInsurance(Integer respStatusInsurance) {
		this.respStatusInsurance = respStatusInsurance;
	}

	public Integer getRespStatusVisa() {
		return respStatusVisa;
	}

	public void setRespStatusVisa(Integer respStatusVisa) {
		this.respStatusVisa = respStatusVisa;
	}

	public Integer getRespStatusCar() {
		return respStatusCar;
	}

	public void setRespStatusCar(Integer respStatusCar) {
		this.respStatusCar = respStatusCar;
	}

	public Integer getRespStatusOther() {
		return respStatusOther;
	}

	public void setRespStatusOther(Integer respStatusOther) {
		this.respStatusOther = respStatusOther;
	}

	public Integer getRespStatusResp() {
		return respStatusResp;
	}

	public void setRespStatusResp(Integer respStatusResp) {
		this.respStatusResp = respStatusResp;
	}

	public String getRespStatusRemarks() {
		return respStatusRemarks;
	}

	public void setRespStatusRemarks(String respStatusRemarks) {
		this.respStatusRemarks = respStatusRemarks;
	}

	public String getRespStatus() {
		return respStatus;
	}

	public void setRespStatus(String respStatus) {
		this.respStatus = respStatus;
	}

	public Integer getRespStatusEvaluator() {
		return respStatusEvaluator;
	}

	public void setRespStatusEvaluator(Integer respStatusEvaluator) {
		this.respStatusEvaluator = respStatusEvaluator;
	}

	public String getLogUser() {
		return logUser;
	}

	public void setLogUser(String logUser) {
		this.logUser = logUser;
	}

	public java.sql.Timestamp getLogDateTime() {
		return logDateTime;
	}

	public void setLogDateTime(java.sql.Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	public String getLogComputer() {
		return logComputer;
	}

	public void setLogComputer(String logComputer) {
		this.logComputer = logComputer;
	}

	public String getLogSoftware() {
		return logSoftware;
	}

	public void setLogSoftware(String logSoftware) {
		this.logSoftware = logSoftware;
	}

	public Integer getRespStatusReportedDateJ() {
		return respStatusReportedDateJ;
	}

	public void setRespStatusReportedDateJ(Integer respStatusReportedDateJ) {
		this.respStatusReportedDateJ = respStatusReportedDateJ;
	}

	public String getRespStatusRemoveApproval() {
		return respStatusRemoveApproval;
	}

	public void setRespStatusRemoveApproval(String respStatusRemoveApproval) {
		this.respStatusRemoveApproval = respStatusRemoveApproval;
	}

	public String getRepStatusId() {
		return repStatusId;
	}

	public void setRepStatusId(String repStatusId) {
		this.repStatusId = repStatusId;
	}



	public String getRespStatusBodilyId() {
		return respStatusBodilyId;
	}

	public void setRespStatusBodilyId(String respStatusBodilyId) {
		this.respStatusBodilyId = respStatusBodilyId;
	}

	public String getRespStatusMaterialId() {
		return respStatusMaterialId;
	}

	public void setRespStatusMaterialId(String respStatusMaterialId) {
		this.respStatusMaterialId = respStatusMaterialId;
	}

	public String getRespStatusOtherId() {
		return respStatusOtherId;
	}

	public void setRespStatusOtherId(String respStatusOtherId) {
		this.respStatusOtherId = respStatusOtherId;
	}

	public String getRespStatusBodOthId() {
		return respStatusBodOthId;
	}

	public void setRespStatusBodOthId(String respStatusBodOthId) {
		this.respStatusBodOthId = respStatusBodOthId;
	}

	public String getRespStatusMatOthId() {
		return respStatusMatOthId;
	}

	public void setRespStatusMatOthId(String respStatusMatOthId) {
		this.respStatusMatOthId = respStatusMatOthId;
	}

	public java.sql.Timestamp getRespStatusReportedDate() {
		return respStatusReportedDate;
	}

	public void setRespStatusReportedDate(java.sql.Timestamp respStatusReportedDate) {
		this.respStatusReportedDate = respStatusReportedDate;
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


}

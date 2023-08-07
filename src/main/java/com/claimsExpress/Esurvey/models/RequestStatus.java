package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="CARS_SURVEY_REQUEST_STATUS")
@EntityListeners(AuditingEntityListener.class)
public class RequestStatus implements Cloneable {

	private static Log logger = LogFactory.getLog(Company.class);

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAR_SUR_REQ_STA_ID")
	private String requestStatusId;

	@Column(name="CAR_SUR_REQ_STA_CAR_ID")
	private String requestStatusCarId;

	@Column(name="CAR_SUR_REQ_STA_USER_ID")
	private String requestStatusUserId;

	@Column(name="CAR_SUR_REQ_STA_TYPOLOGY")
	private String requestStatusTypology;

	@Column(name="SYS_CREATED_DATE")
	private java.sql.Timestamp sysCreatedDate;

	@Column(name="SYS_CREATED_BY")
	private String sysCreatedBy;

	@Column(name="CAR_SUR_REQ_STA_LONGITUDE")
	private String requestStatusLongitutde;

	@Column(name="CAR_SUR_REQ_STA_LATITUDE")
	private String requestStatusLatitude;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}



	public String getRequestStatusId() {
		return requestStatusId;
	}

	public void setRequestStatusId(String requestStatusId) {
		this.requestStatusId = requestStatusId;
	}

	public String getRequestStatusCarId() {
		return requestStatusCarId;
	}

	public void setRequestStatusCarId(String requestStatusCarId) {
		this.requestStatusCarId = requestStatusCarId;
	}

	public String getRequestStatusUserId() {
		return requestStatusUserId;
	}

	public void setRequestStatusUserId(String requestStatusUserId) {
		this.requestStatusUserId = requestStatusUserId;
	}

	public String getRequestStatusTypology() {
		return requestStatusTypology;
	}

	public void setRequestStatusTypology(String requestStatusTypology) {
		this.requestStatusTypology = requestStatusTypology;
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

	public String getRequestStatusLongitutde() {
		return requestStatusLongitutde;
	}

	public void setRequestStatusLongitutde(String requestStatusLongitutde) {
		this.requestStatusLongitutde = requestStatusLongitutde;
	}

	public String getRequestStatusLatitude() {
		return requestStatusLatitude;
	}

	public void setRequestStatusLatitude(String requestStatusLatitude) {
		this.requestStatusLatitude = requestStatusLatitude;
	}

	

}

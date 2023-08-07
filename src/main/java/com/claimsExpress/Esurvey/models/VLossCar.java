package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "V_LOSS_CAR")
@EntityListeners(AuditingEntityListener.class)
public class VLossCar {
	@Id
	@Column(name = "CARID")
	private String carId;

	@Column(name = "NOTIFICATIONID")
	private String notificationId;


	@Column(name = "NOTIFICATION")
	private Long notification;
	
	@Column(name = "INSCOMPANYID")
	private String insuranceCompanyId;


	@Column(name = "POLCARID")
	private String policyCarId;


	@Column(name = "LOSSTOWID")
	private String lossTowId;

	@Column(name = "VEHSEQ")
	private Integer vehSeq;

	@Column(name = "POLICY_HOLDER")
	private String policyHolder;

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	
	public Long getNotification() {
		return notification;
	}

	public void setNotification(Long notification) {
		this.notification = notification;
	}

	public String getInsuranceCompanyId() {
		return insuranceCompanyId;
	}

	public void setInsuranceCompanyId(String insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}

	public String getPolicyCarId() {
		return policyCarId;
	}

	public void setPolicyCarId(String policyCarId) {
		this.policyCarId = policyCarId;
	}

	public String getLossTowId() {
		return lossTowId;
	}

	public void setLossTowId(String lossTowId) {
		this.lossTowId = lossTowId;
	}

	public Integer getVehSeq() {
		return vehSeq;
	}

	public void setVehSeq(Integer vehSeq) {
		this.vehSeq = vehSeq;
	}

	public String getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}

package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CARS_APP_ACCIDENT")
@EntityListeners(AuditingEntityListener.class)
public class CarsAppAccident {
	@Id
	@Column(name="APP_ACCIDENT_ID ")
	private String  accidentId ;
	 

	public CarsAppAccident() {
	}
	
	@Column(name="APP_ACCIDENT_NOTIFICATION_ID") 
	  private String accidentNotificationId ; 

	 

	

	@Column(name="APP_ACCIDENT_NOTIFICATION") 
	  private String accidentNotification ; 
	
	
	@Column(name="APP_ACCIDENT_LOCATION ") 
	  private String accidentlocation ; 
	
	
	@Column(name="APP_ACCIDENT_DETAILS") 
	  private String accidentDetails; 
	@Column(name="APP_ACCIDENT_EXPERT_USER_ID") 
	  private String accidentExpertUserId ; 
	@Column(name="APP_ACCIDENT_EXPERT_NAME") 
	  private String accidentExpertName 
	  ; 
	@Column(name="APP_ACCIDENT_BRAND") 
	  private String accidentBrand; 
	@Column(name="APP_ACCIDENT_TRADEMARK") 
	  private String accidentTradeMark ;
	
	
	@Column(name="APP_ACCIDENT_USAGE") 
	  private String accidentUsage ; 
	
	
	@Column(name="APP_ACCIDENT_CHASSIS") 
	  private String accidentChassis ; 
	
	
	@Column(name="APP_ACCIDENT_PLATE") 
	  private String accidentPlate ; 
	
	
	
	@Column(name="APP_ACCIDENT_CUSTOMER_NAME") 
	  private String accidentCustomerName; 
	
	
	
	@Column(name="APP_ACCIDENT_CUSTOMER_PHONE") 
	  private String accidentCustomerPhone ; 
	
	

	@Column(name="APP_ACCIDENT_POLICY_NUMBER") 
	  private String accidentPolicyNumber ; 

	@Column(name="APP_ACCIDENT_POLICY_INCEPT_DAT") 
	  private Date accidentPolicyInceptDate ; 
	@Column(name="APP_ACCIDENT_POLICY_EXPIRY_DAT") 
	  private Date accidentPolicyExpiryDate ; 
	
	
	@Column(name="APP_ACCIDENT_POLICY_TYPE") 
	  private String accidentPolicyType; 
	@Column(name="APP_ACCIDENT_POLICY_DETAILS") 
	  private String accidentPolicyDetails; 

	@Column(name="APP_ACCIDENT_INSURER_NAME ") 
	  private String accidentInsurerName ; 
	@Column(name="APP_ACCIDENT_CALLCENTER_MOBILE") 
	  private String accidentCallCenterMobile ; 
	@Column(name="APP_ACCIDENT_CALLER_NAME") 
	  private String accidentCallerName ; 
	@Column(name="APP_ACCIDENT_CONTACT_NUMBER") 
	  private String accidentContactNumber ;

	
	
	@Column(name="APP_ACCIDENT_STATUS") 
	  private String accdentStatus ;
	@Column(name="APP_ACCIDENT_ARRIVED_STATUS") 
	  private boolean accdentArrivedStatus ;
	
	@Column(name="APP_ACCIDENT_ARRIVED_CODE") 
	  private String accdentArrivedCode ;
	@Column(name="APP_ACCIDENT_Make") 
	  private String accidentMake;

	
	@Column(name="SYS_CREATED_DATE") 
	  private Date created ;
	
	
	
	public String getAccidentMake() {
		return accidentMake;
	}
	public void setAccidentMake(String accidentMake) {
		this.accidentMake = accidentMake;
	}
	public String getAccdentStatus() {
		return accdentStatus;
	}
	public void setAccdentStatus(String accdentStatus) {
		this.accdentStatus = accdentStatus;
	}
	public boolean isAccdentArrivedStatus() {
		return accdentArrivedStatus;
	}
	public void setAccdentArrivedStatus(boolean accdentArrivedStatus) {
		this.accdentArrivedStatus = accdentArrivedStatus;
	}
	public String getAccdentArrivedCode() {
		return accdentArrivedCode;
	}
	public void setAccdentArrivedCode(String accdentArrivedCode) {
		this.accdentArrivedCode = accdentArrivedCode;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAccidentId() {
		return accidentId;
	}
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}
	public String getAccidentNotificationId() {
		return accidentNotificationId;
	}
	public void setAccidentNotificationId(String accidentNotificationId) {
		this.accidentNotificationId = accidentNotificationId;
	}
	public String getAccidentNotification() {
		return accidentNotification;
	}
	public void setAccidentNotification(String accidentNotification) {
		this.accidentNotification = accidentNotification;
	}
	public String getAccidentlocation() {
		return accidentlocation;
	}
	public void setAccidentlocation(String accidentlocation) {
		this.accidentlocation = accidentlocation;
	}
	public String getAccidentDetails() {
		return accidentDetails;
	}
	public void setAccidentDetails(String accidentDetails) {
		this.accidentDetails = accidentDetails;
	}
	public String getAccidentExpertUserId() {
		return accidentExpertUserId;
	}
	public void setAccidentExpertUserId(String accidentExpertUserId) {
		this.accidentExpertUserId = accidentExpertUserId;
	}
	public String getAccidentExpertName() {
		return accidentExpertName;
	}
	public void setAccidentExpertName(String accidentExpertName) {
		this.accidentExpertName = accidentExpertName;
	}
	public String getAccidentBrand() {
		return accidentBrand;
	}
	public void setAccidentBrand(String accidentBrand) {
		this.accidentBrand = accidentBrand;
	}
	public String getAccidentTradeMark() {
		return accidentTradeMark;
	}
	public void setAccidentTradeMark(String accidentTradeMark) {
		this.accidentTradeMark = accidentTradeMark;
	}
	public String getAccidentUsage() {
		return accidentUsage;
	}
	public void setAccidentUsage(String accidentUsage) {
		this.accidentUsage = accidentUsage;
	}
	public String getAccidentChassis() {
		return accidentChassis;
	}
	public void setAccidentChassis(String accidentChassis) {
		this.accidentChassis = accidentChassis;
	}
	public String getAccidentPlate() {
		return accidentPlate;
	}
	public void setAccidentPlate(String accidentPlate) {
		this.accidentPlate = accidentPlate;
	}
	public String getAccidentCustomerName() {
		return accidentCustomerName;
	}
	public void setAccidentCustomerName(String accidentCustomerName) {
		this.accidentCustomerName = accidentCustomerName;
	}
	public String getAccidentCustomerPhone() {
		return accidentCustomerPhone;
	}
	public void setAccidentCustomerPhone(String accidentCustomerPhone) {
		this.accidentCustomerPhone = accidentCustomerPhone;
	}
	public String getAccidentPolicyNumber() {
		return accidentPolicyNumber;
	}
	public void setAccidentPolicyNumber(String accidentPolicyNumber) {
		this.accidentPolicyNumber = accidentPolicyNumber;
	}
	public Date getAccidentPolicyInceptDate() {
		return accidentPolicyInceptDate;
	}
	public void setAccidentPolicyInceptDate(Date accidentPolicyInceptDate) {
		this.accidentPolicyInceptDate = accidentPolicyInceptDate;
	}
	public Date getAccidentPolicyExpiryDate() {
		return accidentPolicyExpiryDate;
	}
	public void setAccidentPolicyExpiryDate(Date accidentPolicyExpiryDate) {
		this.accidentPolicyExpiryDate = accidentPolicyExpiryDate;
	}
	public String getAccidentPolicyType() {
		return accidentPolicyType;
	}
	public void setAccidentPolicyType(String accidentPolicyType) {
		this.accidentPolicyType = accidentPolicyType;
	}
	public String getAccidentPolicyDetails() {
		return accidentPolicyDetails;
	}
	public void setAccidentPolicyDetails(String accidentPolicyDetails) {
		this.accidentPolicyDetails = accidentPolicyDetails;
	}
	public String getAccidentInsurerName() {
		return accidentInsurerName;
	}
	public void setAccidentInsurerName(String accidentInsurerName) {
		this.accidentInsurerName = accidentInsurerName;
	}
	public String getAccidentCallCenterMobile() {
		return accidentCallCenterMobile;
	}
	public void setAccidentCallCenterMobile(String accidentCallCenterMobile) {
		this.accidentCallCenterMobile = accidentCallCenterMobile;
	}
	public String getAccidentCallerName() {
		return accidentCallerName;
	}
	public void setAccidentCallerName(String accidentCallerName) {
		this.accidentCallerName = accidentCallerName;
	}
	public String getAccidentContactNumber() {
		return accidentContactNumber;
	}
	public void setAccidentContactNumber(String accidentContactNumber) {
		this.accidentContactNumber = accidentContactNumber;
	} 
	



}



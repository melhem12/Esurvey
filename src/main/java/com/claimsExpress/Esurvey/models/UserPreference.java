package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CORE_USER_PREFERENCE")
@EntityListeners(AuditingEntityListener.class)
public class UserPreference implements Cloneable {

	private static Log logger = LogFactory.getLog(UserPreference.class);

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private String userId;

	@Column(name="CORE_COMPANY_ID")
	private Integer userCompanyId;

	@Column(name="DISPLAY_NAME")
	private String userName;

	@Column(name="USER_EMAIL")
	private String userEmail;

	public UserPreference() {
		super();
	}

	public UserPreference(String userId) {
		super();

		this.setUserId(userId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getUserCompanyId() {
		return userCompanyId;
	}

	public void setUserCompanyId(Integer userCompanyId) {
		this.userCompanyId = userCompanyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



}

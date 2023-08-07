package com.claimsExpress.Esurvey.responses;

import java.io.Serializable;

public class UserPreferenceResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private Integer userCompanyId;
	
	private String userName;
	
	private String userEmail;

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

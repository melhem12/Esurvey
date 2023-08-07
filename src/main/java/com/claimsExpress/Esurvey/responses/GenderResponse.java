package com.claimsExpress.Esurvey.responses;

import java.io.Serializable;

public class GenderResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String genderId;
	
	private String genderDescription;

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getGenderDescription() {
		return genderDescription;
	}

	public void setGenderDescription(String genderDescription) {
		this.genderDescription = genderDescription;
	}
	
	

}

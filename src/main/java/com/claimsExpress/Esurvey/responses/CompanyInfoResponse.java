package com.claimsExpress.Esurvey.responses;

public class CompanyInfoResponse {

	private Integer companyId;

	private String companyName;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public CompanyInfoResponse(Integer companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public CompanyInfoResponse() {
		super();
	}


}

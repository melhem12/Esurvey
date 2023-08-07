package com.claimsExpress.Esurvey.responses;

import java.util.List;

public class SurveyListResponse {
	
	private List<SurveyResponse> SurveyResponseList;

	public List<SurveyResponse> getSurveyResponseList() {
		return SurveyResponseList;
	}

	public void setSurveyResponseList(List<SurveyResponse> surveyResponseList) {
		SurveyResponseList = surveyResponseList;
	}

}

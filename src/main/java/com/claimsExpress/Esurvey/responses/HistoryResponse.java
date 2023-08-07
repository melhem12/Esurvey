package com.claimsExpress.Esurvey.responses;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;

public interface HistoryResponse {


	@Value("#{target.VISA}")
	String getNotification();
	@Value("#{target.SURVEY_DATE}")
	Timestamp getSurveyDate();

	
}

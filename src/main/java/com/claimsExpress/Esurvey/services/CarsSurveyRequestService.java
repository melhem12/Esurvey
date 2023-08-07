package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.CarLossCar;
import com.claimsExpress.Esurvey.models.CarsSurveyRequest;
import com.claimsExpress.Esurvey.repositories.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
public class CarsSurveyRequestService {
	@Autowired
	DB db;
	
	public void insertCarsSurveyRequest(String userId, String carId) {
		
	Long count = db.carsSurveyRequestRepository.getCarsSurveyRequestCount(carId);

	if (count == 0) {
		CarsSurveyRequest carsSurveyRequest = new CarsSurveyRequest();
		carsSurveyRequest.setSurveyRequestId(UUID.randomUUID().toString());
		CarLossCar carls= db.carLossCarRepository.findById(carId).get();
		carsSurveyRequest.setSurveyRequestCarId(carls);
		carsSurveyRequest.setSurveyRequestDate(new Timestamp(new Date().getTime()));
		carsSurveyRequest.setSysVersionNumber("0");
		carsSurveyRequest.setSysCreatedBy(userId);
		carsSurveyRequest.setSysCreatedDate(new Timestamp(new Date().getTime()));
		carsSurveyRequest.setSysUpdatedBy(userId);
		carsSurveyRequest.setSysUpdatedDate(new Timestamp(new Date().getTime()));

		CarsSurveyRequest saved=	db.carsSurveyRequestRepository.save(carsSurveyRequest);
		
	}
	}
}

package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.CarLossCar;
import com.claimsExpress.Esurvey.models.CarsSurvey;
import com.claimsExpress.Esurvey.repositories.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
public class CarsSurveyService {
	
	@Autowired
	DB db;
	
	public void insertCarsSurvey(String userId, String carId) {
		
	Long count = db.carsSurveyRepository.getCarsSurveyCount(carId);

	if (count == 0) {
		
		CarsSurvey carsSurvey = new CarsSurvey();
		carsSurvey.setSurveyId(UUID.randomUUID().toString());
		
		CarLossCar carls= db.carLossCarRepository.findById(carId).get();
		carsSurvey.setSurveyCarId(carls);
		carsSurvey.setSurveySequence("0");
		carsSurvey.setSurveyDate(new Timestamp(new Date().getTime()));
		carsSurvey.setSurveySheet("Y");
		carsSurvey.setSurveyMajorDamage("N");
		carsSurvey.setSurveyNotMajorDamage("N");
		carsSurvey.setSurveySheetDate(new Timestamp(new Date().getTime()));
		carsSurvey.setSurveySupplierId(null);
		carsSurvey.setSurveyPic("N");
		carsSurvey.setSysCreatedBy(userId);
		carsSurvey.setSysCreatedDate(new Timestamp(new Date().getTime()));
		carsSurvey.setSysUpdatedBy(userId);
		carsSurvey.setSysUpdatedDate(new Timestamp(new Date().getTime()));
		carsSurvey.setSurveyRemarks(userId);
		carsSurvey.setSurveyPlace("V.DISPATCHED");
		db.carsSurveyRepository.save(carsSurvey);
	}
	}
	@org.springframework.transaction.annotation.Transactional
	public void deleteCarsurvey(String carId,String userId) {
		try {
		String surveyId= db.carsSurveyDamageRepository.findByCar(carId);
		db.carsSurveyDamagedPartsRepository.deleteFromDamagePart(surveyId,userId);
		db.carsSurveyRepository.deleteBycarId(carId, userId);
		db.carsSurveyDamageRepository.deleteByCarId(carId,userId);
		db.carsSurveyRequestRepository.deleteByCarId(carId, userId);
		db.carLossRespRepository.deleteByCarId(carId, userId);
		 db.carLossCarRepository.deleteTp(carId, userId);
		}
		catch(Exception e){
			
			String a =e.toString();
			
		}
		
	}
}

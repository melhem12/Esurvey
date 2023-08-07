package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.CarLossCar;
import com.claimsExpress.Esurvey.models.CarsSurveyDamage;
import com.claimsExpress.Esurvey.repositories.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarsSurveyDamageService {
	
	@Autowired
		DB db;
	
	public void insertCarsSurvey(String userId, String surveyId, CarLossCar carLossCar, String vehicleSize, String bodyType,
			String doors) {
		
		
		int count = db.carsSurveyDamageRepository.getCarsSurveyDamagedCount(carLossCar.getCarId());

		if (count == 0) {
			CarsSurveyDamage carsSurveyDamage = new CarsSurveyDamage();
			carsSurveyDamage.setSurveyDamagedId(UUID.randomUUID().toString());
			carsSurveyDamage.setSurveyDamagedSurveyId(surveyId);
			carsSurveyDamage.setSurveyDamagedCarId(carLossCar);
			carsSurveyDamage.setSurveyDamagedVehicleSize(vehicleSize);
			carsSurveyDamage.setSurveyDamagedBodyType(bodyType);
			carsSurveyDamage.setSurveyDamagedDoors(doors);
			carsSurveyDamage.setSysVersionNumber(0);
			carsSurveyDamage.setSysCreatedDate(new Timestamp(new Date().getTime()));
			carsSurveyDamage.setSysCreatedBy(userId);
			carsSurveyDamage.setSysUpdatedDate(new Timestamp(new Date().getTime()));
			carsSurveyDamage.setSysUpdatedBy(userId);

			db.carsSurveyDamageRepository.save(carsSurveyDamage);
		} else {
			
			Optional <CarsSurveyDamage> carsSurveyDamage = db.carsSurveyDamageRepository.findBySurveyDamagedCarId(carLossCar.getCarId());
			if(carsSurveyDamage.isPresent()) { 
				CarsSurveyDamage c = carsSurveyDamage.get();
			c.setSurveyDamagedVehicleSize(vehicleSize);
			c.setSurveyDamagedBodyType(bodyType);
			c.setSurveyDamagedDoors(doors);
			c.setSysUpdatedDate(new Timestamp(new Date().getTime()));
			c.setSysUpdatedBy(userId);
			db.carsSurveyDamageRepository.save(c);
			}
		}

	}
	
	@org.springframework.transaction.annotation.Transactional
	public void finishCarsSurveyDamage(String carId, String userId) {
	db.carsSurveyDamageRepository.finish(carId,userId);
		
	}
}

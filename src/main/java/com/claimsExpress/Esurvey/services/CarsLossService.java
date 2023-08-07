package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.CarLossCar;
import com.claimsExpress.Esurvey.models.CarsSurveyRequest;
import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.requests.CarsLossRequest;
import com.claimsExpress.Esurvey.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class CarsLossService {
	@Autowired
	DB db;
	@Autowired
	CarsSurveyDamageService carsSurveyDamageService;

	public void updateLossCarPersonalInformation(CarsLossRequest carsLossRequest) throws ParseException {

		Optional<CarLossCar> carLossCar = db.carLossCarRepository.findById(carsLossRequest.getCarId());

		if (carLossCar.isPresent()) {
			CarLossCar c = carLossCar.get();
			Optional<CarsSurveyRequest> cOptional = db.carsSurveyRequestRepository.findById(c.getCarId());
//			if (cOptional.isPresent()) {
//
//				String surveyId = cOptional.get().getSurveyRequestId();
//				carsSurveyDamageService.insertCarsSurvey(carsLossRequest.getUserId(), surveyId, c,
//						carsLossRequest.getCarVehicleSize(), carsLossRequest.getCarBodyType(),
//						carsLossRequest.getCarDoors());
//
//			}

			if (!Utility.isEmpty(carsLossRequest.getUserId())) {
				c.setSysUpdatedBy(carsLossRequest.getUserId());
			}
			
			c.setSysUpdatedDate(new Timestamp(new Date().getTime()));

			if (!Utility.isEmpty(carsLossRequest.getCarOwnerFamilyName())) {
				c.setCarOwnerFamilyName(carsLossRequest.getCarOwnerFamilyName());
			}

			if (!Utility.isEmpty(carsLossRequest.getCarOwnerFirstName())) {
				c.setCarOwnerFirstName(carsLossRequest.getCarOwnerFirstName());
			}

			if (!Utility.isEmpty(carsLossRequest.getCarOwnerFatherName())) {
				c.setCarOwnerFatherName(carsLossRequest.getCarOwnerFatherName());

			}
			
			
			

			if (!Utility.isEmpty(carsLossRequest.getPhoneNumber())) {
				c.setCarOwnerPhone(carsLossRequest.getPhoneNumber());
			}

			if (!Utility.isEmpty(carsLossRequest.getCarDriverGender())) {
				c.setCarDriverGender(carsLossRequest.getCarDriverGender());
			}
			if (!Utility.isEmpty(carsLossRequest.getLicenseNumber())) {
				c.setCarDriverLicenseNbr(carsLossRequest.getLicenseNumber());

			}
			if (!Utility.isEmpty(carsLossRequest.getLicenseDate())) {
				Date  date = new SimpleDateFormat("dd/MM/yyyy").parse(carsLossRequest.getLicenseDate());
				c.setCarDriverLicenseIncpDate(new Timestamp(date.getTime()));

			}
			if (!Utility.isEmpty(carsLossRequest.getLicenseExpiryDate())) {
		
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(carsLossRequest.getLicenseExpiryDate());	
					c.setCarDriverLicenseEX(new Timestamp(date.getTime()));
			}
			db.carLossCarRepository.save(c);
		}
		// db.carLossCarRepository.updateCarLossPersonalInformation(carsLossRequest);

	}

	public void updateLossCar(CarsLossRequest carsLossRequest) {
		Optional<CarLossCar> carLossCar = db.carLossCarRepository.findById(carsLossRequest.getCarId());

		if (carLossCar.isPresent()) {
			CarLossCar c = carLossCar.get();

			Optional<CarsSurveyRequest> cOptional = db.carsSurveyRequestRepository.findByCarId(c.getCarId());
			if (cOptional.isPresent()) {

				String surveyId = cOptional.get().getSurveyRequestId();
				carsSurveyDamageService.insertCarsSurvey(carsLossRequest.getUserId(), surveyId, c,
						carsLossRequest.getCarVehicleSize(), carsLossRequest.getCarBodyType(),
						carsLossRequest.getCarDoors());

			}

			// FIXME
			// c.setSysUpdatedDate(new Timestamp(new Date().getTime()));
			if (!Utility.isEmpty(carsLossRequest.getUserId())) {
				c.setSysUpdatedBy(carsLossRequest.getUserId());
			}
			if (!Utility.isEmpty(carsLossRequest.getCarYear())) {
				c.setCarYear(Long.parseLong(carsLossRequest.getCarYear()));

			}
			if (!Utility.isEmpty(carsLossRequest.getCarBrandId())) {
				c.setCarBrandId(carsLossRequest.getCarBrandId());
			}
			if (!Utility.isEmpty(carsLossRequest.getCarTradeMarkId())) {
				c.setCarShapeId(carsLossRequest.getCarTradeMarkId() + ".ZZZZZ");
				String value = carsLossRequest.getCarTradeMarkId();
				String[] parts = value.split("\\.");
				c.setCarTradeMark(parts[1]);
			}

			if (!Utility.isEmpty(carsLossRequest.getCarPlate())) {
				c.setCarPlate(carsLossRequest.getCarPlate());

			}
			if (!Utility.isEmpty(carsLossRequest.getCarPolicyType())) {
            c.setCarPolicyType(carsLossRequest.getCarPolicyType());
			}
			
			if (!Utility.isEmpty(carsLossRequest.getCarInsuranceCompany())) {
				c.setInsuranceCompany(carsLossRequest.getCarInsuranceCompany());
							}
			db.carLossCarRepository.save(c);

		}
		
	}
	
		public int carExists(String carId) {
			try {
			CarLossCar carLossCar = new CarLossCar();
			carLossCar=db.carLossCarRepository.findById(carId).get();
			if(carLossCar!=null) {
			return 1;
			}else {
				return 0;
			}
			}catch(Exception e) {
				String  a = e.toString();
			}
			return 0;

			}

		// TODO Auto-generated method stub


}

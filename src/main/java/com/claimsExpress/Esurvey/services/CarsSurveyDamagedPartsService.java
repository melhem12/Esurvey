package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.CarsParts;
import com.claimsExpress.Esurvey.models.CarsSurveyDamagedParts;
import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.requests.CarsSurveyDamagedPartsBean;
import com.claimsExpress.Esurvey.requests.CarsSurveyDamagedPartsListBean;
import com.claimsExpress.Esurvey.responses.CarsSurveyDamagedPartsReceiveBean;
import com.claimsExpress.Esurvey.responses.CarsSurveyDamagedPartsReceiveBeanList;
import com.claimsExpress.Esurvey.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CarsSurveyDamagedPartsService {
	@Autowired
	  DB db;
	

	public  CarsSurveyDamagedPartsReceiveBeanList getAllDamagedParts(String carId) {
		// TODO Auto-generated method stub
		String surveyId = db.carsSurveyDamagedPartsRepository.GetSurveyByCarId(carId);
		CarsSurveyDamagedPartsReceiveBeanList carsSurveyDamagedPartsListBean =new CarsSurveyDamagedPartsReceiveBeanList();
		ArrayList<CarsSurveyDamagedPartsReceiveBean> carsSurveyDamagedPartsReceiveBeanList = new ArrayList<CarsSurveyDamagedPartsReceiveBean>();
		List<String> ids = db.carsSurveyDamagedPartsRepository.getAllDamagedParts(surveyId);
		
		for( String var : ids)
		if (var != null && !"".equals(var)) {
			CarsSurveyDamagedParts carsSurveyDamagedPartsLoaded = db.carsSurveyDamagedPartsRepository.findById(var).get();
			CarsSurveyDamagedPartsReceiveBean carsSurveyDamagedPartsReceiveBean = new CarsSurveyDamagedPartsReceiveBean();
			carsSurveyDamagedPartsReceiveBean.setSurveyDamagedPartsId(
					populateField(carsSurveyDamagedPartsLoaded.getSurveyDamagedPartsId()));
			carsSurveyDamagedPartsReceiveBean.setSurveyDamagedSurveyId(
					populateField(carsSurveyDamagedPartsLoaded.getSurveyDamagedSurveyId()));
			carsSurveyDamagedPartsReceiveBean
					.setSurveyDamagedPartCode(carsSurveyDamagedPartsLoaded.getSurveyDamagedPartCode());
			carsSurveyDamagedPartsReceiveBean.setSurveyDamagedDescription(
					populateField(carsSurveyDamagedPartsLoaded.getSurveyDamagedDescription()));
			carsSurveyDamagedPartsReceiveBean
					.setSurveyDamagedSeverity(carsSurveyDamagedPartsLoaded.getSurveyDamagedSeverity());
			carsSurveyDamagedPartsReceiveBean.setSurveyDamagedReview(
					populateField(carsSurveyDamagedPartsLoaded.getSurveyDamagedReview()));
			carsSurveyDamagedPartsReceiveBean
					.setMetParentPart(populateField(carsSurveyDamagedPartsLoaded.getMetParentPart()));

			CarsParts carsPartsLoadeds = db.carPartsRepository.findById(carsSurveyDamagedPartsLoaded.getSurveyDamagedPartCode().toString()).get();
					new CarsParts(carsSurveyDamagedPartsLoaded.getSurveyDamagedPartCode().toString());
			
			
			carsSurveyDamagedPartsReceiveBean.setSurveyDamagedPartArabicDescription(
					populateField(carsPartsLoadeds.getPartArabicDescription()));
			carsSurveyDamagedPartsReceiveBean
					.setSurveyDamagedPartDescription(populateField(carsPartsLoadeds.getPartDescription()));
			carsSurveyDamagedPartsReceiveBeanList.add(carsSurveyDamagedPartsReceiveBean);
		}
		carsSurveyDamagedPartsListBean.setCarsSurveyDamagedPartsReceiveBeanList(carsSurveyDamagedPartsReceiveBeanList);
	//	carsSurveyDamagedPartsReceiveResponseList.setCarsSurveyDamagedPartsReceiveBeanList(carsSurveyDamagedPartsReceiveResponse);
		return carsSurveyDamagedPartsListBean;
	
	}

	private String populateField(Object val) {

		if (!Utility.isEmpty(val)) {
			return val.toString();
		}

		return "";

	}

	@org.springframework.transaction.annotation.Transactional
	public  void insertLossCar(CarsSurveyDamagedPartsListBean carsSurveyDamagedPartsListBean) {
		
		String surveyId = db.carsSurveyDamagedPartsRepository.GetSurveyByCarId(carsSurveyDamagedPartsListBean.getCarId()) ;
		
		db.carsSurveyDamagedPartsRepository.deleteDamagedParts(surveyId);
		
	if (carsSurveyDamagedPartsListBean.getCarsSurveyDamagedPartsBean() != null && !carsSurveyDamagedPartsListBean.getCarsSurveyDamagedPartsBean().isEmpty()) {
	
		if (surveyId != null && !surveyId.isEmpty()) {
			
			for (CarsSurveyDamagedPartsBean carsSurveyDamagedPartsBean2 : carsSurveyDamagedPartsListBean.getCarsSurveyDamagedPartsBean()) {
				CarsSurveyDamagedParts carsSurveyDamagedParts = new CarsSurveyDamagedParts();
				carsSurveyDamagedParts.setSurveyDamagedPartsId(UUID.randomUUID().toString());
				carsSurveyDamagedParts
						.setSurveyDamagedCheckCompany(carsSurveyDamagedPartsBean2.getSurveyDamagedCheckCompany());
				carsSurveyDamagedParts
						.setSurveyDamagedDescription(carsSurveyDamagedPartsBean2.getSurveyDamagedDescription());
				carsSurveyDamagedParts
						.setSurveyDamagedPartCode(carsSurveyDamagedPartsBean2.getSurveyDamagedPartCode());
				carsSurveyDamagedParts.setSurveyDamagedReview(carsSurveyDamagedPartsBean2.getSurveyDamagedReview());
				carsSurveyDamagedParts
						.setSurveyDamagedSeverity(carsSurveyDamagedPartsBean2.getSurveyDamagedSeverity());
				carsSurveyDamagedParts.setSurveyDamagedSurveyId(surveyId);
				carsSurveyDamagedParts.setMetParentPart(carsSurveyDamagedPartsBean2.getMetParentPart());
				carsSurveyDamagedParts.setSysVersionNumber(0);
				carsSurveyDamagedParts.setSysCreatedBy(carsSurveyDamagedPartsBean2.getUserId());
				carsSurveyDamagedParts.setSysCreatedDate(new Timestamp(new Date().getTime()));
				carsSurveyDamagedParts.setSysUpdatedBy(carsSurveyDamagedPartsBean2.getUserId());
				carsSurveyDamagedParts.setSysUpdatedDate(new Timestamp(new Date().getTime()));
				db.carsSurveyDamagedPartsRepository.saveAndFlush(carsSurveyDamagedParts);
			}
		}
	}
		
	}




	
}

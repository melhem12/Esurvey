package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.responses.CarPartListResponse;
import com.claimsExpress.Esurvey.responses.CarPartResponse;
import com.claimsExpress.Esurvey.responses.PartMetListResponse;
import com.claimsExpress.Esurvey.responses.PartMetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsPartsService {
	@Autowired
	DB db;
	
	
	public CarPartListResponse getCarParts(String partSubgroup, String description, String bodyType, String doors,String direction) {
		System.out.println(partSubgroup);
		System.out.println(direction);
		CarPartListResponse carPartListResponse = new CarPartListResponse();
	List<CarPartResponse> carPartResponseList = db.carPartsRepository.getCarParts( partSubgroup,  description,  bodyType,  doors,direction);
		//List<CarPartResponse> carPartResponseList = db.carPartsRepository.getCarParts( partSubgroup,   bodyType,  doors);
		carPartListResponse.setCarPartBeanList(carPartResponseList);
	//	System.out.println(carPartListResponse.getCarPartBeanList().get(1).getMetCount());
		return carPartListResponse;
	}


	public PartMetListResponse getPartMet(String partSubgroup, String partId, String bodyType, String doors) {
		PartMetListResponse partMetListRespons = new PartMetListResponse();
		List<PartMetResponse> caPartMetResponses = db.carPartsRepository.getCPartMet(partId, partSubgroup, bodyType, doors);
		partMetListRespons.setPartMetBeanList(caPartMetResponses);
		// TODO Auto-generated method stub
		return partMetListRespons;
	}
	
}

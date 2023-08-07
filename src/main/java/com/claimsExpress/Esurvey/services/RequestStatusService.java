package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.RequestStatus;
import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.requests.RequestStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
public class RequestStatusService {
	@Autowired 
	DB db ;

	public void insertRequestStatus(RequestStatusRequest requestStatusRequest) {

		RequestStatus requestStatus = new RequestStatus();
		requestStatus.setRequestStatusId(UUID.randomUUID().toString());
		requestStatus.setRequestStatusUserId(requestStatusRequest.getUserId());
		requestStatus.setRequestStatusCarId(requestStatusRequest.getCarId());
		requestStatus.setRequestStatusTypology(requestStatusRequest.getTypology());
		requestStatus.setRequestStatusLongitutde(requestStatusRequest.getLongitude());
		requestStatus.setRequestStatusLatitude(requestStatusRequest.getLatitude());
		requestStatus.setSysCreatedDate(new Timestamp(new Date().getTime()));
		requestStatus.setSysCreatedBy(requestStatusRequest.getUserId());	
		db.requestStatusRepository.save(requestStatus);
	}


}

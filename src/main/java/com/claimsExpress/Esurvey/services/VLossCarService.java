package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.CarLossCar;
import com.claimsExpress.Esurvey.models.CarsLossResp;
import com.claimsExpress.Esurvey.models.UserPreference;
import com.claimsExpress.Esurvey.models.VLossCar;
import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.requests.LossCarsRequest;
import com.claimsExpress.Esurvey.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VLossCarService {
	@Autowired
	DB db;
	
	@PersistenceContext
    private EntityManager manager;
	
	public ClaimCounterResponse getEsurveySearchCount(String companyCode, String passNumber, String policyNumber,
			String plateNumber, String plateCharacter) {
		Long count = db.vLossCar2Repository.count(companyCode, passNumber, policyNumber, plateCharacter, plateNumber);
		ClaimCounterResponse claimCounterResponse = new ClaimCounterResponse();
		claimCounterResponse.setCounter(count);
		// TODO Auto-generated method stub
		return claimCounterResponse;
	}

	public ClaimListResponse getEsurveySearch(String companyCode, String passNumber, String policyNumber,
			String plateNumber, String plateCharacter) {
		ClaimListResponse claimListResponse = new ClaimListResponse();
		List<ClaimResponse> claimList = db.vLossCar2Repository.search(companyCode, passNumber, policyNumber,
				plateCharacter, plateNumber);
	//	db.claimResponseRepository.getClaimResponse(companyCode, passNumber, policyNumber,
		//		plateCharacter, plateNumber);
		
		////

		///////
		System.out.println(claimList);
		claimListResponse.setClaimBeanList(claimList);
		return claimListResponse;
	}
// public List<ClaimResponse2> getEsurveySearchList(String companyCode, String passNumber, String policyNumber,
//				String plateNumber, String plateCharacte) {
//	        List<ClaimResponse2> claimresp = manager.createNamedQuery("searchClaim", ClaimResponse2.class)
//	                                                .setParameter(1, companyCode)
//	                                                .setParameter(2, passNumber)
//	                                                .setParameter(3, policyNumber)
//	                                                .setParameter(4, plateNumber)
//	                                                .setParameter(5, plateCharacte)
//	                                                .getResultList();
//	        System.out.println(claimresp);
//	        return claimresp;
//	    }
	public UserPreference authenticate(String userId, String password) {
		
		UserPreference userPreference = db.vLossCar2Repository.authenticate( userId, password);
		return userPreference ;
	}

	public ClaimListDetailResponse getDetails(String notificationId, String companyCode) {
		ClaimListDetailResponse claimListDetailResponse = new ClaimListDetailResponse();
		List<ClaimDetailResponse> claimDetailList = db.vLossCar2Repository.getDetails(notificationId, companyCode);
		claimListDetailResponse.setClaimDetailBeanList(claimDetailList);
		return claimListDetailResponse;
	}

	public ClaimListCarDetailResponse getCarDetail(String carId, String companyCode) {
		ClaimListCarDetailResponse claimListCarDetailResponse = new ClaimListCarDetailResponse();
		List<ClaimCarDetailResponse> ClaimCarDetailList = db.vLossCar2Repository.getCarDetail(carId, companyCode);
		claimListCarDetailResponse.setClaimListCarDetailBean(ClaimCarDetailList);
		return claimListCarDetailResponse;
	}

	public ClaimListResponse getDailySurvey(String userId) {
		ClaimListResponse claimListResponse = new ClaimListResponse();
		List<ClaimResponse> claimResponseList = db.vLossCar2Repository.getDailySurvey(userId);
		claimListResponse.setClaimBeanList(claimResponseList);
		return claimListResponse;
	}
	public List<HistoryResponse> searchSurvey(String userId,String passNumber , String from , String to , String companyCode  )  {
		 String pattern = "dd-MMM-yy";
		 System.out.println(from);
		 System.out.println(to);
		 System.out.println(passNumber);
		 System.out.println(companyCode);
		 System.out.println(userId);
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        Date date1 = null;
	        Date date2 = null;
	        try {
				 date1=new SimpleDateFormat("dd/MM/yyyy").parse(from);
				 date2=new SimpleDateFormat("dd/MM/yyyy").parse(to);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

	        String mysqlDateString = formatter.format(date1);
	        String mysqlDateString2 = formatter.format(date2);
System.out.println(mysqlDateString);
	        System.out.println("//////////////////////"+mysqlDateString);
	        
		List<HistoryResponse> HistoryResponseList = db.vLossCar2Repository.searchSurvey(userId,passNumber,mysqlDateString ,mysqlDateString2,companyCode );
		
		return HistoryResponseList;
	}
	

	public SurveyCounterResponse getSurveyCount(String userId) {
		SurveyCounterResponse counterResponse = new SurveyCounterResponse ();
		  Long count = db.vLossCar2Repository.getSurveyCount(userId);
		// TODO Auto-generated method stub
		  counterResponse.setCounter(count);
		return counterResponse;
	}

	
	public InsertLossCarResponse insertLossCar(LossCarsRequest lossCarsRequest) {
		InsertLossCarResponse insertLossCarResponse= new InsertLossCarResponse();
		String carId = UUID.randomUUID().toString();
		CarLossCar carLossCar = new CarLossCar();
		carLossCar.setCarId(carId);
		carLossCar.setCarSequence(db.carLossCarRepository.getSurveyCount(lossCarsRequest.getNotification()));
		Optional <VLossCar> vlossCar  =db.vLossCarRepository.findByNotification(Long.parseLong(lossCarsRequest.getNotification()));
		if(vlossCar.isPresent()){
			carLossCar.setCarClaimId(vlossCar.get().getLossTowId());	
		}
		
		carLossCar.setSysCreatedBy(lossCarsRequest.getUserId());
		carLossCar.setSysCreatedDate(new Timestamp(new Date().getTime()));
		carLossCar.setSysUpdatedBy(lossCarsRequest.getUserId());
		carLossCar.setSysUpdatedDate(new Timestamp(new Date().getTime()));
		db.carLossCarRepository.save(carLossCar);
		
		CarsLossResp carsLossResp = new CarsLossResp();
		carsLossResp.setRespStatusOther(0);
		carsLossResp.setRepStatusId(UUID.randomUUID().toString());
		CarLossCar carls= db.carLossCarRepository.findById(carId).get();
		carsLossResp.setRepStatusCarId(carls);
		
		carsLossResp.setRespStatusReportedDate(new Timestamp(new Date().getTime()));
		carsLossResp.setRespStatusOtherId(carId);
		
		carsLossResp.setSysCreatedBy(lossCarsRequest.getUserId());
		carsLossResp.setSysCreatedDate(new Timestamp(new Date().getTime()));
		carsLossResp.setSysUpdatedBy(lossCarsRequest.getUserId());
		carsLossResp.setSysUpdatedDate(new Timestamp(new Date().getTime()));
		carsLossResp.setSysVersionNumber(1);
		db.carLossRespRepository.save(carsLossResp);
		insertLossCarResponse.setCarId(carId);
		
		
			
			Optional <VLossCar> vlossC  =db.vLossCarRepository.findByCarId(carId);
			if(vlossC.isPresent()){
				carsLossResp.setRespStatusOther(vlossC.get().getVehSeq());	
			}
		 
		 
		 
		 carsLossResp.setRepStatusId(UUID.randomUUID().toString());
			
			
			
			carsLossResp.setRepStatusCarId(carls);
			carsLossResp.setRespStatusReportedDate(new Timestamp(new Date().getTime()));
			VLossCar vlc=  db.vLossCarRepository.findByNotificationAndVhesq(Long.parseLong(lossCarsRequest.getNotification())).get();
			carsLossResp.setRespStatusOtherId(vlc.getCarId());
			db.carLossRespRepository.save(carsLossResp);
		// TODO Auto-generated method stub
		
	return insertLossCarResponse;
	}
	
	

}

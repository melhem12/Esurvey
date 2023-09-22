package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.controllers.CarsAppBodlyResponse;
import com.claimsExpress.Esurvey.models.*;
import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.requests.AccidentCoditionsRequest;
import com.claimsExpress.Esurvey.requests.CarsAppAccidentRequest;
import com.claimsExpress.Esurvey.requests.CarsAppBodlyRequest;
import com.claimsExpress.Esurvey.requests.CarsAppDamagePartsRequest;
import com.claimsExpress.Esurvey.responses.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TemaServices {
	  final Logger logger = LoggerFactory.getLogger(TemaServices.class);

	@Autowired
	private DB db ;
	@Autowired
	private NotificationService notificationService ;
	public void  addNewAccident(CarsAppAccidentRequest carsAppAccidentRequest) {
		notificationService.sendPnsToTopic(carsAppAccidentRequest.getAccidentExpertUserId(), "New Accident", "You have 5 minutes to accept ");
		CarsAppAccident carsAppAccident= new CarsAppAccident();
		
		carsAppAccident.setAccidentId(UUID.randomUUID().toString());
		
		carsAppAccident.setAccidentBrand(carsAppAccidentRequest.getAccidentBrand());
		carsAppAccident.setAccidentCallCenterMobile(carsAppAccidentRequest.getAccidentCallCenterMobile());
		carsAppAccident.setAccidentCallerName(carsAppAccidentRequest.getAccidentCallerName());
		carsAppAccident.setAccidentChassis(carsAppAccidentRequest.getAccidentChassis());
		carsAppAccident.setAccidentContactNumber(carsAppAccidentRequest.getAccidentContactNumber());
		carsAppAccident.setAccidentCustomerName(carsAppAccidentRequest.getAccidentCustomerName());
		carsAppAccident.setAccidentCustomerPhone(carsAppAccidentRequest.getAccidentCustomerPhone());
		carsAppAccident.setAccidentDetails(carsAppAccidentRequest.getAccidentDetails());
		carsAppAccident.setAccidentExpertName(carsAppAccidentRequest.getAccidentExpertName());
		carsAppAccident.setAccidentExpertUserId(carsAppAccidentRequest.getAccidentExpertUserId());
		carsAppAccident.setAccidentlocation(carsAppAccidentRequest.getAccidentlocation());
		carsAppAccident.setAccidentNotification(carsAppAccidentRequest.getAccidentNotification());
		carsAppAccident.setAccidentInsurerName(carsAppAccidentRequest.getAccidentInsurerName());
		carsAppAccident.setAccidentMake(carsAppAccidentRequest.getAccidentMake());
		carsAppAccident.setAccidentPolicyNumber(carsAppAccidentRequest.getAccidentPolicyNumber());
		carsAppAccident.setAccidentPolicyType(carsAppAccidentRequest.getAccidentPolicyType());
		carsAppAccident.setAccidentTradeMark(carsAppAccidentRequest.getAccidentTradeMark());
		carsAppAccident.setAccidentUsage(carsAppAccidentRequest.getAccidentUsage());
		carsAppAccident.setAccidentNotificationId(carsAppAccidentRequest.getAccidentNotificationId());
		
		
		
		carsAppAccident.setAccidentPlate(carsAppAccidentRequest.getAccidentPlate());
		carsAppAccident.setAccidentPolicyDetails(carsAppAccidentRequest.getAccidentPolicyDetails());
		carsAppAccident.setAccdentStatus("new");
		carsAppAccident.setCreated( new Date(Calendar.getInstance().getTime().getTime()));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {

			java.util.Date expDate = sdf1.parse(carsAppAccidentRequest.getAccidentPolicyExpiryDate());
			Date sqlExpDate = new Date(expDate.getTime());
			carsAppAccident.setAccidentPolicyExpiryDate(sqlExpDate);

		}catch (Exception e) {
			// TODO: handle exception
		}
try {

			java.util.Date incDate = sdf1.parse(carsAppAccidentRequest.getAccidentPolicyInceptDate());

			Date sqlIncDate = new Date(incDate.getTime());

			carsAppAccident.setAccidentPolicyInceptDate(sqlIncDate);

		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
db.carAccidentrepository.save(carsAppAccident);
		
	}
	
	
	public CarsAccidentListResponse getMissions(String userId ) {
		CarsAccidentListResponse carsAccidentListResponse = new CarsAccidentListResponse();
		List<CarAccidentResponse> carAccidentResponses= new ArrayList<>();
		   java.util.Date date = new java.util.Date();  
		
		List<CarsAppAccident> carsAppAccidents=  db.carAccidentrepository.findByAccidentExpertUserIdOrderByCreatedDesc(userId);
		carsAppAccidents.stream().forEach(cars->{
			if(cars.getAccdentStatus().equals("new")  && date.getTime()-cars.getCreated().getTime()<300000)  {
				
				CarAccidentResponse carAccidentResponse = new CarAccidentResponse();
				carAccidentResponse.setAccidentId(cars.getAccidentId());
				carAccidentResponse.setAccidentBrand(cars.getAccidentBrand());
				carAccidentResponse.setAccidentCallCenterMobile(cars.getAccidentCallCenterMobile());
				carAccidentResponse.setAccidentCallerName(cars.getAccidentCallerName());
				carAccidentResponse.setAccidentChassis(cars.getAccidentChassis());
				carAccidentResponse.setAccidentContactNumber(cars.getAccidentContactNumber());
				carAccidentResponse.setAccidentCustomerName(cars.getAccidentCustomerName());
				carAccidentResponse.setAccidentCustomerPhone(cars.getAccidentCustomerPhone());
				carAccidentResponse.setAccidentDetails(cars.getAccidentDetails());
				carAccidentResponse.setAccidentExpertName(cars.getAccidentExpertName());
				carAccidentResponse.setAccidentExpertUserId(cars.getAccidentExpertUserId());
				carAccidentResponse.setAccidentlocation(cars.getAccidentlocation());
				carAccidentResponse.setAccidentNotification(cars.getAccidentNotification());
				carAccidentResponse.setAccidentNotificationId(cars.getAccidentNotificationId());
				carAccidentResponse.setAccidentPlate(cars.getAccidentPlate());
				carAccidentResponse.setAccidentPolicyDetails(cars.getAccidentPolicyDetails());
				carAccidentResponse.setAccidentPolicyExpiryDate(cars.getAccidentPolicyExpiryDate());
				carAccidentResponse.setAccidentPolicyInceptDate(cars.getAccidentPolicyInceptDate());
				carAccidentResponse.setAccidentPolicyNumber(cars.getAccidentPolicyNumber());
				carAccidentResponse.setAccidentPolicyType(cars.getAccidentPolicyType());
				carAccidentResponse.setAccidentTradeMark(cars.getAccidentTradeMark());
				carAccidentResponse.setAccidentUsage(cars.getAccidentUsage());
				carAccidentResponse.setAccidentMake(cars.getAccidentMake());
				carAccidentResponse.setAccdentArrivedStatus(cars.isAccdentArrivedStatus());
				carAccidentResponse.setAccidentStatus(cars.getAccdentStatus())
				;
				
				carAccidentResponse.setTime(String.valueOf(new SimpleDateFormat("HH:mm").format(cars.getCreated())));
				carAccidentResponse.setAccidentInsurerName(cars.getAccidentInsurerName());

				carAccidentResponse.setDate(String.valueOf(cars.getCreated()));
			
				carAccidentResponses.add(carAccidentResponse);

				
			}
			
			
			
			if(cars.getAccdentStatus().equals("rejected")) {
				CarAccidentResponse carAccidentResponse = new CarAccidentResponse();
				carAccidentResponse.setAccidentId(cars.getAccidentId());
				carAccidentResponse.setAccidentBrand(cars.getAccidentBrand());
				carAccidentResponse.setAccidentCallCenterMobile(cars.getAccidentCallCenterMobile());
				carAccidentResponse.setAccidentCallerName(cars.getAccidentCallerName());
				carAccidentResponse.setAccidentChassis(cars.getAccidentChassis());
				carAccidentResponse.setAccidentContactNumber(cars.getAccidentContactNumber());
				carAccidentResponse.setAccidentCustomerName(cars.getAccidentCustomerName());
				carAccidentResponse.setAccidentCustomerPhone(cars.getAccidentCustomerPhone());
				carAccidentResponse.setAccidentDetails(cars.getAccidentDetails());
				carAccidentResponse.setAccidentExpertName(cars.getAccidentExpertName());
				carAccidentResponse.setAccidentExpertUserId(cars.getAccidentExpertUserId());
				carAccidentResponse.setAccidentlocation(cars.getAccidentlocation());
				carAccidentResponse.setAccidentNotification(cars.getAccidentNotification());
				carAccidentResponse.setAccidentNotificationId(cars.getAccidentNotificationId());
				carAccidentResponse.setAccidentPlate(cars.getAccidentPlate());
				carAccidentResponse.setAccidentPolicyDetails(cars.getAccidentPolicyDetails());
				carAccidentResponse.setAccidentPolicyExpiryDate(cars.getAccidentPolicyExpiryDate());
				carAccidentResponse.setAccidentPolicyInceptDate(cars.getAccidentPolicyInceptDate());
				carAccidentResponse.setAccidentPolicyNumber(cars.getAccidentPolicyNumber());
				carAccidentResponse.setAccidentPolicyType(cars.getAccidentPolicyType());
				carAccidentResponse.setAccidentTradeMark(cars.getAccidentTradeMark());
				carAccidentResponse.setAccidentUsage(cars.getAccidentUsage());
				carAccidentResponse.setAccidentMake(cars.getAccidentMake());
				carAccidentResponse.setAccdentArrivedStatus(cars.isAccdentArrivedStatus());
				carAccidentResponse.setAccidentStatus(cars.getAccdentStatus())
				;
				
				carAccidentResponse.setTime(String.valueOf(new SimpleDateFormat("HH:mm").format(cars.getCreated())));
				carAccidentResponse.setAccidentInsurerName(cars.getAccidentInsurerName());

				carAccidentResponse.setDate(String.valueOf(cars.getCreated()));
			
				carAccidentResponses.add(carAccidentResponse);

				
			}



			if(cars.getAccdentStatus().equals("completed")) {
				CarAccidentResponse carAccidentResponse = new CarAccidentResponse();
				carAccidentResponse.setAccidentId(cars.getAccidentId());
				carAccidentResponse.setAccidentBrand(cars.getAccidentBrand());
				carAccidentResponse.setAccidentCallCenterMobile(cars.getAccidentCallCenterMobile());
				carAccidentResponse.setAccidentCallerName(cars.getAccidentCallerName());
				carAccidentResponse.setAccidentChassis(cars.getAccidentChassis());
				carAccidentResponse.setAccidentContactNumber(cars.getAccidentContactNumber());
				carAccidentResponse.setAccidentCustomerName(cars.getAccidentCustomerName());
				carAccidentResponse.setAccidentCustomerPhone(cars.getAccidentCustomerPhone());
				carAccidentResponse.setAccidentDetails(cars.getAccidentDetails());
				carAccidentResponse.setAccidentExpertName(cars.getAccidentExpertName());
				carAccidentResponse.setAccidentExpertUserId(cars.getAccidentExpertUserId());
				carAccidentResponse.setAccidentlocation(cars.getAccidentlocation());
				carAccidentResponse.setAccidentNotification(cars.getAccidentNotification());
				carAccidentResponse.setAccidentNotificationId(cars.getAccidentNotificationId());
				carAccidentResponse.setAccidentPlate(cars.getAccidentPlate());
				carAccidentResponse.setAccidentPolicyDetails(cars.getAccidentPolicyDetails());
				carAccidentResponse.setAccidentPolicyExpiryDate(cars.getAccidentPolicyExpiryDate());
				carAccidentResponse.setAccidentPolicyInceptDate(cars.getAccidentPolicyInceptDate());
				carAccidentResponse.setAccidentPolicyNumber(cars.getAccidentPolicyNumber());
				carAccidentResponse.setAccidentPolicyType(cars.getAccidentPolicyType());
				carAccidentResponse.setAccidentTradeMark(cars.getAccidentTradeMark());
				carAccidentResponse.setAccidentUsage(cars.getAccidentUsage());
				carAccidentResponse.setAccidentMake(cars.getAccidentMake());
				carAccidentResponse.setAccdentArrivedStatus(cars.isAccdentArrivedStatus());
				carAccidentResponse.setAccidentStatus(cars.getAccdentStatus())
				;
				
				carAccidentResponse.setTime(String.valueOf(new SimpleDateFormat("HH:mm").format(cars.getCreated())));
				carAccidentResponse.setAccidentInsurerName(cars.getAccidentInsurerName());

				carAccidentResponse.setDate(String.valueOf(cars.getCreated()));
			
				carAccidentResponses.add(carAccidentResponse);

				
			}
			
			
			if(cars.getAccdentStatus().equals("accepted")) {
				CarAccidentResponse carAccidentResponse = new CarAccidentResponse();
				carAccidentResponse.setAccidentId(cars.getAccidentId());
				carAccidentResponse.setAccidentBrand(cars.getAccidentBrand());
				carAccidentResponse.setAccidentCallCenterMobile(cars.getAccidentCallCenterMobile());
				carAccidentResponse.setAccidentCallerName(cars.getAccidentCallerName());
				carAccidentResponse.setAccidentChassis(cars.getAccidentChassis());
				carAccidentResponse.setAccidentContactNumber(cars.getAccidentContactNumber());
				carAccidentResponse.setAccidentCustomerName(cars.getAccidentCustomerName());
				carAccidentResponse.setAccidentCustomerPhone(cars.getAccidentCustomerPhone());
				carAccidentResponse.setAccidentDetails(cars.getAccidentDetails());
				carAccidentResponse.setAccidentExpertName(cars.getAccidentExpertName());
				carAccidentResponse.setAccidentExpertUserId(cars.getAccidentExpertUserId());
				carAccidentResponse.setAccidentlocation(cars.getAccidentlocation());
				carAccidentResponse.setAccidentNotification(cars.getAccidentNotification());
				carAccidentResponse.setAccidentNotificationId(cars.getAccidentNotificationId());
				carAccidentResponse.setAccidentPlate(cars.getAccidentPlate());
				carAccidentResponse.setAccidentPolicyDetails(cars.getAccidentPolicyDetails());
				carAccidentResponse.setAccidentPolicyExpiryDate(cars.getAccidentPolicyExpiryDate());
				carAccidentResponse.setAccidentPolicyInceptDate(cars.getAccidentPolicyInceptDate());
				carAccidentResponse.setAccidentPolicyNumber(cars.getAccidentPolicyNumber());
				carAccidentResponse.setAccidentPolicyType(cars.getAccidentPolicyType());
				carAccidentResponse.setAccidentTradeMark(cars.getAccidentTradeMark());
				carAccidentResponse.setAccidentUsage(cars.getAccidentUsage());
				carAccidentResponse.setAccidentMake(cars.getAccidentMake());
				carAccidentResponse.setAccdentArrivedStatus(cars.isAccdentArrivedStatus());
				carAccidentResponse.setAccidentStatus(cars.getAccdentStatus())
				;
				
				carAccidentResponse.setTime(String.valueOf(new SimpleDateFormat("HH:mm").format(cars.getCreated())));
				carAccidentResponse.setAccidentInsurerName(cars.getAccidentInsurerName());

				carAccidentResponse.setDate(String.valueOf(cars.getCreated()));
			
				carAccidentResponses.add(carAccidentResponse);

				
			}
			
			

		});
		carsAccidentListResponse.setMissions(carAccidentResponses);


		return carsAccidentListResponse;
		
	}


	public ResponsabilityListResponse getResponsdabilities() {
		ResponsabilityListResponse responsabilityListResponse = new ResponsabilityListResponse();
		
		List <ConstantResponse> v= db.coreDomainValueMLRepository.getResp("APP_RESP", "ar");
		logger.info("///////////////////////");
		//logger.info(values.get(0).toString());
		logger.info("///////////////////////");	
		responsabilityListResponse.setResponsabilityList(v);
		return responsabilityListResponse;
	}


	public DamageCapListResponse getDamageCap() {
		DamageCapListResponse damageCapListResponse = new DamageCapListResponse();
		List <ConstantResponse> v= db.coreDomainValueMLRepository.getResp("APP_DAMAGE", "ar");
		damageCapListResponse.setDamageCapList(v);
		
		return damageCapListResponse;
	}


	public DoubtsListResponse getDoubts() {
		DoubtsListResponse doubtsListResponse= new DoubtsListResponse();
		List <ConstantResponse> v= db.coreDomainValueMLRepository.getResp("APP_DOUBTS", "ar");
		doubtsListResponse.setDoubtsList(v);
		return doubtsListResponse;
	}


	public CarpartsPanelListResponse getCarParts() {
		CarpartsPanelListResponse  panel= new CarpartsPanelListResponse();
		List <CarParts> v= db.coreDomainValueMLRepository.getCarParts();
		panel.setPanelList(v);	
		return panel ;
	}


	public  void insertAccidentConditions(AccidentCoditionsRequest accidentCoditionsRequest) {
		
		
		Optional<CarsAppAccidentConditions> carsAppAccidentConditions	=	db.carsAppAccidentConditionsRepository.findByCarsAppAccident(accidentCoditionsRequest.getCarsAppAccidentId());

		carsAppAccidentConditions.ifPresent(
				value -> System.out.println("Found: " + value));
		carsAppAccidentConditions.ifPresent(
                (conditions)
                        -> {
                        	
                        	
                        	conditions.setAccidentConditionsDoubts(accidentCoditionsRequest.getAccidentConditionsDoubts());
                        	conditions.setAccidentConditionsResponsib(accidentCoditionsRequest.getAccidentConditionsResponsib());
                        	conditions.setAccidentConditionsTPFDamage(accidentCoditionsRequest.getAccidentConditionsTPFDamage());
                			conditions.setAccidentConditiosTPCount(accidentCoditionsRequest.getAccidentConditiosTPCount());
                        	db.carsAppAccidentConditionsRepository.save(conditions);
		
                        });
		             if   (!carsAppAccidentConditions.isPresent()) {

		                        	CarsAppAccidentConditions carsAppAccidentCoditionsNew = new		CarsAppAccidentConditions();
		                			carsAppAccidentCoditionsNew.setAccidentConditionsDoubts(accidentCoditionsRequest.getAccidentConditionsDoubts());
		                			carsAppAccidentCoditionsNew.setAccidentConditionsId(UUID.randomUUID().toString());
		                			carsAppAccidentCoditionsNew.setAccidentConditionsResponsib(accidentCoditionsRequest.getAccidentConditionsResponsib());
		                			carsAppAccidentCoditionsNew.setAccidentConditionsTPFDamage(accidentCoditionsRequest.getAccidentConditionsTPFDamage());
		                			carsAppAccidentCoditionsNew.setAccidentConditiosTPCount(accidentCoditionsRequest.getAccidentConditiosTPCount());
		                			Optional<CarsAppAccident > accident =	db.carAccidentrepository.findById(accidentCoditionsRequest.getCarsAppAccidentId());
		                			accident.ifPresent(
		                		                (acc)
		                		                        -> {
		                		                        	carsAppAccidentCoditionsNew.setCarsAppAccident(acc);
		                		                        	db.carsAppAccidentConditionsRepository.save(carsAppAccidentCoditionsNew);

		                		                });
		                			              ///TODO exception
		                }
		
		
	
		

	}


	public AccidentCoditionsResponse getAccidentCoditions(String acidentId) {
	
		AccidentCoditionsResponse accidentCoditionsResponse = new AccidentCoditionsResponse();
		Optional<CarsAppAccidentConditions> carsAppAccidentConditions	=	db.carsAppAccidentConditionsRepository.findByCarsAppAccident(acidentId);
		carsAppAccidentConditions.ifPresent(
                (conditions)
                        -> {
                        	System.out.println("fetched///////////////////////////");
                        	accidentCoditionsResponse.setAccidentConditionsDoubts(conditions.getAccidentConditionsDoubts());
                        	accidentCoditionsResponse.setAccidentConditionsId(conditions.getAccidentConditionsId());
                        	accidentCoditionsResponse.setAccidentConditionsResponsib(conditions.getAccidentConditionsResponsib());
                        	accidentCoditionsResponse.setAccidentConditionsTPFDamage(conditions.getAccidentConditionsTPFDamage());
                        	accidentCoditionsResponse.setAccidentConditiosTPCount(conditions.getAccidentConditiosTPCount());
                        	accidentCoditionsResponse.setCarsAppAccidentId(conditions.getCarsAppAccident().getAccidentId());

                });
    	//System.out.println("fetched///////////////////////////"+accidentCoditionsResponse.g);

		return accidentCoditionsResponse;
	}


	public void updateGeoStatus(String status, String username) {
		
		
		System.out.println("tttttttttttttttt");

		
		
		
	Optional <CarsSupplier> cs = db.carsSupplierRepository.findBySupplierCoreUserId(username);
		
	
		
		
		System.out.println("000000000000000000000000000000000000000");
		
		System.out.println(cs.get().getCarSupkey());

	Optional<GeoExpert> geoOtional= db.geoExpertRepository.findByGeoExpertId(cs.get().getCarSupkey());
	geoOtional.ifPresent(
            (geo)
                    -> {
                    	
               geo.setStatus(status);
               geo.setDispatchingTime( new Timestamp(System.currentTimeMillis()));
               db.geoExpertRepository.save(geo);
               
            });
	
	}


	public void updateAccidentStatus(String status,String accidentId, String username) {
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+status);












//		// Save the PDF content to a file
//		try {
//			FileUtils.writeByteArrayToFile(new File("item-report.pdf"), reportContent);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//








		if(status.equals("accepted")) {
			System.out.println("lllllllllllllll");

			 String randomPin ="1234";













			 
			 
				Optional<CarsAppAccident> accOptional= db.carAccidentrepository.findById(accidentId);
				accOptional.ifPresent(
			            (acc)
			                    -> {
			                    	
			               acc.setAccdentStatus(status);
			               
			               ///generate random number and send  to client using SMS  and save it 
			              
			               acc.setAccdentArrivedCode(randomPin);
			               db.carAccidentrepository.save(acc);
			           	Optional <CarsSupplier> cs = db.carsSupplierRepository.findBySupplierCoreUserId(username);
System.out.println(username);
System.out.println("/////////////////////////");
System.out.println(cs.get().getCarSupkey());

			               Optional<GeoExpert> geoOtional= db.geoExpertRepository.findByGeoExpertId(cs.get().getCarSupkey());
			           	geoOtional.ifPresent(
			                       (geo)
			                               -> {
			                               	
			                          geo.setStatus("dispatch");
			                          db.geoExpertRepository.save(geo);
			                          
			                       });
			           	
			               
			            });
				
			
		}
		else if(status.equals("completed")) {
			Optional<CarsAppAccident> accOptional= db.carAccidentrepository.findById(accidentId);
			accOptional.ifPresent(
		            (acc)
		                    -> {
		                    	
		               acc.setAccdentStatus(status);











						CarsAppAccident carsAppAccident=        db.carAccidentrepository.save(acc);









						JasperReport jasperReport;

						try {
							System.out.println("begin ................................");

							jasperReport = (JasperReport)
									JRLoader.loadObject(ResourceUtils.getFile("C:\\coreReports\\aropeTema.jasper"));
						} catch (FileNotFoundException | JRException e) {
							try {
								File file = ResourceUtils.getFile("C:\\coreReports\\aropeTema.jrxml");
								System.out.println("read   ................");
								jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
								JRSaver.saveObject(jasperReport, "C:\\coreReports\\aropeTema.jasper");
							} catch (FileNotFoundException | JRException ex) {
								throw new RuntimeException(e);
							}
						}
						//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);

						Map<String, Object> parameters = new HashMap<>();

						parameters.put("insuredName", "Fathi");

						JasperPrint jasperPrint = null;
						byte[] reportContent;

						try {
							// Sample data - Replace with your actual data source
							List<Map<String, Object>> dataList = new ArrayList<>();

							Map<String, Object> data1 = new HashMap<>();
							data1.put("insuredName", carsAppAccident.getAccidentCustomerName());
							data1.put("phoneNumber", carsAppAccident.getAccidentCustomerPhone());
							data1.put("policyNumber", carsAppAccident.getAccidentPolicyNumber());



//			data1.put("reportDate", "2023-09-14");
							data1.put("reportDetails", carsAppAccident.getAccidentDetails());

							data1.put("policyCode",carsAppAccident.getAccidentPolicyNumber());
							data1.put("vehicleDetails", "Sample vehicle details");
							data1.put("pasNumber", "12345");
							data1.put("requestSendingDate", new java.util.Date());
							data1.put("accidentAddress", carsAppAccident.getAccidentlocation());
							data1.put("accidentCallerName", carsAppAccident.getAccidentCallerName());
							data1.put("requestNumber", "REQ123");
							data1.put("expertName",carsAppAccident.getAccidentExpertName());








//							Optional<CarsAppAccidentConditions> carsAppAccidentConditions	=	db.carsAppAccidentConditionsRepository.findByCarsAppAccident(carsAppAccident.getAccidentId());
//
//							carsAppAccidentConditions.ifPresent(
//									value -> System.out.println("Found: " + value));
//							carsAppAccidentConditions.ifPresent(
//									(conditions)
//											-> {
//
//
//										conditions.setAccidentConditionsDoubts(accidentCoditionsRequest.getAccidentConditionsDoubts());
//										conditions.setAccidentConditionsResponsib(accidentCoditionsRequest.getAccidentConditionsResponsib());
//										conditions.setAccidentConditionsTPFDamage(accidentCoditionsRequest.getAccidentConditionsTPFDamage());
//										conditions.setAccidentConditiosTPCount(accidentCoditionsRequest.getAccidentConditiosTPCount());
//
//									});

















							Optional<CarsAppAccidentConditions> carsAppAccidentConditions	=	db.carsAppAccidentConditionsRepository.findByCarsAppAccident(carsAppAccident.getAccidentId());


							carsAppAccidentConditions.ifPresent(
									(conditions)
											-> {

										System.out.println("fetched///////////////////////////");
										data1.put("responsibility", conditions.getAccidentConditionsResponsib());
										Optional <ConstantResponse> v= db.coreDomainValueMLRepository.getRespByCode("APP_DOUBTS", "ar",conditions.getAccidentConditionsDoubts());
										System.out.println(v.get().getDescription()+"////////////////////sadsda");
										data1.put("doubts",v.get().getDescription());
										data1.put("thirdParties",conditions.getAccidentConditionsTPFDamage());



									});





							data1.put("caseAcceptedDate", new java.util.Date());
							data1.put("arrivedDate", new java.util.Date());
							data1.put("reportSendDate", new java.util.Date());
							data1.put("photosSentDate", new java.util.Date());
							data1.put("severity", "Low");
//							data1.put("thirdParties", "Sample third parties");
							data1.put("numberOfPhotos", "5");
							data1.put("voiceRecorded", "true");
							data1.put("damageDetails", "Sample damage details");
							data1.put("expertPhoneNumber", "987-654-3210");
							data1.put("accidentContactNumber", "555-555-5555");
							data1.put("passengersMinorInjuriesNumberTp", "2");
							data1.put("passengersMinorInjuriesNumberIns", "1");
							data1.put("passengersMajorInjuriesNumberTp", "0");
							data1.put("passengersMajorInjuriesNumberIns", "0");
							data1.put("deathNumberTp", "0");
							data1.put("deathNumberIns", "0");
							data1.put("accidentDetails", "Sample accident details");
							data1.put("arrivedLocation", "Sample arrived location");
//							data1.put("temaPhotos", "Sample tema photos");






							// Add more data fields as needed

							// Add more data fields here
							dataList.add(data1);

							// Create a JRBeanCollectionDataSource to provide the data
							JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
							System.out.println(jasperReport.getName());
							jasperReport.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
							jasperReport.setProperty("net.sf.jasperreports.default.font.name", "ArialFontFamily");
							jasperReport.setProperty("net.sf.jasperreports.default.pdf.font.name", "ArialFontFamily");
							jasperReport.setProperty("net.sf.jasperreports.default.pdf.embedded", "true");
							//	jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
							try {
								jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

							}
							catch (Exception e){
								System.out.println(e.toString());
							}
							System.out.println(jasperReport.getName());
							JasperExportManager.exportReportToPdfFile(jasperPrint, "output_report.pdf");

							//jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);

							reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

						} catch (JRException e) {
							System.out.println(e);
							throw new RuntimeException(e);
						}


























						Optional <CarsSupplier> cs = db.carsSupplierRepository.findBySupplierCoreUserId(username);

			               Optional<GeoExpert> geoOtional= db.geoExpertRepository.findByGeoExpertId(cs.get().getCarSupkey());
		           	geoOtional.ifPresent(
		                       (geo)
		                               -> {
		                               	
		                          geo.setStatus("available");
		                          db.geoExpertRepository.save(geo);
		                          
		                       });
		           	
		           	
		               
		               
		               
		               
		            });
		}
		
		
		if(status.equals("rejected")) {
			System.out.println("rejjjjjjjjjjjjjjjjjjjjjj");
				Optional<CarsAppAccident> accOptional= db.carAccidentrepository.findById(accidentId);
				accOptional.ifPresent(
			            (acc)
			                    -> {
			                    	
			               acc.setAccdentStatus(status);
			               
			               ///generate random number and send  to client using SMS  and save it 
			              
			               db.carAccidentrepository.save(acc);
			               
			            });
				
			
		}	
	}


	public VerficationResponse updateArrivedStatus(String pinCode, String accidentID) {
		  System.out.println(pinCode);
		// TODO Auto-generated method stub
		Optional<CarsAppAccident> accOptional= db.carAccidentrepository.findById(accidentID);
		VerficationResponse response = new VerficationResponse();
		accOptional.ifPresent(
	            (acc)
	                    -> {
	                    	
	               if(acc.getAccdentArrivedCode().equals(pinCode))
	               {
	            	 
	            	   response.setVerficationSuccess(true);
		               acc.setAccdentArrivedStatus(true);
		               db.carAccidentrepository.save(acc);

  
	            	  
	               }
	               else {
	            	   response.setVerficationSuccess(false);

		               acc.setAccdentArrivedStatus(false);
		               db.carAccidentrepository.save(acc);

   
	               }
	              
	               
	            });
		return response ;
	
	}


	public void uploadAccidentPicturesToDatabase(String name, String accidentId, byte[] image) {
		
			
			Optional<CarsAppPictures> caOptiona =  db.carsAppPicturesRepository.findByCarsAppAccident(accidentId);

			

				
				
		
	    	caOptiona.ifPresent(
			            (pic)
			                    -> {
			                    	
			                    	if(name.equals("appPicturesGeneral")) {
			                    		pic.setAppPicturesGeneral(image);
			                			
			                		}

			                    	
			                    	if(name.equals("appPicturesCarDamage")) {
			                    		pic.setAppPicturesCarDamage(image);
			                			
			                		}
			                    	
			                    	
			                    	if(name.equals("appPicturesTPPolicy")) {
			                    		pic.setAppPicturesTPPolicy(image);
			                			
			                		}
			                    	if(name.equals("appPicturesDLvr1")) {
			                    		pic.setAppPicturesDLvr1(image);
			                			
			                		}
			                    	if(name.equals("appPicturesDLvr2")) {
			                    		pic.setAppPicturesDLvr2(image);
			                			
			                		}
			                    	
			                    	if(name.equals("appPicturesOptional1")) {
			                    		pic.setAppPicturesOptional1(image);
			                			
			                		}
			                    	if(name.equals("appPicturesOptional2")) {
			                    		pic.setAppPicturesOptional2(image);
			                			
			                		}
			                    	if(name.equals("appPicturesOptional3")) {
			                    		pic.setAppPicturesOptional3(image);
			                			
			                		}
		                			db.carsAppPicturesRepository.save(pic);

			              
			               
			            });
			            if(!caOptiona.isPresent())
			                     {
			                    	
			                    	
			                    	CarsAppPictures carsAppPictures = new CarsAppPictures();
			                		carsAppPictures.setAppPicturesId(UUID.randomUUID().toString());
			                		Optional<CarsAppAccident> accOptional= db.carAccidentrepository.findById(accidentId);
			                		carsAppPictures.setCarsAppAccident(accOptional.get());
			                		
			                		if(name.equals("appPicturesGeneral")) {
			                			carsAppPictures.setAppPicturesGeneral(image);
			                			
			                		}

			                    	
			                    	if(name.equals("appPicturesCarDamage")) {
			                    		carsAppPictures.setAppPicturesCarDamage(image);
			                			
			                		}
			                    	
			                    	
			                    	if(name.equals("appPicturesTPPolicy")) {
			                    		carsAppPictures.setAppPicturesTPPolicy(image);
			                			
			                		}
			                    	if(name.equals("appPicturesDLvr1")) {
			                    		carsAppPictures.setAppPicturesDLvr1(image);
			                			
			                		}
			                    	if(name.equals("appPicturesDLvr2")) {
			                    		carsAppPictures.setAppPicturesDLvr2(image);
			                			
			                		}
			                    	
			                    	if(name.equals("appPicturesOptional1") ){
			                    		carsAppPictures.setAppPicturesOptional1(image);
			                			
			                		}
			                    	if(name.equals("appPicturesOptional2")) {
			                    		carsAppPictures.setAppPicturesOptional2(image);
			                			
			                		}
			                    	if(name.equals("appPicturesOptional3") ){
			                    		carsAppPictures.setAppPicturesOptional3(image);
			                			
			                		}
			              
			            			db.carsAppPicturesRepository.save(carsAppPictures);

			  		             
			            }
    	
    	
    	
    	
    	
	    	
	    	
    	
    	
    	
    	
		
		
		
	}


	public AccidentPicturesResponse getAccPictures(String accidentId) {
		
		AccidentPicturesResponse accidentPicturesResponse = 	new AccidentPicturesResponse();
    	Optional<CarsAppPictures> caOptiona =  db.carsAppPicturesRepository.findByCarsAppAccident(accidentId);

    	caOptiona.ifPresent(
		            (pic)
		                    -> {
		                    	
		                    	
		                    	accidentPicturesResponse.setAppPicturesGeneral(pic.getAppPicturesGeneral()!=null);
		                			
		                		

		                    	accidentPicturesResponse.setCarsAppAccidentId(pic.getCarsAppAccident().getAccidentId());
		                    	accidentPicturesResponse.setAppPicturesId(pic.getAppPicturesId());
		                    
		                    		accidentPicturesResponse.setAppPicturesCarDamage(pic.getAppPicturesCarDamage()!=null);
		                			
		                		
		                    	
		                    	
		                    		accidentPicturesResponse.setAppPicturesTPPolicy(pic.getAppPicturesTPPolicy()!=null);
		                			
		                	
		                    		accidentPicturesResponse.setAppPicturesDLvr1(pic.getAppPicturesDLvr1()!=null);
		                			
		                	
		                    	
		                    		accidentPicturesResponse.setAppPicturesDLvr2(pic.getAppPicturesDLvr2()!=null);
		                			
		                		
		                    	
		                    	
		                    		accidentPicturesResponse.setAppPicturesOptional1(pic.getAppPicturesOptional1()!=null);
		                			
		                		
		                  
		                    		accidentPicturesResponse.setAppPicturesOptional2(pic.getAppPicturesOptional2()!=null);
		                			
		                		
		                    		accidentPicturesResponse.setAppPicturesOptional3(pic.getAppPicturesOptional2()!=null);
		                			
		                		

		              
		               
		            });
		return accidentPicturesResponse;
	}


	public void updateCarsAppBodly(CarsAppBodlyRequest carsAppBodlyRequest) {
		// TODO Auto-generated method stub
		Optional<CarsAppBodly>	carsAppBodlyOptional= db.carsAppBodlyRepository.findByCarsAppAccident(carsAppBodlyRequest.getCarsAppAccidentId());
		
		
		
		
		
		carsAppBodlyOptional.ifPresent((carsAppBodly)
                -> {
                	
                  	carsAppBodly.setBodlyInsCountDeath(carsAppBodlyRequest.getBodlyInsCountDeath());
        			carsAppBodly.setBodlyInsCountLightInj(carsAppBodlyRequest.getBodlyInsCountLightInj());
        			carsAppBodly.setBodlyInsCountSeverInj(carsAppBodlyRequest.getBodlyInsCountSeverInj());
        			carsAppBodly.setBodlyTPCountDeath(carsAppBodlyRequest.getBodlyTPCountDeath());
        			carsAppBodly.setBodlyTPCountLightInj(carsAppBodlyRequest.getBodlyTPCountLightInj());
        			carsAppBodly.setBodlyTPCountSeverInj(carsAppBodlyRequest.getBodlyTPCountSeverInj());
        			db.carsAppBodlyRepository.save(carsAppBodly);

     
        });
		if (!carsAppBodlyOptional.isPresent()){
                	
                	
        			CarsAppBodly carsAppBodly = new CarsAppBodly();
        			carsAppBodly.setBodlyId(UUID.randomUUID().toString());
        			carsAppBodly.setBodlyInsCountDeath(carsAppBodlyRequest.getBodlyInsCountDeath());
        			carsAppBodly.setBodlyInsCountLightInj(carsAppBodlyRequest.getBodlyInsCountLightInj());
        			carsAppBodly.setBodlyInsCountSeverInj(carsAppBodlyRequest.getBodlyInsCountSeverInj());
        			carsAppBodly.setBodlyTPCountDeath(carsAppBodlyRequest.getBodlyTPCountDeath());
        			carsAppBodly.setBodlyTPCountLightInj(carsAppBodlyRequest.getBodlyTPCountLightInj());
        			carsAppBodly.setBodlyTPCountSeverInj(carsAppBodlyRequest.getBodlyTPCountSeverInj());
        			Optional<CarsAppAccident> carsAppAccident= db.carAccidentrepository.findById(carsAppBodlyRequest.getCarsAppAccidentId());
        			carsAppBodly.setCarsAppAccident(carsAppAccident.get());
        			db.carsAppBodlyRepository.save(carsAppBodly);


		             
        }

		
		
	}


	public CarsAppBodlyResponse getCarsAppBodly(String accidentId) {
		CarsAppBodlyResponse carsAppBodlyResponse = new CarsAppBodlyResponse();
		Optional<CarsAppBodly>	carsAppBodlyOptional= db.carsAppBodlyRepository.findByCarsAppAccident(accidentId);
		
		carsAppBodlyOptional.ifPresent((carsAppBodly)
                -> {
                	
            		carsAppBodlyResponse.setBodlyId(carsAppBodly.getBodlyId());

            		carsAppBodlyResponse.setBodlyInsCountDeath(carsAppBodly.getBodlyInsCountDeath());
            		carsAppBodlyResponse.setBodlyInsCountLightInj(carsAppBodly.getBodlyInsCountLightInj());
            		carsAppBodlyResponse.setBodlyInsCountSeverInj(carsAppBodly.getBodlyTPCountSeverInj());
            		carsAppBodlyResponse.setBodlyTPCountDeath(carsAppBodly.getBodlyTPCountDeath());
            		carsAppBodlyResponse.setBodlyTPCountLightInj(carsAppBodly.getBodlyTPCountLightInj());
            		carsAppBodlyResponse.setBodlyTPCountSeverInj(carsAppBodly.getBodlyTPCountSeverInj());

            		carsAppBodlyResponse.setCarsAppAccidentId(carsAppBodly.getCarsAppAccident().getAccidentId());

          
           
        }
                );
	
	
	
		// TODO Auto-generated method stub
		return carsAppBodlyResponse;
	}


	public CarsAppDamagePartsResponse getCarsAppDamageParts(String accidentId) {
		CarsAppDamagePartsResponse carsAppDamagePartsResponse = new CarsAppDamagePartsResponse();
		List<CarsAppDamagePartResponse> carAppDamagePartResponses = new ArrayList<>();

		List<CarsAppDamageParts>	carsAppDamageParts=  db.carsAppDamagePartsRepository.findByCarsAppAccident(accidentId);
		carsAppDamageParts.stream().forEach(carsAppDamagePart->{
			CarsAppDamagePartResponse carsAppDamagePartResponse = new CarsAppDamagePartResponse ();
			
			carsAppDamagePartResponse.setDamagedPartsId(carsAppDamagePart.getDamagedPartsId());
			carsAppDamagePartResponse.setDamagesPartsPartId(carsAppDamagePart.getDamagesPartsPartId());
			carsAppDamagePartResponse.setCarsAppAccidentId(carsAppDamagePart.getCarsAppAccident().getAccidentId());
			carAppDamagePartResponses.add(carsAppDamagePartResponse);
			
		});
		carsAppDamagePartsResponse.setAppDamagePartResponses(carAppDamagePartResponses);
		// TODO Auto-generated method stub
		return carsAppDamagePartsResponse;
	}


	public void updateCarsAppDamageParts(CarsAppDamagePartsRequest carsAppDamagePartsRequest) {
		
		// TODO Auto-generated method stub
		
			List<CarsAppDamageParts>	carsAppDamagePartList=  db.carsAppDamagePartsRepository.findByCarsAppAccident(carsAppDamagePartsRequest.getAccidentId());
             db.carsAppDamagePartsRepository.deleteAll(carsAppDamagePartList);
             
			carsAppDamagePartsRequest.getCarsAppDamagePartsRequest().stream().forEach(reqList->{
				
		     	CarsAppDamageParts carsAppDamageParts = new CarsAppDamageParts();
    			Optional<CarsAppAccident> carsAppAccidentOptional= db.carAccidentrepository.findById(reqList.getCarsAppAccidentId());

				carsAppDamageParts.setCarsAppAccident(carsAppAccidentOptional.get());

				carsAppDamageParts.setDamagesPartsPartId(reqList.getDamagesPartsPartId());
				carsAppDamageParts.setDamagedPartsId(UUID.randomUUID().toString());
				db.carsAppDamagePartsRepository.save(carsAppDamageParts);
				
					
				
					
					
					
					
	
				
				
				
			});	
		}
		
	
	


	public void uploadNotes( String carsAppAccidentId, byte[] bytes, String notesRemark) {
		
		
		
		
		
	Optional<CarsAppNotes>  notesOptional=	db.carsAppNotesRepository.findByCarsAppAccident(carsAppAccidentId);
		notesOptional.ifPresent((notes)
                -> {
                	 notes.setNotesRemark(notesRemark);
    	             notes.setVoiceNote(bytes);
    	 			db.carsAppNotesRepository.save(notes);	

                
        });
		if(!notesOptional.isPresent())
       {

        			CarsAppNotes carsAppNotes = new CarsAppNotes();
        			carsAppNotes.setNotesId(UUID.randomUUID().toString());
        			carsAppNotes.setVoiceNote(bytes);
        			Optional<CarsAppAccident> carsAppAccidentOptional= db.carAccidentrepository.findById(carsAppAccidentId);
        			carsAppNotes.setCarsAppAccident(carsAppAccidentOptional.get());
        			carsAppNotes.setNotesRemark(notesRemark);
        			db.carsAppNotesRepository.save(carsAppNotes);	
        	        	
                	
            	 }

	
	}


	public CarsAppNotesResponse getNotes(String accidentId) {
		CarsAppNotesResponse carsAppNotesResponse = new CarsAppNotesResponse();
		// TODO Auto-generated method stub
		Optional<CarsAppNotes>  notesOptional=	db.carsAppNotesRepository.findByCarsAppAccident(accidentId);
		notesOptional.ifPresent((notes)
                -> {
                	carsAppNotesResponse.setNotesRemark(notes.getNotesRemark());
                	carsAppNotesResponse.setVoiceNote(notes.getVoiceNote());
                	carsAppNotesResponse.setNotesId(notes.getNotesId());

                	carsAppNotesResponse.setCarsAppAccidentId(notes.getCarsAppAccident().getAccidentId());
        }
                );
		return carsAppNotesResponse;
	}


	public void updateGeoLocation(String longitude, String latitude, String username) {

		Optional <CarsSupplier> cs = db.carsSupplierRepository.findBySupplierCoreUserId(username);

		System.out.println("000000000000000000000000000000000000000");
		
		System.out.println(cs.get().getCarSupkey());

		Optional<GeoExpert> geoOtional= db.geoExpertRepository.findByGeoExpertId(cs.get().getCarSupkey());
		geoOtional.ifPresent(
	            (geo)
	                    -> {
	                    	
	               geo.setLatitude(latitude);
	       
	               geo.setLongitude(longitude);
	               db.geoExpertRepository.save(geo);

	            });
		
		// TODO Auto-generated method stub
		
	}

	
	
	
	


}

package com.claimsExpress.Esurvey.controllers;

import com.claimsExpress.Esurvey.models.UserPreference;
import com.claimsExpress.Esurvey.requests.*;
import com.claimsExpress.Esurvey.responses.*;
import com.claimsExpress.Esurvey.services.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController

@RequestMapping(value = "/api/v1/esurveyController")
@Slf4j
public class ESurveyController {
	  final Logger logger = LoggerFactory.getLogger(ESurveyController.class);

	@Autowired
	CarsSurveyService carsSurveyService;

	@Autowired
	CarsSurveyRequestService carsSurveyRequestService;
	
	@Autowired
	VLossCarService vLossCarService;
	
	@Autowired
	CarsPartsService carsPartsService;
	
	@Autowired
	CarsLossService carsLossService;
	
	@Autowired
 	CarsSurveyDamageService   carsSurveyDamageService;
	
	@Autowired
 	RequestStatusService   requestStatusService;
	@Autowired
	CarsSurveyDamagedPartsService carsSurveyDamagedPartsService;
	@GetMapping("/eSurveySearchCount")
	private ResponseEntity<ClaimCounterResponse> getEsurveySearchCount(
			@RequestParam(name = "companyCode", required = true) String companyCode,
			@RequestParam(name = "passNumber", required = false) String passNumber,
			@RequestParam(name = "policyNumber", required = false) String policyNumber,
			@RequestParam(name = "plateNumber", required = false) String plateNumber,
			@RequestParam(name = "plateCharacter", required = false) String plateCharacter) {
		ClaimCounterResponse response = vLossCarService.getEsurveySearchCount(companyCode, passNumber, policyNumber,
				plateNumber, plateCharacter);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	@GetMapping("/eSurveySearch")
	private ResponseEntity<ClaimListResponse> getEsurveySearch(
			@RequestParam(name = "companyCode", required = true) String companyCode,
			@RequestParam(name = "passNumber", required = false) String passNumber,
			@RequestParam(name = "policyNumber", required = false) String policyNumber,
			@RequestParam(name = "plateNumber", required = false) String plateNumber,
			@RequestParam(name = "plateCharacter", required = false) String plateCharacter) {
		ClaimListResponse response = vLossCarService.getEsurveySearch(companyCode, passNumber, policyNumber,
				plateNumber, plateCharacter);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<UserPreferenceResponse> authenticate(AuthenticationResponse auth) {
	//	Gson gson = new Gson();

			UserPreference userPreference = vLossCarService.authenticate(auth.getUserId(),
					auth.getPassword());
			UserPreferenceResponse userPreferenceResponse = new UserPreferenceResponse();
			BeanUtils.copyProperties(userPreferenceResponse, userPreference);

			return new ResponseEntity(userPreferenceResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getClaimDetails")
	public ResponseEntity<ClaimListDetailResponse> ClaimDetail(@RequestParam(name = "notificationId", required = true) String notificationId,
			@RequestParam(name = "companyCode", required = true) String companyCode
	) {
		ClaimListDetailResponse response = vLossCarService.getDetails(notificationId, companyCode);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	


	@GetMapping("/getCarDetails")

	public ResponseEntity<ClaimListDetailResponse> carDetail(@RequestParam(name = "carId", required = true) String carId,
			@RequestParam(name = "companyCode", required = true) String companyCode
	) {		
		ClaimListCarDetailResponse response = vLossCarService.getCarDetail(carId, companyCode);
	return new ResponseEntity(response, HttpStatus.OK);
		
	}
	

	@GetMapping("/getCarParts")
	public ResponseEntity<CarPartListResponse>  getCarParts(@RequestParam(name = "partSubgroup", required = true) String partSubgroup,
			@RequestParam(name = "bodyType", required = true) String bodyType, @RequestParam(name = "doors", required = true) String doors,
			@RequestParam(name = "description", required = false) String description,@RequestParam(name = "direction", required = true) String direction  ) {
		CarPartListResponse response = carsPartsService.getCarParts(partSubgroup, description, bodyType, doors,direction);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	@GetMapping("/getPartMet")
	public ResponseEntity<PartMetListResponse>  getPartMet(@RequestParam(name = "partSubgroup", required = true) String partSubgroup,
			@RequestParam(name = "bodyType", required = true) String bodyType, @RequestParam(name = "doors", required = true) String doors,
			@RequestParam(name = "partId", required = false) String partId) {
		PartMetListResponse response = carsPartsService.getPartMet(partSubgroup, partId, bodyType, doors);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/getDailySurvey")
	public ResponseEntity<ClaimListResponse> getDailySurvey(@RequestParam(name = "userId", required = true) String userId) {
		
		ClaimListResponse response = vLossCarService.getDailySurvey(userId);
		return new ResponseEntity(response, HttpStatus.OK);
		

	}
	
	@GetMapping("/searchSurvey")
	public ResponseEntity<HistoryResponse> searchSurveys(@RequestParam(name = "userId", required = true) String userId,@RequestParam(name = "passNumber",
	required = false) String passNumber,@RequestParam(name = "from", required = false) String from
			,@RequestParam(name = "to", required = false) String to ,@RequestParam(name = "companyCode", required = true) String companyCode)  {
		
		List<HistoryResponse> response = vLossCarService.searchSurvey(userId, passNumber, from, to,companyCode);
		return new ResponseEntity(response, HttpStatus.OK);
		

	}
	
	@GetMapping("/getSurveyCount")
	public ResponseEntity<SurveyCounterResponse> getSurveyCount(@RequestParam(name = "userId", required = true) String userId) {
		
		SurveyCounterResponse response = vLossCarService.getSurveyCount(userId);
		return new ResponseEntity(response, HttpStatus.OK);
		

	}
	

	@GetMapping("/finishSurvey")
	public ResponseEntity<Void> finishSurvey(@RequestParam(name="carId") String carId, @RequestParam(name="userId") String userId) {
	
		carsSurveyDamageService.finishCarsSurveyDamage(carId, userId);
			
			 return new ResponseEntity( HttpStatus.OK);
	}
	@GetMapping("/getAllDamagedParts")
	public ResponseEntity<CarsSurveyDamagedPartsReceiveBeanList> getAllDamagedParts(@RequestParam(name = "carId", required = true) String carId) {
		
		CarsSurveyDamagedPartsReceiveBeanList response = carsSurveyDamagedPartsService.getAllDamagedParts(carId);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	

	
	@PostMapping(value = {"/insertDamagedParts"})
	public  ResponseEntity<Void> insertDamagedParts (@RequestBody CarsSurveyDamagedPartsListBean carsSurveyDamagedPartsListBean) {
	//	System.out.println("//////////////////////////////");
	//	System.out.println(carsSurveyDamagedPartsListBean.getCarsSurveyDamagedPartsBean().toString());
	System.out.println(carsSurveyDamagedPartsListBean.getCarId());
	System.out.println("//////////////////////////////");
	System.out.println(carsSurveyDamagedPartsListBean.getCarsSurveyDamagedPartsBean());
		try {

			carsSurveyDamagedPartsService.insertLossCar(carsSurveyDamagedPartsListBean);
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
 
	
	
	
	
    @PostMapping(value = { "/insertLossCar"})
    public ResponseEntity<InsertLossCarResponse> insertLossCar( @RequestBody LossCarsRequest lossCarsRequest ){
    	try {
    		InsertLossCarResponse response=vLossCarService.insertLossCar(lossCarsRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
    	}
    	catch(Exception ex) {
            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);

    	}
    
    }
    @PostMapping(value = { "/insertCarsSurvey"})
    public ResponseEntity<Void> insertCarsSurvey( @RequestBody InsertCarsSurveyRequest insertCarsSurveyRequest ){
    	try {
    		carsSurveyService.insertCarsSurvey(insertCarsSurveyRequest.getUserId(),insertCarsSurveyRequest.getCarId());
    		carsSurveyRequestService.insertCarsSurveyRequest(insertCarsSurveyRequest.getUserId(),insertCarsSurveyRequest.getCarId());
            return new ResponseEntity( HttpStatus.CREATED);
    	}
    	catch(Exception ex) {
            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);

    	}
    
    }
	
    
    
    @PostMapping(value = { "/insertRequestStatus"})
    public ResponseEntity<Void> insertRequestStatus( @RequestBody RequestStatusRequest requestStatusRequest ){
    	try {
    		requestStatusService.insertRequestStatus(requestStatusRequest);
            return new ResponseEntity( HttpStatus.CREATED);
    	}
    	catch(Exception ex) {
            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);

    	}
    
    }
    @DeleteMapping(value = { "/deleteCarsSurvey"})
    public ResponseEntity<Void> deleteCarsSurvey( @RequestParam(name = "carId", required = true) String carId , @RequestParam(name = "userId", required = true) String userId){
    	try {
    		carsSurveyService.deleteCarsurvey(carId,userId);
    		if(carsLossService.carExists(carId)==1) {
    		    return new ResponseEntity( HttpStatus.METHOD_NOT_ALLOWED);
    		}
            return new ResponseEntity( HttpStatus.OK);
    	}
    	catch(Exception ex) {
            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);

    	}
    
    }
	
    @PostMapping("/sendImage/{notification}")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable("notification") String notification) {
      String message = "";
      try {
      //  storageService.save(file);        MessageInfosage = "Uploaded the file successfully: " + file.getOriginalFilename();
    	  logger.info(file.getName());
    	  logger.info(file.getContentType());
logger.info(file.getOriginalFilename());
logger.info(file.getResource().toString());
logger.info(file.getBytes().toString());

imageIoWrite(file.getBytes(),notification);

        return new ResponseEntity(HttpStatus.OK);
        
      } catch (Exception e) {
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
      }
    }
    public static void imageIoWrite(byte[] a,String notification) {
        try {
        	
        	new File("C:\\INTEGRA_DOCUMENTS\\"+notification).mkdirs();
//        	BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            ImageIO.write(bImage, "jpg", bos );
//            byte [] data = bos.toByteArray();
            ByteArrayInputStream bis = new ByteArrayInputStream(a);
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File("C:\\INTEGRA_DOCUMENTS\\"+notification+"\\"+UUID.randomUUID().toString()+".jpg") );
            bis.close();
            System.out.println("image created");
	
        	
//            File initialImage = new File("C://Users/Rou/Desktop/image.jpg");
//            bImage = ImageIO.read(initialImage);
//
//            ImageIO.write(bImage, "gif", new File("C://Users/Rou/Desktop/image.gif"));
//            ImageIO.write(bImage, "jpg", new File("C://Users/Rou/Desktop/image.png"));
//            ImageIO.write(bImage, "bmp", new File("C://Users/Rou/Desktop/image.bmp"));

        } catch (IOException e) {
              System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
   }
    
 

 
	@PostMapping("/updateLossCarPersonalInformation")
	public ResponseEntity<Void>  updateLossCarPersonalInformation(@RequestBody CarsLossRequest carsLossRequest) throws ParseException {
		carsLossService.updateLossCarPersonalInformation(carsLossRequest);
		  return new ResponseEntity( HttpStatus.OK);
	}
	@PostMapping("/updateLossCar")
	public ResponseEntity<Void>  updateLossCar( @RequestBody CarsLossRequest carsLossRequest) {
		carsLossService.updateLossCar(carsLossRequest);
		  return new ResponseEntity( HttpStatus.OK);
	}
	
    
    
	
}

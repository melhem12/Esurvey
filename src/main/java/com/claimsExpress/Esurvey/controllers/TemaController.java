package com.claimsExpress.Esurvey.controllers;

import com.claimsExpress.Esurvey.requests.*;
import com.claimsExpress.Esurvey.responses.*;
import com.claimsExpress.Esurvey.services.TemaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping(value = "/api/v1/temaController")
@CrossOrigin("*")
public class TemaController  extends BaseController{
	@Autowired
	TemaServices temaServices;
	@GetMapping("/missions")
	private ResponseEntity<CarsAccidentListResponse> getMissions() {
		CarsAccidentListResponse response = temaServices.getMissions(getCurrentUser().getUsername());
		return new ResponseEntity(response, HttpStatus.OK);
	}
	@GetMapping("/responsabilities")
	private ResponseEntity<ResponsabilityListResponse> getResponsdabilities() {
		ResponsabilityListResponse response = temaServices.getResponsdabilities();
		return new ResponseEntity(response, HttpStatus.OK);
	}
	@GetMapping("/damageCap")
	private ResponseEntity<DamageCapListResponse> getDamageCap() {
		DamageCapListResponse response = temaServices.getDamageCap();
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@GetMapping("/doubts")
	private ResponseEntity<DoubtsListResponse> getDoubts() {
		DoubtsListResponse response = temaServices.getDoubts();
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@GetMapping("/carPanels")
	private ResponseEntity<CarpartsPanelListResponse> getCarParts() {
		CarpartsPanelListResponse response = temaServices.getCarParts();
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@GetMapping("/accidentConditions")
	private ResponseEntity<AccidentCoditionsResponse>  getAccidentCoditions(@RequestParam(name = "accidentId", required = true)String accidentId){
		AccidentCoditionsResponse response = temaServices.getAccidentCoditions(accidentId);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@PostMapping(value = {"/insertAccidentConditions"})
	public  ResponseEntity<Void> insertAccidentConditions (@RequestBody AccidentCoditionsRequest accidentCoditionsRequest) {

		try {

			temaServices.insertAccidentConditions(accidentCoditionsRequest);
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping(value = {"/updateGeoStatus"})
	public  ResponseEntity<Void> updateGeoStatus (@RequestBody  UserStatusRequest userStatusRequest) {

		try {

			temaServices.updateGeoStatus(userStatusRequest.getStatus(),getCurrentUser().getUsername());
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PostMapping(value = {"/updateAccidentStatus"})
	public  ResponseEntity<Void> updateAccidentStatus (@RequestBody  AccidentStatusRequest accidentStatusRequest) {

		try {

				temaServices.updateAccidentStatus(accidentStatusRequest.getStatus(),accidentStatusRequest.getAccidentId(),getCurrentUser().getUsername());
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@PostMapping(value = {"/updateGeoLocation"})
	public  ResponseEntity<Void> updateGeoLocation (@RequestBody  GeoLocationRequest geoLocationRequest) {
		
		System.out.println("66666666666666666666666666666666666666666666666666666666666test");


		try {

			temaServices.updateGeoLocation(geoLocationRequest.getLongitude(),geoLocationRequest.getLatitude(),getCurrentUser().getUsername());
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	
	
	
	
	
	@PostMapping(value = "/uploadAccidentPicturesToDatabase")
	public String uploadAccidentPicturesToDatabase(@RequestParam String name, @RequestParam MultipartFile file,@RequestParam String accidentId)
			throws IOException {

		// Set the form data into entity
	//	PrimeMinisterOfIndia pmOfIndia = new PrimeMinisterOfIndia();
//		pmOfIndia.setName(name);
//		pmOfIndia.setPhoto(file.getBytes());
		
		
		temaServices.uploadAccidentPicturesToDatabase(name ,accidentId,compressImage(file));

		// Save the records into the database
		//fileUploadRepository.save(pmOfIndia);

		return "image uploaded";
	}
	
	
	
	
	
	
	
	
	@PostMapping(value = {"/updateArrivedStatus"})
	public  ResponseEntity<VerficationResponse> updateArrivedStatus (@RequestBody  ArriveStatusRequest arriveStatusRequest) {

		try {

			VerficationResponse response=	temaServices.updateArrivedStatus(arriveStatusRequest.getPinCode(),arriveStatusRequest.getAccidentID());
			  return new ResponseEntity(response, HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@GetMapping("/getAccPictures")
	private ResponseEntity<AccidentPicturesResponse> getAccPictures(@RequestParam String accidentId) {
		AccidentPicturesResponse response = temaServices.getAccPictures(accidentId);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@PostMapping(value = {"/updateCarsAppBodly"})
	public  ResponseEntity<Void> updateCarsAppBodly (@RequestBody  CarsAppBodlyRequest carsAppBodlyRequest) {

		try {

			temaServices.updateCarsAppBodly(carsAppBodlyRequest);
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
	}
	
	
	

	@GetMapping("/getCarsAppBodly")
	private ResponseEntity<CarsAppBodlyResponse> getCarsAppBodly(@RequestParam String accidentId) {
		CarsAppBodlyResponse response = temaServices.getCarsAppBodly(accidentId);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/getCarsAppDamageParts")
	private ResponseEntity<CarsAppDamagePartsResponse> getCarsAppDamageParts(@RequestParam String accidentId) {
		CarsAppDamagePartsResponse response = temaServices.getCarsAppDamageParts(accidentId);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	
	@PostMapping(value = {"/updateCarsAppDamageParts"})
	public  ResponseEntity<Void> updateCarsAppDamageParts (@RequestBody  CarsAppDamagePartsRequest carsAppDamagePartsRequest) {

		try {

			temaServices.updateCarsAppDamageParts(carsAppDamagePartsRequest);
			  return new ResponseEntity( HttpStatus.CREATED);

		} catch (Exception e) {
			  return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
	}
	
	
	@PostMapping(value = "/uploadNotes")
	public String uploadNotes(  @RequestParam MultipartFile file,@RequestParam String carsAppAccidentId,@RequestParam String notesRemark)
			throws IOException {
		
		// Set the form data into entity
	//	PrimeMinisterOfIndia pmOfIndia = new PrimeMinisterOfIndia();
//		pmOfIndia.setName(name);
//		pmOfIndia.setPhoto(file.getBytes());
		
		temaServices.uploadNotes( carsAppAccidentId,file.getBytes(),notesRemark);

		// Save the records into the database
		//fileUploadRepository.save(pmOfIndia);

		return "image uploaded";
	}
	
	
	
	@GetMapping("/getNotes")
	private ResponseEntity<CarsAppNotesResponse> getNotes(@RequestParam String accidentId) {
		CarsAppNotesResponse response = temaServices.getNotes(accidentId);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	

	
	private byte[] compressImage(MultipartFile mpFile) {
	    float quality = 0.3f;
	    String imageName = mpFile.getOriginalFilename();
	    String imageExtension = imageName.substring(imageName.lastIndexOf(".") + 1);
	    // Returns an Iterator containing all currently registered ImageWriters that claim to be able to encode the named format.
	    // You don't have to register one yourself; some are provided.
	    ImageWriter imageWriter = ImageIO.getImageWritersByFormatName(imageExtension).next();
	    ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
	    imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT); // Check the api value that suites your needs.
	    // A compression quality setting of 0.0 is most generically interpreted as "high compression is important,"
	    // while a setting of 1.0 is most generically interpreted as "high image quality is important."
	    imageWriteParam.setCompressionQuality(quality);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    // MemoryCacheImageOutputStream: An implementation of ImageOutputStream that writes its output to a regular
	    // OutputStream, i.e. the ByteArrayOutputStream.
	    ImageOutputStream imageOutputStream = new MemoryCacheImageOutputStream(baos);
	    // Sets the destination to the given ImageOutputStream or other Object.
	    imageWriter.setOutput(imageOutputStream);
	    BufferedImage originalImage = null;
	    try (InputStream inputStream = mpFile.getInputStream()) {
	        originalImage = ImageIO.read(inputStream); 
	    } catch (IOException e) {
	        String info = String.format("compressImage - bufferedImage (file %s)- IOException - message: %s ", imageName, e.getMessage());
	    //    logger.error(info);
	        return baos.toByteArray();
	    }
	    IIOImage image = new IIOImage(originalImage, null, null);
	    try {
	        imageWriter.write(null, image, imageWriteParam);
	    } catch (IOException e) {
	        String info = String.format("compressImage - imageWriter (file %s)- IOException - message: %s ", imageName, e.getMessage());
	       // logger.error(info);
	    } finally {
	        imageWriter.dispose();
	    }
	    return baos.toByteArray();
	}
	
	
	
	
	
	
}

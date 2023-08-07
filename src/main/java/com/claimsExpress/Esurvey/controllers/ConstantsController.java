package com.claimsExpress.Esurvey.controllers;

import com.claimsExpress.Esurvey.responses.*;
import com.claimsExpress.Esurvey.services.ConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController

@RequestMapping(value="/api/v1/constant")
public class ConstantsController   {
	@Autowired 
	private ConstantService constantService ;
@GetMapping("/companiesList")
private ResponseEntity <CompanyListResponse> getCompanies (){
	CompanyListResponse  response= constantService.companyInfoResponseList();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/genderList")
private ResponseEntity <GenderListResponse> getGenders (){
	GenderListResponse  response= constantService.getGendersList();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/carBrandList")
private ResponseEntity <CarBrandListResponse> getCarBrandList (){
	CarBrandListResponse  response= constantService.getCarBrandList();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/carTrademarkList")
private ResponseEntity <CarTrademarkListResponse> getCarTrademarkList (@RequestParam(name="carBrandId") String carBrandId){
	CarTrademarkListResponse  response= constantService.getCarTrademarkList(carBrandId);
	return new ResponseEntity( response ,HttpStatus.OK);
}

@GetMapping("/getDoors")
private ResponseEntity <DoorsListResponse> getDoors (){
	DoorsListResponse  response= constantService.getDoors();
	return new ResponseEntity( response ,HttpStatus.OK);
}

@GetMapping("/getBodyType")
private ResponseEntity <BodyTypeListResponse> getBodyType (){
	BodyTypeListResponse  response= constantService.getBodyType();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/getVehicleSize")
private ResponseEntity <VehicleSizeListResponse> getVehicleSize (){
	VehicleSizeListResponse  response= constantService.getVehicleSize();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/getDescriptions")
private ResponseEntity <LitigationDamageLovResponse> getDescriptions (){
	LitigationDamageLovListResponse  response= constantService.getDescriptions();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/getPartGroup")
private ResponseEntity <PartGroupListResponse> getPartGroup (){
	PartGroupListResponse  response= constantService.getPartGroup();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/getDirections")
private ResponseEntity <DirectionsListResponse> getDirections (){
	DirectionsListResponse  response= constantService.getDirections();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/getPolicyType")
private ResponseEntity <DirectionsListResponse> getPolicyType (){
	PolicyTypeListResponse  response= constantService.getPolicyType();
	return new ResponseEntity( response ,HttpStatus.OK);
}
@GetMapping("/getInsuranceCompany")
private ResponseEntity <DirectionsListResponse> getInsuranceCompany (){
	InsuranceCompanyListResponse  response= constantService.getInsuranceCompany();
	return new ResponseEntity( response ,HttpStatus.OK);
}



}

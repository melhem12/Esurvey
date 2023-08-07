package com.claimsExpress.Esurvey.controllers;

import com.claimsExpress.Esurvey.requests.CarsAppAccidentRequest;
import com.claimsExpress.Esurvey.services.TemaServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/v1/auth/outer")
public class AccidentOuterController {
	  final Logger logger = LoggerFactory.getLogger(AccidentOuterController.class);

	@Autowired 
	private TemaServices temaServices ;
	@PostMapping("/addAccident")
	public ResponseEntity<Void>  addNewAccident(@RequestBody  CarsAppAccidentRequest carsAppAccidentRequest) throws ParseException {
		logger.info("///////////////////////");

		logger.info(carsAppAccidentRequest.getAccidentBrand());
		logger.info("///////////////////////");
		temaServices.addNewAccident(carsAppAccidentRequest);
		  return new ResponseEntity( HttpStatus.OK);
		

	}
}

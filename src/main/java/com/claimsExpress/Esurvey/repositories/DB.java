package com.claimsExpress.Esurvey.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DB {
@Autowired
public CompanyRepository companyRepository ;

@Autowired
public CarBrandRepository carBrandRepository ;

@Autowired
public CarLossCarRepository carLossCarRepository ;

@Autowired
public CarLossRespRepository carLossRespRepository ;

@Autowired
public CarPartsRepository carPartsRepository ;

@Autowired
public CarsSurveyDamageRepository carsSurveyDamageRepository ;

@Autowired
public CarsSurveyDamagedPartsRepository carsSurveyDamagedPartsRepository ;

@Autowired
public CarsSurveyRepository carsSurveyRepository ;

@Autowired
public CarsSurveyRequestRepository carsSurveyRequestRepository ;

@Autowired
public CarTrademarkRepository carTrademarkRepository ;

@Autowired
public PartGroupRepository partGroupRepository ;

@Autowired
public RequestStatusRepository requestStatusRepository ;

@Autowired
public UserPreferenceRepository userPreferenceRepository ;
@Autowired
public  DoorsRepository doorsRepository ;
@Autowired
public  BodyTypeRepository bodyTypeRepository ;
@Autowired
public  VehicleSizeRepository vehicleSizeRepository ;
@Autowired
public  VLossCar2Repository vLossCar2Repository ;
@Autowired
public  VLossCarRepository vLossCarRepository ;
@Autowired
public  LitigationRepository litigationRepository;
@Autowired
public DirectionsRepository directionsRepository ;
@Autowired
public PolicyTypeRepository policyTypeRepository ;
@Autowired
public InsuranceCompanyRepository insuranceCompanyRepository;
@Autowired
public CarAccidentrepository carAccidentrepository;
@Autowired
public CoreDomainValueMLRepository coreDomainValueMLRepository ;

@Autowired
public CarsAppAccidentConditionsRepository carsAppAccidentConditionsRepository ;

@Autowired
public  GeoExpertRepository  geoExpertRepository;

@Autowired
public CarsAppPicturesRepository carsAppPicturesRepository;
@Autowired
public CarsAppBodlyRepository carsAppBodlyRepository ;
@Autowired
public CarsAppDamagePartsRepository carsAppDamagePartsRepository ;
@Autowired
public CarsAppNotesRepository carsAppNotesRepository ;
@Autowired
public CarsSupplierRepository carsSupplierRepository;
}


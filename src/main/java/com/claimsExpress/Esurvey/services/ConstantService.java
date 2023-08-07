package com.claimsExpress.Esurvey.services;

import com.claimsExpress.Esurvey.models.*;
import com.claimsExpress.Esurvey.repositories.DB;
import com.claimsExpress.Esurvey.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstantService {
	@Autowired
	DB db;

	public CompanyListResponse companyInfoResponseList() {
		CompanyListResponse companyListResponse = new CompanyListResponse();
		List<CompanyInfoResponse> companyList = new ArrayList<CompanyInfoResponse>();
		List<Company> cLsit = db.companyRepository.findAll();

		cLsit.stream().forEach(c -> {
			CompanyInfoResponse cInfo = new CompanyInfoResponse();

			cInfo.setCompanyId(c.getCompanyId());
			cInfo.setCompanyName(c.getCompanyName());
			companyList.add(cInfo);
		});
		companyListResponse.setCompanyBeanList(companyList);
		return companyListResponse;
	}

	public GenderListResponse getGendersList() {
		List<GenderResponse> genderBeanList = new ArrayList<GenderResponse>();
		GenderResponse genderResponse = new GenderResponse();
		genderResponse.setGenderId("M");
		genderResponse.setGenderDescription("MALE");
		genderBeanList.add(genderResponse);
		genderResponse = new GenderResponse();
		genderResponse.setGenderId("F");
		genderResponse.setGenderDescription("FEMALE");
		genderBeanList.add(genderResponse);

		GenderListResponse GenderListBean = new GenderListResponse();

		GenderListBean.setGenderBeanList(genderBeanList);
		// TODO Auto-generated method stub
		return GenderListBean;
	}

	public CarBrandListResponse getCarBrandList() {
		CarBrandListResponse carBrandListResponse = new CarBrandListResponse();
		List<CarBrand> brandLsit = db.carBrandRepository.findAll();
		List<CarBrandResponse> carBrandList = new ArrayList();
		brandLsit.stream().forEach(c -> {
			CarBrandResponse cr = new CarBrandResponse();
			cr.setCarBrandDescription(c.getCarBrandDescription());
			cr.setCarBrandId(c.getCarBrandId());
			carBrandList.add(cr);
		});
		carBrandListResponse.setCarBrandBeanList(carBrandList);

		return carBrandListResponse;
	}

	public CarTrademarkListResponse getCarTrademarkList(String carBrandId) {
		CarTrademarkListResponse carTrademarkListResponse = new CarTrademarkListResponse();
		List<CarTrademark> cardTradeMarkList = db.carTrademarkRepository.getTrademarksbyBrandId(carBrandId);
		List<CarTrademarkResponse> carTradeList = new ArrayList();
		cardTradeMarkList.stream().forEach(c -> {
			CarTrademarkResponse cr = new CarTrademarkResponse();
			cr.setCarTrademarkDescription(c.getCarTrademarkDescription());
			cr.setCarTrademarkId(c.getCarTrademarkId());
			carTradeList.add(cr);
		});
		carTrademarkListResponse.setCarTrademarkBeanList(carTradeList);

		return carTrademarkListResponse;
	}

	public DoorsListResponse getDoors() {
		DoorsListResponse doorsListResponse = new DoorsListResponse();
		List<DoorsResponse> doors = new ArrayList();
		List<Doors> doorsList = db.doorsRepository.findAll();
		doorsList.stream().forEach(d -> {
			DoorsResponse doorsResponse = new DoorsResponse();
			doorsResponse.setCode(d.getCode());
			doorsResponse.setDescription(d.getDescription());

			doors.add(doorsResponse);
		});

		doorsListResponse.setDoorsBeanList(doors);
		return doorsListResponse;
	}

	public BodyTypeListResponse getBodyType() {
		BodyTypeListResponse bodyTypeListResponse = new BodyTypeListResponse();
		List<BodyTypeResponse> bodytypes = new ArrayList();
		List<BodyType> body = db.bodyTypeRepository.findAll();
		body.stream().forEach(b -> {
			BodyTypeResponse bodyTypeResponse = new BodyTypeResponse();
			bodyTypeResponse.setCode(b.getCode());
			bodyTypeResponse.setDescription(b.getDescription());
			bodytypes.add(bodyTypeResponse);

		});
		bodyTypeListResponse.setBodyTypeBeanList(bodytypes);
		return bodyTypeListResponse;
	}

	public VehicleSizeListResponse getVehicleSize() {
		VehicleSizeListResponse vehicleSizeListResponse = new VehicleSizeListResponse();
		List<VehicleSizeResponse> veList = new ArrayList();
		List<VehicleSize> vsize = db.vehicleSizeRepository.findAll();
		vsize.stream().forEach(v -> {
			VehicleSizeResponse vehicleSizeResponse = new VehicleSizeResponse();
			vehicleSizeResponse.setCode(v.getCode());
			vehicleSizeResponse.setDescription(v.getDescription());
			veList.add(vehicleSizeResponse);
		});
		// TODO Auto-generated method stub
		vehicleSizeListResponse.setVehicleSizeBeanList(veList);
		return vehicleSizeListResponse;
	}

	public LitigationDamageLovListResponse getDescriptions() {
		LitigationDamageLovListResponse litigationDamageLovListResponse = new LitigationDamageLovListResponse();
		List<LitigationDamageLovResponse> damageLovResponses = new ArrayList();
		List<Reviews> reviewList = db.litigationRepository.findAll();
		reviewList.stream().forEach(l -> {
			LitigationDamageLovResponse damageLovResponse = new LitigationDamageLovResponse();
			damageLovResponse.setCode(l.getCode());
			damageLovResponse.setDescription(l.getDescription());
			damageLovResponses.add(damageLovResponse);
		});
		
		litigationDamageLovListResponse.setLitigationDamageLovBeanList(damageLovResponses);
		// TODO Auto-generated method stub
		return litigationDamageLovListResponse;
	}

	public PartGroupListResponse getPartGroup() {
		PartGroupListResponse groupListResponse = new PartGroupListResponse();
		List<PartGroupResponse> partGroupResponses = new ArrayList();
		List<PartGroup> partGrouplist = db.partGroupRepository.findAll();	
		partGrouplist.stream().forEach(p -> {
			PartGroupResponse groupResponse = new PartGroupResponse()	;
			groupResponse.setCode(p.getCode());
			groupResponse.setDescription(p.getDescription());
			partGroupResponses.add(groupResponse);
		});
		groupListResponse.setPartGroupBeanList(partGroupResponses);
		// TODO Auto-generated method stub
		return groupListResponse;
	}

	public DirectionsListResponse getDirections() {
		DirectionsListResponse directionsListResponse = new DirectionsListResponse();
		List<Direction> directions = db.directionsRepository.findAll();
		List<DirectionResponse> directionResponses = new ArrayList<>();
		directions.stream().forEach(d->{
	
			DirectionResponse directionResponse = new DirectionResponse();
			
			directionResponse.setCode(d.getCode());
			directionResponse.setDescription(d.getDescription());
			directionResponses.add(directionResponse);
		});
		directionsListResponse.setDirectionsListResponse(directionResponses);
		return directionsListResponse;
	}

	public PolicyTypeListResponse getPolicyType() {
		PolicyTypeListResponse policyTypeListResponse = new PolicyTypeListResponse();
		List<PolicyType> policyTypes = db.policyTypeRepository.getPolicyType();
		List<PolicyTypeResponse> policyTypeResponses = new ArrayList<>();
		policyTypes.stream().forEach(d->{
	
			PolicyTypeResponse policyTypeResponse = new PolicyTypeResponse();
			
			policyTypeResponse.setCode(d.getCode());
			policyTypeResponse.setDescription(d.getDescription());
			policyTypeResponses.add(policyTypeResponse);
		});
		policyTypeListResponse.setPolicyTypeResponseList(policyTypeResponses);
		return policyTypeListResponse;
	}

	public InsuranceCompanyListResponse getInsuranceCompany() {
		InsuranceCompanyListResponse insuranceCompanyListResponse = new    InsuranceCompanyListResponse();
		List<InsuranceCompany> companies=db.insuranceCompanyRepository.getInsuranceCompany();
		List<InsuranceCompanyResponse> companyResponses= new ArrayList<>();
		companies.stream().forEach(i->{
			
			InsuranceCompanyResponse insuranceCompanyResponse = new InsuranceCompanyResponse();
			
			insuranceCompanyResponse.setSupplierId(i.getSupplierId());
			insuranceCompanyResponse.setSupplierName(i.getSupplierName());
			companyResponses.add(insuranceCompanyResponse);
		});
		insuranceCompanyListResponse.setInsuranceCompanyResponseList(companyResponses);
		return insuranceCompanyListResponse;
	}

}

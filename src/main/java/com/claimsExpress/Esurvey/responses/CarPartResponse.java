package com.claimsExpress.Esurvey.responses;

import org.springframework.beans.factory.annotation.Value;

public interface CarPartResponse {
	
	
	@Value("#{target.PART_ID}")
	String getPartId();

	
	@Value("#{target.PART_DESCRIPTION}")
	String getPartDescription();

	@Value("#{target.PART_ARABIC_DESC}")
	String getPartArabicDescription();
	
	
	@Value("#{target.MET_COUNT}")
	Integer getMetCount();
	
	@Value("#{target.RELATED_COUNT}")
	Integer getRelatedCount();
	

}

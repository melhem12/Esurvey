package com.claimsExpress.Esurvey.responses;

import org.springframework.beans.factory.annotation.Value;

public interface PartMetResponse {
	
	
	@Value("#{target.PART_ID}")
	public String getPartId();
	
	@Value("#{target.PART_DESCRIPTION}")
	public String getPartDescription();

	@Value("#{target.PART_ARABIC_DESC}")
	public String getPartArabicDescription() ;

}

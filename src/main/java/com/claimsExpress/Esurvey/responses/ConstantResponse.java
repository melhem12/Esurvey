package com.claimsExpress.Esurvey.responses;

import org.springframework.beans.factory.annotation.Value;

public interface ConstantResponse {
@Value("#{target.CODE}")
 String getCode() ;
@Value("#{target.DESCRIPTION}")
 String getDescription() ;
@Value("#{target.CORE_DOMAIN_VALUE_ID}")
 String getCoreDomainValueId() ;
}

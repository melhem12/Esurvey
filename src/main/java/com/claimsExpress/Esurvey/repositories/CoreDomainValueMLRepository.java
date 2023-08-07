package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CoreDomainValueML;
import com.claimsExpress.Esurvey.responses.CarParts;
import com.claimsExpress.Esurvey.responses.ConstantResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CoreDomainValueMLRepository  extends JpaRepository<CoreDomainValueML, String> {
	//@Query(value="select code , description from CoreDomainValueML  c where  coreDomainValueId = ?1  and lang= ?2")
	//List <CoreDomainValueML> findByCoreDomainValueIdAndLang(String coreDomainValueId , String lang);

	@Query(value=" SELECT CODE, DESCRIPTION, CORE_DOMAIN_VALUE_ID "
			+ "	FROM CORE_DOMAIN_VALUE_ML "
			+ "	WHERE CORE_DOMAIN_ID= ?1 AND LNG=  ?2 ", nativeQuery = true)
	public List<ConstantResponse> getResp(String coreDomainValueId , String lang);
	
	@Query(value=" SELECT PART_ID,PART_DESCRIPTION,PART_ARABIC_DESC FROM CARS_PARTS WHERE PART_MET='PANEL' AND PART_TYPE='BODY' AND SUBSTR(PART_COMBINATION,1,2)='P1' ORDER BY 2 ", nativeQuery = true)
	
	public List<CarParts> getCarParts();

	
}

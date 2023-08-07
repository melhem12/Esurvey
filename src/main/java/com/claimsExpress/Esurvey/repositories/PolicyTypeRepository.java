package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.PolicyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PolicyTypeRepository  extends JpaRepository<PolicyType, String> {
	@Query("select  p from PolicyType p where code in  ('ALL','TPL','MOB')")
	List<PolicyType> getPolicyType();


}

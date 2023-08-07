package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsLossResp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CarLossRespRepository extends JpaRepository<CarsLossResp, String> {
	
	@Modifying
	@Query(value ="delete FROM CARS_LOSS_RESP where REP_STATUS_CAR_ID = ?1 AND TRUNC (SYS_CREATED_DATE) =  TRUNC(SYSDATE) AND SYS_CREATED_BY = trim(?2)  ", nativeQuery = true)
	void deleteByCarId(String carId,String userId) ;
}

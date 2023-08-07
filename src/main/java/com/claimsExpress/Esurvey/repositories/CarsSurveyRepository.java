package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CarsSurveyRepository extends JpaRepository<CarsSurvey, Long> {
	
	@Query(value = " SELECT COUNT(*) FROM CARS_SURVEY WHERE SURVEY_CAR_ID= ? ", nativeQuery = true)
	public Long  getCarsSurveyCount(String carId);

	@Modifying
@Query(value =" delete FROM CARS_SURVEY WHERE SURVEY_CAR_ID = trim(?1) AND TRUNC (SYS_CREATED_DATE) =  TRUNC(SYSDATE) AND SYS_CREATED_BY = trim(?2)", nativeQuery = true)
public void deleteBycarId(String carId,String userId) ;

	
}

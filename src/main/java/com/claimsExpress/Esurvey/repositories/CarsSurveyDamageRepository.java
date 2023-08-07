package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsSurveyDamage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CarsSurveyDamageRepository extends JpaRepository<CarsSurveyDamage, String> {

	@Query(value = "SELECT SURVEY_DAMAGED_SURVEY_ID FROM CARS_SURVEY_DAMAGED WHERE  SURVEY_DAMAGED_CAR_ID= ?1 ", nativeQuery = true)
	String findByCar(String carId);
	
	@Modifying
	@Query(value = " delete FROM CARS_SURVEY_DAMAGED  where SURVEY_DAMAGED_CAR_ID = trim(?1) AND TRUNC (SYS_CREATED_DATE) =  TRUNC(SYSDATE) AND SYS_CREATED_BY = trim(?2) ", nativeQuery = true)
	void deleteByCarId(String carId, String userId);



	@Query(value=" SELECT COUNT(*) FROM CARS_SURVEY_DAMAGED WHERE  SURVEY_DAMAGED_CAR_ID= ?1 ", nativeQuery = true)
	Integer  getCarsSurveyDamagedCount(String carId) ;
	
@Query("select c from CarsSurveyDamage c join fetch  c.surveyDamagedCarId s where s.carId = ?1")
	Optional<CarsSurveyDamage>  findBySurveyDamagedCarId(String carId) ;

@Modifying
@Query(value=" UPDATE CARS_SURVEY_DAMAGED SET"
		+ " SYS_UPDATED_DATE = sysdate , SYS_UPDATED_BY = :userId , "
		+ " SURVEY_DAMAGED_LOCKED_DATE = sysdate ,"
		+ "SURVEY_DAMAGED_LOCKED_USER   = trim(:userId) "
		+ " WHERE SURVEY_DAMAGED_CAR_ID  = :carId ", nativeQuery = true)
void finish(String carId, String userId);
}


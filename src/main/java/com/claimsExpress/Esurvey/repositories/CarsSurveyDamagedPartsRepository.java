package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsSurveyDamagedParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CarsSurveyDamagedPartsRepository extends JpaRepository<CarsSurveyDamagedParts, String> {


	
	@Query(value = "   SELECT SURVEY_DAMAGED_SURVEY_ID FROM CARS_SURVEY_DAMAGED WHERE  SURVEY_DAMAGED_CAR_ID= ?1  ", nativeQuery = true)
	public String  GetSurveyByCarId(String userId);
	
	@Query(value = "   SELECT SURVEY_DAMAGED_PARTS_ID FROM CARS_SURVEY_DAMAGED_PARTS WHERE (?1 is null or SURVEY_DAMAGED_SURVEY_ID = trim(?1)) ", nativeQuery = true)
	public  List<String> getAllDamagedParts(String surveyId);
	
	@Modifying
	@Query(value = "   delete FROM CARS_SURVEY_DAMAGED_PARTS WHERE SURVEY_DAMAGED_SURVEY_ID = trim(?1)  AND TRUNC (SYS_CREATED_DATE) =  TRUNC(SYSDATE) AND SYS_CREATED_BY = trim(?2)", nativeQuery = true)
	public  void deleteFromDamagePart(String surveyId ,String creatorUser);

	@Modifying
	@Query(value = "   delete FROM CARS_SURVEY_DAMAGED_PARTS WHERE  SURVEY_DAMAGED_SURVEY_ID = :surveyId ", nativeQuery = true)
	public void deleteDamagedParts(@Param("surveyId") String surveyId);
}

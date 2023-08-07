package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarLossCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CarLossCarRepository extends JpaRepository<CarLossCar, String> {
	 
	 
	@Query(value = "   SELECT MAX(VEHSEQ)+1  FROM  V_LOSS_CAR WHERE  NOTIFICATION = ?1  ", nativeQuery = true)
	public Integer  getSurveyCount(String notification);

	@Modifying
	@Query(value = "  delete FROM CARS_LOSS_CAR WHERE CAR_ID= trim(?1) AND TRUNC (CARS_LOSS_CAR.SYS_CREATED_DATE) =  TRUNC(SYSDATE) AND CARS_LOSS_CAR.SYS_CREATED_BY = trim(?2)  ", nativeQuery = true)
	public void deleteTp(String carId, String userId);

//	@Query(value = "UPDATE CARS_LOSS_CAR SET "
//			+ "SYS_UPDATED_DATE = sysdate , SYS_UPDATED_BY = ? ,  ", nativeQuery = true)
//	public void updateCarLossPersonalInformation(CarsLossRequest carsLossRequest);


}

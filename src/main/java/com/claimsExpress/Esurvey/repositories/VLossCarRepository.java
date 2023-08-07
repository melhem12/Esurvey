package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.VLossCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VLossCarRepository  extends JpaRepository<VLossCar, String> {
	@Query("select  v from  VLossCar v where  notification = ?1   and rownum <= 1  ")
Optional<VLossCar> findByNotification(Long notification) ;
	
	@Query("select  v from  VLossCar v where  carId = ?1   and rownum <= 1  ")
Optional<VLossCar> findByCarId(String carId) ;
	@Query("select  v from  VLossCar v where  notification = ?1  and vehSeq = 0  and rownum <= 1 ")
	Optional<VLossCar> findByNotificationAndVhesq(Long notification) ;

}

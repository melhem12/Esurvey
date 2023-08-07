package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsAppBodly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CarsAppBodlyRepository  extends JpaRepository<CarsAppBodly, String>{
	@Query("select  cb from CarsAppBodly cb   join fetch  cb.carsAppAccident ca     where ca.accidentId = ?1 ")

	Optional<CarsAppBodly> findByCarsAppAccident(String accidentId);

}

package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsAppPictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CarsAppPicturesRepository extends JpaRepository<CarsAppPictures, String>  {
	
	
	@Query("select  cp from CarsAppPictures cp   join fetch  cp.carsAppAccident ca     where ca.accidentId = ?1 ")
	Optional<CarsAppPictures>  findByCarsAppAccident(String id);
}

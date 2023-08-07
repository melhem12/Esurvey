package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface  DirectionsRepository  extends JpaRepository<Direction, String> {

	
	

	
}

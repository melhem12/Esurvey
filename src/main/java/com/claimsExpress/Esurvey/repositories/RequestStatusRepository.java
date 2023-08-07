package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RequestStatusRepository extends JpaRepository<RequestStatus, String> {

}

package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.PartGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PartGroupRepository extends JpaRepository<PartGroup, Long> {

}

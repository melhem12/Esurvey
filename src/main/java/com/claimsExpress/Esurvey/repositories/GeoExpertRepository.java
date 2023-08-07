
package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.GeoExpert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface GeoExpertRepository  extends JpaRepository<GeoExpert, String> {
 Optional<GeoExpert> findByGeoExpertId(String userId);
}

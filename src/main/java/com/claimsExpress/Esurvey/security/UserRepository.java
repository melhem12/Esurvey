package com.claimsExpress.Esurvey.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {



@Query(value = "select perm.CORE_ROLE_ID from CORE_USER_PROFILE prof , CORE_USER_PROFILE_PERM perm , CORE_COMPANY_PROFILE cProf " +
        " where  prof.CORE_USER_ID = ?1  and " +
        " prof.ID = perm.CORE_USER_PROFILE_ID and prof.CORE_COMPANY_PROFILE_ID = cProf.ID and cProf.CORE_PROFILE_ID = 'tema' ",nativeQuery = true)
        List<String> findRolesByUser(String userId);
    @Query(value = " SELECT CONFIG_VALUE from CORE_CONFIGURATION where ID = ?1 ", nativeQuery = true)
    String findConfigByKey(String key);
}

package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.CarsParts;
import com.claimsExpress.Esurvey.responses.CarPartResponse;
import com.claimsExpress.Esurvey.responses.PartMetResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CarPartsRepository extends JpaRepository<CarsParts, String> {

	@Query(value = "select p.PART_ID,p.PART_DESCRIPTION,p.PART_ARABIC_DESC,(select COUNT(*) from CARS_PARTS pMET, CARS_PARTS_DETAIL pdMET"
			+ " where pMET.PART_ID = pdMET.PART_PART_ID"
			+ " and (UPPER(pdMET.PART_CAR_TYPE) = UPPER(:bodyType)   or UPPER(pdMET.PART_CAR_TYPE) = 'ALL') "
			+ " and (UPPER(pMET.PART_SUBGROUP) = UPPER(:partSubgroup)  OR UPPER(p.PART_TYPE) = UPPER(:partSubgroup)  or NVL( :partSubgroup,'ALL') = 'ALL') "
			+ "and (UPPER(pdMET.PART_EXTERIOR) = UPPER(:doors) or UPPER(pdMET.PART_EXTERIOR) = 'COMMON') "
			+ "and  UPPER(pdMET.PART_MODEL) = UPPER('Generic') "
			+ "and (((SUBSTR(pMET.PART_COMBINATION,1,1) in('T','M') "
			+ "and (pdMET.PART_OPERATION in (select cMET.PART_OPERATION from CARS_PARTS_DETAIL cMET where cMET.PART_PART_ID= p.PART_ID and (UPPER(cMET.PART_CAR_TYPE) = UPPER(:bodyType)  or UPPER(cMET.PART_CAR_TYPE) = 'ALL') and UPPER(cMET.PART_MODEL) = UPPER('Generic'))) "
			+ "and  'MET' = 'MET' ) "
			+ " or ((UPPER(pMET.PART_DIRECTION) = UPPER('Left') OR NVL( 'Left','ALL') = 'ALL' ) "
			+ "and (UPPER(pMET.PART_COMBINATION) = UPPER('M1') OR NVL( 'M1','ALL') = 'ALL' ) "
			+ "and (UPPER(pMET.PART_GROUP_CODE) = UPPER('BODY') or NVL( 'BODY','ALL') = 'ALL' ) and NVL( :partSubgroup,'SUBGROUP') = 'SUBGROUP' ))) ) MET_COUNT, "
			+ " (select COUNT(*) from CARS_PARTS pREL, CARS_PARTS_DETAIL pdREL  "
			+ "where pREL.PART_ID = pdREL.PART_PART_ID "
			+ "and (UPPER(pdREL.PART_CAR_TYPE) = UPPER(:bodyType)   or UPPER(pdREL.PART_CAR_TYPE) = 'ALL') "
			+ "and (UPPER(pREL.PART_SUBGROUP) = UPPER(:partSubgroup)  OR UPPER(p.PART_TYPE) = UPPER(:partSubgroup)  or NVL( :partSubgroup,'ALL') = 'ALL') "
			+ "and (UPPER(pdREL.PART_EXTERIOR) = UPPER(:doors) or UPPER(pdREL.PART_EXTERIOR) = 'COMMON')"
			+ "and  UPPER(pdREL.PART_MODEL) = UPPER('Generic') "
			+ "AND pREL.PART_COMBINATION is null AND pdREL.PART_OPERATION = pd.PART_OPERATION) RELATED_COUNT "
			+ "from CARS_PARTS p, CARS_PARTS_DETAIL pd " + " where p.PART_ID = pd.PART_PART_ID "
			// + "and p.PART_COMBINATION is not null "
			+ "and (UPPER(pd.PART_CAR_TYPE) = UPPER(:bodyType) or UPPER(pd.PART_CAR_TYPE) = 'ALL') "
			+ "and (UPPER(pd.PART_EXTERIOR) = UPPER(:doors) OR UPPER(pd.PART_EXTERIOR) = 'COMMON') "
			+ "and  UPPER(pd.PART_MODEL) = UPPER('Generic') "

			+ "and (UPPER(p.PART_SUBGROUP) = UPPER(:partSubgroup) OR UPPER(p.PART_TYPE) = UPPER(:partSubgroup) OR NVL( :partSubgroup,'ALL') = 'ALL') "
			// + "and (UPPER(p.PART_SUBGROUP) = UPPER('BRAKE SYSTEM') OR UPPER(p.PART_TYPE)
			// = UPPER('BRAKE SYSTEM') OR NVL( :partSubgroup,'ALL') = 'ALL') "
			+ "  and   ( (:description is null or  UPPER(p.PART_DESCRIPTION) like '%'||UPPER(:description)||'%') or (:description is null or  UPPER(p.PART_ARABIC_DESC) like '%'||UPPER(:description)||'%') )  "

			+ "   and ((UPPER(p.PART_DIRECTION) = UPPER(:direction) OR NVL( UPPER(:direction),'ALL') = 'ALL' ))  "

			// + "and upper(p.PART_SUBGROUP) = UPPER(:partSubgroup) "
			+ "order by  p.PART_DESCRIPTION ", nativeQuery = true)
	List<CarPartResponse> getCarParts(@Param("partSubgroup") String partSubgroup,
			@Param("description") String description, @Param("bodyType") String bodyType, @Param("doors") String doors
			,@Param("direction") String direction);
	// List<CarPartResponse> getCarParts(@Param("partSubgroup") String partSubgroup,
	// @Param("bodyType") String bodyType, @Param("doors") String doors);

	@Query(value = "   select PART_ID,PART_DESCRIPTION,PART_ARABIC_DESC from CARS_PARTS p, CARS_PARTS_DETAIL pd  "
			+ "where p.PART_ID = pd.PART_PART_ID  "
			+ " and (UPPER(pd.PART_CAR_TYPE) = UPPER(:bodyType)   or UPPER(pd.PART_CAR_TYPE) = 'ALL') "
			+ " and (UPPER(p.PART_SUBGROUP) = UPPER(:partSubgroup)   or NVL(:partSubgroup,'ALL') = 'ALL')   "
			+ "   and (UPPER(pd.PART_EXTERIOR) = UPPER(:doors) or UPPER(pd.PART_EXTERIOR) = 'COMMON') "
			+ "  and  UPPER(pd.PART_MODEL) = UPPER('Generic')   "
			+ "     and (((SUBSTR(p.PART_COMBINATION,1,1) in('T','M') "
			+ " and (pd.PART_OPERATION in (select c.PART_OPERATION from CARS_PARTS_DETAIL c where c.PART_PART_ID= :partId and (UPPER(c.PART_CAR_TYPE) = UPPER(:bodyType)  or UPPER(c.PART_CAR_TYPE) = 'ALL') and UPPER(c.PART_MODEL) = UPPER('Generic')))  "
			+ "       and  'MET' = 'MET' )  "
			+ "   or ((UPPER(p.PART_DIRECTION) = UPPER('Left') OR NVL( 'Left','ALL') = 'ALL' )  "
			+ "  and (UPPER(p.PART_COMBINATION) = UPPER('M1') OR NVL( 'M1','ALL') = 'ALL' ) "
			+ "  and (UPPER(p.PART_GROUP_CODE) = UPPER('BODY') or NVL( 'BODY','ALL') = 'ALL' ) and NVL( :partSubgroup,'SUBGROUP') = 'SUBGROUP' )))  "

			, nativeQuery = true)
	List<PartMetResponse> getCPartMet(@Param("partId") String partId, @Param("partSubgroup") String partSubgroup,
			@Param("bodyType") String bodyType, @Param("doors") String doors);

}

package com.claimsExpress.Esurvey.repositories;

import com.claimsExpress.Esurvey.models.UserPreference;
import com.claimsExpress.Esurvey.models.VLossCar2;
import com.claimsExpress.Esurvey.responses.ClaimCarDetailResponse;
import com.claimsExpress.Esurvey.responses.ClaimDetailResponse;
import com.claimsExpress.Esurvey.responses.ClaimResponse;
import com.claimsExpress.Esurvey.responses.HistoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface VLossCar2Repository extends JpaRepository<VLossCar2, String> {
	
	

	@Query(value = "SELECT count (DISTINCT NOTIFICATION) FROM  V_LOSS_CAR2, CARS_INSURANCE   WHERE  V_LOSS_CAR2.INSCOMPANYCODE = CARS_INSURANCE.INSURANCE_ID"
			+ "  AND    NVL(INSURANCE_ID,0) = ?1 "
			+ " AND NOTIFICATION_MAT_DAMAGE <>'6' AND CLAIMSTATUSCODE <>'8' "
			+ " AND   (?2 is null or NOTIFICATION = trim(?2)) " + "  AND  (?3 is null or POLICYNUMBER = trim(?3)) "
			+ "AND   (?4 is null or PLATE_CHAR LIKE '%' || upper(trim(?4)) ||'%' )  "
			+ " AND (?5 is null or PLATE_NUM LIKE '%' || upper(trim(?5)) ||'%' ) ", nativeQuery = true)
	public Long count(String insuranceId, String notification, String policyNumber, String plateCharacter,
			String plate);

	@Query(value = "SELECT DISTINCT NOTIFICATION ,NOTIFICATIONID, CLAIMSTATUSCODE,REPORTEDDATE, INSCOMPANYCODE FROM  V_LOSS_CAR2, CARS_INSURANCE   WHERE  V_LOSS_CAR2.INSCOMPANYCODE = CARS_INSURANCE.INSURANCE_ID"
			+ "  AND    NVL(INSURANCE_ID,0) = ?1 "
			+ " AND NOTIFICATION_MAT_DAMAGE <>'6' AND CLAIMSTATUSCODE <>'8' "
			+ " AND   (?2 is null or NOTIFICATION = trim(?2)) " + "  AND  (?3 is null or POLICYNUMBER = trim(?3)) "
			+ "AND   (?4 is null or PLATE_CHAR LIKE '%' || upper(trim(?4)) ||'%' )  "
			+ " AND (?5 is null or PLATE_NUM LIKE '%' || upper(trim(?5)) ||'%' )"
			+ " ORDER BY CLAIMSTATUSCODE,REPORTEDDATE DESC ", nativeQuery = true)
	public List<ClaimResponse> search(String insuranceId, String notification, String policyNumber, String plateCharacter,
			String plate);
	
	@Query(value = "SELECT count(*) from core_user  where (?1 is null or core_user = trim(?1)) and  (?2 is null or PWD_ENCRYPTED = trim(?2) ", nativeQuery = true)
	public UserPreference authenticate(String userId, String password);

	
	@Query(value = "SELECT notificationid, carid , NOTIFICATION pasNumber,OWNERNAME VehicleOwnerName,"
			+ "OWNER_PHONE phoneNumber,CAR_DRIVER_LICENSE_NBR licenseNumber,BRANDTRADEMARK,YEARMAN  modelYear,"
			+ "PLATE plateNumber, POLICYNUM policyNumber, VEHSEQ vehicleNumber,TO_CHAR(REPORTEDDATE,'YYYY/MM/DD') reportedDate,TO_CHAR(ACCIDENTDATE,'YYYY/MM/DD') lossDate,"
			+ " ACCIDENTTOWN accidentLocation,csd.SURVEY_DAMAGED_LOCKED_USER FROM  V_LOSS_CAR2, CARS_INSURANCE, CARS_LOSS_CAR,CARS_SURVEY_DAMAGED csd WHERE  V_LOSS_CAR2.INSCOMPANYCODE = CARS_INSURANCE.INSURANCE_ID AND CAR_ID = CARID AND csd.SURVEY_DAMAGED_CAR_ID(+) = CARID"
			+ " AND   (?2 is null or INSURANCE_ID = trim(?2)) "
			+ "AND NOTIFICATION_MAT_DAMAGE <>'6' AND CLAIMSTATUSCODE <>'8'"
			+ "AND (?1 is null or NOTIFICATIONID = trim(?1))"
			+ " ORDER BY VEHSEQ ", nativeQuery = true)
	public List<ClaimDetailResponse> getDetails(String notificationId, String companyCode);

	
	@Query(value = " SELECT notificationid, carid , NOTIFICATION pasNumber,OWNERNAME VehicleOwnerName, CAR_OWNER_FIRST_NAME, CAR_OWNER_FATHER_NAME, CAR_OWNER_MAINDEN, CAR_OWNER_FAMILY_NAME, "
			+ "  CARS_LOSS_CAR.CAR_OWNER_PHONE phoneNumber,CAR_DRIVER_LICENSE_NBR licenseNumber,  TO_CHAR(CAR_DRIVER_LICENSE_INCP_DTE,'DD/MM/YYYY')licenseDate,TO_CHAR(CAR_DRIVER_LICENSE_EXP_DTE,'DD/MM/YYYY') licenseExpiryDate, "
			+ " V_LOSS_CAR2.BRAND_ID,  (SELECT TRADEMARK_CODE FROM BRAND_TRADEMARK_SHAPE_LOV_VW WHERE SHAPE_CODE = CAR_SHAPE_ID)CAR_TRADEMARK_ID, CAR_SHAPE_ID ShapeId, BRANDTRADEMARK,  YEARMAN  modelYear, "
			+ " CARCHASSISS chassisNumber,PLATE plateNumber, POLICYNUM policyNumber, NVL(INSURANCE_NODE_ID,0) insurerCode, VEHSEQ vehicleNumber,   "
			+ "CLAIMSTATUS claimStatus, TO_CHAR(REPORTEDDATE,'DD/MM/YYYY') reportedDate,TO_CHAR(ACCIDENTDATE,'DD/MM/YYYY') lossDate,  "
			+ " ACCIDENTTOWN accidentLocation, CLAIM_NUMBER, csd.SURVEY_DAMAGED_VEHICLE_SIZE, csd.SURVEY_DAMAGED_BODY_TYPE,csd.SURVEY_DAMAGED_DOORS , CAR_THRDP_INS_CMPNY_ID, CAR_POLICY_TYPE "
			+ " FROM  V_LOSS_CAR2, CARS_INSURANCE, CARS_LOSS_CAR,CARS_SURVEY_DAMAGED csd "
			+ "WHERE  V_LOSS_CAR2.INSCOMPANYCODE = CARS_INSURANCE.INSURANCE_ID "
			+ " AND CAR_ID = CARID "
			+ "AND csd.SURVEY_DAMAGED_CAR_ID(+)=CARID "
			+ " AND    (?2 is null or NVL(INSURANCE_ID,0) = trim(?2)) "
			+ " AND NOTIFICATION_MAT_DAMAGE <>'6'  AND CLAIMSTATUSCODE <>'8' "
			+ "AND (?1 is null or carid = trim(?1))"
			+ "ORDER BY VEHSEQ ", nativeQuery = true)
	public List<ClaimCarDetailResponse> getCarDetail(String carId, String companyCode);

	
	@Query(value = " SELECT DISTINCT NOTIFICATION ,NOTIFICATIONID, CLAIMSTATUSCODE,REPORTEDDATE,INSCOMPANYCODE "
			+ " FROM V_LOSS_CAR, CARS_SURVEY_REQUEST "
			+ " WHERE V_LOSS_CAR.CLAIMSTATUSCODE <> '8' "
			+ " AND TRUNC (CARS_SURVEY_REQUEST.SURVEY_DISPATCH_DATE) =  TRUNC(SYSDATE) "
			+ "  AND SURVEY_REQUEST_CAR_ID = CARID AND NVL (SURVEY_REQUEST_CANCELED, 'N') = 'N'"
			+ " AND SURVEY_REQUEST_SURVEYOR_ID IN ( SELECT SUPPLIER_ID FROM CARS_SUPPLIER WHERE (?1 is null or SUPPLIER_CORE_USER_ID = trim(?1))) ", nativeQuery = true)
	public List<ClaimResponse> getDailySurvey(String userId);
	
	@Query(value = "   SELECT count  (Distinct NOTIFICATION)  "
			+ " FROM V_LOSS_CAR, CARS_SURVEY_REQUEST "
			+ " WHERE V_LOSS_CAR.CLAIMSTATUSCODE <> '8' "
			+ " AND TRUNC (CARS_SURVEY_REQUEST.SURVEY_DISPATCH_DATE) =  TRUNC(SYSDATE) "
			+ "  AND SURVEY_REQUEST_CAR_ID = CARID AND NVL (SURVEY_REQUEST_CANCELED, 'N') = 'N'"
			+ " AND SURVEY_REQUEST_SURVEYOR_ID IN ( SELECT SUPPLIER_ID FROM CARS_SUPPLIER WHERE (?1 is null or SUPPLIER_CORE_USER_ID = trim(?1))) ", nativeQuery = true)
	public Long  getSurveyCount(String userId);
	
	
//	SELECT DECODE(SURVEY_SEQUENCE,'0','Survey','Re-Survey') SURVEY,
//
//	(SELECT SUPPLIER_NAME FROM CARS_SUPPLIER WHERE  SUPPLIER_ID = SURVEY_PLACE) SURVEYED_PLACE,
//
//	NOTIFICATION VISA,INS_TP INSURED_TP,BRANDTRADEMARK,PLATE,YEARMAN,
//
//	TRUNC(CARS_SURVEY.SURVEY_DATE)  SURVEY_RECEIVED,
//
//	(SELECT SUPPLIER_NAME FROM CARS_SUPPLIER WHERE  SUPPLIER_ID = SURVEY_SUPPLIER_ID) SURVEYED_BY,
//
//	INSCOMPANY
//	 ,CARS_SURVEY.SURVEY_DATE
//
//	FROM CARS_SURVEY, V_LOSS_CAR2
//
//	WHERE CARID=SURVEY_CAR_ID
//
//	AND TRUNC(CARS_SURVEY.SURVEY_DATE) BETWEEN '01-JUN-2021' AND '30-JUN-2021'
//  AND CARS_SURVEY.SYS_CREATED_BY = trim('MMEHDI') 
//  AND   ( '319401617' is null or V_LOSS_CAR2.NOTIFICATION  = trim('319401617'))
//  AND   V_LOSS_CAR2.INSCOMPANYID = '11';

	@Query(value = " SELECT  DECODE(SURVEY_SEQUENCE,'0','Survey','Re-Survey') SURVEY, "
			+ " (SELECT SUPPLIER_NAME FROM CARS_SUPPLIER WHERE  SUPPLIER_ID = SURVEY_PLACE) SURVEYED_PLACE, "
			+ " NOTIFICATION VISA,INS_TP INSURED_TP,BRANDTRADEMARK,PLATE,YEARMAN, "
			+ " TRUNC(CARS_SURVEY.SURVEY_DATE)  SURVEY_RECEIVED, "
			+ " (SELECT SUPPLIER_NAME FROM CARS_SUPPLIER WHERE  SUPPLIER_ID = SURVEY_SUPPLIER_ID) SURVEYED_BY, "
			+ " INSCOMPANY , "
			+ "  CARS_SURVEY.SURVEY_DATE "
			+ "FROM CARS_SURVEY, V_LOSS_CAR2 "
			+ " WHERE CARID=SURVEY_CAR_ID  "
			+ " AND TRUNC( CARS_SURVEY.SURVEY_DATE) BETWEEN :fr AND :t "
			+ " AND CARS_SURVEY.SYS_CREATED_BY = trim(:userId) "
			+ "	AND   ( :passNumber is null or V_LOSS_CAR2.NOTIFICATION  = trim(:passNumber)) "
			+ " AND   V_LOSS_CAR2.INSCOMPANYID = :companyCode ", nativeQuery = true)
	
	public List<HistoryResponse> searchSurvey(@Param("userId")String userId,@Param("passNumber")String passNumber ,@Param("fr") String fr ,@Param("t") String t  ,@Param("companyCode") String companyCode );

	
}

package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="CARS_PARTS")
@EntityListeners(AuditingEntityListener.class)
public class CarsParts implements Cloneable {

	private static Log logger = LogFactory.getLog(CarsParts.class);

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PART_ID")
	private String partId;

	@Column(name="PART_DESCRIPTION")
	private String partDescription;

	@Column(name="PART_ARABIC_DESC")
	private String partArabicDescription;

	@Column(name="PART_TYPE")
	private String partType;

	@Column(name="PART_REPAIR")
	private String partRepair;

	@Column(name="PART_MOST_COMMUNLY_USED")
	private Integer partMostCommunlyUsed;

	@Column(name="PART_GROUP_CODE")
	private String partGroupCode;

	@Column(name="PART_SUBGROUP")
	private String partSubGroup;

	@Column(name="PART_DIRECTION")
	private String partDirection;

	@Column(name="PART_CODE")
	private String partCode;

	@Column(name="PART_COMBINATION")
	private String partCombination;

	@Column(name="PART_MET")
	private String partMet;

	@Column(name="SYS_VERSION_NUMBER")
	private Integer sysVersionNumber;

	@Column(name="SYS_CREATED_DATE")
	private java.sql.Timestamp sysCreatedDate;

	@Column(name="SYS_CREATED_BY")
	private String sysCreatedBy;

	@Column(name="SYS_UPDATED_DATE")
	private java.sql.Timestamp sysUpdatedDate;

	@Column(name="SYS_UPDATED_BY")
	private String sysUpdatedBy;

	@Column(name="PART_OPINION_MANUAL")
	private String partOpinionManual;

	@Column(name="PART_ORDER")
	private Integer partOrder;

	public CarsParts() {
		super();
	}

	public CarsParts(String partId) {
		super();

		this.setPartId(partId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPartArabicDescription() {
		return partArabicDescription;
	}

	public void setPartArabicDescription(String partArabicDescription) {
		this.partArabicDescription = partArabicDescription;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartRepair() {
		return partRepair;
	}

	public void setPartRepair(String partRepair) {
		this.partRepair = partRepair;
	}

	public String getPartGroupCode() {
		return partGroupCode;
	}

	public void setPartGroupCode(String partGroupCode) {
		this.partGroupCode = partGroupCode;
	}

	public String getPartSubGroup() {
		return partSubGroup;
	}

	public void setPartSubGroup(String partSubGroup) {
		this.partSubGroup = partSubGroup;
	}

	public String getPartDirection() {
		return partDirection;
	}

	public void setPartDirection(String partDirection) {
		this.partDirection = partDirection;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartCombination() {
		return partCombination;
	}

	public void setPartCombination(String partCombination) {
		this.partCombination = partCombination;
	}

	public String getPartMet() {
		return partMet;
	}

	public void setPartMet(String partMet) {
		this.partMet = partMet;
	}

	public Integer getSysVersionNumber() {
		return sysVersionNumber;
	}

	public void setSysVersionNumber(Integer sysVersionNumber) {
		this.sysVersionNumber = sysVersionNumber;
	}

	public java.sql.Timestamp getSysCreatedDate() {
		return sysCreatedDate;
	}

	public void setSysCreatedDate(java.sql.Timestamp sysCreatedDate) {
		this.sysCreatedDate = sysCreatedDate;
	}

	public String getSysCreatedBy() {
		return sysCreatedBy;
	}

	public void setSysCreatedBy(String sysCreatedBy) {
		this.sysCreatedBy = sysCreatedBy;
	}

	public java.sql.Timestamp getSysUpdatedDate() {
		return sysUpdatedDate;
	}

	public void setSysUpdatedDate(java.sql.Timestamp sysUpdatedDate) {
		this.sysUpdatedDate = sysUpdatedDate;
	}

	public String getSysUpdatedBy() {
		return sysUpdatedBy;
	}

	public void setSysUpdatedBy(String sysUpdatedBy) {
		this.sysUpdatedBy = sysUpdatedBy;
	}

	public String getPartOpinionManual() {
		return partOpinionManual;
	}

	public void setPartOpinionManual(String partOpinionManual) {
		this.partOpinionManual = partOpinionManual;
	}

	public Integer getPartMostCommunlyUsed() {
		return partMostCommunlyUsed;
	}

	public void setPartMostCommunlyUsed(Integer partMostCommunlyUsed) {
		this.partMostCommunlyUsed = partMostCommunlyUsed;
	}

	public Integer getPartOrder() {
		return partOrder;
	}

	public void setPartOrder(Integer partOrder) {
		this.partOrder = partOrder;
	}

}

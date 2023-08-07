package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CARS_SUPPLIER")
@EntityListeners(AuditingEntityListener.class)
public class InsuranceCompany {
	@Id
	@Column(name="SUPPLIER_ID")
	private String supplierId;
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}

package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CARS_SUPPLIER")
@EntityListeners(AuditingEntityListener.class)
public class CarsSupplier {

	@Id
	@Column(name="SUPPLIER_ID")
	private String carSupkey;
	@Column(name="SUPPLIER_CORE_USER_ID" )
	private String supplierCoreUserId;
	public String getCarSupkey() {
		return carSupkey;
	}
	public void setCarSupkey(String carSupkey) {
		this.carSupkey = carSupkey;
	}
	public String getSupplierCoreUserId() {
		return supplierCoreUserId;
	}
	public void setSupplierCoreUserId(String supplierCoreUserId) {
		this.supplierCoreUserId = supplierCoreUserId;
	}
	
}

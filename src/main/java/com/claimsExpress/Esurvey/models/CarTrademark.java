package com.claimsExpress.Esurvey.models;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CARS_CAR_TRADEMARK")
@EntityListeners(AuditingEntityListener.class)
public class CarTrademark  implements Cloneable {

	private static Log logger = LogFactory.getLog(CarTrademark.class);

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CAR_TRADEMARK_ID")
	private String carTrademarkId;
	@Column(name="CAR_TRADEMARK_DESCRIPTION")

	private String carTrademarkDescription;

@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="carBrandId",nullable=false)
	private CarBrand carBrand;

	public CarTrademark() {
		super();
	}

	public CarTrademark(String carTrademarkId) {
		super();

		this.setCarTrademarkId(carTrademarkId);
	}








	public String getCarTrademarkId() {
		return carTrademarkId;
	}

	public void setCarTrademarkId(String carTrademarkId) {
		this.carTrademarkId = carTrademarkId;
	}

	public String getCarTrademarkDescription() {
		return carTrademarkDescription;
	}

	public void setCarTrademarkDescription(String carTrademarkDescription) {
		this.carTrademarkDescription = carTrademarkDescription;
	}

	public CarBrand getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	


}

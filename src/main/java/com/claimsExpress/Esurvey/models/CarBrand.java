package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CARS_CAR_BRAND")
@EntityListeners(AuditingEntityListener.class)
public class CarBrand  implements Cloneable {

	private static Log logger = LogFactory.getLog(CarBrand.class);
	@Id
	@Column(name="CAR_BRAND_ID")
	private String carBrandId;

	@Column(name="CAR_BRAND_DESCRIPTION")

	private String carBrandDescription;

	public CarBrand() {
		super();
	}

	public CarBrand(String carBrandId) {
		super();

		this.setCarBrandId(carBrandId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(String carBrandId) {
		this.carBrandId = carBrandId;
	}

	public String getCarBrandDescription() {
		return carBrandDescription;
	}

	public void setCarBrandDescription(String carBrandDescription) {
		this.carBrandDescription = carBrandDescription;
	}

}

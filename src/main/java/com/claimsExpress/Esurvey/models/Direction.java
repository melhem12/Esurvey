package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="PART_DIRECTION_LOV_VW")
@EntityListeners(AuditingEntityListener.class)
public class Direction implements Cloneable {
	@Id
	@Column(name="CODE")
	private String code;

	@Column(name="DESCRIPTION")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	


}
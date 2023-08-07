package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CORE_COMPANY")
@EntityListeners(AuditingEntityListener.class)
public class Company  implements Cloneable {

	private static Log logger = LogFactory.getLog(Company.class);

	private static final long serialVersionUID = 1L;
	@Id
@Column(name="ID")
	private Integer companyId;
@Column(name="NAME")

	private String companyName;
@Column(name="ADDRESS_INFO")

	private String companyAddress;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Company() {
		super();
	}

	public Company(Integer companyId) {
		super();

		this.setCompanyId(companyId);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	



}

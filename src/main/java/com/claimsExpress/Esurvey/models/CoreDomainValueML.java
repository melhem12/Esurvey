package com.claimsExpress.Esurvey.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="CORE_DOMAIN_VALUE_ML")
@EntityListeners(AuditingEntityListener.class)
public class CoreDomainValueML {
	@Id
	@Column(name="CODE ")
	private String code ;
	@Column(name="DESCRIPTION ")
	private String description ;
	@Column(name="CORE_DOMAIN_VALUE_ID")
	private String coreDomainValueId ;
	
	
	@Column(name="LNG")
	private String lang ;
	
	
	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public CoreDomainValueML() {
	}
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
	public String getCoreDomainValueId() {
		return coreDomainValueId;
	}
	public void setCoreDomainValueId(String coreDomainValueId) {
		this.coreDomainValueId = coreDomainValueId;
	}
	
	}

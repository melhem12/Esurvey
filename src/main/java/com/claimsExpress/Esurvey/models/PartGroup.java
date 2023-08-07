package com.claimsExpress.Esurvey.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="PART_GROUP_LOV_VW")
@EntityListeners(AuditingEntityListener.class)
public class PartGroup  implements Cloneable {

	private static Log logger = LogFactory.getLog(Company.class);

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CODE")
	private String code;

	@Column(name="DESCRIPTION")
	private String description;

	public PartGroup() {
		super();
	}

	public PartGroup(String code) {
		super();

		this.setCode(code);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
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

}

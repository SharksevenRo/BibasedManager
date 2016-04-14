package com.nchu.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbScopeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TbScopeId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer scope;
	private Integer type;

	// Constructors

	/** default constructor */
	public TbScopeId() {
	}

	/** full constructor */
	public TbScopeId(Integer id, Integer scope, Integer type) {
		this.id = id;
		this.scope = scope;
		this.type = type;
	}

	// Property accessors

	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "scope")
	public Integer getScope() {
		return this.scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbScopeId))
			return false;
		TbScopeId castOther = (TbScopeId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getScope() == castOther.getScope()) || (this
						.getScope() != null && castOther.getScope() != null && this
						.getScope().equals(castOther.getScope())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getScope() == null ? 0 : this.getScope().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}
package com.nchu.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbRoleFunctionId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TbRoleFunctionId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private Short functionUrl;

	// Constructors

	/** default constructor */
	public TbRoleFunctionId() {
	}

	/** full constructor */
	public TbRoleFunctionId(Integer id, Integer roleId, Short functionUrl) {
		this.id = id;
		this.roleId = roleId;
		this.functionUrl = functionUrl;
	}

	// Property accessors

	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "roleId", nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "functionUrl", nullable = false)
	public Short getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(Short functionUrl) {
		this.functionUrl = functionUrl;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbRoleFunctionId))
			return false;
		TbRoleFunctionId castOther = (TbRoleFunctionId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getFunctionUrl() == castOther.getFunctionUrl()) || (this
						.getFunctionUrl() != null
						&& castOther.getFunctionUrl() != null && this
						.getFunctionUrl().equals(castOther.getFunctionUrl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37
				* result
				+ (getFunctionUrl() == null ? 0 : this.getFunctionUrl()
						.hashCode());
		return result;
	}

}
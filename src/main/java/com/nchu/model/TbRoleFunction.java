package com.nchu.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbRoleFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_role_function", catalog = "bibased")
public class TbRoleFunction implements java.io.Serializable {

	// Fields

	private TbRoleFunctionId id;
	private TbRole tbRole;

	// Constructors

	/** default constructor */
	public TbRoleFunction() {
	}

	/** full constructor */
	public TbRoleFunction(TbRoleFunctionId id, TbRole tbRole) {
		this.id = id;
		this.tbRole = tbRole;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "roleId", column = @Column(name = "roleId", nullable = false)),
			@AttributeOverride(name = "functionUrl", column = @Column(name = "functionUrl", nullable = false)) })
	public TbRoleFunctionId getId() {
		return this.id;
	}

	public void setId(TbRoleFunctionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", nullable = false, insertable = false, updatable = false)
	public TbRole getTbRole() {
		return this.tbRole;
	}

	public void setTbRole(TbRole tbRole) {
		this.tbRole = tbRole;
	}

}
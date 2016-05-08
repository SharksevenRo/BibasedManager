package com.nchu.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TbScope entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_scope", catalog = "bibased")
public class TbScope  implements java.io.Serializable {

	// Fields

	private TbScopeId id;

	// Constructors

	/** default constructor */
	public TbScope() {
	}

	/** full constructor */
	public TbScope(TbScopeId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id")),
			@AttributeOverride(name = "scope", column = @Column(name = "scope")),
			@AttributeOverride(name = "type", column = @Column(name = "type")) })
	public TbScopeId getId() {
		return this.id;
	}

	public void setId(TbScopeId id) {
		this.id = id;
	}

}
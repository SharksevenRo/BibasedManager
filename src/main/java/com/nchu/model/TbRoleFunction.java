package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	private Integer id;
	private Integer roleId;
	private Integer parentId;
	private String functionUrl;
	private String name;
	

	// Constructors

	/** default constructor */
	public TbRoleFunction() {
	}

	/** full constructor */
	public TbRoleFunction(Integer roleid,String functionUrl) {
		this.roleId=roleid;
		this.functionUrl = functionUrl;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "functionurl", nullable = false)
	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}
	@Column(name = "roleid", nullable = false)
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Column(name = "parentid", nullable = false)
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

}
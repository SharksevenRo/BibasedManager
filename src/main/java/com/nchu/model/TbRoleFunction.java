package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	public TbRoleFunction(Integer roleId, String functionUrl) {
		this.roleId = roleId;
		this.functionUrl = functionUrl;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "roleid", nullable = false)
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "functionurl", nullable = false)
	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "parentid", nullable = false)
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
}
package com.nchu.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_role", catalog = "bibased")
public class TbRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private Set<TbRoleFunction> tbRoleFunctions = new HashSet<TbRoleFunction>(0);
	private Set<TbUser> tbUsers = new HashSet<TbUser>(0);

	// Constructors

	/** default constructor */
	public TbRole() {
	}

	/** full constructor */
	public TbRole(String roleName, Set<TbRoleFunction> tbRoleFunctions,
			Set<TbUser> tbUsers) {
		this.roleName = roleName;
		this.tbRoleFunctions = tbRoleFunctions;
		this.tbUsers = tbUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "roleName", length = 10)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbRole")
	public Set<TbRoleFunction> getTbRoleFunctions() {
		return this.tbRoleFunctions;
	}

	public void setTbRoleFunctions(Set<TbRoleFunction> tbRoleFunctions) {
		this.tbRoleFunctions = tbRoleFunctions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbRole")
	public Set<TbUser> getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set<TbUser> tbUsers) {
		this.tbUsers = tbUsers;
	}

}
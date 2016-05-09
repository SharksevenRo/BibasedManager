package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_user", catalog = "bibased")
public class TbUser  implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private String name;
	private String code;
	private String phone;
	private String password;
	private Integer teacher;

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** minimal constructor */
	public TbUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public TbUser(Integer roleId, String name,
			String code, String phone, String password) {
		this.roleId = roleId;
		this.name = name;
		this.code = code;
		this.phone = phone;
		this.password = password;
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


	@Column(name = "roleid", length = 20)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", length = 30)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTeacher() {
		return teacher;
	}
	@Column(name = "teacher")
	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}
	
	
}
package com.nchu.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_task", catalog = "bibased")
public class TbTask implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private String name;
	private Integer parentId;
	private Date limitime;
	private String descrption;
	private Integer scope;

	// Constructors

	/** default constructor */
	public TbTask() {
	}

	/** full constructor */
	public TbTask(TbUser tbUser, String name, Integer parentId, Date limitime,
			String descrption, Integer scope) {
		this.tbUser = tbUser;
		this.name = name;
		this.parentId = parentId;
		this.limitime = limitime;
		this.descrption = descrption;
		this.scope = scope;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher")
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parentId")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "limitime", length = 10)
	public Date getLimitime() {
		return this.limitime;
	}

	public void setLimitime(Date limitime) {
		this.limitime = limitime;
	}

	@Column(name = "descrption", length = 65535)
	public String getDescrption() {
		return this.descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	@Column(name = "scope")
	public Integer getScope() {
		return this.scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

}
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
public class TbTask  implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser owner;
	private Integer publisher;
	private String name;
	private Integer parentid;
	private Date limitime;
	private String description;
	private Integer scope;

	// Constructors

	/** default constructor */
	public TbTask() {
	}

	/** full constructor */
	public TbTask(TbUser owner, String name, Integer parentid, Date limitime,
			String description, Integer scope, Integer parentId) {
		this.owner = owner;
		this.name = name;
		this.parentid = parentid;
		this.limitime = limitime;
		this.description = description;
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
	@JoinColumn(name = "owner")
	public TbUser getOwner() {
		return this.owner;
	}

	public void setOwner(TbUser userId) {
		this.owner = userId;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "limitime", length = 10)
	public Date getLimitime() {
		return this.limitime;
	}

	public void setLimitime(Date limitime) {
		this.limitime = limitime;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "scope")
	public Integer getScope() {
		return this.scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}
	@Column(name = "publisher")
	public Integer getPublisher() {
		return publisher;
	}

	public void setPublisher(Integer publisher) {
		this.publisher = publisher;
	}
}
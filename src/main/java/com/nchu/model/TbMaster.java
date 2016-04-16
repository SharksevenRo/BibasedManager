package com.nchu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_master", catalog = "bibased")
public class TbMaster implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer mkey;
	private String type;
	private String reander;

	// Constructors

	/** default constructor */
	public TbMaster() {
	}

	/** full constructor */
	public TbMaster(Integer mkey, String type, String reander) {
		this.mkey = mkey;
		this.type = type;
		this.reander = reander;
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

	@Column(name = "mkey")
	public Integer getMkey() {
		return this.mkey;
	}

	public void setMkey(Integer mkey) {
		this.mkey = mkey;
	}

	@Column(name = "type", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "reander", length = 40)
	public String getReander() {
		return this.reander;
	}

	public void setReander(String reander) {
		this.reander = reander;
	}

}
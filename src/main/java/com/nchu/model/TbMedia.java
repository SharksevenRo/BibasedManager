package com.nchu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbMedia entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_media", catalog = "bibased")
public class TbMedia implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer owner;
	private Integer receiver;
	private Short status;
	private String url;
	private Integer type;

	// Constructors

	/** default constructor */
	public TbMedia() {
	}

	/** minimal constructor */
	public TbMedia(String url, Integer type) {
		this.url = url;
		this.type = type;
	}

	/** full constructor */
	public TbMedia(Integer owner, Integer receiver, Short status, String url,
			Integer type) {
		this.owner = owner;
		this.receiver = receiver;
		this.status = status;
		this.url = url;
		this.type = type;
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

	@Column(name = "owner")
	public Integer getOwner() {
		return this.owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	@Column(name = "receiver")
	public Integer getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "url", nullable = false, length = 65535)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
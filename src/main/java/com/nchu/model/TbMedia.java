package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbMedia entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_media", catalog = "bibased")
public class TbMedia implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser owner;
	private TbUser receiver;
	private Short status;
	private String url;
	private Integer type;
	private String name;
	private Integer score;

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
	public TbMedia(TbUser owner, TbUser receiver, Short status, String url,
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	public TbUser getOwner() {
		return this.owner;
	}

	public void setOwner(TbUser owner) {
		this.owner = owner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver")
	public TbUser getReceiver() {
		return this.receiver;
	}

	public void setReceiver(TbUser receiver) {
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

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
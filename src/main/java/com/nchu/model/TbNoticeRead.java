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
 * TbNoticeRead entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_notice_read", catalog = "bibased")
public class TbNoticeRead implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUserByUserId;
	private TbNotice tbNoticeByNoticeId;
	private TbNotice tbNoticeByNoticeid;
	private TbUser tbUserByUserid;

	// Constructors

	/** default constructor */
	public TbNoticeRead() {
	}

	/** minimal constructor */
	public TbNoticeRead(Integer id, TbUser tbUserByUserId,
			TbNotice tbNoticeByNoticeId) {
		this.id = id;
		this.tbUserByUserId = tbUserByUserId;
		this.tbNoticeByNoticeId = tbNoticeByNoticeId;
	}

	/** full constructor */
	public TbNoticeRead(Integer id, TbUser tbUserByUserId,
			TbNotice tbNoticeByNoticeId, TbNotice tbNoticeByNoticeid,
			TbUser tbUserByUserid) {
		this.id = id;
		this.tbUserByUserId = tbUserByUserId;
		this.tbNoticeByNoticeId = tbNoticeByNoticeId;
		this.tbNoticeByNoticeid = tbNoticeByNoticeid;
		this.tbUserByUserid = tbUserByUserid;
	}

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
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public TbUser getTbUserByUserId() {
		return this.tbUserByUserId;
	}

	public void setTbUserByUserId(TbUser tbUserByUserId) {
		this.tbUserByUserId = tbUserByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "notice_id", nullable = false, insertable = false, updatable = false)
	public TbNotice getTbNoticeByNoticeId() {
		return this.tbNoticeByNoticeId;
	}

	public void setTbNoticeByNoticeId(TbNotice tbNoticeByNoticeId) {
		this.tbNoticeByNoticeId = tbNoticeByNoticeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "noticeid", insertable = false, updatable = false)
	public TbNotice getTbNoticeByNoticeid() {
		return this.tbNoticeByNoticeid;
	}

	public void setTbNoticeByNoticeid(TbNotice tbNoticeByNoticeid) {
		this.tbNoticeByNoticeid = tbNoticeByNoticeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	public TbUser getTbUserByUserid() {
		return this.tbUserByUserid;
	}

	public void setTbUserByUserid(TbUser tbUserByUserid) {
		this.tbUserByUserid = tbUserByUserid;
	}

}
package com.nchu.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private TbNoticeReadId id;
	private TbNotice tbNotice;
	private TbUser tbUser;

	// Constructors

	/** default constructor */
	public TbNoticeRead() {
	}

	/** minimal constructor */
	public TbNoticeRead(TbNoticeReadId id) {
		this.id = id;
	}

	/** full constructor */
	public TbNoticeRead(TbNoticeReadId id, TbNotice tbNotice, TbUser tbUser) {
		this.id = id;
		this.tbNotice = tbNotice;
		this.tbUser = tbUser;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "noticeId", column = @Column(name = "noticeId")),
			@AttributeOverride(name = "userId", column = @Column(name = "userId")),
			@AttributeOverride(name = "time", column = @Column(name = "time", length = 19)),
			@AttributeOverride(name = "isRead", column = @Column(name = "isRead")) })
	public TbNoticeReadId getId() {
		return this.id;
	}

	public void setId(TbNoticeReadId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "noticeId", insertable = false, updatable = false)
	public TbNotice getTbNotice() {
		return this.tbNotice;
	}

	public void setTbNotice(TbNotice tbNotice) {
		this.tbNotice = tbNotice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

}
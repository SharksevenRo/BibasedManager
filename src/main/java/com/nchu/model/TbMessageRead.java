package com.nchu.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbMessageRead entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_message_read", catalog = "bibased")
public class TbMessageRead  implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUserByUserId;
	private TbMessage tbMessageByMessageId;
	private TbMessage tbMessageByMessageid;
	private TbUser tbUserByUserid;
	private Timestamp time;
	private Short isread;
	private Short isRead;

	// Constructors

	/** default constructor */
	public TbMessageRead() {
	}

	/** minimal constructor */
	public TbMessageRead(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public TbMessageRead(TbUser tbUserByUserId, TbMessage tbMessageByMessageId,
			TbMessage tbMessageByMessageid, TbUser tbUserByUserid,
			Timestamp time, Short isread, Short isRead) {
		this.tbUserByUserId = tbUserByUserId;
		this.tbMessageByMessageId = tbMessageByMessageId;
		this.tbMessageByMessageid = tbMessageByMessageid;
		this.tbUserByUserid = tbUserByUserid;
		this.time = time;
		this.isread = isread;
		this.isRead = isRead;
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
	@JoinColumn(name = "user_id")
	public TbUser getTbUserByUserId() {
		return this.tbUserByUserId;
	}

	public void setTbUserByUserId(TbUser tbUserByUserId) {
		this.tbUserByUserId = tbUserByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_id")
	public TbMessage getTbMessageByMessageId() {
		return this.tbMessageByMessageId;
	}

	public void setTbMessageByMessageId(TbMessage tbMessageByMessageId) {
		this.tbMessageByMessageId = tbMessageByMessageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "messageid")
	public TbMessage getTbMessageByMessageid() {
		return this.tbMessageByMessageid;
	}

	public void setTbMessageByMessageid(TbMessage tbMessageByMessageid) {
		this.tbMessageByMessageid = tbMessageByMessageid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public TbUser getTbUserByUserid() {
		return this.tbUserByUserid;
	}

	public void setTbUserByUserid(TbUser tbUserByUserid) {
		this.tbUserByUserid = tbUserByUserid;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "isread")
	public Short getIsread() {
		return this.isread;
	}

	public void setIsread(Short isread) {
		this.isread = isread;
	}

	@Column(name = "is_read")
	public Short getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Short isRead) {
		this.isRead = isRead;
	}

}
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
public class TbMessageRead implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbMessage tbMessage;
	private TbUser tbUser;
	private Timestamp time;
	private Short isRead;

	// Constructors

	/** default constructor */
	public TbMessageRead() {
	}

	/** full constructor */
	public TbMessageRead(TbMessage tbMessage, TbUser tbUser, Timestamp time,
			Short isRead) {
		this.tbMessage = tbMessage;
		this.tbUser = tbUser;
		this.time = time;
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
	@JoinColumn(name = "messageId")
	public TbMessage getTbMessage() {
		return this.tbMessage;
	}

	public void setTbMessage(TbMessage tbMessage) {
		this.tbMessage = tbMessage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "isRead")
	public Short getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Short isRead) {
		this.isRead = isRead;
	}

}
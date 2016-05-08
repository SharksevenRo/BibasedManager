package com.nchu.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_message", catalog = "bibased")
public class TbMessage  implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private Time content;
	private Integer receiver;
	private Integer parentid;
	private Timestamp time;
	private Integer parentId;
	private Set<TbMessageRead> tbMessageReadsForMessageId = new HashSet<TbMessageRead>(
			0);
	private Set<TbMessageRead> tbMessageReadsForMessageid = new HashSet<TbMessageRead>(
			0);

	// Constructors

	/** default constructor */
	public TbMessage() {
	}

	/** minimal constructor */
	public TbMessage(Time content, Timestamp time) {
		this.content = content;
		this.time = time;
	}

	/** full constructor */
	public TbMessage(TbUser tbUser, Time content, Integer receiver,
			Integer parentid, Timestamp time, Integer parentId,
			Set<TbMessageRead> tbMessageReadsForMessageId,
			Set<TbMessageRead> tbMessageReadsForMessageid) {
		this.tbUser = tbUser;
		this.content = content;
		this.receiver = receiver;
		this.parentid = parentid;
		this.time = time;
		this.parentId = parentId;
		this.tbMessageReadsForMessageId = tbMessageReadsForMessageId;
		this.tbMessageReadsForMessageid = tbMessageReadsForMessageid;
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
	@JoinColumn(name = "sender")
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	@Column(name = "content", nullable = false, length = 8)
	public Time getContent() {
		return this.content;
	}

	public void setContent(Time content) {
		this.content = content;
	}

	@Column(name = "receiver")
	public Integer getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbMessageByMessageId")
	public Set<TbMessageRead> getTbMessageReadsForMessageId() {
		return this.tbMessageReadsForMessageId;
	}

	public void setTbMessageReadsForMessageId(
			Set<TbMessageRead> tbMessageReadsForMessageId) {
		this.tbMessageReadsForMessageId = tbMessageReadsForMessageId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbMessageByMessageid")
	public Set<TbMessageRead> getTbMessageReadsForMessageid() {
		return this.tbMessageReadsForMessageid;
	}

	public void setTbMessageReadsForMessageid(
			Set<TbMessageRead> tbMessageReadsForMessageid) {
		this.tbMessageReadsForMessageid = tbMessageReadsForMessageid;
	}

}
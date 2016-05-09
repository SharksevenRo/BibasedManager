package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.nchu.web.support.CustomDateSerializer;

/**
 * TbMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_message", catalog = "bibased")
public class TbMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser sender;
	private String content;
	private TbUser receiver;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
	private Integer parentId;

	private List<TbMessage> child;

	// Constructors

	/** default constructor */
	public TbMessage() {
	}

	/** minimal constructor */
	public TbMessage(String content, Date time) {
		this.content = content;
		this.time = time;
	}

	/** full constructor */
	public TbMessage(TbUser tbUser, String content, TbUser receiver, Integer parentid, Timestamp time, Integer parentId,
			Set<TbMessageRead> tbMessageReadsForMessageId, Set<TbMessageRead> tbMessageReadsForMessageid) {
		this.sender = tbUser;
		this.content = content;
		this.receiver = receiver;
		this.time = time;
		this.parentId = parentId;
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
	public TbUser getSender() {
		return this.sender;
	}

	public void setSender(TbUser tbUser) {
		this.sender = tbUser;
	}

	@Column(name = "content", nullable = false, length = 8)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver")
	public TbUser getReceiver() {
		return this.receiver;
	}

	public void setReceiver(TbUser receiver) {
		this.receiver = receiver;
	}

	@Column(name = "time")
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "parentid")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Transient
	public List<TbMessage> getChild() {
		return child;
	}

	public void setChild(List<TbMessage> child) {
		this.child = child;
	}

}
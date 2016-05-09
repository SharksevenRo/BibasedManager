package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.nchu.web.support.CustomDateSerializer;

/**
 * TbNotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_notice", catalog = "bibased")
public class TbNotice  implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser sender;
	private String title;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	private Short stuvisible;
	private Short teavisible;
	private Integer scope;
	private TbUser receiver;

	// Constructors

	/** default constructor */
	public TbNotice() {
	}

	/** minimal constructor */
	public TbNotice(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public TbNotice(TbUser sender, String title, String content,
			Timestamp time, Short stuvisible, Short teavisible, Integer scope,
			TbUser type) {
		this.sender = sender;
		this.title = title;
		this.content = content;
		this.time = time;
		this.stuvisible = stuvisible;
		this.teavisible = teavisible;
		this.scope = scope;
		this.receiver = type;
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

	public void setSender(TbUser sender) {
		this.sender = sender;
	}

	@Column(name = "title", length = 65535)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time", length = 19)
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "stuvisible")
	public Short getStuvisible() {
		return this.stuvisible;
	}

	public void setStuvisible(Short stuvisible) {
		this.stuvisible = stuvisible;
	}

	@Column(name = "teavisible")
	public Short getTeavisible() {
		return this.teavisible;
	}

	public void setTeavisible(Short teavisible) {
		this.teavisible = teavisible;
	}

	@Column(name = "scope")
	public Integer getScope() {
		return this.scope;
	}

	public void setScope(Integer scope) {
		this.scope = scope;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver")
	public TbUser getReceiver() {
		return this.receiver;
	}

	public void setReceiver(TbUser type) {
		this.receiver = type;
	}
}
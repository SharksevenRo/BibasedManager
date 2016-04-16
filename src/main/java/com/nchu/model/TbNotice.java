package com.nchu.model;

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
 * TbNotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_notice", catalog = "bibased")
public class TbNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUser;
	private String title;
	private String content;
	private Timestamp time;
	private Short stuvisible;
	private Short teavisible;
	private Integer scope;
	private Short type;
	private Set<TbNoticeRead> tbNoticeReadsForNoticeid = new HashSet<TbNoticeRead>(
			0);
	private Set<TbNoticeRead> tbNoticeReadsForNoticeId = new HashSet<TbNoticeRead>(
			0);

	// Constructors

	/** default constructor */
	public TbNotice() {
	}

	/** minimal constructor */
	public TbNotice(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public TbNotice(TbUser tbUser, String title, String content,
			Timestamp time, Short stuvisible, Short teavisible, Integer scope,
			Short type, Set<TbNoticeRead> tbNoticeReadsForNoticeid,
			Set<TbNoticeRead> tbNoticeReadsForNoticeId) {
		this.tbUser = tbUser;
		this.title = title;
		this.content = content;
		this.time = time;
		this.stuvisible = stuvisible;
		this.teavisible = teavisible;
		this.scope = scope;
		this.type = type;
		this.tbNoticeReadsForNoticeid = tbNoticeReadsForNoticeid;
		this.tbNoticeReadsForNoticeId = tbNoticeReadsForNoticeId;
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

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
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

	@Column(name = "type")
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbNoticeByNoticeid")
	public Set<TbNoticeRead> getTbNoticeReadsForNoticeid() {
		return this.tbNoticeReadsForNoticeid;
	}

	public void setTbNoticeReadsForNoticeid(
			Set<TbNoticeRead> tbNoticeReadsForNoticeid) {
		this.tbNoticeReadsForNoticeid = tbNoticeReadsForNoticeid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbNoticeByNoticeId")
	public Set<TbNoticeRead> getTbNoticeReadsForNoticeId() {
		return this.tbNoticeReadsForNoticeId;
	}

	public void setTbNoticeReadsForNoticeId(
			Set<TbNoticeRead> tbNoticeReadsForNoticeId) {
		this.tbNoticeReadsForNoticeId = tbNoticeReadsForNoticeId;
	}

}
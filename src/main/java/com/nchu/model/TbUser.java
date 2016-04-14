package com.nchu.model;

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
 * TbUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_user", catalog = "bibased")
public class TbUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbRole tbRole;
	private String name;
	private String mail;
	private String phone;
	private String password;
	private Set<TbNotice> tbNotices = new HashSet<TbNotice>(0);
	private Set<TbGrade> tbGrades = new HashSet<TbGrade>(0);
	private Set<TbGroup> tbGroups = new HashSet<TbGroup>(0);
	private Set<TbMessage> tbMessages = new HashSet<TbMessage>(0);
	private Set<TbMessageRead> tbMessageReads = new HashSet<TbMessageRead>(0);
	private Set<TbNoticeRead> tbNoticeReads = new HashSet<TbNoticeRead>(0);
	private Set<TbTask> tbTasks = new HashSet<TbTask>(0);

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** minimal constructor */
	public TbUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public TbUser(TbRole tbRole, String name, String mail, String phone,
			String password, Set<TbNotice> tbNotices, Set<TbGrade> tbGrades,
			Set<TbGroup> tbGroups, Set<TbMessage> tbMessages,
			Set<TbMessageRead> tbMessageReads, Set<TbNoticeRead> tbNoticeReads,
			Set<TbTask> tbTasks) {
		this.tbRole = tbRole;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
		this.tbNotices = tbNotices;
		this.tbGrades = tbGrades;
		this.tbGroups = tbGroups;
		this.tbMessages = tbMessages;
		this.tbMessageReads = tbMessageReads;
		this.tbNoticeReads = tbNoticeReads;
		this.tbTasks = tbTasks;
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
	@JoinColumn(name = "roleId")
	public TbRole getTbRole() {
		return this.tbRole;
	}

	public void setTbRole(TbRole tbRole) {
		this.tbRole = tbRole;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "mail", length = 30)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbNotice> getTbNotices() {
		return this.tbNotices;
	}

	public void setTbNotices(Set<TbNotice> tbNotices) {
		this.tbNotices = tbNotices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbGrade> getTbGrades() {
		return this.tbGrades;
	}

	public void setTbGrades(Set<TbGrade> tbGrades) {
		this.tbGrades = tbGrades;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbGroup> getTbGroups() {
		return this.tbGroups;
	}

	public void setTbGroups(Set<TbGroup> tbGroups) {
		this.tbGroups = tbGroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbMessage> getTbMessages() {
		return this.tbMessages;
	}

	public void setTbMessages(Set<TbMessage> tbMessages) {
		this.tbMessages = tbMessages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbMessageRead> getTbMessageReads() {
		return this.tbMessageReads;
	}

	public void setTbMessageReads(Set<TbMessageRead> tbMessageReads) {
		this.tbMessageReads = tbMessageReads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbNoticeRead> getTbNoticeReads() {
		return this.tbNoticeReads;
	}

	public void setTbNoticeReads(Set<TbNoticeRead> tbNoticeReads) {
		this.tbNoticeReads = tbNoticeReads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbTask> getTbTasks() {
		return this.tbTasks;
	}

	public void setTbTasks(Set<TbTask> tbTasks) {
		this.tbTasks = tbTasks;
	}

}
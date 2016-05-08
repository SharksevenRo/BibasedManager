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
public class TbUser  implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private String name;
	private String code;
	private String phone;
	private String password;
	private Set<TbNotice> tbNotices = new HashSet<TbNotice>(0);
	private Set<TbGrade> tbGradesForUserid = new HashSet<TbGrade>(0);
	private Set<TbGroup> tbGroups = new HashSet<TbGroup>(0);
	private Set<TbMessage> tbMessages = new HashSet<TbMessage>(0);
	private Set<TbMessageRead> tbMessageReadsForUserId = new HashSet<TbMessageRead>(
			0);
	private Set<TbMessageRead> tbMessageReadsForUserid = new HashSet<TbMessageRead>(
			0);
	private Set<TbGrade> tbGradesForUserId = new HashSet<TbGrade>(0);
	private Set<TbNoticeRead> tbNoticeReadsForUserId = new HashSet<TbNoticeRead>(
			0);
	private Set<TbNoticeRead> tbNoticeReadsForUserid = new HashSet<TbNoticeRead>(
			0);
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
	public TbUser(Integer roleId, String name,
			String code, String phone, String password,
			Set<TbNotice> tbNotices, Set<TbGrade> tbGradesForUserid,
			Set<TbGroup> tbGroups, Set<TbMessage> tbMessages,
			Set<TbMessageRead> tbMessageReadsForUserId,
			Set<TbMessageRead> tbMessageReadsForUserid,
			Set<TbGrade> tbGradesForUserId,
			Set<TbNoticeRead> tbNoticeReadsForUserId,
			Set<TbNoticeRead> tbNoticeReadsForUserid, Set<TbTask> tbTasks) {
		this.roleId = roleId;
		this.name = name;
		this.code = code;
		this.phone = phone;
		this.password = password;
		this.tbNotices = tbNotices;
		this.tbGradesForUserid = tbGradesForUserid;
		this.tbGroups = tbGroups;
		this.tbMessages = tbMessages;
		this.tbMessageReadsForUserId = tbMessageReadsForUserId;
		this.tbMessageReadsForUserid = tbMessageReadsForUserid;
		this.tbGradesForUserId = tbGradesForUserId;
		this.tbNoticeReadsForUserId = tbNoticeReadsForUserId;
		this.tbNoticeReadsForUserid = tbNoticeReadsForUserid;
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


	@Column(name = "roleid", length = 20)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", length = 30)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUserByUserid")
	public Set<TbGrade> getTbGradesForUserid() {
		return this.tbGradesForUserid;
	}

	public void setTbGradesForUserid(Set<TbGrade> tbGradesForUserid) {
		this.tbGradesForUserid = tbGradesForUserid;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUserByUserId")
	public Set<TbMessageRead> getTbMessageReadsForUserId() {
		return this.tbMessageReadsForUserId;
	}

	public void setTbMessageReadsForUserId(
			Set<TbMessageRead> tbMessageReadsForUserId) {
		this.tbMessageReadsForUserId = tbMessageReadsForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUserByUserid")
	public Set<TbMessageRead> getTbMessageReadsForUserid() {
		return this.tbMessageReadsForUserid;
	}

	public void setTbMessageReadsForUserid(
			Set<TbMessageRead> tbMessageReadsForUserid) {
		this.tbMessageReadsForUserid = tbMessageReadsForUserid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUserByUserId")
	public Set<TbGrade> getTbGradesForUserId() {
		return this.tbGradesForUserId;
	}

	public void setTbGradesForUserId(Set<TbGrade> tbGradesForUserId) {
		this.tbGradesForUserId = tbGradesForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUserByUserId")
	public Set<TbNoticeRead> getTbNoticeReadsForUserId() {
		return this.tbNoticeReadsForUserId;
	}

	public void setTbNoticeReadsForUserId(
			Set<TbNoticeRead> tbNoticeReadsForUserId) {
		this.tbNoticeReadsForUserId = tbNoticeReadsForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUserByUserid")
	public Set<TbNoticeRead> getTbNoticeReadsForUserid() {
		return this.tbNoticeReadsForUserid;
	}

	public void setTbNoticeReadsForUserid(
			Set<TbNoticeRead> tbNoticeReadsForUserid) {
		this.tbNoticeReadsForUserid = tbNoticeReadsForUserid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbUser")
	public Set<TbTask> getTbTasks() {
		return this.tbTasks;
	}

	public void setTbTasks(Set<TbTask> tbTasks) {
		this.tbTasks = tbTasks;
	}

}
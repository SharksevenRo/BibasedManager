package com.nchu.model;

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
 * TbGrade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_grade", catalog = "bibased")
public class TbGrade implements java.io.Serializable {

	// Fields

	private Integer id;
	private TbUser tbUserByUserId;
	private TbUser tbUserByUserid;
	private Integer taskid;
	private Integer score;
	private Integer judgment;
	private Integer taskId;

	// Constructors

	/** default constructor */
	public TbGrade() {
	}

	/** full constructor */
	public TbGrade(TbUser tbUserByUserId, TbUser tbUserByUserid,
			Integer taskid, Integer score, Integer judgment, Integer taskId) {
		this.tbUserByUserId = tbUserByUserId;
		this.tbUserByUserid = tbUserByUserid;
		this.taskid = taskid;
		this.score = score;
		this.judgment = judgment;
		this.taskId = taskId;
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
	@JoinColumn(name = "userid")
	public TbUser getTbUserByUserid() {
		return this.tbUserByUserid;
	}

	public void setTbUserByUserid(TbUser tbUserByUserid) {
		this.tbUserByUserid = tbUserByUserid;
	}

	@Column(name = "taskid")
	public Integer getTaskid() {
		return this.taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "judgment")
	public Integer getJudgment() {
		return this.judgment;
	}

	public void setJudgment(Integer judgment) {
		this.judgment = judgment;
	}

	@Column(name = "task_id")
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}
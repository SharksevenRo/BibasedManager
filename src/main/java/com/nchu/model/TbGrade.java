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
	private TbUser tbUser;
	private Integer type;
	private Integer score;
	private Integer judgment;

	// Constructors

	/** default constructor */
	public TbGrade() {
	}

	/** full constructor */
	public TbGrade(TbUser tbUser, Integer type, Integer score, Integer judgment) {
		this.tbUser = tbUser;
		this.type = type;
		this.score = score;
		this.judgment = judgment;
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
	@JoinColumn(name = "userId")
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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

}
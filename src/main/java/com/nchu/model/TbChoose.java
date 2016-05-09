package com.nchu.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_choose", catalog = "bibased")
public class TbChoose {

	
	private Integer id;
	private Integer studentId;
	private TbTask task;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "stuid")
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "taskid")
	public TbTask getTask() {
		return task;
	}
	public void setTask(TbTask task) {
		this.task = task;
	}
	
}

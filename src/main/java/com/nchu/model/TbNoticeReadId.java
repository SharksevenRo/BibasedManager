package com.nchu.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbNoticeReadId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TbNoticeReadId implements java.io.Serializable {

	// Fields

	private Integer noticeId;
	private Integer userId;
	private Timestamp time;
	private Short isRead;

	// Constructors

	/** default constructor */
	public TbNoticeReadId() {
	}

	/** full constructor */
	public TbNoticeReadId(Integer noticeId, Integer userId, Timestamp time,
			Short isRead) {
		this.noticeId = noticeId;
		this.userId = userId;
		this.time = time;
		this.isRead = isRead;
	}

	// Property accessors

	@Column(name = "noticeId")
	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@Column(name = "userId")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbNoticeReadId))
			return false;
		TbNoticeReadId castOther = (TbNoticeReadId) other;

		return ((this.getNoticeId() == castOther.getNoticeId()) || (this
				.getNoticeId() != null && castOther.getNoticeId() != null && this
				.getNoticeId().equals(castOther.getNoticeId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getIsRead() == castOther.getIsRead()) || (this
						.getIsRead() != null && castOther.getIsRead() != null && this
						.getIsRead().equals(castOther.getIsRead())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNoticeId() == null ? 0 : this.getNoticeId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37 * result
				+ (getIsRead() == null ? 0 : this.getIsRead().hashCode());
		return result;
	}

}
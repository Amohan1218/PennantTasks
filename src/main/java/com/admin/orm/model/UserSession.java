package com.admin.orm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_usersessions")
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ussn_id")
    private Integer id;

    @Column(name = "ussn_user_id")
    private Integer userId;

    @Column(name = "ussn_sessionid")
    private String sessionId;

    @Column(name = "ussn_cdate")
    private Date creationDate;

    @Column(name = "ussn_key")
    private String sessionKey;

    @Column(name = "ussn_host")
    private String host;

    @Column(name = "ussn_expire")
    private Date expireTime;

    @Column(name = "ussn_status")
    private String status;

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", userId=" + userId + ", sessionId=" + sessionId + ", creationDate="
				+ creationDate + ", sessionKey=" + sessionKey + ", host=" + host + ", expireTime=" + expireTime
				+ ", status=" + status + "]";
	}

	public UserSession() {
		super();
	}

	public UserSession(Integer userId, String sessionId, Date creationDate, String sessionKey, String host,
			Date expireTime, String status) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
		this.creationDate = creationDate;
		this.sessionKey = sessionKey;
		this.host = host;
		this.expireTime = expireTime;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}


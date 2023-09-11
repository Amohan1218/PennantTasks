package com.admin.orm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_uname", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "user_cdate")
    private Date creationDate;

    @Column(name = "user_type", nullable = false, length = 4)
    private String userType;

    @Column(name = "user_pwd", nullable = false, length = 50)
    private String password;

    @Column(name = "user_email", length = 60)
    private String email;

    @Column(name = "user_recoveryemail", length = 60)
    private String recoveryEmail;

    @Column(name = "user_mobile")
    private Long mobile;

    public Users() {  }

	public Users(String username, Date creationDate, String userType, String password, String email,
			String recoveryEmail, Long mobile) {
		super();
		this.username = username;
		this.creationDate = creationDate;
		this.userType = userType;
		this.password = password;
		this.email = email;
		this.recoveryEmail = recoveryEmail;
		this.mobile = mobile;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecoveryEmail() {
		return recoveryEmail;
	}

	public void setRecoveryEmail(String recoveryEmail) {
		this.recoveryEmail = recoveryEmail;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", creationDate=" + creationDate + ", userType="
				+ userType + ", password=" + password + ", email=" + email + ", recoveryEmail=" + recoveryEmail
				+ ", mobile=" + mobile + "]";
	}
	
}

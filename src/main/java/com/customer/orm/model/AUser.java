package com.customer.orm.model;

import javax.persistence.*;

@Entity
@Table(name = "ms_auser")
public class AUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auser_id")
    private Long userId;

    @Column(name = "auser_username", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "auser_password", nullable = false, length = 50)
    private String password;

    @Column(name = "auser_type", nullable = false, length = 10)
    private String userType;

    public AUser() {
        // Default constructor
    }

    public AUser(Long userId, String username, String password, String userType) {
    	this.userId = userId;
    	this.username = username;
        this.password = password;
        this.userType = userType;
    }

    // Getters and setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

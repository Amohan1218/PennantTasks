package com.folder.orm.model;

import javax.persistence.*;

@Table(name = "ms_auser")
@Entity
public class AUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auser_id")
    private Integer id;

    @Column(name = "auser_username", unique = true, nullable = false)
    private String username;

    @Column(name = "auser_password", nullable = false)
    private String password;

    // Constructors, getters, and setters

    // Default constructor
    public AUser() {
    }
    
    // Parameterized constructor
    public AUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
	public String toString() {
		return "AUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	// Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

package com.folder.orm.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ms_loantypes")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lnty_id")
    private Integer id;
    
    @OneToMany
    private List<LoanApplicant> lapp;
    
    @Column(name = "lnty_name")
    private String name;

    @Column(name = "lnty_desc")
    private String description;

    // Constructors, getters, and setters

    // Default constructor
    public LoanType() {
    }

    // Parameterized constructor
    public LoanType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "LoanType [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}

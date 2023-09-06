package com.folder.orm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ms_customers")
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer id;

    @Column(name = "cust_firstname")
    private String firstName;

    @Column(name = "cust_lastname")
    private String lastName;

    @Column(name = "cust_dob")
    private Date dateOfBirth;

    @Column(name = "cust_panno")
    private String panNumber;

    @Column(name = "cust_mobile")
    private Long mobileNumber;

    @Column(name = "cust_address")
    private String address;

    @Column(name = "cust_gname")
    private String guardianName;

    @Column(name = "cust_luudate")
    private Date lastUpdatedDate;

    @Column(name = "cust_luser")
    private Integer lastUpdatedUser;
    
    @OneToMany
    private List<LoanApplicant> lapp;	

    // Constructors, getters, and setters

    // Default constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String firstName, String lastName, Date dateOfBirth, String panNumber,
                    Long mobileNumber, String address, String guardianName, Date lastUpdatedDate, Integer lastUpdatedUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.panNumber = panNumber;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.guardianName = guardianName;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedUser = lastUpdatedUser;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", panNumber=" + panNumber + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", guardianName=" + guardianName + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedUser="
				+ lastUpdatedUser + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(Integer lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}
    
}

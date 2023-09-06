package com.folder.orm.model;

import javax.persistence.*;
import java.util.Date;

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
    
}

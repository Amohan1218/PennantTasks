package com.customer.orm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_firstname", length = 50)
    private String custFirstName;

    @Column(name = "cust_lastname", length = 50)
    private String custLastName;

    @Column(name = "cust_dob")
    private Date custDob;

    @Column(name = "cust_panno", length = 10)
    private String custPanNo;

    @Column(name = "cust_mobile")
    private Long custMobile;

    @Column(name = "cust_address", length = 255)
    private String custAddress;

    @Column(name = "cust_gname", length = 50)
    private String custGuardianName;

    @Column(name = "cust_luudate")
    private Date custLastUpdateDate;

    @Column(name = "cust_luser")
    private int custLastUpdatedBy; // Assuming you have a User entity

	public Customer() {
		super();
	}

	public Customer(String custFirstName, String custLastName, Date custDob, String custPanNo,
			Long custMobile, String custAddress, String custGuardianName, Date custLastUpdateDate, int custLastUpdatedBy) {
		super();
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custDob = custDob;
		this.custPanNo = custPanNo;
		this.custMobile = custMobile;
		this.custAddress = custAddress;
		this.custGuardianName = custGuardianName;
		this.custLastUpdatedBy = custLastUpdatedBy;
		this.custLastUpdateDate = custLastUpdateDate;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public Date getCustDob() {
		return custDob;
	}

	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}

	public String getCustPanNo() {
		return custPanNo;
	}

	public void setCustPanNo(String custPanNo) {
		this.custPanNo = custPanNo;
	}

	public Long getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(Long custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustGuardianName() {
		return custGuardianName;
	}

	public void setCustGuardianName(String custGuardianName) {
		this.custGuardianName = custGuardianName;
	}

	public Date getCustLastUpdateDate() {
		return custLastUpdateDate;
	}

	public void setCustLastUpdateDate(Date custLastUpdateDate) {
		this.custLastUpdateDate = custLastUpdateDate;
	}

	public int getCustLastUpdatedBy() {
		return custLastUpdatedBy;
	}

	public void setCustLastUpdatedBy(int custLastUpdatedBy) {
		this.custLastUpdatedBy = custLastUpdatedBy;
	}
}


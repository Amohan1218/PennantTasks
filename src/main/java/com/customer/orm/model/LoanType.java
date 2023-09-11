package com.customer.orm.model;

import javax.persistence.*;

@Entity
@Table(name = "ms_loantypes")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lnty_id")
    private Integer LTid;

    @Column(name = "lnty_name")
    private String LTname;

    @Column(name = "lnty_desc")
    private String LTdescription;

    public LoanType() {
    }

	@Override
	public String toString() {
		return "LoanType [LTid=" + LTid + ", LTname=" + LTname + ", LTdescription=" + LTdescription + "]";
	}

	public Integer getLTid() {
		return LTid;
	}

	public void setLTid(Integer lTid) {
		LTid = lTid;
	}

	public String getLTname() {
		return LTname;
	}

	public void setLTname(String lTname) {
		LTname = lTname;
	}

	public String getLTdescription() {
		return LTdescription;
	}

	public void setLTdescription(String lTdescription) {
		LTdescription = lTdescription;
	}

	public LoanType(Integer lTid, String lTname, String lTdescription) {
		super();
		LTid = lTid;
		LTname = lTname;
		LTdescription = lTdescription;
	}
}

package com.customer.orm.model;

import javax.persistence.*;

@Entity
@Table(name = "ms_loanApplicantsNominees")
public class LoanApplicantNominees {

    @Id
    @Column(name = "lnap_id")
    private int id;

    @Column(name = "lnap_nominee")
    private String nominee;

    @Column(name = "lanp_relation")
    private String relation;

	public LoanApplicantNominees() {
		super();
	}

	public LoanApplicantNominees(int id, String nominee, String relation) {
		super();
		this.id = id;
		this.nominee = nominee;
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "LoanApplicantNominees [id=" + id + ", nominee=" + nominee + ", relation=" + relation + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
}

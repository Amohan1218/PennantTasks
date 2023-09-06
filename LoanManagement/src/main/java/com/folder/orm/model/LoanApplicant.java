package com.folder.orm.model;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "ms_loanApplicants")
public class LoanApplicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lnap_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "lnap_processed_user")
	private AUser processedUser; // Assuming you have a User entity for 'ms_auser' table

	@ManyToOne
	@JoinColumn(name = "lnap_lnty_id")
	private LoanType loanType; // Assuming you have a LoanType entity for 'ms_loantypes' table

	@ManyToOne
	@JoinColumn(name = "lnap_cust_id")
	private Customer customer; // Assuming you have a Customer entity for 'ms_customers' table

	@Column(name = "lnap_apdate")
	private Date applicationDate;

	@Column(name = "lnap_amount")
	private Double amount;

	@Column(name = "lnap_emi_range_from")
	private Double emiRangeFrom;

	@Column(name = "lnap_emi_range_to")
	private Double emiRangeTo;

	@Column(name = "lnap_nom_requested")
	private Integer nominalRequested;

	@Column(name = "lnap_cibil_score")
	private Double cibilScore;

	@Column(name = "lnap_status")
	private String status;

	@Column(name = "lnap_conclusion_remarks")
	private String conclusionRemarks;

	@Column(name = "lnap_processed_date")
	private Date processedDate;

	public LoanApplicant() {
		super();
	}

	public LoanApplicant(Integer id, AUser processedUser, LoanType loanType, Customer customer, Date applicationDate,
			Double amount, Double emiRangeFrom, Double emiRangeTo, Integer nominalRequested, Double cibilScore,
			String status, String conclusionRemarks, Date processedDate) {
		super();
		this.id = id;
		this.processedUser = processedUser;
		this.loanType = loanType;
		this.customer = customer;
		this.applicationDate = applicationDate;
		this.amount = amount;
		this.emiRangeFrom = emiRangeFrom;
		this.emiRangeTo = emiRangeTo;
		this.nominalRequested = nominalRequested;
		this.cibilScore = cibilScore;
		this.status = status;
		this.conclusionRemarks = conclusionRemarks;
		this.processedDate = processedDate;
	}

	@Override
	public String toString() {
		return "LoanApplicant [id=" + id + ", applicationDate=" + applicationDate + ", amount=" + amount
				+ ", emiRangeFrom=" + emiRangeFrom + ", emiRangeTo=" + emiRangeTo + ", nominalRequested="
				+ nominalRequested + ", cibilScore=" + cibilScore + ", status=" + status + ", conclusionRemarks="
				+ conclusionRemarks + ", processedDate=" + processedDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AUser getProcessedUser() {
		return processedUser;
	}

	public void setProcessedUser(AUser processedUser) {
		this.processedUser = processedUser;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
		this.applicationDate = sd.parse(sd.format(applicationDate));
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getEmiRangeFrom() {
		return emiRangeFrom;
	}

	public void setEmiRangeFrom(Double emiRangeFrom) {
		this.emiRangeFrom = emiRangeFrom;
	}

	public Double getEmiRangeTo() {
		return emiRangeTo;
	}

	public void setEmiRangeTo(Double emiRangeTo) {
		this.emiRangeTo = emiRangeTo;
	}

	public Integer getNominalRequested() {
		return nominalRequested;
	}

	public void setNominalRequested(Integer nominalRequested) {
		this.nominalRequested = nominalRequested;
	}

	public Double getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(Double cibilScore) {
		this.cibilScore = cibilScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConclusionRemarks() {
		return conclusionRemarks;
	}

	public void setConclusionRemarks(String conclusionRemarks) {
		this.conclusionRemarks = conclusionRemarks;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
}
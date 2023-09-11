package com.customer.orm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_loanApplicants")
public class LoanApplicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lnap_id")
    private Long id;

    @Column(name = "lnap_cust_id")
    private Integer customerId;

    @Column(name = "lnap_apdate")
    @Temporal(TemporalType.DATE)
    private Date applicationDate;

    @Column(name = "lnap_lnty_id")
    private Integer loanTypeId;

    @Column(name = "lnap_amount")
    private Double loanAmount;

    @Column(name = "lnap_emi_range_from")
    private Double emiRangeFrom;

    @Column(name = "lnap_emi_range_to")
    private Double emiRangeTo;

    @Column(name = "lnap_nom_requested")
    private Integer noOfMonthsRequested;

    @Column(name = "lnap_annual_income")
    private Double annualIncome;

    @Column(name = "lnap_disposable_income")
    private Double disposableIncome;

    @Column(name = "lnap_cibil_score")
    private Double cibilScore;

    @Column(name = "lnap_status")
    private String status;

    @Column(name = "lnap_conclusion_remarks")
    private String conclusionRemarks;

    @Column(name = "lnap_processed_user")
    private Integer processedUser;

    @Column(name = "lnap_processed_date")
    @Temporal(TemporalType.DATE)
    private Date processedDate;

    
	public LoanApplicant() {
		super();
	}


	@Override
	public String toString() {
		return "LoanApplicant [id=" + id + ", customerId=" + customerId + ", applicationDate=" + applicationDate
				+ ", loanTypeId=" + loanTypeId + ", loanAmount=" + loanAmount + ", emiRangeFrom=" + emiRangeFrom
				+ ", emiRangeTo=" + emiRangeTo + ", noOfMonthsRequested=" + noOfMonthsRequested + ", annualIncome="
				+ annualIncome + ", disposableIncome=" + disposableIncome + ", cibilScore=" + cibilScore + ", status="
				+ status + ", conclusionRemarks=" + conclusionRemarks + ", processedUser=" + processedUser
				+ ", processedDate=" + processedDate + "]";
	}


	public LoanApplicant(Integer customerId, Date applicationDate, Integer loanTypeId, Double loanAmount,
			Double emiRangeFrom, Double emiRangeTo, Integer noOfMonthsRequested, Double annualIncome,
			Double disposableIncome, Double cibilScore, String status, String conclusionRemarks, Integer processedUser,
			Date processedDate) {
		super();
		this.customerId = customerId;
		this.applicationDate = applicationDate;
		this.loanTypeId = loanTypeId;
		this.loanAmount = loanAmount;
		this.emiRangeFrom = emiRangeFrom;
		this.emiRangeTo = emiRangeTo;
		this.noOfMonthsRequested = noOfMonthsRequested;
		this.annualIncome = annualIncome;
		this.disposableIncome = disposableIncome;
		this.cibilScore = cibilScore;
		this.status = status;
		this.conclusionRemarks = conclusionRemarks;
		this.processedUser = processedUser;
		this.processedDate = processedDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Date getApplicationDate() {
		return applicationDate;
	}


	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}


	public Integer getLoanTypeId() {
		return loanTypeId;
	}


	public void setLoanTypeId(Integer loanTypeId) {
		this.loanTypeId = loanTypeId;
	}


	public Double getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
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


	public Integer getNoOfMonthsRequested() {
		return noOfMonthsRequested;
	}


	public void setNoOfMonthsRequested(Integer noOfMonthsRequested) {
		this.noOfMonthsRequested = noOfMonthsRequested;
	}


	public Double getAnnualIncome() {
		return annualIncome;
	}


	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}


	public Double getDisposableIncome() {
		return disposableIncome;
	}


	public void setDisposableIncome(Double disposableIncome) {
		this.disposableIncome = disposableIncome;
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


	public Integer getProcessedUser() {
		return processedUser;
	}


	public void setProcessedUser(Integer processedUser) {
		this.processedUser = processedUser;
	}


	public Date getProcessedDate() {
		return processedDate;
	}


	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
}
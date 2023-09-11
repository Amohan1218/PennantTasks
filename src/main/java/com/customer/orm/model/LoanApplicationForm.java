package com.customer.orm.model;

public class LoanApplicationForm {
	Integer userId;
	String firstName;
	String lastName;
	String dateOfBirth;
	String pANNumber;
	String address;
	Double lnAmount;
	Integer lnType;
	Double aIncome;
	Double dIncome;
	Integer monthsRequired;
	String gurdName;
	Long phNumber;
	String nName;
	String nRelation;

	public LoanApplicationForm() {
		super();
	}
	
	@Override
	public String toString() {
		return "LoanApplicationForm [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", pANNumber=" + pANNumber + ", address=" + address + ", lnAmount="
				+ lnAmount + ", lnType=" + lnType + ", aIncome=" + aIncome + ", dIncome=" + dIncome
				+ ", monthsRequired=" + monthsRequired + ", gurdName=" + gurdName + ", phNumber=" + phNumber
				+ ", nName=" + nName + ", nRelation=" + nRelation + "]";
	}

	public LoanApplicationForm(Integer userId, String firstName, String lastName, String dateOfBirth, String pANNumber,
			String address, Double lnAmount, Integer lnType, Double aIncome, Double dIncome, Integer monthsRequired,
			String gurdName, Long phNumber, String nName, String nRelation) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.pANNumber = pANNumber;
		this.address = address;
		this.lnAmount = lnAmount;
		this.lnType = lnType;
		this.aIncome = aIncome;
		this.dIncome = dIncome;
		this.monthsRequired = monthsRequired;
		this.gurdName = gurdName;
		this.phNumber = phNumber;
		this.nName = nName;
		this.nRelation = nRelation;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getpANNumber() {
		return pANNumber;
	}

	public void setpANNumber(String pANNumber) {
		this.pANNumber = pANNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLnAmount() {
		return lnAmount;
	}

	public void setLnAmount(Double lnAmount) {
		this.lnAmount = lnAmount;
	}

	public Integer getLnType() {
		return lnType;
	}

	public void setLnType(Integer lnType) {
		this.lnType = lnType;
	}

	public Double getaIncome() {
		return aIncome;
	}

	public void setaIncome(Double aIncome) {
		this.aIncome = aIncome;
	}

	public Double getdIncome() {
		return dIncome;
	}

	public void setdIncome(Double dIncome) {
		this.dIncome = dIncome;
	}

	public Integer getMonthsRequired() {
		return monthsRequired;
	}

	public void setMonthsRequired(Integer monthsRequired) {
		this.monthsRequired = monthsRequired;
	}

	public String getGurdName() {
		return gurdName;
	}

	public void setGurdName(String gurdName) {
		this.gurdName = gurdName;
	}

	public Long getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(Long phNumber) {
		this.phNumber = phNumber;
	}

	public String getnName() {
		return nName;
	}

	public void setnName(String nName) {
		this.nName = nName;
	}

	public String getnRelation() {
		return nRelation;
	}

	public void setnRelation(String nRelation) {
		this.nRelation = nRelation;
	}
}

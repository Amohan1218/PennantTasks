package tasks.calInterstTask;

import java.time.LocalDate;

class Account {
	String acctNum, acctType, balance;
	LocalDate dOPAcct;

	public Account(String acctNum, String acctType, LocalDate dOPAcct, String balance) {
		super();
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.balance = balance;
		this.dOPAcct = dOPAcct;
	}

	public String toString() {
		return getAcctNum() + " .. " + getAcctType() + " .. " + getdOPAcct() + " .. " + getBalance();
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public LocalDate getdOPAcct() {
		return dOPAcct;
	}

	public void setdOPAcct(LocalDate dOPAcct) {
		this.dOPAcct = dOPAcct;
	}
}

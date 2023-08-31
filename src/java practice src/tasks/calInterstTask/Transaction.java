package tasks.calInterstTask;

import java.time.LocalDate;

class Transaction {
	String TransactionID, acctNum;
	LocalDate dOTransac;
	String transacType, amount;

	public Transaction(String transactionID, String acctNum, LocalDate dOTransac, String transacType, String amount) {
		super();
		TransactionID = transactionID;
		this.acctNum = acctNum;
		this.dOTransac = dOTransac;
		this.transacType = transacType;
		this.amount = amount;
	}

	public String toString() {
		return getTransactionID() + " .. " + getAcctNum() + " .. " + getdOTransac() + " .. " + getTransacType() + " .. "
				+ getAmount();
	}

	public String getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public LocalDate getdOTransac() {
		return dOTransac;
	}

	public void setdOTransac(LocalDate dOTransac) {
		this.dOTransac = dOTransac;
	}

	public String getTransacType() {
		return transacType;
	}

	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
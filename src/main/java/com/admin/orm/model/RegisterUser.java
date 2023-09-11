package com.admin.orm.model;

public class RegisterUser {
	String accType;
	String userName;
	String password;
	String emailId;
	String recEmailId;
	String phNum;
	public RegisterUser() {
		super();
	}
	public RegisterUser(String accType, String userName, String password, String emailId, String recEmailId,
			String phNum) {
		super();
		this.accType = accType;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.recEmailId = recEmailId;
		this.phNum = phNum;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRecEmailId() {
		return recEmailId;
	}
	public void setRecEmailId(String recEmailId) {
		this.recEmailId = recEmailId;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	@Override
	public String toString() {
		return "RegisterUser [accType=" + accType + ", userName=" + userName + ", password=" + password + ", emailId="
				+ emailId + ", recEmailId=" + recEmailId + ", phNum=" + phNum + "]";
	}
	
}

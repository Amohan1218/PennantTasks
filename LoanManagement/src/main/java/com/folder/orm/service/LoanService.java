package com.folder.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.folder.orm.dao.LoanDAO;
import com.folder.orm.model.AUser;
import com.folder.orm.model.LoanApplicant;

@Component
public class LoanService {
	
	LoanDAO LoanObj;
	
	@Autowired
	LoanService(LoanDAO loandao){
		this.LoanObj = loandao;
	}

	public List<LoanApplicant> getAllApplications() {
		return LoanObj.getAllApplicants();
	}
	
	@Transactional(readOnly = true)
	public List<AUser> getAllUser() {
		return LoanObj.getAllUser();
	}
	
	
}

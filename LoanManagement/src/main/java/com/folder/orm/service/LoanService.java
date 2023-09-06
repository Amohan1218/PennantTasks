package com.folder.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.folder.orm.dao.LoanDAO;
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
	
	
}

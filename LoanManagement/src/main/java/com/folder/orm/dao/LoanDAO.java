package com.folder.orm.dao;

import java.util.List;

import com.folder.orm.model.AUser;
import com.folder.orm.model.LoanApplicant;

public interface LoanDAO {
	List<LoanApplicant> getAllApplicants();

	List<AUser> getAllUser();
}

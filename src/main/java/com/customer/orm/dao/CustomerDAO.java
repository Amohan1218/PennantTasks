package com.customer.orm.dao;

import java.util.List;

import com.customer.orm.model.AUser;
import com.customer.orm.model.Customer;
import com.customer.orm.model.LoanApplicant;
import com.customer.orm.model.LoanApplicantNominees;

public interface CustomerDAO {
	List<LoanApplicant> getAllApplicants();

	List<AUser> getAllUser();

	void saveCustomer(Customer c);

	void saveApplication(LoanApplicant lA);

	void saveNominee(LoanApplicantNominees lN);

	List<LoanApplicant> getLoanApplications(Integer userId);

	List<LoanApplicant> getApprovedApplications(Integer userId, String status);
}

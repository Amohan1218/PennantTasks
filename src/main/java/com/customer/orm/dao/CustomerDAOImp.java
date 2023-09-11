package com.customer.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.customer.orm.model.AUser;
import com.customer.orm.model.Customer;
import com.customer.orm.model.LoanApplicant;
import com.customer.orm.model.LoanApplicantNominees;

public class CustomerDAOImp implements CustomerDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplicant> getAllApplicants() {
		return em.createQuery("SELECT l FROM LoanApplicant l").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AUser> getAllUser() {
		return em.createQuery("SELECT e FROM AUser e").getResultList();
	}

	@Override
	public void saveCustomer(Customer c) {
		em.persist(c);
	}

	@Override
	public void saveApplication(LoanApplicant lA) {
		em.persist(lA);
	}

	@Override
	public void saveNominee(LoanApplicantNominees lN) {
		em.persist(lN);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplicant> getLoanApplications(Integer userId) {
		String str = "SELECT e FROM LoanApplicant e WHERE processedUser = :userId";
		Query query = em.createQuery(str);
		query.setParameter("userId", userId);
		
		return query.getResultList();
	}

	@Override
	public List<LoanApplicant> getApprovedApplications(Integer userId, String status) {
		String str = "SELECT e FROM LoanApplicant e WHERE processedUser = :userId AND status = :sts";
		Query query = em.createQuery(str);
		query.setParameter("userId", userId);
		query.setParameter("sts", status);
		
		return query.getResultList();
	}
}

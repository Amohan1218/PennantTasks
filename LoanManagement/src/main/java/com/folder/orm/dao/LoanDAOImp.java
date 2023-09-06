package com.folder.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.folder.orm.model.LoanApplicant;

public class LoanDAOImp implements LoanDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<LoanApplicant> getAllApplicants() {
		return em.createQuery("SELECT l FROM ms_loanApplicants l").getResultList();
	}
}

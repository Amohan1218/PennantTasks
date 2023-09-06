package com.folder.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.folder.orm.model.AUser;
import com.folder.orm.model.LoanApplicant;

public class LoanDAOImp implements LoanDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<LoanApplicant> getAllApplicants() {
		return em.createQuery("SELECT l FROM LoanApplicant l").getResultList();
	}
	
	@Override
	public List<AUser> getAllUser() {
		return em.createQuery("SELECT e FROM AUser e").getResultList();
	}
}

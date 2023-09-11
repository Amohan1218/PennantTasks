package com.admin.orm.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.admin.orm.model.UserSession;
import com.admin.orm.model.Users;
import com.customer.orm.model.LoanApplicant;

public class AdminDAOImp implements AdminDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveUser(Users u) {
		em.persist(u);
	}

	@Override
	public Users getUser(String username) {
		String qStr = "SELECT e FROM Users e WHERE e.username = :uname";
		Query query = em.createQuery(qStr);
		query.setParameter("uname", username);
		
		try {
	        return (Users) query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

	@Override
	public void saveSession(UserSession us) {
		em.persist(us);
	}

	@Override
	public UserSession getSession(Integer sId) {
		String qStr = "SELECT e FROM UserSession e WHERE e.id = :sessionId";
		Query query = em.createQuery(qStr);
		query.setParameter("sessionId", sId);
		
		try {
	        return (UserSession) query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplicant> getApplicantsByDate(Date targetDate) {
		String qStr = "SELECT e FROM LoanApplicant e WHERE applicationDate = :cDate";
		Query query = em.createQuery(qStr);
		query.setParameter("cDate", targetDate);
		
		return (List<LoanApplicant>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApplicant> getApplicantsByLAmount(Double amtFrom, Double amtTo) {
		String qStr = "SELECT e FROM LoanApplicant e WHERE loanAmount BETWEEN :From AND :To";
		Query query = em.createQuery(qStr);
		query.setParameter("From", amtFrom);
		query.setParameter("To", amtTo);
		
		return (List<LoanApplicant>) query.getResultList();
	}
	
}

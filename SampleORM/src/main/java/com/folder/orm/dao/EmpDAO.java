package com.folder.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.folder.orm.model.Employee;

@Component
public class EmpDAO {

	@PersistenceContext
	private EntityManager em;

	public void persist(Employee emp) {
		em.persist(emp);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return em.createQuery("SELECT e FROM Employee e").getResultList();
	}
}

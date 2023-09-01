package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.DoctorMapper;
import com.model.Doctors;

public class HospitalDAOImp implements HospitalDAO{
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public HospitalDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_DOCTORS = "select * from arogya_doctors";
	
	@Override
	public List<Doctors> getAllDoctors() {
		return jdbcTemplate.query(SQL_GET_DOCTORS, new DoctorMapper());
	}
}

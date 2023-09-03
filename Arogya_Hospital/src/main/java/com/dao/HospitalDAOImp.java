package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.DoctorMapper;
import com.model.Doctors;
import com.model.SlotAvlDates;
import com.model.SlotAvlDatesMapper;

public class HospitalDAOImp implements HospitalDAO{
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public HospitalDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_DOCTORS = "select * from arogya_doctors";
	private final String SQL_GET_ALL_AVL_SLOTS = "select slot_date from appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = ? group by slot_date";
	
	@Override
	public List<Doctors> getAllDoctors() {
		return jdbcTemplate.query(SQL_GET_DOCTORS, new DoctorMapper());
	}

	@Override
	public List<SlotAvlDates> getAvailableDates(int doc_id) {
		return jdbcTemplate.query(SQL_GET_ALL_AVL_SLOTS, new Object[] { doc_id }, new SlotAvlDatesMapper());
	}
}

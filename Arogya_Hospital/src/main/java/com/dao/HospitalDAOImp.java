package com.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.DocSchd;
import com.model.DocSchdMapper;
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

	private final String SQL_GET_DOCTORS = "select * from ms_doctors";
	private final String SQL_GET_DOCTOR_INFO = "select * from ms_doctor_schedule where doc_id = ?";
	private final String SQL_GET_ALL_AVL_SLOTS = "select slot_date from ms_appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = ? group by slot_date";
	
	@Override
	public List<Doctors> getAllDoctors() {
		return jdbcTemplate.query(SQL_GET_DOCTORS, new DoctorMapper());
	}

	@Override
	public List<SlotAvlDates> getAvailableDates(int doc_id) {
		return jdbcTemplate.query(SQL_GET_ALL_AVL_SLOTS, new Object[] { doc_id }, new SlotAvlDatesMapper());
	}

	@Override
	public DocSchd getDoctor(int docId) {
		return jdbcTemplate.queryForObject(SQL_GET_DOCTOR_INFO,  new Object[] { docId }, new DocSchdMapper());
	}
}
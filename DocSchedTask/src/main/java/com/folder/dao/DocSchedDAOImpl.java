package com.folder.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.folder.model.DoctorList;
import com.folder.model.DoctorListMapper;
import com.folder.model.DoctorSchedule;

public class DocSchedDAOImpl implements DocSchedDAO{
	
	JdbcTemplate jdbcTemplate;	
	
	private final String SQL_GET_ALL_DOCTOR_LIST = "select * from ms_doctorlist";
	private final String SQL_INSERT_DOCTOR_SCHEDULE = "insert into ms_doctor_schedule (doct_id, dcsc_schedule, dcsc_avl_from, dcsc_avl_to) values(?,?,?,?)";

	@Autowired
	public DocSchedDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	public boolean createDoctorSchedule(List<DoctorSchedule> L) {
		int i  = 0;
		for(DoctorSchedule d : L) {
			i = jdbcTemplate.update(SQL_INSERT_DOCTOR_SCHEDULE, d.getDoct_id(), d.getDcsc_schedule(), d.getDcsc_avl_from(), d.getDcsc_avl_to());	
		}
		if(i > 1) 
			return true;
		else
			return false;
	}

	@Override
	public List<DoctorList> getDoctorList() {
		return jdbcTemplate.query(SQL_GET_ALL_DOCTOR_LIST, new DoctorListMapper());
	}
}

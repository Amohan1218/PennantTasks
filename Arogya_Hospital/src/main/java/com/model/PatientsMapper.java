package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PatientsMapper implements RowMapper<Patients>{

	@Override
	public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patients p = new Patients();
		
		p.setPatientID(rs.getInt(1));
		p.setFirstName(rs.getString(2));
		p.setLastName(rs.getString(3));
		p.setAge(rs.getInt(4));
		p.setGender(rs.getString(5));
		p.setContactNumber(rs.getInt(6));
		p.setEmail(rs.getString(7));
		
		return p;
	}

}

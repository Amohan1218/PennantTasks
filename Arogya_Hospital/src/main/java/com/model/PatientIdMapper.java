package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PatientIdMapper implements RowMapper<PatientId>{

	@Override
	public PatientId mapRow(ResultSet rs, int rowNum) throws SQLException {
		PatientId p = new PatientId();
		
		p.setPatientId(rs.getInt(1));
		
		return p;
	}

}

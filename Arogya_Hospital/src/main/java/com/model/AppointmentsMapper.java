package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AppointmentsMapper implements RowMapper<Appointments>{

	@Override
	public Appointments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Appointments a = new Appointments();
		
		a.setApptId(rs.getInt(1));
		a.setApptDate(rs.getString(2));
		a.setApptDocId(rs.getInt(3));
		a.setApptPatnId(rs.getInt(4));
		a.setApptSlotFrom(rs.getString(5));
		a.setApptSlotTo(rs.getString(6));
		
		return a;
	}

}

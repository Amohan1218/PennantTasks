package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoctorMapper implements RowMapper<Doctors>{

	@Override
	public Doctors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctors D = new Doctors();
		
		D.setDocId(rs.getInt(1));
		D.setDocName(rs.getString(2));
		D.setQual(rs.getString(3));
		D.setSpec(rs.getString(4));
		D.setExp(rs.getInt(5));
		D.setWrkhrs(rs.getInt(6));
		D.setImg(rs.getString(7));
		
		return D;
	}

}

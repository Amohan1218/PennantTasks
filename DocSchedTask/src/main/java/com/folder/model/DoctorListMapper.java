package com.folder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoctorListMapper implements RowMapper<DoctorList>{
	@Override
	public DoctorList mapRow(ResultSet rs, int i) throws SQLException{
		DoctorList D = new DoctorList();
		
		D.setDoctorId(rs.getInt(1));
		D.setFullName(rs.getString(2));
		D.setSpecializationId(rs.getInt(3));
		D.setQualification(rs.getString(4));
		D.setExperience(rs.getInt(5));
		D.setDesignation(rs.getString(6));
		D.setImageUrl(rs.getString(7));
		
		return D;
	}
}

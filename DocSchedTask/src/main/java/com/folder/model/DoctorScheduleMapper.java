package com.folder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoctorScheduleMapper implements RowMapper<DoctorSchedule> {
	@Override
	public DoctorSchedule mapRow(ResultSet rs, int i) throws SQLException{
		
		DoctorSchedule docSch = new DoctorSchedule();
			
		docSch.setDoct_id(rs.getInt("doct_id"));
		docSch.setDcsc_schedule(null);
		docSch.setDcsc_avl_from(null);
		docSch.setDcsc_avl_to(null);
		
		return docSch;
	}
}

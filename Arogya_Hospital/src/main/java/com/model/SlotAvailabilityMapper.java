package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlotAvailabilityMapper implements RowMapper<SlotAvailability>{

	@Override
	public SlotAvailability mapRow(ResultSet rs, int rowNum) throws SQLException {
		SlotAvailability S = new SlotAvailability();
		
		java.sql.Date v3 = rs.getDate(3);
		
		S.setSlot_id(rs.getInt(1));
		S.setSlot_doc_id(rs.getInt(2));
		S.setSlot_date(v3.toLocalDate());
		S.setSlot_from(rs.getString(4));
		S.setSlot_to(rs.getString(5));
		S.setSlot_status(rs.getString(6));
		
		return S;
	}

}

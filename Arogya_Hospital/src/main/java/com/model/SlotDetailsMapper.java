package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlotDetailsMapper implements RowMapper<SlotDetails> {

	@Override
	public SlotDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		SlotDetails s = new SlotDetails();
		
		s.setSlotFrom(rs.getString(4));
		s.setSlotTo(rs.getString(5));
		
		return s;
	}

}

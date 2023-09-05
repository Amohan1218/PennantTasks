package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlotAvlDatesMapper implements RowMapper<SlotAvlDates>{

	@Override
	public SlotAvlDates mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SlotAvlDates SAD = new SlotAvlDates();
		SAD.setDate(rs.getString(1));
		
		return SAD;
	}

}

package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SlotAvlMapper implements RowMapper<SlotAvl>{

	@Override
	public SlotAvl mapRow(ResultSet rs, int rowNum) throws SQLException {
		SlotAvl S = new SlotAvl();
		
		S.setSlot_id(rs.getInt(1));
		S.setSlot_doc_id(rs.getInt(2));
		S.setSlot_date(rs.getString(3));
		S.setSlot_from(rs.getString(4));
		S.setSlot_to(rs.getString(5));
		S.setSlot_status(rs.getString(6));
		
		return S;
	}

}

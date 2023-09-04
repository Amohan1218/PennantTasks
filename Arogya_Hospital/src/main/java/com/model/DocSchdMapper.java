package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DocSchdMapper implements RowMapper<DocSchd>{

	@Override
	public DocSchd mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocSchd d = new DocSchd();
		
		d.setDocId(rs.getInt(1));
		d.setWklySchd(rs.getString(2));
		d.setMrngSlot(rs.getString(3));
		d.setMrngSlot(rs.getString(4));
		d.setSlotDuration(rs.getInt(5));
		d.setRange(rs.getInt(6));
		
		return d;
	}

}

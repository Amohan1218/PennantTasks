package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DocSchdMapper implements RowMapper<DocSchd>{

	@Override
	public DocSchd mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocSchd d = new DocSchd();
		
		d.setDocId(rs.getInt(1));
		d.setSlotIndex(rs.getInt(2));
		d.setWklySchd(rs.getString(3));
		d.setSlotFrom(rs.getString(4));
		d.setSlotTo(rs.getString(5));
		d.setSlotDuration(rs.getInt(6));
		d.setRange(rs.getInt(7));
		
		return d;
	}

}

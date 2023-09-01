package com.folder.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AuthenticateMapper implements RowMapper<Credentials>{

	@Override
	public Credentials mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Credentials c = new Credentials();
		
		c.setUserName(rs.getString("username"));
		c.setPassword(rs.getString("password"));
		
		return c;
	}
}

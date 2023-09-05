package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User c = new User();
		
		c.setUserName(rs.getString("username"));
		c.setPassword(rs.getString("password"));
		
		return c;
	}
}
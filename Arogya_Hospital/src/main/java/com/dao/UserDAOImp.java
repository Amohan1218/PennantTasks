package com.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.UserMapper;
import com.model.User;

public class UserDAOImp implements UserDAO{
	JdbcTemplate jdbcTemplate;	

	private final String SQL_FIND_USER = "select * from ms_mydb where username = ?";
	private final String SQL_CREATE_USER = "insert into ms_mydb values(?, ?)";

	@Autowired
	public UserDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User getUser(String uname) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { uname }, new UserMapper());
	}

	@Override
	public int createUser(User c) {
		return jdbcTemplate.update(SQL_CREATE_USER, c.getUserName(), c.getPassword());
	}
}
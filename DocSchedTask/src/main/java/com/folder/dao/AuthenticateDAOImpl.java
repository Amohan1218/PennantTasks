package com.folder.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.folder.model.AuthenticateMapper;
import com.folder.model.Credentials;

public class AuthenticateDAOImpl implements AuthenticateDAO{
	JdbcTemplate jdbcTemplate;	

	private final String SQL_FIND_USER = "select * from ms_mydb where username = ?";
	private final String SQL_CREATE_USER = "insert into ms_mydb values(?, ?)";

	@Autowired
	public AuthenticateDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Credentials getUser(String uname) {
		return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { uname }, new AuthenticateMapper());
	}

	@Override
	public int createUser(Credentials c) {
		return jdbcTemplate.update(SQL_CREATE_USER, c.getUserName(), c.getPassword());
	}
}

package com.dao;

import com.model.User;

public interface UserDAO {
	
	User getUser(String uname);
	int createUser(User c);
}
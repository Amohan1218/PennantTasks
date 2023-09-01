package com.folder.dao;

import com.folder.model.Credentials;

public interface AuthenticateDAO {
	Credentials getUser(String uname);
	
	int createUser(Credentials c);
}

package com.neuedu.dao;

import com.neuedu.entity.Account;

public interface LoginDao {

	 Account LogonLogic(String name, String password);

	 void addToken(Account acc, String token);
	
	String findTokenByAccountId(int accountid);
}

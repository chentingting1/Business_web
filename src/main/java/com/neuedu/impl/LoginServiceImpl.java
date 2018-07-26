package com.neuedu.impl;

import com.neuedu.dao.LoginDao;
import com.neuedu.dao.impl.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao ld = new LoginDaoImpl();

	public Account LogonLogic(String name, String password) {

		return ld.LogonLogic(name, password);
	}

	@Override
	public void addToken(Account acc, String token) {
		ld.addToken(acc, token);
	}

	@Override
	public String findTokenByAccountId(int accountid) {
		
		return ld.findTokenByAccountId(accountid);
	}

}

package com.bosch.matchmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.matchmanager.dao.AccountDao;
import com.bosch.matchmanager.model.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDAO;
	
	public boolean checkAccount(String username, String password){
		return accountDAO.checkAccount(username, password);
	}
	
	public List<Account> getAllAccounts(){
		return accountDAO.getAllAccounts();
	}
}

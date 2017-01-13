package com.bosch.matchmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bosch.matchmanager.model.Account;


@Repository
public class AccountDao {
	@PersistenceContext
	private EntityManager em;
	
	public boolean checkAccount(String username, String password){
		TypedQuery<Account> account = em.createQuery("SELECT a FROM Account a WHERE a.username = '" + username + "' AND a.password = '" + password + "'", Account.class);
		if(account.getResultList().size() > 0)
			return true;
		return false;
	}
	
	public List<Account> getAllAccounts(){
		TypedQuery<Account> account = em.createQuery("SELECT a FROM Account a", Account.class);
		return account.getResultList();
	}
}

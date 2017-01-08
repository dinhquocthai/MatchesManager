package com.bosch.matchmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Account implements Serializable{
	
	private static final long serialVersionUID = -34591357104102856L;
	
	@Id
    @GeneratedValue
    @Column
    private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	public Account(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

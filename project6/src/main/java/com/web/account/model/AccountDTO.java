package com.web.account.model;

import java.sql.Date;

public class AccountDTO {
	private int id;				// Column Name : ID
	private String username;	// Column Name : USERNAME
	private String password;	// Column Name : PASSWORD
	private String email;		// Column Name : EMAIL
	private Date joinDate;		// Column Name : JOINDATE
	
	public AccountDTO() {
		this.username = "";
		this.email = "";
	}
	
	public AccountDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public AccountDTO(String username, String password, String email) {
		this(username, password);
		this.email = email;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public boolean equalsPassword(AccountDTO dto) {
		return this.password.equals(dto.getPassword());
	}
}

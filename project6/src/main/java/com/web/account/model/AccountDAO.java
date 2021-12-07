package com.web.account.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.db.conn.OracleConnect;

public class AccountDAO {
	private OracleConnect oc;
	
	public AccountDAO() {
		this.oc = new OracleConnect(true);
	}

	public boolean insert(AccountDTO dto) {
		String query = "INSERT INTO ACCOUNTS VALUES("
				+ "ACCOUNTS_SEQ.NEXTVAL, "
				+ "'" + dto.getUsername() + "', "
				+ "'" + dto.getPassword() + "', "
				+ "'" + dto.getEmail() + "', "
				+ "SYSDATE)";
		
		int res = oc.insert(query);
		
		return res == 1 ? true : false;
	}

	public List<AccountDTO> select(String username) {
		String query = "SELECT * FROM ACCOUNTS WHERE USERNAME = '" + username + "'";
		ResultSet res = oc.select(query);
		
		List<AccountDTO> datas = new ArrayList<AccountDTO>();
		try {
			while(res.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setId(res.getInt("ID"));
				dto.setUsername(res.getString("USERNAME"));
				dto.setPassword(res.getString("PASSWORD"));
				dto.setEmail(res.getString("EMAIL"));
				dto.setJoinDate(res.getDate("JOINDATE"));
				datas.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public void commit() {
		oc.commit();
	}
	
	public void rollback() {
		oc.rollback();
	}
	
	public void close() {
		oc.close();
	}

}

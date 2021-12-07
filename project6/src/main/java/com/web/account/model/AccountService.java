package com.web.account.model;

import java.util.List;

public class AccountService {

	public boolean isValid(AccountDTO dto) {
		if(isEmpty(dto.getUsername()) || isEmpty(dto.getPassword())
				|| isEmpty(dto.getEmail())) {
			return false;
		}
		return true;
	}

	private boolean isEmpty(String str) {
		return str.isEmpty();
	}

	public boolean add(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		int count = dao.select(dto.getUsername()).size();
		if(count == 0) {
			boolean res = dao.insert(dto);
			if(res) {
				dao.commit();
				dao.close();
				return true;
			} else {
				dao.rollback();
				dao.close();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean login(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> data = dao.select(dto.getUsername());
		if(data.size() == 1) {
			AccountDTO userData = data.get(0);
			if(dto.equalsPassword(userData)) {
				dto.setId(userData.getId());
				dto.setPassword("");
				dto.setEmail(userData.getEmail());
				dto.setJoinDate(userData.getJoinDate());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}







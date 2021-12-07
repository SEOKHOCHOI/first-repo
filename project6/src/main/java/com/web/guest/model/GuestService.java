package com.web.guest.model;

import java.util.List;

public class GuestService {
	
	public boolean create(GuestDTO dto) {
		GuestDAO dao = new GuestDAO();
		boolean res = dao.add(dto);
		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return res;
	}

	public boolean isValid(GuestDTO dto) {
		if(dto.getWriter().length() <= 4) {
			return false;
		} else if(dto.getWriter().length() > 20) {
			return false;
		}
		return true;
	}

	public List<GuestDTO> searchAll() {
		GuestDAO dao = new GuestDAO();
		return dao.getList();
	}
}

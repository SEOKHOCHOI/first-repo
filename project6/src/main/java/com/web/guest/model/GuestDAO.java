package com.web.guest.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class GuestDAO {
	OracleConnect oc = null;
	
	public GuestDAO() {
		this.oc = new OracleConnect(true);
	}
	
	public boolean add(GuestDTO dto) {
		String query = "INSERT INTO GUESTBOOK VALUES(GUESTBOOK_SEQ.NEXTVAL, "
				+ "'" + dto.getWriter() + "', "
				+ "'" + dto.getContext() + "', "
				+ "TO_DATE('" + dto.getgDate() + "', 'YYYY-MM-DD'))";
		
		int res = oc.insert(query);
		
		return res == 1 ? true : false;
	}
	
	public List<GuestDTO> getList() {
		String query = "SELECT * FROM GUESTBOOK";
		
		List<GuestDTO> datas = new ArrayList<GuestDTO>();
		
		ResultSet res = oc.select(query);
		
		try {
			while(res.next()) {
				GuestDTO dto = new GuestDTO();
				dto.setId(res.getInt("ID"));
				dto.setWriter(res.getString("WRITER"));
				dto.setContext(res.getString("CONTEXT"));
				dto.setgDate(res.getDate("G_DATE"));
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

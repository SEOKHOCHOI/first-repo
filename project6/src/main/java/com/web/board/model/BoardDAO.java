package com.web.board.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.conn.OracleConnect;

public class BoardDAO {
	private OracleConnect oc = null;
	
	public BoardDAO() {
		this.oc = new OracleConnect(true);
	}

	public List<BoardDTO> select() {
		List<BoardDTO> datas = null;
		String query = "SELECT * FROM BOARDS";
		ResultSet rs = oc.select(query);
		try {
			datas = new ArrayList<BoardDTO>();
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setId(rs.getInt("ID"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
				data.setCreateDate(rs.getDate("CREATEDATE"));
				data.setUpdateDate(rs.getDate("UPDATEDATE"));
				data.setViewCnt(rs.getInt("VIEWCNT"));
				datas.add(data);
			}
			rs.close();
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

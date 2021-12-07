package com.web.board.model;

import java.util.List;

public class BoardService {

	public List<BoardDTO> getList() {
		List<BoardDTO> datas = null;
		BoardDAO dao = new BoardDAO();
		datas = dao.select();
		dao.close();
		return datas;
	}

}

package com.web.guest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.guest.model.GuestDTO;
import com.web.guest.model.GuestService;

@WebServlet("/guest")  // 애너테이션(장식자)
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GuestService service = new GuestService();
		List<GuestDTO> datas = service.searchAll();
		
		request.setAttribute("datas", datas);
		
		String view = "/WEB-INF/jsp/guest/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String context = request.getParameter("context");
		String date = request.getParameter("date");
		
		GuestDTO dto = new GuestDTO();
		dto.setWriter(writer);
		dto.setContext(context);
		dto.setgDate(date);
		
		GuestService service = new GuestService();
		
		// 유효성검사(필수입력체크, 문자열 형식, 제한문자검사...)
		String view = "/WEB-INF/jsp/guest/index.jsp";
		if(service.isValid(dto)) {
			// 데이터 형식 이상 없음
			if(service.create(dto)) {
				response.sendRedirect("/guest");
			} else {
				// 저장 실패
				request.setAttribute("error_type", "저장 실패");
				RequestDispatcher rp = request.getRequestDispatcher(view);
				rp.forward(request, response);
			}
		} else {
			// 데이터 형식 이상 있음
			request.setAttribute("error_type", "데이터 형식 오류");
			RequestDispatcher rp = request.getRequestDispatcher(view);
			rp.forward(request, response);
		}
		
	}

}

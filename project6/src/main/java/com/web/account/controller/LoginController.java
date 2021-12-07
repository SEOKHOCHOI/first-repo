package com.web.account.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.account.model.AccountDTO;
import com.web.account.model.AccountService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/account/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user_id");
		String password = request.getParameter("user_pw");
		
		AccountDTO dto = new AccountDTO(username, password);
		AccountService service = new AccountService();
		
		if(service.login(dto)) {
			HttpSession session = request.getSession();
			session.setAttribute("s_login_user", dto.getUsername()); // 세션객체는 서버가 관리한다.(서버에 저장된다.)
			
			Cookie cookie = new Cookie("login_user", dto.getUsername());
			cookie.setMaxAge(60*30);
			response.addCookie(cookie);
			response.sendRedirect("/");
		} else {
			System.out.println("로그인 실패");
		}
	}

}






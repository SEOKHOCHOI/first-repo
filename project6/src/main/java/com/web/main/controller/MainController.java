package com.web.main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_user = "";
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("login_user")) {
				login_user = c.getValue();
			}
		}
		
		if(login_user.equals("")) {
			// 로그인 안한 상태
			request.setAttribute("logined", false);
		} else {
			// 로그인 한 상태
			request.setAttribute("logined", true);
		}
		
		HttpSession session = request.getSession();
		String s_login_user = "";
		if(session.getAttribute("s_login_user") != null) {
			s_login_user = (String) session.getAttribute("s_login_user");
		}
		
		if(s_login_user.equals("")) {
			// 로그인 안한 상태
			request.setAttribute("s_logined", false);
		} else {
			// 로그인 한 상태
			request.setAttribute("s_logined", true);
		}
		
		String view = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

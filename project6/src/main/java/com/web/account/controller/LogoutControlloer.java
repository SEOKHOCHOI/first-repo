package com.web.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("login_user")) {
				c.setMaxAge(0);	// 유효 시간을 0으로 만들어서 만료시킴.
				response.addCookie(c);
			}
		}
		
		HttpSession session = request.getSession();
		// session.removeAttribute("s_login_user");
		session.invalidate();
		
		response.sendRedirect("/");
	}

}

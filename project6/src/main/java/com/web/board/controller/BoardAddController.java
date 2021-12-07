package com.web.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/board/add.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// enctype="multipart/form-data" 는 기존의 request.getParameter() 사용 안됨.
		// cos 라이브러리의 MultipartRequest 객체를 사용해야 함.
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/upload"),
				1024 * 1024 * 10,
				"utf-8",
				new DefaultFileRenamePolicy());
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		
		System.out.println("/upload/" + multi.getFile("uploadFile").getName());
		System.out.println("/upload/" + multi.getFilesystemName("uploadFile"));
		System.out.println(multi.getFile("uploadFile").length());
	}

}

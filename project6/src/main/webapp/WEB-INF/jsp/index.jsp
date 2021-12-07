<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link type="">
<script type="text/javascript" src="/static/js/sample.js"></script>
</head>
<body>
    <h1>메인 페이지 입니다.</h1>
    <div>
        <input type="text" id="id_url">
    </div>
    <ul>
        <li><a id="id_lotto" href="/lotto">로또번호 생성 페이지</a></li>
        <li><a id="id_guest" href="/guest">방명록 작성 페이지</a></li>
        <li><a href="/board">게시판</a></li>
        <%
        	boolean logined = (boolean) request.getAttribute("logined");
        	if(logined) {
        %>
        	<li><a id="id_join" href="/info">내정보 페이지</a></li>
	        <li><a id="id_login" href="/logout">로그아웃 페이지</a></li>
        <%
        	} else {
   		%>
	        <li><a id="id_join" href="/join">회원가입 페이지</a></li>
	        <li><a id="id_login" href="/login">로그인 페이지</a></li>
        <%		
        	}
        %>
    </ul>
    
    <%
    	boolean s_logined = (boolean) request.getAttribute("s_logined");
    	if(s_logined) {
    %>
    		<h1><%=(String) request.getSession().getAttribute("s_login_user") %>님 환영합니다.</h1>
    <%
    	} else {
    %>
    		<h1>로그인을 하지 않았습니다.</h1>
    <%
    	}
    %>
    
</body>
</html>
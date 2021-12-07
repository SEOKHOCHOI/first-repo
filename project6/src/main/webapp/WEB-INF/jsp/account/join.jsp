<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.account.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="/static/js/sample.js"></script>
</head>
<body>
	<%
		AccountDTO initData = new AccountDTO();
		String error = "";
		
		if(request.getAttribute("init") != null) {
			initData = (AccountDTO) request.getAttribute("init");
		}
		
		if(request.getAttribute("error") != null) {
			error = (String) request.getAttribute("error");
		}
	%>
	<h1>회원가입</h1>
	<form action="./join" method="post">
		<div>
			<input type="text" id="id_username" name="username" value="<%=initData.getUsername() %>" placeholder="계정명">
			<button type="button" onclick="initData();">초기화</button>
		</div>
		<div>
			<input type="password" name="password" placeholder="패스워드">
		</div>
		<div>
			<input type="password" name="password_check" placeholder="패스워드 확인">
		</div>
		<div>
			<input type="email" name="email" value="<%=initData.getEmail() %>" placeholder="이메일 주소">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>
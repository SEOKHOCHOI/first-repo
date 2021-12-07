<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
         import="com.web.guest.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script type="text/javascript" src="/static/js/guest.js"></script>
</head>
<body>
	<form id="guest_form" action="./guest" method="post">
		<input type="text" name="writer" placeholder="작성자" value="<%=request.getParameter("writer") %>" required>
		<textarea name="context" placeholder="방명록 작성" required><%=request.getParameter("context") %></textarea>
		<input type="hidden" name="date">
		<button type="submit">전송</button>
	</form>
	<div><%=(String) request.getAttribute("error_type") %></div>
	<table>
	<%
		List<GuestDTO> datas = (List<GuestDTO>) request.getAttribute("datas");
	
		for(GuestDTO data: datas) {
	%>
		<tr>
			<td><%=data.getId() %></td>
			<td><%=data.getWriter() %></td>
			<td><%=data.getContext() %></td>
			<td><%=data.getgDate() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
		import="com.web.board.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인</title>
</head>
<body>
	<div>
		<a href="/board/add">글쓰기</a>
	</div>
	<div>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<%
				List<BoardDTO> datas = (List<BoardDTO>) request.getAttribute("datas");
				for(BoardDTO data: datas) {
			%>
				<tr>
					<td><%=data.getId() %></td>
					<td><a href="/board/detail?id=<%=data.getId() %>"><%=data.getTitle() %></a></td>
					<td><%=data.getWriter() %></td>
					<td><%=data.getCreateDate() %></td>
					<td><%=data.getViewCnt() %></td>
				</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>
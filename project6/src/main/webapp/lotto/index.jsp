<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로또번호 생성 페이지</title>
</head>
<body>
	<h2>로또 게임 횟수 입력</h2>
    <form action="./result.jsp" method="get">
    	<input type="text" name="game_count" placeholder="게임 수를 입력하세요.">
    	<button type="submit">실행</button>
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<body>
	<div>
		<form action="/board/add" method="post" enctype="multipart/form-data">
			<div>
				<input type="text" name="title">
			</div>
			<div>
				<input type="text" name="writer">
			</div>
			<div>
				<textarea name="content"></textarea>
			</div>
			<div>
				<input type="file" name="uploadFile">
			</div>
			<div>
				<button type="submit">저장</button>
			</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h2>직원등록</h2>

<form action="insertOk" method="post" name="mk" onsubmit="return main()">
	<table>
		<tr>
			<td>직원번호</td>
			<td><input type="text" name="mno"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone"><br>
			<span id="errPhone"></span>
			</td>
		</tr>
		<tr>
			<td>직급</td>
			<td><input type="text" name="position"></td>
		</tr>
		<tr>
			<td>이메일주소</td>
			<td><input type="text" name="email" id="email"><br>
			<span id="errEmail"></span></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>
</body>
<script src="/static/js/insert.js"></script>
</html>
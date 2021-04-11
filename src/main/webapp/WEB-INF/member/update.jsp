<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>직원등록</h2>

<form action="updateOk" method="post">
	<input type="hidden" value="${dto.mno}" name="no">
	<table>
		<tr>
			<td>직원번호</td>
			<td><input type="text" name="mno" value="${dto.mno}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${dto.name}"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="${dto.phone}"></td>
		</tr>
		<tr>
			<td>직급</td>
			<td><input type="text" name="position" value="${dto.position}"></td>
		</tr>
		<tr>
			<td>이메일주소</td>
			<td><input type="text" name="email" value="${dto.email}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>

</body>
</html>
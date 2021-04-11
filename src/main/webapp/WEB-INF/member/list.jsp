<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>직원목록</h2>
	<button id="down">목록받기</button>
	<table>
		<tr>
			<th>직원번호</th>
			<th>직급</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>삭제/수정</th>
		</tr>
	<c:forEach items="${list}" var="dto">
		<tr class="tr1">
			<fmt:formatNumber minIntegerDigits="3" value="${dto.mno}" type="number" var="mno"/>
			<td id="mno">${mno}</td>
			<td>${dto.position}</td>
			<td>${dto.name}</td>
			<td>${dto.phone}</td>
			<td>${dto.email}</td>
			<td>
				<button class="deleteOk">삭제</button>
				<button class="update">수정</button>
			</td>
		</tr>
	</c:forEach>
	</table>
	<form method="post" action="list">
		<select name="searchOption">
			<option value="mno">직원번호</option>
			<option value="position">직급</option>
			<option value="name">이름</option>
			<option value="phone">전화번호</option>
			<option value="email">이메일</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</body>
<script src="/static/js/list.js"></script>
</html>
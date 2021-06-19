<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script>
<link rel="stylesheet" type="text/css" href="${R}common.css" />
<style>
a.btn {
	float: right;
	margin: -20px 0 5px 0;
}

td:nth-child(1), td:nth-child(5) {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>게시판</h1>
		<c:forEach var="member" items="${ members }">
		<h3>${ member.idx }- ${ member.username }</h3>
		<a href="create?idx=${member.idx }" class="btn">새 글</a>
		</c:forEach>
		<table class="list">
			<thead>
				<tr>
					<th>index</th>
					<th>제목</th>
					<th>날짜</th>
					<th>작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${ boards }">
					<tr data-url="content?idx=${ board.idx }">
						<td>${ board.idx }</td>
						<td>${ board.title }</td>
						<td>${ board.date }</td>
						<td>${ board.member.username}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
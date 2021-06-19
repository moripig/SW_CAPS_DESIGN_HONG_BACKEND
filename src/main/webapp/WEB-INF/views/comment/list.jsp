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
		
		<c:forEach var="board" items="${ boards }">
		<h3>${ board.idx }- ${ board.title }</h3>
		<a href="/board/content?idx=${board.idx}" class="btn">게시판 가기</a>
		<table class="list">
			<thead>
				<tr>
					<th>수정</th>
					<th>index</th>
					<th>내용</th>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="comment" items="${ board.comments }">
				<tr>
					<td><a href="edit?idx=${ comment.idx }" >수정</a></td>
						<td>${ comment.idx }</td>
						<td>${ comment.content }</td>
						<td>${ comment.date }</td>
						<td>${ comment.member.idx }</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:forEach>

	</div>
</body>
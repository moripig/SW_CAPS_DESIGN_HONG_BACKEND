<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<form:form modelAttribute="board">
		<div class="container">
			<h1>${board.idx}- ${ board.title }</h1>
			<a href="create" class="btn">새글 등록</a>

			<table class="list">
				<thead>
					<tr>
						<th>내용</th>
						<th>날짜</th>
						<th>작성자</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ board.content}</td>
						<td>${ board.date }</td>
						<td>${ board.member.idx }</td>
					</tr>
				</tbody>

			</table>
			<h1>댓글</h1>
			<table class="list">
				<thead>
					<tr>
						<th>index</th>
						<th>내용</th>
						<th>날짜</th>
						<th>작성자</th>
						<th>작성시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="comment" items="${ board.comments }">
						<tr>
							<td>${ comment.idx}</td>
							<td>${ comment.content }</td>
							<td>${ comment.date}</td>
							<td>${ comment.member.username }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<a href="/comment/create?idx=${ board.idx }" class="btn">댓글 달기</a>
			<a href="edit?idx=${ board.idx }" class="btn">수정</a> 
			<a href="list" class="btn">목록으로</a>
		</div>
	</form:form>
</body>
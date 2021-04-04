<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>회원목록</h1>
		<a href="create" class="btn">회원등록</a>
		<table class="list">
			<thead>
				<tr>
					<th>index</th>
					<th>아이디</th>
					<th>email</th>
					<th>password</th>
					<th>이름</th>
					<th>성별</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${ members }">
					<tr data-url="edit?mem_idx=${ member.mem_idx }">
						<td>${ member.mem_idx }</td>
						<td>${ member.mem_userid }</td>
						<td>${ member.mem_email}</td>
						<td>${ member.mem_password }</td>
						<td>${ member.mem_username }</td>
						<td>${ member.mem_gender }</td>
						<td>${ member.mem_address }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
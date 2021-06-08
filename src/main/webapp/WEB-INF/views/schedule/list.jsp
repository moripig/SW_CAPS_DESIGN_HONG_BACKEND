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
</head>
<body>
	<div class="container">
		<h1>일정목록</h1>
		<c:forEach var="member" items="${ members }">
			<h3>${ member.mem_idx }- ${ member.mem_username }</h3>
			<a href="create?mem_idx=${member.mem_idx }" class="btn">일정등록</a>
			<table class="list">
				<thead>
					<tr>
						<th>index</th>
						<th>출발날</th>
						<th>끝나는날</th>
						<th>장소</th>
						<th>인원</th>
						<th>회원index</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="schedule" items="${ member.schedules }">
						<tr data-url="edit?sche_idx=${ schedule.sche_idx }">
							<td>${ schedule.sche_idx }</td>
							<td>${ schedule.sche_start }</td>
							<td>${ schedule.sche_end }</td>
							<td>${ schedule.sche_loca }</td>
							<td>${ schedule.sche_num }</td>
							<td>${ shcedule.member.mem_idx }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script>
<link rel="stylesheet" href="${R}common.css">
<style>
form {
	width: 600px;
	margin: auto;
	box-shadow: 0 0 4px lightgray, 2px 2px 4px gray;
	overflow: auto;
}

div.title {
	font-size: 20pt;
	padding: 10px;
	background-color: #eee;
}

table {
	margin: 20px;
}

td {
	min-width: 100;
	padding: 5px;
}

td:nth-child(1) {
	text-align: right;
}

button {
	margin: 5px 0 20px 20px;
}
</style>
</head>
<body>
	<div class="container">
		<form:form method="post" modelAttribute="member">
			<div class="title">회원 ${ member.mem_idx > 0  ? "수정" : "등록" }</div>
			<table>
				<tr>
					<td>index:</td>
					<td><form:input path="mem_idx" disabled="true" /></td>
				</tr>
				<tr>
					<td>아이디:</td>
					<td><form:input path="mem_userid" /></td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><form:input path="mem_password" /></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><form:input path="mem_username" />></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><form:input path="mem_address" /></td>
				</tr>
				<tr>
					<td>성별:</td>
					<td><form:radiobutton path="mem_gender" value="1" label="남자" />
						<form:radiobutton path="mem_gender" value="2" label="여자" /></td>
				</tr>
				<tr>
					<td>이메일:</td>
					<td><form:input path="mem_email" type="email" /></td>
				</tr>
			</table>
			<hr />
			<div>
				<button type="submit" class="btn">저장</button>
				<c:if test="${ member.mem_idx > 0 }">
					<a href="delete?mem_idx=${ member.mem_idx }" class="btn"
						data-confirm-delete>삭제</a>
				</c:if>
				<a href="list" class="btn">목록으로</a>
			</div>
		</form:form>
	</div>
</body>
</html>
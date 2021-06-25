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
			<div>
				<table>
					<tr>
						<td>${ member.idx }</td>
						<td>${ member.userId }</td>
						<td>${ member.email}</td>
						<td>${ member.password }</td>
						<td>${ member.userName }</td>
						<td>${ member.gender }</td>
						<td>${ member.address }</td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>
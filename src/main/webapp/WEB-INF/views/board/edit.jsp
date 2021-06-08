<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.text.SimpleDateFormat" %>

<c:url var="R" value="/" />
<%@ page import="java.util.Date" %>
<% Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = format.format(now);
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <link rel="stylesheet" href="${R}common.css">
  <style>
    form { width: 600px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    div.title { font-size: 20pt; padding: 10px; background-color: #eee; }
    table { margin: 20px; }
    td { min-width: 100; padding: 5px; }
    td:nth-child(1) { text-align: right; }
    button { margin: 5px 0 20px 20px; }  
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="board">
    <div class="title">글 ${ board.board_idx > 0  ? "수정" : "등록" }</div>
    <table>
     <tr>
        <td>작성자:</td>
        <td><form:input path="member.mem_idx" /> </td>
      </tr>
     
     <tr>
        <td>index:</td>
        <td><form:input path="board_idx" disabled="true" /></td>        
      </tr>
      <tr>
        <td>제목:</td>
        <td><form:input path="board_title" /></td>        
      </tr>
      <tr>
        <td>내용:</td>
        <td><form:textarea path="board_content" /></td>
      </tr>
      <tr>
        <td>시간:</td>
        <td><form:input path="board_date" value="<%= date %>"/></td>
        
      </tr>
      


    </table>
    <hr />
    <div>
      <button type="submit" class="btn">저장</button>
      <c:if test="${ board.board_idx > 0 }">
        <a href="delete?board_idx=${ board.board_idx }" class="btn" data-confirm-delete>삭제</a>
      </c:if>
      <a href="list" class="btn">목록으로</a>
    </div>
  </form:form>
</div>
</body>
</html>
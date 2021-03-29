<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>MemberTest</title>
</head>
<body style="text-align: center">

<%--<form action="/member/delete" method="post">--%>
<form action="/member/signup" method="post">
  <div>
    <label for="mem_userid">아이디: </label>
    <input id="mem_userid" name="mem_userid" type="text">
  </div>
  <div>
    <label for="mem_password">패스워드: </label>
    <input id="mem_password" name="mem_password" type="password">
  </div>
  <div>
    <label for="mem_email">메일주소: </label>
    <input id="mem_email" name="mem_email" type="text">
  </div>
  <div>
    <label for="mem_username">이름: </label>
    <input id="mem_username" name="mem_username" type="text">
  </div>
  <div>
    <label for="mem_gender">성별: </label>
    <input id="mem_gender" name="mem_gender" type="text">
  </div>
  <div>
    <label for="mem_address">주소: </label>
    <input id="mem_address" name="mem_address" type="text">
  </div>
  <div>
    <label for="mem_idx">인덱스: </label>
    <input id="mem_idx" name="mem_idx" type="text">
  </div>
  <input type="submit" value="가입하기">
</form>

</body>
</html>


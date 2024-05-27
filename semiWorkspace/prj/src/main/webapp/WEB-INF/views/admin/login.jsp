<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/login/util.jsp" %>
<%@ include file="/WEB-INF/views/admin-seller/layout/alert.jsp" %>

<c:remove var="alertMsg" scope="session" />
</head>
<body>
	<div class="container">
	   	<%@ include file="/WEB-INF/views/admin-seller/layout/login/nav.jsp" %>
	   	<main>		
		   	<form action="/app/admin/login" method="post" class="form-login">
		       <div class="admin-fields">
		           <input type="email" name="adminId" id="adminId" placeholder="관리자 아이디 (이메일)">
		           <input type="password" name="adminPwd" id="adminPwd" placeholder="관리자 비밀번호">
		       </div>
		       <div>
		           <input type="submit" value="로그인">
		       </div>
		   	</form>
		</main>
	
	</div>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 로그인</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/login/util.jsp" %>
</head>
<body>
	<div class="container">
	   	<%@ include file="/WEB-INF/views/admin-seller/layout/login/nav.jsp" %>
	   	<main>		
		   	<form action="/admin/login" method="post" class="form-login">
		       <div class="seller-fields">
		           <input type="email" name="sellerId" id="sellerId" placeholder="판매자 아이디 (이메일)">
		           <input type="password" name="sellerPwd" id="sellerPwd" placeholder="판매자 비밀번호">
		       </div>
		       <div>
		           <input type="submit" value="로그인">
		       </div>
		   	</form>
		</main>
	   	<%@ include file="/WEB-INF/views/admin-seller/layout/login/link.jsp" %>
	
	</div>


</body>
</html>

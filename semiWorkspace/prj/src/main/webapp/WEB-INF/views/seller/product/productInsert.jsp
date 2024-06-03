<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/inquiry.css">
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
<%@ include file="/WEB-INF/views/admin-seller/layout/alert.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 상품추가</div>
    	<br>
    	<div id="third">
    		
    		<br>
    		<%@ include file="/WEB-INF/views/seller/layout/product/productInsert.jsp" %>
    	</div>
    	
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

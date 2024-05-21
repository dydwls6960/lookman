<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman관리자페이지</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/admin/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
    <main>
    	<div id="addr">관리자홈 > 회원관리 > 회원검색 > 회원정보</div>
    	<br>
    	<div id="info">
    		<div id="info-title">
		    	<span><span id="b-g">&#10073;</span> 유저정보</span>
    		</div>
    		<div id="info-content">
    			<table id="info-table">
    				
    			</table>
    		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>
  </div>
</body>
</html>

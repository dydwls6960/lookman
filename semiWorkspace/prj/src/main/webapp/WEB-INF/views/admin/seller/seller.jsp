<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman관리자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/inquiry.css">
<script def src="/app/resources/js/seller/product/inquiry.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>

</head>

<body>
  <%@ include file="/WEB-INF/views/admin/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
    <main>
	    <div id="addr">관리자홈 > 판매자관리</div>
    	<br>
    	<%@ include file="/WEB-INF/views/admin/layout/seller/seller.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 판매자리스트</span>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>판매자번호</th>
				  	<th>판매자아이디</th>
				    <th>판매명</th>
				    <th>소개</th>
				    <th>가입일</th>
				  </tr>
				  <c:forEach items="${sVoList}" var="sVo">
				  	  <tr>
					  	<td>${sVo.getSellerNo()}</td>
					    <td>${sVo.getAccName()}</td>
					    <td>${sVo.getName()}</td>
					    <td>${sVo.getInfo()}</td>
					    <td>${sVo.getCreatedDate()}</td>
					  </tr>
				  </c:forEach>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>
  </div>
</body>
</html>

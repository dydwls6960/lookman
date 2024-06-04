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
	    <div id="addr">관리자홈 > 회원관리 > 주문관리</div>
    	<br>
    	<%@ include file="/WEB-INF/views/admin/layout/member/order.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 상품리스트</span>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>주문번호</th>
				  	<th>주문자</th>
				    <th>주문일</th>
				    <th>총가격</th>
				  </tr>
				  <c:forEach items="${aolVoList}" var="aolVo">
				  	  <tr>
					  	<td>${aolVo.getOrderNo()}</td>
					    <td>${aolVo.getMemberName()}</td>
					    <td>${aolVo.getCreatedDate()}</td>
					    <td>${aolVo.getTotalPrice()}</td>
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

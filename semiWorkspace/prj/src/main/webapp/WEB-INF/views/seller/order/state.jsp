<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/order/state.css">
<script def src="/app/resources/js/seller/order/state.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 주문상태 </div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/order/searchState.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 판매내역</span>
	   		</div>
	   		<div>
	   			<table id="salesHistory" class="userList">
				  <tr>
				  	<th>주문번호</th>
				    <th>상품번호</th>
				    <th>주문자</th>
				    <th>주문상태</th>
				    <th>주문상태변경</th>
				  </tr>
				  <c:forEach items="${solVoList}" var="solVo">
				  	  <tr>
					  	<td>${solVo.getOrderDetailNo()}</td>
					    <td>${solVo.getProductNo()}</td>
					    <td>${solVo.getMemberName()}</td>
					    <td>${solVo.getStatusName()}</td>
					    <td>
					    	<input type="button" value="배송준비중" onclick="location.href='/app/seller/order/update?orderDetailNo=${solVo.getOrderDetailNo()}&status=prepare'">
    						<input type="button" value="배송시작" onclick="location.href='/app/seller/order/update?orderDetailNo=${solVo.getOrderDetailNo()}&status=start'">
    						<input type="button" value="배송완료" onclick="location.href='/app/seller/order/update?orderDetailNo=${solVo.getOrderDetailNo()}&status=complete'">
					    </td>
					  </tr>
				  </c:forEach>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

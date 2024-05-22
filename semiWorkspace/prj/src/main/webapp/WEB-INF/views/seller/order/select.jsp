<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/order/list.css">
<script def src="/app/resources/js/seller/order/list.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 판매내역 > 검색결과</div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/order/searchList.jsp" %>
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
				    <th>수량</th>
				    <th>주문상태</th>
				    <th>결제방식</th>
				    <th>주문일</th>
				  </tr>
				  <tr data-href="#">
				  	<td>2</td>
				    <td>1</td>
				    <td>이용진</td>
				    <td>2</td>
				    <td>입금전</td>
				    <td>무통장</td>
				    <td>24년05월19 11:00</td>
				  </tr>
				  <tr data-href="#">
				  	<td>2</td>
				    <td>3</td>
				    <td>이용진</td>
				    <td>4</td>
				    <td>입금전</td>
				    <td>무통장</td>
				    <td>24년05월19 11:00</td>
				  </tr>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

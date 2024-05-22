<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/list.css">
<script def src="/app/resources/js/seller/product/list.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 상품리스트 > 상품검색결과</div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/product/searchList.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div id="add">
		    	<span><span id="b-g">&#10073;</span> 상품리스트</span>
		    	<a href="#">+상품추가</a>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>상품번호</th>
				    <th>상품명</th>
				    <th>상품이미지</th>
				    <th>상품금액</th>
				    <th>수량</th>
				    <th>등록일</th>
				    <th>수정일</th>
				  </tr>
				  <tr data-href="#">
				  	<td>5</td>
				    <td>옷</td>
				    <td><img alt="" src=""> 옷~~~~</td>
				    <td>74,000원</td>
				    <td>5개</td>
				    <td>24년05월19 13:00</td>
				    <td>없음</td>
				  </tr>
				  <tr data-href="#">
				  	<td>3</td>
				    <td>옷</td>
				    <td><img alt="" src=""> 옷~~~~</td>
				    <td>34,000원</td>
				    <td>5개</td>
				    <td>24년05월19 13:00</td>
				    <td>없음</td>
				  </tr>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

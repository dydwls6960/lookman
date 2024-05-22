<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/review.css">
<script def src="/app/resources/js/seller/product/review.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 삼품 후기관리</div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/product/searchReview.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 상품리스트</span>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>후기번호</th>
				    <th>상품</th>
				    <th>제목</th>
				    <th>별점</th>
				    <th>작성자</th>
				    <th>작성일</th>
				  </tr>
				  <tr data-href="#">
				  	<td>3</td>
				    <td><img alt="" src=""> 옷이에요</td>
				    <td>잘맞아요</td>
				    <td>4.5</td>
				    <td>이용진</td>
				    <td>24년05월19 13:00</td>
				  </tr>
				  <tr data-href="#">
				  	<td>2</td>
				    <td><img alt="" src=""> 바지이에요</td>
				    <td>작아요</td>
				    <td>2.5</td>
				    <td>이용진</td>
				    <td>24년05월19 13:00</td>
				  </tr>
				  <tr data-href="#">
				  	<td>1</td>
				    <td><img alt="" src=""> 신발이에요</td>
				    <td>너무커요</td>
				    <td>3</td>
				    <td>이용진</td>
				    <td>24년05월19 13:00</td>
				  </tr>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

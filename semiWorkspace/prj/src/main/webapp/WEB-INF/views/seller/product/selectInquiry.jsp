<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/inquiry.css">
<script def src="/app/resources/js/seller/product/inquiry.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 상품 문의관리 > 문의 검색결과</div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/product/searchInquiry.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 상품리스트</span>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>번호</th>
				    <th>구분</th>
				    <th>제목</th>
				    <th>작성자</th>
				    <th>작성일</th>
				    <th>답변유무</th>
				  </tr>
				  <tr data-href="#">
				  	<td>5</td>
				    <td>카테고리1</td>
				    <td>옷이 배송이 안왔어요</td>
				    <td>이용진</td>
				    <td>24년05월19 13:00</td>
				    <td>N</td>
				  </tr>
				  <tr data-href="#">
				  	<td>1</td>
				    <td>카테고리1</td>
				    <td>옷 교환 신청할거임</td>
				    <td>이용진</td>
				    <td>24년05월19 13:00</td>
				    <td>Y</td>
				  </tr>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

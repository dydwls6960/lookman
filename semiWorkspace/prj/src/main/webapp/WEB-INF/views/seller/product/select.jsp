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
				  	<th>카테고리</th>
				    <th>상품명</th>
				    <th>상품이미지</th>
				    <th>상품금액</th>
				    <th>판매자</th>
				    <th>등록일</th>
				    <th>조회수</th>
				  </tr>
				  <c:forEach items="${pVoList}" var="pVo">
				  	  <tr data-href="#">
					  	<td>${pVo.getProductNo()}</td>
					  	<td>${pVo.getCategoryNo()}</td>
					    <td>${pVo.getName()}</td>
					    <td><img src="/app/resources/img/product/${pVo.getDeletedYn()}" width="100" height="100">${pVo.getDetails()}</td>
					    <td>${pVo.getPrice()}</td>
					    <td>${pVo.getSellerNo()}</td>
					    <td>${pVo.getCreatedDate()}</td>
					    <td>${pVo.getHit()}</td>
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

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
	    <div id="addr">판매자홈 > 상품리스트 > 상세조회결과</div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/product/detail/searchList.jsp" %>
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
				    <th>상품</th>
				    <th>상품금액</th>
				    <th>사이즈</th>
				    <th>색상</th>
				    <th>개수</th>
				  </tr>
				  <c:forEach items="${splVoList}" var="splVo">
				  	  <tr>
					  	<td>${splVo.getProductNo()}</td>
					  	<td>${splVo.getCategoryName()}</td>
					    <td><img src="/app/resources/img/product/${splVo.getImgName()}" width="100" height="100">${splVo.getProductName()}</td>
					    <td>${splVo.getProductPrice()}</td>
					    <td>${splVo.getSizeName()}</td>
					    <td>${splVo.getColorName()}</td>
					    <td>${splVo.getQuantity()}</td>
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

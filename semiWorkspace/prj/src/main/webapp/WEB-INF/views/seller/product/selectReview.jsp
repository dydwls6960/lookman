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
	    <div id="addr">판매자홈 > 후기관리 > 검색결과</div>
    	<br>
    	<%@ include file="/WEB-INF/views/seller/layout/product/searchReview.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 후기리스트</span>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>후기번호</th>
				    <th>상품번호</th>
				    <th>작성자</th>
				    <th>후기내용</th>
				    <th>별점</th>
				    <th>작성일</th>
				  </tr>
				  <c:forEach items="${sprVoList}" var="sprVo">
				  	  <tr>
					  	<td>${sprVo.getReviewNo()}</td>
					    <td>${sprVo.getProductNo()}</td>
					    <td>${sprVo.getMemberName()}</td>
					    <td>${sprVo.getContent()}</td>
					    <td>${sprVo.getRating()}</td>
					    <td>${sprVo.getCreatedDate()}</td>
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

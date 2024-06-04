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
	    <div id="addr">판매자홈 > 문의관리 > 검색결과</div>
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
				  	<th>문의번호</th>
				  	<th>상품번호</th>
				    <th>닉네임</th>
				    <th>문의제목</th>
				    <th>문의날짜</th>
				    <th>문의상태</th>
				  </tr>
				  <c:forEach items="${spiVoList}" var="spiVo">
				  	  <tr onclick="goInquiryUpdate(${spiVo.getProductInquiryNo()})">
					  	<td>${spiVo.getProductInquiryNo()}</td>
					    <td>${spiVo.getProductNo()}</td>
					    <td>${spiVo.getMemberName()}</td>
					    <td>${spiVo.getProductInquiryTitle()}</td>
					    <td>${spiVo.getAskDate()}</td>
					    <td>${spiVo.getStatusName()}</td>
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

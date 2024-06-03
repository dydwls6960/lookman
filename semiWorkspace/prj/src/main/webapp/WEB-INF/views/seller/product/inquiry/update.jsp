<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/inquiry.css">
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
<%@ include file="/WEB-INF/views/admin-seller/layout/alert.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 문의관리 > 수정하기</div>
    	<br>
    	<div id="third">
    		<div id="t-title">
			    <span><span id="b-g">&#10073;</span> 상품 문의내역</span>
			    <a href="/app/seller/home/product/inquiry">상품문의 바로가기</a>
    		</div>
    		<div>
    			<table id="userDeclaration" class="userList">
				  <tr>
				  	<th>문의번호</th>
				  	<th>상품번호</th>
				    <th>닉네임</th>
				    <th>문의제목</th>
				    <th>문의내용</th>
				    <th>답변내용</th>
				    <th>문의상태</th>
				  </tr>
				  
			  	  <tr>
				  	<td>${spiVo.getProductInquiryNo()}</td>
				    <td>${spiVo.getProductNo()}</td>
				    <td>${spiVo.getMemberName()}</td>
				    <td>${spiVo.getProductInquiryTitle()}</td>
				    <td>${spiVo.getqContent()}</td>
				    <td>${spiVo.getRespContent()}</td>
				    <td>${spiVo.getStatusName()}</td>
				  </tr>
		
				</table>
    		</div>
    		<br>
    		<%@ include file="/WEB-INF/views/seller/layout/product/insertInquiry.jsp" %>
    	</div>
    	
    	
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

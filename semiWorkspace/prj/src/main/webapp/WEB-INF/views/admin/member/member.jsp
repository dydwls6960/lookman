<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman관리자페이지</title>
<link rel="stylesheet" href="/app/resources/css/seller/product/inquiry.css">
<script def src="/app/resources/js/seller/product/inquiry.js"></script>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>

</head>

<body>
  <%@ include file="/WEB-INF/views/admin/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
    <main>
	    <div id="addr">관리자홈 > 회원관리</div>
    	<br>
    	<%@ include file="/WEB-INF/views/admin/layout/member/member.jsp" %>
    	<br><hr><br>
    	<div class="seller-div">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 상품리스트</span>
	   		</div>
	   		<div>
	   			<table id="productList" class="userList">
				  <tr>
				  	<th>회원번호</th>
				  	<th>회원아이디</th>
				    <th>회원이름</th>
				    <th>전화번호</th>
				    <th>가입일</th>
				  </tr>
				  <c:forEach items="${mVoList}" var="mVo">
				  	  <tr>
					  	<td>${mVo.getMemberNo()}</td>
					    <td>${mVo.getId()}</td>
					    <td>${mVo.getName()}</td>
					    <td>${mVo.getPhoneNo()}</td>
					    <td>${mVo.getCreatedDate()}</td>
					  </tr>
				  </c:forEach>
				</table>
	   		</div>
    	</div>
    	
    </main>
    <%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>
  </div>
</body>
</html>

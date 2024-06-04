<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
<%@ include file="/WEB-INF/views/admin-seller/layout/alert.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/seller/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/seller/layout/header.jsp" %>
    <main>
	    <div id="addr">판매자홈 > 통계</div>
    	<br>
    	
    	<div id="four">
    		<div id="f-title">
			    <span><span id="b-g">&#10073;</span> 판매자통계</span>
    		</div>
    		<div>
    			<table id="userDeclaration" class="userList">
				  <tr>
				  	<th>주문번호</th>
				    <th>상품번호</th>
				    <th>주문자</th>
				    <th>주문상태</th>
				    <th>상품가격</th>
				  </tr>
				  <c:forEach items="${solVoList}" var="solVo">
				  	  <tr>
					  	<td>${solVo.getOrderDetailNo()}</td>
					    <td>${solVo.getProductNo()}</td>
					    <td>${solVo.getMemberName()}</td>
					    <td>${solVo.getStatusName()}</td>
					    <td>${solVo.getPrice()}</td>
					  </tr>
				  </c:forEach>
				  <tr>
				    <th>평균가격</th>
				    <th>총가격</th>
				    <th>최소가격</th>
				    <th>최대가격</th>
				    <th>가격개수</th>
				  </tr>
				  <tr>
				  	<td>${sssVo.getAvg()}</td>
				  	<td>${sssVo.getTotal()}</td>
				  	<td>${sssVo.getMin()}</td>
				    <td>${sssVo.getMax()}</td>
				    <td>${sssVo.getCnt()}</td>
				  </tr>
				  <tr>
				    <th>찜수</th>
				    <th>주문수</th>
				    <th>총액</th>
				    <th>수수료</th>
				    <th>순이익</th>
				  </tr>
				  <tr>
				  	<td>${spsVo.getFavoriteCnt()}</td>
				  	<td>${spsVo.getOrderCnt()}</td>
				    <td>${spsVo.getTotalPrice()}</td>
				    <td>${spsVo.getCharge()}</td>
				    <td>${spsVo.getNetProfit()}</td>
				  </tr>
				</table>
    		</div>
    	</div>
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

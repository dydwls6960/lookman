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
	    <div id="addr">판매자홈</div>
    	<br>
    	<div id="first">
	    	<div id="f-title">
		    	<span><span id="b-g">&#10073;</span> 판매자 현황</span>
	   		</div>
    		<div id="f-content">
    			<span id="f-c-right" class="f-c-item">
    				판매자 상품현황
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>상품수</th>
						    <th>찜수</th>
						    <th>주문수</th>
						    <th>총액</th>
						    <th>수수료</th>
						    <th>순이익</th>
						  </tr>
						  <tr>
						  	<td>${spsVo.getProductCnt()}</td>
						  	<td>${spsVo.getFavoriteCnt()}</td>
						  	<td>${spsVo.getOrderCnt()}</td>
						    <td>${spsVo.getTotalPrice()}</td>
						    <td>${spsVo.getCharge()}</td>
						    <td>${spsVo.getNetProfit()}</td>
						  </tr>
						</table>
    				</div>
    			</span>
    			<span id="f-c-left" class="f-c-item">
    				누적금액
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>문의수</th>
						    <th>미처리수</th>
						    <th>처리수</th>
						    <th>삭제수</th>
						  </tr>
						 <tr>
						    <td>${siVo.getInquiryCnt()}</td>
						    <td>${siVo.getBeforeInquiryCnt()}</td>
						    <td>${siVo.getAfterInquiryCnt()}</td>
						    <td>${siVo.getDeleteInquiryCnt()}</td>
						</tr>

						</table>
    				</div>
    			</span>
    		</div>
    	</div>
    	
    	<div id="second">
    		<div id="s-title">
			    <span><span id="b-g">&#10073;</span> 상품내역</span>
			    <a href="/app/seller/home/product/list">상품내역 바로가기</a>
    		</div>
    		<div>
    			<table id="productList" class="userList">
				  <tr>
				  	<th>상품번호</th>
				  	<th>카테고리</th>
				    <th>상품</th>
				    <th>상품금액</th>
				    <th>판매자</th>
				    <th>등록일</th>
				  </tr>
				  <c:forEach items="${splVoList}" var="splVo">
				  	  <tr>
					  	<td>${splVo.getProductNo()}</td>
					  	<td>${splVo.getCategoryName()}</td>
					    <td><img src="/app/resources/img/product/${splVo.getImgName()}" width="100" height="100">${splVo.getProductName()}</td>
					    <td>${splVo.getProductPrice()}</td>
					    <td>${splVo.getSellerName()}</td>
					    <td>${splVo.getCreateDate()}</td>
					  </tr>
				  </c:forEach>
				</table>
    		</div>
    	</div>
    	
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
				    <th>문의날짜</th>
				    <th>문의상태</th>
				  </tr>
				  <c:forEach items="${spiVoList}" var="spiVo">
				  	  <tr>
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
    	
    	<div id="four">
    		<div id="f-title">
			    <span><span id="b-g">&#10073;</span> 간단 주문내역</span>
			    <a href="/app/seller/home/order/list">주문내역 바로가기</a>
    		</div>
    		<div>
    			<table id="userDeclaration" class="userList">
				  <tr>
				  	<th>주문번호</th>
				    <th>상품번호</th>
				    <th>주문자</th>
				    <th>주문상태</th>
				    <th>주문일</th>
				  </tr>
				  <c:forEach items="${solVoList}" var="solVo">
				  	  <tr>
					  	<td>${solVo.getOrderDetailNo()}</td>
					    <td>${solVo.getProductNo()}</td>
					    <td>${solVo.getMemberName()}</td>
					    <td>${solVo.getStatusName()}</td>
					    <td>${solVo.getCreateDate()}</td>
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

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
    				전체 상품현황
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>전체상품</th>
						    <th>전체 조회수</th>
						    <th>전체 찜목록</th>
						    <th>총 주문건수</th>
						    <th>총액</th>
						  </tr>
						  <tr>
						  	<td>${ssVo.getAllProductCnt()}</td>
						  	<td>${ssVo.getAllHitSum()}</td>
						  	<td>${ssVo.getAllFavoriteCnt()}</td>
						    <td>${ssVo.getAllOrderCnt()}</td>
						    <td>${ssVo.getAllPriceSum()}</td>
						  </tr>
						</table>
    				</div>
    			</span>
    			<span id="f-c-left" class="f-c-item">
    				누적금액
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>주문수</th>
						    <th>총주문금액</th>
						    <th>수수료</th>
						    <th>순이익</th>
						  </tr>
						 <tr>
						    <td>${ssVo.getAllOrderCnt()}</td>
						    <td>${ssVo.getAllPriceSum()}</td>
						    <td>${ssVo.getAllPriceSum()*0.1}</td>
						    <td>${ssVo.getAllPriceSum()-ssVo.getAllPriceSum()*0.1}</td>
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
				    <th>상품명</th>
				    <th>상품이미지</th>
				    <th>상품금액</th>
				    <th>판매자</th>
				    <th>등록일</th>
				    <th>조회수</th>
				  </tr>
				  <c:forEach items="${pVoList}" var="pVo">
				  	  <tr>
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
    	
    	<div id="third">
    		<div id="t-title">
			    <span><span id="b-g">&#10073;</span> 상품 문의내역</span>
			    <a href="/app/seller/home/product/inquiry">상품문의 바로가기</a>
    		</div>
    		<div>
    			<table id="userDeclaration" class="userList">
				  <tr>
				  	<th>문의번호</th>
				    <th>아이디</th>
				    <th>닉네임</th>
				    <th>상품상태</th>
				    <th>문의제목</th>
				    <th>문의내용</th>
				    <th>문의날짜</th>
				    <th>처리여부</th>
				  </tr>
				  <c:forEach items="${spiVoList}" var="spiVo">
				  	  <tr>
					  	<td>${spiVo.getProduct_inquiry_no()}</td>
					    <td>${spiVo.getMember_id()}</td>
					    <td>${spiVo.getMember_name()}</td>
					    <td>${spiVo.getStatus_name()}</td>
					    <td>${spiVo.getTitle()}</td>
					    <td>${spiVo.getQuestion_content()}</td>
					    <td>${spiVo.getAsk_date()}</td>
					    <td>${spiVo.getPrivate_yn()}</td>
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
				    <th>주문자</th>
				    <th>주문상태</th>
				    <th>결제방식</th>
				    <th>배송비</th>
				    <th>상품금액</th>
				    <th>주문일</th>
				  </tr>
				  <c:forEach items="${ssoVoList}" var="ssoVo">
				  	  <tr>
					  	<td>${ssoVo.getOrdersNo()}</td>
					    <td>${ssoVo.getMemberName()}</td>
					    <td>${ssoVo.getStatusName()}</td>
					    <td>${ssoVo.getCardName()}</td>
					    <td>${ssoVo.getShippingFee()}</td>
					    <td>${ssoVo.getProductPrice()}</td>
					    <td>${ssoVo.getCreatedDate()}</td>
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

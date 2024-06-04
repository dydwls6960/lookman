<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman관리자페이지</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
<%@ include file="/WEB-INF/views/admin-seller/layout/alert.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/admin/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
    <main>
    	<div id="addr">관리자홈</div>
    	<br>
    	<div id="first">
	    	<div id="f-title">
		    	<span><span id="b-g">&#10073;</span> 전체 회원통계</span>
	   		</div>
    		<div id="f-content">
    			<span id="f-c-right" class="f-c-item">
    				전체회원수
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>일반멤버</th>
						    <th>멤버쉽멤버</th>
						    <th>판매자</th>
						    <th>사용자수</th>
						  </tr>
						  <tr>
						    <td>${uVo.getMember()}</td>
						    <td>${uVo.getMembershipMember()}</td>
						    <td>${uVo.getSeller()}</td>
						    <td>${uVo.getTotalUser()}</td>
						  </tr>
						</table>
    				</div>
    			</span>
    			<span id="f-c-left" class="f-c-item">
    				누적금액
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>상품수</th>
						    <th>주문수</th>
						    <th>총액</th>
						    <th>수수료</th>
						    <th>순이익</th>
						  </tr>
						  <tr>
						  	<td>${spsVo.getProductCnt()}</td>
						  	<td>${spsVo.getOrderCnt()}</td>
						    <td>${spsVo.getTotalPrice()}</td>
						    <td>${spsVo.getCharge()}</td>
						    <td>${spsVo.getNetProfit()}</td>
						  </tr>
						</table>
    				</div>
    			</span>
    		</div>
    	</div>
    	
    	<div id="second">
    		<div id="s-title">
			    <span><span id="b-g">&#10073;</span> 쿠폰리스트</span>
			    <a href="#">쿠폰관리 바로가기</a>
    		</div>
    		<div>
    			<table id="userInquiry" class="userList">
				  <tr>
				  	<th>쿠폰번호</th>
				    <th>쿠폰이름</th>
				    <th>쿠폰코드</th>
				    <th>할인가격</th>
				    <th>남은수</th>
				    <th>유효기간</th>
				  </tr>
				  <c:forEach items="${clVoList}" var="clVo">
				  	  <tr>
					  	<td>${clVo.getCouponNo()}</td>
					  	<td>${clVo.getName()}</td>
					    <td>${clVo.getCode()}</td>
					    <td>${clVo.getDiscountPrice()}</td>
					    <td>${clVo.getUsageLimit()}</td>
					    <td>${clVo.getExpiryDate()}</td>
					  </tr>
				  </c:forEach>
				</table>
    		</div>
    	</div>
    	
    	<div id="third">
    		<div id="t-title">
			    <span><span id="b-g">&#10073;</span> 신고 문의현황</span>
			    <a href="#">신고문의 바로가기</a>
    		</div>
    		<div>
    			<table id="userDeclaration" class="userList">
				  <tr>
				  	<th>신고번호</th>
				    <th>신고자</th>
				    <th>신고할회원</th>
				    <th>신고상태</th>
				    <th>신고제목</th>
				    <th>신고일</th>
				  </tr>
				  <c:forEach items="${rlVoList}" var="rlVo">
				  	  <tr>
					  	<td>${rlVo.getReportNo()}</td>
					  	<td>${rlVo.getMemberName()}</td>
					    <td>${rlVo.getTargetMemberNo()}</td>
					    <td>${rlVo.getStatusName()}</td>
					    <td>${rlVo.getTitle()}</td>
					    <td>${rlVo.getCreatedDate()}</td>
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

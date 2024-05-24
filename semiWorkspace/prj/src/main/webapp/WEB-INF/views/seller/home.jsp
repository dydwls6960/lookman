<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman판매자페이지</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
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
						  	<td>5</td>
						  	<td>500</td>
						  	<td>150</td>
						    <td>13</td>
						    <td>500,000</td>
						  </tr>
						</table>
    				</div>
    			</span>
    			<span id="f-c-left" class="f-c-item">
    				누적금액
    				<div>
    					<table id="userCnt">
						  <tr>
						    <th>총매출</th>
						    <th>순이익</th>
						  </tr>
						  <tr>
						    <td>500,000</td>
						    <td>450,000</td>
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
    			<table id="userInquiry" class="userList">
				  <tr>
				  	<th>상품번호</th>
				    <th>상품명</th>
				    <th>상품이미지</th>
				    <th>상품금액</th>
				    <th>등록일</th>
				    <th>수정일</th>
				  </tr>
				  <tr>
				  	<td>3</td>
				    <td>옷</td>
				    <td>[이미지]옷~~~~</td>
				    <td>34,000원</td>
				    <td>24년05월19 13:00</td>
				    <td>없음</td>
				  </tr>
				  <tr>
				  	<td>2</td>
				    <td>바지</td>
				    <td>[이미지]바지~~~~</td>
				    <td>50,000원</td>
				    <td>24년05월19 12:00</td>
				    <td>없음</td>
				  </tr>
				  <tr>
				  	<td>3</td>
				    <td>신발</td>
				    <td>[이미지]신발~~~~</td>
				    <td>24,000원</td>
				    <td>24년05월19 11:00</td>
				    <td>24년05월19 13:00</td>
				  </tr>
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
				    <th>문의내용</th>
				    <th>문의날짜</th>
				    <th>처리여부</th>
				  </tr>
				  <tr>
				  	<td>3</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>집가고싶어</td>
				    <td>24-05-20 17:00</td>
				    <td>N</td>
				  </tr>
				  <tr>
				  	<td>2</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>집가고싶어</td>
				    <td>24-05-20 17:00</td>
				    <td>N</td>
				  </tr>
				  <tr>
				  	<td>1</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>집가고싶어</td>
				    <td>24-05-20 17:00</td>
				    <td>N</td>
				  </tr>
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
				    <th>베송비</th>
				    <th>총금액</th>
				    <th>주문일</th>
				  </tr>
				  <tr>
				  	<td>3</td>
				    <td>dydwls</td>
				    <td>입금전</td>
				    <td>무통장</td>
				    <td>3,000원</td>
				    <td>53,000원</td>
				    <td>24-05-17 17:00</td>
				  </tr>
				  <tr>
				  	<td>2</td>
				    <td>dydwls</td>
				    <td>취소</td>
				    <td>무통장</td>
				    <td>5,000원</td>
				    <td>65,000원</td>
				    <td>24-05-26 16:00</td>
				  </tr>
				  <tr>
				  	<td>1</td>
				    <td>dydwls</td>
				    <td>배송완료</td>
				    <td>포인트</td>
				    <td>무료배송</td>
				    <td>100,000원</td>
				    <td>24-05-15 15:00</td>
				  </tr>
				</table>
    		</div>
    	</div>
    </main>
    <%@ include file="/WEB-INF/views/seller/layout/footer.jsp" %>
  </div>
</body>
</html>

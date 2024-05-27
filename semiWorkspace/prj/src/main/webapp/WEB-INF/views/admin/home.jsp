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
						    <th>전체회원수</th>
						  </tr>
						  <tr>
						    <td>0</td>
						    <td>0</td>
						    <td>0</td>
						    <td>0</td>
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
						    <td>0</td>
						    <td>0</td>
						  </tr>
						</table>
    				</div>
    			</span>
    		</div>
    	</div>
    	
    	<div id="second">
    		<div id="s-title">
			    <span><span id="b-g">&#10073;</span> 고객 문의현황</span>
			    <a href="#">고객문의 바로가기</a>
    		</div>
    		<div>
    			<table id="userInquiry" class="userList">
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
    	
    	<div id="third">
    		<div id="t-title">
			    <span><span id="b-g">&#10073;</span> 신고 문의현황</span>
			    <a href="#">신고문의 바로가기</a>
    		</div>
    		<div>
    			<table id="userDeclaration" class="userList">
				  <tr>
				  	<th>신고번호</th>
				    <th>아이디</th>
				    <th>닉네임</th>
				    <th>신고자아이디</th>
				    <th>신고내용</th>
				    <th>신고날짜</th>
				    <th>처리여부</th>
				  </tr>
				  <tr>
				  	<td>3</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>singo</td>
				    <td>물건안팜</td>
				    <td>24-05-20 17:00</td>
				    <td>N</td>
				  </tr>
				  <tr>
				  	<td>2</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>singo</td>
				    <td>물건안팜</td>
				    <td>24-05-20 17:00</td>
				    <td>N</td>
				  </tr>
				  <tr>
				  	<td>1</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>singo</td>
				    <td>물건안팜</td>
				    <td>24-05-20 17:00</td>
				    <td>N</td>
				  </tr>
				</table>
    		</div>
    	</div>
    </main>
    <%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>
  </div>
</body>
</html>

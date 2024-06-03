<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman관리자페이지</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
</head>

<body>
  <%@ include file="/WEB-INF/views/admin/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
    <main>
    	<div id="addr">관리자홈 > 회원관리 > 주문기록</div>
    	<br>
    	<%@ include file="/WEB-INF/views/admin/layout/memberManagemnet/info.jsp" %>
    	<div id="info">
    		<div id="info-title">
		    	<span><span id="b-g">&#10073;</span> 주문정보</span>
    		</div>
    		<div id="info-content">
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

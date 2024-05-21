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
    	<div id="addr">관리자홈 > 회원관리 > 포인트관리</div>
    	<br>
    	<form action="" method="post">
	    	<div id="search">
	    		<div id="info-title">
			    	<span><span id="b-g">&#10073;</span> 회원정보</span>
	    		</div>
	    		<div id="info-content">
	    			<table id="user-search" class="userList">
	    				<tr>
	    					<th>
	    						회원통계
	    					</th>
	    					<td style="text-align: left">
	    						회원수 : 3
	    					</td>
	    				</tr>
	    				<tr>
	    					<th>
	    						검색
	    					</th>
	    					<td style="text-align: left">
	    						<select name="search_option">
							        <option value="id">아이디</option>
							        <option value="nickname">닉네임</option>
							    </select>
							    <input type="text">
	    					</td>
	    				</tr>
	
	    				<tr>
	    					<th>
	    						멤버쉽 유무
	    					</th>
	    					<td class="membership-checkboxes" style="text-align: left">
						        <label><input type="checkbox" name="membership" value="yes"> Yes</label>
						        <label><input type="checkbox" name="membership" value="no"> No</label>
						    </td>
	    				</tr>
	    				
	    				
	    			</table>
	    			<div id="search-div">
		    			<input type="submit" value="검색">
		    			<input type="reset" value="초기화">
	    			</div>
	    		</div>
	    	</div>
	    	<div>
	    		<div id="point-title">
			    	<span><span id="b-g">&#10073;</span> 포인트지급</span>
	    		</div>
	    		<div id="point-content">
	    			<table id="point" class="userList">
	    				<tr>
	    					<th>포인트 내용</th>
	    					<td><input type="text"></td>
	    				</tr>
	    				<tr>
	    					<th>포인트</th>
	    					<td><input type="text"></td>
	    				</tr>
	    			</table>
	    		</div>
	    		
	    	</div>
    	</form>
    	
    	
    </main>
    <%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>
  </div>
</body>
</html>

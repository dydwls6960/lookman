<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookman관리자페이지</title>
<%@ include file="/WEB-INF/views/admin-seller/layout/home/util.jsp" %>
<link rel="stylesheet" href="/app/resources/css/admin/search.css">
<script def src="/app/resources/js/admin/search.js"></script>
</head>

<body>
  <%@ include file="/WEB-INF/views/admin/layout/nav.jsp" %>
  <div id="container">
  	<%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>
    <main>
    	<div id="addr">관리자홈 > 회원관리 > 회원검색</div>
    	<br>
    	<form action="" method="post">
	    	<div id="search">
	    		<div id="search-title">
			    	<span><span id="b-g">&#10073;</span> 유저검색</span>
	    		</div>
	    		<div id="search-content">
	    			<table id="user-search" class="userList">
	    				<tr>
	    					<th>
	    						유저
	    					</th>
	    					<td style="text-align: left">
	    						<select name="search_option">
							        <option value="member">사용자</option>
							        <option value="seller">판매자</option>
							    </select>
							    <input type="text">
	    					</td>
	    				</tr>
	    				<tr>
	    					<th>
	    						검색어
	    					</th>
	    					<td style="text-align: left">
	    						<select name="search_option">
							        <option value="id">아이디</option>
							        <option value="nickname">닉네임</option>
							        <option value="phone">전화번호</option>
							    </select>
							    <input type="text">
	    					</td>
	    				</tr>
	
	    				<tr>
	    					<th>
	    						기간검색
	    					</th>
	    					<td class="search-field" style="text-align: left">
						        <input type="text" placeholder="시작일" style="width: 100px"> ~
						        <input type="text" placeholder="종료일" style="width: 100px">
						        <select name="period">
						            <option value="today">오늘</option>
						            <option value="yesterday">어제</option>
						            <option value="week">일주일</option>
						            <option value="month">한 달</option>
						            <option value="all">전체</option>
						        </select>
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
    	</form>
    	<br>
    	<hr/>
    	<br>
    	<div id="search-result">
    		<div>
		    	<span><span id="b-g">&#10073;</span> 회원목록</span>
		    	<span id="search-result-total">총회원수 : 3</span>
    		</div>
    		<div >
    			<table id="userInfo" class="userList">
				  <tr>
				    <th>번호</th>
				    <th>아이디</th>
				    <th>닉네임</th>
				    <th>멤버쉽 유무</th>
				    <th>가입날짜</th>
				    <th>재제여부</th>
				    <th>탈퇴여부</th>
				    <th>탈퇴날짜</th>
				  </tr>
				  <tr data-href="/app/admin/home/memberManagement/info">
				    <td>3</td>
				    <td>dldydwls</td>
				    <td>이이용진</td>
				    <td>N</td>
				    <td>24년5월21일 15시44분</td>
				    <td>N</td>
				    <td>N</td>
				    <td>.</td>
				  </tr>
				  <tr data-href="/app/admin/home/memberManagement/info">
				    <td>2</td>
				    <td>wlsdyd</td>
				    <td>이진용</td>
				    <td>Y</td>
				    <td>24년5월21일 15시44분</td>
				    <td>N</td>
				    <td>N</td>
				    <td>.</td>
				  </tr>
				  <tr data-href="/app/admin/home/memberManagement/info">
				    <td>1</td>
				    <td>dydwls</td>
				    <td>이용진</td>
				    <td>N</td>
				    <td>24년5월21일 15시44분</td>
				    <td>N</td>
				    <td>Y</td>
				    <td>24년5월21일 15시44분</td>
				  </tr>
				</table>
    		</div>
    	</div>
    </main>
    <%@ include file="/WEB-INF/views/admin/layout/footer.jsp" %>
  </div>
</body>
</html>
